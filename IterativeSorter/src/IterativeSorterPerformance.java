//2023/12/25
import java.util.Random;

public class IterativeSorterPerformance {

	public static void main(String[] args) {

		IterativeSorter sorter = new IterativeSorter();
        SorterUtilities utility = new SorterUtilities();        
	    Random generator = new Random();
        generator.setSeed(12345);

		//3 sorts x 2 metrics x 4 data sets
		System.out.print(String.format("%6s", ""));
		System.out.print(formatHeader("random").repeat(6));			
		System.out.print(formatHeader("nearly").repeat(6));			
		System.out.print(formatHeader("reverse").repeat(6));			
		System.out.print(formatHeader("few unique").repeat(6));			
		System.out.println();
		
		System.out.print(String.format("%6s\t", "n"));
		System.out.print( (formatHeader("BS T(n)/n^2") + formatHeader("BS S(n)/n^2") +
							formatHeader("IS T(n)/n^2") + formatHeader("IS S(n)/n^2") +
							formatHeader("SS T(n)/n^2") + formatHeader("SS S(n)/n^2") ).repeat(4));

		System.out.println();
				
		for (int n = 1000; n <= 10000; n+=1000){
			
			if (n == 10000) {
				System.out.println("------");
			}
			double n_squared = n * n;
			IntegerArray arrayToSort = null;
			System.out.print(String.format("%6d\t",n));
			
			///////////////////////////////////RANDOM
			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doBubbleSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doInsertionSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doSelectionSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			///////////////////////////////////NEARLY SORTED
			arrayToSort = utility.createNearlySortedArray(n);			
			IntegerArray.reset();
			sorter.doBubbleSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createNearlySortedArray(n);			
			IntegerArray.reset();
			sorter.doInsertionSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createNearlySortedArray(n);			
			IntegerArray.reset();
			sorter.doSelectionSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));
			
			///////////////////////////////////REVERSE ORDER
			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doBubbleSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doInsertionSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doSelectionSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			///////////////////////////////////FEW UNIQUE
			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doBubbleSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doInsertionSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));

			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doSelectionSort(arrayToSort);
			System.out.print(formatTest(arrayToSort,n));
						
			System.out.println();

		}
	}
	
	private static String formatHeader(String columnHeader) {
		return String.format("%15s\t",columnHeader);
	}

	private static String formatValues(long value, double divisor) {
		return String.format("%15.3f\t", value / divisor);
	}
	
	private static String formatTest(IntegerArray arrayToSort, long n) {
		return formatValues(arrayToSort.getReads() + arrayToSort.getWrites(),  n * n)		
				+ formatValues((arrayToSort.getSpaces() + n), n);
	}
			
}
