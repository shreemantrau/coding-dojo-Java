class StringManipulator {
    public String trimAndConcat(String s1, String s2) {
        return s1.trim().concat(s2.trim());
    }

    public Integer getIndexOrNull(String s, char c) {
        return s.indexOf(c);
    }

    public String concatSubString(String s1, int x, int y, String s2) {
        
        return s1.substring(x, y).concat(s2);
    }
}