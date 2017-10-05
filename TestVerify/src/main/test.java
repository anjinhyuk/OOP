package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class test implements KeyListener, ActionListener {

	JFrame frame;
	private final int WIDTH = 1000;
	private final int HEIGHT = 800;
	private static int option = 0;
	private static int fileIndex = 0;
	private static String outputFilePath = "Output";
	private JLabel imageLabel;
	private JLabel charLabel;
	private JPanel cenPanel;
	private static Border border;
	private static JRadioButton rdbtnProceed;
	private static JRadioButton rdbtnYes;
	private static JRadioButton rdbtnNo;
	private static JRadioButton rdbtnDont;
	private static JRadioButton rdbtnDone;
	
	ArrayList<File> fileArray = new ArrayList<File>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public test() {
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("AGES - Simple Training Set Verifier");
		frame.setBounds(100, 100, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.addKeyListener(this);
		
		//Input Label
		JPanel inputPanel = new JPanel();
		inputPanel.setBounds(0, 0, WIDTH, 70);
		inputPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(inputPanel);
		inputPanel.setLayout(null);
		
		JLabel lblinputLabel = new JLabel("Input File Location:");
		lblinputLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblinputLabel.setBounds(10, 11, 132, 16);
		inputPanel.add(lblinputLabel);
		
		border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JLabel lblNewLabel = new JLabel("Verify Original Image and Computer Unicode Character Match");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(600, 10, 385, 14);
		inputPanel.add(lblNewLabel);
		
		JLabel lblExp1 = new JLabel("On your keyboard, press the letter in parenthesse for the action");
		lblExp1.setBounds(600, 24, 390, 14);
		inputPanel.add(lblExp1);
		
		JLabel lblExp2 = new JLabel("desired then type P or click the Proceed button to go to next");
		lblExp2.setBounds(600, 36, 390, 14);
		inputPanel.add(lblExp2);
		
		JLabel lblExp3 = new JLabel("image. Type D or clikc Done when finished with session.");
		lblExp3.setBounds(600, 48, 390, 14);
		inputPanel.add(lblExp3);
		
		//Radio Panel
		JPanel radioPanel = new JPanel();
		radioPanel.setBounds(750, 70, 250, 629);
		radioPanel.setBackground(Color.GRAY);
		frame.getContentPane().add(radioPanel);
		radioPanel.setLayout(null);
		
		//Radio Buttons
		rdbtnProceed = new JRadioButton("0 - Proceed (P) \r\n(Submit Action)");
		rdbtnProceed.setSelected(true);
		rdbtnProceed.setMnemonic(KeyEvent.VK_P);
		rdbtnProceed.setMnemonic(KeyEvent.VK_0);
		rdbtnProceed.setActionCommand("proceed");
		rdbtnProceed.setBounds(6, 21, 206, 23);
		radioPanel.add(rdbtnProceed);
		
		rdbtnYes = new JRadioButton("1 - Yes (Y)");
		rdbtnYes.setMnemonic(KeyEvent.VK_Y);
		rdbtnYes.setMnemonic(KeyEvent.VK_1);
		rdbtnYes.setActionCommand("yes");
		rdbtnYes.setBounds(6, 47, 130, 23);
		radioPanel.add(rdbtnYes);
		
		rdbtnNo = new JRadioButton("2 - No (N)");
		rdbtnNo.setMnemonic(KeyEvent.VK_N);
		rdbtnNo.setMnemonic(KeyEvent.VK_2);
		rdbtnNo.setActionCommand("no");
		rdbtnNo.setBounds(6, 73, 130, 23);
		radioPanel.add(rdbtnNo);
		
		rdbtnDont = new JRadioButton("3 - Don't Know (K)");
		rdbtnDont.setMnemonic(KeyEvent.VK_K);
		rdbtnDont.setMnemonic(KeyEvent.VK_3);
		rdbtnDont.setActionCommand("know");		
		rdbtnDont.setBounds(6, 99, 130, 23);
		radioPanel.add(rdbtnDont);
		
		rdbtnDone = new JRadioButton("4 - Done / Exit (D)");
		rdbtnDone.setMnemonic(KeyEvent.VK_D);
		rdbtnDone.setMnemonic(KeyEvent.VK_4);
		rdbtnDone.setActionCommand("done");
		rdbtnDone.setBounds(6, 125, 130, 23);
		radioPanel.add(rdbtnDone);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnProceed);
		group.add(rdbtnYes);
		group.add(rdbtnNo);
		group.add(rdbtnDont);
		group.add(rdbtnDone);
		
		rdbtnProceed.addActionListener(this);
		rdbtnYes.addActionListener(this);
		rdbtnNo.addActionListener(this);
		rdbtnDont.addActionListener(this);
		rdbtnDone.addActionListener(this);
		
		rdbtnProceed.addKeyListener(this);
		rdbtnYes.addKeyListener(this);
		rdbtnNo.addKeyListener(this);
		rdbtnDont.addKeyListener(this);
		rdbtnDone.addKeyListener(this);
		
		//Center Panel
		JPanel centerPanel = new JPanel();
		centerPanel.setBounds(0, 70, 750, 629);
		centerPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(centerPanel);
		centerPanel.setLayout(null);
		
		JLabel lblTitle = new JLabel("Verify Original Image and Computer Unicode Match");
		lblTitle.setBounds(117, 101, 600, 25);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 19));
		centerPanel.add(lblTitle);
		
		JLabel lblOriginal = new JLabel("Original Image");
		lblOriginal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOriginal.setBounds(126, 163, 150, 20);
		centerPanel.add(lblOriginal);
		
		JLabel lblComputer = new JLabel("Computer Unicode");
		lblComputer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblComputer.setBounds(450, 163, 150, 20);
		centerPanel.add(lblComputer);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBounds(68, 194, 250, 250);
		centerPanel.add(lblimage);
		lblimage.setBorder(border);
		
		JLabel lbluni = new JLabel("");
		lbluni.setBounds(402, 194, 250, 250);
		centerPanel.add(lbluni);
		lbluni.setBorder(border);
