public interface Deque<T> {
    public void addFirst(T x);

    public void addLast(T x);

    public T get(int index);

    public T removeLast();

    public T removeFirst();

    public int size();

    public void printDeque();

    public boolean isEmpty();
}
