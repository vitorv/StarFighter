import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowEvent;

public class StarFighter extends JFrame
{
   private MenuMain mainMenu;
   private OuterSpace theGame;
   private MenuGameOver gameOverMenu;
   
   public StarFighter()
   {
      super("STARFIGHTER");
      
      setUndecorated(true);
      
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      setSize(screenSize);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
      
   public void runMainMenu()
   {
      	mainMenu = new MenuMain(this);
      	((Component)mainMenu).setFocusable(true);
      	getContentPane().add(mainMenu);
      	mainMenu.requestFocusInWindow();
      	setVisible(true);
   }
   
   public void closeMainMenu()
   {
   		((Component)mainMenu).setFocusable(false);
   		getContentPane().remove(mainMenu);
   }
   
   public void runGameOverMenu(Points score)
   {
      	gameOverMenu = new MenuGameOver(this,score);
      	((Component)gameOverMenu).setFocusable(true);
      	getContentPane().add(gameOverMenu);
      	gameOverMenu.requestFocusInWindow();
      	setVisible(true);
   }
   
   public void closeGameOverMenu()
   {
   		((Component)gameOverMenu).setFocusable(false);
   		getContentPane().remove(gameOverMenu);
   }
      
   public void runTheGame()
   {
      	theGame = new OuterSpace(this);
      	((Component)theGame).setFocusable(true);
      	getContentPane().add(theGame);
      	theGame.requestFocusInWindow();
      	setVisible(true);
   }
   
   public void closeTheGame()
   {
   		((Component)theGame).setFocusable(false);
   		getContentPane().remove(theGame);
   }
   
   public static void main( String args[] )
   {
      StarFighter run = new StarFighter();
      run.runMainMenu();
   }
}