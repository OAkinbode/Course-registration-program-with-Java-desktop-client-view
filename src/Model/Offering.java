package Model;

import java.util.ArrayList;

public class Offering {

    private int section;
    private String semester;
    private int count;
    private ArrayList <Course> offeringCourses;
    private ArrayList <Registration> studentList;

    public Offering(int section, String semester, ArrayList<Course> offeringCourses) {

        this.section = section;
        this.semester = semester;
        studentList = new ArrayList<>();
        offeringCourses = new ArrayList<>();
        this.offeringCourses = offeringCourses;
    }

    public ArrayList<Course> getOfferingCourses() {
        return offeringCourses;
    }
     public void setOfferingCourses(ArrayList<Course> offeringCourses) {
        this.offeringCourses = offeringCourses;
    }

    public void addStudent (Registration r){
        studentList.add(r);
    }
   
    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public void setTheCourse(Course theCourse) {
        // this.theCourse = theCourse;
        offeringCourses.add(theCourse);
    }

    public String getSemester(){
        return semester;
    }

    public int getCourseId(){
        return offeringCourses.get(0).getCourseId();
    }

    public String getCourseName(){
        return offeringCourses.get(0).getCourseName();
    }

    public int countRegs(){
        count = 0;
        for (int i = 0; i < studentList.size(); i++){
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        return  "" + offeringCourses;
    }
}
