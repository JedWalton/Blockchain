
class Clock {

    int hours = 12;
    int minutes = 0;
    int minsInHour = 60;
    int hoursInClock12hr24hr = 12;

    public void next() {
        this.minutes++;
        if (this.minutes == minsInHour) {
            this.minutes = 0;
            this.hours++;
            if (this.hours == hoursInClock12hr24hr + 1) {
                this.hours = 1;
            }
        }
    }
}