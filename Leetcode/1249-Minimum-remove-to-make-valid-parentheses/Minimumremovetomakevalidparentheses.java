

class Minimumremovetomakevalidparentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> openSt = new Stack<>();
        HashSet<Integer> todoRemove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                openSt.push(i);
            else if (s.charAt(i) == ')') {
                if (openSt.isEmpty())
                    todoRemove.add(i); // Meet closing-parentheses but no opening-parenthesis -> remove closing-parenthesis
                else
                    openSt.pop();
            }
        }
        todoRemove.addAll(openSt); // remove remain opening-parenthesis

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (!todoRemove.contains(i))
                stringBuilder.append(s.charAt(i));

        return stringBuilder.toString();
    }
}
