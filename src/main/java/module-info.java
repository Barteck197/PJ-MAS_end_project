module com.s20198_final_project {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens gb to javafx.fxml;
    exports gb;

    opens model to javafx.fxml;
    exports model;

    opens utils to javafx.fxml;
    exports utils;
}