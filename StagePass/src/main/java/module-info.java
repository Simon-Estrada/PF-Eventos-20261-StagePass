module co.edu.uniquindio.stagepass {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.stagepass to javafx.fxml;
    exports co.edu.uniquindio.stagepass;
}