//		
//		JLabel lblWarn = new JLabel("To start with this program, please press \"change input-file path\" or \"Default\" in the input section above");
//		lblWarn.setBounds(0, 0, 600, 39);
//		centerPanel.add(lblWarn);
//		lblWarn.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblDir = new JLabel("");
		lblDir.setBounds(140, 13, 404, 14);
		lblDir.setFont(new Font("DengXian (Body Asian)", Font.PLAIN, 11));
		inputPanel.add(lblDir);
		
		setCenPanel(centerPanel);
		
		//Output Panel
		JPanel outputPanel = new JPanel();
		outputPanel.setBounds(0, 700, 1000, 70);
		outputPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(outputPanel);
		outputPanel.setLayout(null);
		
		JLabel lblOutputLabel = new JLabel("Output Location:");
		lblOutputLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOutputLabel.setBounds(21, 11, 123, 16);
		outputPanel.add(lblOutputLabel);
		
		JLabel lblDirout = new JLabel("");
		lblDirout.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDirout.setBounds(141, 11, 404, 14);
		outputPanel.add(lblDirout);
		
		//---------------------------------------------------------------------------------------------//
		
		//Input Button
		JButton btnInputButton = new JButton("Change input-file path...");
		btnInputButton.setBounds(20, 36, 177, 23);
		btnInputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					fileIndex = 0;
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					storeFile(path);
					lblDir.setText(path);
					drawImage(getFile(fileIndex).getAbsolutePath(), lblimage);
					drawChar(lbluni);
				}
			}		
		});
		
		//Input Default
		JButton btnInputDefault = new JButton("Default");
		btnInputDefault.setBounds(207, 36, 86, 23);
		btnInputDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"You set the \"Input\" folder in the program as input", "Input Default", JOptionPane.INFORMATION_MESSAGE);
				fileIndex = 0;
				String path = "Input";
				storeFile(path);
				lblDir.setText(path);
				drawImage(getFile(fileIndex).getAbsolutePath(), lblimage);
				drawChar(lbluni);	
			}
		});
		
		//Output Buttons
		JButton btnOutputButton = new JButton("Change output-file path...");
		btnOutputButton.setBounds(21, 36, 179, 23);
		btnOutputButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					outputFilePath = path;
					System.out.println(path);
					lblDirout.setText(path);
					try {
						Files.createDirectories(Paths.get(path+"/Yes"));
						Files.createDirectories(Paths.get(path+"/No"));
						Files.createDirectories(Paths.get(path+"/Don't_Know"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		//Output Default
		JButton btnOutputDefault = new JButton("Default");
		btnOutputDefault.setBounds(210, 36, 91, 23);
		btnOutputDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				outputFilePath = "Output";
				lblDirout.setText(outputFilePath);
				JOptionPane.showMessageDialog(null,"You set the \"Output\" folder in the program as output", "Output Default", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		setImageLabel(lblimage);
		setCharLabel(lbluni);

		inputPanel.add(btnInputButton);
		outputPanel.add(btnOutputButton);
		inputPanel.add(btnInputDefault);
		outputPanel.add(btnOutputDefault);

		storeFile("Input");

	}
	
	//Storing files in the folder
	public void storeFile(String path) {
		File fileDir = new File(path);
		File[] files = fileDir.listFiles();
		fileArray.clear();
		for (File f : files) {
			//getting extension of files
			String extension = "";
			int i = f.getName().lastIndexOf('.');
			if (i >= 0) {
			    extension = f.getName().substring(i+1);
			}
			//putting only image files
			if(extension.equalsIgnoreCase("jpg") || extension.equalsIgnoreCase("gif") || extension.equalsIgnoreCase("png")) {
				fileArray.add(f);
			}
		}
	}
	
	//return file 
	public File getFile(int a) {
		return fileArray.get(a);
	}
	
	public void drawImage(String p, JLabel j) {
		j.setIcon(ResizeImage(p));
	}
	
	public void drawChar(JLabel j) {
		char c = getFile(fileIndex).getName().charAt(0);
		j.setBackground(Color.white);
		j.setText(""+c);
		j.setBounds(402, 194, 250, 250);
		j.setHorizontalAlignment(SwingConstants.CENTER);
		j.setFont(new Font("DengXian (Body Asian)", Font.PLAIN, 180));
		getCenPanel().add(j);
		j.setBorder(border);
	}
	
	//resize Image
	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(250,250, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}

	//Getters and setters
	public void setOption(int opt) { this.option = opt;	}
	
	public int getOption () { return option; }

	public void setCenPanel(JPanel j) { this.cenPanel = j; }
	
	public JPanel getCenPanel() { return this.cenPanel;	}
	
	public void setImageLabel(JLabel j) { this.imageLabel = j; }
	
	public JLabel getImageLabel() {	return this.imageLabel; }
	
	public void setCharLabel(JLabel j) { this.charLabel = j; }
	
	public JLabel getCharLabel() { return this.charLabel; }
	
	//proceed function
	public void proceedFunction() {
		 if (getOption() == 0) {
			 JOptionPane.showMessageDialog(frame, "You have to choose option below");
		 } else { 
			 proceedFunctionWindows();
			 System.out.println(fileIndex);
		 }
	}
	
	//File Classifier
	public void proceedFunctionWindows() {
		//Yes Choice
		if(getOption() == 1) {
			Path FROM = Paths.get(getFile(fileIndex).getAbsolutePath());
			Path TO = Paths.get(outputFilePath + "/Yes/" + getFile(fileIndex).getName());
			try {
				Files.move(FROM, TO);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		//No Choice
		} else if (getOption() == 2) {
			Path FROM = Paths.get(getFile(fileIndex).getAbsolutePath());
			Path TO = Paths.get(outputFilePath + "/No/" + getFile(fileIndex).getName());
			try {
				Files.move(FROM, TO);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		//Dont know Choice
		} else if (getOption() == 3) {
			Path FROM = Paths.get(getFile(fileIndex).getAbsolutePath()); 
			Path TO = Paths.get(outputFilePath + "/Don't_Know/" + getFile(fileIndex).getName());
			try {
				Files.move(FROM, TO);
			} catch (IOException e) {
				e.printStackTrace();
			}				
		}
		//Automation
		if (fileIndex < fileArray.size()-1) {
			fileIndex++;
			drawImage(getFile(fileIndex).getAbsolutePath(), getImageLabel());
			getCharLabel().setBackground(Color.white);
			drawChar(getCharLabel());
		} else {
			JOptionPane.showMessageDialog(null,"There are no more files. Please change the directoy", "No files", JOptionPane.INFORMATION_MESSAGE);
		}
		setOption(0);
	}

	public void doneFunction() {
		int doneAction = JOptionPane.showOptionDialog(null, "You want to stop?", "Quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (doneAction == 0) {
			frame.dispose();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("proceed")) {
			proceedFunction();		
		}
		else if(e.getActionCommand().equals("yes")) {
			setOption(1);
		}
		else if(e.getActionCommand().equals("no")) {
			setOption(2);
		}
		else if(e.getActionCommand().equals("know")) {
			setOption(3);
		}
		else if(e.getActionCommand().equals("done")) {
			doneFunction();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if (c == KeyEvent.VK_P || c == KeyEvent.VK_NUMPAD0) {
			rdbtnProceed.setSelected(true);
			proceedFunction();
		} else if (c == KeyEvent.VK_Y || c == KeyEvent.VK_NUMPAD1) {
			rdbtnYes.setSelected(true);
			setOption(1);
		} else if (c == KeyEvent.VK_N || c == KeyEvent.VK_NUMPAD2 ) {
			rdbtnNo.setSelected(true);
			setOption(2);
		} else if (c == KeyEvent.VK_K || c == KeyEvent.VK_NUMPAD3) {
			rdbtnDont.setSelected(true);
			setOption(3);
		}
		else if (c == KeyEvent.VK_D || c == KeyEvent.VK_NUMPAD4) {
			rdbtnDone.setSelected(true);
			doneFunction();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}