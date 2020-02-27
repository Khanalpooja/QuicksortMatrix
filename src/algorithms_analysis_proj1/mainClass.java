
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
    static int[][] myNum1;
    static int[][] myNum2;
    static int[][] myNum;

    public static void main(String[] args) throws IOException {  
        inputMatrix();
        quickSortMethod1Obj();
        outToFile("method1", myNum1);

        quickSortMethod2Obj();
        outToFile("method2", myNum2);
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
    
    // Input the matrix from the input.txt file
    private static void inputMatrix() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("input.txt"));
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        System.out.print(String.format("The matrix is %d x %d \n", n1, n2));
        int[][] firstMatrix = new int[n1][n2];
        int[][] secondMatrix = new int[n1][n2];
        readMatrix(scanner, firstMatrix);
        readMatrix(scanner, secondMatrix);
        myNum1 = firstMatrix;
        myNum2 = secondMatrix;
    }
    
    private static void quickSortMethod1Obj() throws IOException {
        //create object for Method1
        assignmentCount = 0;
        comparisonCount = 0;
        temp = 0;
        quickSortMethod1 quick1 = new quickSortMethod1();

        for(int row = 0; row < myNum1.length; row++){
         quick1.QuickSortMethod1(myNum1,0, 9 ,5);
        }
        for(int[] arr: myNum1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Total Number of comparisions made for Method 1");
        System.out.println(comparisonCount);
        System.out.println("Total Number of assignments made for Method 1");
        System.out.println(assignmentCount);

    }
    
    
    private static void quickSortMethod2Obj() throws IOException {
//      create object for Method2
        assignmentCount = 0;
        comparisonCount = 0;
        temp = 0;
        quickSortMethod2 quick2 = new quickSortMethod2();
  
        for(int row = 0; row < myNum2.length; row++){
                quick2.QuickSortMethod2(myNum2,0,myNum2[0].length-1,row, true);
            }
            for(int col = 0; col < myNum2[0].length; col++){
                quick2.QuickSortMethod2(myNum2,0,myNum2.length-1,col, false);
            }
            for(int[] arr: myNum2) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("Total Number of comparisions made for Method 2");
            System.out.println(comparisonCount);
            System.out.println("Total Number of assignments made for Method 2");
            System.out.println(assignmentCount);
    }

    private static void outToFile(String method, int[][] inputArray) throws IOException{
        File outputMethod2 = new File("pk0050_"+method+".txt");
        outputMethod2.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputMethod2, false));
        for(int[] arr: inputArray) {
            for (int num: arr){

            writer.write(String.format("%8d", num));

            }
            writer.newLine();
        }
        writer.close();
    }
    
    
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
