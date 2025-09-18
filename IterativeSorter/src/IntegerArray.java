//2023/06/28
import java.util.Arrays;

public class IntegerArray {

	private static long spaces = 0;
	private static long reads = 0;
	private static long writes = 0;
	private static long resets = 0;
	
	private int[] array = null;

	public IntegerArray(int size) {
		this.array = new int[size];
		spaces += array.length;
	}
			
	public int length() {
		return array.length;
	}
	
    public int read(int index) {	
    	reads++;    	
        return array[index];
    }
    
    public void write(int index, int element) {	
    	writes++;    	
        array[index] = element;
    }
    
    public long getReads() {
    	return reads;
    }
    
    public long getWrites() {
    	return writes;
    }
    
    public long getSpaces() {
    	return spaces;
    }
    
    public long getResets() {
    	return resets;
    }

    public static void reset() {
    	reads = 0;
    	writes = 0;
    	spaces = 0;
    	resets++;
    }
    
    public String toString() {
    	return String.format("reads: %d; writes: %d; space: %d; size: %d; resets: %d\n%s", getReads(), getWrites(), getSpaces(), this.array.length, getResets(), Arrays.toString(array));
    }
		
}
