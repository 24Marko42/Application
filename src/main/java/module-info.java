module org.example.mainfolder {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.mainfolder to javafx.fxml;
    exports org.example.mainfolder;
}