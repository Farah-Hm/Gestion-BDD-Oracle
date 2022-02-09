module Project {
	exports helpers;
	exports school;
	exports model;
	exports login;
	exports user3;
    opens school to javafx.fxml;
    opens login to javafx.fxml;
    opens user3 to javafx.fxml;
	requires java.logging;
	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
}