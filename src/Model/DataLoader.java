package Model;

import java.util.ArrayList;

public class DataLoader {

    //Helper method
    public static ArrayList<Course> loadWinterCoursesFromDataBase (){
        //Simulating a database of Winter courses!
        Course c1 = new Course ("ENSF", 609);
        Course c2 = new Course ("ENSF", 610);
        Course c3 = new Course ("ENSF", 611);
        Course c4 = new Course ("ENSF", 612);
        Course c6 = new Course ("ENSF", 614);
        Course c7 = new Course ("ENSF", 615);

        ArrayList <Course> winterCourseList = new ArrayList<>();
        winterCourseList.add(c1);
        winterCourseList.add(c2);
        winterCourseList.add(c3);
        winterCourseList.add(c4);
        winterCourseList.add(c6);
        winterCourseList.add(c7);

        return winterCourseList;
    }

   public static ArrayList<Course> loadSummerCoursesFromDataBase (){
        //Simulating a database of Summer courses!
        Course c5 = new Course ("ENSF", 613);
        Course c6 = new Course ("ENSF", 614);
        Course c7 = new Course ("ENSF", 615);
        Course c8 = new Course ("ENSF", 616);

        ArrayList <Course> summerCourseList = new ArrayList<>();

        summerCourseList.add(c5);
        summerCourseList.add(c6);
        summerCourseList.add(c7);
        summerCourseList.add(c8);
        
        return summerCourseList;
    }

    public static ArrayList<Course> loadFallCoursesFromDataBase (){
        //Simulating a database of Fall courses!

        Course c9 = new Course ("ENSF", 617);
        Course c10 = new Course ("ENSF", 618);
        Course c11 = new Course ("ENSF", 619);
        Course c12 = new Course ("ENSF", 620);
        Course c6 = new Course ("ENSF", 614);
        Course c7 = new Course ("ENSF", 615);
        

        ArrayList <Course> fallCourseList = new ArrayList<>();
  
        fallCourseList.add(c9);
        fallCourseList.add(c10);
        fallCourseList.add(c11);
        fallCourseList.add(c12);
        fallCourseList.add(c6);
        fallCourseList.add(c7);
        
        return fallCourseList;
    }
    public static ArrayList <Offering> offeringList(){
        ArrayList<Offering> tempOfferingList = new ArrayList<Offering>();
        Offering summer = new Offering(1, "Summer" ,loadSummerCoursesFromDataBase());
        Offering fall = new Offering(2, "Fall", loadFallCoursesFromDataBase());
        Offering winter = new Offering(3, "Winter",loadWinterCoursesFromDataBase());

        tempOfferingList.add(summer);
        tempOfferingList.add(fall);
        tempOfferingList.add(winter);

        return tempOfferingList;
    }


}
