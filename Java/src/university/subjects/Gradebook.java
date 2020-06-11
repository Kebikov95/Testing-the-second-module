package university.subjects;

import university.exceptions.MarkException;
import university.students.Student;

import java.util.ArrayList;
import java.util.List;

public class Gradebook {
    private List<Record> records;

    public Gradebook() {
        records = new ArrayList<>();
    }

    public Gradebook(List<Record> records) {
        this.records = records;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void addRecord(Student student, SubjectType subjectType, int mark) throws MarkException {
        records.add(new Record(student, subjectType, mark));
    }

    public Gradebook getGradebok(Student student) throws Exception {
        return getGradebook((Object) student);
    }

    public Gradebook getGradebok(SubjectType type) throws Exception {
        return getGradebook((Object) type);
    }

    private Gradebook getGradebook(Object object) throws Exception {
        List<Record> returnRecordList = new ArrayList<>();
        for (Record record : records) {
            if (object instanceof SubjectType) {
                if(record.getSubjectType() == object) returnRecordList.add(record);
            } else if(object instanceof Student) {
                if(object.equals(record.getStudent())) returnRecordList.add(record);
            } else {
                throw new Exception("A entered value type isn't expected.");
            }
        }
        return new Gradebook(returnRecordList);
    }

    public void display() {
        for (Record record:records) {
            System.out.println(record.getRecordLine());
        }
    }

    @Override
    public String toString() {
        return "Gradebook{" +
                "records=" + records +
                '}';
    }
}
