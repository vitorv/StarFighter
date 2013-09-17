import java.lang.*;
import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class AlienBlock
{
   private ArrayList<Alien> alienList = new ArrayList<Alien>();
   private int moveCounter;
   private int width, height;
   
   public AlienBlock(int screenWidth, int screenHeight, int row, int col, int alspeed)
   {
   	  moveCounter = 0;
   	  
      int x = 10;
      int y = 10;
      for(int a=0; a<row; a++)
      {
         for(int b=0; b<col; b++)
         {
            add(new Alien(x,y,alspeed));
            x += 80;
         }
         x = 10;
         y += 60;
      }
      width = screenWidth;
      height = screenHeight;
   }
   
   public void add(Alien al)
   {
   		alienList.add(al);
   }
   
   public void remove(Alien al)
   {
   		alienList.remove(al);
   }
   
   public void remove(int al)
   {
   		alienList.remove(al);
   }
   
   public ArrayList<Alien> getAlienList()
   {
   		return alienList;
   }
   
   public void move()
   {
   		for(Alien al : alienList)
        {
            for(Alien a : alienList)
            	a.changePosition();
            
            if(al.getY()%2==0)
               for(Alien a : alienList)
                  a.moveRight(); 
                  
            if(al.getY()%2==1)
               for(Alien a : alienList)
                  a.moveLeft(); 
                  
            if((touchLeftOfScreen() || touchRightOfScreen()))
               for(Alien a : alienList)
               { a.moveDown(); } break;
        }
   }
   
   public boolean touchRightOfScreen()
   {
      for(Alien al:alienList)
         if(al.getX()+65 > width)
            return true;
      return false;
   }
   
   public boolean touchLeftOfScreen()
   {
      for(Alien al:alienList)
         if(al.getX() <= 0)
            return true;    
      return false;
   }
   
   public void shoot(AlienShots alShots)
   {
      for(Alien al : alienList)
         if(al.shootChance(alienList.size()*20))
            al.shoot(alShots);
   }

   public void draw(Graphics g)
   {
      for(Alien al:alienList)
      {
         al.draw(g);
      }
   }

   	public String toString()
   	{
      	return "";
   	}
}