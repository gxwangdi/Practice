

class Reorderdatainlogfiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isD1 = Character.isDigit(split1[1].charAt(0));
            boolean isD2 = Character.isDigit(split2[1].charAt(0));

            if (!isD1 && !isD2) {
                // int comp = split1[0].compareTo(split2[0]);
                // if (comp == 0) {
                //     comp = split1[1].compareTo(split2[1]);
                // }
                // return comp;
                // pay atention to requirement 2.
                int comp = split1[1].compareTo(split2[1]);
                if (comp == 0) return split1[0].compareTo(split2[0]);
                else return comp;
            } else if (isD1 && isD2) {
                // keep raw order
                return 0;
            } else if (isD1 && !isD2) {
                // reverse s1 and s2.
                return 1;
            } else {
                // keep in this order s1, s2.
                return -1;
            }
        });
        return logs;
    }
}
