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
import university.groups.economy.BusinessEconomicsGroup;
import university.groups.technology.JavaDevelopmentGroup;
import university.groups.technology.WebDevelopmentGroup;
import university.students.Student;
import university.subjects.Gradebook;
import university.subjects.SubjectType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<Student> javaStudents = new ArrayList<>();
        List<Student> webStudents = new ArrayList<>();
        Student student11 = new Student("Ivan", "Ivanovich", LocalDate.of(2000, 5, 10));
        Student student12 = new Student("Vasia", "Pupkin", LocalDate.of(2001, 2, 7));
        Student student13 = new Student("Alex", "Gropur", LocalDate.of(1999, 10, 5));
        Student student14 = new Student("Andrey", "Sochy", LocalDate.of(2002, 12, 3));
        Student student15 = new Student("Andrey", "Vlasov", LocalDate.of(2000, 1, 19));
        javaStudents.add(student11);
        javaStudents.add(student12);
        javaStudents.add(student13);
        javaStudents.add(student14);
        javaStudents.add(student15);

        Student student21 = new Student("Mike", "Fedotov", LocalDate.of(2001, 5, 10));
        Student student22 = new Student("Gary", "Shmeltzer", LocalDate.of(2002, 2, 7));
        Student student23 = new Student("Dmitry", "Nikonov", LocalDate.of(1998, 10, 5));
        Student student24 = new Student("Nukolay", "Litvinov", LocalDate.of(2001, 12, 3));
        Student student25 = new Student("Fedor", "Antonov", LocalDate.of(2000, 1, 19));
        webStudents.add(student21);
        webStudents.add(student22);
        webStudents.add(student23);
        webStudents.add(student24);
        webStudents.add(student25);

        Gradebook javaGroupGradebook = new Gradebook();
        Gradebook webGroupGradebook = new Gradebook();
        try {
            // Interception of the error "score below 0 or above 10".
            try {
                javaGroupGradebook.addRecord(student11, SubjectType.JAVA, 8);
                javaGroupGradebook.addRecord(student12, SubjectType.JAVA, 7);
                javaGroupGradebook.addRecord(student13, SubjectType.JAVA, 8);
                javaGroupGradebook.addRecord(student12, SubjectType.JAVA, 9);
                javaGroupGradebook.addRecord(student14, SubjectType.JAVA, 2);
                javaGroupGradebook.addRecord(student11, SubjectType.JAVA, 5);
                javaGroupGradebook.addRecord(student13, SubjectType.JAVA, 7);
                javaGroupGradebook.addRecord(student12, SubjectType.JAVA, 1);
                javaGroupGradebook.addRecord(student15, SubjectType.JAVA, 1);
                javaGroupGradebook.addRecord(student11, SubjectType.ENGLISH, 5);
                javaGroupGradebook.addRecord(student12, SubjectType.ENGLISH, 2);
                javaGroupGradebook.addRecord(student13, SubjectType.ENGLISH, 9);
                javaGroupGradebook.addRecord(student11, SubjectType.ENGLISH, 5);
                javaGroupGradebook.addRecord(student12, SubjectType.ENGLISH, 2);
                javaGroupGradebook.addRecord(student14, SubjectType.ENGLISH, 10);
                javaGroupGradebook.addRecord(student12, SubjectType.ENGLISH, 4);
                javaGroupGradebook.addRecord(student13, SubjectType.ENGLISH, 0);
                javaGroupGradebook.addRecord(student15, SubjectType.ENGLISH, 4);

                webGroupGradebook.addRecord(student21, SubjectType.JAVA, 8);
                webGroupGradebook.addRecord(student22, SubjectType.JAVA, 7);
                webGroupGradebook.addRecord(student23, SubjectType.JAVA, 8);
                webGroupGradebook.addRecord(student22, SubjectType.JAVA, 9);
                webGroupGradebook.addRecord(student24, SubjectType.JAVA, 2);
                webGroupGradebook.addRecord(student21, SubjectType.JAVA, 5);
                webGroupGradebook.addRecord(student23, SubjectType.JAVA, 7);
                webGroupGradebook.addRecord(student22, SubjectType.JAVA, 1);
                webGroupGradebook.addRecord(student25, SubjectType.JAVA, 10);
                webGroupGradebook.addRecord(student21, SubjectType.ENGLISH, 5);
                webGroupGradebook.addRecord(student22, SubjectType.ENGLISH, 2);
                webGroupGradebook.addRecord(student23, SubjectType.ENGLISH, 9);
                webGroupGradebook.addRecord(student21, SubjectType.ENGLISH, 5);
                webGroupGradebook.addRecord(student22, SubjectType.ENGLISH, 2);
                webGroupGradebook.addRecord(student24, SubjectType.ENGLISH, 8);
                webGroupGradebook.addRecord(student22, SubjectType.ENGLISH, 4);
                webGroupGradebook.addRecord(student23, SubjectType.ENGLISH, 0);
                webGroupGradebook.addRecord(student25, SubjectType.ENGLISH, 8);
            } catch (MarkException markException) {
                markException.printStackTrace();
            }

//            // Interception of the error "lack of students in the group".
//            try {
//                List<Student> economyStudents = new ArrayList<>();
//                Gradebook economyGradebook = new Gradebook();
//                Group economists = new BusinessEconomicsGroup(economyStudents, economyGradebook);
//            } catch (EmptyGroupException emptyGroupException) {
//                emptyGroupException.printStackTrace();
//            }
//
//            // Interception of the error "lack of groups at the faculty".
//            try {
//                List<Group> groups = new ArrayList<>();
//                EconomyFaculty economyFaculty = new EconomyFaculty(groups);
//            } catch (EmptyFacultyException emptyFacultyException) {
//                emptyFacultyException.printStackTrace();
//            }
//
//            // Interception of the error "lack of faculties at the university".
//            try {
//                List<Faculty> lawFaculty = new ArrayList<>();
//                University universityOfLaw = new University("University of law", lawFaculty);
//            } catch (EmptyUniversityException emptyUniversityException) {
//                emptyUniversityException.printStackTrace();
//            }

            Group javaDevelopmentGroup = new JavaDevelopmentGroup(javaStudents, javaGroupGradebook);
            Group webDevelopmentGroup = new WebDevelopmentGroup(webStudents, webGroupGradebook);
            List<Group> itGroups = new ArrayList<>();
            itGroups.add(javaDevelopmentGroup);
            itGroups.add(webDevelopmentGroup);
            TechnologyFaculty informationTechnologyFaculty = new TechnologyFaculty(itGroups);
            List<Faculty> faculties = new ArrayList<>();
            faculties.add(informationTechnologyFaculty);
            University university = new University("Belorussian University", faculties);

            System.out.printf("Get average mark of student '%s': %.2f\n", student11.getStudentName(),
                    university.getAverageMark(student11));
            System.out.printf("Get subject '%s' average mark in the faculty '%s' in group '%s': %.2f\n",
                    SubjectType.JAVA.getSubjectName(),
                    FacultyType.INFORMATION_TECHNOLOGY.getFacultyName(),
                    GroupType.JAVA_DEVELOPMENT.getGroupName(),
                    university.getAverageMark(SubjectType.JAVA, FacultyType.INFORMATION_TECHNOLOGY, GroupType.JAVA_DEVELOPMENT));
            System.out.printf("Get subject '%s' average mark of all university: %.2f\n",
                    SubjectType.JAVA.getSubjectName(), university.getAverageMark(SubjectType.JAVA));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
