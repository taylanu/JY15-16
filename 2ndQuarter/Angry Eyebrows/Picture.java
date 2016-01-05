   import java.awt.*;
   import java.awt.font.*;
   import java.awt.geom.*;
   import java.awt.image.BufferedImage;
   import java.text.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2008
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
    public class Picture extends SimplePicture { 
   
   ///////////////////// constructors //////////////////////////////////
   
   /**
   * Constructor that takes no arguments 
   */
       public Picture () {
      
      /* not needed but use it to show students the implicit call to super()
      * child constructors always call a parent constructor 
      */
         super();  
      }
   
   /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
       public Picture(String fileName) {
      // let the parent class handle this fileName
         super(fileName);
      }
   
   /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
       public Picture(int width, int height) {
      // let the parent class handle this width and height
         super(width,height);
      }
   
   /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
       public Picture(Picture copyPicture) {
      // let the parent class do the copy
         super(copyPicture);
      }
   
   /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
       public Picture(BufferedImage image) {
         super(image);
      }
   
   ////////////////////// methods ///////////////////////////////////////
   
   /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
       public String toString() {
         String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
         return output;
      
      }
   
   /**
   * Class method to let the user pick a file name and then create the picture 
   * and show it
   * @return the picture object
   */
       public static Picture pickAndShow() {
         String fileName = FileChooser.pickAFile();
         Picture picture = new Picture(fileName);
         picture.show();
         return picture;
      }
   
   /**
   * Class method to create a picture object from the passed file name and 
   * then show it
   * @param fileName the name of the file that has a picture in it
   * @return the picture object
   */
       public static Picture showNamed(String fileName) {
         Picture picture = new Picture(fileName);
         picture.show();
         return picture;
      }
   
   /**
   * A method create a copy of the current picture and return it
   * @return the copied picture
   */
       public Picture copy()
      {
         return new Picture(this);
      }
   
   /**
   * Method to increase the red in a picture.
   */
       public void increaseRed() {
         Pixel [] pixelArray = this.getPixels();
         for (Pixel pixelObj : pixelArray) {
            pixelObj.setRed(pixelObj.getRed()*2);
         }
      }
   
   /**
   * Method to negate a picture
   */
       public void negate() {
         Pixel [] pixelArray = this.getPixels();
         int red,green,blue;
      
         for (Pixel pixelObj : pixelArray) {
            red = pixelObj.getRed();
            green = pixelObj.getGreen();
            blue = pixelObj.getBlue();
            pixelObj.setColor(new Color(255-red, 255-green, 255-blue));
         }
      }
   
   /**
   * Method to flip a picture 
   */
       public Picture flip() {
         Pixel currPixel = null;
         Pixel targetPixel = null;
         Picture target = 
            new Picture(this.getWidth(),this.getHeight());
      
         for (int srcX = 0, trgX = getWidth()-1; 
         srcX < getWidth();
         srcX++, trgX--) {
            for (int srcY = 0, trgY = 0; 
            srcY < getHeight();
            srcY++, trgY++) {
            
            // get the current pixel
               currPixel = this.getPixel(srcX,srcY);
               targetPixel = target.getPixel(trgX,trgY);
            
            // copy the color of currPixel into target
               targetPixel.setColor(currPixel.getColor());
            }
         }
         return target;
      }
   
   /**
   * Method to decrease the red by half in the current picture
   */
       public void decreaseRed() {
      
         Pixel pixel = null; // the current pixel
         int redValue = 0;       // the amount of red
      
      // get the array of pixels for this picture object
         Pixel[] pixels = this.getPixels();
      
      // start the index at 0
         int index = 0;
      
      // loop while the index is less than the length of the pixels array
         while (index < pixels.length) {
         
         // get the current pixel at this index
            pixel = pixels[index];
         // get the red value at the pixel
            redValue = pixel.getRed();
         // set the red value to half what it was
            redValue = (int) (redValue * 0.5);
         // set the red for this pixel to the new value
            pixel.setRed(redValue);
         // increment the index
            index++;
         }
      }
   
   /**
   * Method to decrease the red by an amount
   * @param amount the amount to change the red by
   */
       public void decreaseRed(double amount) {
      
         Pixel[] pixels = this.getPixels();
         Pixel p = null;
         int value = 0;
      
      // loop through all the pixels
         for (int i = 0; i < pixels.length; i++) {
         
         // get the current pixel
            p = pixels[i];
         // get the value
            value = p.getRed();
         // set the red value the passed amount time what it was
            p.setRed((int) (value * amount));
         }
      }
   
   /**
   * Method to compose (copy) this picture onto a target picture
   * at a given point.
   * @param target the picture onto which we copy this picture
   * @param targetX target X position to start at
   * @param targetY target Y position to start at
   */
       public void compose(Picture target, int targetX, int targetY) {
      
         Pixel currPixel = null;
         Pixel newPixel = null;
      
      // loop through the columns
         for (int srcX=0, trgX = targetX; srcX < this.getWidth();
         srcX++, trgX++) {
         
         // loop through the rows
            for (int srcY=0, trgY=targetY; srcY < this.getHeight();
            srcY++, trgY++) {
            
            // get the current pixel
               currPixel = this.getPixel(srcX,srcY);
            
            /* copy the color of currPixel into target,
            * but only if it'll fit.
            */
               if (trgX < target.getWidth() && trgY < target.getHeight()) {
                  newPixel = target.getPixel(trgX,trgY);
                  newPixel.setColor(currPixel.getColor());
               }
            }
         }
      }
   
   /**
   * Method to scale the picture by a factor, and return the result
   * @param factor the factor to scale by (1.0 stays the same,
   *    0.5 decreases each side by 0.5, 2.0 doubles each side)
   * @return the scaled picture
   */
       public Picture scale(double factor) {
      
         Pixel sourcePixel, targetPixel;
         Picture canvas = new Picture(
                                 (int) (factor*this.getWidth())+1,
                                 (int) (factor*this.getHeight())+1);
      // loop through the columns
         for (double sourceX = 0, targetX=0;
         sourceX < this.getWidth();
         sourceX+=(1/factor), targetX++) {
         
         // loop through the rows
            for (double sourceY=0, targetY=0;
            sourceY < this.getHeight();
            sourceY+=(1/factor), targetY++) {
            
               sourcePixel = this.getPixel((int) sourceX,(int) sourceY);
               targetPixel = canvas.getPixel((int) targetX, (int) targetY);
               targetPixel.setColor(sourcePixel.getColor());
            }
         }
         return canvas;
      }
   
   /**
   * Method to do chromakey using an input color for the background
   * and a point for the upper left corner of where to copy
   * @param target the picture onto which we chromakey this picture
   * @param bgColor the color to make transparent
   * @param threshold within this distance from bgColor, make transparent
   * @param targetX target X position to start at
   * @param targetY target Y position to start at
   */
       public void chromakey(Picture target, Color bgColor, int threshold,
                        int targetX, int targetY) {
      
         Pixel currPixel = null;
         Pixel newPixel = null;
      
      // loop through the columns
         for (int srcX=0, trgX=targetX;
         srcX<getWidth() && trgX<target.getWidth();
         srcX++, trgX++) {
         
         // loop through the rows
            for (int srcY=0, trgY=targetY;
            srcY<getHeight() && trgY<target.getHeight();
            srcY++, trgY++) {
            
            // get the current pixel
               currPixel = this.getPixel(srcX,srcY);
            
            /* if the color at the current pixel is within threshold of
            * the input color, then don't copy the pixel
            */
               if (currPixel.colorDistance(bgColor)>threshold) {
                  target.getPixel(trgX,trgY).setColor(currPixel.getColor());
               }
            }
         }
      }
   
    /**
   * Method to do chromakey assuming a blue background 
   * @param target the picture onto which we chromakey this picture
   * @param targetX target X position to start at
   * @param targetY target Y position to start at
   */
       public void blueScreen(Picture target,
                        int targetX, int targetY) {
      
         Pixel currPixel = null;
         Pixel newPixel = null;
      
      // loop through the columns
         for (int srcX=0, trgX=targetX;
         srcX<getWidth() && trgX<target.getWidth();
         srcX++, trgX++) {
         
         // loop through the rows
            for (int srcY=0, trgY=targetY;
            srcY<getHeight() && trgY<target.getHeight();
            srcY++, trgY++) {
            
            // get the current pixel
               currPixel = this.getPixel(srcX,srcY);
            
            /* if the color at the current pixel mostly blue (blue value is
            * greater than red and green combined), then don't copy pixel
            */
               if (currPixel.getRed() + currPixel.getGreen() > currPixel.getBlue()) {
                  target.getPixel(trgX,trgY).setColor(currPixel.getColor());
               }
            }
         }
      }
   
   /**
   * Method to change the picture to gray scale with luminance
   */
       public void grayscaleWithLuminance()
      {
         Pixel[] pixelArray = this.getPixels();
         Pixel pixel = null;
         int luminance = 0;
         double redValue = 0;
         double greenValue = 0;
         double blueValue = 0;
      
      // loop through all the pixels
         for (int i = 0; i < pixelArray.length; i++)
         {
         // get the current pixel
            pixel = pixelArray[i];
         
         // get the corrected red, green, and blue values
            redValue = pixel.getRed() * 0.299;
            greenValue = pixel.getGreen() * 0.587;
            blueValue = pixel.getBlue() * 0.114;
         
         // compute the intensity of the pixel (average value)
            luminance = (int) (redValue + greenValue + blueValue);
         
         // set the pixel color to the new color
            pixel.setColor(new Color(luminance,luminance,luminance));
         
         }
      }
   
   /** 
   * Method to do an oil paint effect on a picture
   * @param dist the distance from the current pixel 
   * to use in the range
   * @return the new picture
   */
       public Picture oilPaint(int dist) {
      
      // create the picture to return
         Picture retPict = new Picture(this.getWidth(),this.getHeight());
      
      // declare pixels
         Pixel currPixel = null;
         Pixel retPixel = null;
      
      // loop through the pixels
         for (int x = 0; x < this.getWidth(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
               currPixel = this.getPixel(x,y);
               retPixel = retPict.getPixel(x,y);
               retPixel.setColor(currPixel.getMostCommonColorInRange(dist));
            }
         }
         return retPict;
      }
   
       public static void main(String[] args)
      {
         Picture p = 
            new Picture(FileChooser.pickAFile());
         p.explore();
         Picture q = p.oilPaint(5);
         q.explore();
      }
        
   } // this } is the end of class Picture, put all new methods before this
