package session_02;

import java.io.File;
import java.util.ArrayList;
import javafx.stage.DirectoryChooser;

public class musicFinder {
	ArrayList<File> files;
	public void start(){
		DirectoryChooser chooser = new DirectoryChooser();
		chooser.setTitle("JavaFX Projects");
		File defaultDirectory = new File(System.getProperty("user.home"));
		chooser.setInitialDirectory(defaultDirectory);
		File selectedDirectory = chooser.showDialog(null);
		System.err.println(selectedDirectory.getAbsolutePath());
        files = searchFile(selectedDirectory);
        print();
	}
	public ArrayList<File> searchFile(File dir) {
		File[] files = dir.listFiles();
		ArrayList<File> matches = new ArrayList<File>();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				if(files[i].getName().endsWith(".mp3")|| files[i].getName().endsWith(".wav")){
					matches.add(files[i]);
					System.err.println("DEBUG: "+files[i].getName());
				}
				if (files[i].isDirectory()) {
					matches.addAll(searchFile(files[i]));
					System.err.println("DEBUG: "+files[i].getName());
				}
			}
		}
		return matches;	
	}

	public void print() {
		File f = null;
		for(int i = 0; i < files.size(); i++){
			f = files.get(i);
			System.err.println(f.getName());
		}
	}	
}
