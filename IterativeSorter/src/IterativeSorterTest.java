//2023/05/05
import junit.framework.TestCase;

public class IterativeSorterTest extends TestCase {

	private SorterUtilities utility = new SorterUtilities();
	private IterativeSorter sorter = new IterativeSorter();

	//this method is not a unit test by itself but is called by tests of BubbleSort on various types of data.
	private void testBubbleSort(IntegerArray arrayToSort) {
		long originalCheckSum = utility.checkSum(arrayToSort);
		IntegerArray.reset();
		sorter.doBubbleSort(arrayToSort);
		//you can place a breakpoint here to see the results of your sort, including metrics
		assertEquals(true, utility.verifySort(arrayToSort) );		
		long sortedCheckSum = utility.checkSum(arrayToSort);
		assertEquals(originalCheckSum, sortedCheckSum);
	}
	
	//this method is not a unit test by itself but is called by tests of InsertionSort on various types of data.
	private void testInsertionSort(IntegerArray arrayToSort) {
		long originalCheckSum = utility.checkSum(arrayToSort);
		IntegerArray.reset();
		sorter.doInsertionSort(arrayToSort);
		//you can place a breakpoint here to see the results of your sort, including metrics
		assertEquals(true, utility.verifySort(arrayToSort) );		
		long sortedCheckSum = utility.checkSum(arrayToSort);
		assertEquals(originalCheckSum, sortedCheckSum);
	}

	//this method is not a unit test by itself but is called by tests of SelectionSort on various types of data.
	private void testSelectionSort(IntegerArray arrayToSort) {
		long originalCheckSum = utility.checkSum(arrayToSort);
		IntegerArray.reset();
		sorter.doSelectionSort(arrayToSort);
		//you can place a breakpoint here to see the results of your sort, including metrics
		assertEquals(true, utility.verifySort(arrayToSort) );		
		long sortedCheckSum = utility.checkSum(arrayToSort);
		assertEquals(originalCheckSum, sortedCheckSum);
	}
	
	public void testBubbleSortRandom() {
		
		testBubbleSort(utility.createRandomArray(10));
		testBubbleSort(utility.createRandomArray(1000));

	}

	public void testBubbleSortNearlySorted() {

		testBubbleSort(utility.createNearlySortedArray(10));
		testBubbleSort(utility.createNearlySortedArray(1000));

	}

	public void testBubbleSortFewUniqueArray() {

		testBubbleSort(utility.createFewUniqueArray(10));
		testBubbleSort(utility.createFewUniqueArray(1000));

	}
	
	public void testBubbleSortReverseOrder() {

		testBubbleSort(utility.createReverseOrderArray(10));
		testBubbleSort(utility.createReverseOrderArray(1000));

	}

	public void testInsertionSortRandom() {
		
		testInsertionSort(utility.createRandomArray(10));
		testInsertionSort(utility.createRandomArray(1000));

	}

	public void testInsertionSortNearlySorted() {

		testInsertionSort(utility.createNearlySortedArray(10));
		testInsertionSort(utility.createNearlySortedArray(1000));

	}

	public void testInsertionSortFewUniqueArray() {

		testInsertionSort(utility.createFewUniqueArray(10));
		testInsertionSort(utility.createFewUniqueArray(1000));

	}
	
	public void testInsertionSortReverseOrder() {

		testInsertionSort(utility.createReverseOrderArray(10));
		testInsertionSort(utility.createReverseOrderArray(1000));

	}
	
	public void testSelectionSortRandom() {
		
		testSelectionSort(utility.createRandomArray(10));
		testSelectionSort(utility.createRandomArray(1000));

	}

	public void testSelectionSortNearlySorted() {

		testSelectionSort(utility.createNearlySortedArray(10));
		testSelectionSort(utility.createNearlySortedArray(1000));

	}

	public void testSelectionSortFewUniqueArray() {

		testSelectionSort(utility.createFewUniqueArray(10));
		testSelectionSort(utility.createFewUniqueArray(1000));

	}
	
	public void testSelectionSortReverseOrder() {

		testSelectionSort(utility.createReverseOrderArray(10));
		testSelectionSort(utility.createReverseOrderArray(1000));

	}
	
}
