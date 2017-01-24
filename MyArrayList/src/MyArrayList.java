import java.util.*;
class MyArrayList<E> implements Iterable<E>{
    private E[] items;
    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Вместимость не может быть отрицательной или равной 0");
        }
        //noinspection unchecked
        items = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object object) {
        return indexOf(object) >= 0;
    }

    public Object[] toArray() {
        //noinspection Since15
        return Arrays.copyOf(items, size);
    }

    public E get(int index) {
        validateIndex(index);
        return (E) items[index];
    }

    public E set(int index, E value) {
        validateIndex(index);
        E oldValue = items[index];
        items[index] = value;
        return oldValue;
    }

    public String toString() {
        return Arrays.deepToString(items);
    }

    public boolean add(E value) {
        if (size == items.length) {
            resizeArray();
        }
        items[size] = value;
        size++;
        return true;
    }

    private void resizeArray() {
        //noinspection unchecked
        E[] newArray = (E[]) new Object[items.length * 2];
        System.arraycopy(items, 0, newArray, 0, size);
        items = newArray;
    }
  /*  private void resizeArray(int delta)
    {
        E[] newArray = (E[]) new Object[items.length + delta];
        System.arraycopy(items, 0, newArray, 0, size);
        items = newArray;
    }*/

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
    }

    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void add(int index, E value) {
        validateIndex(index);
        if (index == items.length) {
            resizeArray();
        }

        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = value;
        size++;
    }

    public int lastIndexOf(Object object) {
        if (object == null) {
            for (int i = size - 1; i >= 0; i--)
                if (items[i] == null)
                    return i;
        } else {
            for (int i = size - 1; i >= 0; i--)
                if (object.equals(items[i]))
                    return i;
        }
        return -1;
    }

    public boolean remove(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    removeAt(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (items[i].equals(object)) {
                    removeAt(i);
                    return true;
                }
            }
        }
        return false;
    }

    public E removeAt(int index) {
        validateIndex(index);

        E elementToRemove = items[index];
        int countOfMovedElem = size - index - 1;
        if (countOfMovedElem > 0) {
            System.arraycopy(items, index + 1, items, index, countOfMovedElem);
        }
        size--;
        items[size] = null;
        return elementToRemove;
    }

    void removeLast() {
        removeAt(size - 1);
    }

    public void clear() {
        while (size != 0) {
            removeAt(0);
        }
    }

    private int cursor;
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            public boolean hasNext() {
                return cursor < size;
            }

            public E next() {
               return items[cursor++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}