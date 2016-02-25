/*
 * hideSecretMessage.java
 *
 * Created on October 16, 2007, 2:04 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package my.steganography;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author asmel
 */
public class hideSecretMessage {
    private BufferedImage coverImage = null;
    private BufferedImage stegoImage = null;
    private String secretMessage = null;
    
    private int[] coverImage1DPix;
    private int[] stegoImage1DPix;
    private long key;
    private ArrayList randPixels = null;
    
    private Random randomizer=null;
    /** Creates a new instance of hideSecretMessage */
    public hideSecretMessage() {
    }
    
    public BufferedImage getCoverImage(){
        return this.coverImage;        
    }
    
    public String getsecretMessage(){
        return this.secretMessage;
    }
    
    public boolean setCoverImage(File imageFile){
        try{
            this.coverImage = ImageIO.read(imageFile);
        }catch(IOException ioe){
            ioe.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean setSecretMessage(String secMsg){
        this.secretMessage = secMsg;
        return true;
    }
    
    public boolean setSecretMessage(File secretFile){        
        BufferedReader br;
        this.secretMessage = "";
        try {
            br = new BufferedReader(new FileReader(secretFile));
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException ex) {                
                ex.printStackTrace();
                return false;
            }
                //System.out.println(""+line);
            while (line != null){
                this.secretMessage += (line + "\n");
                try {
                    line = br.readLine();
                } catch (IOException ex) {                        
                        //JOptionPane.showMessageDialog(this, "error io", "", JOptionPane.INFORMATION_MESSAGE);
                    ex.printStackTrace();
                    return false;
                }
            }                                       
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean hideMessage(long key, File f, int hidingMethod){             
        //Create a stegoimage array of pixels from coverimage
        this.key = key;
        int h = this.coverImage.getHeight();
        int w = this.coverImage.getWidth();
        int len = w*h;
        
        this.coverImage1DPix = new int[len];
        this.coverImage.getRGB(0, 0, w, h, this.coverImage1DPix, 0, w);
        
        this.stegoImage1DPix = new int[len];
        for (int i = 0; i < len; ++i){
            this.stegoImage1DPix[i] = this.coverImage1DPix[i];
        }
        //Hide the secret message in stegoimage array of pixels
        if (hidingMethod == 0) this.hide1();
        else if (hidingMethod == 1) this.hide2();
        else if (hidingMethod == 2) this.hide3();
        else this.hide4();
        
        //create stegoimage from the stegoimage array of pixels
        this.stegoImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        this.stegoImage.setRGB(0, 0, w, h, this.stegoImage1DPix, 0, w);
        
        //save the stegoimage to a file        
        try {
            ImageIO.write(this.stegoImage, "png", f);
        } catch (IOException ex) {
            ex.printStackTrace();       
            return false;
        }
        return true;
    }
    
    private void hide1(){       
        int[] orVal = {0x01000000, 0x00010000, 0x00000100, 0x00000001};
        int[] andVal= {0xFEFFFFFF, 0xFFFEFFFF, 0xFFFFFEFF, 0xFFFFFFFE};
        ///////////////////////////////
        int charCount = this.secretMessage.length();        
                       
        this.randomizer = new Random(this.key);
        int neededPixelCount = 2*charCount + 2;        
        this.randPixels = new ArrayList(neededPixelCount);
              
        int msgIndex;
        int pixel; 
        String binary;
        for (msgIndex = 0; msgIndex < this.secretMessage.length(); ++msgIndex){           
            int charVal = this.secretMessage.charAt(msgIndex);            
            binary = this.getBinaryString(charVal);
                        
            pixel = this.getNextRandomPixel();            
            for (int i = 0; i < 4; ++i){                
                if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= orVal[i];
                else this.stegoImage1DPix[pixel] &= andVal[i];
            }             
            
            pixel = this.getNextRandomPixel();            
            for (int i = 4; i < 8; ++i){
                if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= orVal[i%4];
                else this.stegoImage1DPix[pixel] &= andVal[i%4];
            }                                     
        }
        
        binary = "00000011";
        pixel = this.getNextRandomPixel();        
        for (int i = 0; i < 4; ++i){            
            if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= orVal[i];
            else this.stegoImage1DPix[pixel] &= andVal[i];
        }
        
        pixel = this.getNextRandomPixel();                   
        for (int i = 4; i < 8; ++i){
            if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= orVal[i%4];
            else this.stegoImage1DPix[pixel] &= andVal[i%4];
        }
        //System.out.println(this.randPixels);
    }        
    
    private void hide2(){
        int[] orValEven = {0x02000000, 0x00020000, 0x00000200, 0x00000002};
        int[] andValEven= {0xFDFFFFFF, 0xFFFDFFFF, 0xFFFFFDFF, 0xFFFFFFFD};
        
        int[] orValOdd = {0x01000000, 0x00010000, 0x00000100, 0x00000001};
        int[] andValOdd= {0xFEFFFFFF, 0xFFFEFFFF, 0xFFFFFEFF, 0xFFFFFFFE};

        int charCount = this.secretMessage.length();        
                       
        this.randomizer = new Random(this.key);
        int neededPixelCount = charCount + 1;        
        this.randPixels = new ArrayList(neededPixelCount);
              
        int msgIndex;
        int pixel; 
        String binary;
        for (msgIndex = 0; msgIndex < this.secretMessage.length(); ++msgIndex){           
            int charVal = this.secretMessage.charAt(msgIndex);            
            binary = this.getBinaryString(charVal);
                        
            pixel = this.getNextRandomPixel();            
            for (int i = 0; i < 8; i+=2){                
                char temp = binary.charAt(i);
                if (temp == '1') {
                    int shift = orValEven[i/2];
                    this.stegoImage1DPix[pixel] |= shift; 
                }
                else{
                    int shift = andValEven[(i)/2];
                    this.stegoImage1DPix[pixel] &= shift; 
                }
            }             
            
            //pixel = this.getNextRandomPixel();            
            for (int i = 1; i < 8; i+=2){
                if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= orValOdd[i/2];
                else this.stegoImage1DPix[pixel] &= andValOdd[i/2];
            }                                     
        }
        
        binary = "00000011";
        pixel = this.getNextRandomPixel();        
        for (int i = 0; i < 8; i+=2){            
            if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= orValEven[i/2];
            else this.stegoImage1DPix[pixel] &= andValEven[i/2];
        }
        
        //pixel = this.getNextRandomPixel();            
        for (int i = 1; i < 8; i+=2){
            if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= orValOdd[i/2];
            else this.stegoImage1DPix[pixel] &= andValOdd[i/2];
        }
    }
    
    private void hide3(){
        int[] orVal = {0x08000000, 0x04000000, 0x02000000, 0x01000000}; 
        int[] andVal= {0xF7FFFFFF, 0xFBFFFFFF, 0xFDFFFFFF, 0xFEFFFFFF};
       
        int charCount = this.secretMessage.length();        
                       
        this.randomizer = new Random(this.key);
        int neededPixelCount = charCount + 1;        
        this.randPixels = new ArrayList(neededPixelCount);
        
       
        int msgIndex;
        String binary;
        int pixel = 0;
        boolean odd = false;
        
        for (msgIndex = 0; msgIndex < this.secretMessage.length(); msgIndex+=2){
            pixel = this.getNextRandomPixel();
            int charVal = this.secretMessage.charAt(msgIndex);            
            binary = this.getBinaryString(charVal);
            for (int i = 0; i < 8; ++i){
                char temp = binary.charAt(i);
                if (temp == '1') 
                    this.stegoImage1DPix[pixel] |= (orVal[i%4] >> (8*(i/4)));
                else 
                    this.stegoImage1DPix[pixel] &= (andVal[i%4] >> (8*(i/4)));
            }
            
            if (msgIndex + 1 >= this.secretMessage.length()){
                odd = true;
                break;
            }
            
            charVal = this.secretMessage.charAt(msgIndex + 1);            
            binary = this.getBinaryString(charVal);
            for (int i = 0; i < 8; ++i){
                if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= (orVal[i%4] >> (16 + 8*(i/4)));
                else this.stegoImage1DPix[pixel] &= (andVal[i%4] >> (16 + 8*(i/4)));
            }
        }
        
        binary = "00000011";
        if (odd){
            for (int i = 0; i < 8; ++i){
                if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= (orVal[i%4] >> (16 + 8*(i/4)));
                else this.stegoImage1DPix[pixel] &= (andVal[i%4] >> (16 + 8*(i/4)));
            }
        }else{
            pixel = this.getNextRandomPixel();        
            for (int i = 0; i < 8; ++i){
                if (binary.charAt(i) == '1') this.stegoImage1DPix[pixel] |= (orVal[i%4] >> (8*(i/4)));
                else this.stegoImage1DPix[pixel] &= (andVal[i%4] >> (8*(i/4)));
            }
        }                
    }
    
    private void hide4(){//6 bits of 8
        int[] orValChar1 = {0x02000000, 0x01000000, 0x08000000, 0x04000000, 0x02000000, 0x01000000, 0x00200000, 0x00100000};        
        int[] andValChar1 ={0xdfffffff, 0xefffffff, 0xf7ffffff, 0xfbffffff, 0xfdffffff, 0xfeffffff, 0xffdfffff, 0xffefffff};
        
        int[] orValChar2 = {0x00080000, 0x00040000, 0x00020000, 0x00010000, 0x00002000, 0x00001000, 0x00000800, 0x00000400};
        int[] andValChar2 ={0xfff7ffff, 0xfffbffff, 0xfffdffff, 0xfffeffff, 0xffffdfff, 0xffffefff, 0xfffff7ff, 0xfffffbff};
        
        int[] orValChar3 = {0x00000200, 0x00000100, 0x00000020, 0x00000010, 0x00000008, 0x00000004, 0x00000002, 0x00000001};
        int[] andValChar3= {0xfffffdff, 0xfffffeff, 0xffffffdf, 0xffffffef, 0xfffffff7, 0xfffffffb, 0xfffffffd, 0xfffffffe};
        
        int charCount = this.secretMessage.length();        
                       
        this.randomizer = new Random(this.key);
        int neededPixelCount = charCount / 3;        
        this.randPixels = new ArrayList(neededPixelCount);
               
        int msgIndex;
        String binary;
        int pixel = 0;
        
        for (msgIndex = 0; msgIndex < this.secretMessage.length(); msgIndex+=3){
            pixel = this.getNextRandomPixel();//same pixel for all 3 chars
            //char1
            int charVal = this.secretMessage.charAt(msgIndex);            
            binary = this.getBinaryString(charVal);
            
            for (int i = 0; i < 8; ++i){
                char temp = binary.charAt(i);
                if (temp == '1'){
                    this.stegoImage1DPix[pixel] |= orValChar1[i];
                }else{
                    this.stegoImage1DPix[pixel] &= andValChar1[i];
                }
            }
            
            if (msgIndex + 1 >= this.secretMessage.length()){
                //no new pixel needed
                binary = "00000011";
                for (int i = 0; i < 8; ++i){
                    char temp = binary.charAt(i);
                    if (temp == '1'){
                        this.stegoImage1DPix[pixel] |= orValChar2[i];
                    }else{
                        this.stegoImage1DPix[pixel] &= andValChar2[i];
                    }                                
                }
                break;
            }
            //char2
            charVal = this.secretMessage.charAt(msgIndex + 1);            
            binary = this.getBinaryString(charVal);
            
            for (int i = 0; i < 8; ++i){
                char temp = binary.charAt(i);
                if (temp == '1'){
                    this.stegoImage1DPix[pixel] |= orValChar2[i];
                }else{
                    this.stegoImage1DPix[pixel] &= andValChar2[i];
                }
            }
            
            if (msgIndex + 2 >= this.secretMessage.length()){
                //no new pixel needed
                binary = "00000011";
                for (int i = 0; i < 8; ++i){
                    char temp = binary.charAt(i);
                    if (temp == '1'){
                        this.stegoImage1DPix[pixel] |= orValChar3[i];
                    }else{
                        this.stegoImage1DPix[pixel] &= andValChar3[i];
                    }                                
                }
                break;
            }
            
            //char3
            charVal = this.secretMessage.charAt(msgIndex + 2);            
            binary = this.getBinaryString(charVal);
            
            for (int i = 0; i < 8; ++i){
                char temp = binary.charAt(i);
                if (temp == '1'){
                    this.stegoImage1DPix[pixel] |= orValChar3[i];
                }else{
                    this.stegoImage1DPix[pixel] &= andValChar3[i];
                }
            }
        }
        
        //if all part of the previous pixel consumed
        if (msgIndex + 2 >= this.secretMessage.length()){
            pixel = this.getNextRandomPixel();
            binary = "00000011";
            for (int i = 0; i < 8; ++i){
                char temp = binary.charAt(i);
                if (temp == '1'){
                    this.stegoImage1DPix[pixel] |= orValChar1[i];
                }else{
                    this.stegoImage1DPix[pixel] &= andValChar1[i];
                }                                
            }
        }
        
    }        
    
    private int getNextRandomPixel(){
        int pixelCount = this.coverImage1DPix.length;
        int pixel = Math.abs(this.randomizer.nextInt())%pixelCount;
        while (this.randPixels.contains(pixel)){
            pixel = Math.abs(randomizer.nextInt())%pixelCount;
        }
        this.randPixels.add(pixel);
        return pixel;
    }
    
    private String getBinaryString(int charVal){
        String binary="";
        for (int i = 7; i >= 0; --i){
            if (((charVal >> i) & 0x01) == 1){                  
                binary+="1";
            }else                    
                binary+="0";
        }
        return binary;
    }
}
