package university.faculties;

import university.exceptions.EmptyFacultyException;
import university.groups.Group;

import java.util.List;

public class EconomyFaculty extends Faculty {
    public EconomyFaculty(FacultyType facultyType, List<Group> groups) throws EmptyFacultyException {
        super(facultyType, groups);
    }
}
