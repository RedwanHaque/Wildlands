/**
 * Auto Generated Java Class.
 */

import java.awt.Color; 
import java.awt.Rectangle; 
import java.awt.Graphics2D; 
import java.awt.Graphics; 


public class WildlandsMenu {
    
    public Rectangle playButton = new Rectangle(541,195,460,90);   
    public Rectangle instructButton = new Rectangle(541,298,455,85); 
    public Rectangle highscoreButton = new Rectangle(541,397,455,85); 
    public Rectangle creditsButton = new Rectangle(541,495,455,85); 
    public Rectangle exitButton = new Rectangle(541,593,455,85); 
    
    
    public void drawMenu(Graphics g){
      
        Graphics2D g2d = (Graphics2D) g; 
        g2d.draw(playButton); 
        g2d.draw(instructButton); 
        g2d.draw(highscoreButton); 
        g2d.draw(creditsButton); 
        g2d.draw(exitButton); 

    }
     
}
