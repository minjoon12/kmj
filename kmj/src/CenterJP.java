import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jaco.mp3.player.MP3Player;

public class CenterJP extends JPanel {

	//  클래스에는  멤버변수 ,  멤버 함수   branch1
	// branch11111111111111111
	
	
	public CenterJP() {
		WestJP WJ = new WestJP();
		GridLayout Grid = new GridLayout(5, 4, 5, 5);
		setLayout(Grid);
		music();
	}

	public void image() {
		String path = Main.THUMBNAIL_PATH;
		File f = new File(path);
		if (null != f.listFiles()) {
			File[] files = f.listFiles();
			for (int i = 0; i < 20; i++) {
				if (i < files.length) {

					Imagebutton imageBtn = new Imagebutton(new ImageIcon(files[i].getAbsolutePath()));
					imageBtn.imageFile = files[i];
					add(imageBtn);

					imageBtn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							Imagebutton btn = (Imagebutton) e.getSource();
							System.out.println(btn.imageFile.getName());
							View d = new View(btn.imageFile.getName());
							d.setVisible(true);
						}
					});
				} else {
					add((new JLabel(new ImageIcon(Main.INTERFACE_PATH + "no-image/"))));
				}
			}
		}

	}

	public void music() {
		String path = Main.MUSIC_PATH;
		File f = new File(path);
		if (null != f.listFiles()) {
			File[] files = f.listFiles();
			for (int i = 0; i < 20; i++) {
				if (i < files.length) {
					JButton musicbtn = new JButton(files[i].getName());
					add(musicbtn);
					
					MyActionListener myActionListener = new MyActionListener();
					myActionListener.file=files[i];
					myActionListener.centerJP=this;
					
					musicbtn.addActionListener(myActionListener);
				} else {
					JButton btn = new JButton("no music");
					add(btn);
				}
			}

		} else {

		}
	}
	
	MP3Player player;
	
	public void musicPlay(File file) {
		try{
			//음악재생
			//다른음악 재생시 정지
			//음악 재생 정지
			if(player!=null) player.stop();
			
			player = new MP3Player(file);
			player.play();
			
		}catch (Exception exception) {
			System.out.println("Error with playing sound.");
			exception.printStackTrace();
		}
		return;
	}
}
