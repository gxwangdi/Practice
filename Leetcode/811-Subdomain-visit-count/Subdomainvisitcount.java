

class Subdomainvisitcount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String str : cpdomains) {
            String[] str1 = str.split(" ");
            int count = Integer.parseInt(str1[0]);
            String[] str2 = str1[1].split("\\.");
            // StringBuilder sb = new StringBuilder();
            String s = "";
            for(int i=str2.length-1; i>=0; i--) {
                // sb.append(str2[i]);
                // System.out.println("count:" + count + " sb:" + sb.toString());
                // String key = sb.reverse().toString();
                s = str2[i] + s;
                map.put(s, map.getOrDefault(s, 0) + count);
                // sb.append('.');
                s = "." + s;
            }
        }
        List<String> list = new ArrayList<>(map.size());
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            // System.out.println("value:" + entry.getValue() + " key:" + entry.getKey());
            sb.setLength(0);
            sb.append(entry.getValue()).append(" ").append(entry.getKey());
            list.add(sb.toString());
        }
        return list;
    }
}
