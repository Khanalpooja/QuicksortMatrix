
package algorithms_analysis_proj1;

import java.io.IOException;
import java.util.*;


/**
 *
 * @author Pooja Khanal
 */
public class quickSortGeneric {
    
    public static void swap (int Array[], int i, int j) 
    {
      int temp = Array[i];
      Array[i] = Array[j];
      Array[j] = temp;
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
}