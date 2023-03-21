package sis.search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sis.util.LineWriter;
import sis.util.TestUtil;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SearchSchedulerTest {
    private int actualResultsCount = 0;
    @Before
    public void setUp() throws IOException {
        TestUtil.delete(SearchTest.FILE);
        LineWriter.write(SearchTest.FILE, SearchTest.TEST_HTML);
    }
    @After
    public void tearDown() throws Exception {
        TestUtil.delete(SearchTest.FILE);
    }

    @Test
    public void testRepeatedSearch() throws Exception {
        final int searchInterval = 3000;
        Search search = new Search(sis.search.SearchTest.URL, "xxx");
        ResultsListener listener = new ResultsListener() {
            @Override
            public void executed(Search search) {
                ++actualResultsCount;
            }
        };
        SearchScheduler scheduler = new SearchScheduler(listener);
        scheduler.repeat(search, searchInterval);

        final int expectedResultsCount = 3;
        Thread.sleep((expectedResultsCount - 1) * searchInterval + 1000);

        scheduler.stop();
        assertEquals(expectedResultsCount, actualResultsCount);
    }
}
