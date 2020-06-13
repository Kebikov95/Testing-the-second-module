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

    public int getRecordSize() {
        return records.size();
    }

    public Gradebook getGradebook(Student student) {
        List<Record> returnRecordList = new ArrayList<>();
        for (Record record : records) {
            if (student.equals(record.getStudent())) returnRecordList.add(record);
        }
        return new Gradebook((returnRecordList));
    }

    public Gradebook getGradebook(SubjectType type) {
        List<Record> returnRecordList = new ArrayList<>();
        for (Record record : records) {
            if(record.getSubjectType() == type) returnRecordList.add(record);
        }
        return new Gradebook(returnRecordList);
    }

    @Override
    public String toString() {
        return "Gradebook{" +
                "records=" + records +
                '}';
    }
}
