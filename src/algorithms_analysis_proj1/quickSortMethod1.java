
/* 
Submitted by: Pooja Khanal, A25288740 
Design/Analysis of Algorithms, CS317-01 , Spring 2020
submitted on: 02/27,2020 

 program to rearrange a given 'r * c' (r - rows, c - columns) matrix as follows:
- each row is sorted in non-decreasing order
- each column is sorted in non-decreasing order

Class for QuickSort implementation using Method 1. 
Method 1:   Take all the 'r*c' elements in an array, 
            sort it, then output row-wise as a 'r*c' matrix.
*/

/*
 * @author Pooja Khanal
 */

package algorithms_analysis_proj1;

import java.io.IOException;

public class quickSortMethod1 {
    
    
    // Method to Swap elements in the Array
    public static void swapMethod1 (double Array[][], int i, int j, int noOfCol) 
    {
        int i_row = i / noOfCol;
        int i_col = i % noOfCol;
        int j_row = j / noOfCol;
        int j_col = j % noOfCol;
        compAssign.Assign(Array[i_row][i_col]);
        compAssign.Assign(Array, i_row, i_col, Array[j_row][j_col]);
        compAssign.Assign(Array, j_row, j_col, mainClass.temp);
    }
    
    
    // Method to partition using the first element as pivot
    // Reference taken from lecture notes of UAH/CS317
    public static int PartitionMethod1( double Array[][], int left , int right, int noOfCol ) throws IOException
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
            
            if (compAssign.GT(Array[left_row][left_col] , Array[i_row][i_col]))
            {    
                i++; 
            }
            else if(compAssign.LT( Array[left_row][left_col], Array[j_row][j_col]))
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
    
    //QuickSort implementation using Method1
    //Reference taken from lecture notes UAH/CS317-Sadish Sadasivam
    
    public static double[][] QuickSortMethod1( double Array[][], int left /*= 1*/, int right /*= n*/, int noOfCol) throws IOException
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
