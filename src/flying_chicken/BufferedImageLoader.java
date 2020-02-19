/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flying_chicken;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Mustafa Murat
 */
public class BufferedImageLoader {
    
    private BufferedImage image;
    
    public BufferedImage loadImage(String Path) throws IOException{
        image = ImageIO.read(getClass().getResource(Path));
        return image;        
    }
    
    
}
