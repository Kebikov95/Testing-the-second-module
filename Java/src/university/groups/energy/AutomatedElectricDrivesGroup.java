package university.groups.energy;

import university.exceptions.EmptyGroupException;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.Gradebook;

import java.util.List;

public class AutomatedElectricDrivesGroup extends EnergyGroup {
    public AutomatedElectricDrivesGroup(List<Student> studentList, Gradebook gradebook) throws EmptyGroupException {
        super(GroupType.AUTOMATED_ELECTRIC, studentList, gradebook);
    }
}
