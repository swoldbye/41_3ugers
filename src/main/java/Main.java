import Boundary.GUI_Monopoly;
import Controllers.C_Initializer;

public class Main {

    public static void main(String[] args) {
	// Starts the controller initialization, which communicates with the GUI boundary and later entities
    // C_ in front of a class means Controller
        C_Initializer init = new C_Initializer();
        init.initialize();
    }
}
