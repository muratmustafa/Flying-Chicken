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
public class Cat extends GameObject implements EntityB{
    
    private Random r = new Random();
    private final BufferedImage cat;
    private Flying_Chicken game;
    private int speed = (r.nextInt(5) + 1);
    public static int difficulty;
    
    public Cat(double x, double y, Flying_Chicken game) {
        super(x, y);        
        cat = game.getCat();
        this.game = game;
    }
    
    public void tick(){
        y -= difficulty;
        
        if(y < -64){            
            x = r.nextInt(440);
            y = 750;
            speed = (r.nextInt(5) + 1);
        }
    }
    
    public void render(Graphics g){
        g.drawImage(cat, (int)x, (int)y, 48, 48, null);
    }

    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public Rectangle getBounds(){
        return new Rectangle((int)x + 3, (int)y + 3, 40, 40);
    }
}
