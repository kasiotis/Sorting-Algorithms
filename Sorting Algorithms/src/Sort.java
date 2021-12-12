
/*****************************************************/
/*** Sort class currently contains some initial    ***/
/*** methods for implementing sorting algorithms   ***/
/***                                               ***/
/***     Initial Author: Jason Steggles 20/09/19   ***/
/***     Extended by: Antreas Kasiotis             ***/
/*****************************************************/

import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

	/** Size of array **/
	private int size;

	/** Number of used elements in array **/
	private int usedSize;

	/** Array of integers **/
	private int[] A;

	/** Initialising getters and setters for the array **/
	public int[] getA() {
		return A;
	}

	public void setA(int[] a) {
		A = a;
	}


	/** Global variables for counting sort comparisons **/
	public int compIS;
	/** Global comparison count for Insertion Sort **/
	public int compQS;
	/** Global comparison count for Quicksort **/
	public int compNS;
	/** Global comparison count for newsort **/

	/*Insertion sort method starts by looking at the elements of the array from left to right
	and checks them one by one in case the current element that is being looked at is in the
	correct location in respect to the previous sorted elements.
	 */
	public void insertion(int[] Array) {
	//loop that goes through all the elements of the array
		for (int i = 1; i < Array.length; i++) {
	// variable "key" is the value of the current element
			int key = Array[i];
			int j = i;
	// loop to find the correct location for the value of "key"
			while (j > 0 && key < Array[j - 1]) {
				Array[j] = Array[j - 1];
				j--;
				compIS++;
			}
	// put key in its correct position
			Array[j] = key;
			compIS++;

		}

	}

	/* This method goes through a given array of integers, takes the last value as a Pivot ,
	 * initialises left and right pointers and then proceeds to scan from left to right
	 * until it finds a value that is larger then the pivot. Afterwards it scans from right
	 * to left until it finds a value that is smaller or equal to the pivot. If both of these
	 * values are found found before the pointers cross then they get swapped with one another.
	 * This is done until the pointers cross and then the pivot gets swapped with the last
	 * left pointer and the index of that location gets returned to the method.
	 */
	public int partition (int[] Ar , int L, int R){

		// Selecting the rightmost element as the Pivot
				int v = Ar[R];
		// Initialising the scanning pointers
			int	pL = L;
			int	pR = R;

		// repeat until left and right scanning pointers overlap
				while (pL<pR) {
		// checking if the value in the array at the index of the left pointer is smaller than
		// the pivot and if it is then moving one position to the right
					while (Ar[pL] < v){
						pL++;
						compQS++;
					}
					compQS++;
		// checking if the right pointer is bigger or equal than the pivot and if the index of the right pointer
		// is larger than the index of the first element in the array. if it is both, then shift it to the left
					while (Ar[pR] >= v && pR>L){
						pR--;
						compQS++;
					}
					compQS++;
		// check if the pointers haven't crossed yet and then swap them with each other
					if (pL < pR){
						int temp = Ar[pL];
						Ar[pL] = Ar[pR];
						Ar[pR] = temp;
					}

				}
		// Put the Pivot in its correct position
				int temp = v ;
				Ar[R] = Ar[pL];
				Ar[pL] = temp;
		// Return the index of the Pivot's final/correct location
				return pL;
	}

// recursive method that sorts and partitions the array, then splits it
// into two arrays and does the same for each split until it is completely sorted
	public void quicksort(int[] Array, int L, int R){

		if (R > L){
			int p = partition(Array,L,R);
			quicksort(Array,L,p-1);
			quicksort(Array,p+1,R);
		}
	}

	// sorting method that is similar(or identical) to selection sort, basic algorithm that works
	// by repeatedly selecting selecting the smallest element that has not been picked up yet and
	// swaps it with the element after the last one that was sorted

	public void newsort(int[] Array){
		// initialising the first position of the array
		int pos = 0;
		// While the position has not exceeded the bounds of the array
		while (pos<Array.length){
		// use the method to findMinFrom to find the min value of the array
			int min = findMinFrom(Array, pos);
		// integer i acts as a copy of the pos variable and goes through a for loop
					for (int i = pos; i<Array.length; i++ ){
		// if the value in the array at position i is equal to the minimum value then swap them
						if (Array[i] == min){
							int temp = Array[i] ;
							Array[i] = Array[pos];
							Array[pos] = temp;
		// after the swap increment the position by one
							pos++;
						}
						compNS++;
					}
		}
	}

// method that takes in the values of the array and the current position index
	public int findMinFrom (int[] Array, int pos){
		// it assigns that value as the minimum value
		int min = Array[pos];
		// in a for loop that goes through all the elements of the array after the value that is located at the pos position we check
		// if there is a value that is smaller than the current minimum and if there is one, then that becomes our new minimum
		for (int i = pos+1; i<Array.length; i++ ){
			if (Array[i]<min){
				min = Array[i];
			}
			compNS++;
		}
		return min;
	}


	/*****************/
	/** Constructor **/
	/*****************/
	Sort(int max) {
		/** Initialise global sort count variables **/
		compIS = 0;
		compQS = 0;
		compNS = 0;

		/** Initialise size variables **/
		usedSize = 0;
		size = max;

		/** Create Array of Integers **/
		setA(new int[size]);
	}

	/*********************************************/
	/*** Read a file of integers into an array ***/
	/*********************************************/
	public void readIn(String file) {
		try {
			/** Initialise loop variable **/
			usedSize = 0;

			/** Set up file for reading **/
			FileReader reader = new FileReader(file);
			Scanner in = new Scanner(reader);

			/** Loop round reading in data while array not full **/
			while (in.hasNextInt() && (usedSize < size)) {
				getA()[usedSize] = in.nextInt();
				usedSize++;
			}


		} catch (IOException e) {
			System.out.println("Error processing file " + file);
		}

	}

	/**********************/
	/*** Display array ***/
	/**********************/
	public void display(int line, String header) {
		/*** Integer Formatter - three digits ***/
		NumberFormat FI = NumberFormat.getInstance();
		FI.setMinimumIntegerDigits(3);

		/** Print header string **/
		System.out.print("\n" + header);

		/** Display array data **/
		for (int i = 0; i < usedSize; i++) {
			/** Check if new line is needed **/
			if (i % line == 0) {
				System.out.println();
			}

			/** Display an array element **/
			System.out.print(FI.format(getA()[i]) + " ");
		}
	}


} /** End of Sort Class **/
