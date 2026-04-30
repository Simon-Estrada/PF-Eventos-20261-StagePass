module co.edu.uniquindio.stagepass {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.stagepass to javafx.fxml;
    exports co.edu.uniquindio.stagepass;
}