import java.util.ArrayList;
import java.util.Scanner;
class Student 
{
    String studentId;
    String name;
    int age;
    int marks1;
    int marks2;
    int marks3;
    int total;
    double percentage;
    String grade;
    Student(String studentId, String name, int age,int marks1, int marks2, int marks3,int total, double percentage,String grade) 
    {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
        this.total = total;
        this.percentage = percentage;
        this.grade = grade;
    }
}
public class StudentManagementSystem 
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) 
    {
        int choice = 0;
        do {
            try {
                System.out.println("\n====================================");
                System.out.println("     STUDENT MANAGEMENT SYSTEM");
                System.out.println("====================================");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student Profile");
                System.out.println("4. Update Student");
                System.out.println("5. Exit");
                System.out.print("Enter Your Choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addStudent();
                        break;

                    case 2:
                        viewStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        System.out.println("Thank You!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Invalid Input! Please Enter Correct Data.");
                sc.nextLine();
            }
        } while (choice != 5);
    }
    // Add Student
    static void addStudent() 
    {
        try {
            sc.nextLine();
            System.out.print("Enter Student ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Student Age: ");
            int age = sc.nextInt();
            // Subject Marks
            System.out.print("Enter Marks For Subject 1: ");
            int marks1 = sc.nextInt();
            System.out.print("Enter Marks For Subject 2: ");
            int marks2 = sc.nextInt();
            System.out.print("Enter Marks For Subject 3: ");
            int marks3 = sc.nextInt();
            // Total Calculation
            int total = marks1 + marks2 + marks3;
            // Percentage Calculation
            double percentage = total / 3.0;
            // Grade Calculation
            String grade;
            if (percentage >= 90) 
            {
                grade = "A";
            } 
            else if (percentage >= 75) 
            {
                grade = "B";
            } 
            else if (percentage >= 50) 
            {
                grade = "C";
            } 
            else 
            {
                grade = "Fail";
            }
            Student student = new Student(id,name,age,marks1,marks2,marks3,total,percentage,grade);
            students.add(student);
            System.out.println("\nStudent Added Successfully!");
        } 
        catch (Exception e) 
        {
            System.out.println("Invalid Input!");
            sc.nextLine();
        }
    }
    // View All Students
    static void viewStudents() 
    {
        if (students.isEmpty()) 
        {
            System.out.println("No Student Records Found!");
            return;
        }
        System.out.println("\n========== STUDENT DETAILS ==========");
        for (Student s : students) 
        {
            System.out.println("Student ID   : " + s.studentId);
            System.out.println("Name         : " + s.name);
            System.out.println("Age          : " + s.age);
            System.out.println("Subject 1    : " + s.marks1);
            System.out.println("Subject 2    : " + s.marks2);
            System.out.println("Subject 3    : " + s.marks3);
            System.out.println("Total Marks  : " + s.total);
            System.out.println("Percentage   : " + s.percentage);
            System.out.println("Grade        : " + s.grade);
            System.out.println("-----------------------------------");
            }
        System.out.println("Total Students : " + students.size());
    }
    // Search Student Profile
    static void searchStudent() 
    {
        try {
            sc.nextLine();
            System.out.print("Enter Student ID To View Profile: ");
            String id = sc.nextLine();
            boolean found = false;
            for (Student s : students) 
            {
                if (s.studentId.equals(id)) 
                {
                    found = true;
                    System.out.println("\n===== STUDENT PROFILE =====");
                    System.out.println("Student ID   : " + s.studentId);
                    System.out.println("Name         : " + s.name);
                    System.out.println("Age          : " + s.age);
                    System.out.println("Subject 1    : " + s.marks1);
                    System.out.println("Subject 2    : " + s.marks2);
                    System.out.println("Subject 3    : " + s.marks3);
                    System.out.println("Total Marks  : " + s.total);
                    System.out.println("Percentage   : " + s.percentage);
                    System.out.println("Grade        : " + s.grade);
                    break;
                }
            }
            if (!found) 
            {
                System.out.println("Student ID Not Found!");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Invalid Input!");
            sc.nextLine();
        }
    }
    // Update Student
    static void updateStudent() 
    {
        try {
            sc.nextLine();
            System.out.print("Enter Student ID To Update: ");
            String id = sc.nextLine();
            boolean found = false;
            for (Student s : students) 
            {
                if (s.studentId.equals(id)) 
                {
                    found = true;
                    System.out.print("Enter New Student Name: ");
                    s.name = sc.nextLine();
                    System.out.print("Enter New Age: ");
                    s.age = sc.nextInt();
                    System.out.print("Enter New Marks For Subject 1: ");
                    s.marks1 = sc.nextInt();
                    System.out.print("Enter New Marks For Subject 2: ");
                    s.marks2 = sc.nextInt();
                    System.out.print("Enter New Marks For Subject 3: ");
                    s.marks3 = sc.nextInt();
                    // Recalculate Total
                    s.total = s.marks1 + s.marks2 + s.marks3;
                    // Recalculate Percentage
                    s.percentage = s.total / 3.0;
                    // Recalculate Grade
                    if (s.percentage >= 90) 
                    {
                        s.grade = "A";
                    } 
                    else if (s.percentage >= 75) 
                    {
                        s.grade = "B";
                    } 
                    else if (s.percentage >= 50) 
                    {
                        s.grade = "C";
                    } 
                    else 
                    {
                        s.grade = "Fail";
                    }
                    System.out.println("\nStudent Record Updated Successfully!");
                    break;
                }
            }
            if (!found) 
            {
                System.out.println("Student ID Not Found!");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Invalid Input!");
            sc.nextLine();
        }
    }
}
