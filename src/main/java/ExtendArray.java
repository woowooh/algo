import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

import static java.lang.Math.max;


@Data
@ToString
public class ExtendArray {
    private int  size;
    private int DEFAULT_CAPACITY = 2;
    static Integer[] DEFAULT_ARRAY = {};
    private Integer[] elements;

    public ExtendArray() {
        this.elements = DEFAULT_ARRAY;
    }

    public void grow() {
        int newCapacity = max(elements.length + (elements.length >> 1), DEFAULT_CAPACITY);
        Integer[] newArr = new Integer[newCapacity];
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
    }

    public void add(int element) {
        if (needGrow()) {
            grow();
        }
        elements[size++] = element;
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    public int get(int index) {
        return elements[index];
    }

    private boolean needGrow() {
        return this.size + 1 > elements.length || this.elements == DEFAULT_ARRAY;
    }

    public static void main(String[] args) {
        ExtendArray arr = new ExtendArray();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        System.out.println(arr);
        System.out.println(arr.size());
        System.out.println(arr.get(2));
        arr.remove(2);
        System.out.println(arr.size());
        arr.remove(2);
        System.out.println(arr.size());
        System.out.println(arr);
    }
}
