package proj103_4;

import javax.swing.*;

   public class ShellDriver{
      public static void main(String[] args){

         JFrame Frame = new JFrame("Shell");

         Frame.setSize(500, 500);
         Frame.setLocation(100, 50);
         Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Frame.setContentPane(new ShellPanel());
         Frame.setVisible(true);
      }
   }