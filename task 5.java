import java.io.*;
import java.util.ArrayList;

class Student implements Serializable {
    private String name;
    private String rollNumber;
    private String grade;

    // Additional details can be stored in a HashMap or any other appropriate data structure
    private String details;

    public Student(String name, String rollNumber, String grade, String details) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + ", Details: " + details;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean removeStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    public Student searchStudent(String rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber().equals(rollNumber)) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void saveStudentsToFile(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadStudentsFromFile(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (ArrayList<Student>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a StudentManagementSystem instance
        StudentManagementSystem sms = new StudentManagementSystem();

        // Adding some students
        sms.addStudent(new Student("John Doe", "S001", "A", "age=18, gender=Male"));
        sms.addStudent(new Student("Jane Smith", "S002", "B", "age=17, gender=Female"));

        // Display all students
        System.out.println("All Students:");
        sms.displayAllStudents();

        // Saving students to a file
        sms.saveStudentsToFile("students.ser");

        // Creating a new StudentManagementSystem instance
        StudentManagementSystem smsNew = new StudentManagementSystem();
        // Loading students from file
        smsNew.loadStudentsFromFile("students.ser");
        System.out.println("Students loaded from file:");
        smsNew.displayAllStudents();
    }
}
