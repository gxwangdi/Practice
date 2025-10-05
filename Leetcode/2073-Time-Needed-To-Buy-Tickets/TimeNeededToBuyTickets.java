

class TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        for(int i =0; i<k+1; i++) {
            count += Math.min(tickets[i], tickets[k]);
        }
        for(int i =k+1; i<tickets.length; i++) {
            count += Math.min(tickets[i], tickets[k]-1);
        }
        return count;
    }
}
