/*
 * extractSecretMessage.java
 *
 * Created on October 16, 2007, 4:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package my.steganography;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author asmel
 */
public class extractSecretMessage {
    private BufferedImage stegoImage = null;
    private int[] stegoImage1DPix;
    private String secretMessage = null;
    private long key;
    private Random randomizer = null;
    private ArrayList randPixels = null;
    /** Creates a new instance of extractSecretMessage */
    public extractSecretMessage() {
    }
    
    public BufferedImage getStegoImage(){
        return this.stegoImage;
    }
    
    public String getSecretMessage(){
        return this.secretMessage;
    }
    
    public boolean setStegoImage(File imageFile){
        try{
            this.stegoImage = ImageIO.read(imageFile);
        }catch(IOException ioe){
            ioe.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean extractSecretMessage(long key, int extMethod){     
        this.key = key;
        int h = this.stegoImage.getHeight();
        int w = this.stegoImage.getWidth();
        int len = h*w;
        
        this.stegoImage1DPix = new int[len];
        this.stegoImage.getRGB(0, 0, w, h, this.stegoImage1DPix, 0, w);
        
        this.secretMessage = "";
        if (extMethod == 0) this.extract1();
        else if (extMethod == 1) this.extract2();
        else if (extMethod == 2) this.extract3();
        else this.extract4();
        //System.out.println("");
        return true;
    }
    
    public void extract1(){
        this.randomizer = new Random(this.key);
        this.randPixels = new ArrayList(1000);                
        
        int h = this.stegoImage.getHeight();
        int w = this.stegoImage.getWidth();
        int len = h*w;
        int i=-1;
        while(++i < 10240){
            int pixel1 = this.getNextRandomPixel();
            int pixel2 = this.getNextRandomPixel();
            
            String binary = "" + ((this.stegoImage1DPix[pixel1] >> 24)&0x01) + "" + ((this.stegoImage1DPix[pixel1] >> 16)&0x01) + "" + ((this.stegoImage1DPix[pixel1] >> 8)&0x01) + "" + ((this.stegoImage1DPix[pixel1])&0x01) +
                            "" + ((this.stegoImage1DPix[pixel2] >> 24)&0x01) + "" + ((this.stegoImage1DPix[pixel2] >> 16)&0x01) + "" + ((this.stegoImage1DPix[pixel2] >> 8)&0x01) + "" + ((this.stegoImage1DPix[pixel2])&0x01);
            //System.out.println(binary);            
            if (binary.equals("00000011")){
                //System.out.println("breaking");
                break;
            }
            this.secretMessage += this.getCharacterValue(binary);            
        }
        //System.out.println(this.randPixels);
    }
    
    private void extract2(){
        this.randomizer = new Random(this.key);
        this.randPixels = new ArrayList(1000);                
        
        int h = this.stegoImage.getHeight();
        int w = this.stegoImage.getWidth();
        int len = h*w;
        int i=-1;
        while(++i < 10240){
            int pixel = this.getNextRandomPixel();
            
            String binary = "" + ((this.stegoImage1DPix[pixel] >> 25)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 24)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 17)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 16)&0x01) +
                            "" + ((this.stegoImage1DPix[pixel] >> 9)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 8)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 1)&0x01) + "" + ((this.stegoImage1DPix[pixel])&0x01);
            //System.out.println(binary);            
            if (binary.equals("00000011")){
                //System.out.println("breaking");
                break;
            }
            this.secretMessage += this.getCharacterValue(binary);            
        }
    }
    
    private void extract3(){
        this.randomizer = new Random(this.key);
        this.randPixels = new ArrayList(1000);                
        
        int h = this.stegoImage.getHeight();
        int w = this.stegoImage.getWidth();
        int len = h*w;
        int i=-1;
        while(++i < 10240){
            int pixel = this.getNextRandomPixel();            
            String binary = "" + ((this.stegoImage1DPix[pixel] >> 27)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 26)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 25)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 24)&0x01) +
                            "" + ((this.stegoImage1DPix[pixel] >> 19)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 18)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 17)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 16)&0x01);
            //System.out.println(binary);            
            if (binary.equals("00000011")){                
                break;
            }
            this.secretMessage += this.getCharacterValue(binary);
            
            binary = "" + ((this.stegoImage1DPix[pixel] >> 11)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 10)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 9)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 8)&0x01) +
                     "" + ((this.stegoImage1DPix[pixel] >> 3)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 2)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 1)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 0)&0x01);
            
            if (binary.equals("00000011")){       
                break;
            }
            this.secretMessage += this.getCharacterValue(binary);
        }
    }
    
    private void extract4(){
        this.randomizer = new Random(this.key);
        this.randPixels = new ArrayList(1000);                
        
        int h = this.stegoImage.getHeight();
        int w = this.stegoImage.getWidth();
        int len = h*w;
        int i=-1;
        while(++i < 10240){
            int pixel = this.getNextRandomPixel();            
            String binary = "" + ((this.stegoImage1DPix[pixel] >> 29)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 28)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 27)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 26)&0x01) +
                            "" + ((this.stegoImage1DPix[pixel] >> 25)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 24)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 21)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 20)&0x01);
            //System.out.println(binary);            
            if (binary.equals("00000011")){                
                break;
            }
            this.secretMessage += this.getCharacterValue(binary);
            
            binary = "" + ((this.stegoImage1DPix[pixel] >> 19)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 18)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 17)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 16)&0x01) +
                     "" + ((this.stegoImage1DPix[pixel] >> 13)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 12)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 11)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 10)&0x01);
            
            if (binary.equals("00000011")){       
                break;
            }
            this.secretMessage += this.getCharacterValue(binary);
            
            binary = "" + ((this.stegoImage1DPix[pixel] >> 9)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 8)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 5)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 4)&0x01) +
                     "" + ((this.stegoImage1DPix[pixel] >> 3)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 2)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 1)&0x01) + "" + ((this.stegoImage1DPix[pixel] >> 0)&0x01);
            
            if (binary.equals("00000011")){       
                break;
            }
            this.secretMessage += this.getCharacterValue(binary);
        }
    }
    
    private int getNextRandomPixel(){
        int pixelCount = this.stegoImage1DPix.length;
        int pixel = Math.abs(this.randomizer.nextInt())%pixelCount;
        while (this.randPixels.contains(pixel)){
            pixel = Math.abs(randomizer.nextInt())%pixelCount;
        }
        this.randPixels.add(pixel);
        return pixel;
    }
    
    private char getCharacterValue(String binary){
        int charVal = 0;
        for (int j = 7; j >= 0; --j){
            //charVal+=binary.charAt(7-j) * Math.pow(2.0, (double)j);
            if (binary.charAt(7-j) == '1'){
                charVal += Math.pow(2.0, (double)j);
            }
        }
        return (char)charVal;
    }
}
