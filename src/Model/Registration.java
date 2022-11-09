package Model;

public class Registration {

    private Offering theOffering;
    private Student theStudent;
    private char theGrade;

    public void register (Student theStudent, Offering theOffering){
        this.theStudent = theStudent;
        this.theOffering = theOffering;
        theOffering.addStudent(this);
        theStudent.addCourse(this);
        this.theGrade = ' ';
    }

    public Offering getTheOffering() {
        return theOffering;
    }

    public void setTheOffering(Offering theOffering) {
        this.theOffering = theOffering;
    }

    public void setTheGrade (char theGrade){
        this.theGrade = theGrade;
    }
    
    public char getTheGrade (){
        return theGrade;
    }

    public int getCourseId(){
        return theOffering.getCourseId();
    }

    public String getCourseName(){
        return theOffering.getCourseName();
    }
    public int countRegs(){
        int count = theOffering.countRegs();
        return count;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "theGrade=" + theGrade + ", in offering: " + theOffering.getSemester() +
                '}';
    }


}
