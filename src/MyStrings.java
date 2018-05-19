import java.util.Iterator;
import java.util.List;

public class MyStrings<Type> implements Iterable<Type>{
    private List arrayList;
    private int currentSize;

    public MyStrings(List newArray) {
        this.arrayList = newArray;
        this.currentSize = newArray.size();
    }

    @Override
    public Iterator<Type> iterator() {
        Iterator<Type> it = new Iterator<Type>() {

            private int currentIndex = currentSize - 1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0 && arrayList.get(currentIndex) != null;
            }

            @Override
            public Type next() {
                return (Type) arrayList.get(currentIndex--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
