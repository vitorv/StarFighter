import javax.swing.JButton;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class Shot_Laser extends Shot
{
	public Shot_Laser(int x, int y)
	{
		super(x,y,10);
		setWidth(80);
		setHeight(1000);
		try{setImage(ImageIO.read(new File("art/shipShot_teal.png")));}catch(Exception e){}
	}

   	public String toString()
   	{
      	return "";
   	}
}