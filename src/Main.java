// import Controller.RegController;
import Model.Runner;
import View.RegView;
import Controller.RegController;

public class Main {
    public static void main(String[] args) {

        RegView theView = new RegView();
        Runner theModel = new Runner();
        RegController theController = new RegController(theModel, theView);

    }
}
