package university.groups.technology;

import university.exceptions.EmptyGroupException;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.Gradebook;

import java.util.List;

public class JavaDevelopmentGroup extends TechnologyGroup {
    public JavaDevelopmentGroup(List<Student> studentList, Gradebook gradebook) throws EmptyGroupException {
        super(GroupType.JAVA_DEVELOPMENT, studentList, gradebook);
    }
}
