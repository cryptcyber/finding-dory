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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindMissingNumber {

    public static void main(String[] args) {
    //	 Accept integers from user input
        int max = getMaxNumberFromUserInput();
        //create a list containing the numbers 1 to max
        List <Integer> numberList = makeSequence(1, max);

        //Create a random number x between 0 and the size of the list. Take the number being at index x in the list,
        //and store the value of the list to an array. Remove it from the list. Repeat this until the the last element
        // of the list is left
        int [] numberArray = new int[max - 1];
        int idx = 0;
        while (numberList.size() > 1) {
            int x = getNextRandom(numberList.size());
            if ( x >= 0 && x < numberList.size()) {
                numberArray[idx++] = numberList.get(x);
                numberList.remove(x);
            }
        }

    // Find the maximum number in an array
        int maxNumber = findMaxNumber(numberArray);
        int missingNumber = findMissingNumber(1, maxNumber, numberArray);
        if (missingNumber == -111) {
            System.out.println();
            System.out.println("*** There is no missing number ***");
        }
        else {
            System.out.println();
            System.out.println("The missingNumber is ---> " + missingNumber);
        }
    }

    private static List<Integer> makeSequence(int begin, int end) {
        List <Integer> numberList = new ArrayList<>(end - begin + 1);
        for (int i = begin; i <= end; i++ ) {
            numberList.add(i);
        }
        return numberList;
    }

    private static int getNextRandom(int max) {
        int min = 0;
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int number = rand.nextInt(max - min + 1) + min;
        return number;
    }

    private static int getMaxNumberFromUserInput() {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.print("Please enter a positive number (> 2) :");
        n = s.nextInt();
        return n;
    }

    private static void setNumberArray(int number, int[] numberArray, int maxNumber) {
            int randomNumber = getNextRandom(maxNumber);
            if (number <= 0) {
                return;
            } else {
                ///find a way to insert a unique number, maybe to use another recursive method?
                numberArray[number - 1] = randomNumber;
                System.out.println("randomNumber : " + randomNumber);
                --number;
                setNumberArray(number, numberArray, maxNumber);
            }
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