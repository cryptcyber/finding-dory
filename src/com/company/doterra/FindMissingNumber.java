/***
 * This is a simple program that finds a missing number from an integer array. I wrote this
 * 1. to show my approach to solve the problem actually works
 * 2. to fix the misstep or to fill the missing gap during the code testing
 *
 * This is how it works:
 * 1. Find the max number from the integer array that a user entered
 * 2. Loop from 1 to the max number assuming any number between 1 to the max number can be a possible missing number
 * 3. Compare each possible number with every element in the array
 * 4. if the number exists, do nothing
 * 5. if the number doesn't exist in the array, then return the number
 *
 * Limitation:
 * 1. One of the elements in the array must include 1. This is a starting number for the outer loop.
 * There should be lots of improvements can be made.
 *
 *
 * test cases
 *        int [] numberArray = {1, 5, 3, 4, 6, 7}; ---> 2
 *        int [] numberArray = {4, 1, 2};   ---> 3
 *        int [] numberArray = {1, 5, 3, 2};  --->  4
 *        int [] numberArray = {3, 2, 4};  ---> should fail because the array doesn't start with 1
 *        int [] numberArray = {1, 1, 3};  ---> 1
 ***/


package com.company.doterra;

import java.util.Scanner;

public class FindMissingNumber {

    public static void main(String[] args) {
    //	 Accept integers from user input
        int [] numberArray = getNumberArray();


    // Find the maximum number in an array
        int maxNumber = findMaxNumber(numberArray);
        int minNumber = findMinNumber(numberArray);
        int missingNumber = findMissingNumber(minNumber, maxNumber, numberArray);
        if (missingNumber == -111) {
            System.out.println();
            System.out.println("*** There is no missing number ***");
        }
        else {
            System.out.println();
            System.out.println("The missingNumber is ---> " + missingNumber);
        }
    }

    private static int[] getNumberArray() {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of elements in the array:");
        n = s.nextInt();
        int numberArray[] = new int[n];
        System.out.println("Enter elements of array:");
        for(int i = 0; i < n; i++)
        {
            numberArray[i] = s.nextInt();
        }
        return numberArray;
    }

    private static int findMissingNumber(int minNumber, int maxNumber, int[] numberArray) {
        int missingNumber = -111;
        int missingCandidate;
        for (missingCandidate = minNumber; missingCandidate <= maxNumber; missingCandidate++) {
            boolean isMissingNumber = true;
            for (int k = 0; k < numberArray.length; k++) {
                if (missingCandidate == numberArray[k]) {
                    isMissingNumber = false;
                    break; //no need to loop because the number is the missingCandidate exists in the array
                }
            }
            if (isMissingNumber == true) {
                missingNumber = missingCandidate;
                break; // found missing number, get out to return the missing number
            }
        }
        return missingNumber;
    }

    private static int findMinNumber(int[] numberArray) {
        System.out.println();
        System.out.print("Finding a minimum number---> ");
        int minNumber = 999;
        for (int i = 0; i < numberArray.length; i++) {
            if (minNumber > numberArray[i]) {
                minNumber = numberArray[i];
            }
        }
        System.out.println(minNumber);
        return minNumber;

    }

    private static int findMaxNumber(int[] numberArray) {
        System.out.println();
        System.out.print("Finding a maximum number---> ");
        int maxNumber = -999;
        for (int i = 0; i < numberArray.length; i++) {
            if (maxNumber < numberArray[i]) {
                maxNumber = numberArray[i];
            }
        }
        System.out.println(maxNumber);
        return maxNumber;
    }
}