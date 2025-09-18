
public class IterativeSearcher {
    
    public int doBinarySearch(IntegerArray arr, int value) {
        int low = 0;
        int high = arr.length();
        while (low + 1 < high) {
            int index = (low + high)/2;
            if (arr.read(index) > value) {
                high = index;
            } else {
                low = index;
            }
        }
        if (arr.read(low) == value) {
            if (low == 0 || arr.read(low - 1) != value) {
                return low;
            } else {
                while(low != 0 && arr.read(low - 1) == value) {
                    low -= 1;
                }
                return low;
            }
        } else {
            return -1;
        }
        
    }
}
