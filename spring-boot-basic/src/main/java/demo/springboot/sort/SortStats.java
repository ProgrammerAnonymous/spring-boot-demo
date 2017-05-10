package demo.springboot.sort;

/**
 * Created by gemhuang on 2017/5/11.
 */
public class SortStats {
    private long steps;
    private double elapsed;
    private int size;

    public long getSteps() {
        return steps;
    }

    public void setSteps(long steps) {
        this.steps = steps;
    }

    public double getElapsed() {
        return elapsed;
    }

    public void setElapsed(double elapsed) {
        this.elapsed = elapsed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
