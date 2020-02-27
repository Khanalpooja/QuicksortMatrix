
/* 
Submitted by: Pooja Khanal, A25288740 
Design/Analysis of Algorithms, CS317-01 , Spring 2020
submitted on: 02/27,2020 

 program to rearrange a given 'r * c' (r - rows, c - columns) matrix as follows:
- each row is sorted in non-decreasing order
- each column is sorted in non-decreasing order

Class for QuickSort implementation using Method 2. 
Method2 :   Sort each row separately one-by-one.
            Then, sort each column separately one-by-one.
            Output this matrix.

*/

/*
 * @author Pooja Khanal
 */
package algorithms_analysis_proj1;

import java.io.IOException;

public class quickSortMethod2 {
    
    // Swap elements in a row for Method2
    //Reference taken from lecture notes UAH/CS317-Sadish Sadasivam
    public static void swapRow (double Array[][], int i, int j, int row) 
    {
        compAssign.Assign(Array[row][i]);
        compAssign.Assign(Array, row, i, Array[row][j]);
        compAssign.Assign(Array, row, j, mainClass.temp);
    }
    
    // Swap elements in a colunm for Method2
    //Reference taken from lecture notes UAH/CS317-Sadish Sadasivam
    public static void swapCol (double Array[][], int i, int j, int col) 
    {
        compAssign.Assign(Array[i][col]);
        compAssign.Assign(Array, i, col, Array[j][col]);
        compAssign.Assign(Array, j, col, mainClass.temp);
    }
    
    //Partition each rows for Method2
    //Reference taken from lecture notes UAH/CS317-Sadish Sadasivam
    //pivot as first element in the row
    public static int PartitionRows( double Array[][], int left , int right, int row) throws IOException
    {
        int i,j =0; 
        i = left + 1; 
        j = right;

        while(i  <= j){

            if(compAssign.GT(Array[row][left],Array[row][i]))
            {    
                i++;

            }
            else if(compAssign.LT(Array[row][left],Array[row][j]))
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
    
    //partition each colum for method2
    //Reference taken from lecture notes UAH/CS317-Sadish Sadasivam
    // pivot as first element in the column
    public static int PartitionCols(double Array[][], int left , int right, int col) throws IOException
    {
        int i,j =0; 

        i = left + 1; 
        j = right;

        while(i  <= j){

            if(compAssign.GT(Array[left][col],Array[i][col]))
            {    
                i++;
            }
            else if(compAssign.LT( Array[left][col], Array[j][col]))
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
    
    // Quicksort method implementation for sorting Row wise and then sorting column wise for the given matrix
    // Reference taken from lecture notes UAH/CS317-Sadish Sadasivam
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
