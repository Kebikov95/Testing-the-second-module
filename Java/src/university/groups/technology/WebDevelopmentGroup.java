package university.groups.technology;

import university.exceptions.EmptyGroupException;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.Gradebook;

import java.util.List;

public class WebDevelopmentGroup extends TechnologyGroup {
    public WebDevelopmentGroup(List<Student> studentList, Gradebook gradebook) throws EmptyGroupException {
        super(GroupType.WEB_DEVELOPMENT, studentList, gradebook);
    }
}
