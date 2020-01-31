import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Hashtable;
import java.util.Objects;

public class SanLie<K, V> {
    private transient Entry<?,?>[] table;
    private float loadFactor;
    private int count = 0;

    public SanLie() {
        this(11, 0.75f);
    }

    public SanLie(int size, float loadFactor) {
        this.loadFactor = loadFactor;
        table = new Entry<?, ?>[size];
    }

    @Accessors(chain = true)
    @NoArgsConstructor
    @Builder
    @Data
    public static class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        public int hashCode() {
            return key.hashCode();
        }

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public V get(K key) {
        Entry<?, ?>[] tab = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        Entry<?, ?> entry = tab[index];
        for(; entry != null; entry = entry.next) {
            if (entry.hash == hash && key.equals(entry.key)) {
                return (V)entry.getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        Entry<?,?> tab[] = table;
        int hashCode = key.hashCode();
        int index = (hashCode & 0x7FFFFFFF) % tab.length;
        Entry<K, V> entry = (Entry<K, V>) table[index];
        for (; entry != null; entry = entry.next) {
            System.out.println("called ");
            if (entry.hash == hashCode && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        addEntry(hashCode, key, value, index);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {
        Entry<?, ?>[] tab = table;
        Entry<K, V> entry = (Entry<K, V>)tab[index];
        tab[index] = new Entry<>(hash, key, value , entry);
        count++;
    }

    public static void main(String[] args) {
        SanLie<String, String> m = new SanLie<>();
        m.put("1", "1");
        m.put("1", "2");
        m.put("3", "3");
        System.out.println(m.get("1"));
        System.out.println(m.get("2"));
        System.out.println(m.get("3"));
    }
}
