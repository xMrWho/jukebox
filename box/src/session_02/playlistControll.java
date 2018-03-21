package session_02;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.text.TableView.TableRow;

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
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;

public class playlistControll implements Initializable{
	private ArrayList<Song> songs;
	private ArrayList<Playlist> list;
    @FXML private TableView<Song> Libary; @FXML private TableView<Playlist> Playlists;

    @FXML
    private Button btnEditPlaylist;

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
    Song[] s = {};
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.songs = new ArrayList<Song>();
		this.list  = new ArrayList<Playlist>();
		File f = new File("C:\\Users\\VBBW\\Music\\bip.mp3");
		Song bib = new Song(f);
		songs.add(bib);
		
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
		
		Libary.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent e) {
			if(e.getClickCount() == 2){
				Song song =  Libary.getSelectionModel().selectedItemProperty().get();
				if(song.getPlayer() != null && song.isPlaying()){
					song.pause();
				}
				else{
					song.play();
				}
			}
				
			}
			
		});
		btnFindSongs.setOnAction(new EventHandler<ActionEvent>(){
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
					data.add(s);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		         
			}
			
		});

		Playlist rock = new Playlist();
		rock.setName("Kellerbar Rock");
		list.add(rock);
		ObservableList<Playlist> data_playlist = FXCollections.observableArrayList(list);
		TableColumn nameCol = new TableColumn("Playlists");
		nameCol.setCellValueFactory( new PropertyValueFactory<Playlist, String>("name"));
		nameCol.setMinWidth(200);
		Playlists.getColumns().addAll(nameCol);
		Playlists.setItems(data_playlist);
	}
}
