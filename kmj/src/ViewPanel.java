import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class ViewPanel extends JPanel{
	String name;
	
	@Override
	public void paint(Graphics g) {
	
		System.out.println("paint");

		ImageIcon ImageIcon = new ImageIcon(Main.PICTURE_PATH + name);
		Image image = ImageIcon.getImage();
		g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
		//super.paint(g);
	}
	
	
	public ViewPanel(String imagename) {
	    System.out.println(Main.PICTURE_PATH + imagename);
        name = imagename;
        
        setVisible(true);
        this.repaint();
	}
	
	
	CenterJP CJ;
	JButton ps = new JButton("play/stop");
	JButton next = new JButton(">>");
	JButton prev = new JButton("<<");
	public ViewPanel(){
		
		add(ps);
		add(next);
		add(prev);
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
				CJ.player.stop();
				CJ.i++;
				CJ.player.play();
			}
		});
		prev.addActionListener(new ActionListener(){//ÀÌÀü À½¾Ç
			public void actionPerformed(ActionEvent e) {
				CJ.player.stop();
				CJ.i--;
				CJ.player.play();
			}
		});
	}
}








