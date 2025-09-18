
public class IterativeMerger {
    
    public IntegerArray doMerge(IntegerArray a, IntegerArray b) {
        int indexA=0, indexB=0, indexC=0;
        IntegerArray c = new IntegerArray(a.length() + b.length());
        while (indexA < a.length() && indexB < b.length()) {
            if (a.read(indexA) < b.read(indexB)) {
                c.write(indexC, a.read(indexA));
                indexA ++;
            } else {
                c.write(indexB, b.read(indexB));
                indexB ++;
            }
            indexC ++;
        }
        if (indexA == a.length()) {
            
        }
        return c;
    }

}
