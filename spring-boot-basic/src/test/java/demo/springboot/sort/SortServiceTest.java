package demo.springboot.sort;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    public void testSort() throws Exception{
        int[] instances = prepareRandomInstances();

        int[] results = service.sort(instances);

        verifySortedResults(results);
    }

    private int[] prepareRandomInstances() {
        return new int[0];
    }

    private void verifySortedResults(int[] results) {
        int before = results[0];

        for(int i=1; i<results.length; i++){
            int later = results[i];

            assertThat(before).isLessThanOrEqualTo(later);

            before = later;
        }
    }
}
