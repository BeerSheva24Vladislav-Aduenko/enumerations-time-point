package telran.time;

public class TimePoint implements Comparable<TimePoint>{
    private float amount;
    private TimeUnit timeUnit;
    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }
    @Override
    public int compareTo(TimePoint arg0) {
        return (int)TimeUnit.SECOND.between(arg0, this);
    }

    @Override
    public boolean equals(Object obj) {
        return (int)TimeUnit.SECOND.between(this, (TimePoint) obj) == 0;
    }

    public float getAmount(){
        return amount;
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public TimePoint convert(TimeUnit timeUnit) {
        return new TimePoint(getTimeUnit().getValueOfSeconds() * amount / timeUnit.getValueOfSeconds(), timeUnit);
    }
    public TimePoint with(TimePointAdjuster adjuster) {
        return adjuster.adjust(this);
    }

}