module MP3Player {
	requires javafx.controls;
	requires javafx.base;
	requires javafx.fxml;
	requires javafx.media;
	
	opens application to javafx.graphics, javafx.fxml;
}
