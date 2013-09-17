import javax.swing.JButton;
import javax.swing.JFrame;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class MenuMain extends Canvas implements KeyListener, Runnable
{
	private JFrame frame;
	private int select;
	private boolean[] buttonSelection;
   private boolean[] keys;
   private boolean fire;
   private Graphics bufferGraphics;
   private Image offscreen;
   private Dimension dim;
   private Ship ship;
   private ShipShots shipShots;
   private PlayButton playButton;
	private QuitButton quitButton;
	private OtherOptionsButton moreButton;
	private StarFighter starFighter;
	
	public MenuMain(StarFighter sf)
	{
      	setBackground(Color.BLACK);
      	
      	dim = Toolkit.getDefaultToolkit().getScreenSize();
      	
      	starFighter = sf;
      	
    	   keys = new boolean[6];
    	   buttonSelection = new boolean[3];
    	   playButton = new PlayButton((int)(dim.getWidth()/4-80),(int)(dim.getHeight()/3)-40);
    	   quitButton = new QuitButton((int)(dim.getWidth()/2-80),(int)(dim.getHeight()/3)-40);
    	   moreButton = new OtherOptionsButton((int)(dim.getWidth()/1.33-80),(int)(dim.getHeight()/3)-40);
      	ship = new Ship();
      	shipShots = new ShipShots(10);
      	
      	fire = false;
      	select = 0;
      
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
     	 
        	shipShots.draw(bufferGraphics); 
        	ship.draw(bufferGraphics);
        	playButton.draw(bufferGraphics);
        	quitButton.draw(bufferGraphics);
        	moreButton.draw(bufferGraphics);
     	 
      	window.drawImage(offscreen,0,0,this);
   	}

   	public void keyPressed(KeyEvent e)
   	{
      	if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getKeyCode() == 37)
      	{
         	keys[0] = true;
         	if(select > 0)
         		select--;
      	}
      	if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getKeyCode() == 39)
      	{
         	keys[1] = true;
         	if(select < 2)
         		select++;
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
   		for(int i=0; i<buttonSelection.length; i++)
   		{
   			if(select == i)
   				buttonSelection[i] = true;
   			else
   				buttonSelection[i] = false;
   		}
   		if(buttonSelection[0] == true)
   		{
   			playButton.buttonAction();
   			ship.setPos(playButton.getX()+40,playButton.getY()+480);
   		}
   		if(buttonSelection[1] == true)
   		{
   			quitButton.buttonAction();
   			ship.setPos(quitButton.getX()+40,quitButton.getY()+480);
   		}
   		if(buttonSelection[2] == true)
   		{
   			moreButton.buttonAction();
   			ship.setPos(moreButton.getX()+40,moreButton.getY()+480);
   		}
   		if(fire == true && shipShots.getShipShots().size() <= 1)
   		{
   			ship.shoot(shipShots);
   		}
   		shipShots.moveUp();
   		
   		if(shipShots.size() > 0 && playButton.collidesWith(shipShots.getShipShots().get(0)))
   		{
   			starFighter.runTheGame();
   			starFighter.closeMainMenu();
   			Thread.currentThread().stop();
   		}
   		if(shipShots.size() > 0 && quitButton.collidesWith(shipShots.getShipShots().get(0)))
   		{
   			System.exit(0);
   		}
   		if(shipShots.size() > 0 && moreButton.collidesWith(shipShots.getShipShots().get(0)))
   		{
   			
   		}
   	}
   
   	public void run()
   	{
     	try{
        	while(true)
        	{
           		Thread.currentThread().sleep(10);
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