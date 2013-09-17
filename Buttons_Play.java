import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Rectangle;

public class Buttons_Play extends Buttons
{
   public Buttons_Play(int x, int y)
   {
      super(x,y);
      setWidth(160);
      setHeight(80);
      
      try
      {
      	 setImages(ImageIO.read(new File("art/playButton1.png")),ImageIO.read(new File("art/playButton2.png")));
      	 setImage(ImageIO.read(new File("art/playButton1.png")));
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
