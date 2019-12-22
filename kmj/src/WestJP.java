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

		
		allImage.addActionListener(new ActionListener(){ //사진전체보기
			public void actionPerformed(ActionEvent e) {
				Main main = (Main) SwingUtilities.getWindowAncestor((Component) e.getSource());
				main.centerJP.image();
			}
		});
		allMusic.addActionListener(new ActionListener(){ //음악전체보기
			public void actionPerformed(ActionEvent e) {
				Main main = (Main) SwingUtilities.getWindowAncestor((Component) e.getSource());
				main.centerJP.music();
			}
		});
		addImage.addActionListener (new ActionListener(){ //사진 추가 업로드 버튼 이벤트
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());//파일 선택 창
				jfc.setMultiSelectionEnabled(true);
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("all type", "jpg", "JPG","PNG","png","GIF","gif"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("JPG", "jpg", "JPG"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("PNG", "PNG", "png"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("GIF", "GIF", "gif"));
				jfc.setAcceptAllFileFilterUsed(false);

				int returnValue = jfc.showSaveDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					try{
						File[] file = jfc.getSelectedFiles();//내가 선택한 파일
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
			public void actionPerformed(ActionEvent e) { //음악 추가 업로드 버튼 이벤트
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());// 파일 선택 창
				
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("all type","MP3","mp3","MP4","mp4","WAV","wav","flac","FLAC"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("FLAC","flac","FLAC"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("MP3","MP3","mp3"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("MP4","MP4","mp4"));
				jfc.addChoosableFileFilter(new FileNameExtensionFilter("WAV","WAV","wav"));
				jfc.setAcceptAllFileFilterUsed(false);
				
				int returnValue = jfc.showSaveDialog(null);
				
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					try{
						File file = jfc.getSelectedFile();// 내가 선택한 파일
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
		add(new JLabel("사진목록"));
		add(Box.createRigidArea(new Dimension(0,5)));
		add(allImage);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(addImage);
		
		/////////////////////////////////////////
		add(Box.createRigidArea(new Dimension(0,30))); //사진과 음악 구분gap
		/////////////////////////////////////////
		
		add(new JLabel("음악목록"));
		add(Box.createRigidArea(new Dimension(0,5)));
		add(allMusic);
		add(Box.createRigidArea(new Dimension(0,5)));
		add(addMusic);
		addImage.setBackground(Color.green);
		addMusic.setBackground(Color.green);
	}
//	private static String getFileExtension(int i,File file) { //파일 확장자 확인
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
		// 파리미터 
		// filePath 원본 사진
		// 파일 타입
		
		
		BufferedImage srcImg = ImageIO.read(new File(filePath)); // 저장된 원본파일로부터 BufferedImage 객체를 생성합니다.
		
		int dw = 110, dh = 110; // 썸네일의 너비와 높이 입니다. 
	
		int ow = srcImg.getWidth();// 원본 이미지의 너비와 높이 입니다. 
		int oh = srcImg.getHeight();//
			
		int nw = ow;          // 원본 너비를 기준으로 하여 썸네일의 비율로 높이를 계산합니다. 
		int nh = (ow * dh) / dw; 
		// 계산된 높이가 원본보다 높다면 crop이 안되므로
		// 원본 높이를 기준으로 썸네일의 비율로 너비를 계산합니다.
		
		if(nh > oh) { nw = (oh * dw) / dh; nh = oh; }
		// 계산된 크기로 원본이미지를 가운데에서 crop 합니다. 
		
		BufferedImage cropImg = Scalr.crop(srcImg, (ow-nw)/2, (oh-nh)/2, nw, nh);
		// crop된 이미지로 썸네일을 생성합니다. 
		
		BufferedImage destImg = Scalr.resize(cropImg, dw, dh); 
		// 썸네일을 저장합니다. 이미지 이름 앞에 "THUMB_" 를 붙여 표시했습니다. 
		
		String thumbName = Main.THUMBNAIL_PATH + fileName;
		File thumbFile = new File(thumbName);
		System.out.println("write"+thumbFile.getAbsolutePath());
		ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
	}
}
