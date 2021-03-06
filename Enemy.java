//Abstract class defining the characteristics that each enemy will inherit 


/** Universal Behaviors 
  * number of enemies produced 
  * number of hitpoints of each enemy 
  * speed of movement of each enemy 
  * animation of each enemy 
  * method of attack of each enemy    
  * spawning method
  * */ 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;   
import java.util.Arrays; 

public abstract class Enemy {
    
    private static int numEnemy = 0; 
    private static int[] enemy; 
    private static int ENEMY_VELOCITY; 
    
    private static int[] storeEnemyX;
    private static int[] storeEnemyY;    
    
    private static BufferedImage enemyStatePic; 
    private static int picNum = 0;    
    
    //Determines the number of each enemy type per wave
    public void numEnemy(String enemyType, int initEnemyNum, int waveNum){
        
        //Depending on the type of enemy, the wave multiplier is set to a different amount 
        if (enemyType.equals("ANIMAL"))
            numEnemy = initEnemyNum * waveNum; 
        else if (enemyType.equals("BANDIT") && waveNum > 2){
            initEnemyNum = 2; 
            numEnemy = initEnemyNum * (waveNum - 2); 
        }   
        else if (enemyType.equals("SAVAGE") && waveNum > 5){
            initEnemyNum = 3; 
            numEnemy = initEnemyNum * (waveNum - 3); 
        }   
        else if (enemyType.equals("ROGUE") && waveNum > 8){
            initEnemyNum = 3; 
            numEnemy = initEnemyNum * (waveNum - 6); 
        }   
        else if (enemyType.equals("filler") && waveNum > 12){
            initEnemyNum = 2; 
            numEnemy = initEnemyNum * (waveNum - 10); 
        }     
        enemy = new int[numEnemy];           
        storeEnemyX = new int[numEnemy]; 
        storeEnemyY = new int[numEnemy];    
        
    }
    
    //Hitpoint updating method
    public void hitPoints(String enemyType, int numHitPoints, int[] playerBulletX, int[] playerBulletY){
      //  if (Wildlands.checkEnemyPlayerCollision
    }
    
    //Abstract method for the type of attack method used by each different type of enemy 
    public abstract void attackMethod();    
    
    //Each enemy will move at a different speed depending on the type of enemy it is
    public void enemyMovement(String enemyType, int playerX, int playerY, int[] enemyX, int[] enemyY){       
 
        int[] dxEP = new int[numEnemy]; 
        int[] dyEP = new int[numEnemy]; 
        double angleEP = 0; 
        
        if (enemyType.equals("ANIMAL")) 
            ENEMY_VELOCITY = 25; 
        else if (enemyType.equals("BANDIT"))
            ENEMY_VELOCITY = 20; 
        else if (enemyType.equals("SAVAGE"))
            ENEMY_VELOCITY = 5; 
        else if (enemyType.equals("ROGUE"))
            ENEMY_VELOCITY = 17; 
        else if (enemyType.equals("filler"))
            ENEMY_VELOCITY = 11;  
                
        for (int i = 0; i < enemy.length; i++){
            dxEP[i] = playerX - enemyX[i]; 
            dyEP[i] = playerY - enemyY[i]; 
            angleEP = Math.atan2(dxEP[i],dyEP[i]); 
            enemyX[i] = (int)(ENEMY_VELOCITY*Math.cos(angleEP));    
            storeEnemyX[i] = enemyX[i]; //Stores x values into a local variable 
            enemyY[i] = (int)(ENEMY_VELOCITY*Math.sin(angleEP));   
            storeEnemyY[i] = enemyY[i]; //Stores y values into a local variable 
        }    
        
    } 
    
    //Returns the x value of the enemy 
    public int[] returnEnemyX(){
      return storeEnemyX; 
    }
    
    //Returns the y values of the enemy 
    public int[] returnEnemyY(){
      return storeEnemyY; 
    }
    
    //Enemy movement animations 
    public void enemyAnimation(String enemyType){
      
      try {
        enemyStatePic = ImageIO.read(new File("Images/" + enemyType + " Sprites/enemy" + Integer.toString(picNum) + ".jpg")); 
      } catch (IOException ex){} 
      
      
      
    }      
    
 /**   //Enemy spawning pattern 
    public void enemySpawnPattern(String enemyType, int[] enemy, int waveNum, int[] enemyX, int[] enemyY, int enemyW, int enemyH, int playerX, int playerY, int playerW, int playerH){
        int count = waveNum; 
        while (enemy.length > 0){
            while (count > waveNum){
                for (int n = waveNum; n > 0; n--){
                    if (Wildlands.checkEnemyPlayerCollision(enemyX, enemyY, enemyW, enemyH, playerX, playerY, playerW, playerH) == true){
                //        enemy = ArrayUtils.removeElement(enemy,n);    
                        count += 1; 
                    }   
                }
            }       
        }
    }    **/ 
    
    
    
}       
 