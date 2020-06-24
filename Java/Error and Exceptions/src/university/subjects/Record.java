package university.subjects;

import university.exceptions.MarkException;
import university.students.Student;

public class Record {
    private Student student;
    private SubjectType subjectType;
    private int mark;

    public Record(Student student, SubjectType subjectType, int mark) throws MarkException {
        this.student = student;
        this.subjectType = subjectType;
        if (mark <= 10 && mark >= 0) {
            this.mark = mark;
        } else {
            throw new MarkException("Mark must be more than 0 and less than 10", mark);
        }
    }

    public Student getStudent() {
        return student;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public int getMark() {
        return mark;
    }

    public String getRecordLine() {
        return student.getStudentName() + " - '" + subjectType + "': " + mark;
    }

    @Override
    public String toString() {
        return "Record{" +
                "student=" + student +
                ", subjectType=" + subjectType +
                ", mark=" + mark +
                '}';
    }
}
