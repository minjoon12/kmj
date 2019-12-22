import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Musicview extends JFrame{
	CenterJP CJ;
	JButton ps = new JButton("play/stop");
	JButton next = new JButton(">>");
	JButton prev = new JButton("<<");
	public Musicview(String[] args) {
		
		setTitle("musicplayer");
		
		ps.addActionListener(new ActionListener(){//À½¾Ç Àç»ý&Á¤Áö
			public void actionPerformed(ActionEvent e) {
				if(CJ.player==null){
					CJ.player.play();
				}
				else{
					CJ.player.stop();
				}
			}
		});
		next.addActionListener(new ActionListener(){//´ÙÀ½ À½¾Ç
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		prev.addActionListener(new ActionListener(){//ÀÌÀü À½¾Ç
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
        setSize(200,500);
        setResizable(true);
        setVisible(true);
	}

}
