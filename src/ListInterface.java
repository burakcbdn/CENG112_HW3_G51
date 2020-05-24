//list interface for implementing list adt

public interface ListInterface<T> {
    public void add(T newEntry);

    public void add(int pos, T newEntry);

    public T remove(int pos);

    public T replace(int pos, T newEntry);

    public T getEntry(int pos);


    public boolean contains(T entry);

    public int getLength();

    public boolean isEmpty();
    public void expand();

    public T[] toArray();
}
