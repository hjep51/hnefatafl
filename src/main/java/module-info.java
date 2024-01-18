module org.hnefatafl.hnefatafl {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.hnefatafl.hnefatafl to javafx.fxml;
    exports org.hnefatafl.hnefatafl;
}