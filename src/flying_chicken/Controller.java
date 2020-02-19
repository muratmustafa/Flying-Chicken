/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Mustafa Murat
 */
public class Controller {
    
    private LinkedList<EntityA> ea = new LinkedList<EntityA>();
    private LinkedList<EntityB> eb = new LinkedList<EntityB>();
    private LinkedList<EntityC> ec = new LinkedList<EntityC>();
    private Flying_Chicken game;
    private EntityA enta;
    private EntityB entb;    
    private EntityC entc;
    private Random r = new Random();
    
    public Controller(Flying_Chicken game){
        this.game = game;
    }
    
    public void createCat(int enemy_count){                
        for(int i = 0; i < enemy_count; i++){
            addEntity(new Cat(r.nextInt(440), 750 + r.nextInt(1000), game));
        }
    }
    
    public void createTarget(){
        for(int i = 0; i < 3; i++){
            
            int y1 = 750 + r.nextInt(1000);
            int y2 = 750 + r.nextInt(1000);
            
            addEntity(new Target(0, y1, game));
            addEntity(new Target(430, y2, game));
        }
    }
    
    public void tick(){
        //A Class
        for(int i = 0; i < ea.size(); i++){
            enta = ea.get(i);
            enta.tick();
        }
        //B Class
        for(int i = 0; i < eb.size(); i++){
            entb = eb.get(i);
            entb.tick();
        }
        //C Class
        for(int i = 0; i < ec.size(); i++){
            entc = ec.get(i);
            entc.tick();
        }
    }
    
    public void render(Graphics g){
        //A Class
        for(int i = 0; i < ea.size(); i++){
            enta = ea.get(i);
            enta.render(g);
        }
        //B Class
        for(int i = 0; i < eb.size(); i++){
            entb = eb.get(i);
            entb.render(g);
        }
        //C Class
        for(int i = 0; i < ec.size(); i++){
            entc = ec.get(i);
            entc.render(g);
        }
    }
    
    public void addEntity(EntityA block){
        ea.add(block);
    }
    
    public void removeEntity(EntityA block){
        ea.remove(block);
    }
    
    public void addEntity(EntityB block){
        eb.add(block);
    }
    
    public void removeEntity(EntityB block){
        eb.remove(block);
    }
    
    public void addEntity(EntityC block){
        ec.add(block);
    }
    
    public void removeEntity(EntityC block){
        
        block = null;
        
        ec.remove(block);
    }
    
    public LinkedList<EntityA> getEntityA(){
        return ea;
    }
    
    public LinkedList<EntityB> getEntityB(){
        return eb;
    }
    
    public LinkedList<EntityC> getEntityC(){
        return ec;
    }
}
