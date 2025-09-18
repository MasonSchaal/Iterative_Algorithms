import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import junit.framework.TestCase;

public class IterativeMergerTest extends TestCase {

	private Random generator;
	private IterativeMerger merger = new IterativeMerger();
	
	public IterativeMergerTest() {
        generator = new Random();
        generator.setSeed(12345);  //do not change this statement
	}
	
	public void testRegularMerge() {

		IntegerArray.reset();
		IntegerArray arrayA = createRandomOrderedArray(10000,1,  0, 3);
		IntegerArray arrayB = createRandomOrderedArray(10000, 1,  0, 3);

		IntegerArray.reset();
		IntegerArray mergedArray = merger.doMerge(arrayA, arrayB);		
		assertEquals(true, verifyMerge(mergedArray, arrayA, arrayB));
		assertEquals(mergedArray.length(), arrayA.length() + arrayB.length());
		
		//switch A and B
		IntegerArray.reset();
		mergedArray = merger.doMerge(arrayB, arrayA);		
		assertEquals(true, verifyMerge(mergedArray, arrayA, arrayB));
		assertEquals(mergedArray.length(), arrayB.length() + arrayA.length());
	
	}
	
	public void testNonOverlappingArrays() {
		
		IntegerArray arrayA = createRandomOrderedArray(10000, 1, 0, 3);
		IntegerArray arrayB = createRandomOrderedArray(10000, 5000, 0, 3);

		//two arrays that do not "overlap"
		IntegerArray.reset();
		IntegerArray mergedArray = merger.doMerge(arrayA, arrayB);		
		assertEquals(true, verifyMerge(mergedArray, arrayA, arrayB));
		assertEquals(mergedArray.length(), arrayA.length() + arrayB.length());
		
		//switch A and B
		IntegerArray.reset();
		mergedArray = merger.doMerge(arrayB, arrayA);		
		assertEquals(true, verifyMerge(mergedArray, arrayA, arrayB));
		assertEquals(mergedArray.length(), arrayB.length() + arrayA.length());

	}
	
	public void testLargeAndSmallArrays() {

		IntegerArray arrayA = createRandomOrderedArray(10, 1, 0 , 3);
		IntegerArray arrayB = createRandomOrderedArray(10000, 1, 0 , 3);

		IntegerArray.reset();
		IntegerArray mergedArray = merger.doMerge(arrayA, arrayB);		
		assertEquals(true, verifyMerge(mergedArray, arrayA, arrayB));
		assertEquals(mergedArray.length(), arrayA.length() + arrayB.length());
		
		//switch A and B
		mergedArray = merger.doMerge(arrayB, arrayA);		
		assertEquals(true, verifyMerge(mergedArray, arrayA, arrayB));
		assertEquals(mergedArray.length(), arrayB.length() + arrayA.length());		
	}
	
	public void testNullArrays() {
		
		IntegerArray arrayA = createRandomOrderedArray(10, 1, 0 , 3);
		IntegerArray nullArray = null;
	
		IntegerArray.reset();
		//should return an array with all elements from arrayA
		IntegerArray mergedArray = merger.doMerge(arrayA, nullArray);		
		assertEquals(mergedArray.length(), arrayA.length());
		assertEquals(true, verifyMerge(mergedArray, arrayA, nullArray));
		
		//should return an array with all elements from arrayA
		mergedArray = merger.doMerge(nullArray, arrayA);		
		assertEquals(mergedArray.length(), arrayA.length());
		assertEquals(true, verifyMerge(mergedArray, nullArray, arrayA));

		//should return an empty array
		mergedArray = merger.doMerge(nullArray, nullArray);		
		assertEquals(false, mergedArray == null);
		assertEquals(true, mergedArray.length() == 0);
	}
	
	private IntegerArray createRandomOrderedArray(int size, int firstValue, int minimumIncrease, int maximumIncrease) {

		IntegerArray array = new IntegerArray(size);
		int currentValue = firstValue;
		int range = maximumIncrease - minimumIncrease + 1;
        
        for (int i = 0; i < size; i++) {
        	array.write(i,currentValue);
        	currentValue += (minimumIncrease + generator.nextInt(range));
        }
		
		return array;		
	}
	
	public long checkSum(IntegerArray array) {
		
		long sum = 0;
		if (array != null) {
			for (int i = 0; i < array.length(); i++) {
				sum += array.read(i);
			}
		}
		return sum;		
	}
	
	private boolean verifyMerge(IntegerArray sortedArray, IntegerArray arrayA, IntegerArray arrayB) {

		if (sortedArray != null) { 		
			for (int i = 0; i < sortedArray.length(); i++) {
				if (i + 1 < sortedArray.length()) {
					if (sortedArray.read(i) > sortedArray.read(i+1)) {
						return false;
					}
				}
			}
		}
		else {
			return false;
		}
		
		if (checkSum(sortedArray) != (checkSum(arrayA) + checkSum(arrayB))) {
			return false;
		}
		
		return true;
	}
	
}
