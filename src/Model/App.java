package Model;

import java.util.ArrayList;

public class App {

public boolean del;
public boolean maxCourses = false;
public boolean wrongCat;

public Student regStudent(CourseCat cat, Student st, int secNum, String courseName, int courseId){
    /*
    Search through a catelogue and return the course.  
    */

    if (!maxCourses){
      wrongCat = false;
      Course course = cat.searchCat(courseName, courseId);
      if (course == null){
        wrongCat = true;
        return st;
      }
      else {
        course.setOfferingList(DataLoader.offeringList());
        st.registerForCourse(cat, course, secNum);
        // check for max courses
        if (countReg(st) >= 6){
            maxCourses = true;
        }
        return st;
      }
    }
    else if(maxCourses){
      return st;
    }
      return st;
  }
  
  public Student deRegCourse(Student st, String courseName, int courseId){
    /*
     This goes to the course registration arraylist in student and deletes the registration that corresponds to the course. 
     */
    // Search and delete the particular course registration from the student object
    st.deRegCourse(courseName, courseId);
    if (st.del == false)
      del = false;
    else
      del = true;
    return st;
  }
  
  public ArrayList<String> printCourseList(Student st){
    /*
     * Prints an arraylist of courses registered by the student.
     */
    return st.printCourseList();
  }
  
  public ArrayList<String> printCat(CourseCat cat){
    /*
     * To print out the catalogue.
     */
    ArrayList<String> courses = new ArrayList<String>();
    Course course;
    String crs = "";
    for (int i = 0; i < cat.getCourseList().size(); i++){
      course = cat.getCourseList().get(i);
      crs = course.getCourseName() + course.getCourseId();
      courses.add(crs);
    }
    return courses;
  }
  
  public int countReg(Student st){
    // Counts the number of course Registrations that a student has. 
    int i = st.getCourseList().size();
    return i;
  }
  
  public Course searchCat(CourseCat cat, String courseName, int courseId){
    /*
     * To search the catalogue.
     */
    Course course = cat.searchCat(courseName, courseId);
    return course;
  }

}
