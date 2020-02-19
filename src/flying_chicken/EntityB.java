/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Mustafa Murat
 */
public interface EntityB {
    
    public void tick();
    public void render(Graphics g);
    public Rectangle getBounds();
    
    public double getX();
    public double getY();    
}

/*
private LinkedList<Egg> e = new LinkedList<Egg>();
    private LinkedList<Cat> c = new LinkedList<Cat>();
    
    Random r = new Random();
    
    Egg TempEgg;
    Cat TempCat;
    
    Flying_Chicken game;

    public Controller(Flying_Chicken game) {
        this.game = game;
        
        addCat(new Cat(r.nextInt(500), 750, game));
    }
    
    public void tick(){
        for(int i = 0; i < e.size(); i++){
            TempEgg = e.get(i);
            
            if(TempEgg.getX() < 0 || TempEgg.getX() > 512)
                removeEgg(TempEgg);
            
            TempEgg.tick();
        }
        
        for(int i = 0; i < c.size(); i++){
            TempCat = c.get(i);
            
            TempCat.tick();
        }
    }
    
    public void render(Graphics g){
        for(int i = 0; i < e.size(); i++){
            TempEgg = e.get(i);
            
            TempEgg.render(g);
        }
        
        for(int i = 0; i < c.size(); i++){
            TempCat = c.get(i);
            
            TempCat.render(g);
        }
    }
    
    public void addEgg(Egg block){
        e.add(block);
    }
    
    public void removeEgg(Egg block){
        e.remove(block);
    }
    
    public void addCat(Cat block){
        c.add(block);
    }
    
    public void removeCat(Cat block){
        c.remove(block);
    }
*/