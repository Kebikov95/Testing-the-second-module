package university.faculties;

import university.exceptions.EmptyFacultyException;
import university.groups.Group;
import university.groups.GroupType;

import java.util.ArrayList;
import java.util.List;

public abstract class Faculty {
    private FacultyType facultyType;
    private List<Group> groups;

    public Faculty(FacultyType facultyType, List<Group> groups) throws EmptyFacultyException {
        this.facultyType = facultyType;
        if (groups.size() != 0) {
            this.groups = groups;
        } else {
            throw new EmptyFacultyException("The faculties must have groups, groups size must be more than 0 ", groups.size());
        }
    }

    public FacultyType getFacultyType() {
        return facultyType;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
