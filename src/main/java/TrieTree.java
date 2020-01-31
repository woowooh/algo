

public class TrieTree {
    private TrieNode root = new TrieNode('/'); // 存储无意义字符

    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null) {
                return false; // 不存在pattern
            }
            p = p.children[index];
        }
        if (p.isEndingChar == false) {
            return false;
        }
        else return true; 
    }

    public class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TrieTree t = new TrieTree();
        char[] arr = {'a', 'b', 'c'};
        char[] brr = {'a', 'b', 'c', 'd'};
        t.insert(arr);
        t.insert(brr);
        System.out.println(t.find(brr));

    }
}