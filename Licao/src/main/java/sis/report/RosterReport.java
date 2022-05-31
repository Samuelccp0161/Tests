package sis.report;

import sis.studentinfo.CourseSession;
import sis.studentinfo.Student;

public class RosterReport {

        static final String NEWLINE = System.getProperty("line.separator");
        static final String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
        static final String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";

        private CourseSession session;

        RosterReport(CourseSession session){
            this.session = session;
        }

        String getReport(){
            StringBuilder buffer = new StringBuilder();

            buffer.append(ROSTER_REPORT_HEADER);

            for (Student student: session.getAllStudents()) {
                buffer.append(student.getName());
                buffer.append(NEWLINE);
            }

            buffer.append(ROSTER_REPORT_FOOTER + session.getAllStudents().size() + NEWLINE);
            return buffer.toString();
        }
    }
