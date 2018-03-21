package session_02;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class playlistControll implements Initializable{
	public ArrayList<Song> songs;
	public ArrayList<Playlist> list;
	public ArrayList<Song> lib;
    @FXML public TableView<Song> Libary; @FXML public TableView<Playlist> Playlists;
    @FXML private Button btnEditPlaylist;

    @FXML
    private Button btnDeletePlaylist;

    @FXML
    private Button btnNewPlaylist;

    @FXML
    private Button btnLibary;

    @FXML
    private TextField current_playlist;

    @FXML
    private Button btnFindSongs;

    @FXML
    private Button btnOpenSong;

    @FXML
    private Button btnAddSongTo;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		MyEventHandler events = new MyEventHandler(this);
		this.songs = new ArrayList<Song>();
		this.lib   = new ArrayList<Song>();
		this.list  = new ArrayList<Playlist>();
		
		TableColumn titleCol = new TableColumn("Title");
	    titleCol.setCellValueFactory( new PropertyValueFactory<Song, String>("title"));
	    
	    TableColumn albumCol = new TableColumn("Album");
	    albumCol.setCellValueFactory( new PropertyValueFactory<Song, String>("album"));
	    albumCol.setMinWidth(200);
	    
	    TableColumn artistCol = new TableColumn("Artist");
	    artistCol.setCellValueFactory( new PropertyValueFactory<Song, String>("artist"));
	    artistCol.setMinWidth(200);
		ObservableList<Song> data = FXCollections.observableArrayList(songs);
		Libary.setItems(data);
		Libary.getColumns().addAll(titleCol, albumCol, artistCol);
		Libary.setOnMouseClicked(events.doubleClickOnLibaryItem);
		btnFindSongs.setOnAction(events.findSongs);
		ObservableList<Playlist> data_playlist = FXCollections.observableArrayList(list);
		TableColumn nameCol = new TableColumn("Playlists");
		nameCol.setCellValueFactory(new PropertyValueFactory<Playlist, String>("name"));
		nameCol.setMinWidth(200);
		Playlists.getColumns().addAll(nameCol);
		Playlists.setItems(data_playlist);
	}
}
