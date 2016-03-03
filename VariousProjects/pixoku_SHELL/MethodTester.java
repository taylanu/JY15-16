//tester program to see if your invert and mirrorFlip methods work.
//use PixokiDriver program to test checkForWin
   public class MethodTester
   {
      public static void show(int[][]board)
      {
         for(int r=0; r<board.length; r++)
         {
            for(int c=0; c<board[0].length; c++)
               System.out.print(board[r][c]);
            System.out.println();
         }
         System.out.println();
      }
   
   
      public static void main(String[]arg)		//should display:	100
      {														//						011
         int[][]board = {{1,0,0},{0,1,1}};		//
         show(board);									//						011					
         show(Pixoku.invert(board));				//						100					
         show(Pixoku.mirrorFlip(board));			//						
      }														//						001
   }															//						110