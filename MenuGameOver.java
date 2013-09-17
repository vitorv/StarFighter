import javax.swing.JButton;
import javax.swing.JFrame;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;
import java.awt.Graphics;

public class MenuGameOver extends Canvas implements KeyListener, Runnable
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
   	private Buttons_Restart restartButton;
   	private Buttons_MainMenu mainMenuButton;
	private StarFighter starFighter;
	private Points score;
	
	public MenuGameOver(StarFighter sf, Points pnts)
	{
      	setBackground(Color.BLACK);
      	
      	dim = Toolkit.getDefaultToolkit().getScreenSize();
      	
      	starFighter = sf;
      	
    	keys = new boolean[6];
    	buttonSelection = new boolean[2];
    	score = pnts;
    	restartButton = new Buttons_Restart((int)(dim.width/2)-500,(int)(dim.height/1.75));
    	mainMenuButton = new Buttons_MainMenu((int)(dim.width/2)+100,(int)(dim.height/1.75));
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
        	restartButton.draw(bufferGraphics);
        	mainMenuButton.draw(bufferGraphics);
        	bufferGraphics.drawString(score.getStringScore(),100,100);
     	 
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
         	if(select < 1)
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
   			restartButton.buttonAction();
   			ship.setPos(restartButton.getX()+125,restartButton.getY()+300);
   		}
   		if(buttonSelection[1] == true)
   		{
   			mainMenuButton.buttonAction();
   			ship.setPos(mainMenuButton.getX()+125,mainMenuButton.getY()+300);
   		}
   		if(fire == true && shipShots.getShipShots().size() <= 1)
   		{
   			ship.shoot(shipShots);
   		}
   		shipShots.moveUp();
   		
   		if(shipShots.size() > 0 && restartButton.collidesWith(shipShots.getShipShots().get(0)))
   		{
   			starFighter.runTheGame();
   			starFighter.closeGameOverMenu();
   			Thread.currentThread().stop();
   		}
   		if(shipShots.size() > 0 && mainMenuButton.collidesWith(shipShots.getShipShots().get(0)))
   		{
   			starFighter.runMainMenu();
   			starFighter.closeGameOverMenu();
   			Thread.currentThread().stop();
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