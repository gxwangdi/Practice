
class PathCrossing {
    public boolean isPathCrossing(String path) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] p = new int[2];
        addPoint(map, p);
        for(int i=0; i<path.length(); i++) {
            char c = path.charAt(i);
            switch (c) {
                case 'N':
                    p[1]++;
                    break;
                case 'S':
                    p[1]--;
                    break;
                case 'E':
                    p[0]++;
                    break;
                case 'W':
                    p[0]--;
                    break;
            }
            if (isPointExist(map, p)) {
                return true;
            }
            addPoint(map, p);
        }
        return false;
    }

    private void addPoint(Map<Integer, Set<Integer>> map, int[] point) {
        Set<Integer> set = map.get(point[0]);
        if ( set == null) {
            set = new HashSet<>();
            map.put(point[0], set);
        }
        set.add(point[1]);
    }

    private boolean isPointExist(Map<Integer, Set<Integer>> map, int[] point) {
        if (!map.containsKey(point[0])) {
            return false;
        }
        Set<Integer> set = map.get(point[0]);
        return set.contains(point[1]);
    }
}
