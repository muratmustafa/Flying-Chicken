/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *
 * @author Mustafa Murat
 */
public class Menu {

    public Rectangle playButton = new Rectangle(210, 350, 100, 50);
    //public Rectangle helpButton = new Rectangle(210, 400, 100, 50);
    public Rectangle difficulty1 = new Rectangle(200, 300, 33, 33);
    public Rectangle difficulty2 = new Rectangle(245, 300, 33, 33);
    public Rectangle difficulty3 = new Rectangle(290, 300, 33, 33);
    public Rectangle quitButton = new Rectangle(210, 417, 100, 50);
    
    

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 35);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("FLYING CHICKEN", 115, 250);

        Font fnt1 = new Font("arial", Font.BOLD, 25);

        g.setFont(fnt1);
        g.drawString("Play", playButton.x + 23, playButton.y + 31);
        //g.drawString("Help", helpButton.x + 23, helpButton.y + 31);
        g.drawString("1", difficulty1.x + 11, difficulty1.y + 26);
        g.drawString("2", difficulty2.x + 11, difficulty2.y + 26);
        g.drawString("3", difficulty3.x + 11, difficulty3.y + 26);
        g.setColor(Color.red);
        g.drawString("Quit", quitButton.x + 23, quitButton.y + 31);
        g.setColor(Color.white);
        g2d.draw(playButton);
        //g2d.draw(helpButton);
        g.setColor(Color.green);
        g2d.draw(difficulty1);
        g.setColor(Color.yellow);
        g2d.draw(difficulty2);
        g.setColor(Color.red);
        g2d.draw(difficulty3);
        g.setColor(Color.red);
        g2d.draw(quitButton);
    }
}
