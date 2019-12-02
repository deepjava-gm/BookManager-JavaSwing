package com.kinggm.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.kinggm.dao.UserDao;
import com.kinggm.model.User;
import com.kinggm.util.DbUtil;
import com.kinggm.util.StringUtil;

public class LogOnFrm extends JFrame {

	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
		setFont(new Font("微软雅黑", Font.PLAIN, 15));
		setResizable(false);
		setTitle("\u7BA1\u7406\u5458\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("   \u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/logo.png")));
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/userName.png")));
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/password.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		passwordTxt.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		
		//设置密码框监听Enter键 
		passwordTxt.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				int KeyCode = e.getKeyCode();
				if (KeyCode == 10) {
					
					try {
						
						
					//登录 Enter键
				   loginActionPerformed(e);
						
					} catch (Exception e2) {
					e2.printStackTrace();
						
					}
					
					
				}

				
			}
		});
		

		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//登录
				loginActionPerformed(e);
				

				
			}
		});
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/login.png")));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
				
				
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/reset.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(86)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(12)
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
								.addComponent(lblNewLabel, Alignment.TRAILING))
							.addGap(87))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(96)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(78, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
							.addGap(6))
						.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(39))
		);
		contentPane.setLayout(gl_contentPane);
		
		//设置窗体居中显示
		this.setLocationRelativeTo(null);
		
	}

	
	
	/*
	 * 登录事件处理
	 * */
	private void loginActionPerformed(ActionEvent evt) {
		String userName=this.userNameTxt.getText();
		String password=new String(passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName) ){
			JOptionPane.showMessageDialog(null,"用户名不能为空！");
			return;
			
		}
		
		if(StringUtil.isEmpty(password) ){
			JOptionPane.showMessageDialog(null,"密码不能为空！");
			return;
			
		}
		
		User user=new User(userName, password);
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			User currentUser=  userDao.login(con, user);
			if(currentUser!=null) {
				dispose();
				new MainFrm().setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null,"用户名或者密码错误！");
				return;
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	/*
	 * 登录事件处理 Enter键
	 * */
	private void loginActionPerformed(KeyEvent evt) {
		String userName=this.userNameTxt.getText();
		String password=new String(passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName) ){
			JOptionPane.showMessageDialog(null,"用户名不能为空！");
			return;
			
		}
		
		if(StringUtil.isEmpty(password) ){
			JOptionPane.showMessageDialog(null,"密码不能为空！");
			return;
			
		}
		
		User user=new User(userName, password);
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			User currentUser=  userDao.login(con, user); 
			if(currentUser!=null) {
				dispose();
				new MainFrm().setVisible(true);
				
			}else {
				JOptionPane.showMessageDialog(null,"用户名或者密码错误！");
				return;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	
	
	

	/*
	 * 重置事件处理
	 * */
	private void resetValueActionPerformed(ActionEvent evt) {

		this.userNameTxt.setText("");
		this.passwordTxt.setText("");

	}





	
	
	
}
