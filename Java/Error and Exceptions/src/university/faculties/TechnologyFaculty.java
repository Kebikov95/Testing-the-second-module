package university.faculties;

import university.exceptions.EmptyFacultyException;
import university.groups.Group;

import java.util.List;

public class TechnologyFaculty extends Faculty {
    public TechnologyFaculty(List<Group> groups) throws EmptyFacultyException {
        super(FacultyType.INFORMATION_TECHNOLOGY, groups);
    }
}
