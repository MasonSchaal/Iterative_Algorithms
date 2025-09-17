
public class IterativeSearcher {
    
    public int doBinarySearch(IntegerArray arr, int value) {
        int index = 0;
        int low = 0;
        int high = arr.length() - 1;
        while (true) {
            index = (int) Math.round(((double)high + (double)low)/2.0);
            int current = arr.read(index);
            if (current < value) {
                low = index;
            } else if (current == value) {
              break;  
            } else {
                high = index;
            }
        }
        return index;
    }
}
