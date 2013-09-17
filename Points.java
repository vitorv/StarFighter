import javax.swing.JButton;
import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.*;

public class Points
{
	private int score;
	private Image num0;
	private Image num1;
	private Image num2;
	private Image num3;
	private Image num4;
	private Image num5;
	private Image num6;
	private Image num7;
	private Image num8;
	private Image num9;
	
	public Points()
	{
		score = 0;
		
		try{
			num0 = ImageIO.read(new File("shot.jpg"));
			num1 = ImageIO.read(new File("shot.jpg"));
			num2 = ImageIO.read(new File("shot.jpg"));
			num3 = ImageIO.read(new File("shot.jpg"));
			num4 = ImageIO.read(new File("shot.jpg"));
			num5 = ImageIO.read(new File("shot.jpg"));
			num6 = ImageIO.read(new File("shot.jpg"));
			num7 = ImageIO.read(new File("shot.jpg"));
			num8 = ImageIO.read(new File("shot.jpg"));
			num9 = ImageIO.read(new File("shot.jpg"));
		}
		catch(Exception e){}
	}
	
	public void add(int points)
	{
		score += points;
	}
	
	public int getIntScore()
	{
		return score;
	}
	
	public String getStringScore()
	{
		return ""+score;
	}
	
	public void convertScoreToImage()
	{
		
	}
   
   	public void draw( Graphics window )
   	{
      	//window.drawImage(image,getX(),getY(),width,height,null);
   	}
	
	public String toString()
	{
		return "";
	}
}