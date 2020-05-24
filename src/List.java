import java.util.Arrays;

public class List<T> {
    private T[] list;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    public List() {
        this(DEFAULT_CAPACITY);
    }

    public List(int initialCapacity) {
        initialCapacity = DEFAULT_CAPACITY;
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[initialCapacity + 1];
        list = tempList;
        numberOfEntries = 0;
    }

    public void add(T newEntry) {
        list[numberOfEntries + 1] = newEntry;
        numberOfEntries++;
    }

    public void add(int pos, T newEntry){
        if ((pos >= 1) && (pos <= numberOfEntries + 1)){
            if (pos <= numberOfEntries){
                makeRoom(pos);
            }
            list[pos] = newEntry;
            numberOfEntries++;
            expand();
        }else {
            throw new IndexOutOfBoundsException("Given position is out of bounds.");
        }
    }

    private void makeRoom(int pos){
        assert (pos >= 1) && (pos <= numberOfEntries + 1);

        int newIndex = pos;
        int lastIndex = numberOfEntries;

        for (int i = lastIndex; i >= newIndex; i--) {
            list[i+1] = list[i];
        }
    }

    private void removeGap(int pos){
        assert ((pos>=1) && (pos<numberOfEntries));

        int removedIndex = pos;
        int lastIndex = numberOfEntries;

        for (int i = removedIndex; i<lastIndex; i++ ){
            list[i] = list[i+1];
        }
    }

    public T remove(int pos) {
        if ((pos >= 1) && (pos <= numberOfEntries + 1)){
            assert !isEmpty();
            T removed = list[pos];

            if (pos<numberOfEntries){
                removeGap(pos);
            }

            numberOfEntries--;
            return removed;
        }else {
            throw new IndexOutOfBoundsException("Given position is out of bounds.");
        }
    }

    public T replace(int pos, T newEntry){
        if ((pos >= 1) && (pos <= numberOfEntries + 1)){
            assert !isEmpty();
            T original = list[pos];
            list[pos] = newEntry;
            return original;
        }else {
            throw new IndexOutOfBoundsException("Given position is out of Bounds.");
        }
    }

    public T getEntry(int pos){
        if ((pos >= 1) && (pos <= numberOfEntries + 1)){
            assert !isEmpty();
            return list[pos];
        }else {
            throw new IndexOutOfBoundsException("Given position is out of Bounds.");
        }
    }


    public boolean contains(T entry) {
        boolean contains = false;
        int index = 1;
        while (!contains && (index<numberOfEntries)){
            if (entry.equals(list[index])){
                contains = true;
            }
            index++;
        }
        return contains;
    }

    public int getLength() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public void expand() {
        int capacity = list.length -1;
        if (numberOfEntries >= capacity){
            int newCapacity = capacity*2;
            list = Arrays.copyOf(list, newCapacity +1);
        }
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++){
            array[i] = list[i+1];
        }
        return array;
    }
}
