package com.wpi.asynch;

import com.google.common.base.Function;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Wiesław Piasecki on 01.12.13.
 */
public class ParallelExecutorServiceTestImpl {

    private ParallelExecutorService parallelExecutorService;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        parallelExecutorService = new ParallelExecutorService();
    }

    @Test
    public void testExecute() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted(Ticker.systemTicker());

        List<Integer> tasks = createTasks(100);
        List<Integer> result = parallelExecutorService.execute(tasks, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer o) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return o+100;
            }
        });
        stopwatch.stop();
        String s = stopwatch.toString();
        assertEquals(tasks, result);
    }

    private List<Integer> createTasks(int max) {
        List<Integer> tab = new ArrayList<Integer>(max);

        for (int i = 0; i < max; i++) {
            tab.add(i);
        }
        return tab;
    }
}
