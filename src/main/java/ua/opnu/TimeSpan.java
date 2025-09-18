package ua.opnu;


public class TimeSpan {
    private int hrs;
    private int mins;

    public TimeSpan(int hrs, int mins) {
        if (hrs >= 0 && mins >= 0 && mins <= 59) {
            this.hrs = hrs;
            this.mins = mins;
        } else {
            this.hrs = 0;
            this.mins = 0;
        }
    }

    int getHours() {
        return hrs;
    }

    int getMinutes() {
        return mins;
    }

    void add(int addHrs, int addMins) {
        if (addHrs < 0 || addMins < 0 || addMins > 59) return;
        int total = mins + addMins;
        mins = total % 60;
        hrs += addHrs + total / 60;
    }

    void addTimeSpan(TimeSpan t) {
        add(t.getHours(), t.getMinutes());
    }

    double getTotalHours() {
        return hrs + mins / 60.0;
    }

    int getTotalMinutes() {
        return hrs * 60 + mins;
    }

    void subtract(TimeSpan t) {
        int remaining = getTotalMinutes() - t.getTotalMinutes();
        if (remaining < 0) return;
        hrs = remaining / 60;
        mins = remaining % 60;
    }

    void scale(int factor) {
        if (factor <= 0) return;
        int total = getTotalMinutes() * factor;
        hrs = total / 60;
        mins = total % 60;
    }
}