package university.groups;

import university.exceptions.EmptyGroupException;
import university.students.Student;
import university.subjects.Gradebook;
import university.subjects.Record;
import university.subjects.SubjectType;

import java.util.List;

public abstract class Group {
    private GroupType groupType;
    private List<Student> studentList;
    private Gradebook gradebook;

    public Group(GroupType groupType, List<Student> studentList, Gradebook gradebook) throws EmptyGroupException {
        this.groupType = groupType;
        if(studentList.size() != 0) {
            this.studentList = studentList;
        } else {
            throw new EmptyGroupException("The group must have students, the number of students should be more than 0 ", studentList.size());
        }
        this.gradebook = gradebook;
    }

    public GroupType getGroupType() {
        return groupType;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public Gradebook getGradebook() {
        return gradebook;
    }

    public float getAverageMark(Student student) {
        int sum = 0;
        int count = 0;
        for (Record record:gradebook.getRecords()) {
            if(student.equals(record.getStudent())) {
                sum += record.getMark();
                count++;
            }
        }
        return (float) sum / count;
    }

    public float getAverageMark(SubjectType subjectType) {
        int sum = 0;
        int count = 0;
        for (Record record:gradebook.getRecords()) {
            if(subjectType == record.getSubjectType()) {
                sum += record.getMark();
                count++;
            }
        }
        return (float) sum / count;
    }
}
