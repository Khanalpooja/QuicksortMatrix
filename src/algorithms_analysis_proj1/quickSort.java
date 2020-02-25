/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms_analysis_proj1;

import java.io.IOException;
import java.util.*;


/**
 *
 * @author Pooja Khanal
 */
public class quickSort {
    
    public static void swap (int Array[], int i, int j) 
    {
      int temp = Array[i];
      Array[i] = Array[j];
      Array[j] = temp;
    }
    public static void swapMethod1 (int Array[][], int i, int j, int noOfCol) 
    {
        int i_row = i / noOfCol;
        int i_col = i % noOfCol;
        int j_row = j / noOfCol;
        int j_col = j % noOfCol;
        int temp = Array[i_row][i_col];
        Array[i_row][i_col] = Array[j_row][j_col];
        Array[j_row][j_col] = temp;
    }
    
    public static void swapRow (int Array[][], int i, int j, int row) 
    {

        int temp = Array[row][i];
        Array[row][i] = Array[row][j];
        Array[row][j] = temp;
    }
    
    public static void swapCol (int Array[][], int i, int j, int col) 
    {

        int temp = Array[i][col];
        Array[i][col] = Array[j][col];
        Array[j][col] = temp;
    }
    
    
    public static int Partition( int Array[], int left , int right) throws IOException// pivot: first  element
    {
        int i,j;
        i = left + 1; 
        j = right;
        while(i  <= j){
            if(Array[i] <= Array[left])
            {    
                i++;
            }
            else if(Array[j]  >= Array[left])
            {
                j--;
            }
            else
            {
                swap(Array, i, j);
                i++;     
                j--;
            }
        }
        swap(Array, left,j);
        return j;
    }
    
    public static int PartitionMethod1( int Array[][], int left , int right, int noOfCol ) throws IOException// pivot: first  element
    {
        //Row
        // i
        // 0 -> row
        // row = True
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
            
            if(Array[i_row][i_col] <= Array[left_row][left_col])
            {    
                i++;
               
            }
            else if(Array[j_row][j_col]  >= Array[left_row][left_col])
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
    
    
    public static int[] QuickSort_main( int Array[], int left /*= 1*/, int right /*= n*/) throws IOException
    {
        
        int pivot;
        if(left < right)
        {
            pivot = Partition(Array, left , right);
            QuickSort_main(Array, left , pivot - 1);
            QuickSort_main(Array, pivot + 1, right);
            System.out.println(Arrays.toString(Array));   
        }
        
        return Array;
    }
    
    public static int[][] QuickSort_main_Method1( int Array[][], int left /*= 1*/, int right /*= n*/, int noOfCol) throws IOException
    {
        
        int pivot;
        if(left < right)
        {
            pivot = PartitionMethod1(Array, left , right, noOfCol);
            QuickSort_main_Method1(Array, left , pivot - 1, noOfCol);
            QuickSort_main_Method1(Array, pivot + 1, right, noOfCol);
        }
        return Array;
    }
    
    
    public static int PartitionRows( int Array[][], int left , int right, int row) throws IOException// pivot: first  element
    {
                int i,j =0; 
     
                i = left + 1; 
                j = right;
                
                while(i  <= j){

                    if(Array[row][i] <= Array[row][left])
                    {    
                        i++;

                    }
                    else if(Array[row][j]  >= Array[row][left])
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
    
    public static int PartitionCols( int Array[][], int left , int right, int col) throws IOException// pivot: first  element
    {
                int i,j =0; 
     
                i = left + 1; 
                j = right;
                
                while(i  <= j){

                    if(Array[i][col] <= Array[left][col])
                    {    
                        i++;
                    }
                    else if(Array[j][col]  >= Array[left][col])
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
    
    public static int[][] QuickSortMethod2( int Array[][], int left /*= 1*/, int right /*= n*/, int rc, boolean row) throws IOException
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
