
/*************************************************/
/***  Simple test class for Sort class         ***/
/***                                           ***/
/***  Author: Jason Steggles    20/09/2019     ***/
/*************************************************/


public class TestSort
{

	// Method that tests all three methods from Sort.java on test1.txt and gives
	// the test results to prove that the implementation of the methods is correct
	public static void implementationTest() {

	// Creating three different tests of max length 50 for the three methods that will be tested
		Sort sortTest = new Sort(50);
		Sort sortTest1 = new Sort(50);
		Sort sortTest2 = new Sort(50);
	// Reading in test1.txt file for all the tests
		sortTest.readIn("test1.txt");
        sortTest1.readIn("test1.txt");
        sortTest2.readIn("test1.txt");

    /* Creating three arrays to take in all the values of the file that
      each will later be sorted by a different method */
      int[] Array = sortTest.getA();
      int[] Array1 = sortTest1.getA();
      int[] Array2 = sortTest2.getA();
    // Displaying the original array, before it gets sorted
    // calling the insertion method on the test and the displaying its results
      sortTest.display(10,"\nOriginal, unsorted values of test1.txt :\n");
      sortTest.insertion(Array);
      sortTest.display(10,"\n\nSorted Values of test1.txt using Insertiong Sort:\n");
    // Displaying the original array, before it gets sorted
    // calling the Quicksort method on the test and the displaying its results
      sortTest1.display(10,"\nOriginal, unsorted values of test1.txt :\n");
      sortTest1.quicksort(Array1, 0, Array1.length-1);
      sortTest1.display(10,"\n\nSorted Values of test1.txt using Quicksort:\n");
    // Displaying the original array, before it gets sorted
    // calling the New Sorting method on the test and the displaying its results
      sortTest2.display(10,"\nOriginal, unsorted values of test1.txt :\n");
      sortTest2.newsort(Array2);
      sortTest2.display(10,"\n\nSorted Values of test1.txt using Newsort:\n");

}
	/*Method that tests the three methods on all six test files
	 *
	 * */
	public static void testAll(){
		// two different max values for the tests since tests 1, 2, 3 contain 50 values and tests 4, 5,6 have 1000 values
		int small = 50;
		int large = 1000;
		// creating three different tests for each sorting method with max size 50
		Sort sortTest = new Sort(small);
		Sort sortTest1 = new Sort(small);
		Sort sortTest2 = new Sort(small);

		// for loop that reads in arrays the values from the files test 1 to 3, applies the sorting methods and prints their comparison counters
		for (int i =1 ; i<4; i++ ){

			System.out.println("\n\nSorted Values of test"+i+".txt:");

		// reading in of values for each test file, sorting using insertion sort and displaying the comparison counter
        sortTest.readIn("test"+i+".txt");
		int[] Array = sortTest.getA();
        sortTest.insertion(Array);
        System.out.println("\nInsertion sort comparison counter: " + sortTest.compIS );

        // reading in of values for each test file, sorting using Quicksort and displaying the comparison counter
        sortTest1.readIn("test"+i+".txt");
		int[] Array1 = sortTest1.getA();
        sortTest1.quicksort(Array1, 0, Array1.length -1);
        System.out.println("\nQuicksort comparison counter: " + sortTest1.compQS );

        // reading in of values for each test file, sorting using New sort and displaying the comparison counter
        sortTest2.readIn("test"+i+".txt");
		int[] Array2 = sortTest2.getA();
        sortTest2.newsort(Array2);
        System.out.println("\nNewsort comparison counter: " + sortTest2.compNS );

		}
		// creating three different tests for each sorting method with max size 1000
		sortTest = new Sort(large);
		sortTest1 = new Sort(large);
		sortTest2 = new Sort(large);

		// for loop that reads in arrays the values from the files test 4 to 6, applies the sorting methods and prints their comparison counters
		for (int i =4 ; i<7; i++ ){

				System.out.println("\n\nSorted Values of test"+i+".txt:");

			// reading in of values for each test file, sorting using insertion sort and displaying the comparison counter
	        sortTest.readIn("test"+i+".txt");
			int[] Array = sortTest.getA();
	        sortTest.insertion(Array);
	        System.out.println("\nInsertion sort comparison counter: " + sortTest.compIS );

	        // reading in of values for each test file, sorting using Quicksort and displaying the comparison counter
	        sortTest1.readIn("test"+i+".txt");
			int[] Array1 = sortTest1.getA();
	        sortTest1.quicksort(Array1, 0, Array1.length-1);
	        System.out.println("\nQuicksort comparison counter: " + sortTest1.compQS );

	        // reading in of values for each test file, sorting using New sort and displaying the comparison counter
	        sortTest2.readIn("test"+i+".txt");
			int[] Array2 = sortTest2.getA();
	        sortTest2.newsort(Array2);
	        System.out.println("\nNewsort comparison counter: " + sortTest2.compNS );

			}

	}



	public static void main(String[] args)
    {
	/** remove comment bellow to use the method that tests the three methods on test1.txt **/
		implementationTest();

	/** remove comment bellow to use the method that tests the three methods on all test files **/
	//	testAll();



		}

} /** End of TestSort class **/
