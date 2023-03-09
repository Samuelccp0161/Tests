package sis.search;

import org.junit.Test;
import sis.util.LineWriter;
import sis.util.TestUtil;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

public class SearchTest {
    public static final String[] TEST_HTML = {
            "<hyml>",
            "<body>",
            "Book: Agile Java, by Jeff Langr <br />",
            "Synopsis: Mr Langr teaches you<br />",
            "Java via test-driven development.<br />",
            "/body></html>"
    };

    public static final String FILE = "testFileSearch.html";
    public static final String URL = "file: " + FILE;

    protected void setUp() throws IOException {
        TestUtil.delete(FILE);
        LineWriter.write(FILE, TEST_HTML);
    }
    protected void tearDown() throws IOException{
        TestUtil.delete(FILE);
    }

    @Test
    public void testCreate() throws IOException {
        Search search = new Search(URL, "x");
        assertEquals(URL, search.getUrl());
        assertEquals("x", search.getText());
    }

    @Test
    public void testPositiveSearch() throws IOException {
        Search search = new Search(URL, "Jeff Langr");
        search.execute();
        assertTrue(search.matches() >= 1);
        assertFalse(search.errored());
    }

    @Test
    public void testNegativeSearch() throws IOException {
        final String unlikelyText = "mama cass elliott";
        Search search = new Search(URL, unlikelyText);
        search.execute();
        assertEquals(0, search.matches());
        assertFalse(search.errored());
    }

    @Test
    public void testErroredSearch() throws IOException {
        final String badUrl = URL + "/z2468.html";
        Search search = new Search(badUrl, "whatever");
        search.execute();
        assertTrue(search.errored());
        assertEquals(FileNotFoundException.class, search.getError().getClass());
    }
}
