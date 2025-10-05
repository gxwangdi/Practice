

class Alertusingsamekeycardthreeormoretimesinaonehourperiod {
    // public List<String> alertNames(String[] keyName, String[] keyTime){
    //     Map<String, Map<Integer, List<String>>> map = new HashMap<>();
    //     for(int i=0; i<keyName.length; i++) {
    //         Map<Integer, List<String>> vm = map.getOrDefault(keyName[i], new HashMap<Integer, List<String>>());
    //         String[] str = keyTime[i].split(":");
    //         int hour = Integer.parseInt(str[0]);
    //         var set1 = vm.getOrDefault(hour, new ArrayList<String>());
    //         set1.add(str[1]);
    //         vm.put(hour, set1);
    //         if ("00".equals(str[1])) {
    //             hour--;
    //             set1 = vm.getOrDefault(hour, new ArrayList<String>());
    //             set1.add(str[1]);
    //             vm.put(hour, set1);
    //         }
    //         map.put(keyName[i], vm);
    //     }
    //     List<String> res = new ArrayList<>();
    //     for(Map.Entry<String, Map<Integer, List<String>>> entry : map.entrySet()) {
    //         Map<Integer, List<String>> value = entry.getValue();
    //         for(List<String> set : value.values()) {
    //             if (set.size() >= 3) {
    //                 res.add(entry.getKey());
    //                 break;
    //             }
    //         }
    //     }
    //     Collections.sort(res);
    //     return res;
    // }

    // For "22:51" - "23:52" is considered to be within a one-hour period.
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0; i<keyName.length; i++) {
            int time = convertTime(keyTime[i]);
            List<Integer> set = map.getOrDefault(keyName[i], new ArrayList<Integer>());
            set.add(time);
            map.put(keyName[i], set);
        }

        List<String> res = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            // boolean flag = false;
            for(int i=0; i+2<list.size(); i++) {
                // if (list.get(i+1)-list.get(i)<=60 && list.get(i+2)-list.get(i+1)<=60) {
                //     flag = true;
                //     break;
                // }
                if (list.get(i+2) - list.get(i) <= 60) {
                    res.add(entry.getKey());
                    break;
                }
            }
            // if (flag) {
            //     res.add(entry.getKey());
            // }
        }
        Collections.sort(res);
        return res;
    }

    private int convertTime(String s) {
        String[] time = s.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        return hour*60 + minute;
    }
}
