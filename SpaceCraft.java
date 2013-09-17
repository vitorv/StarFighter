import java.awt.Color;
import java.awt.Graphics;

public abstract class SpaceCraft implements Locatable
{
   private int xPos;
   private int yPos;

   public SpaceCraft()
   {
      setPos(10,10);
   }

   public SpaceCraft(int x, int y)
   {
      setPos(x,y);
   }

   public void setPos( int x, int y)
   {
      xPos = x;
      yPos = y;
   }

   public void setX(int x)
   {
      xPos = x;
   }

   public void setY(int y)
   {
      yPos = y;
   }

   public int getX()
   {
      return xPos;
   }

   public int getY()
   {
      return yPos;
   }

   public abstract void setSpeed( int s );
   public abstract int getSpeed();

   public abstract void moveUp();
   public abstract void moveDown();
   public abstract void moveLeft();
   public abstract void moveRight();

   public abstract void draw(Graphics window);

   public String toString()
   {
      return getX() + " " + getY() + " " + getSpeed();
   }
}