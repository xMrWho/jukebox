package test;

/**
 * @author xMrWho
 *
 *
 * TODO: OPEN SONG IF PLAYER IS ALREADY STARTABLE DO NOT WORK
 * TODO: OPEN SONG EFFECTS THAT PLAYER IS GOING TO STOP AND LOAD THE CURRENT SONG
 * TODO: THIS METHODS CLASS SHOULD ONLY BE A BRIDGE FOR PAUSABLEPLAYER AND GUI TO COMMUNICATE
 * TODO: EACH METHOD IN A DIFFERENT CLASS FOR BETTER COMMUNICATION
 * TODO: PLEASE INIT A NEW PACKAGE FOR THE METHOD STUFF
 * TODO: if Song ended also reset the Time Text Field
 * 
 */
/**
public class Methods {
	public PausablePlayer player;
	private ArrayList<File> playable;
	public MainController gui;
	private timer myTimer;

	public Methods(MainController gui){
		this.gui      = gui;
		this.playable = new ArrayList<File>();
	}
    
	public void addPlayable(File f){
			playable.add(f);
	}
	
	public void removePlayable(File f){
		playable.remove(f);
	}
	

  public void play()
  {
    if (player != null)
    {
      if (this.player.getStatus() == MediaPlayer.Status.PAUSED)
      {
       //TODO Icon ändern 
    	gui.playIco.setIcon(FontAwesomeIcon.PAUSE_CIRCLE_ALT);
        this.player.play();
      }
    } 
    else if(player == null){
    	player = new PausablePlayer();
    	player.setCurrent(playable.get(0));
    	player.play();
    	playback();
    	gui.playIco.setIcon(FontAwesomeIcon.PAUSE_CIRCLE_ALT);
    	
    }
    }
   
	private void playback() {
	myTimer = new timer(this);
	myTimer.startTimer();
	
}

	public void slidTime(double val) {
		if(player != null && player.isPlaying()){
		player.player.seek(Duration.seconds(val));	
		}
	}

	boolean muted = false;
	public void slidVol(double val) {
		if(player != null){
			double i = val / 100.0D;
			FontAwesomeIcon mute = FontAwesomeIcon.VOLUME_OFF;
			FontAwesomeIcon full = FontAwesomeIcon.VOLUME_UP;
			FontAwesomeIcon low = FontAwesomeIcon.VOLUME_DOWN;
			if(val > 49 && val <= 100){
				gui.volIco.setIcon(full);
				player.player.setVolume(i);
				muted = false;
			}
			else if (val <= 49 && val != 0){
				gui.volIco.setIcon(low);
				player.player.setVolume(i);
				muted = false;
			}
			else if (val ==  0){
				gui.volIco.setIcon(mute);
				player.player.setVolume(i);
				gui.volIco.setIcon(mute);
	            muted = true;
			}
			
			
		}
		
	}
      
    double vol;
	public void muteVol() {
		if(muted== false){
			vol = player.player.getVolume();
			FontAwesomeIcon mute = FontAwesomeIcon.VOLUME_OFF;	
			gui.volIco.setIcon(mute);
			player.player.setVolume(0);
			muted = true;
		}
		else{
			FontAwesomeIcon mute = FontAwesomeIcon.VOLUME_OFF;
			FontAwesomeIcon full = FontAwesomeIcon.VOLUME_UP;
			FontAwesomeIcon low = FontAwesomeIcon.VOLUME_DOWN;
			player.player.setVolume(vol);
			double val = vol;
			muted = false;
			if(val > 49 && val <= 100){
				gui.volIco.setIcon(full);
				player.player.setVolume(val);
				muted = false;
			}
			else if (val <= 49 && val != 0){
				gui.volIco.setIcon(low);
				player.player.setVolume(val);
				muted = false;
			}
			else if (val ==  0){
				gui.volIco.setIcon(mute);
				player.player.setVolume(val);
				gui.volIco.setIcon(mute);
	            muted = true;
			}
		
		}
		
	}

	public void next() {
		myTimer.stopTimer();
		gui.songCoverIV.setImage(new Image(getClass().getResource("/images/cd.png").toExternalForm()));
		
		gui.song.setText("Song: ");
		gui.artist.setText("Künstler: ");
		gui.album.setText("Album: ");
		gui.playIco.setIcon(FontAwesomeIcon.PLAY_CIRCLE_ALT);
		gui.timeSlider.setValue(0);
		gui.timeSlider.setMax(100);
		playable.remove(0);
	}
	
	
	
	
	
	
	
	
	
	
	
}
*/
public class Methods{}
