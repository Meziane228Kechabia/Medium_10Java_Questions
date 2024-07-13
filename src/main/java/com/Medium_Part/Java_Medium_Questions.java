package com.Medium_Part;

import java.util.Arrays;

public class Java_Medium_Questions {

    public static void main(String[] args) {
        // Example of finding factorial using recursion
        int number = 19;
        int result = findFactorialNumberUsingRecursion(number);
        System.out.println("Factorial of " + number + " = " + result);

        // Example of checking if a number is palindrome
        checkIfNumberIsPalindrome(93122139);

        // Example of checking if a string is palindrome
        checkIfGivenStringIsAPalindromeOrNot("banana");

        // Example of reversing a given string
        reverseAGivenString();

        // Example of finding the second largest number in an array
        int[] a = {12, 23, 48, 6, 19, 4};
        System.out.println("Second Largest: " + getSecondLargest(a));

        // Example of sorting an array using Bubble Sort
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("Sorted array using Bubble Sort:");
        printArray(arr);

        // Example of sorting an array using Selection Sort
        int[] arry = {64, 25, 12, 22, 11};
        selectionSort(arry);
        System.out.println("Sorted array using Selection Sort:");
        printArray(arry);

        // Example of sorting an array using Insertion Sort
        int[] arrInsertion = {64, 25, 12, 22, 11};
        System.out.println("Array before sorting using Insertion Sort:");
        printArray(arrInsertion);
        insertionSort(arrInsertion);
        System.out.println("\nArray after sorting using Insertion Sort:");
        printArray(arrInsertion);

        // Example of binary search
        int[] array = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 14;
        int index = binarySearch(array, target);
        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }

        // Example of counting words in a string
        String input = "Hello, this is a sample sentence.";
        int wordCount = countWords(input);
        System.out.println("Number of words in the string: " + wordCount);
    }

    // Method to find the factorial of a number using recursion
    public static int findFactorialNumberUsingRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * findFactorialNumberUsingRecursion(n - 1);
        }
    }

    // Method to check if a given number is a palindrome or not
    public static void checkIfNumberIsPalindrome(int number) {
        if (isPalindrome(number)) {
            System.out.println("The inserted number is a palindrome: " + number);
        } else {
            System.out.println("The inserted number is NOT a palindrome: " + number);
        }
    }

    // Utility method to check if a number is palindrome
    public static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to check if a given string is a palindrome or not
    public static void checkIfGivenStringIsAPalindromeOrNot(String str) {
        if (isPalindrome(str)) {
            System.out.println("The inserted word is a palindrome: " + str);
        } else {
            System.out.println("The inserted String is NOT a palindrome: " + str);
        }
    }

    // Utility method to check if a string is palindrome
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Method to reverse a given string without using any built-in functions
    public static void reverseAGivenString() {
        String str = "Sanyville California";
        String reversed = reverseString(str);
        System.out.println("Original string: " + str);
        System.out.println("Reversed string: " + reversed);
    }

    // Utility method to reverse a string
    public static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    // Method to find the second largest number in an array
    public static int getSecondLargest(int[] a) {
        Arrays.sort(a);
        return a[a.length - 2];
    }

    // Method to implement bubble sort algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Method to implement selection sort algorithm
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    // Method to implement insertion sort algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Utility method to print array elements
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Method to implement binary search algorithm
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Check if target is present at mid
            if (arr[mid] == target) {
                return mid;
            }
            // If target greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                right = mid - 1;
            }
        }
        // If we reach here, then the element was not present
        return -1;
    }

    // Method to count the number of words in a given string
    public static int countWords(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        // Split the string by whitespace characters
        String[] words = str.split("\\s+");
        // Return the number of words
        return words.length;
    }
}
