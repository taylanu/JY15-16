import java.util.Scanner;

public class MagicSquare {
    public static void main(String arg[]) {

        Scanner input = new Scanner(System.in);
        int[][] square = new int[4][4];
        int row0 = 0, row1 = 0, row2 = 0, row3 = 0;//ROWS
        int col0 = 0, col1 = 0, col2 = 0, col3 = 0;//COLUMNS
        int dia1 = 0, dia0 = 0;//DIAGONALS

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("Enter an integer for the Magic Square");
                square[i][j] = input.nextInt();
            }
        }
        //ROWS
        row0 = rowCheck(0, square);
        row1 = rowCheck(1, square);
        row2 = rowCheck(2, square);
        row3 = rowCheck(3, square);
        //COLUMNS
        col0 = colCheck(0, square);
        col1 = colCheck(1, square);
        col2 = colCheck(2, square);
        col3 = colCheck(3, square);
        //DIAGONALS
        for (int i = 0; i <= 3; i++) {
            dia0 += square[i][i];
        }
        for (int i = 0; i <= 3; i++) {
            dia1 += square[i][3 - i];
        }

        if (row0 == row1 && row1 == row2 && row2 == row3 && row3 == col0 &&
                col0 == col1 && col1 == col2 && col2 == col3 && col3 == dia0 && dia0 == dia1) {
            System.out.println();
            System.out.println("You got it! Your magic number is " + row0);
        } else {
            System.out.println("Unfortunately your values do not make a magic square.");
        }
        //PRINT SQUARE
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(square[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int rowCheck(int row, int[][] list) {
        int sum = 0;
        for (int i = 0; i < list.length; i++)
            sum += list[row][i];
        return sum;
    }

    public static int colCheck(int col, int[][] list) {
        int sum = 0;
        for (int i = 0; i < list[0].length; i++)
            sum += list[i][col];
        return sum;
    }
}//END ALL
