import java.util.*;

public class StudentManagementSystem {
    private List<Student> students = new ArrayList<>();

    public StudentManagementSystem() {
        // Add random sample data
        students.add(new Student("Alice", 101, "A", "CSE"));
        students.add(new Student("Bob", 102, "B", "ECE"));
        students.add(new Student("Charlie", 103, "A", "EEE"));
    }

    public void addStudent(Student s) {
        for (Student student : students) {
            if (student.getRollNumber() == s.getRollNumber()) {
                System.out.println("Student with this roll number already exists.");
                return;
            }
        }
        students.add(s);
        System.out.println("Student added.");
    }

    public void removeStudent(int rollNumber) {
        boolean removed = students.removeIf(s -> s.getRollNumber() == rollNumber);
        System.out.println(removed ? "Student removed." : "Student not found.");
    }

    public Student searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) return s;
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void editStudent(int roll, String name, String grade, String dept) {
        Student s = searchStudent(roll);
        if (s != null) {
            s.setName(name);
            s.setGrade(grade);
            s.setDepartment(dept);
            System.out.println("Student updated.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
