public class Substitute<anyType> 
{
   private int rows, cols, key;
   private anyType obj;
   
   public Substitute(int r, int c, int maxCol, anyType o)
   {
      rows = r;
      cols = c;
      key = r * maxCol + c;
      obj = o;
   }
   
   public int getRow()//returns the row of the object
   {
      return rows;
   }
   public int getCol()//returns the column of the object
   {
      return cols;
   }
   public int getKey()//returns the key of the object
   {
      return key;
   }
   public anyType getObj()//returns the value it stores
   {
      return obj;
   }
}