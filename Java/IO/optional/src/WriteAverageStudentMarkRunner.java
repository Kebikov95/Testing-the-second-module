import java.io.*;
import java.util.Arrays;

// 5.In a file containing the names of students and their grades, write in capital
// letters the names of those students who have an average score of more than 7.
public class WriteAverageStudentMarkRunner {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("resources\\marks.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources\\marks.txt", true))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] array = line.split(",");
                Student student = (Student) makeStudentFromArray(array);
                try {
                    double average = student.getAverageMark();
                    System.out.printf(student.toString() + "\t-\t%.2f\n", student.getAverageMark());
                    if(average > 7) {
                        bw.write('\n' + student.lastName.toUpperCase());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Student makeStudentFromArray(String[] array) {
        String studentLastName = array[0];
        int[] studentMarks = new int[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            studentMarks[i - 1] = Integer.parseInt(array[i].trim());
        }
        return new Student(studentLastName, studentMarks);
    }

    static class Student {
        String lastName;
        int[] marks;

        public Student(String lastName, int[] marks) {
            this.lastName = lastName;
            this.marks = marks;
        }

        public double getAverageMark() throws Exception {
            int sum = 0;
            for (int mark : marks) {
                if(mark >= 0 && mark <= 10)
                    sum += mark;
                else
                    throw new Exception("The mark mast be more or equal zero and less than ten.");
            }
            return (double) sum / marks.length;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "lastName='" + lastName + '\'' +
                    ", marks=" + Arrays.toString(marks) +
                    '}';
        }
    }
}
