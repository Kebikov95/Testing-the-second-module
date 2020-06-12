package university;

import university.exceptions.EmptyUniversityException;
import university.faculties.Faculty;
import university.faculties.FacultyType;
import university.groups.Group;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.SubjectType;

import java.util.List;

public class University implements AverageMarkable {
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

    public Faculty getFaculty(FacultyType facultyType) {
        Faculty returnFaculty = null;
        for (Faculty faculty : faculties) {
            if (faculty.getFacultyType() == facultyType) returnFaculty = faculty;
        }
        return returnFaculty;
    }

    // The method for calculating the average grade for a specific student for the entire university.
    @Override
    public float getAverageMark(Student student) {
        float averageMark = 0;
        for (Faculty faculty : faculties) {
            averageMark += faculty.getAverageMark(student);
        }
        return averageMark;
    }

    // The method for calculating the average grade for a specific subject for the entire university.
    @Override
    public float getAverageMark(SubjectType subjectType) {
        float sumAverageMark = 0;
        for (Faculty faculty : faculties) {
            sumAverageMark += faculty.getAverageMark(subjectType);
        }
        return (float) sumAverageMark / faculties.size();
    }

    // The method for calculating the average score for a specific subject in a specific group and at a specific faculty.
    public float getAverageMark(SubjectType subjectType, FacultyType facultyType, GroupType groupType) {
        Faculty faculty = getFaculty(facultyType);
        Group group = faculty.getGroup(groupType);
        return group.getAverageMark(subjectType);
    }
}
