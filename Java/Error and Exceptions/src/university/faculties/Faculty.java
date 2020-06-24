package university.faculties;

import university.AverageMarkable;
import university.exceptions.EmptyFacultyException;
import university.groups.Group;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.SubjectType;

import java.util.List;

public abstract class Faculty implements AverageMarkable {
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

    public Group getGroup(GroupType type) {
        Group returnGroup = null;
        for (Group group : groups) {
            if(group.getGroupType() == type)  returnGroup = group;
        }
        return returnGroup;
    }

    public int getQuantityGroupsHavingSubject(SubjectType subjectType) {
        int count = 0;
        for (Group group : groups) {
            if(group.isGroupHasSubject(subjectType)) count++;
        }
        return count;
    }

    @Override
    public float getAverageMark(Student student) {
        float averageMark = 0;
        for (Group group : groups) {
            if(group.getStudentList().contains(student)) {
                averageMark = group.getAverageMark(student);
            }
        }
        return averageMark;
    }

    @Override
    public float getAverageMark(SubjectType subjectType) {
        float averageMark= 0;
        for (Group group : groups) {
            averageMark += group.getAverageMark(subjectType);
        }
        return  getQuantityGroupsHavingSubject(subjectType) == 0
                ? 0 : averageMark / getQuantityGroupsHavingSubject(subjectType);
    }
}
