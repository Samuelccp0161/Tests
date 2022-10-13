package sis.report;

import sis.studentinfo.Session;
import sis.studentinfo.Student;
import java.io.*;


public class RosterReport {
//    static final String NEWLINE = System.getProperty("line.separator");
    static final String ROSTER_REPORT_HEADER = "Student%n-%n";
    static final String ROSTER_REPORT_FOOTER = "%n# students = %d%n";
    private final Session session;
    private Writer writer;
    RosterReport(Session session){
        this.session = session;
    }
    void writeReport(Writer writer) throws IOException{
        this.writer = writer;
        writeHeader();
        writeBody();
        writeFooter();
    }
    private void writeHeader() throws IOException {
        writer.write(String.format(ROSTER_REPORT_HEADER));
    }
    void writeBody() throws IOException{
        for (Student student: session.getAllStudents()){
            writer.write(String.format(student.getName() + "%n"));
        }
    }
    void writeFooter() throws IOException {
        writer.write(String.format(ROSTER_REPORT_FOOTER, session.getAllStudents().size()));
    }
    void writeReport(String filename) throws IOException{
        Writer bufferedWriter = new BufferedWriter(new FileWriter(filename));
        try {
            writeReport(bufferedWriter);
        }
        finally {
            bufferedWriter.close();
        }
    }

}
