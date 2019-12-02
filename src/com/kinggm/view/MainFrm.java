package com.kinggm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
* ×÷Õß: kinggm  E-mail:82674246@qq.com
* Ê±¼ä: 2019Äê6ÔÂ5ÈÕ ÏÂÎç10:38:31
* 
*/
public class MainFrm extends JFrame {

	JDesktopPane table=null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrm() {
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 900);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u57FA\u672C\u6570\u636E\u7EF4\u62A4");
		menu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/base.png")));
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		menu_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookTypeManager.png")));
		menu.add(menu_2);
		
		JMenuItem menuItem = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		
		
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookTypeAddInterFrm bookTypeAddInterFrm=new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);
				table.add(bookTypeAddInterFrm);
				
				
				
			}
		});
		
		
		
		menuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_2.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u56FE\u4E66\u7C7B\u522B\u7EF4\u62A4");
		
		
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInterFrm bookTypeManageInterFrm=new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);
				table.add(bookTypeManageInterFrm);
				
				
			}
		});
		
		
		menuItem_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menuItem_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_2.add(menuItem_1);
		
		JMenu menu_3 = new JMenu("\u56FE\u4E66\u7BA1\u7406");
		menu_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menu_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/bookManager.png")));
		menu.add(menu_3);
		
		JMenuItem menuItem_2 = new JMenuItem("\u56FE\u4E66\u6DFB\u52A0");
		
		
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);
				table.add(bookAddInterFrm);
				
				
			}
		});
		
		
		
		menuItem_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/add.png")));
		menu_3.add(menuItem_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u56FE\u4E66\u7EF4\u62A4");
		
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				BookManageInterFrm bookManageInterFrm=new BookManageInterFrm();
				bookManageInterFrm.setVisible(true);
				table.add(bookManageInterFrm);
			}
		});
		
		
		mntmNewMenuItem_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/edit.png")));
		menu_3.add(mntmNewMenuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5B89\u5168\u9000\u51FA");
		menuItem_3.addActionListener(new ActionListener() {

			//°²È«ÍË³ö
			public void actionPerformed(ActionEvent e) {
				
			int result=JOptionPane.showConfirmDialog(null, "ÊÇ·ñÍË³öÏµÍ³");
			if(result==0) {
				
				dispose();
			}	
			
			}
			
			
		});
		menuItem_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menuItem_3.setIcon(new ImageIcon(MainFrm.class.getResource("/images/exit.png")));
		menu.add(menuItem_3);
		
		JMenu menu_1 = new JMenu("\u5173\u4E8E\u6211\u4EEC");
		menu_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		menu_1.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menuBar.add(menu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E86\u89E3kinggm");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KinggmInterFrm kinggmInterFrm=new KinggmInterFrm();
				kinggmInterFrm.setVisible(true);
				table.add(kinggmInterFrm);
				
			}
		});
		mntmNewMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about.png")));
		menu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		
		//ÉèÖÃ´°Ìå¾ÓÖÐÏÔÊ¾
		this.setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		
		table = new JDesktopPane();
		table.setBackground(new Color(80, 144, 255));
		contentPane.add(table, BorderLayout.CENTER);
		GroupLayout gl_table = new GroupLayout(table);
		gl_table.setHorizontalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1182, Short.MAX_VALUE)
		);
		gl_table.setVerticalGroup(
			gl_table.createParallelGroup(Alignment.LEADING)
				.addGap(0, 727, Short.MAX_VALUE)
		);
		table.setLayout(gl_table);
		
		
		//ÉèÖÃ´°¿Ú×î´ó»¯
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}

