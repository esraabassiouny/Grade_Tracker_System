import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Person {

    static Scanner input = new Scanner(System.in);
   // public final ArrayList<StudentGrades> Student_Grades = new ArrayList<>();
    private int NoOfCourses=0;
    private double expenses = 0;
    private boolean expenses_paid = false;

    public boolean[] attendance = new boolean[10];

    public final ArrayList<Course> Student_courses = new ArrayList<>();

    public Student (){
        super();
    }

    public Student(String Fname, String Lname){
        super(Fname,Lname);

    }

    public Student(String Fname, String Lname,int id){
        super(Fname,Lname);
        this.setID(id);

    }


    public void ViewStudentPerformance() {


    }

    public void ViewGrades() {
        if (NoOfCourses == 0)
            System.out.println("You haven't registered any course");
        else if (expenses_paid) {
            for (Course course:Student_courses) {
                System.out.println("Course Title: " + course.courseTitle);
              //  grades[courseNo].DisplayReport();
            }
        } else
            System.out.println("Please pay expenses first");
    }

    public void Payment() {
        if (NoOfCourses == 0 || expenses_paid)
            System.out.println("No payments to pay");
        else {
            for (Course course:Student_courses) {
                expenses += course.credits * 100;
            }
            do {
                System.out.println("Please pay " + expenses);
                System.out.println("Pay Now?");
                System.out.println("1- Yes\n2- No");
                int ans = input.nextInt();
                if (ans == 1) {
                    System.out.println("Payment Completed.");
                    expenses_paid = true;
                    break;
                } else if (ans == 2) {
                    //return back
                    break;
                } else {
                    System.out.println("Invalid Choice!Try Again.");
                }
            } while (true);
        }
    }

    public void AddCourse(Course[] courses) {
        for(int i=0;i< Course.no_of_courses;i++){
            System.out.println((i+1)+":"+courses[i].courseTitle);
        }
        System.out.println("Which Course You Want To Register For? ");
        int answer =input.nextInt();
        Student_courses.add(courses[answer-1]);
    }

    public void ViewEvents() {

    }

}