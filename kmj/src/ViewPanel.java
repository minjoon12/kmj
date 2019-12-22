import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
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
        //this.validate();
        
	}

}
