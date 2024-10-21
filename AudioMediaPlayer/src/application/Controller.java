package application;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Controller implements Initializable {

	@FXML
	private Pane pane;
	@FXML
	private Label mediaLabel;
	@FXML
	private Button playButton, pauseButton, resetButton, previousButton, nextButton;
	@FXML
	private ComboBox<String> speedBox;
	@FXML
	private Slider volumeSlider;
	@FXML
	private ProgressBar mediaProgressBar;

	private Media media;
	private MediaPlayer mediaPlayer;

	private File directory;
	private File[] files;

	private ArrayList<File> media_list;

	private int position;
	private int[] speeds = { 25, 50, 75, 100, 125, 150, 175, 200 };

	private Timer timer;
	private TimerTask task;
	private boolean runnning;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		media_list = new ArrayList<File>();
		directory = new File("media");
		files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				media_list.add(file);
				System.out.println(file);
			}
		}
		media = new Media(media_list.get(position).toURI().toString());
		mediaPlayer = new MediaPlayer(media);

		mediaLabel.setText(media_list.get(position).getName());
	}

	public void playMedia() {
		mediaPlayer.play();
	}

	public void pauseMedia() {
		mediaPlayer.pause();
	}

	public void resetMedia() {
		mediaPlayer.seek(Duration.seconds(0));
	}

	public void previousMedia() {

	}

	public void nextMedia() {
		if (position < media_list.size() - 1) {
			position++;
			mediaPlayer.stop();
			media = new Media(media_list.get(position).getName());
			playMedia();
		}

		else {
			position = 0;
			mediaPlayer.stop();
			media = new Media(media_list.get(position).getName());
			playMedia();
		}
	}

	public void changeSpeed(ActionEvent event) {

	}

	public void beginTimer() {

	}

	public void cancelTimer() {

	}

}
