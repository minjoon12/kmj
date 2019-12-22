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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;
import org.imgscalr.Scalr;
import java.awt.image.*;
import javax.imageio.*;


public class WestJP extends JPanel {
	
	JButton allImage = new JButton("view all image");
	JButton addImage = new JButton("add image");
	JButton allMusic = new JButton("view all music");
	JButton addMusic = new JButton("add music");
	
	public WestJP() {
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		setLayout(box);

		
		allImage.addActionListener(new ActionListener(){ //������ü����
			public void actionPerformed(ActionEvent e) {
				Main main = (Main) SwingUtilities.getWindowAncestor((Component) e.getSource());
				main.centerJP.image();
			}
		});
		allMusic.addActionListener(new ActionListener(){ //������ü����
			public void actionPerformed(ActionEvent e) {
				Main main = (Main) SwingUtilities.getWindowAncestor((Component) e.getSource());
				main.centerJP.music();
			}
		});
		addImage.addActionListener (new ActionListener(){ //���� �߰� ���ε� ��ư �̺�Ʈ
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());//���� ���� â
				jfc.setMultiSelectionEnabled(true);
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("all type", "jpg", "JPG","PNG","png","GIF","gif"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("JPG", "jpg", "JPG"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("PNG", "PNG", "png"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("GIF", "GIF", "gif"));
				jfc.setAcceptAllFileFilterUsed(false);

				int returnValue = jfc.showSaveDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					try{
						File[] file = jfc.getSelectedFiles();//���� ������ ����
							for(int x=0; x < file.length  ; x++) {
								
								Path src = Paths.get(file[x].getAbsolutePath());
								Path target = Paths.get(Main.PICTURE_PATH + file[x].getName());
								Files.copy(src,target);
								System.out.println(file[x].getAbsolutePath());
								System.out.println(file[x].getName());
								
								String tr =FilenameUtils.getExtension(file[x].getAbsolutePath());
								
								makeThumbnail(file[x].getAbsolutePath(),file[x].getName(),tr);
							}
							
					}catch(Exception m){
						m.printStackTrace();
					}
				}
			}
		});
		addMusic.addActionListener (new ActionListener(){
			public void actionPerformed(ActionEvent e) { //���� �߰� ���ε� ��ư �̺�Ʈ
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());// ���� ���� â
				
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("all type","MP3","mp3","MP4","mp4","WAV","wav","flac","FLAC"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("FLAC","flac","FLAC"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("MP3","MP3","mp3"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("MP4","MP4","mp4"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("WAV","WAV","wav"));
				jfc.setAcceptAllFileFilterUsed(false);
				
				int returnValue = jfc.showSaveDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					try{
						File file = jfc.getSelectedFile();// ���� ������ ����
						Path src = Paths.get(file.getAbsolutePath());
						Path target= Paths.get(Main.MUSIC_PATH + file.getName());
						Files.copy(src,target);
						System.out.println(file.getAbsolutePath());
					}catch(IOException m){
						m.printStackTrace();
					}
				}
			}
		});
		add(new JLabel("�������"));
		add(Box.createRigidArea(new Dimension(0,5)));
		add(allImage);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(addImage);
		
		/////////////////////////////////////////
		add(Box.createRigidArea(new Dimension(0,30))); //������ ���� ����gap
		/////////////////////////////////////////
		
		add(new JLabel("���Ǹ��"));
		add(Box.createRigidArea(new Dimension(0,5)));
		add(allMusic);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(addMusic);
		addImage.setBackground(Color.green);
		addMusic.setBackground(Color.green);
	}
//	private static String getFileExtension(int i,File file) { //���� Ȯ���� Ȯ��
//        String extension = "";
// 
//        try {
//            if (file != null && file.exists()) {
//                String name = file.getName();
//                extension = name.substring(name.lastIndexOf(".")+1);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//       if(i==1) {
//       	if(extension.equalsIgnoreCase("TIF")||extension.equalsIgnoreCase("BMP")||
//        	extension.equalsIgnoreCase("JPEG")||extension.equalsIgnoreCase("JPG")||
//			extension.equalsIgnoreCase("GIF")||extension.equalsIgnoreCase("PNG")||
//      	extension.equalsIgnoreCase("TIFF")||extension.equalsIgnoreCase("RAW")||) {
//        		
//        	}
//        }
//        return extension;
// 
//    }
	private void makeThumbnail(String filePath, String fileName, String fileExt) throws Exception {
		// �ĸ����� 
		// filePath ���� ����
		// ���� Ÿ��
		
		
		BufferedImage srcImg = ImageIO.read(new File(filePath)); // ����� �������Ϸκ��� BufferedImage ��ü�� �����մϴ�.
		
		int dw = 110, dh = 110; // ������� �ʺ�� ���� �Դϴ�. 
	
		int ow = srcImg.getWidth();// ���� �̹����� �ʺ�� ���� �Դϴ�. 
		int oh = srcImg.getHeight();//
			
		int nw = ow;          // ���� �ʺ� �������� �Ͽ� ������� ������ ���̸� ����մϴ�. 
		int nh = (ow * dh) / dw; 
		// ���� ���̰� �������� ���ٸ� crop�� �ȵǹǷ�
		// ���� ���̸� �������� ������� ������ �ʺ� ����մϴ�.
		
		if(nh > oh) { nw = (oh * dw) / dh; nh = oh; }
		// ���� ũ��� �����̹����� ������� crop �մϴ�. 
		
		BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);
		// crop�� �̹����� ������� �����մϴ�. 
		
		BufferedImage destImg = Scalr.resize(cropImg, dw, dh); 
		// ������� �����մϴ�. �̹��� �̸� �տ� "THUMB_" �� �ٿ� ǥ���߽��ϴ�. 
		
		String thumbName = Main.THUMBNAIL_PATH + fileName;
		File thumbFile = new File(thumbName);
		System.out.println("write"+thumbFile.getAbsolutePath());
		ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
	}
}
