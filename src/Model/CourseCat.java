package Model;

import java.util.ArrayList;

public class CourseCat {

    ArrayList <Course> courseList;

    public CourseCat (ArrayList <Course> courseList){
        this.courseList = courseList;
    }
    public ArrayList <Course> getCourseList (){
        return courseList;
    }

    public Course searchCat (String courseName, int courseId) {

        for (Course c: courseList) {
            if (c.getCourseName().equals(courseName) &&
                    c.getCourseId() == courseId) {
                return c;
            }
        }
        return null;
    }

    public int size(){
        return courseList.size();
    }

    @Override
    public String toString() {
        return "CourseCat{" +
                "courseList=" + courseList +
                '}';
    }
}
