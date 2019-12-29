import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.*;

public class Musicview extends JFrame{
	
	public Musicview() {
		
		setTitle("Music Player");
		
        setSize(200,500);
        setResizable(true);
        setVisible(true);
        ViewPanel VP = new ViewPanel();
        this.add(VP);
	}

}
