import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;

import jaco.mp3.player.MP3Player;

public class MyActionListener implements ActionListener {

	CenterJP centerJP;

	public void actionPerformed(ActionEvent e) {
		centerJP.musicPlay();
	} 
}