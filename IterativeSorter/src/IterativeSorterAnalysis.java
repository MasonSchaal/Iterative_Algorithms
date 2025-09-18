//2023/05/05
import java.util.Random;

public class IterativeSorterAnalysis {

	private Random generator;
	private IterativeSorter sorter;
    SorterUtilities utility = new SorterUtilities();

	public static void main(String[] args) {
		IterativeSorterAnalysis s = new IterativeSorterAnalysis();
		s.analyse();
	}
	
	private void analyse() {
        generator = new Random();
        generator.setSeed(12345);  //do not change this statement
        
        sorter = new IterativeSorter();
        utility = new SorterUtilities();        

        analyseRandom();
	}
	
	private void analyseRandom() {
			
		System.out.print(String.format("%6s", ""));
		for (int i = 0; i < 6; i++) {
			System.out.print(String.format("%12s\t","random"));			
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(String.format("%12s\t","nearly"));			
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(String.format("%12s\t","reverse"));			
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(String.format("%12s\t","few unique"));			
		}
		
		System.out.println();
		
		
		System.out.print(String.format("%6s\t", "n"));
		for (int i = 0; i < 4; i++) {
			System.out.print(String.format("%12s\t%12s\t", "BS-reads", "BS-writes"));
			System.out.print(String.format("%12s\t%12s\t", "IS-reads", "IS-writes"));
			System.out.print(String.format("%12s\t%12s\t", "SS-reads", "SS-writes"));
		}
		System.out.println();
				
		for (int n = 100; n <= 10000; n+=100){
			///////////////////////////////////RANDOM
			IntegerArray arrayToSort = null;
			System.out.print(String.format("%6d\t",n));
			
			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doBubbleSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doInsertionSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			arrayToSort = utility.createRandomArray(n);
			IntegerArray.reset();
			sorter.doSelectionSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			///////////////////////////////////NEARLY SORTED
			arrayToSort = utility.createNearlySortedArray(n);			
			IntegerArray.reset();
			sorter.doBubbleSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			arrayToSort = utility.createNearlySortedArray(n);			
			IntegerArray.reset();
			sorter.doInsertionSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			arrayToSort = utility.createNearlySortedArray(n);			
			IntegerArray.reset();
			sorter.doSelectionSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));
			
			///////////////////////////////////REVERSE ORDER
			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doBubbleSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doInsertionSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			arrayToSort = utility.createReverseOrderArray(n);						
			IntegerArray.reset();
			sorter.doSelectionSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			///////////////////////////////////NEARLY SORTED
			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doBubbleSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doInsertionSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			arrayToSort = utility.createFewUniqueArray(n);			
			IntegerArray.reset();
			sorter.doSelectionSort(arrayToSort);
			System.out.print(String.format("%10d\t%10d\t", arrayToSort.getReads(), arrayToSort.getWrites()));

			
			System.out.println();

		}
		
	}
		
}
