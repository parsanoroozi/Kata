package time_formatter;

public class TimeFormatter {
    public static String formatDuration(int seconds) {

        if (seconds == 0) return "now";
        int yToS = 60 * 60 * 24 * 365;
        int dToS = 60 * 60 * 24;
        int hToS = 60 * 60;
        int mToS = 60;

        int year = seconds / yToS;
        seconds -= yToS * year;

        int day = seconds / dToS;
        seconds -= dToS * day;

        int hour = seconds / hToS;
        seconds -= hToS * hour;

        int minute = seconds / mToS;

        int second = seconds - mToS * minute;


        StringBuilder s = new StringBuilder(30);

        if (year > 0) {
            s.append(year).append(year > 1 ? " years" : " year");
        }

        if (day > 0) {
            if (hour > 0 || minute > 0 || second > 0) {
                if (s.isEmpty()) s.append(day).append(day > 1 ? " days" : " day");
                else s.append(", ").append(day).append(day > 1 ? " days" : " day");
            } else {
                if (s.isEmpty()) s.append(day).append(day > 1 ? " days" : " day");
                else s.append(" and ").append(day).append(day > 1 ? " days" : " day");
            }
        }

        if (hour > 0) {
            if (minute > 0 || second > 0) {
                if (s.isEmpty()) s.append(hour).append(hour > 1 ? " hours" : " hour");
                else s.append(", ").append(hour).append(hour > 1 ? " hours" : " hour");
            } else {
                if (s.isEmpty()) s.append(hour).append(hour > 1 ? " hours" : " hour");
                else s.append(" and ").append(hour).append(hour > 1 ? " hours" : " hour");
            }
        }

        if (minute > 0) {
            if (second > 0) {
                if (s.isEmpty()) s.append(minute).append(minute > 1 ? " minutes" : " minute");
                else s.append(", ").append(minute).append(minute > 1 ? " minutes" : " minute");
            } else {
                if (s.isEmpty()) s.append(minute).append(minute > 1 ? " minutes" : " minute");
                else s.append(" and ").append(minute).append(minute > 1 ? " minutes" : " minute");
            }
        }

        if (second > 0) {
            if (s.isEmpty()) s.append(second).append(second > 1 ? " seconds" : " second");
            else s.append(" and ").append(second).append(second > 1 ? " seconds" : " second");
        }


        return s.toString();
    }
}
