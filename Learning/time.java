public class time {
    private int hour;
    private int minute;
    private int second;

    public static void main(String[] args) {
        time enter = new time();
        System.out.println(enter.toMilitary());
        enter.setTime(13, 24, 12);
        System.out.println(enter.toMilitary());
        enter.setTime(14, 28, 7);
        System.out.println(enter.standardTime());
    }

    public void setTime(int h, int m, int s) {
        hour = ((h >= 0 && h < 24) ? h : 0);
        minute = ((m > 0 && m < 60) ? m : 0);
        second = ((s > 0 && s < 60) ? s : 0);
    }

    public String toMilitary() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public String standardTime() {
        return String.format("%d:%02d:%02d %s", ((hour == 0 || hour == 12) ? 12 : hour % 12), minute, second, (hour < 12 ? "AM" : "PM"));
    }
}
