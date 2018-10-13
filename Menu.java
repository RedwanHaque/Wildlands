//Menu class - stores the methods responsible for creating the various methods of the game 
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class Menu {
    
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
    
      static MyMouseListener mouseListener = new MyMouseListener();    
//    static PlayGameButtonClickListener playButtonListener = new PlayGameButtonClickListener(); 
  //  static InstructMenuButtonClickListener instructButtonListener = new InstructMenuButtonClickListener(); 
  //  static HighscoreMenuButtonClickListener highscoreButtonListener = new HighscoreMenuButtonClickListener(); 
  //  static CreditsMenuButtonClickListener creditsButtonListener = new CreditsMenuButtonClickListener(); 
  //  static ExitMenuButtonClickListener exitButtonListener = new ExitMenuButtonClickListener(); 
    
    public static void main(String[] args) {
        
        //Loads the menu background pictures 
        try{    
            mainMenuBackground = ImageIO.read(new File("Images/Menu Backgrounds/Wildlands Main Menu Background.jpg"));       
            instructMenuBackground = ImageIO.read(new File("Images/Menu Backgrounds/Wildlands Instructions.jpg")); 
            highscoreMenuBackground = ImageIO.read(new File("Images/Menu Backgrounds/Wildlands High Score Background.jpg")); 
            creditsMenuBackground = ImageIO.read(new File("Images/Menu Backgrounds/Wildlands Credits Menu.jpg")); 
            exitMenuBackground = ImageIO.read(new File("Images/Menu Backgrounds/Wildlands Exit Confrimation.jpg")); 
        } catch (IOException ex){}      
        
        do{

        frame.setSize(1600,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas = new GraphicsPanel(); 
        
        Dimension backButtonSize = new Dimension(214,86); 
        
        if (mainMenuSelect == true)
            drawMainMenuComponents(canvas);    
        else if (instructMenuSelect == true)
            drawInstructionMenuComponents(canvas,backButtonSize); 
        else if (highscoreMenuSelect == true) 
            drawhighscoreMenuComponents(canvas,backButtonSize); 
        else if (creditsMenuSelect == true) 
            drawCreditsMenuComponents(canvas,backButtonSize); 
        else if (exitMenuSelect == true) 
            drawExitMenuComponents(canvas,backButtonSize);  
        
     //   resetMenuSelectFlags(); 
    //    selectProperMenu(); 
           frame.add(canvas);      
        
        canvas.addMouseListener(mouseListener);      

      //  selectProperMenu(); 
        frame.add(canvas);   
        frame.setVisible(true); 
        frame.setResizable(false); 
        frame.setLocationRelativeTo(null);   
        }while(menu); 
        
    }  
    
    public static void drawMainMenuComponents(Container panel){          
        resetPanel(panel);    
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));       
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
    
    //Draws the instruction menu 
    public static void drawInstructionMenuComponents(Container panel,Dimension backButtonSize){   
        resetPanel(panel);      
        canvas.repaint(); 
        createBackButtonComponent(panel,backButtonSize);    
        canvas.setVisible(true); 
    }         
    //Draws the highscore menu
    public static void drawhighscoreMenuComponents(Container panel, Dimension backButtonSize){   
        resetPanel(panel); 
        createBackButtonComponent(panel,backButtonSize);    
    }      
    //Draws the credits menu 
    public static void drawCreditsMenuComponents(Container panel, Dimension backButtonSize){   
        resetPanel(panel); 
        createBackButtonComponent(panel,backButtonSize); 
    }      
    //Draws the exit menu 
    public static void drawExitMenuComponents(Container panel, Dimension backButtonSize){   
        resetPanel(panel); 
        createBackButtonComponent(panel,backButtonSize);  
    }         
    //The method responsible for creating the back button component  
    public static void createBackButtonComponent(Container panel, Dimension backButtonSize){
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));       
        panel.setBounds(0,0,1600,900);          
        panel.setBackground(new Color(100,100,100,0));      
        
        JButton backButton = new JButton("");    
        backButton.setMaximumSize(backButtonSize); 
        backButton.setBounds(254,679,468,765);    
        panel.add(backButton);    
    }       
    //Resets the entire panel 
    public static void resetPanel(Container panel){
        panel.removeAll(); 
        panel.revalidate(); 
        panel.repaint(); 
    }      
