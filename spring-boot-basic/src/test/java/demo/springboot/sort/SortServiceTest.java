package demo.springboot.sort;

import org.javatuples.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.FactoryBean;
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

    @Autowired
    private SortService service;

    @Test
    public void testSort() throws Exception {
        int[] instances = prepareRandomInstances();

        Pair<SortStats, int[]> results = service.sort(instances);

        verifySortedResults(results);
    }

    private int[] prepareRandomInstances() {
        return new int[]{5, 4, 1, 3, 2};
    }

    private void verifySortedResults(Pair<SortStats, int[]> results) {
        int[] sorted = results.getValue1();
        int before = sorted[0];

        for (int i = 1; i < sorted.length; i++) {
            int later = sorted[i];

            assertThat(before).isLessThanOrEqualTo(later);

            before = later;
        }
    }
}
