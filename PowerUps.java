import javax.swing.JButton;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class PowerUps
{
   private ArrayList<PowerUp> powerUps;
   private int powerUpSpeed;
   private Dimension dim;
   
   public PowerUps(int powerUpSpeed)
   {
      powerUps = new ArrayList<PowerUp>();
      this.powerUpSpeed = powerUpSpeed;
      dim = Toolkit.getDefaultToolkit().getScreenSize();
   }
   
   public void add(PowerUp powerUp)
   {
      powerUps.add(powerUp);
   }
    
   public void remove(PowerUp powerUp)
   {
      powerUps.remove(powerUp);
   }
    
   public void remove(int powerUp)
   {
      powerUps.remove(powerUp);
   }
   
   public int size()
   {
   		return powerUps.size();
   }
    
   public void draw(Graphics g)
   {
      for(PowerUp powerUp : powerUps)
         powerUp.draw(g);
   }
   
   public ArrayList<PowerUp> getPowerUps()
   {
      return powerUps;
   }
    
   public void moveDown()
   {
    	for(PowerUp powerUp : powerUps)
    		powerUp.moveDown();
    	removeFromBottomOfScreen();
   }
   
   public void removeFromBottomOfScreen()
   {
      for(int i=0; i<powerUps.size(); i++)
         if(powerUps.get(i).getY() > dim.height)
            powerUps.remove(i);
   }
    
   public String toString()
   {
      return "";
   }
}