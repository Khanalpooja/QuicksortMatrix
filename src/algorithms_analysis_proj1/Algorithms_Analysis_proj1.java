/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms_analysis_proj1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 *
 * @author owner
 */
public class Algorithms_Analysis_proj1 {

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) throws FileNotFoundException { 
//    quicksort qui;    
   
    
    
//    double[][] myDouble = new double[1000][1000];
//		int x=0, y=0;
//                
//		try
//        {
//        try (BufferedReader in = new BufferedReader(new FileReader("input.txt")) //reading files in specified directory
//        ) {
//            String line;
//            while ((line = in.readLine()) != null)	//file reading
//            {
//                String[] values = line.split(" ");
//                for (String str : values)
//                {
//                    double str_double = Double.parseDouble(str);
//                    myDouble[x][y]=str_double;
//                    System.out.print(myDouble[x][y] + " ");
//                }
//                System.out.println("");

            try{
                            quickSort quick = new quickSort();
                            int[] myNum = {3, 200, 30, 4};
                            System.out.println(Arrays.toString(myNum));
                            quick.QuickSort_main(myNum,0,3);
            }
            catch ( IOException ioException){}
            //	        	x=x+1;
//            }
//        }
//        }catch( IOException ioException ) {}
        
        
    }
}
