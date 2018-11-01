package iot;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JProgressBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.SystemColor;
import java.awt.event.InputMethodListener;
import java.io.File;
import java.util.Scanner;
import java.awt.event.InputMethodEvent;

public class frame1 extends image2matrix{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	static JLabel l;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 800, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWellcomeToThe = new JLabel("Welcome to the POV-Globe GUI Wizard");
		lblWellcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWellcomeToThe.setBounds(200, 63, 382, 16);
		frame.getContentPane().add(lblWellcomeToThe);
		
		JLabel lblThisWizardWill = new JLabel("This Wizard will help you to creat a image code for your globe.");
		lblThisWizardWill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThisWizardWill.setBounds(200, 108, 382, 16);
		frame.getContentPane().add(lblThisWizardWill);
		
		JLabel lblImagePath = new JLabel("Image path:");
		lblImagePath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImagePath.setBounds(200, 188, 98, 16);
		frame.getContentPane().add(lblImagePath);
		
		textField = new JTextField();
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				System.out.print(test_path);
			}
		});
		textField.setBounds(310, 186, 272, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Component path = null;
				System.out.println(btnBrowse);
				System.out.println("Browse");
				
			        // if the user presses the save button show the save dialog 
			        String com = evt.getActionCommand(); 
			        System.out.println(com);
			        if (com.equals("Browse")) { 
			            // create an object of JFileChooser class 
			            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
			  
			            // resctrict the user to selec files of all types 
			            j.setAcceptAllFileFilterUsed(false); 
			  
			            // set a title for the dialog 
			            j.setDialogTitle("Select a .png file"); 
			  
			            // only allow files of .txt extension 
			            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .png files", "png"); 
			            j.addChoosableFileFilter(restrict); 
			  
			            // invoke the showsSaveDialog function to show the save dialog 
			            int r = j.showSaveDialog(null); 
			  
			            // if the user selects a file 
			            if (r == JFileChooser.APPROVE_OPTION) 
			  
			            { 
			                // set the label to the path of the selected file 
			                l.setText(j.getSelectedFile().getAbsolutePath()); 
			            } 
			            // if the user cancelled the operation 
			            else
			                l.setText("the user cancelled the operation"); 
			        } 
			        // if the user presses the open dialog show the open dialog 
			  
			        else { 
			            // create an object of JFileChooser class 
			            JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
			  
			            // resctrict the user to selec files of all types 
			            j.setAcceptAllFileFilterUsed(false); 
			  
			            // set a title for the dialog 
			            j.setDialogTitle("Select a .png file"); 
			  
			            // only allow files of .txt extension 
			            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .png files", "png"); 
			            j.addChoosableFileFilter(restrict); 
			  
			            // invoke the showsOpenDialog function to show the save dialog 
			            int r = j.showOpenDialog(null); 
			  
			            // if the user selects a file 
			            if (r == JFileChooser.APPROVE_OPTION) { 
			                // set the label to the path of the selected file 
			                l.setText(j.getSelectedFile().getAbsolutePath()); 
			            } 
			            // if the user cancelled the operation 
			            else
			                l.setText("the user cancelled the operation"); 
			        }
			    } 
		});
		
		btnBrowse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBrowse.setBounds(600, 185, 97, 25);
		frame.getContentPane().add(btnBrowse);
		
		JLabel lblOutputPath = new JLabel("Output path:");
		lblOutputPath.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOutputPath.setBounds(200, 250, 98, 16);
		frame.getContentPane().add(lblOutputPath);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(310, 251, 272, 22);
		frame.getContentPane().add(textField_1);
		
		JButton button = new JButton("Browse");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(600, 250, 97, 25);
		frame.getContentPane().add(button);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConvert.setBounds(400, 365, 97, 25);
		frame.getContentPane().add(btnConvert);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(200, 474, 497, 25);
		frame.getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/earth-globe.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(6, 13, 186, 211);
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
	}
}
