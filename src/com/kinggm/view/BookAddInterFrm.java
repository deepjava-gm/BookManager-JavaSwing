package com.kinggm.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

import com.kinggm.dao.BookDao;
import com.kinggm.dao.BookTypeDao;
import com.kinggm.model.Book;
import com.kinggm.model.BookType;
import com.kinggm.util.DbUtil;
import com.kinggm.util.StringUtil;

/**
 * 图书添加界面
* 作者: kinggm  E-mail:82674246@qq.com
* 时间: 2019年6月12日 下午5:23:28
* 
*/
public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JComboBox bookTypeJcb;
	private JTextArea bookDescTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private BookDao bookDao=new BookDao();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private JRadioButton manJrb;
	private JRadioButton femaleJrb;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
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
	public BookAddInterFrm() {
		setFont(new Font("微软雅黑", Font.PLAIN, 15));
		getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 15));
		setIconifiable(true);
		setClosable(true);
		setTitle("\u56FE\u4E66\u6DFB\u52A0");
		setBounds(100, 100, 550, 600);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u4F5C\u8005\u6027\u522B:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		 manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setSelected(true);
		
		 femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u4EF7\u683C:");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("\u56FE\u4E66\u63CF\u8FF0:");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JButton button = new JButton("\u6DFB\u52A0");
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
				
				
			}
		});
		
		
		button.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add.png")));
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
				
			}
		});
		
		
		button_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset.png")));
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JLabel label_4 = new JLabel("\u56FE\u4E66\u7C7B\u522B:");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		 bookTypeJcb = new JComboBox();
		 bookTypeJcb.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		 bookDescTxt = new JTextArea();
		 bookDescTxt.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblNewLabel)
									.addComponent(label))
								.addComponent(label_4, Alignment.TRAILING)
								.addComponent(label_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(manJrb)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(femaleJrb)
											.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
											.addComponent(label_2))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(bookTypeJcb, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(bookNameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
											.addComponent(label_1)))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(priceTxt)
										.addComponent(authorTxt, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
								.addComponent(bookDescTxt, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(312)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(manJrb)
						.addComponent(femaleJrb)
						.addComponent(label_2)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(bookDescTxt, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
							.addGap(114))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(247)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(button_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
							.addContainerGap(57, Short.MAX_VALUE))))
		);
		getContentPane().setLayout(groupLayout);

		//调用初始化图书类别下拉框
		fillBookType();
		
		
		//设置文本域边框
		bookDescTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		
	}
	
	//重置事件处理
	private void resetValueActionPerformed(ActionEvent e) {
		resetValue();
		
	}

	//图书添加事件处理
	protected void bookAddActionPerformed(ActionEvent e) {
	
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
	
		if (StringUtil.isEmpty(bookName)) {

			JOptionPane.showMessageDialog(null, "图书名不能为空");
			return;
		}
		
		if (StringUtil.isEmpty(author)) {

			JOptionPane.showMessageDialog(null, "图书作者名不能为空");
			return;
		}
		
		if (StringUtil.isEmpty(price)) {

			JOptionPane.showMessageDialog(null, "图书价格不能为空");
			return;
		}
		
		
		
		String sex="";
		if(manJrb.isSelected()) {
			sex="男";
		}else if(femaleJrb.isSelected()) {
			sex="女";

		}
		
		BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(bookName,  author,  sex, Float.parseFloat(price) ,  bookTypeId,  bookDesc);
		
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
		int addNum=bookDao.add(con, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "图书添加成功");
			
				resetValue();
			}else {
				JOptionPane.showMessageDialog(null, "图书添加失败请重试");
				
				
			}
					
			
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败请重试");
			
			
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			
			
		}
		
		
		
	}
	
	
	
	
//重置表单
	private void resetValue() {
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.manJrb.setSelected(true);
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0) {
			this.bookTypeJcb.setSelectedIndex(0);
			
		}
		
	}

	//初始化图书类别下拉框
	private void fillBookType() {
		Connection con=null;
		BookType bookType=null;
		
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			while (rs.next()) {
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}

