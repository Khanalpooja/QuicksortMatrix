/* 
Submitted by: Pooja Khanal, A25288740 
Design/Analysis of Algorithms, CS317-01 , Spring 2020
submitted on: 02/27,2020 

 program to rearrange a given 'r * c' (r - rows, c - columns) matrix as follows:
- each row is sorted in non-decreasing order
- each column is sorted in non-decreasing order

-   Class for Comparisions and Assignment of elements in matrix. 
-   also counts the total number of comparisions and assignments made for sorting
    the matrix
*/

/*
 * @author Pooja Khanal
 */
package algorithms_analysis_proj1;

import static algorithms_analysis_proj1.mainClass.comparisonCount;
import static algorithms_analysis_proj1.mainClass.assignmentCount;
import static algorithms_analysis_proj1.mainClass.temp;

public class compAssign {
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

    // ASSIGN  num to Array[i][j]
    public static void Assign(double[][] Array , int i, int j, double num){
        assignmentCount++;
        Array[i][j] = num;  
    }

    //ASSIGN a to temp
    public static void Assign(double a){
        assignmentCount++;
        temp = a; 
    } 
}
