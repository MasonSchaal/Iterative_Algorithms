
public class IterativeMerger {
    
    public IntegerArray doMerge(IntegerArray a, IntegerArray b) {
        if (a != null && b != null) {
            int indexA=0, indexB=0, indexC=0;
            IntegerArray c = new IntegerArray(a.length() + b.length());
            while (indexA < a.length() && indexB < b.length()) {
                if (a.read(indexA) < b.read(indexB)) {
                    c.write(indexC, a.read(indexA));
                    indexA ++;
                } else {
                    c.write(indexC, b.read(indexB));
                    indexB ++;
                }
                indexC ++;
            }
            if (indexA == a.length()) {
                for (int i = indexC ; i < c.length() ; i++) {
                    c.write(i, b.read(indexB));
                    indexB++;
                }
            } else {
                for (int i = indexC ; i < c.length() ; i++) {
                    c.write(i, a.read(indexA));
                    indexA++;
                }
            }
            return c;
        } else {
            if (a == null && b != null) {
                return b;
            } else if (b == null && a != null) {
                return a;
            } else {
                return new IntegerArray(0);
            }
        }
    }

}
