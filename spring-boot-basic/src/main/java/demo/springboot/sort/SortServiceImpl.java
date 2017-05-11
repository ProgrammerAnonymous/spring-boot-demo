package demo.springboot.sort;

import org.javatuples.Pair;
import org.springframework.stereotype.Service;

/**
 * Created by gemhuang on 2017/5/10.
 */
@Service
public class SortServiceImpl implements SortService {

    @Override
    public Pair<SortStats, int[]> sort(int[] instances) {
        SortStats stats = SortStats.getInstanceBySize(instances.length);

        stats.startTimer();

        for (int i = 1; i < instances.length; i++) {
            stats.addSteps(insert(instances, i, instances[i]));
        }

        stats.stopTimer();

        System.out.println();

        return Pair.with(stats, instances);
    }

    private long insert(int[] instances, int pos, int value) {
        long steps = 0L;

        int flag = pos - 1;

        while (flag >= 0 && instances[flag] > value) {
            instances[flag + 1] = instances[flag];
            flag--;
            steps++;
        }

        instances[flag + 1] = value;

        return steps;
    }
}
