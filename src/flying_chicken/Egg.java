/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mustafa Murat
 */
public class Egg extends GameObject implements EntityA{
    
    private final BufferedImage egg;
    private final String direction;
    private Flying_Chicken game;

    public Egg(double x, double y, Flying_Chicken game, String direction) {
        
        super(x, y);
        this.egg = game.getEgg();
        this.direction = direction;
        this.game = game;
        
        if(direction.equals("right"))
            this.x += 80;
    }   
    
    public void tick(){
        y -= 2;
        
        switch (direction) {
            case "right":
                x += 8;
                break;
            case "left":
                x -= 8;
                break;
        }
        
        if(Physics._Collision(this,game.ec)){
            System.out.println("Collision" + " " + x + " " + y + " ");
        }
    }
    
    public void render(Graphics g){
        g.drawImage(egg, (int)x, (int)y, 16, 16, null);
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
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
