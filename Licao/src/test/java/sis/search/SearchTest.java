package sis.search;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class SearchTest {
    private static final String URL = "http://www.langrsoft.com";

    @Test
    public void testCreate() {
        Search search = new Search(URL, "x");
        assertEquals(URL, search.getUrl());
        assertEquals("x", search.getText());
    }

    @Test
    public void testPositiveSearch() {
        Search search = new Search(URL, "Jeff Langr");
        search.execute();
        assertTrue(search.matches() >= 1);
        assertFalse(search.errored());
    }

    @Test
    public void testNegativeSearch() {
        final String unlikelyText = "mama cass elliott";
        Search search = new Search(URL, unlikelyText);
        search.execute();
        assertEquals(0, search.matches());
        assertFalse(search.errored());
    }

    @Test
    public void testErroredSearch() {
        final String badUrl = URL + "/z2468.html";
        Search search = new Search(badUrl, "whatever");
        search.execute();
        assertTrue(search.arrored());
        assertEquals(FileNotFoundException.class, search.getError().getClass);
    }
}
