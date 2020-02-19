/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Mustafa Murat
 */
public class MouseInput implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        
        /*
        public Rectangle difficulty1 = new Rectangle(200, 300, 33, 33);
        public Rectangle difficulty2 = new Rectangle(245, 300, 33, 33);
        public Rectangle difficulty3 = new Rectangle(290, 300, 33, 33);
        public Rectangle playButton = new Rectangle(210, 350, 100, 50);
        public Rectangle quitButton = new Rectangle(210, 417, 100, 50);
        */
        
        if(mx >= 200 && mx <= 233){
            if(my >= 300 && my <= 333){
                //1
                System.out.println("1");
                Cat.difficulty = 3;
                Target.difficulty = 3;
            }
        }
        
        if(mx >= 245 && mx <= 278){
            if(my >= 300 && my <= 333){
                //2
                System.out.println("2");
                Cat.difficulty = 5;
                Target.difficulty = 7;
            }
        }
        
        if(mx >= 290 && mx <= 322){
            if(my >= 300 && my <= 333){
                //3
                System.out.println("3");
                Cat.difficulty = 9;
                Target.difficulty = 11;
            }
        }
        
        if(mx >= 210 && mx <= 310){
            if(my >= 350 && my <= 400){
                //PLAY
                Flying_Chicken.State = Flying_Chicken.STATE.GAME;
            }
        }
        
        if(mx >= 210 && mx <= 310){
            if(my >= 417 && my <= 467){
                //QUİT
                System.exit(0);
            }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }   
}
