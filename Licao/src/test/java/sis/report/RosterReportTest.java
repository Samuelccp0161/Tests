package sis.report;

import org.junit.Test;
import sis.studentinfo.*;

import java.io.*;

import static org.junit.Assert.assertTrue;
import static sis.report.ReportConstant.NEWLINE;
import static org.junit.Assert.assertEquals;

public class RosterReportTest {
        private Session session;
        protected void setUp() {
            session = CourseSession.create(new Course("ENGL", "101"), DateUtil.createDate(2003, 1, 6));
            session.enroll(new Student("A"));
            session.enroll(new Student("B"));
        }
    @Test
    public void testRosterReport() throws IOException {

        Writer writer = new StringWriter();
        new RosterReport(session).writeReport(writer);
        String rosterReport = writer.toString();
        assertReportContents(writer.toString());
    }
    private void assertReportContents(String rosterReport){
        assertEquals(String.format(RosterReport.ROSTER_REPORT_HEADER
                + "A%n" +
                  "B%n" +
                RosterReport.ROSTER_REPORT_FOOTER, 2), rosterReport);
    }
    @Test
    public void testFiledReport() throws IOException {
        final String filename = "testFiledReport.txt";
        try {
            delete(filename);

            new RosterReport(session).writeReport(filename);

            StringBuffer buffer = new StringBuffer();
            String line;

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null)
                buffer.append(String.format(line + "%n"));
            reader.close();

            assertReportContents(buffer.toString());
        }
        finally {
            delete(filename);
        }
    }
    private void delete(String filename){
        File file = new File(filename);
        if (file.exists())
            assertTrue("unable to delete " + filename, file.delete());
    }
}
