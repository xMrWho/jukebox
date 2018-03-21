package session_02;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class Song {
	private String title, album, artist;
	private int duration;
	private File songFile;
	private Mp3File file;
	private Image image;
	private Image songCover = new Image(getClass().getClassLoader().getResource("res/images/cd.png").toExternalForm());
	private MediaPlayer player;
	/** @return Title of Song */
	public String getTitle() { return title; }
	/** Set the Title of the Song @param title */
	public void setTitle(String title) { this.title = title; }
	/** @return Album of Song */
	public String getAlbum() { return album; }
	/** Set Album of Song @param album */
	public void setAlbum(String album) { this.album = album; }
	/** @return Artist of Song */
	public String getArtist() { return artist; }
	/** Set Artist of Song @param artist */
	public void setArtist(String artist) { this.artist = artist; }
	/** @return Duration of Song in Seconds */
	public int getDuration() { return duration; }
	/** Set Duration of Song @param duration */
	public void setDuration(int duration) { this.duration = duration; }
	/** @return File (Java) of Song --> is playable in Mediaplayer */
	public File getSongFile() { return songFile; }
	/** Set File of Song @param songFile */
	public void setSongFile(File songFile) { this.songFile = songFile; }
    /** @return Image of Song */
	public Image getImage() { return image; }
    /** Set Image of Song @param image */
	public void setImage(Image image) { this.image = image; }
	
	public Song(){}
	/** Create Object of Song with a SongFile (.mp3/.wav) @param f */
	
	public Song(File f){
		this.songFile = f;
		try {
			file = new Mp3File(songFile);
			duration = (int) TimeUnit.MILLISECONDS.toSeconds(file.getLengthInMilliseconds());
			if(file.hasId3v2Tag()){
				ID3v2 tag = file.getId3v2Tag();
				title  = tag.getTitle();
				album = tag.getAlbum();
				artist = tag.getAlbumArtist();
				byte[] imageData = tag.getAlbumImage();
				try {
					 BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
					 Image card = SwingFXUtils.toFXImage(img, null);
					 image = card;
				}
				catch (IOException e) {
					e.printStackTrace();
					image = songCover;
				}
			}
			else if(file.hasId3v1Tag()){
				ID3v1 tag = file.getId3v1Tag();
				title  = tag.getTitle();
				album = tag.getAlbum();
				artist = tag.getArtist();
			}
		} catch (UnsupportedTagException | InvalidDataException | IOException e) {
			title = songFile.getName();
			album = "Unknown";
		}
	}
	

	public MediaPlayer getPlayer(){
		return player;
	}
	public void play(){
		if (this.player != null)
	    {
	      MediaPlayer.Status currentStatus = this.player.getStatus();
	      if ((currentStatus == MediaPlayer.Status.PAUSED) || (currentStatus == MediaPlayer.Status.STOPPED))
	      {
	        System.out.println("Player will start at: " + this.player.getCurrentTime());
	        this.player.play();
	      }
	    }
	    else
	    {
	      player = new MediaPlayer(new Media(songFile.toURI().toString()));
	      this.player.play();
	    }
	}
	  public Duration getTime()
	  {
	    if (this.player != null) {
	      return this.player.getTotalDuration();
	    }
	    return null;
	  }
	  
	  public void pause()
	  {
	    if ((this.player.getStatus() == MediaPlayer.Status.PLAYING) && (this.player != null)) {
	      this.player.pause();
	    }
	  }
	  
	  public void stop()
	  {
	    if ((this.player.getStatus() == MediaPlayer.Status.PLAYING) && (this.player != null)) {
	      this.player.stop();
	    }
	  }
	  
	  public void close()
	  {
	    if (this.player != null)
	    {
	      this.player.stop();
	      this.player = null;
	    }
	  }
	  
	  public MediaPlayer.Status getStatus()
	  {
	    return this.player.getStatus();
	  }
	  
	  public boolean isPlaying()
	  {
	    return this.player.getStatus() == MediaPlayer.Status.PLAYING;
	  }

}
