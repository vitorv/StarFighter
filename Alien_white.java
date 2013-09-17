/*import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.awt.Rectangle;

public class Alien extends SpaceCraft
{
   	private Image image, first, second, shotImage;
	private int speed, moveCounter, rand, boundary;
    private int	width = 55;
    private int	height = 40;

   	public Alien()
   	{
    	   this(0,0,0);
   	}
   	
   	public Alien(int x, int y, int s)
   	{
      	//set stuff
      	super(x,y);
      	setSpeed(s);
      	moveCounter = 0;
      	
      	try
      	{
         	first = ImageIO.read(new File("whiteAlien1.png")); 
         	second = ImageIO.read(new File("whiteAlien2.png"));
         	image = first;
      	}
      	catch(Exception e)
      	{
         	//feel free to do something here
      	}  
   	}

   	public Alien(int x, int y, int screenWidth, int s)
   	{
      	//set stuff
      	super(x,y);
      	setSpeed(s);
      	moveCounter = 0;
       	boundary = screenWidth;
      	
      	try
      	{
         	first = ImageIO.read(new File("whiteAlien1.png")); 
         	second = ImageIO.read(new File("whiteAlien2.png"));
         	image = first;
      	}
      	catch(Exception e)
      	{
         	//feel free to do something here
      	}  
   	}

   	public void setImage(Image I)
   	{
      	image = I;
   	}

   	public void setSpeed(int s)
   	{
      	speed = s;
   	}

   	public int getSpeed()
   	{
      	return speed;
   	}
   
   	public int getWidth()
   	{
   		return width;
   	}
   
   	public int getHeight()
   	{
   		return height;
   	}

   	public void moveUp()
   	{
    	setY(getY()-getSpeed());
   	}

   	public void moveDown()
   	{
    	setY(getY()+21);
   	}

   	public void moveLeft()
   	{
    	setX(getX()-getSpeed());
   	}

   	public void moveRight()
   	{
    	setX(getX()+getSpeed());
   	}

   	public void draw( Graphics window )
   	{
    	window.drawImage(image,getX(),getY(),width,height,null);
   	}
   
   	public void changePosition()
   	{
    	moveCounter++;
       	if(moveCounter % 40 == 0)
          	if(moveCounter == 40)
            	setImage(first);
            if(moveCounter == 80)
            {
            	moveCounter = 0;
            	setImage(second);
            }
   	}
   	
   	public void move()
   	{
    	changePosition();
            
       	if(getY()%2==0)
        	moveRight(); 
                  
      	if(getY()%2==1)
        	moveLeft(); 
                  
       	if((getX()<=0 || getX()+65>boundary))
            moveDown(); 
   	}
   
   	public boolean shootChance(int probability) //probability = 1/(alienList size +10)
   	{
   		rand = (int)(Math.random()*(probability+10));
   		if(rand == 1)
   		   return true;
   		return false;
   	}
   	
   	public void shoot(AlienShots alShots)
   	{
   		alShots.add(new Shot(getX(),getY(),14,31,alShots.getAlienShotSpeed(),alShots.getAlienShotImage()));
   	}

   	public String toString()
   	{
    	return "";
   	}
}*/
