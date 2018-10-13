/**
 * Auto Generated Java Class.
 */

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;


public class WildlandsMenuReal {
    private static GraphicsPanel canvas;    
    
    static JFrame frame = new JFrame("Wildlands"); 
    
    //Menu Pictures 
    private static BufferedImage mainMenuBackground;       
    private static BufferedImage instructMenuBackground; 
    private static BufferedImage highscoreMenuBackground; 
    private static BufferedImage creditsMenuBackground; 
    private static BufferedImage exitMenuBackground; 
    
    //Menu Select Boolean Flags 
    private static boolean mainMenuSelect = false;   
    private static boolean playGame = false; 
    private static boolean instructMenuSelect = true; 
    private static boolean highscoreMenuSelect = false; 
    private static boolean creditsMenuSelect = false; 
    private static boolean exitMenuSelect = false; 
    private static boolean menu = true; 
    
    private static int mouseX = 0; 
    private static int mouseY = 0; 
    public static void drawMainMenu(Container panel){
         panel.setBounds(0,0,1600,900);          
        panel.setBackground(new Color(100,100,100,0)); 
        Dimension buttonMaxSize = new Dimension(460,90);    
        Dimension buttonMaxSize2 = new Dimension(460,85); 
        panel.add(Box.createRigidArea(new Dimension(457,195)));        
        
        JButton playButton = new JButton(""); 
        playButton.setMaximumSize(buttonMaxSize);        
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);            
        playButton.setOpaque(false); 
        playButton.setContentAreaFilled(false); 
        playButton.setBorderPainted(false);    
        playButton.addActionListener(new PlayGameButtonClickListener());   
        panel.add(playButton);    
        panel.add(Box.createRigidArea(new Dimension(457,14))); 
        
        JButton instructButton = new JButton(""); 
        instructButton.setMaximumSize(buttonMaxSize2);    
        instructButton.setAlignmentX(Component.CENTER_ALIGNMENT);    
        playButton.setOpaque(false); 
        instructButton.setContentAreaFilled(false); 
        instructButton.setBorderPainted(false);     
        instructButton.addActionListener(new InstructMenuButtonClickListener());    
        panel.add(playButton);    
        panel.add(instructButton); 
        panel.add(Box.createRigidArea(new Dimension(457,14))); 
        
        JButton highscoreButton = new JButton(""); 
        highscoreButton.setMaximumSize(buttonMaxSize2);    
        highscoreButton.setAlignmentX(Component.CENTER_ALIGNMENT);    
        highscoreButton.setOpaque(false); 
        highscoreButton.setContentAreaFilled(false); 
        highscoreButton.setBorderPainted(false);    
        highscoreButton.addActionListener(new HighscoreMenuButtonClickListener());  
        panel.add(highscoreButton); 
        panel.add(Box.createRigidArea(new Dimension(457,14))); 
        
        JButton creditsButton = new JButton(""); 
        creditsButton.setMaximumSize(buttonMaxSize2);    
        creditsButton.setAlignmentX(Component.CENTER_ALIGNMENT);    
        creditsButton.setOpaque(false); 
        creditsButton.setContentAreaFilled(false); 
        creditsButton.setBorderPainted(false);    
        creditsButton.addActionListener(new CreditsMenuButtonClickListener()); 
        panel.add(creditsButton); 
        panel.add(Box.createRigidArea(new Dimension(457,14))); 
        
        JButton exitButton = new JButton(""); 
        exitButton.setMaximumSize(buttonMaxSize2);    
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);    
        exitButton.setOpaque(false); 
        exitButton.setContentAreaFilled(false); 
        exitButton.setBorderPainted(false);    
        exitButton.addActionListener(new ExitMenuButtonClickListener()); 
        panel.add(exitButton);       
    }
    
}
