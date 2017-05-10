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
        for (int i = 1; i < instances.length; i++) {
            insert(instances, i, instances[i]);
        }

        return Pair.with(null, instances);
    }

    private void insert(int[] instances, int pos, int value) {
        int flag = pos - 1;

        while (flag >= 0 && instances[flag] > value) {
            instances[flag + 1] = instances[flag];
            flag--;
        }

        instances[flag + 1] = value;
    }
}
