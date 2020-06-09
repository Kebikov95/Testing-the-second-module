package university;

import university.exceptions.EmptyFacultyException;
import university.exceptions.EmptyGroupException;
import university.exceptions.EmptyUniversityException;
import university.exceptions.MarkException;
import university.faculties.EconomyFaculty;
import university.faculties.Faculty;
import university.faculties.FacultyType;
import university.faculties.TechnologyFaculty;
import university.groups.Group;
import university.groups.GroupType;
import university.groups.technology.JavaDevelopmentGroup;
import university.groups.technology.WebDevelopmentGroup;
import university.students.Student;
import university.subjects.Gradebook;
import university.subjects.SubjectType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("Kirill", "Kebikov", LocalDate.of(1995, 3, 9));
        Student student2 = new Student("Vasia", "Pupkin", LocalDate.of(1995, 3, 9));
        Student student3 = new Student("Alex", "Gropur", LocalDate.of(1995, 3, 9));
        Student student4 = new Student("Andrey", "Sochy", LocalDate.of(1995, 3, 9));
        Student student5 = new Student("Andrey", "Vlasov", LocalDate.of(1995, 3, 9));
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        Gradebook gradebook = new Gradebook();
        try {
            try {
                gradebook.addRecord(student1, SubjectType.JAVA, 8);
                gradebook.addRecord(student2, SubjectType.JAVA, 7);
                gradebook.addRecord(student3, SubjectType.JAVA, 8);
                gradebook.addRecord(student2, SubjectType.JAVA, 9);
                gradebook.addRecord(student4, SubjectType.JAVA, 2);
                gradebook.addRecord(student1, SubjectType.JAVA, 5);
                gradebook.addRecord(student3, SubjectType.JAVA, 7);
                gradebook.addRecord(student2, SubjectType.JAVA, 1);
                gradebook.addRecord(student1, SubjectType.ENGLISH, 5);
                gradebook.addRecord(student2, SubjectType.ENGLISH, 2);
                gradebook.addRecord(student3, SubjectType.ENGLISH, 9);
                gradebook.addRecord(student1, SubjectType.ENGLISH, 5);
                gradebook.addRecord(student2, SubjectType.ENGLISH, 2);
                gradebook.addRecord(student4, SubjectType.ENGLISH, 10);
                gradebook.addRecord(student2, SubjectType.ENGLISH, 4);
                gradebook.addRecord(student3, SubjectType.ENGLISH, 0);
            } catch (MarkException markException) {
                markException.printStackTrace();
            }

            try {
                List<Student> webStudents = new ArrayList<>();
                Group webDev = new WebDevelopmentGroup(GroupType.WEB_DEVELOPMENT, webStudents, gradebook);
            } catch (EmptyGroupException emptyGroupException) {
                emptyGroupException.printStackTrace();
            }

            try {
                List<Group> groups = new ArrayList<>();
                EconomyFaculty economyFaculty = new EconomyFaculty(FacultyType.ECONOMY, groups);
            } catch (EmptyFacultyException emptyFacultyException) {
                emptyFacultyException.printStackTrace();
            }

            try {
                List<Faculty> lawFaculty = new ArrayList<>();
                University universityOfLaw = new University("University of law", lawFaculty);
            } catch (EmptyUniversityException emptyUniversityException) {
                emptyUniversityException.printStackTrace();
            }

            Group javaDevelopmentGroup = new JavaDevelopmentGroup(GroupType.JAVA_DEVELOPMENT, students, gradebook);
            TechnologyFaculty informationTechnologyFaculty = new TechnologyFaculty(FacultyType.INFORMATION_TECHNOLOGY,
                    Collections.singletonList(javaDevelopmentGroup));
            List<Faculty> faculties = new ArrayList<>();
            faculties.add(informationTechnologyFaculty);
            University university = new University("Belorussian University", faculties);

            System.out.println("Get student average mark: " + university.getAverageMark(student2));

            System.out.println("Get subject average mark: " + university.getAverageMark(SubjectType.JAVA, FacultyType.INFORMATION_TECHNOLOGY, GroupType.JAVA_DEVELOPMENT));

            System.out.println("Get subject average mark of all university: " + university.getAverageMark(SubjectType.JAVA));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
