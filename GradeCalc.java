import java.util.*;

class Student {
    String name;
    double total;
    double average;
    char grade;

    Student(String name, double total, double average, char grade) {
        this.name = name;
        this.total = total;
        this.average = average;
        this.grade = grade;
    }
}

public class GradeCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            // Ask for student name
            System.out.print("\nEnter Student Name (or type 'exit' to stop): ");
            String name = sc.nextLine();

            // Exit condition
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            double total = 0;
            // Input marks for 4 subjects
            for (int i = 0; i < 4; i++) {
                System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                total += sc.nextDouble();
            }

            // Clear buffer
            sc.nextLine();

            // Calculate average
            double average = total / 4.0;

            // Grade calculation
            char grade;
            if (average >= 90) {
                grade = 'A';
            } else if (average >= 75) {
                grade = 'B';
            } else if (average >= 60) {
                grade = 'C';
            } else if (average >= 40) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            // Save student data
            students.add(new Student(name, total, average, grade));
        }

        // Final Summary
        System.out.println("\n===== STUDENT SUMMARY =====");
        System.out.printf("%-15s %-10s %-10s %-5s\n", "Name", "Total", "Average", "Grade");
        System.out.println("------------------------------------------");

        for (Student s : students) {
            System.out.printf("%-15s %-10.2f %-10.2f %-5c\n", s.name, s.total, s.average, s.grade);
        }

        System.out.println("==========================================");

        sc.close();
    }
}


