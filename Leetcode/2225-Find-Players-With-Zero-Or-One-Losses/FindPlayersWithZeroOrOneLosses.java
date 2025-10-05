

class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
    var noLoss = new HashSet<Integer>();
    var oneLoss = new HashSet<Integer>();
    var moreLoss = new HashSet<Integer>();

    for (int[] m: matches) {
        if (!noLoss.contains(m[0]) && !oneLoss.contains(m[0]) && !moreLoss.contains(m[0])) {
            noLoss.add(m[0]);
        }

        if (!moreLoss.contains(m[1])) {
            if (oneLoss.contains(m[1])) {
                oneLoss.remove(m[1]);
                moreLoss.add(m[1]);
            } else {
                noLoss.remove(m[1]);
                oneLoss.add(m[1]);
            }
        }
    }
    var noLossList = new ArrayList<Integer>(noLoss);
    var oneLossList = new ArrayList<Integer>(oneLoss);

    Collections.sort(noLossList);
    Collections.sort(oneLossList);
    return List.of(noLossList, oneLossList);
}
}
