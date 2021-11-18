module bsu.comp152.project4_2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens bsu.comp152.project4_2 to javafx.fxml;
    exports bsu.comp152.project4_2;
}