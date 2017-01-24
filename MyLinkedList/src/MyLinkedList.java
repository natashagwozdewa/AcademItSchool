import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public String toString() {
        String string = "";
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                //noinspection ConstantConditions
                string += getNode(i).getValue() + " , ";
            } else {
                //noinspection ConstantConditions
                string += getNode(i).getValue();
            }
        }
        return "{ " + string + " }";
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new NullPointerException("Неверный индекс: " + index + " Размер списка : " + size);
        }
    }


    T get(int index) {
        //noinspection unchecked,ConstantConditions
        return (T) getNode(index).getValue();
    }

    T set(int index, T value) {
        validateIndex(index);
        //noinspection unchecked,ConstantConditions
        T oldValue = (T) getNode(index).getValue();
        //noinspection unchecked,ConstantConditions
        getNode(index).setValue(value);
        return oldValue;
    }

    private Node getNode(int index) {
        validateIndex(index);
        int count = 0;
        for (Node node = head; node != null; node = node.getNext()) {
            if (index == count) {
                //noinspection unchecked
                return node;
            }
            count++;
        }
        return null;
    }

    boolean addLast(T value) {
        if (size == 0) {
            //noinspection unchecked
            Node node = new Node(value, null, null);
            head = node;
            tail = node;
        } else {
            //noinspection unchecked
            Node node = new Node(value, tail, null);
            tail.setNext(node);
            tail = node;
        }
        ++size;
        return true;
    }

    boolean addFirst(T value) {
        if (size == 0) {
            //noinspection unchecked
            Node node = new Node(value, null, null);
            head = node;
            tail = node;
        } else {
            //noinspection unchecked
            Node node = new Node(value, null, head);
            head.setPrev(node);
            head = node;
        }
        ++size;
        return true;
    }

    void add(int index, T value) {
        validateIndex(index);
        if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node previousNode = getNode(index - 1);
            Node nextNode = getNode(index);
            //noinspection unchecked
            Node newNode = new Node(value, previousNode, nextNode);
            previousNode.setNext(newNode);
            nextNode.setPrev(newNode);
            ++size;
        }
    }

    boolean removeLast() {
        if (tail == null) {
            throw new NoSuchElementException();
        } else {
            tail.setValue(null);
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
            return true;
        }
    }

    boolean removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            head.setValue(null);
            head = head.getNext();
            head.setPrev(null);
            size--;
            return true;
        }
    }

    T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new NullPointerException("Неверный индекс: " + index + " Размер списка : " + size);
        }
        //noinspection unchecked
        T elementToRemove = (T) getNode(index).getValue();
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node removedNode = getNode(index);
            removedNode.setValue(null);
            Node previousNode = getNode(index - 1);
            Node nextNode = getNode(index + 1);
            previousNode.setNext(nextNode);
            nextNode.setPrev(previousNode);
            size--;
        }
        return elementToRemove;
    }

    boolean remove(Object object)
    {
        int count =0;
        if(object == null)
        {
            for (Node node = head; node != null; node = node.getNext()) {
                if (node.getValue() == null) {
                    removeAt(count);
                    return true;
                }
                count++;
            }
        }
        else {
            for (Node node = head; node != null; node = node.getNext()) {
                if (node.getValue().equals(object)) {
                    removeAt(count);
                    return true;
                }
                count++;
            }
        }
        return false;
    }

    int getLength() {
        return size;
    }

    T getLast() {
        return get(getLength() - 1);
    }

    T getFirst()
    {
        return get(0);
    }

    void clear()
    {
        while (size != 0) {
            removeAt(0);
        }
    }

    int indexOf(Object object)
    {
        int index = 0;
        if(object == null)
        {
            for(Node node = head; node != null; node = node.getNext())
            {
                if(node.getValue() == null)
                {
                    return index;
                }
                index++;
            }
        }

        for(Node node = head; node != null; node = node.getNext())
        {
            if(node.getValue().equals(object))
            {
                return index;
            }
            index++;
        }
        return  -1;
    }

    public int lastIndexOf(Object object) {
        int index = size;
        if (object == null) {
            for (Node node = tail; node != null;node = node.getPrev()) {
                index--;
                if (node.getValue() == null)
                    return index;
            }
        } else {
            for (Node node = tail; node != null;node = node.getPrev()) {
                index--;
                if (node.getValue().equals(object))
                    return index;
            }
        }
        return -1;
    }

    private int cursor = -1;
    Iterator<T> iterator() {
        return new Iterator<T>() {

              public boolean hasNext() {
                return cursor < size-1;
            }

            public T next() {
                cursor++;
                //noinspection unchecked,ConstantConditions
                return (T) getNode(cursor).getValue();

            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
