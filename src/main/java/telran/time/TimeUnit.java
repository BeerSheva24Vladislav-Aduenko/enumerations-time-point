package telran.time;

public enum TimeUnit {
    SECOND(1), MINUTE(60), HOUR(3600);
    private int valueOfSeconds;
    TimeUnit(int valuOfSeconds) {
        this.valueOfSeconds = valuOfSeconds;
    }
    public int getValueOfSeconds(){
        return valueOfSeconds;
    }
    public float between(TimePoint p1, TimePoint p2) { 
        float p1Amout = p1.getTimeUnit().getValueOfSeconds() * p1.getAmount();
        float p2Amout = p2.getTimeUnit().getValueOfSeconds() * p2.getAmount();
        return (p2Amout - p1Amout) / valueOfSeconds;
    }
}