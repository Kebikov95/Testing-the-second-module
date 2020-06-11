package university.groups.economy;

import university.exceptions.EmptyGroupException;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.Gradebook;

import java.util.List;

public class WorldEconomyGroup extends EconomyGroup {
    public WorldEconomyGroup(List<Student> studentList, Gradebook gradebook) throws EmptyGroupException {
        super(GroupType.WORLD_ECONOMY, studentList, gradebook);
    }
}
