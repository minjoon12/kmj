import java.io.File;

import javax.swing.Icon;
import javax.swing.JButton;

public class Imagebutton extends JButton {
	
	public File imageFile; 
	
	public Imagebutton(Icon imageIcon) {
		super(imageIcon);
	}
}