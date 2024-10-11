import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
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

        }

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
