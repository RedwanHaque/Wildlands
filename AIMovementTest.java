//AI following player test 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;   
import java.util.Arrays; 


public class AIMovementTest {   
    
    static JFrame gameWindow;
    static GraphicsPanel canvas;
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    
    static MyMouseMotionListener mouseMotionListener = new MyMouseMotionListener();    
    static MyMouseListener mouseListener = new MyMouseListener(); 
    
    //Box Properties (player controled) 
    static int boxW = 30;       
    static int boxH = 30;       
    static int boxX = WIDTH/2 - boxW/2; 
    static int boxY = HEIGHT/2 - boxH/2; 
    static Rectangle playerCollisionBox = new Rectangle(boxX,boxY,boxW,boxH); 
    
    static double angle = 0; 
    
    static int[] x = {12, 75, 1100, 1550, 765}; 
    static int[] y = {12, 255, 765, 895, 355}; 
    
    //Moving Enemy Properties 
    static int[] enemyAngle = new int[25]; 
    static int[] dxEP = new int[5]; 
    static int[] dyEP = new int[5];        
    static int[] VELOCITY = new int[5];      
    static Rectangle[] enemyCollisionBox = new Rectangle[5];   
    
    //Bullet Properties    
    static int numBullets = 50; 
    static final int BULLET_VELOCITY = 50;   
    static final int bulletW = 10; 
    static final int bulletH = 10; 
    
    static boolean[] bulletVisible = new boolean[numBullets]; 
    
    static int[] bulletX = new int[numBullets]; 
    static int[] bulletY = new int[numBullets]; 
    
    static int[] bulletStepX = new int[numBullets]; 
    static int[] bulletStepY = new int[numBullets];    
    
    static double[] bulletAngle = new double[numBullets]; 
    
    static Rectangle[] bulletHitBox = new Rectangle[numBullets]; 
    
    static int currentBullet = 0; 
    
    //Mouse 
    static int mouseClickX = 0; 
    static int mouseClickY = 0; 
    
    public static void main(String[] args) {   
        
        for (int i = 0; i < 5; i++){
            enemyCollisionBox[i] = new Rectangle(x[i],y[i],boxW,boxH); 
        } 
        
        Arrays.fill(VELOCITY, 5); 
        Arrays.fill(bulletX, 0); 
        Arrays.fill(bulletY, 0); 
        Arrays.fill(bulletVisible, false); 
        
        
        gameWindow = new JFrame("AI Test");
        gameWindow.setSize(WIDTH,HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new GraphicsPanel();   
        canvas.addMouseMotionListener(mouseMotionListener);    
        canvas.addMouseListener(mouseListener); 
        
        gameWindow.add(canvas); 
        
        gameWindow.setVisible(true);   
        gameWindow.setLocationRelativeTo(null);        
        gameWindow.setResizable(false); 
        runGameLoop();
        
    }   
 
     public static void runGameLoop(){   
         int diffX, diffY = 0;  
         int refPointX = WIDTH/2; 
         int refPointY = HEIGHT/2; 
         double bulletAngle = 0; 
         while (true) {
            gameWindow.repaint();
            try  {Thread.sleep(35);} catch(Exception e){}      
            playerCollisionBox.setLocation(boxX,boxY); 
            for (int a = 0; a < enemyCollisionBox.length; a++){   
                enemyCollisionBox[a].setLocation(x[a],y[a]); 
                for (int b = 0; b < enemyCollisionBox.length; b++){ 
                    if (a != b){
                        if (enemyCollisionBox[a].intersects(enemyCollisionBox[b]) || enemyCollisionBox[a].intersects(playerCollisionBox)){ 
                            x[a] -= dxEP[a]; 
                            y[a] -= dyEP[a];       
                            dxEP[b] = 0; 
                            dyEP[b] = 0; 
                        }
                    } 
                }
            }      
             for (int i = 0; i < currentBullet; i++){   
                 if (bulletVisible[i] == true){
                     bulletX[i] += bulletStepX[i]; 
                     bulletY[i] += bulletStepY[i];    
                     bulletHitBox[i].setLocation(bulletX[i],bulletY[i]);              
                     for (int x = 0; x < enemyCollisionBox.length; x++){
                         if (enemyCollisionBox[x].intersects(bulletHitBox[i])){
                             bulletVisible[i] = false; 
                         //    enemyCollisionBox = ArraysUtils.removeElement(enemyCollisionBox,x); 
                         }
                     }
                     if (bulletY[i] < 0 || bulletY[i] > HEIGHT || bulletX[i] < 0 || bulletX[i] > WIDTH) 
                         bulletVisible[i] = false; 
                 }
             }   
         }
     }    
     public static void music(){
         
     }
     static class GraphicsPanel extends JPanel{
         public GraphicsPanel(){
             setFocusable(true);
             requestFocusInWindow();
         }   
         public void paintComponent(Graphics g){ 
             super.paintComponent(g); 
             g.setColor(Color.RED); 
             for (int i = 0; i < 5; i++){
                 g.fillRect(x[i],y[i],boxW,boxH);        
             }   
             g.setColor(Color.BLUE); 
             g.fillRect(boxX, boxY, boxW, boxH);    
             
             g.setColor(Color.BLACK); 
             for (int i=0; i<bulletX.length; i++){
                 if (bulletVisible[i] == true)
                     g.fillOval(bulletX[i],bulletY[i],bulletW,bulletH);
             } 
         } 
      }      
     static class MyMouseListener implements MouseListener{
         public void mousePressed(MouseEvent e){
             
             mouseClickX = e.getX(); 
             mouseClickY = e.getY(); 
         
             bulletX[currentBullet] = boxX;
             bulletY[currentBullet] = boxY;            

             bulletAngle[currentBullet] = Math.atan2(bulletX[currentBullet] - WIDTH/2, bulletY[currentBullet] - HEIGHT/2);  
             
             bulletStepX[currentBullet] = (int)(BULLET_VELOCITY*Math.cos(bulletAngle[currentBullet])); 
             bulletStepY[currentBullet] = (int)(BULLET_VELOCITY*Math.sin(bulletAngle[currentBullet])); 
             bulletVisible[currentBullet] = true;          
             bulletHitBox[currentBullet] = new Rectangle(bulletX[currentBullet],bulletY[currentBullet]); 
             currentBullet = (currentBullet + 1)%numBullets;     
             
         }
         public void mouseReleased(MouseEvent e){}
         public void mouseEntered(MouseEvent e){}
         public void mouseExited(MouseEvent e){}
         public void mouseClicked(MouseEvent e){}
     }
     static class MyMouseMotionListener implements MouseMotionListener{ 
         public void mouseDragged(MouseEvent e){}          
         public void mouseMoved(MouseEvent e){   
             
             int mouseX = e.getX(); 
             int mouseY = e.getY(); 
             int diffX, diffY = 0; 
             
             for (int i = 0; i < x.length; i++){
                  diffX = mouseX - x[i]; 
                  diffY = mouseY - y[i]; 
                  angle = Math.atan2(diffY,diffX);    
                  dxEP[i] = (int)(VELOCITY[i] * Math.cos(angle)); 
                  dyEP[i] = (int)(VELOCITY[i] * Math.sin(angle)); 
                  x[i] += dxEP[i]; 
                  y[i] += dyEP[i];    
             } 
             boxX = mouseX; 
             boxY = mouseY;   
         }   
     }    
     
}