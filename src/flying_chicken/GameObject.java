/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.Rectangle;

/**
 *
 * @author Mustafa Murat
 */
public class GameObject {
    
    public double x, y;

    public GameObject(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Rectangle getBounds(int width, int height){
        return new Rectangle((int)x, (int)y, width, height);
    }
}
