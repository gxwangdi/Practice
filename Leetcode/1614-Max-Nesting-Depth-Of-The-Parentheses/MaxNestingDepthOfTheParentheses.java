

class MaxNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int max = 0;
        int depth = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    depth++;
                    max = Math.max(max, depth);
                    break;
                case ')':
                    depth--;
                    break;
            }
        }
        return max;
    }
}
