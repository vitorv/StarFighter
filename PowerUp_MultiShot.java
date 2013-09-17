import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class PowerUp_MultiShot extends PowerUp
{
   private Image image, first, second, third, fourth;
   private int actionTimer, rand;
   private Ship s;
   private ShipShots ss;
   private Ships ships;
   private PowerUpTimer powerUpTimer;
   
   public PowerUp_MultiShot(int x, int y)
   {
      super(x,y,40,40,3);
      actionTimer = 0;
      
      try
      {
         first = ImageIO.read(new File("art/powerUp_multiShot1.png"));
         second = ImageIO.read(new File("art/powerUp_multiShot2.png"));
         third = ImageIO.read(new File("art/powerUp_multiShot3.png"));
         fourth = ImageIO.read(new File("art/powerUp_multiShot4.png"));
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
      try{s.setImage(ImageIO.read(new File("art/shipRed2.png")));}catch(Exception e){}
      try{ss.setShipShotImage(ImageIO.read(new File("art/shipShot_red.png")));}catch(Exception e){}
      setSpeed(0);
      powerUpTimer.setPowerUpTime(200);
      s.activateMultiShot();
   }
   
   public void endAction()
   {
      try{s.setImage(ImageIO.read(new File("art/shipBlue2.png")));}catch(Exception e){}
      try{ss.setShipShotImage(ImageIO.read(new File("art/shipShot.jpg")));}catch(Exception e){}
      s.endMultiShot();
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
