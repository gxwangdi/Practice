

class Analyzeuserwebsitevisitpattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Item>> map = new HashMap<>();
        int n = username.length;
        for (int i=0; i<n; i++) {
            map.putIfAbsent(username[i], new ArrayList<>());
            map.get(username[i]).add(new Item(timestamp[i], website[i]));
        }

        Map<String, Integer> count = new HashMap<>();
        String res = "";
        for (String key : map.keySet()) {
            Set<String> set = new HashSet<>(); // to avoid duplicats.
            List<Item> list = map.get(key);
            Collections.sort(list, (a,b)->a.time-b.time);
            // brutal force O(N ^ 3)
            for (int i=0; i<list.size(); i++) {
                for (int j=i+1; j<list.size(); j++) {
                    for (int k=j+1; k<list.size(); k++) {
                        String s = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
                        if (!set.contains(s)) {
                            count.put(s, count.getOrDefault(s, 0)+1);
                            set.add(s);
                        }
                        if ("".equals(res) ||count.get(res) < count.get(s) || (count.get(res)==count.get(s) && res.compareTo(s) >0)) {
                            res = s;
                        }
                    }
                }
            }
        }
        List<String> result = Arrays.asList(res.split(" "));
        return result;
    }

    // the item contains int and String, can not use array of any type.
    private static class Item {
        int time;
        String web;
        public Item(int t, String w) {
            time = t;
            web = w;
        }
    }
}
