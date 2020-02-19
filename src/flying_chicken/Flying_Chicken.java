/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 *
 * @author Mustafa Murat
 */
public class Flying_Chicken extends Canvas implements Runnable{
    
    public static final int WIDTH = 500;
    public static final int HEIGHT = 750;
    public final String TITLE = "Flying Chicken";
    
    public LinkedList<EntityA> ea;
    public LinkedList<EntityB> eb;
    public LinkedList<EntityC> ec;
    
    private int cat_count = 5;
    private boolean running = false;
    private boolean is_shooting = false;
    private String direction = "right";
    private Thread thread;
    
    private final BufferedImage image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
    private BufferedImage bg = null;
    private BufferedImage chickenRight = null;
    private BufferedImage chickenLeft = null;
    private BufferedImage egg = null;
    private BufferedImage cat = null;
    private BufferedImage targetRight = null;
    private BufferedImage targetLeft = null;
    private BufferedImage sun = null;
    private BufferedImage cloud = null;
    
    private Chicken c;
    private Controller controller;
    private Menu menu;
    
    public static int HEALTH = 100;
    
    public static int i = 0;
    
    public static enum STATE{
        MENU,
        GAME
    };
    
    public static STATE State = STATE.MENU;
    
    public void init(){
        
        requestFocus();
        
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            bg = loader.loadImage("/bg.png");
            chickenRight = loader.loadImage("/chickenRight.png");
            chickenLeft = loader.loadImage("/chickenLeft.png");
            egg = loader.loadImage("/egg.png");
            cat = loader.loadImage("/cat.png");
            targetRight = loader.loadImage("/targetRight.png");
            targetLeft = loader.loadImage("/targetLeft.png");
            sun = loader.loadImage("/sun.png");
            cloud = loader.loadImage("/cloud.png");
        }catch(IOException e){
            e.printStackTrace();
        }
        
        addKeyListener(new KeyInput(this));
        addMouseListener(new MouseInput());        
        
        c = new Chicken(200, 325, this);
        controller = new Controller(this);        
        controller.createCat(cat_count);
        controller.createTarget();
        menu = new Menu();
        
        ea = controller.getEntityA();
        eb = controller.getEntityB();
        ec = controller.getEntityC();
    }
       
    private synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running)
            return; 
        running = false;
        try{
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.exit(1);
    }
    
    @Override
    public void run(){
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        if(State == STATE.GAME){
            c.tick();
            controller.tick();
            
            i++;
            System.out.println(i / 53);
            
            if(i / 53 == 45){
                Cat.difficulty = 5;
            }else if(i / 53 == 75){
                Cat.difficulty = 9;
            }
                
        }
    }
    
    private void render(){
        
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            createBufferStrategy(3);
            return;
        }        
        
        Graphics g = bs.getDrawGraphics();
        ///////////////////
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        
        if(State == STATE.GAME){
            g.drawImage(bg, 0, 0, null);
        
            g.drawImage(sun, 370, 20,96,96,null);
            g.drawImage(cloud, 200, 60,null);
            g.drawImage(cloud, 60, 200,null);
            g.drawImage(cloud, 350, 250,null);
            g.drawImage(cloud, 110, 400,null);
            g.drawImage(cloud, 300, 500,null);
            g.drawImage(cloud, 60, 600,null);
            
            c.render(g, direction);
            controller.render(g);
            
            g.setColor(Color.gray);
            g.fillRect(403, 5, 100, 15);
            
            if(HEALTH == 100)
                g.setColor(Color.green);
            else if(HEALTH == 67)
                g.setColor(Color.yellow);
            else if(HEALTH == 34)
                g.setColor(Color.red);
            
            g.fillRect(403, 5, HEALTH, 15);
            
            g.setColor(Color.white);
            g.drawRect(403, 5, 100, 15);
            
            Font fnt0 = new Font("arial", Font.BOLD, 35);
            g.setFont(fnt0);
            g.setColor(Color.white);
            String score = String.valueOf(Target.score);
            String difficulty = "1";            
            
            if(Cat.difficulty == 3){
                difficulty = "1";
            }else if(Cat.difficulty == 5){
                difficulty = "2";
            }else if(Cat.difficulty == 9){
                difficulty = "3";
            }
            
            g.drawString(score, 8, 32);
            Font fnt1 = new Font("arial", Font.BOLD, 20);
            g.setFont(fnt1);
            g.drawString("Level " + difficulty, 220, 32);
            
        }else if(State == STATE.MENU){
            menu.render(g);
        }
        
        ///////////////////
        g.dispose();
        bs.show();
    }
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if(State == STATE.GAME){
            if(key == KeyEvent.VK_RIGHT){
                c.setVelX(5);
                direction = "right";
                Chicken.flag = 1;
            }else if(key == KeyEvent.VK_LEFT){
                c.setVelX(-5);
                direction = "left";
                Chicken.flag = 1;
            }else if(key == KeyEvent.VK_SPACE && !is_shooting){
                is_shooting = true;
                controller.addEntity(new Egg(c.getX(),c.getY(),this, direction));
                Target.flag = 1;
            }
        }
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_RIGHT){
                c.setVelX(0);
            }else if(key == KeyEvent.VK_LEFT){
                c.setVelX(0);
            }else if(key == KeyEvent.VK_SPACE){
                is_shooting = false;
            }
    }
    
    public static void main(String[] args) {
        Flying_Chicken game = new Flying_Chicken();
        
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        
        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }
    
    public BufferedImage getChickenRight(){
        return chickenRight;
    }
    
    public BufferedImage getChickenLeft(){
        return chickenLeft;
    }
    
    public BufferedImage getEgg(){
        return egg;
    }
    
    public BufferedImage getCat(){
        return cat; 
    }
    
    public BufferedImage gatTargetRight(){
        return targetRight;
    }
    
    public BufferedImage gatTargetLeft(){
        return targetLeft;
    }

    public int getCat_count() {
        return cat_count;
    }

    public void setCat_count(int cat_count) {
        this.cat_count = cat_count;
    }
}
