import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class Ship extends SpaceCraft
{
   private Image image;
   private int speed;
   private int height = 80;
   private int width = 80;
   private boolean multiShot = false;
   private boolean fastShot = false;
   private boolean laserShot = false;

   public Ship()
   {
      this(0,0,0);
   }

   public Ship(int x, int y)
   {
      this(x,y,0);
   }

   public Ship(int x, int y, int s)
   {
      //set stuff
      super(x,y);
      setSpeed(s);
      
      try
      {
         image = ImageIO.read(new File("art/shipBlue2.png")); 
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

   public Image getImage()
   {
      return image;
   }

   public void setSpeed(int s)
   {
      speed = s;
   }
   
   public int getHeight()
   {
      return height;
   }
   
   public int getWidth()
   {
      return width;
   }

   public int getSpeed()
   {
      return speed;
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
   
   public void activateMultiShot()
   {
      multiShot = true;
   }
   
   public void activateFastShot()
   {
      fastShot = true;
   }
   
   public void activateLazeShot()
   {
      laserShot = true;
   }
   
   public boolean isLaserActive()
   {
   	  return laserShot;
   }
   
   public void endMultiShot()
   {
      multiShot = false;
   }
   
   public void endFastShot()
   {
      fastShot = false;
   }
   
   public void endLaserShot()
   {
      laserShot = false;
   }
   
   public void shoot(ShipShots shipShots)
   {
      if(multiShot == true)
      {
         shipShots.add(new Shot(getX()+(getWidth()/2)-5,getY(),shipShots.getShipShotSpeed(), shipShots.getShipShotImage()));
         shipShots.add(new Shot(getX()+(getWidth()/2)-25,getY()+20,shipShots.getShipShotSpeed(), shipShots.getShipShotImage()));
         shipShots.add(new Shot(getX()+(getWidth()/2)+15,getY()+20,shipShots.getShipShotSpeed(), shipShots.getShipShotImage()));
      }
      else if(laserShot == true)
      {
         shipShots.add(new Shot_Laser(getX(),0));
      }
      else{
         shipShots.add(new Shot(getX()+(getWidth()/2)-5,getY(),shipShots.getShipShotSpeed(), shipShots.getShipShotImage()));
      }
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
