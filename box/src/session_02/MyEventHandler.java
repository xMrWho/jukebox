package session_02;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;

public class MyEventHandler {
	private playlistControll controller;
	MyEventHandler(playlistControll controller){
		this.controller = controller;
	}
	public EventHandler<MouseEvent> doubleClickOnLibaryItem = new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			if(e.getClickCount() == 2){
			Song song =  controller.Libary.getSelectionModel().selectedItemProperty().get();
				if(song.getPlayer() != null && song.isPlaying()){
					song.pause(); }
				else{
					song.play();
				}}}};
	
	public EventHandler<ActionEvent> findSongs = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent event) {
			DirectoryChooser chooser = new DirectoryChooser();
			chooser.setTitle("Music");
			File defaultDirectory = new File(System.getProperty("user.home"));
			chooser.setInitialDirectory(defaultDirectory);
			File selectedDirectory = chooser.showDialog(null);
			System.err.println(selectedDirectory.getAbsolutePath());
	        ArrayList<File> files = musicFinder.searchFile(selectedDirectory);
			for(int i = 0; i < files.size(); i++){
				Song s = new Song(files.get(i));
				controller.lib.add(s);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
}
