import javax.swing.JDialog;
import javax.swing.JFrame;
public class View extends JFrame{
	
	public View(String imagename) {
		
		setTitle(imagename);
        
        setSize(500,500);
        setResizable(true);
        setVisible(true);
        ViewPanel JP = new ViewPanel(imagename);
        this.add(JP);
       
	}

}
