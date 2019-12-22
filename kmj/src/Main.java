import java.util.Scanner;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.sound.midi.Patch;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.swing.filechooser.FileSystemView;
import org.imgscalr.Scalr;
import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import org.imgscalr.Scalr;

// ***https://github.com/rkalla/imgscalr*** /////////// scalr ���̺귯�� �ٿ�!!!!!!!!!!!!!!!!!!!!!!!!!


public class Main extends JFrame{
	
	public static String MUSIC_PATH = "C:/Users/�л���/Desktop/java nas(������)/music/";
	public static String PICTURE_PATH = "C:/Users/�л���/Desktop/java nas(������)/Image/";
	public static String THUMBNAIL_PATH = "C:/Users/�л���/Desktop/java nas(������)/thumbnail/";
	public static String INTERFACE_PATH = "C:/Users/�л���/Desktop/java nas(������)/interface/";
	
	WestJP folderJP = new WestJP();
	
	CenterJP centerJP = new CenterJP();
	
	/**
	 * �ּ��߰�
	 */
	public Main()
	{
		setTitle("���ϰ���");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		c.setLayout(new BorderLayout());
		
		c.add(folderJP,BorderLayout.WEST);
		c.add(centerJP,BorderLayout.CENTER);
		
		setSize(600,600);
		setVisible(true);
	}

	public static void main(String[] args) throws IIOException{
		new Main();
	}
}