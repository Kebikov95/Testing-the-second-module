package university.groups.economy;

import university.exceptions.EmptyGroupException;
import university.groups.GroupType;
import university.students.Student;
import university.subjects.Gradebook;

import java.util.List;

public class BusinessEconomicsGroup extends EconomyGroup {
    public BusinessEconomicsGroup(List<Student> studentList, Gradebook gradebook) throws EmptyGroupException {
        super(GroupType.BUSINESS_ECONOMICS, studentList, gradebook);
    }
}
