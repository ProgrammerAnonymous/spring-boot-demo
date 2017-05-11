package demo.springboot.sort;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by gemhuang on 2017/5/11.
 */
public class SortStats {

    private static final BigDecimal NANOS_TO_SEC = BigDecimal.valueOf(1000000000L);
    private static final String STRING_TMPL = "本次排序數列大小為 %1$d，排序時間為 %2$f 秒，執行步數為 %3$d";

    public static SortStats getInstanceBySize(int size) {
        return new SortStats(size);
    }

    private long steps = 0L;
    private double elapsed = 0.0;
    private int size = 0;

    private Instant startTime;
    private Instant stopTime;
    private Duration elapsedTime = Duration.ZERO;

    public SortStats() {}

    public SortStats(int size) {
        this.size = size;
    }

    public void startTimer() {
        startTime = Instant.now();
    }

    public void stopTimer() {
        stopTime = Instant.now();
        elapsedTime = elapsedTime.plus(Duration.between(startTime, stopTime));
    }

    public long getSteps() {
        return steps;
    }

    public void setSteps(long steps) {
        this.steps = steps;
    }

    public void addSteps(long steps) {
        this.steps += steps;
    }

    public double getElapsed() {
        if (this.elapsed == 0) {
            this.elapsed = BigDecimal.valueOf(elapsedTime.toNanos())
                                     .divide(NANOS_TO_SEC).doubleValue();
        }
        return elapsed;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return String.format(STRING_TMPL, getSize(), getElapsed(), getSteps());
    }
}
