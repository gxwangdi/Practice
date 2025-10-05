class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> sources = new HashSet<>();
        for(List<String> path: paths) {
            sources.add(path.get(0));
        }
        for(List<String> path: paths) {
            if(!sources.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return "";
    }
}
