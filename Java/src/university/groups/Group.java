package university.groups;

import university.AverageMarkable;
import university.exceptions.EmptyGroupException;
import university.students.Student;
import university.subjects.Gradebook;
import university.subjects.Record;
import university.subjects.SubjectType;

import java.util.List;

public abstract class Group implements AverageMarkable {
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


    public boolean isGroupHasSubject(SubjectType subjectType) {
        List<Record> records = gradebook.getRecords();
        for (Record record : records) {
            return record.getSubjectType() == subjectType;
        }
        return false;
    }

    @Override
    public float getAverageMark(Student student) {
        int sum = 0;
        Gradebook gradebook = this.gradebook.getGradebook(student);
        for (Record record : gradebook.getRecords()) {
            sum += record.getMark();
        }
        return gradebook.getRecordSize() == 0 ? 0 : (float) sum / gradebook.getRecordSize();
    }

    @Override
    public float getAverageMark(SubjectType subjectType) {
        int sum = 0;
        Gradebook gradebook = this.gradebook.getGradebook(subjectType);
        for (Record record : gradebook.getRecords()) {
            sum += record.getMark();
        }
        return gradebook.getRecordSize() == 0 ? 0 : (float) sum / gradebook.getRecordSize();
    }
}
