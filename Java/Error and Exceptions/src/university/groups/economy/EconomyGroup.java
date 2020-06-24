package university.groups.economy;

import university.exceptions.EmptyGroupException;
import university.groups.Group;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.Gradebook;

import java.util.List;

public abstract class EconomyGroup extends Group {
    public EconomyGroup(GroupType groupType, List<Student> studentList, Gradebook gradebook) throws EmptyGroupException {
        super(groupType, studentList, gradebook);
    }
}
