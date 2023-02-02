/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;
//import java.util.ArrayList;

/**
 *
 * @author Sarim Shahwar
 */
public class ProceduralAbstraction {
//Requires: None
//Modifies: None
//Effects: Returns the smallest positive integer n for which n!
// (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
// integer x. Otherwise returns 1.  

    static int l = 1;

    public static int reverseFactorial(int x) {
        if (x <= 1) {
            int ph = l; //ph is a used as a placeholder
            l = 1;
            return ph;
        }
        l++;
        return reverseFactorial(x / l);

    }
//Requires: None
//Modifies: None
//Effects: If the matrix arr satisfies Nice property, prints the sum and
// returns true. Otherwise returns false.

    public static boolean isMatrixNice(int[][] arr) {
        if (arr.length == arr[0].length) {
            int m_sum = 0; //matrix sum

            for (int i = 0; i < arr.length; i++) {
                int trow = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    trow = trow + arr[i][j];
                }
                if (i == 0) {
                    m_sum = trow;
                } else {
                    if (m_sum != trow) {
                        System.out.println("The Sum Cannot be Calculated as the Matrix is not Nice ");
                        return false;
                    }
                }
            }
            int diagonal = 0;
            for (int i = 0; i < 2; i++) {
                int tdiag = 0;
                for (int j = 0; j < arr.length; j++) {
                    tdiag = tdiag + arr[j][j];
                }
                if (i == 0) {
                    diagonal = tdiag;
                } else {
                    if (diagonal != tdiag) {
                        return false;
                    }
                }
                if (diagonal != m_sum) {
                    return false;
                }
            }
            System.out.println("The Sum of the Nice Matrix is: " + m_sum);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) { //Main class
//reverseFactorial rff = new reverseFactorial()
        Scanner scan1 = new Scanner(System.in); //For Integers

        int options = 0, user, x;
        while (options != 3) {

            System.out.println("=================================================================================");
            System.out.println("Welcome! Please select one of the following options listed below!");
            System.out.println("Enter the number 1 below to run the Reverse Factorial Program");
            System.out.println("Enter the number 2 below to run the Nice Matrix Program");
            System.out.println("Enter the number 3 below to end the Program");
            System.out.println("=================================================================================");

            user = scan1.nextInt();
            switch (user) {

                case 1:
                    //Reverse Factorial Program
                    System.out.println("Enter an Interger below: ");
                    x = scan1.nextInt();
                    System.out.println(" ");
                    System.out.println("The Reverse Factorial for " + x + " is " + reverseFactorial(x / l));

                    break;
                    
                case 2:
                    //NiceMatrix Program
                    System.out.println("Matrix #1: ");
                    System.out.println("2, 7, 6");
                    System.out.println("9, 5, 1");
                    System.out.println("4, 3, 8");
                    int[][] matrix1 = {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}};
                    System.out.println("Is the matrix above nice? " + isMatrixNice(matrix1));

                    System.out.println("");
                    System.out.println("Matrix #2: ");
                    System.out.println("-3, 1, 0");
                    System.out.println("4, -3, 4");
                    System.out.println("7, -9, 0");
                    int[][] matrix2 = {{-3, 1, 0}, {4, -3, 4}, {7, -9, 0}};
                    System.out.println("Is the matrix above nice? " + isMatrixNice(matrix2));

                    break;
                    
                case 3:
                    //End program
                    return;

                default: //For invalid entry
                    System.out.println("Invalid Operation... Please Try Again");

            }

        }

    }

}
