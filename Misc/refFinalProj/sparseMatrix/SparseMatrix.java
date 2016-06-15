import java.util.ArrayList;
public class SparseMatrix<anyType> implements Matrixable<anyType>
{
   private int maxRows, maxCols;
   private ArrayList<Substitute<anyType>> list;
   
   public SparseMatrix(int r, int c)
   {
      maxRows = r;
      maxCols = c;
      list = new ArrayList<Substitute<anyType>>();
   }
   public int numRows()//how many rows?
   {
      return maxRows;
   }
   public int numColumns()//how many columns?
   {
      return maxCols;
   }
   public int size()//total number of spaces
   {
      return maxRows * maxCols;
   }
   public int getFirstRow()//Gets the row of the first item in the matrix
   {
      return list.get(0).getRow();
   }
   public int getFirstCol()//Get the column of the first item in the matrix
   {
      return list.get(0).getCol();
   }
   public anyType get(int r, int c)//finds the object with the specified (r,c)
   {
      int key = r * maxCols + c;
      for(int i = 0; i < list.size(); i++)
      {
         if(key == ((Substitute)list.get(i)).getKey())
         {
            return (anyType)list.get(i).getObj();
         } 
      }
      return null;
   }
   
   public anyType set(int r, int c, anyType x)//Sets the object at (r,c) to x
   {
      Substitute tute = new Substitute(r, c, maxCols, x);
      int key = r * maxCols + c;
      for(int i = 0; i < list.size(); i++)
      {
         if(key == ((Substitute)list.get(i)).getKey())
         {
            Object sub = list.get(i).getObj();
            list.set(i, tute);
            return (anyType)(sub);
         } 
      }
      return null;
   }
   public boolean add(int r, int c, anyType x)//Adds x into the matrix at point (r,c)
   {
      Substitute sub = new Substitute(r, c, maxCols, x);
      int key = r * maxCols + c;
      for(int i = 0; i < list.size(); i++)
      {
         if(key <= ((Substitute)list.get(i)).getKey())
         {
            list.add(i, sub);
            return true;
         } 
      }
      list.add(sub);
      return true;
   }
   public anyType remove(int r, int c)//Deletes the item at (r,c) but returns whatever was there
   {
      int key = r * maxCols + c;
      for(int i = 0; i < list.size(); i++)
      {
         if(key == ((Substitute)list.get(i)).getKey())
         {
            Object temp = list.get(i).getObj();
            list.remove(i);
            return (anyType)temp;
         } 
      }
      return null;
   }
   
   public boolean contains(anyType x)//checks if x is anywehere in the matrix
   {
      for(int i = 0; i < list.size(); i++)
      {
         if(x.equals(list.get(i).getObj()))
         {
            return true;
         }
      }
      return false;
   }
   
   public int[] getLocation(anyType x)// Returns the (r,c) of x
   {
      int[] location = new int[2];
      if(!contains(x))
      {
         return null;
      }
      else
      {
         for(int i = 0; i < list.size(); i++)
         {
            if(x.equals(list.get(i).getObj()))
            {
               location[0] = list.get(i).getRow();
               location[1] = list.get(i).getCol();
            }
         }
      }
      return location;
   }
   
   public Object[][] toArray()//Rewrites the sparsematrix as a 2d array
   {
      Object[][] array = new Object[maxRows][maxCols];
      for(int r = 0; r < maxRows; r++)
      {
         for(int c = 0; c < maxCols; c++)
         {
            if(has(r,c))
            {
               array[r][c] = get(r,c);
            }
            else
            {
               array[r][c] = null;
            }
         }
      }  
      return array;
   }
   
   public boolean isEmpty()//Is there any object in here?
   {
      if(list.size() == 0)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public void clear()//Erases everything
   {
      for(int r = 0; r < maxRows; r++)
      {
         for(int c = 0; c < maxCols; c++)
         {
            remove(r,c);
         }
      }      
   }
   
   public boolean has(int r, int c)//Is there any object at this point?
   {
      int key = r * maxCols + c;
      for(int i = 0; i < list.size(); i++)
      {
         if(key == ((Substitute)list.get(i)).getKey())
         {
            return true;
         } 
      }
      return false;
   
   }
   public String toString()//Prints out a 2d form of the array
   {
      String str = "";
      for(int r = 0; r < maxRows; r++)
      {
         for(int c = 0; c < maxCols; c++)
         {
            int index = -1;
            for(int i = 0; i < list.size(); i++)
            {
               if(r * maxCols + c == ((Substitute)list.get(i)).getKey())
               {
                  str += ((Substitute)list.get(i)).getObj();
                  index = i;
               }
            }
            if(index == -1)
            {
               str += "-";
            }
            str += "\t";
         }
         str += "\n";
      }
      return str;
   }
}