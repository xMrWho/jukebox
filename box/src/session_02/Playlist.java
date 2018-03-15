package session_02;

import java.util.ArrayList;

public class Playlist {
	private ArrayList<Song> playlist;
	private String name;
	/**
	 * 
	 * @return Name of Playlist
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * Set the name of the playlist @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	/**
	 * Initialisiert diese Playlist, die keine Lieder enth�lt. 
	 *
	 */
	public Playlist() {
		playlist = new ArrayList<Song>();
	}

	/**
	 * Dieser Kopierkonstruktor initialisiert die Playlist, 
	 * die alle Lieder einer bereits bestehenden Instanz 
	 * enth�lt. �nderungen einer der beiden Playlists 
	 * d�rfen sich auf der jeweils anderen nicht auswirken. 
	 *
	 * @param original Die Playlist, welche kopiert werden soll 
	 */
	public Playlist(Playlist original) {
		playlist = new ArrayList<Song>();
		Song t;
		for(int i = 0; i < original.playlist.size(); i++) {
			t = original.playlist.get(i);
			this.addSong(t);
		}
	}

	/**
	 * Dieser Kopierkonstruktor initialisiert die Playlist, 
	 * die eine Aneinanderkettung von zwei bestehenden 
	 * Playlists darstellt. Dabei sollen zuerst die 
	 * Lieder aus playlist1, dann die Lieder aus der 
	 * playlist2 �bernommen werden. �nderungen einer 
	 * der drei danach bestehenden Playlists d�rfen 
	 * sich auf den jeweils anderen nicht auswirken. 
	 *
	 * @param playlist1 Die erste Playlist, deren Songs 
	 * 	in die neue Playlist �bernommen werden sollen 
	 * @param playlist2 Die zweite Playlist, deren Songs 
	 * 	in die neue Playlist �bernommen werden sollen 
	 */
	public Playlist(Playlist playlist1, Playlist playlist2) {
		playlist = new ArrayList<Song>();
		Song t;
		for(int i = 0; i < playlist1.playlist.size(); i++) {
			t = playlist1.playlist.get(i);
			this.addSong(t);
		}
		for(int i = 0; i < playlist2.playlist.size(); i++) {
			t = playlist2.playlist.get(i);
			this.addSong(t);
		}
	}

	/**
	 * F�gt einen Song an die Playlist an; der Song 
	 * soll dabei ans Ende der Playlist gestellt werden. 
	 * Eine Playlist darf jedoch nicht den selben Song 
	 * doppelt enthalten, stellen Sie also sicher, dass 
	 * die Methode addSong dies �berpr�ft. Hierbei ist 
	 * es ausreichend zu �berpr�fen, ob genau das selbe 
	 * Objekt (die selbe Referenz) bereits gespeichert 
	 * ist. Sie k�nnen daher problemlos eine entsprechende 
	 * Methode der Klasse  nutzen. addSong soll true 
	 * zur�ckgeben, falls das Hinzuf�gen erfolgreich 
	 * war, und false, falls nicht. 
	 *
	 * @param song Der Song, der zur Playlist 
	 * 	hinzugef�gt werden soll 
	 *
	 * @return Ein Wert, der Angibt, ob das 
	 * 	Hinzuf�gen erfolgreich war 
	 */
	public boolean addSong(Song song) {
		if(!playlist.contains(song)) {
			playlist.add(song);
			return true;
		}
		return false; 
	}

	/**
	 * Erzeugt aus der bestehenden Playlist eine zweite 
	 * Playlist, welche nur Lieder des durch artist 
	 * angegebenen Interpreten enth�lt. 
	 *
	 * @param artist Der Interpret, dessen Lieder in 
	 * 	die neue Playlist �bernommen werden sollen 
	 *
	 * @return Die neu erzeugte Playlist 
	 */
	public Playlist extractPlaylistByArtist(String artist) {
		Playlist newList = new Playlist();
		Song t;
		for(int i = 0; i < playlist.size(); i++) {
			t = playlist.get(i);
			if(t.getArtist().equals(artist)) {
				newList.addSong(new Song(t.getSongFile()));
			}
		}
		return newList; 

	}

	/**
	 * Z�hlt, wie viele Lieder des durch artist angegebenen 
	 * Interpreten in der Playlist enthalten sind. 
	 *
	 * @param artist Der Interpret, dessen 
	 * 	Lieder gez�hlt werden sollen 
	 *
	 * @return Die Anzahl der Lieder des 
	 * 	Interpreten in der Playlist 
	 */
	public int countSongsByArtist(String artist) {
		int cnt = 0;
		for(int i = 0; i < playlist.size(); i++) {
			if(playlist.get(i).getArtist().equals(artist)) {
				cnt ++;
			}
		}
		return cnt;

	}

	/**
	 * Erstellt eine lesbare Form der Playlist. Diese 
	 * besteht aus einer Liste der String-Repr�sentationen 
	 * der Songs, sowie in der letzten Zeile die Gesamtlauftzeit 
	 * der Playlist. 
	 *  
	 *
	 * @return Eine lesbare Repr�sentation der Playlist 
	 */
	public String toString() {
		int sum = 0;
		String ret = "";
		for(int i = 0; i < playlist.size(); i++) {
			ret += playlist.get(i).toString() + '\n';
			sum += playlist.get(i).getDuration();
		}
		ret += sum;
		return ret; 
	}

	
}
