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
            image = brigthen(image, 20);
            Dispaly(image);
            //Dispaly(image);
            //image = toGrayScale2(image);
            //Dispaly(image);
            /*image = pixalate(image, 2);
            Dispaly(image);
            image = pixalated2(image, 3);
            Dispaly(image);*/
            //image = blur(image);
            //Dispaly(image);

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
        g.dispose();
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
    public static BufferedImage pixalate(BufferedImage img, int n){
        BufferedImage pixImg = new BufferedImage(img.getWidth(),img.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        int pix = 0, p = 0;
        for(int y = 0; y<img.getHeight()-2; y+=2 ){
            for(int x = 0; x<img.getWidth(); x+=2){
                pix = (int)((img.getRGB(x, y)& 0xFF)+
                (img.getRGB(x+1, y)& 0xFF)+ 
                (img.getRGB(x, y+1)& 0XFF)+
                (img.getRGB(x+1, y+1)& 0xFF))/4;
                p = (255<<24) | (pix<<16) | (pix<<8) | pix;
                pixImg.setRGB(x,y,p);
                pixImg.setRGB(x+1,y,p);
                pixImg.setRGB(x,y+1,p);
                pixImg.setRGB(x+1,y+1,p);

            }
        }
        return pixImg;

    }
    public static BufferedImage pixalated2(BufferedImage image, int n){
        BufferedImage pixImg = new BufferedImage(image.getWidth(),image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        int pix = 0, p =0;
        for(int y = 0; y < image.getHeight()-n; y+=n){
            for(int x = 0; x < image.getWidth()-n; x +=n){
                for(int a = 0; a<n; a++){
                    for(int b = 0; b<n; b++){
                        pix +=(image.getRGB(x+a, y+b)& 0xFF);
                    }
                }
                pix =(int)(pix/n/n);
                for(int a = 0; a<n;a++){
                    for(int b = 0; b<n;b++) {
                        p = (225<<24) | (pix<<16) |(pix<<8) | pix;
                        pixImg.setRGB(x+a,y+b,p);
                    }
                }
                pix = 0;

            }
        }



        return pixImg;

    }
    public static BufferedImage blur(BufferedImage img){
        BufferedImage blurImage = new BufferedImage(img.getWidth()-2, img.getHeight()-2, BufferedImage.TYPE_BYTE_GRAY);
        int pix = 0;
        for(int y = 0; y < blurImage.getHeight(); y++){
            for(int x = 0; x < blurImage.getWidth(); x++){
                pix = (int)(4*(img.getRGB(x+1, y+1)& 0xFF)
                + 2*(img.getRGB(x+1, y)& 0xFF)
                + 2*(img.getRGB(x+1, y+2)& 0xFF)
                + 2*(img.getRGB(x, y+1)& 0xFF)
                + 2*(img.getRGB(x+2, y+1)& 0xFF)
                + (img.getRGB(x, y)& 0xFF)
                + (img.getRGB(x, y+2)& 0xFF)
                + (img.getRGB(x+2, y)& 0xFF)
                + (img.getRGB(x+2, y+2)& 0xFF))/16;
                int p = (255<<24) | (pix<<16) | (pix<<8) | pix;
                blurImage.setRGB(x, y, p);
                
                    }
                }

        return blurImage;

    }
    public static BufferedImage brigthen(BufferedImage image, int percentage){
        int r =0, g=0, b =0, rgb =0, p = 0;
        int amount = (int) (percentage * 255 / 100);
        BufferedImage brigthenImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        for(int i = 0; i < image.getHeight(); i+=1){
            for(int j = 0; j < image.getWidth(); j+=1 ){
                rgb = image.getRGB(j,i);
                r = ((rgb >> 16) & 0xFF)+ amount;
                g = ((rgb >> 8) & 0xFF)+ amount;
                b = (rgb & 0xFF) + amount;
                if (r > 255) r = 255;
                if (g > 255) g = 255;
                if (b > 255) b = 255;
                p = (255<<24) | (r<<16) | (g<<8) | b;
                brigthenImage.setRGB(j, i, p);
                


            }
        }

        return brigthenImage;
    
    }

    
    


    
}