/**    public static void selectProperMenu(/**boolean mainMenuSelect, boolean instructButtonSelect, boolean highScoreMenuSelect, boolean creditsMenuSelect, boolean exitMenuSelect){
        if (mainMenuSelect == true){
            if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 195 && mouseY <= 285) 
                playGame = true; 
            else if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 298 && mouseY <= 383)    
                instructMenuSelect = true; 
            else if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 395 && mouseY <= 483) 
                highscoreMenuSelect = true; 
            else if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 494 && mouseY <= 581)    
                creditsMenuSelect = true; 
            else if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 593 && mouseY <= 679)    
                exitMenuSelect = true; 
        }
    }   **/    
    public static void resetMenuSelectFlags(){           
        playGame = false; 
        mainMenuSelect = true;    
        instructMenuSelect = false; 
        highscoreMenuSelect = false; 
        creditsMenuSelect = false; 
        exitMenuSelect = false;  
    }
    static class GraphicsPanel extends JPanel{
        public GraphicsPanel(){
            setFocusable(true);
            requestFocusInWindow();
        }   
        public void paintComponent(Graphics g){ 
            super.paintComponent(g);             
            //Draws each of the pictures if called upon 
            if (mainMenuSelect)
                g.drawImage(mainMenuBackground,0,0,this); 
            else if (instructMenuSelect) 
                g.drawImage(instructMenuBackground,0,0,this);    
            else if (highscoreMenuSelect) 
                g.drawImage(highscoreMenuBackground,0,0,this);   
            else if (creditsMenuSelect) 
                g.drawImage(creditsMenuBackground,0,0,this);    
            else if (exitMenuSelect) 
                g.drawImage(exitMenuBackground,0,0,this); 
        } 
    }   
      static class MyMouseListener implements MouseListener{
      public void mousePressed(MouseEvent e){
        mouseX = e.getX(); 
        mouseY = e.getY();       
        //     resetMenuSelectFlags(); 
 /**     if (mainMenuSelect == true){
      if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 195 && mouseY <= 285) 
      playGame = true; 
      else if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 298 && mouseY <= 383)    
      instructMenuSelect = true; 
      else if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 395 && mouseY <= 483) 
      highscoreMenuSelect = true; 
      else if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 494 && mouseY <= 581)    
      creditsMenuSelect = true; 
      else if (mouseX >= 541 && mouseX <= 1001 && mouseY >= 593 && mouseY <= 679)    
      exitMenuSelect = true; 
      }   **/ 
      }      
      public void mouseReleased(MouseEvent e){}
      public void mouseEntered(MouseEvent e){}
      public void mouseExited(MouseEvent e){}
      public void mouseClicked(MouseEvent e){}
      }   
    static class PlayGameButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){       
            menu = false; 
            System.out.println ("THE GAME HAS STARTED"); 
        }   
    } 
    static class InstructMenuButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){  
            frame.repaint(); 
            highscoreMenuSelect = false;    
            creditsMenuSelect = false;   
            exitMenuSelect = false;    
            playGame = false; 
            instructMenuSelect = true;    
            frame.setVisible(true);    
            System.out.println(instructMenuSelect); 
        }   
    }   
    static class HighscoreMenuButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            highscoreMenuSelect = true; 
        }
    }   
    static class CreditsMenuButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            creditsMenuSelect = true; 
        }
    }   
    static class ExitMenuButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            exitMenuSelect = true; 
        }
    }   
    //Return boolean flag methods 
    public boolean returnMainMenuFlag(){
        return this.mainMenuSelect; 
    }   
    public boolean returnPlayGameFlag(){
        return this.playGame; 
    }   
    public boolean returnInstructMenuFlag(){
        return this.instructMenuSelect; 
    }   
    public boolean returnHighscoreMenuFlag(){
        return this.highscoreMenuSelect; 
    }   
    public boolean returnCreditsMenuFlag(){
        return this.creditsMenuSelect; 
    }    
    public boolean returnExitMenuFlag(){
        return this.exitMenuSelect; 
    }   
    public boolean returnMenuFlag(){
        return this.menu; 
    }
}

