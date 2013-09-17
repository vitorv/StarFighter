import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class Buttons
{
   private Image image, first, second;
   private int moveCounter, xPos, yPos, actionSpeed;
   private int height;
   private int width;

   public Buttons(int x, int y)
   {
      setPos(x,y);
      moveCounter = 0;
      actionSpeed = 20;
   }
   
   public void setImage(Image img)
   {
   		image = img;
   }
   
   public void setImages(Image firstImage, Image secondImage)
   {
   	  first = firstImage;
   	  second = secondImage;
   }

   public void setPos( int x, int y)
   {
      xPos = x;
      yPos = y;
   }

   public void setX(int x)
   {
      xPos = x;
   }

   public void setY(int y)
   {
      yPos = y;
   }
   
   public void setWidth(int w)
   {
   	  width = w;
   }
   
   public void setHeight(int h)
   {
   	  height = h;
   }

   public int getX()
   {
      return xPos;
   }

   public int getY()
   {
      return yPos;
   }
   
   public int getHeight()
   {
      return height;
   }
   
   public int getWidth()
   {
      return width;
   }
   
   public void buttonAction()
   {
    	moveCounter++;
         if(moveCounter % actionSpeed == 0)
            if(moveCounter == actionSpeed)
            	setImage(second);
            if(moveCounter == actionSpeed*2)
            {
            	moveCounter = 0;
            	setImage(first);
            } 
   }
   
   public boolean collidesWith(Shot s)
   {
   		Rectangle shot = new Rectangle(s.getX(),s.getY(),s.getWidth(),s.getHeight());
   		Rectangle button = new Rectangle(getX(),getY(),getWidth(),getHeight());
   		if(button.intersects(shot))
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
