package demo.springboot.sort;

import org.javatuples.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by gemhuang on 2017/5/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SortServiceTest {
    private static final Logger log = LoggerFactory.getLogger(SortServiceTest.class);

    @Autowired
    private SortService service;

    @Test
    public void testSort() throws Exception {
        int[] instances = prepareRandomInstances();

        Pair<SortStats, int[]> results = service.sort(instances);

        verifySortedStats(results.getValue0());
        verifySortedValues(results.getValue1());
    }

    private int[] prepareRandomInstances() {
        return new int[]{5, 4, 1, 3, 2};
    }

    private void verifySortedStats(SortStats stats) {
        assertThat(stats).isNotNull();

        log.info(stats.toString());
    }

    private void verifySortedValues(int[] sorted) {
        int before = sorted[0];

        for (int i = 1; i < sorted.length; i++) {
            int later = sorted[i];

            assertThat(before).isLessThanOrEqualTo(later);

            before = later;
        }
    }
}
