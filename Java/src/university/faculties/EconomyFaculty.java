package university.faculties;

import university.exceptions.EmptyFacultyException;
import university.groups.Group;

import java.util.List;

public class EconomyFaculty extends Faculty {
    public EconomyFaculty(List<Group> groups) throws EmptyFacultyException {
        super(FacultyType.ECONOMY, groups);
    }
}
