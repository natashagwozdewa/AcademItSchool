import java.util.*;

class MyHashMap<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int MAXIMUM_CAPACITY = Integer.MAX_VALUE / 2;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int threshold;
    private final float loadFactor;

    private Entry<K, V>[] table;
    private int size;

    public String toString() {
        return Arrays.toString(table);
    }

    MyHashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Указана неверная начальная вместимость: " +
                    initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Указан неверный коэффициент загрузки: " +
                    loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = (int) (initialCapacity * loadFactor);
        //noinspection unchecked
        table = new Entry[initialCapacity];
    }

    MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        //noinspection unchecked
        table = new Entry[DEFAULT_INITIAL_CAPACITY];

    }

    private static class Entry<K, V> implements Map.Entry {
        private final int hash;
        private final K key;
        private V value;
        private Entry<K, V> next;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public String toString() {
            return key + " = " + value;
        }

        public int hashCode() {
            return key.hashCode() ^ value.hashCode();
        }

        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (object instanceof Map.Entry) {
                //noinspection unchecked
                Map.Entry<K, V> e = (Map.Entry<K, V>) object;
                if (key.equals(e.getKey()) && value.equals(e.getValue())) {
                    return true;
                }
            }
            return false;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        int getHash() {
            return hash;
        }

        Entry<K, V> getNext() {
            return next;
        }

        public Object setValue(Object value) {
            V oldValue = this.value;
            //noinspection unchecked
            this.value = (V) value;
            return oldValue;
        }

        void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }

    private static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private void addEntry(int hash, K key, V value, int index) {
        Entry<K, V> e = table[index];
        table[index] = new Entry<K, V>(hash, key, value, e);
        if (size >= threshold) {
            resize(2 * table.length);
        }
    }


    int getSize() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    V put(K key, V value) {
        if (key == null) {
            for (Entry<K, V> e = table[0]; e != null; e = e.getNext()) {
                if (e.getKey() == null) {
                    V oldValue = e.getValue();
                    e.setValue(value);
                    return oldValue;
                }
            }
            size++;
            addEntry(0, null, value, 0);
            return null;
        }
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for (Entry<K, V> e = table[i]; e != null; e = e.getNext()) {
            Object k;
            if (e.getHash() == hash && ((k = e.getKey()) == key || key.equals(k))) {
                V oldValue = e.getValue();
                e.setValue(value);
                return oldValue;
            }
        }
        size++;
        addEntry(hash, key, value, i);
        return null;
    }

    void putAll(Map<K, V> map) {
        if (map.size() == 0) {
            return;
        } else if (map.size() > threshold) {
            int targetCapacity = (int) (map.size() / loadFactor + 1);
            if (targetCapacity > MAXIMUM_CAPACITY) {
                targetCapacity = MAXIMUM_CAPACITY;
            }
            int newCapacity = table.length;
            while (newCapacity < targetCapacity) {
                newCapacity <<= 1;
            }
            if (newCapacity > table.length) {
                resize(newCapacity);
            }
        }
        for (Map.Entry<K, V> e : map.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    V get(Object key) {
        if (key == null) {
            for (Entry<K, V> e = table[0]; e != null; e = e.getNext()) {
                if (e.getKey() == null) {
                    return e.getValue();
                }
            }
            return null;
        }

        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for (Entry<K, V> e = table[i]; e != null; e = e.getNext()) {
            Object k;
            if (e.getHash() == hash && ((k = e.getKey()) == key || key.equals(k))) {
                return e.getValue();
            }
        }
        return null;
    }

    private Entry<K, V> getEntry(int hash, K key) {
        int i = indexFor(hash, table.length);
        for (Entry<K, V> e = table[i]; e != null; e = e.getNext()) {
            Object k;
            if (e.getHash() == hash && ((k = e.getKey()) == key || (key != null && key.equals(k)))) {
                return e;
            }
        }
        return null;
    }

    private void resize(int newCapacity) {
        if (table.length == MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return;
        }

        Entry[] newTable;
        newTable = new Entry[newCapacity];
        transfer(newTable);
        //noinspection unchecked
        table = newTable;
        threshold = (int) (newCapacity * loadFactor);
    }

    private void transfer(Entry[] newTable) {
        Entry[] src = table;
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) {
            //noinspection unchecked
            Entry<K, V> e = src[j];
            if (e != null) {
                src[j] = null;
                do {
                    Entry<K, V> next = e.getNext();
                    int i = indexFor(e.getHash(), newCapacity);
                    //noinspection unchecked
                    e.setNext(newTable[i]);
                    newTable[i] = e;
                    e = next;
                } while (e != null);
            }
        }
    }

    void clear() {
        Entry[] newTable = table;
        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = null;
        }
        size = 0;
    }

    boolean containsValue(V value) {
        Entry[] newTable = table;
        for (Entry aNewTable : newTable) {
            for (Entry e = aNewTable; e != null; e = e.getNext()) {
                if (value == null) {
                    if (e.getValue() == null) {
                        return true;
                    }
                } else {
                    if (value.equals(e.getValue())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean containsKey(K key) {
        Entry[] newTable = table;
        for (Entry aNewTable : newTable) {
            for (Entry e = aNewTable; e != null; e = e.getNext()) {
                if (key == null) {
                    if (e.getKey() == null) {
                        return true;
                    }
                } else {
                    if (key.equals(e.getKey())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    V remove(K key) {
        Entry<K, V> e = removeEntryForKey(key);
        return (e == null ? null : e.getValue());
    }

    private Entry<K, V> removeEntryForKey(K key) {
        int hash;
        if (key == null) {
            hash = 0;
        } else {
            hash = hash(key.hashCode());
        }
        int i = indexFor(hash, table.length);
        Entry<K, V> previous = table[i];
        Entry<K, V> e = previous;

        while (e != null) {
            Entry<K, V> next = e.getNext();
            Object k;
            if (e.getHash() == hash && ((k = e.getKey()) == key || (key != null && key.equals(k)))) {
                size--;
                if (previous == e) {
                    table[i] = next;
                } else {
                    previous.setNext(next);
                }
                return e;
            }
            previous = e;
            e = next;
        }
        return e;
    }

    public V replace(K key, V value) {
        Entry<K, V> e;
        if ((e = getEntry(hash(key.hashCode()), key)) != null) {
            V oldValue = e.value;
            e.value = value;
            return oldValue;
        }
        return null;
    }

    private Collection<V> values;
    private Set<K> keySet;
    private Set<Entry<K, V>> entrySet = null;

    public Collection<V> values() {
        Collection<V> vs = values;
        return (vs != null ? vs : (values = new Values()));
    }

    Iterator<V> newValueIterator() {
        return new ValueIterator();
    }

    private Iterator<K> newKeyIterator() {
        return new KeyIterator();
    }

    private EntryIterator newEntryIterator() {
        return new EntryIterator();
    }

    private class Values extends AbstractCollection<V> {

        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        public int size() {
            return size;
        }
    }

    private class ValueIterator extends HashIterator<V>
            implements Iterator<V> {
        public V next() {
            return nextEntry().getValue();
        }
    }

    private class KeyIterator extends HashIterator<K> {
        public K next() {
            return nextEntry().getKey();
        }
    }

    private class EntryIterator extends HashIterator<Entry<K, V>> {
        public Entry<K, V> next() {
            return nextEntry();
        }
    }

    abstract class HashIterator<E> implements Iterator<E> {
        Entry next;
        Entry<K, V> current;
        int index;

        HashIterator() {
            if (size > 0) {
                Entry[] t = table;
                //noinspection StatementWithEmptyBody
                do {
                } while (index < t.length && (next = t[index++]) == null);
            }
        }

        public boolean hasNext() {
            return next != null;
        }

        Entry<K, V> nextEntry() {
            //noinspection unchecked
            Entry<K, V> e = next;
            if (e == null)
                throw new NoSuchElementException();

            if ((next = e.getNext()) == null) {
                Entry[] t = table;
                //noinspection StatementWithEmptyBody
                do {
                } while (index < t.length && (next = t[index++]) == null);
            }
            current = e;
            return e;
        }

        public void remove() {
            if (current == null)
                throw new IllegalStateException();
            K key = current.getKey();
            current = null;
            MyHashMap.this.removeEntryForKey(key);
        }
    }

    Set<K> keySet() {
        Set<K> ks = keySet;
        return (ks != null ? ks : (keySet = new KeySet()));
    }

    private class KeySet extends AbstractSet<K> {
        public Iterator<K> iterator() {
            return newKeyIterator();
        }

        public int size() {
            return size;
        }
    }

    Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es = entrySet;
        return es != null ? es : (entrySet = new EntrySet());
    }

    private class EntrySet extends AbstractSet<Entry<K, V>> {

        public Iterator<Entry<K, V>> iterator() {
            return newEntryIterator();
        }

        public int size() {
            return 0;
        }
    }

}

