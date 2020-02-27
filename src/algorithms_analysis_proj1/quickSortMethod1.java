
package algorithms_analysis_proj1;

import java.io.IOException;

/**
 *
 * @author Pooja Khanal
 */
public class quickSortMethod1 {
    
    public static void swapMethod1 (int Array[][], int i, int j, int noOfCol) 
    {
        int i_row = i / noOfCol;
        int i_col = i % noOfCol;
        int j_row = j / noOfCol;
        int j_col = j % noOfCol;
        mainClass.Assign(Array[i_row][i_col]);
        mainClass.Assign(Array, i_row, i_col, Array[j_row][j_col]);
        mainClass.Assign(Array, j_row, j_col, mainClass.temp);
    }
    public static int PartitionMethod1( int Array[][], int left , int right, int noOfCol ) throws IOException// pivot: first  element
    {
     
        int i,j;
        i = left + 1; 
        j = right;
        int left_row = left/noOfCol;
        int left_col = left % noOfCol;
        while(i  <= j){
            int i_row = i / noOfCol;
            int i_col = i % noOfCol;
            int j_row = j / noOfCol;
            int j_col = j % noOfCol;
            
            if (mainClass.GT(Array[left_row][left_col] , Array[i_row][i_col]))
            {    
                i++; 
            }
            else if(mainClass.LT( Array[left_row][left_col], Array[j_row][j_col]))
            {
                j--;   
            }
            else
            {
                swapMethod1(Array, i,j, noOfCol);
                i++;     
                j--;
            }
        }
        swapMethod1(Array, left,j, noOfCol);
        return j;
    }
    
    public static int[][] QuickSortMethod1( int Array[][], int left /*= 1*/, int right /*= n*/, int noOfCol) throws IOException
    {
        int pivot;
        if(left < right)
        {
            pivot = PartitionMethod1(Array, left , right, noOfCol);
            QuickSortMethod1(Array, left , pivot - 1, noOfCol);
            QuickSortMethod1(Array, pivot + 1, right, noOfCol);
        }
        return Array;
    }
}
