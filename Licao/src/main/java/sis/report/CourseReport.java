package sis.report;

import java.util.*;
import sis.studentinfo.*;
import static sis.report.ReportConstant.NEWLINE;

public class CourseReport {
    private final ArrayList<Session> sessions = new ArrayList<>();
    public void add(Session session){
        sessions.add(session);
    }
    public String text(){
        StringBuilder builder = new StringBuilder();
        for (Session session: sessions)
            builder.append(session.getDepartment()).append(session.getNumber()).append(NEWLINE);
        return builder.toString();
    }
}
