class ReformatDate {
    public String reformatDate(String date) {
        String dateStrings[] = date.split(" ");
        String day = dateStrings[0].substring(0, dateStrings[0].length()-2);

        String month = getMonth(dateStrings[1]);
        String year = dateStrings[2];
        return new String(year + "-" + month + "-" + (day.length() == 1 ?  "0" + day   : day));

    }
    private String getMonth(String month) {
        switch(month) {
            case "Jan" : return "01";
            case "Feb" : return "02";
            case "Mar" : return "03";
            case "Apr" : return "04";
            case "May" : return "05";
            case "Jun" : return "06";
            case "Jul" : return "07";
            case "Aug" : return "08";
            case "Sep" : return "09";
            case "Oct" : return "10";
            case "Nov" : return "11";
            case "Dec" : return "12";
            default : return "";
        }
    }
}
