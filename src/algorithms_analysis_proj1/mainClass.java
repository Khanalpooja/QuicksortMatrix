
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
    static double temp; 
    static double[][] myArray1;
    static double[][] myArray2;


    public static void main(String[] args) throws IOException {  
        inputMatrix();
        
        quickSortMethod1Obj();
        outToFile("Method1", myArray1);

        quickSortMethod2Obj();
        outToFile("Method2", myArray2);
    }

    // Input the matrix from the input.txt file
    private static void inputMatrix() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File("input.txt"));
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        System.out.print(String.format("The matrix is %d x %d \n", n1, n2));
        double[][] firstMatrix = new double[n1][n2];
        double[][] secondMatrix = new double[n1][n2];
        readMatrix(scanner, firstMatrix);
        readMatrix(scanner, secondMatrix);
        myArray1 = firstMatrix;
        myArray2 = secondMatrix;
    }
    
    private static void readMatrix(final Scanner scanner, final double[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (scanner.hasNextInt()) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }
    }  
    
    private static void quickSortMethod1Obj() throws IOException {
        //create object for Method1
        assignmentCount = 0;
        comparisonCount = 0;
        temp = 0;
        quickSortMethod1 quick1 = new quickSortMethod1();

        for(int row = 0; row < myArray1.length; row++){
         quick1.QuickSortMethod1(myArray1,0, myArray1.length , myArray1[0].length);
        }
        System.out.println("The sorted Matrix from Method1 is:\n");
        for(double[] arr: myArray1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Total Number of comparisions made for Method 1 is:\t"+ comparisonCount);
        System.out.println("Total Number of assignments made for Method 1 is:\t"+ assignmentCount +"\n");
    }
    
    private static void quickSortMethod2Obj() throws IOException {
//      create object for Method2
        assignmentCount = 0;
        comparisonCount = 0;
        temp = 0;
        quickSortMethod2 quick2 = new quickSortMethod2();
  
        for(int row = 0; row < myArray2.length; row++){
                quick2.QuickSortMethod2(myArray2,0,myArray2[0].length-1,row, true);
        }
        for(int col = 0; col < myArray2[0].length; col++){
            quick2.QuickSortMethod2(myArray2,0,myArray2.length-1,col, false);
        }
        
        System.out.println("The sorted Matrix from Method1 is:\n");
        for(double[] arr: myArray2) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("Total Number of comparisions made for Method 2 is:\t"+ comparisonCount);
        System.out.println("Total Number of assignments made for Method 2 is:\t"+ assignmentCount+ "\n");
    }

    
    private static void outToFile(String method, double[][] inputArray) throws IOException{
        File outputMethod2 = new File("pk0050_"+ method +".txt");
        outputMethod2.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputMethod2, false));
        for(double[] arr: inputArray) {
            for (double num: arr){
            writer.write(String.format("%8.2f", num));
            }
            writer.newLine();
        }
        writer.close();
    }
    
    
    public static boolean EQ(double a, double b)
    {   
        comparisonCount++;
        if (a == b){
            return true;
        }
        else 
            return false; 
    }
    public static boolean LT(double a, double b)
    {   comparisonCount++;
        if (a < b){
            return true;
        }
        else 
            return false; 
    }
    public static boolean GT(double a, double b)
    {
        comparisonCount++;
        if (a > b){
            return true;
        }
        else 
            return false; 
    }

    public static void Assign(double[][] Array , int i, int j, double num){
        assignmentCount++;
        Array[i][j] = num;  
    }

    public static void Assign(double a){
        assignmentCount++;
        temp = a; 
    } 
}
