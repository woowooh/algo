

public class BFfind {
    public static boolean find(String base, String pattern) {
        boolean isMatch = false;
        int len = base.length();
        int patternLen = pattern.length();
        for (int i = 0; i < len; i++) {
            int n = 0;
            int j = i;
            if (base.charAt(j) == pattern.charAt(n)) {
                while (n < patternLen) {
                    if (base.charAt(j) == pattern.charAt(n)) {
                        n++;
                        j++;
                        if (n == patternLen) {
                            return true;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return isMatch;
    }

    public static void main(String[] args) {
        String a = "abcdefghijklmn";
        String b = "ijkl";
        System.out.println(find(a, b));
    }
}
