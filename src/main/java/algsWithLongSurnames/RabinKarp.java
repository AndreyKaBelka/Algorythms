package algsWithLongSurnames;

public class RabinKarp {
    public RabinKarp() {
    }

    public int calc(String source, String pattern) {
        if (pattern.length() > source.length()) return -1;
        if (pattern.length() == source.length() && pattern.equals(source)) return 0;
        int ptrHash = pattern.hashCode();
        for (int i = 0; i < source.length() - pattern.length() + 1; i++) {
            int srcHash = source.substring(i, i + pattern.length()).hashCode();
            if (ptrHash == srcHash) {
                return i;
            }
        }
        return -1;
    }
}
