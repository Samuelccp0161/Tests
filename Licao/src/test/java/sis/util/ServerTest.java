package sis.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sis.search.ResultsListener;
import sis.search.Search;
import sis.search.SearchTest;

import static org.junit.Assert.assertTrue;

public class ServerTest {
    private int numberOfResults = 0;
    private Server server;
    private static final long TIMEOUT = 3000L;
    private static final String[] URLS = {
            SearchTest.URL, SearchTest.URL, SearchTest.URL
    };

    @Before
    public void setUp() throws  Exception{
        TestUtil.delete(SearchTest.FILE);
        LineWriter.write(SearchTest.FILE, SearchTest.TEST_HTML);

        ResultsListener listener = new ResultsListener(){
            public void executed(Search search){
                numberOfResults++;
            }
        };
        server = new Server(listener);
    }

    @After
    public void tearDown() throws Exception{
        TestUtil.delete(SearchTest.FILE);
    }
    @Test
    public void testSearch() throws Exception{
        long start = System.currentTimeMillis();
        for (String url : URLS){
            server.add(new Search(url, "xxx"));
        }
        long elapsed = System.currentTimeMillis() - start;
        long averageLatency = elapsed / URLS.length;
        assertTrue(averageLatency < 20);
        assertTrue(waitForResults());
    }
    private boolean waitForResults(){
        long start = System.currentTimeMillis();
        while (numberOfResults < URLS.length){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }if (System.currentTimeMillis() - start > TIMEOUT)
                return false;
        }
        return true;
    }
}
