import javax.swing.JButton;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
   private boolean[] keys;
   private boolean playing;
   private boolean fire;
   private Graphics bufferGraphics;
   private Image offscreen;
   private Dimension dim;
   private int gameSpeed;
   private int alienSpeed;
   private int alienShotSpeed;
   private int alienRow;
   private int alienCol;
   private int shipShotSpeed;
   private int shipShotDelay;
   private int shipSpeed;
   private int powerUpSpeed;
   private int powerUp;
   private AlienBlock alienBlock;
   private AlienShots alienShots;
   private Ships ships;
   private ShipShots shipShots;
   private StarFighter starFighter;
   private PowerUps powerUps;
   private PowerUpTimer powerUpTimer;
   private Points score;
       
   public OuterSpace (StarFighter sf)
   {
      playing = true;
      fire = false;
      
      starFighter = sf;
      dim = Toolkit.getDefaultToolkit().getScreenSize();
      gameSpeed = 10;
      alienRow = 6;
      alienCol = 10;
      alienSpeed = 3;
      alienShotSpeed = 4;
      shipShotSpeed = 10;
      shipShotDelay = 20;
      shipSpeed = 10;
      powerUpSpeed = 3;
      
      keys = new boolean[6];

      setBackground(Color.BLACK);
      
      score = new Points();
      alienBlock  = new AlienBlock((int)dim.getWidth(),(int)dim.getHeight(),alienRow,alienCol,alienSpeed);
      alienShots = new AlienShots(alienShotSpeed);
      ships = new Ships((int)dim.getWidth(), shipShotSpeed, shipShotDelay);
      shipShots = new ShipShots(shipShotSpeed);
      powerUps = new PowerUps(powerUpSpeed);
      powerUpTimer = new PowerUpTimer();
     
      ships.add(new Ship((int)dim.getWidth()/2,(int)dim.getHeight()-120,shipSpeed));
      
      new Thread(this).start();
      this.addKeyListener(this);

      setVisible(true);
   }
   
   public void init()
   {
      dim = getSize();
      setBackground(Color.black);
      offscreen = createImage(dim.width,dim.height);
      bufferGraphics = offscreen.getGraphics();
   }
   
   public void update(Graphics g)
   {
       paint(g);
   }
    
   public void paint( Graphics window )
   {
      init();
      bufferGraphics.clearRect(0,0,dim.width,dim.height);
      
      if(keys[0] == true && !ships.touchLeftOfScreen())
      {
         ships.moveLeft();
      }
      if(keys[1] == true && !ships.touchRightOfScreen())
      {
         ships.moveRight();
      }
      
      powerUps.draw(bufferGraphics);
      alienShots.draw(bufferGraphics);
      alienBlock.draw(bufferGraphics);
      shipShots.draw(bufferGraphics);
      ships.draw(bufferGraphics);
      
      window.drawImage(offscreen,0,0,this);
   }

   public void keyPressed(KeyEvent e)
   {
      if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getKeyCode() == 37)
      {
         keys[0] = true;
      }
      if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getKeyCode() == 39)
      {
         keys[1] = true;
      }
      if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getKeyCode() == 38)
      {
         keys[2] = true;
      }
      if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getKeyCode() == 40)
      {
         keys[3] = true;
      }
      if (e.getKeyChar() == ' ')
      {
      	 fire = true;
      }
      if (e.getKeyCode() == 27)
      { 
         System.exit(0); 
      }
      
      repaint();
   }

   public void keyReleased(KeyEvent e)
   {
      if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getKeyCode() == 37)
      {
         keys[0] = false;
      }
      if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getKeyCode() == 39)
      {
         keys[1] = false;
      }
      if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getKeyCode() == 38)
      {
         keys[2] = false;
      }
      if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getKeyCode() == 40)
      {
      	 keys[3] = false;
      }
      if (e.getKeyChar() == ' ')
      {
      	 fire = false;
      }
   }

   public void keyTyped(KeyEvent e)
   {/*no code needed here*/}
   
   public void action()
   {
      if(fire == true)
         ships.shoot(shipShots);
         
      alienBlock.shoot(alienShots);
      
      alienBlock.move();
      
      shipShots.moveUp();
      
      alienShots.moveDown();
      
      powerUps.moveDown();
      
      try{
      //collisions-------------------------------------------------------------------
      //----------ship shot > alien----------
      for(int i=0; i<shipShots.getShipShots().size(); i++)
         for(int j=0; j<alienBlock.getAlienList().size(); j++)
      		try{
               if(shipShots.getShipShots().get(i).collidesWithAlien(alienBlock.getAlienList().get(j)))
	      		{
                  	int rand = (int)(Math.random()*40);
                  	if(rand == 0 || rand == 1)
                  		powerUps.add(new PowerUp_MultiShot(alienBlock.getAlienList().get(j).getX()+(alienBlock.getAlienList().get(j).getWidth()/2), alienBlock.getAlienList().get(j).getY()));
                    if(rand == 2 || rand == 3)
                        powerUps.add(new PowerUp_FastShot(alienBlock.getAlienList().get(j).getX()+(alienBlock.getAlienList().get(j).getWidth()/2), alienBlock.getAlienList().get(j).getY()));
                    if(rand == 4)
                    	powerUps.add(new PowerUp_Laser(alienBlock.getAlienList().get(j).getX()+(alienBlock.getAlienList().get(j).getWidth()/2), alienBlock.getAlienList().get(j).getY()));
                  	alienBlock.remove(j);
                  	if(!ships.getShips().get(0).isLaserActive())
	      			   shipShots.remove(i);
	      			score.add(50);
	      		}
      	  	   }catch(Exception ex){}
      	  	
      //----------ship shot > alien shot----------	  	
      for(int i=0; i<shipShots.getShipShots().size(); i++)
      	for(int j=0; j<alienShots.getAlienShots().size(); j++)
      		try{
	      	  	if(shipShots.getShipShots().get(i).collidesWithShot(alienShots.getAlienShots().get(j)))
	      		{
	      			shipShots.remove(i);
	      			alienShots.remove(j);
	      		}
            }catch(Exception ex){}
            
      //----------alien shot > ship----------      
      for(int i=0; i<alienShots.getAlienShots().size(); i++)
         for(int j=0; j<ships.getShips().size(); j++)
            try{
               if(alienShots.getAlienShots().get(i).collidesWithShip(ships.getShips().get(j)))
               {
                  alienShots.remove(i);
                  ships.remove(j);
                  starFighter.runGameOverMenu(score);
                  starFighter.closeTheGame();
   				  Thread.currentThread().stop();
               }
            }catch(Exception ex){}
            
      //----------power up > ship----------      
      for(int i=0; i<powerUps.getPowerUps().size(); i++)
         for(int j=0; j<ships.getShips().size(); j++)
            try{
               if(powerUps.getPowerUps().get(i).collidesWithShip(ships.getShips().get(j)))
               {
               	  if(powerUpTimer.getTimer() > 0)
               	  {
               	  	powerUpTimer.endTimer();
		            powerUps.getPowerUps().get(powerUp).endAction();
		   		    powerUps.remove(powerUp);
               	  }
                  powerUps.getPowerUps().get(i).beginAction(ships.getShips().get(j), shipShots, ships, powerUpTimer);
                  powerUpTimer.beginTimer();
                  powerUp = i;
                  powerUps.getPowerUps().get(i).setPos(10,(int)dim.height-50);
               }
            }catch(Exception ex){}
      //----------------------------------------------------------------------------
   		if(alienBlock.getAlienList().size() == 0)
   		{
   			starFighter.runGameOverMenu(score);
   			starFighter.closeTheGame();
   			Thread.currentThread().stop();
   		}
   		
   		if(powerUpTimer.isOver())
   		{
   			powerUpTimer.endTimer();
            powerUps.getPowerUps().get(powerUp).endAction();
   		    powerUps.remove(powerUp);
   		}
   		
   		if(powerUpTimer.isPowerUpOn())
   		{
   			powerUpTimer.timerRun();
   		}
      }catch(Exception e){}
   }
   
   public void run()
   {
     try{
        while(playing)
        {
           Thread.currentThread().sleep(gameSpeed);
           action();
           repaint();
        }
     }catch(Exception e){System.out.println("error :: run() \n"); e.printStackTrace();}
      
   }

   	public String toString()
   	{
      	return "";
   	}
}