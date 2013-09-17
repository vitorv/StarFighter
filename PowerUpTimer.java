public class PowerUpTimer
{
   private int timer;
   private int powerUpTime;
   private boolean powerUpOn = false;
   
   public PowerUpTimer()
   {
      timer = 0;
      powerUpTime = 150;
   }
   
   public void beginTimer()
   {
      timer = 0;
      powerUpOn = true;
   }
   
   public void endTimer()
   {
      timer = 0;
      powerUpOn = false;
   }
   
   public boolean isOver()
   {
      if(timer >= powerUpTime)
      {
         return true;
      }
      return false;
   }
   
   public boolean isPowerUpOn()
   {
   		return powerUpOn;
   }
   
   public void timerRun()
   {
   		timer++;
   }
   
   public int getTimer()
   {
   		return timer;
   }
   
   public int getPowerUpTime()
   {
   		return powerUpTime;
   }
   
   public void setTimer(int time)
   {
   		timer = time;
   }
   
   public void setPowerUpTime(int time)
   {
   		powerUpTime = time;
   }
   
   public String toString()
   {
      return "";
   }
}