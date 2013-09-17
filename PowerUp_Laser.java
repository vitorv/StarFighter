import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class PowerUp_Laser extends PowerUp
{
   private Image image, first, second, third, fourth;
   private int actionTimer, rand, oldDelay;
   private Ship s;
   private ShipShots ss;
   private Ships ships;
   private PowerUpTimer powerUpTimer;
   
   public PowerUp_Laser(int x, int y)
   {
      super(x,y,40,40,3);
      actionTimer = 0;
      
      try
      {
         first = ImageIO.read(new File("art/powerUp_laser1.png"));
         second = ImageIO.read(new File("art/powerUp_laser2.png"));
         third = ImageIO.read(new File("art/powerUp_laser3.png"));
         fourth = ImageIO.read(new File("art/powerUp_laser4.png"));
         image = first;
      }
      catch(Exception e){}
   }
   
   public void moveDown()
   {
   		setY(getY()+getSpeed());
   		moveAction();
   }
   
   public void beginAction(Ship s, ShipShots ss, Ships ships, PowerUpTimer timer)
   {
      this.s = s;
      this.ss = ss;
      this.ships = ships;
      powerUpTimer = timer;
      try{s.setImage(ImageIO.read(new File("art/shipTeal2.png")));}catch(Exception e){}
      oldDelay = ships.getShotDelay();
      setSpeed(0);
      powerUpTimer.setPowerUpTime(50);
      ships.setShotDelay(0);
      s.activateLazeShot();
   }
   
   public void endAction()
   {
      try{s.setImage(ImageIO.read(new File("art/shipBlue2.png")));}catch(Exception e){}
      ships.setShotDelay(oldDelay);
      s.endLaserShot();
   }
   
   public void moveAction()
   {
      actionTimer++;
         if(actionTimer % 5 == 0)
         {
            if(actionTimer == 5)
               setImage(second);
            if(actionTimer == 10)
               setImage(third);
            if(actionTimer == 15)
               setImage(fourth);
            if(actionTimer == 20)
               setImage(third);
            if(actionTimer == 25)
               setImage(second);
            if(actionTimer == 30)
            {
               actionTimer = 0;
               setImage(first);
            } 
         }
   }
   
   public String toString()
   {
      return "";
   }
}