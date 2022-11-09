package Model;

import java.util.ArrayList;

public class Runner {
    static App modelRunner; 
  CourseCat catSummer;
  CourseCat catFall;
  CourseCat catWinter;
  ArrayList<CourseCat> cat;
  Student st;
  int action;
  int numRegs = 0;

  public Runner(){
    modelRunner = new App();
    catSummer = new CourseCat(DataLoader.loadSummerCoursesFromDataBase());
    catFall = new CourseCat(DataLoader.loadFallCoursesFromDataBase());
    catWinter = new CourseCat(DataLoader.loadWinterCoursesFromDataBase());
    cat = new ArrayList<CourseCat>();
    cat.add(0, catSummer); 
    cat.add(1, catFall); 
    cat.add(2, catWinter); 
  }
  public void run(String StudentName, int StudentId){
    // Create object of Student
    st = new Student(StudentName, StudentId);
    // Present Menu. 
  }

  public void exit(){
    System.exit(0);
  }


  public int countCourses(){
    return modelRunner.countReg(st);
  }

  public String printCat(){
    String Catalogue = "The Catalogue: \n" + "Summer Courses are: \n";
      for (int i = 0; i < catSummer.size(); i++){
        Catalogue += modelRunner.printCat(catSummer).get(i) + "\n";
      }
      Catalogue += "\nFall Courses are: \n";
      for (int i = 0; i < catFall.size(); i++){
        Catalogue += modelRunner.printCat(catFall).get(i) + "\n";
      }
      Catalogue += "\nWinter Courses are: \n";
      for (int i = 0; i < catWinter.size(); i++){
        Catalogue += modelRunner.printCat(catWinter).get(i) + "\n";
      }
      return Catalogue;
  }

  public String searchCat(String courseName, int courseId){
    String text = "";
      boolean flag = false;
      for (int i = 0; i < 3; i++){
        Course course = modelRunner.searchCat(cat.get(i), courseName, courseId);
        if (course != null){
          text = "\n" + courseName + courseId + " Found!\n";
          flag = true;
          break;
        }
      }
      if (flag == false)
          text = "\n Oops! Course was not found!\n\n";
    return text;
  }

  public String regCourse(String courseName, int courseId, String offering){
    
    String text = "";
      String course = courseName + courseId;
      boolean existingCourse = false;
      offering = offering.toLowerCase();

    //Checking for duplicate courses
    for (int i = 0; i < countCourses(); i++){
      if (course.equals(modelRunner.printCourseList(st).get(i))){
        existingCourse = true;
      }
      }
    if (!modelRunner.maxCourses && existingCourse == false){
        if (offering.equals("summer")){
          st = modelRunner.regStudent(catSummer, st, 1, courseName, courseId);
        }
        else if (offering.equals("fall")){
          st = modelRunner.regStudent(catFall, st, 2, courseName, courseId);
        }
        else if (offering.equals("winter")){
          st = modelRunner.regStudent(catWinter, st, 3, courseName, courseId);
        }
        else
          text = "\nPlease enter a valid offering\n";
      numRegs++;
        text = "Course successfully added";
      }
      else if(existingCourse == true){
        text = "You already registered for this course!";
      }
      else if(modelRunner.maxCourses){
        text = "\nMaximun number of courses reached. You can only register 6 courses";
      }
      if (modelRunner.wrongCat)
        text = "The course you selected does not exist in this catalogue!";

    return text;
  }

  public String printCourses(){
    String text = "\nPrinting your current courses\n\n";
      int count = 1;
      for (int i = 0; i < countCourses(); i++ ){
        text += count + ". " + modelRunner.printCourseList(st).get(i) + 
        " This course has: " + st.countRegs(i) + " total students registered" + "\n";
        count++;
      }
      return text;
  }

  public String deleteCourses(String courseName, int courseId){
    String text = "";
      st.deRegCourse(courseName, courseId);
      if (st.del == true){
        text += "\nsuccessfully deleted";
      }
      else 
        text += "\nCourse not found/deleted";
    return text;
  }
}
