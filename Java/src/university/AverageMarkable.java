package university;

import university.students.Student;
import university.subjects.SubjectType;

public interface AverageMarkable {
    float getAverageMark(Student student);
    float getAverageMark(SubjectType subjectType);
}
