import javax.swing.JButton;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class Shot extends SpaceCraft
{
   	private Image image;
   	private int speed;
   	private int width = 10;
   	private int height = 30;

   	public Shot()
   	{
   		this(0,0,0);
   	}

   	public Shot(int x, int y, int s)
   	{
      	//set stuff
      	super(x,y);
      	setSpeed(s);
     	 
      	try
      	{
         	image = ImageIO.read(new File("shipShot.png")); 
      	}
      	catch(Exception e)
      	{
         	//feel free to do something here
      	}     
   	}

   	public Shot(int x, int y, int s, Image img)
   	{
      	//set stuff
      	super(x,y);
      	setSpeed(s);
      	
      	try
      	{
         	image = img; 
      	}
      	catch(Exception e)
      	{
         	//feel free to do something here
      	}     
   	}

   	public Shot(int x, int y, int shotWidth, int shotHeight, int s, Image img)
   	{
      	//set stuff
      	super(x,y);
      	setSpeed(s);
      	width = shotWidth;
      	height = shotHeight;
      	
      	try
      	{
         	image = img; 
      	}
      	catch(Exception e)
      	{
         	//feel free to do something here
      	}     
   	}

   	public void setSpeed(int s)
   	{
      	speed = s;
   	}

   	public void setWidth(int w)
   	{
      	width = w;
   	}

   	public void setHeight(int h)
   	{
      	height = h;
   	}

   	public void setImage(Image I)
   	{
      	image = I;
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
      	setY(getY()+getSpeed());
   	}
	
   	public void moveLeft()
   	{
      	setX(getX()-getSpeed());
   	}

   	public void moveRight()
   	{
      	setX(getX()+getSpeed());
   	}
   
   	public boolean collidesWithShot(Shot other)
   	{
   		Rectangle thisShot = new Rectangle(this.getX(), this.getY(), this.width, this.height);
   		Rectangle otherShot = new Rectangle(other.getX(), other.getY(), other.getWidth(), other.getHeight());
   		if(thisShot.intersects(otherShot))
   			return true;
   		return false;
   	}
   
   	public boolean collidesWithAlien(Alien al)
   	{
   		Rectangle thisShot = new Rectangle(this.getX(), this.getY(), this.width, this.height);
   		Rectangle alien = new Rectangle(al.getX(), al.getY(), al.getWidth(), al.getHeight());
   		if(thisShot.intersects(alien))
   			return true;
   		return false;
   	}
   
   	public boolean collidesWithShip(Ship s)
   	{
   		Rectangle thisShot = new Rectangle(this.getX(), this.getY(), this.width, this.height);
   		Rectangle shipPart1 = new Rectangle(s.getX()+12, s.getY()+40, s.getWidth()-24, s.getHeight()-40);
   		Rectangle shipPart2 = new Rectangle(s.getX()+24, s.getY()+10, s.getWidth()-48, s.getHeight()-40);
   		if(thisShot.intersects(shipPart1) || thisShot.intersects(shipPart2))
   			return true;
   		return false;
   	}
   
   	public void draw( Graphics window )
   	{
      	window.drawImage(image,getX(),getY(),width,height,null);
   	}

   	public String toString()
   	{
      	return "";
   	}
   
}
