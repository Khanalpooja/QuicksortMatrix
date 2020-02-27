
package algorithms_analysis_proj1;

import java.io.IOException;

/**
 *
 * @author Pooja Khanal
 */
public class quickSortMethod2 {
    
    public static void swapRow (double Array[][], int i, int j, int row) 
    {
        mainClass.Assign(Array[row][i]);
        mainClass.Assign(Array, row, i, Array[row][j]);
        mainClass.Assign(Array, row, j, mainClass.temp);
    }
    
    public static void swapCol (double Array[][], int i, int j, int col) 
    {
        mainClass.Assign(Array[i][col]);
        mainClass.Assign(Array, i, col, Array[j][col]);
        mainClass.Assign(Array, j, col, mainClass.temp);
    }
    
    public static int PartitionRows( double Array[][], int left , int right, int row) throws IOException// pivot: first  element
    {
        int i,j =0; 
        i = left + 1; 
        j = right;

        while(i  <= j){

            if(mainClass.GT(Array[row][left],Array[row][i]))
            {    
                i++;

            }
            else if(mainClass.LT(Array[row][left],Array[row][j]))
            {
                j--;

            }
            else
            {
                swapRow(Array, i,j, row);
                i++;     
                j--;
            }
        }
        swapRow(Array, left,j, row);
        return j;
    }
    
    public static int PartitionCols(double Array[][], int left , int right, int col) throws IOException// pivot: first  element
    {
        int i,j =0; 

        i = left + 1; 
        j = right;

        while(i  <= j){

            if(mainClass.GT(Array[left][col],Array[i][col]))
            {    
                i++;
            }
            else if(mainClass.LT( Array[left][col], Array[j][col]))
            {
                j--;

            }
            else
            {
                swapCol(Array, i,j, col);
                i++;     
                j--;
            }
        }
        swapCol(Array, left,j, col);
        return j;
    }
    
    public static double[][] QuickSortMethod2( double Array[][], int left /*= 1*/, int right /*= n*/, int rc, boolean row) throws IOException
    {
           int pivot;
           if(left < right)
           {
               if (row) {
                   pivot = PartitionRows(Array, left , right, rc);
                    QuickSortMethod2(Array, left , pivot - 1, rc, row);
                    QuickSortMethod2(Array, pivot + 1, right, rc, row);
               } else {
                   pivot = PartitionCols(Array, left , right, rc);
                    QuickSortMethod2(Array, left , pivot - 1, rc, row);
                    QuickSortMethod2(Array, pivot + 1, right, rc, row);
               }   
           }      
        return Array;
    }
}
