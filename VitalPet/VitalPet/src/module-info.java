module VitalPet {
    requires javafx.controls;
    requires javafx.fxml;
    exports mx.edu.uacm.is.slt.ds.vitalpet.application to javafx.graphics, javafx.fxml;
    opens mx.edu.uacm.is.slt.ds.vitalpet.application to javafx.fxml;
    opens mx.edu.uacm.is.slt.ds.vitalpet.controllers to javafx.fxml;
}