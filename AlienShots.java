import javax.swing.JButton;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class AlienShots
{
   private ArrayList<Shot> alienShots;
   private Image shotImage;
   private int shotSpeed, shotWidth, shotHeight;
   private Dimension dim;
   
   public AlienShots(int alienShotSpeed)
   {
   	  dim = Toolkit.getDefaultToolkit().getScreenSize();
      alienShots = new ArrayList<Shot>();
      try{shotImage = ImageIO.read(new File("art/whiteAlienShot.png"));}catch(Exception e){}
      shotSpeed = alienShotSpeed;
   }
   
   public void add(Shot alShot)
   {
    	alienShots.add(alShot);
   }
    
   public void remove(Shot alShot)
   {
    	alienShots.remove(alShot);
   }
    
   public void remove(int alShot)
   {
    	alienShots.remove(alShot);
   }
   
   public int size()
   {
   	return alienShots.size();
   }
    
   public void draw(Graphics g)
   {
    	for(Shot alShot : alienShots)
    		alShot.draw(g);
   }
   
   public ArrayList<Shot> getAlienShots()
   {
      return alienShots;
   }
   
   public Image getAlienShotImage()
   {
      return shotImage;
   }
   
   public int getAlienShotSpeed()
   {
      return shotSpeed;
   }
    
   public void moveDown()
   {
    	for(Shot alShot : alienShots)
    		alShot.moveDown();
    	removeFromBottomOfScreen();
   }
   
   public void removeFromBottomOfScreen()
   {
      for(int i=0; i<alienShots.size(); i++)
         if(alienShots.get(i).getY() > dim.height)
            alienShots.remove(i);
   }
    
   public String toString()
   {
    	return "";
   }
}
