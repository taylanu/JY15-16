import java.awt.Color;

public class AngryEyebrows
{
   public static void main(String[] args)
   {
      String fName = "angrybirdwithouteyebrow.jpg";
      Picture picture = new Picture(fName);
      // picture.show(); Uncomment when want to show image as well

      // int[]xvals = new int[10];
      // int[]yvals = new int[10];
   	picture.getPixel(275,275).setColor(Color.red);
   	picture.getPixel(392,281).setColor(new Color(255,0,255));

   //LEFT BROW
   	for(int x=0;x<=75;x++){
		for(int y=0;y<=26;y++){
		int randr = (int)(Math.random()*255)+1;
		int randg = (int)(Math.random()*255)+1;
		int randb = (int)(Math.random()*255)+1;

		picture.getPixel(255+x,200+y+x).setColor(new Color(randr,randg,randb));
		}
	}
	//RIGHT BROW
	for(int x=0;x<=75;x++){
		for(int y=0;y<=26;y++){
		int randr = (int)(Math.random()*255)+1;
		int randg = (int)(Math.random()*255)+1;
		int randb = (int)(Math.random()*255)+1;

		picture.getPixel(352+x,273+y-x).setColor(new Color(randr,randg,randb));
		}
	}
   	/*
      picture.getPixel(338,273).setColor(Color.black);
      picture.getPixel(339,273).setColor(Color.black);
      picture.getPixel(340,273).setColor(Color.black);
      picture.getPixel(341,273).setColor(Color.black);
      picture.getPixel(342,273).setColor(Color.black);
      picture.getPixel(343,273).setColor(Color.black);
      picture.getPixel(344,273).setColor(Color.black);
      picture.getPixel(345,273).setColor(Color.black);
      picture.getPixel(346,273).setColor(Color.black);
      picture.getPixel(347,273).setColor(Color.black);
    */
      picture.explore();         //allows to search color by pixel
  }
}
