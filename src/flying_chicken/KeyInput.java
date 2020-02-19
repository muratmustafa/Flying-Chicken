/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Mustafa Murat
 */
public class KeyInput extends KeyAdapter{
    
    Flying_Chicken game;
    
    public KeyInput(Flying_Chicken game){
        this.game = game;
    }
    
    public void keyPressed(KeyEvent e){
        game.keyPressed(e);
    }
    
    public void keyReleased(KeyEvent e){
        game.keyReleased(e);
    }
}
