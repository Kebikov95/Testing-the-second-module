package university.faculties;

import university.exceptions.EmptyFacultyException;
import university.groups.Group;

import java.util.List;

public class EnergyFaculty extends Faculty {
    public EnergyFaculty(List<Group> groups) throws EmptyFacultyException {
        super(FacultyType.ENERGY, groups);
    }
}
