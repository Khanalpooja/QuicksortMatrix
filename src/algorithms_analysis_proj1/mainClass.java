
package algorithms_analysis_proj1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File; 
import java.io.*;
/**
 *
 * @author Pooja Khanal
 */
public class mainClass {
    static int comparisonCount; 
    static int assignmentCount;
    static int temp; 

    public static void main(String[] args) throws FileNotFoundException { 

       try{
            quickSortMethod1 quick1 = new quickSortMethod1();
            quickSortMethod2 quick2 = new quickSortMethod2();

            Scanner scanner = new Scanner(new File("input.txt"));
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            System.out.print(String.format("The matrix is %d x %d \n", n1, n2));
            int[][] firstMatrix = new int[n1][n2];

            readMatrix(scanner, firstMatrix);
            int[][] myNum = firstMatrix;
            
//            for(int row = 0; row < myNum.length; row++){
             quick1.QuickSortMethod1(myNum,0, 10 ,9);
             
             for(int[] arr: myNum) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(comparisonCount);
            System.out.println(assignmentCount);
//            }
            
//            for(int row = 0; row < myNum.length; row++){
//                quick2.QuickSortMethod2(myNum,0,myNum[0].length-1,row, true);
//            }
//            for(int col = 0; col < myNum[0].length; col++){
//                quick2.QuickSortMethod2(myNum,0,myNum.length-1,col, false);
//            }
//            for(int[] arr: myNum) {
//                System.out.println(Arrays.toString(arr));
//            }
//            System.out.println(comparisonCount);
//            System.out.println(assignmentCount);

            File outputMethod2 = new File("pk0050_Method2.txt");
            outputMethod2.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputMethod2, false));
            for(int[] arr: myNum) {
                for (int num: arr){

                writer.write(String.format("%8d", num));

                }
                writer.newLine();
            }
            writer.close();

       }
       catch ( IOException ioException){
           System.out.println("File not found");
       }        
    }

    private static void readMatrix(final Scanner scanner, final int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (scanner.hasNextInt()) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }
    }
//
//    private static void displayMatrix(final int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }


    public static boolean EQ(int a, int b)
    {   
        comparisonCount++;
        if (a == b){
            return true;
        }
        else 
            return false; 
    }
    public static boolean LT(int a, int b)
    {   comparisonCount++;
        if (a < b){
            return true;
        }
        else 
            return false; 
    }
    public static boolean GT(int a, int b)
    {
        comparisonCount++;
        if (a > b){
            return true;
        }
        else 
            return false; 
    }

    public static void Assign(int[][] Array , int i, int j, int num){
        assignmentCount++;
        Array[i][j] = num;  
    }

    public static void Assign(int a){
        assignmentCount++;
        temp = a; 
    } 
}
