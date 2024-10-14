import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public class ImageProcessing {
    public static void main(String [] args){
        File file = new File("Test.jpg");
        BufferedImage image = null;
        try{image = ImageIO.read(file);}
        catch(IOException e){e.printStackTrace(System.out);}
        if(image != null){
            Dispaly(image);
            image = toGrayScale2(image);
            Dispaly(image);

        }

    }

    private static BufferedImage toGrayScale2(BufferedImage image) {
        System.out.println("Converting to GrayScale");
        BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        /*int rgb=0, r=0, g=0, b =0;
        for(int y = 0; y < image.getHeight();y++){
            for(int x = 0; x < image.getWidth();x++){
                rgb = (int)(image.getRGB(x, y));
                r = ((rgb >> 16) & 0xFF);
                g = ((rgb >> 8) & 0xFF);
                b = (rgb & 0xFF);
                rgb = (int)((r+g+b)/3);
                rgb = (255<<24) | (rgb<<16) | (rgb<<8) | rgb;
                grayImage.setRGB(x, y, rgb);

            }

        }*/
        Graphics g = grayImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();;
        return grayImage;

    }

    private static void Dispaly(BufferedImage image) {
        System.out.println("Displayed Image");
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        frame.setSize(image.getWidth(), image.getHeight());
        label.setIcon(new ImageIcon(image));
        frame.getContentPane().add(label, BorderLayout.CENTER);
       // frame.pack();
        frame.setVisible(true);

    }
    
}
