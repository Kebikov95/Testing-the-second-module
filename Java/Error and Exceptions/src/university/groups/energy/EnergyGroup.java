package university.groups.energy;

import university.exceptions.EmptyGroupException;
import university.groups.Group;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.Gradebook;

import java.util.List;

public abstract class EnergyGroup extends Group {
    public EnergyGroup(GroupType groupType, List<Student> studentList, Gradebook gradebook) throws EmptyGroupException {
        super(groupType, studentList, gradebook);
    }
}
