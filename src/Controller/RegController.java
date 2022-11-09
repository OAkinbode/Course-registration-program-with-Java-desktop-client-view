package Controller;

import Model.Runner;
import Model.Student;
import View.RegView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegController{

    Runner run;
    Student std;
    RegView rView;

    public RegController(Runner run, RegView rView){
        this.run = run;
        this.rView = rView;
        rView.addRegListener(new RegListener());
        rView.addCatListener(new CataloguePrinter());
        rView.addCourseListener(new regCourse());
        rView.addSpecCourseListener(new regCourse2());
        rView.addShowAllCoursesListener(new CoursePrinter());
        rView.deleteCoursesListener(new deleteCourse());
        rView.deleteCoursesListener2(new deleteCourse2());
        rView.searchCatListener(new searchCat());
        rView.searchCatListener2(new searchCat2());
        rView.Exit(new Exit());

    }

    class RegListener extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //The controller gets the user data from the view
            String stN = "";
            int stId = 0;
            try {
                stN = rView.getStudentName();
                stId = rView.getStudentId();
                //The controller gets user data from the view
                run.run(stN, stId);
                
                // rView.setOutput("Welcome: " + stN);
                rView.displayReg("Welcome: " + stN);
            } catch (NumberFormatException ex) {
                rView.displayErrorMessage("Please input correct values!");
            }
        }
    }

    class CataloguePrinter extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            try {
                String Cat = run.printCat();
                rView.setOutput(Cat);
            } catch (NumberFormatException ex) {
                rView.displayErrorMessage("Please input correct values!");
            }
        }
    }

    class regCourse extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            try {
                rView.addingCourse();
            } catch (NumberFormatException ex) {
                rView.displayErrorMessage("Please input correct values!");
            }
        }
    }

    class regCourse2 extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String returnText = "";
            String name = "";
           String offering = "";
           int Id = 0;
            try {
                name = rView.getCourseName();
                offering =rView.getOffering();
                Id = rView.getCourseId();
                returnText = run.regCourse(name, Id, offering);
                rView.displayReg(returnText);
            } catch (NumberFormatException ex) {
                rView.displayErrorMessage("Please input correct values!");
            }
        }
    }

    class CoursePrinter extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            try {
                String courses = run.printCourses();
                rView.displayReg(courses);
            } catch (NumberFormatException ex) {
                rView.displayErrorMessage("Please input correct values!");
            }
        }
    }

    class deleteCourse extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
            try {
                rView.deleteCourse();
            } catch (NumberFormatException ex) {
                rView.displayErrorMessage("Please input correct values!");
            }
        }
    }

    class deleteCourse2 extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           String name = "";
           String text = "";
           int id = 0;
            try {
                name = rView.getCourseName();
                id = rView.getCourseId();
                text = run.deleteCourses(name, id);
                rView.displayReg(text);
            } catch (NumberFormatException ex) {
                rView.displayErrorMessage("Please input correct values!");
            }
        }
    }

    class searchCat extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                rView.searchCat();
            } catch (NumberFormatException ex) {
                rView.displayErrorMessage("Please input correct values!");
            }
        }
    }


    class searchCat2 extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = "";
            String text = "";
            int id = 0;
            try {
                name = rView.getCourseName();
                id = rView.getCourseId();
                text = run.searchCat(name, id);
                rView.displayReg(text);
            } catch (NumberFormatException ex) {
                rView.displayErrorMessage("Please input correct values!");
            }
        }
    }

    class Exit extends Component implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            run.exit();
        }
    }

}