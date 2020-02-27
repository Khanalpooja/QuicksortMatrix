

/* 
Submitted by: Pooja Khanal, A25288740 
Design/Analysis of Algorithms, CS317-01 , Spring 2020
submitted on: 02/27,2020 

 program to rearrange a given 'r * c' (r - rows, c - columns) matrix as follows:
- each row is sorted in non-decreasing order
- each column is sorted in non-decreasing order

Main class for QuickSorting 
*/

/*
 * @author Pooja Khanal
 */
package algorithms_analysis_proj1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.io.File; 
import java.io.*;



public class mainClass {
    static int comparisonCount; 
    static int assignmentCount;
    static double temp; 
    
    //Array for Method1
    static double[][] myArray1;
    
    //Array for Method2
    static double[][] myArray2;


    public static void main(String[] args) throws IOException { 
        System.out.println("Prepared by: Pooja Khanal, A25288740");
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
        System.out.print(String.format("The input matrix is %d x %d \n\n", n1, n2));
        double[][] firstMatrix = new double[n1][n2];
        double[][] secondMatrix = new double[n1][n2];
        readMatrix(scanner, firstMatrix);
        readMatrix(scanner, secondMatrix);
        myArray1 = firstMatrix;
        myArray2 = secondMatrix;
    }
    
    // Read each row and column of the input matrix
    private static void readMatrix(final Scanner scanner, final double[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (scanner.hasNextDouble()) {
                    matrix[i][j] = scanner.nextDouble();
                }
            }
        }
    }  
    
    // Create an object for quickSortMethod1 and call its methods to sort the matrix
    private static void quickSortMethod1Obj() throws IOException {
        //Initialize assignmentCount, comparisonCount and temp
        assignmentCount = 0;
        comparisonCount = 0;
        temp = 0;
        
        //create object for Method1
        quickSortMethod1 quick1 = new quickSortMethod1();
        
        //get rows and column of the matrix
        int m = myArray1.length;
        int n = myArray1[0].length;
        
        //Call method to sort the matrix
        quick1.QuickSortMethod1(myArray1,0, m*n-1 , n);
        
        System.out.println("The sorted Matrix from Method1 is written in file pk0050_Method1.txt\n");
     
        //Print the matrix to the output console.
        for(double[] arr: myArray1) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("\n");
        
        //Print the total number of comparisions and assignments made
        System.out.println("Total Number of comparisions made for Method 1 is:\t"+ comparisonCount);
        System.out.println("Total Number of assignments made for Method 1 is:\t"+ assignmentCount +"\n");
    }
    
    // Create an object for quickSortMethod1 and call its methods to sort the matrix
    private static void quickSortMethod2Obj() throws IOException {
        //Initialize assignmentCount, comparisonCount and temp
        assignmentCount = 0;
        comparisonCount = 0;
        temp = 0;
        
        //create object for Method2
        quickSortMethod2 quick2 = new quickSortMethod2();
  
        //call method to sort the matrix row wise
        for(int row = 0; row < myArray2.length; row++){
            quick2.QuickSortMethod2(myArray2,0,myArray2[0].length-1,row, true);
        }
        
        //call method to sort the matrix column wise
        for(int col = 0; col < myArray2[0].length; col++){
            quick2.QuickSortMethod2(myArray2,0,myArray2.length-1,col, false);
        }
        
        System.out.println("The sorted Matrix from Method2 is written in File pk0050_Method2.txt\n");
        
        //print the matrix to the output console.
        for(double[] arr: myArray2) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println("\n");
        
        //Print the total number of comparisions and assignments made
        System.out.println("Total Number of comparisions made for Method 2 is:\t"+ comparisonCount);
        System.out.println("Total Number of assignments made for Method 2 is:\t"+ assignmentCount+ "\n");
    }

    // Method to write the sorted metrices to output files 
    private static void outToFile(String method, double[][] inputArray) throws IOException{
        //gets the output method and creates file with the method name appended to my login.
        File outputMethod = new File("pk0050_"+ method +".txt");
        outputMethod.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputMethod, false));
        for(double[] arr: inputArray) {
            for (double num: arr){
            writer.write(String.format("%8.2f", num));
            }
            writer.newLine();
        }
        writer.close();
    }
}
