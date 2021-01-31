package ru.otus;

import java.util.*;
import java.util.function.UnaryOperator;

public class DIYArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] values;
    private int size;

    public DIYArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public DIYArrayList(int initCap) {
        checkCapacity(initCap);
        values = (T[]) new Object[initCap];
    }

    private void checkCapacity(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException(String.format("Illegal Capacity: %s", cap));
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(values, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(values, size, a.getClass());
        System.arraycopy(values, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean add(T t) {
        checkAdequacyCapacity(size + 1);
        values[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c.size() > 0) {
            int oSize = values.length;
            Object[] src = c.toArray();
            size = oSize + src.length;

            checkAdequacyCapacity(size);

            if (index < oSize) {
                System.arraycopy(values, index, values, index + src.length, oSize - index);
            }
            System.arraycopy(src, 0, values, index, src.length);

            return true;
        }
        return false;
    }

    private void checkAdequacyCapacity(int reqCap) {
        if (reqCap > values.length) {
            values = Arrays.copyOf(values, reqCap + DEFAULT_CAPACITY);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T set(int index, T element) {
        values[index] = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        //checkRange(index);

        return new ListIterator<T>() {
            int position = index;
            int lastElementReturned = -1; // index of last element returned, -1 if not such

            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                lastElementReturned = position++;
                return (T) values[lastElementReturned];
            }

            @Override
            public boolean hasPrevious() {
                return position > 0;
            }

            @Override
            public T previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                lastElementReturned = --position;
                return (T) values[lastElementReturned];
            }

            @Override
            public int nextIndex() {
                return position;
            }

            @Override
            public int previousIndex() {
                return position - 1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(T t) {
                if (lastElementReturned < 0) {
                    throw new IllegalStateException("Method set must be executed only after applying previous or next methods!");
                }
                DIYArrayList.this.set(lastElementReturned, t);
            }

            @Override
            public void add(T t) {
                DIYArrayList.this.add(t);
            }
        };
    }


    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
