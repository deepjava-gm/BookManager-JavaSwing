package com.kinggm.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import com.kinggm.dao.BookTypeDao;
import com.kinggm.model.BookType;
import com.kinggm.util.DbUtil;
import com.kinggm.util.StringUtil;
import javax.swing.border.BevelBorder;
import java.awt.Color;

/**
* 作者: kinggm  E-mail:82674246@qq.com
* 时间: 2019年6月5日 下午5:14:55
* 
*/
public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt = new JTextArea();
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u56FE\u4E66\u7C7B\u522B\u6DFB\u52A0");
		setBounds(100, 100, 619, 466);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0:");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		
		JButton button = new JButton(" \u6DFB\u52A0");
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddActionPerformed(e);
				
			}
		});
		
		
		button.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add.png")));
		button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		
		JButton button_1 = new JButton(" \u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 resetValueActionPerformed(e); 
				
				
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset.png")));
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
							.addGap(180))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(260)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addGap(66)
							.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)))
					.addGap(57))
		);
		bookTypeDescTxt.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookTypeNameTxt)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
					.addGap(29))
		);
		getContentPane().setLayout(groupLayout);
		
		//设置文本域边框
		bookTypeDescTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		

	}

	
	//图书类别添加事件处理
	private void bookTypeAddActionPerformed(ActionEvent e) {
	  String bookTypeName=	this.bookTypeNameTxt.getText();
	  String bookTypeDesc=	this.bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypeName)) {
			
			JOptionPane.showMessageDialog(null,"图书类别不能为空");
			return;
		}
		BookType bookType=new BookType(bookTypeName,bookTypeDesc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int n=bookTypeDao.add(con, bookType);
			if(n==1) {
				JOptionPane.showMessageDialog(null, "图书类别添加成功!");
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "图书类别添加失败,请重试!");
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		finally {
			
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		
		}
		
	  
	}

	//实现重置按钮事件
	private void resetValueActionPerformed(ActionEvent e) {
		this.resetValue();   
		
	}

	//重置表单
	private void resetValue() {
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
		
	}
	
	
	
	
}

