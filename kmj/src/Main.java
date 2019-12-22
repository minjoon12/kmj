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

// ***https://github.com/rkalla/imgscalr*** /////////// scalr 라이브러리 다운!!!!!!!!!!!!!!!!!!!!!!!!!


public class Main extends JFrame{
	
	public static String MUSIC_PATH = "C:/Users/학생용/Desktop/java nas(강민준)/music/";
	public static String PICTURE_PATH = "C:/Users/학생용/Desktop/java nas(강민준)/Image/";
	public static String THUMBNAIL_PATH = "C:/Users/학생용/Desktop/java nas(강민준)/thumbnail/";
	public static String INTERFACE_PATH = "C:/Users/학생용/Desktop/java nas(강민준)/interface/";
	
	WestJP folderJP = new WestJP();
	
	CenterJP centerJP = new CenterJP();
	
	/**
	 * 주석추가12
	 */
	public Main()
	{
		setTitle("파일관리");
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
