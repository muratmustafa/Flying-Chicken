/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 *
 * @author Mustafa Murat
 */
public class Chicken extends GameObject implements EntityA {

    private double velX = 0;
    private BufferedImage chicken;
    private Flying_Chicken game;
    private Controller c;
    public static int flag = 1;

    public Chicken(double x, double y, Flying_Chicken game) {
        super(x, y);
        this.game = game;
    }

    public void tick() {
        x += velX;

        if (x <= -10) {
            x = -10;
        }

        if (x >= 438) {
            x = 438;
        }
        
        for (int i = 0; i < game.eb.size(); i++) {
            EntityB tempEnt = game.eb.get(i);

            if (Physics.Collision(this, tempEnt) && flag == 1) {
                game.HEALTH -= 33;
                if (game.HEALTH == 1) {
                    JOptionPane.showMessageDialog(null,"                GAME IS OVER\n\n" + "SCORE: " + Target.score  + "\n\n");
                    game.HEALTH = 100;
                    Target.score = 0;
                    setVelX(0);
                    Flying_Chicken.i = 0;
                    flag = 1;
                    Flying_Chicken.State = Flying_Chicken.STATE.MENU;
                }
                flag = 0;
            }
        }

    }

    public void render(Graphics g, String direction) {

        if (direction.equals("right")) {
            chicken = game.getChickenRight();
        } else if (direction.equals("left")) {
            chicken = game.getChickenLeft();
        }

        g.drawImage(chicken, (int) x, (int) y, 64, 64, null);
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

    public void setVelX(double velX) {
        this.velX = velX;
    }

    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x + 5, (int) y + 5, 50, 50);
    }
}
