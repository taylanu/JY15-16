import java.awt.Color;

public class AngryEyebrows
{
   public static void main(String[] args)
   {       	
      String fName = "angrybirdwithouteyebrow.jpg";
      Picture picture = new Picture(fName);
      picture.show();
   	
      picture.getPixel(338,274).setColor(Color.black);
      picture.getPixel(339,274).setColor(Color.black);
      picture.getPixel(340,274).setColor(Color.black);
      picture.getPixel(341,274).setColor(Color.black);
      picture.getPixel(342,274).setColor(Color.black);
      picture.getPixel(343,274).setColor(Color.black);
      picture.getPixel(344,274).setColor(Color.black);
      picture.getPixel(345,274).setColor(Color.black);
      picture.getPixel(346,274).setColor(Color.black);
      picture.getPixel(347,274).setColor(Color.black);
      
      picture.explore();
   
   }
}