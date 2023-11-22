module com.example.mycarprice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens com.example.mycarprice to javafx.fxml;
    exports com.example.mycarprice;
}