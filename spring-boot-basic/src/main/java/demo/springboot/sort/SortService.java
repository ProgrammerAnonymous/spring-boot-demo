package demo.springboot.sort;

import org.javatuples.Pair;

/**
 * Created by gemhuang on 2017/5/9.
 */
public interface SortService {
    Pair<SortStats, int[]> sort(int[] instances);
}
