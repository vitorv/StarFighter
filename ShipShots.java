import javax.swing.JButton;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class ShipShots
{
   private ArrayList<Shot> shipShots;
   private Image shotImage;
   private int shotSpeed;
   private int shotWidth, shotHeight;
   
   public ShipShots(int shipShotSpeed)
   {
      shipShots = new ArrayList<Shot>();
      try{shotImage = ImageIO.read(new File("art/shipShot.jpg"));}catch(Exception e){}
      shotSpeed = shipShotSpeed;
   }
   
   public void add(Shot shipShot)
   {
      shipShots.add(shipShot);
   }
    
   public void remove(Shot shipShot)
   {
      shipShots.remove(shipShot);
   }
    
   public void remove(int shipShot)
   {
      shipShots.remove(shipShot);
   }
   
   public int size()
   {
   		return shipShots.size();
   }
    
   public void draw(Graphics g)
   {
      for(Shot shipShot : shipShots)
         shipShot.draw(g);
   }
   
   public ArrayList<Shot> getShipShots()
   {
      return shipShots;
   }
   
   public Image getShipShotImage()
   {
      return shotImage;
   }
   
   public void setShipShotImage(Image I)
   {
      shotImage = I;
   }
   
   /*public void setShotSize(int w, int h)
   {
   		
   }*/
   
   public void setShotSpeed(int speed)
   {
   		shotSpeed = speed;
   }
   
   public int getShipShotSpeed()
   {
      return shotSpeed;
   }
    
   public void moveUp()
   {
      for(Shot shipShot : shipShots)
         shipShot.moveUp();
      removeFromTopOfScreen();
   }
   
   public void removeFromTopOfScreen()
   {
      for(int i=0; i<shipShots.size(); i++)
         if(shipShots.get(i).getY() < -40)
            shipShots.remove(i);
   }
    
   public String toString()
   {
      return "";
   }
}
