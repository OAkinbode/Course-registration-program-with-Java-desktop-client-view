package Model;

import java.util.ArrayList;

public class Student {

    private String name;
    private int id;
    public boolean del;
    private ArrayList<Registration> courseList;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        courseList = new ArrayList<Registration>();
    }

    public void addCourse (Registration r){
        courseList.add(r);
    }

    public ArrayList<Registration> getCourseList(){
        return this.courseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void registerForCourse (CourseCat cat, Course myCourse, int secNumber) {
        //Can we do some course - secNumber/semester matching here.
        Offering theOffering = myCourse.getOffering(secNumber);
        Registration reg = new Registration ();
        reg.register(this, theOffering);
    }

    public void deRegCourse(String courseName, int courseId){
        del = false;
        int index = 99;
        for (int i = 0; i < courseList.size(); i++)
            if (getCourseId(i) == courseId && getCourseName(i).equals(courseName)){
                index = i;
            }
        if (courseList.size() > index){
            courseList.remove(index);
            del = true;
        }
    }

    public ArrayList<String> printCourseList(){
        ArrayList<String> stdCourses = new ArrayList<String>();
        String courses = "";
        for (int i = 0; i < courseList.size(); i++){
            String courseName = getCourseName(i);
            int courseId = getCourseId(i);
            courses = courseName + courseId;
            stdCourses.add(i, courses);
        }
        return stdCourses;
    }

    private String getCourseName(int i){
        String courseName = courseList.get(i).getCourseName();
        // System.out.println("search: " + courseName);
        return courseName;
    }

    private int getCourseId(int i){
        int courseId = courseList.get(i).getCourseId();
        // System.out.println("search: " + courseId);
        return courseId;
    }

    public int countRegs(int i){
        int count = courseList.get(i).countRegs(); 
        return count;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", courseList=" + courseList +
                '}';
    }
}
