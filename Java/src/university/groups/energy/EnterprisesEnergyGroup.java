package university.groups.energy;

import university.exceptions.EmptyGroupException;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.Gradebook;

import java.util.List;

public class EnterprisesEnergyGroup extends EnergyGroup {
    public EnterprisesEnergyGroup(GroupType groupType, List<Student> studentList, Gradebook gradebook) throws EmptyGroupException {
        super(groupType, studentList, gradebook);
    }
}
