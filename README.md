# finding-dory
Where is my missing number?
This is a simple progrddam that finds a missing number from an integer array. I wrote this
  1. to show my approach to solve the problem actually works.
  2. to fix the misstep or to fill the missing gap during the code testing.
 
  This is how it works:
  1. An user enters a number.
  2. Using the number, create a list that has a sequence of numbers from 1 to the number.
  3. Create a random number x between 0 and the size of the list. Take the number being at index x in the list,
     and store the value from the list to an array. Remove it from the list. Repeat this until the the last element
     of the list is left. Once created, a number array is created.
  4. Find a max number from the newly created array. Loop from 1 to the max number assuming any number between 1 to the max number can be a possible missing number
  3. Compare each possible missing number with every element in the array.
  4. If the number exists, do nothing.
  5. If the number doesn't exist in the array, then return the number.
