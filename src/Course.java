
import java.util.ArrayList;

public class Course {
    private   String courseCode;
    public  String courseTitle;
    public  int credits;
    public String department;
    public  String description;
    public String []sessionDates=new String[2];
    public ArrayList <Instructor> assignedInstructor = new ArrayList<>();
    public MidtermExam assignedMidterm = new MidtermExam();
    public FinalExam assignedfinal = new FinalExam();
    public ArrayList<Assignment> assignedAssignment = new ArrayList<>();
    public ArrayList<Quiz>assignedQuiz =  new ArrayList<>();
    public ArrayList<Student>enrolledStudents=new ArrayList<Student>();
    private double mean;
    private double StandardDeviation; //if used
    public Course () {}
    public Course(String courseCode,String courseTitle,int credits,String department,String description
            ,String []sessionDates)
    {
        this.courseCode=courseCode;
        this.courseTitle=courseTitle;
        this.credits=credits;
        this.department=department;
        this.description=description;
        this.sessionDates=sessionDates;
    }
    public Course (String courseCode,String courseTitle,int credits,String department,String description,
                   String []sessionDates,Instructor assignedInstructor,MidtermExam assignedMidterm,FinalExam assignedfinal)
    {
        this(courseCode,courseTitle,credits,department,description,sessionDates);
        if(assignedInstructor!=null) {
            this.assignedInstructor.add(assignedInstructor);
        }
        this.assignedfinal=assignedfinal;
        this.assignedMidterm=assignedMidterm;
    }
 /*  public Course (String courseCode,String courseTitle,int credits,String department,String description,String []sessionDates,Instructor assignedInstructor,
    Assignment  assignedAssignment,Quiz assignedQuiz,MidtermExam assignedMidterm,FinalExam assignedfinal)
    {
        this(courseCode,courseTitle,credits,department,description,sessionDates,assignedInstructor,assignedMidterm,assignedfinal);
        this.assignedAssignment.add(assignedAssignment);
        this.assignedQuiz.add(assignedQuiz);
    }

    public Course (String courseCode,String courseTitle,int credits,String department,String description,String []sessionDates,Instructor assignedInstructor,
                  ArrayList <Assignment> assignedAssignment,ArrayList<Quiz> assignedQuiz,MidtermExam assignedMidterm,FinalExam assignedfinal)
    {
        this(courseCode,courseTitle,credits,department,description,sessionDates);
        this.assignedInstructor.add(assignedInstructor);
        this.assignedAssignment=assignedAssignment;
        this.assignedQuiz=assignedQuiz;
        this.assignedfinal=assignedfinal;
        this.assignedMidterm=assignedMidterm;
    }
    public Course(String courseCode,String courseTitle)
    {
        this.courseCode=courseCode;
        this.courseTitle=courseTitle;
    }*/
    public void setCourseCode(String courseCode)
    {
        this.courseCode=courseCode;
    }
    public String getCourseCode()
    {
        return  courseCode;
    }
    public void enrollStudent(Student student)   //>>student sends me  that
    {
         enrolledStudents.add(student);
    }
    public void viewListOfEnrolledStudents()
    {
        for(int enrolledStudentsIndex=0;enrolledStudentsIndex<enrolledStudents.size();enrolledStudentsIndex++)
        {
            System.out.println(enrolledStudents.get(enrolledStudentsIndex).getFname()+
                    " "+enrolledStudents.get(enrolledStudentsIndex).getLname()+"     "+
                    enrolledStudents.get(enrolledStudentsIndex).getID());
        }
    }

    public void addAssignedAssignment(Assignment assignedAssignment)
    {
        this.assignedAssignment.add(assignedAssignment);
        Main.assignments.add(assignedAssignment);                //>>Is any one add that ????
    }
    public void addAssignedQuiz(Quiz assignedQuiz)
    {
       this.assignedQuiz.add(assignedQuiz);
       Main.quizzes.add(assignedQuiz);                           //>>Is any one add that ????
    }
    public void addAssignedMidterm(MidtermExam assignedMidterm)
    {
        this.assignedMidterm=assignedMidterm;
        Main.midtermExams.add(assignedMidterm);                 //>>Is any one add that ????
    }
    public void addAssignedFinal(FinalExam assignedfinal)
    {
       this.assignedfinal=assignedfinal;
       Main.finalExams.add(assignedfinal);                    //>>Is any one add that ????
    }

    public double CalcMean(){
        double sum=0;
        for (Student student:enrolledStudents) {
            for (int i=0;i<student.getNoOfCourses();i++) {
                if(student.Student_courses.get(i).courseCode.equals(this.courseCode)){
                    sum+=student.Student_Grades.get(i).CalcTotalGrade();
                }
            }
        }
        mean=sum/enrolledStudents.size();
        return mean;
    }

    public double CalcStandardDeviation(){
        double sum=0;
        for (Student student:enrolledStudents) {
            for (int i=0;i<student.getNoOfCourses();i++) {
                if(student.Student_courses.get(i).courseCode.equals(this.courseCode)){
                    sum+=Math.pow(student.Student_Grades.get(i).CalcTotalGrade()-mean,2);
                }
            }
        }
        sum/=enrolledStudents.size()-1;
        StandardDeviation=Math.sqrt(sum);
        return StandardDeviation;
    }
public String toString()
{
    String courseData=courseCode + "," + courseTitle + "," + credits + "," + department + "," + description + "," + sessionDates[0] + "-" + sessionDates[1];
    if(!this.assignedInstructor.isEmpty())
    {
        courseData+=","+assignedInstructor.get(0).getID();
    }
    if(this.assignedfinal.getID()!=0)
    {
        courseData+=","+this.assignedfinal.getID();
    }
    if(this.assignedMidterm.getID()!=0)
    {
        courseData+=","+this.assignedMidterm.getID();
    }
    return courseData;

}
}

