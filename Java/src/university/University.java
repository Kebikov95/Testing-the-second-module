package university;

import university.exceptions.EmptyFacultyException;
import university.exceptions.EmptyUniversityException;
import university.faculties.Faculty;
import university.faculties.FacultyType;
import university.groups.Group;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.SubjectType;

import java.util.List;

public class University {
    private String universityName;
    private List<Faculty> faculties;

    public University(String universityName, List<Faculty> faculties) throws EmptyUniversityException {
        this.universityName = universityName;
        if (faculties.size() != 0) {
            this.faculties = faculties;
        } else {
            throw new EmptyUniversityException("The university must have faculties, faculties size must be more than 0 ", faculties.size());
        }
    }

    public float getAverageMark(Student student) {
        float averageMark = 0;
        for (Faculty faculty:faculties) {
            for (Group group:faculty.getGroups()) {
                for (Student currentStudent:group.getStudentList()) {
                    if (currentStudent.equals(student)) averageMark = group.getAverageMark(student);
                }
            }
        }
        return averageMark;
    }

    public float getAverageMark(SubjectType subject, FacultyType facultyType, GroupType groupType) {
        float averageMark = 0;
        for (Faculty currentFaculty:faculties) {
            for (Group currentGroup:currentFaculty.getGroups()) {
                if (currentFaculty.getFacultyType() == facultyType &&
                        currentGroup.getGroupType() == groupType) {
                    averageMark = currentGroup.getAverageMark(subject);
                }
            }
        }
        return averageMark;
    }

    public float getAverageMark(SubjectType subject) {
        float averageMark = 0;
        for (Faculty currentFaculty:faculties) {
            for (Group currentGroup:currentFaculty.getGroups()) {
                    averageMark = currentGroup.getAverageMark(subject);
            }
        }
        return averageMark;
    }
}
