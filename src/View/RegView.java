package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegView extends JFrame {

    private JTextField studentName = new JTextField(15);
    private JLabel nameLabel = new JLabel("Student Name: ");
    private JLabel idLabel = new JLabel("Student Id: ");
    private JLabel courseNLabel = new JLabel("Course Name: ");
    private JLabel courseIdLabel = new JLabel("Course Id: ");
    private JLabel offeringLabel = new JLabel("Course Id: ");

    private JTextField studentId = new JTextField(15);
    private JTextField courseName = new JTextField("Enter Course Name", 15);
    private JTextField courseId = new JTextField("Enter Course Id", 15);
    private JTextField offering = new JTextField("Enter Offering", 15);
    private JButton runButton = new JButton("Click here to Register/Login Student");
    private JButton printCat = new JButton("Show catalogue");
    private JButton printCourses = new JButton("Show all courses");
    private JButton addCourse = new JButton("Add a course");
    private JButton addCourse2 = new JButton("Add a course");
    private JButton deleteCourse = new JButton("Delete course");
    private JButton deleteCourse2 = new JButton("Delete course");
    private JButton searchCat = new JButton("Search Catalogue");
    private JButton searchCat2 = new JButton("Search Catalogue");
    private JButton exit = new JButton("Exit");

    private JTextArea output = new JTextArea(15, 15);
    // private JTextField output = new JTextField(15);

    private FlowLayout Flow = new FlowLayout();

    JPanel namePanel = new JPanel();
    JPanel idPanel = new JPanel();
    JPanel resultPanel = new JPanel();
    JPanel total = new JPanel();
    private BoxLayout Box = new BoxLayout(namePanel, BoxLayout.X_AXIS);
    private BoxLayout id = new BoxLayout(namePanel, BoxLayout.X_AXIS);

    public RegView (){
    
        setTitle("Student Login");
        namePanel.setLayout(new BorderLayout());
        idPanel.setLayout(new BorderLayout());
        resultPanel.setLayout(new BorderLayout());
        
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(studentName, BorderLayout.EAST);
        idPanel.add(idLabel, BorderLayout.WEST);
        idPanel.add(studentId, BorderLayout.EAST);
        resultPanel.add(runButton, BorderLayout.NORTH);
        // resultPanel.add(output, BorderLayout.SOUTH);
        total.add(namePanel, BorderLayout.NORTH);
        total.add(idPanel, BorderLayout.CENTER);
        total.add(resultPanel, BorderLayout.SOUTH);

        namePanel.setBounds(10,10,200,50);
        idPanel.setBounds(10,210,200,50);
        resultPanel.setBounds(20,220,400,50);

        this.add(total);
        setVisible(true);
    }

    public void displayReg(String stName){
        this.output.setText(stName);
        namePanel.removeAll();
        namePanel.revalidate();
        idPanel.removeAll();
        idPanel.revalidate();
        runButton.setVisible(false);
        
        namePanel.setLayout(new BorderLayout());
        namePanel.add(printCat, BorderLayout.NORTH);
        namePanel.add(addCourse, BorderLayout.CENTER);
        namePanel.add(printCourses, BorderLayout.SOUTH);
        namePanel.setBounds(10,10,200,50);

        idPanel.setLayout(new BorderLayout());
        idPanel.add(deleteCourse, BorderLayout.NORTH);
        idPanel.add(searchCat, BorderLayout.CENTER);
        idPanel.add(exit, BorderLayout.SOUTH);
        idPanel.setBounds(10,10,200,50);
        
        this.setTitle("Student registered");
        resultPanel.add(output, BorderLayout.EAST);
        this.setVisible(true);
    }

    public void addingCourse(){
        this.setTitle("Registering for courses");
        namePanel.removeAll();
        namePanel.revalidate();
        idPanel.removeAll();
        idPanel.revalidate();
        namePanel.setLayout(new BorderLayout());
        namePanel.add(courseName, BorderLayout.NORTH);
        namePanel.add(courseId, BorderLayout.CENTER);
        namePanel.add(offering, BorderLayout.SOUTH);

        idPanel.setLayout(new BorderLayout());
        idPanel.add(addCourse2, BorderLayout.CENTER);

        namePanel.setBounds(10,10,200,50);
        idPanel.setBounds(10,10,200,50);

        this.setVisible(true);
    }

    public void deleteCourse(){
        this.setTitle("Registering for courses");
        namePanel.removeAll();
        namePanel.revalidate();
        idPanel.removeAll();
        idPanel.revalidate();
        namePanel.setLayout(new BorderLayout());
        namePanel.add(courseName, BorderLayout.NORTH);
        namePanel.add(courseId, BorderLayout.SOUTH);

        idPanel.setLayout(new BorderLayout());
        idPanel.add(deleteCourse2, BorderLayout.CENTER);

        namePanel.setBounds(10,10,200,50);
        idPanel.setBounds(10,10,200,50);

        this.setVisible(true);
    }

    public void searchCat(){
        this.setTitle("Registering for courses");
        namePanel.removeAll();
        namePanel.revalidate();
        idPanel.removeAll();
        idPanel.revalidate();
        namePanel.setLayout(new BorderLayout());
        namePanel.add(courseName, BorderLayout.NORTH);
        namePanel.add(courseId, BorderLayout.SOUTH);

        idPanel.setLayout(new BorderLayout());
        idPanel.add(searchCat2, BorderLayout.CENTER);

        namePanel.setBounds(10,10,200,50);
        idPanel.setBounds(10,10,200,50);

        this.setVisible(true);
    }

    public void showAllCourses(){
        this.setTitle("Registering for courses");
        namePanel.removeAll();
        namePanel.revalidate();
        this.setVisible(true);
    }

    public String getStudentName() {
        return studentName.getText();
    }
    public int getStudentId() {
        return Integer.parseInt(studentId.getText());
    }

    public String getCourseName(){
        return courseName.getText();
    }

    public String getOffering(){
        return offering.getText();
    }

    public int getCourseId(){
        return Integer.parseInt(courseId.getText());
    }
    
    public void setOutput(String text){
        output.setText(text);
    }

    public void addRegListener (ActionListener listenForRunButton){
        runButton.addActionListener(listenForRunButton);
    }

    public void addCatListener (ActionListener listenForCat){
        printCat.addActionListener(listenForCat);
    }

    public void addCourseListener (ActionListener listenForAddCourse){
        addCourse.addActionListener(listenForAddCourse);
    }

    public void addSpecCourseListener (ActionListener listenForAddSpecCourse){
        addCourse2.addActionListener(listenForAddSpecCourse);
    }

    public void addShowAllCoursesListener (ActionListener listenForShowAllCourse){
        printCourses.addActionListener(listenForShowAllCourse);
    }

    public void deleteCoursesListener (ActionListener listenForDelCourse){
        deleteCourse.addActionListener(listenForDelCourse);
    }

    public void deleteCoursesListener2 (ActionListener listenForSpecDelCourse){
        deleteCourse2.addActionListener(listenForSpecDelCourse);
    }

    public void searchCatListener (ActionListener listenForSearchCat){
        searchCat.addActionListener(listenForSearchCat);
    }

    public void searchCatListener2 (ActionListener listenForSearchCat2){
        searchCat2.addActionListener(listenForSearchCat2);
    }

    public void Exit (ActionListener Exit){
        exit.addActionListener(Exit);
    }

    public void displayErrorMessage (String errorMessage){
        JOptionPane.showMessageDialog(this,errorMessage);
    }
    
}
