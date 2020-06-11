package university.groups;

import university.exceptions.EmptyGroupException;
import university.faculties.Faculty;
import university.faculties.FacultyType;
import university.students.Student;
import university.subjects.Gradebook;
import university.subjects.Record;
import university.subjects.SubjectType;

import java.util.ArrayList;
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

    public float getAverageMark(Student student) throws Exception {
        return getAverageMark((Object) student);
    }

    public float getAverageMark(SubjectType subjectType) throws Exception {
        return getAverageMark((Object) subjectType);
    }

    private float getAverageMark(Object object) throws Exception {
        int sum = 0;
        Gradebook gradebook;
        if (object instanceof SubjectType) {
            gradebook  = this.gradebook.getGradebok((SubjectType) object);
        } else if(object instanceof Student) {
            gradebook = this.gradebook.getGradebok((Student) object);
        } else {
            throw new Exception("A entered value type isn't expected.");
        }

        for (Record record : gradebook.getRecords()) {
            sum += record.getMark();
        }
        return (float) sum / gradebook.getRecords().size();
    }
}
