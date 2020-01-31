import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    SanLie.Entry<K, V> head;
    SanLie.Entry<K, V> tail;
    int size = 0;
    int DEFAULT_CAPACITY = 3;
    Map<K, V> m = new Hashtable<>();

    public void put(K key, V value) {
        m.put(key, value);
        SanLie.Entry<K, V> e = new SanLie.Entry<>();
        e.key = key;
        e.value = value;
        SanLie.Entry<K, V> last = tail;
        tail = e;
        if (size + 1 > DEFAULT_CAPACITY) {
            m.remove(head.getKey());
            head = head.next;
        }
        if (last == null) {
            head = e;
        } else {
            e.before = last;
            last.after = e;
        }
        size++;
    }

    public V get(K key) {
        return (V)m.get(key);
    }

    public static void main(String[] args) {
        LRUCache<String, String> l = new LRUCache<>();
        l.put("1", "1");
        l.put("2", "2");
        l.put("3", "3");
        l.put("4", "4");
        System.out.println(l.get("1"));
        System.out.println(l.get("2"));
        System.out.println(l.get("3"));
    }
}
