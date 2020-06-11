package university;

import university.exceptions.EmptyFacultyException;
import university.exceptions.EmptyUniversityException;
import university.faculties.Faculty;
import university.faculties.FacultyType;
import university.groups.Group;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.Gradebook;
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

    // The method for calculating the average score for all subjects of a particular student.
    public float getAverageMark(Student student) throws Exception {
        float averageMark = 0;
        for (Faculty faculty : faculties) {
            for (Group group : faculty.getGroups()) {
                for (Student currentStudent:group.getStudentList()) {
                    if (currentStudent.equals(student)) averageMark = group.getAverageMark(student);
                }
            }
        }
        return averageMark;
    }

    // The method for calculating the average score for a specific subject in a specific group and at a specific faculty.
    public float getAverageMark(SubjectType subject, FacultyType facultyType, GroupType groupType) throws Exception {
        float averageMark = 0;
        for (Faculty currentFaculty : faculties) {
            for (Group currentGroup : currentFaculty.getGroups()) {
                if (currentFaculty.getFacultyType() == facultyType &&
                        currentGroup.getGroupType() == groupType) {
                    averageMark = currentGroup.getAverageMark(subject);
                }
            }
        }
        return averageMark;
    }

    // The method for calculating the average grade for a specific subject for the entire university.
    public float getAverageMark(SubjectType subject) throws Exception {
        float averageMark = 0;
        int count = 0;
        for (Faculty currentFaculty : faculties) {
            for (Group currentGroup : currentFaculty.getGroups()) {
                if(currentGroup.getAverageMark(subject) > 0) {
                    averageMark += currentGroup.getAverageMark(subject);
                    count++;
                }
            }
        }
        return averageMark / count;
    }
}
