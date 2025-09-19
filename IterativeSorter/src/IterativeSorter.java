
public class IterativeSorter {

    public IntegerArray doBubbleSort(IntegerArray arr) {
        int swaps = 1;
        while (swaps != 0) {
            swaps = 0;
            for (int i=0 ; i < arr.length() ; i++) {
                if (i+1 < arr.length()) {
                    int firstValue = arr.read(i);
                    int secondValue = arr.read(i+1);
                    if (firstValue > secondValue) {
                        arr.write(i, secondValue);
                        arr.write(i+1, firstValue);
                        swaps++;
                    }
                }
            }
        }
        return arr;
    }
    
    public IntegerArray doInsertionSort(IntegerArray arr) {
        for (int i=1 ; i < arr.length() ; i++) { 
            int j = i;
            while (j != 0) {
                int firstValue = arr.read(j);
                int secondValue = arr.read(j-1);
                if (firstValue < secondValue) {
                    arr.write(j, secondValue);
                    arr.write(j-1, firstValue);
                    j--;
                } else {
                    break;
                }
            }
        }
        return arr;
    }
    
    public IntegerArray doSelectionSort(IntegerArray arr) {
        for (int i=0 ; i < arr.length() ; i++) {
            int smallest = i;
            for (int j=i+1 ; j < arr.length() ; j++) {
                if (arr.read(j) < arr.read(smallest)) {
                    smallest = j;
                }
            }
            if (smallest != i) {
                int temp = arr.read(i);
                arr.write(i, arr.read(smallest));
                arr.write(smallest, temp);
            }
        }
        return arr;
    }
}
