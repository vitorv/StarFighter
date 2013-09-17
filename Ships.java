import java.lang.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Ships
{
   private ArrayList<Ship> shipList = new ArrayList<Ship>();
   private int shotTimer, shotDelay;
   private int width;
   
   public Ships(int screenWidth, int shipShotSpeed, int shipShotDelay)
   {
      width = screenWidth;
      shotTimer = 0;
      shotDelay = shipShotDelay;
   }
   
   public void add(Ship s)
   {
      shipList.add(s);
   }
   
   public void remove(Ship s)
   {
      shipList.remove(s);
   }
   
   public void remove(int s)
   {
      shipList.remove(s);
   }
   
   public ArrayList<Ship> getShips()
   {
      return shipList;
   }
   
   public void setShotDelay(int delay)
   {
      shotDelay = delay;
   }
   
   public int getShotDelay()
   {
      return shotDelay;
   }
   
   public void moveLeft()
   {
      for(Ship s : shipList)
         s.moveLeft();
   }
   
   public void moveRight()
   {
      for(Ship s : shipList)
         s.moveRight();
   }
   
   public boolean touchRightOfScreen()
   {
      for(Ship s : shipList)
         if(s.getX()+s.getWidth()>width)
            return true;
      return false;
   }
   
   public boolean touchLeftOfScreen()
   {
      for(Ship s : shipList)
         if(s.getX()<0)
            return true;
      return false;
   }
   
   public void shoot(ShipShots shipShots)
   {
      if(shotTimer>shotDelay)
      {
         shotTimer = 0;
         for(Ship s : shipList)
            s.shoot(shipShots);
      }
   }

   public void draw(Graphics g)
   {
      shotTimer++;
      for(Ship s : shipList)
         if(s != null)
            s.draw(g);
   }

   	public String toString()
   	{
      	return "";
   	}
}