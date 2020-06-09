package university.faculties;

import university.exceptions.EmptyFacultyException;
import university.groups.Group;

import java.util.List;

public class TechnologyFaculty extends Faculty {
    public TechnologyFaculty(FacultyType facultyType, List<Group> groups) throws EmptyFacultyException {
        super(facultyType, groups);
    }
}
