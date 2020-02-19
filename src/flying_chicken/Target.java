/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author Mustafa Murat
 */
public class Target extends GameObject implements EntityC{
    
    private final BufferedImage targetRight;
    private final BufferedImage targetLeft;
    private final Random r = new Random();
    private final Flying_Chicken game;
    private Controller c;
    private final int[] items = new int[]{48,64,96};
    private int size;
    public static int difficulty;
    public static int score;
    public static int flag;
    
    public Target(double x, double y, Flying_Chicken game){
        super(x, y);
        
        this.game = game;
        targetRight= game.gatTargetRight();
        targetLeft = game.gatTargetLeft();
        size = getRandom(items);
    }
    
    public static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    
    @Override
    public void tick(){
        y -= difficulty;
        
        if(y < -64){
            y = 750 + r.nextInt(1000);            
            size = getRandom(items);
        }
        
        if(Physics.Collision(this, game.ea) && flag == 1){
            if(this.size == 48){
                score += 7;
                flag = 0;
            }else if(this.size == 64){
                score += 5;
                flag = 0;
            }else if(this.size == 96){
                score += 3;
                flag = 0;
            }
            
            this.y = 750 + r.nextInt(1000);
        }
    }
    
    @Override
    public void render(Graphics g){
        if(x == 0){
            
            if(size == 64)
                x = -16;
            
            if(size == 96)
                x = -20;
            
            g.drawImage(targetLeft, (int)x, (int)y, size, size, null);
            
            x = 0;
        }
        
        if(x == 430){
            
            if(size == 48)
                x = 460;
            
            if(size == 64)
                x = 450;
            
            g.drawImage(targetRight, (int)x, (int)y, size, size, null);
            
            x = 430;
        }
    }
    
    @Override
    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    @Override
    public double getY() {
        return y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public int getSize(){
        return size;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 64, 64);
    }
}
