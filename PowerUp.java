import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class PowerUp extends SpaceCraft
{
   private Image image;
   private int speed;
   private int height;
   private int width;

   public PowerUp()
   {
      this(0,0,0);
   }

   public PowerUp(int x, int y)
   {
      this(x,y,3);
   }

   public PowerUp(int x, int y, int s)
   {
      //set stuff
      super(x,y);
      setSpeed(s);
   }

   public PowerUp(int x, int y, int w, int h, int s)
   {
      //set stuff
      super(x,y);
      setSpeed(s);
      setWidth(w);
      setHeight(h);
   }

   public void setImage(Image I)
   {
      image = I;
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

   public void draw( Graphics window )
   {
      window.drawImage(image,getX(),getY(),width,height,null);
   }
   
   public boolean collidesWithShip(Ship s)
   {
      Rectangle power = new Rectangle(getX(),getY(),getWidth(),getHeight());
      Rectangle ship = new Rectangle(s.getX(),s.getY(),s.getWidth(),getHeight());
      if(power.intersects(ship))
         return true;
      return false;
   }
   
   public void beginAction(Ship s, ShipShots ss, Ships ships, PowerUpTimer timer)
   {
   }
   
   public void endAction()
   {
   }

   public String toString()
   {
      return "";
   }
   
   
}
