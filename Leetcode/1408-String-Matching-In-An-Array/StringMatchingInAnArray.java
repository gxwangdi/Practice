

class StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(String s1 : words) {
            for(String s2 : words) {
                if (s1.contains(s2) && !s1.equals(s2)) {
                    res.add(s2);
                    break;
                }
            }
        }
        return res;
    }
}
