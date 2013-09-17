import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class Buttons_Misc extends Buttons
{
   public Buttons_Misc(int x, int y)
   {
      super(x,y);
      setWidth(160);
      setHeight(80);
      
      try
      {
      	 setImages(ImageIO.read(new File("art/moreButton1.png")),ImageIO.read(new File("art/moreButton2.png")));
      	 setImage(ImageIO.read(new File("art/moreButton1.png")));
      }
      catch(Exception e)
      {
         //feel free to do something here
      }
   }

   public String toString()
   {
      return "";
   }
}
