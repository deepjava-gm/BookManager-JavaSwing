package com.kinggm.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kinggm.dao.BookDao;
import com.kinggm.dao.BookTypeDao;
import com.kinggm.model.Book;
import com.kinggm.model.BookType;
import com.kinggm.util.DbUtil;
import com.kinggm.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
* ×÷Õß: kinggm  E-mail:82674246@qq.com
* Ê±¼ä: 2019Äê6ÔÂ12ÈÕ ÏÂÎç9:07:29
* 
*/
public class BookManageInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
    private JComboBox s_bookTypeJcb ;
    private JRadioButton manJrb;
    private JRadioButton femaleJrb;
    private JTextArea bookDescTxt;
    private JComboBox bookTypeJcb ;
	private DbUtil dbUtil=new DbUtil();
	private BookDao bookDao=new BookDao(); 
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private JTextField priceTxt;
	private JTextField authorTxt;
	
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public BookManageInterFrm() {
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		setIconifiable(true);
		setClosable(true);
		setRootPaneCheckingEnabled(false);
		setTitle("\u56FE\u4E66\u7BA1\u7406");
		setBounds(100, 100, 663, 702);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		panel_1.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 619, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel label_3 = new JLabel("\u7F16\u53F7:");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		idTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		bookNameTxt = new JTextField();
		bookNameTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		bookNameTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("\u4F5C\u8005\u6027\u522B:");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		 manJrb = new JRadioButton("\u7537");
		buttonGroup.add(manJrb);
		manJrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		 femaleJrb = new JRadioButton("\u5973");
		buttonGroup.add(femaleJrb);
		femaleJrb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JLabel label_5 = new JLabel("\u4EF7\u683C:");
		label_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		priceTxt = new JTextField();
		priceTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		priceTxt.setColumns(10);
		
		JLabel label_6 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
		label_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		authorTxt = new JTextField();
		authorTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		authorTxt.setColumns(10);
		
		JLabel label_7 = new JLabel("\u56FE\u4E66\u7C7B\u522B:");
		label_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JLabel label_8 = new JLabel("\u56FE\u4E66\u63CF\u8FF0:");
		label_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		 bookDescTxt = new JTextArea();
		bookDescTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
		bookDescTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateActionPerformed(e);
				
			}
		});
		
		
		button_1.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/modify.png")));
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JButton button_2 = new JButton("\u5220\u9664");
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookDeleteActionPerformed(e);
				
			}
		});
		
		
		button_2.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/delete.png")));
		button_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		 bookTypeJcb = new JComboBox();
		bookTypeJcb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(priceTxt, 0, 0, Short.MAX_VALUE)))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(label_6))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(bookNameTxt, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
								.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_4)
									.addGap(18)
									.addComponent(manJrb)
									.addGap(18)
									.addComponent(femaleJrb))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
							.addGap(13))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_8)
							.addGap(3)
							.addComponent(bookDescTxt, GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(button_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_2)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(label_4)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(manJrb)
						.addComponent(femaleJrb))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(label_6)
						.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0:");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		s_bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u4F5C\u8005:");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		s_authorTxt = new JTextField();
		s_authorTxt.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		s_authorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u7C7B\u522B:");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		s_bookTypeJcb = new JComboBox();
		s_bookTypeJcb.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		
		JButton button = new JButton("\u67E5\u8BE2");
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
				
				
				
			}
		});
		
		
		button.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/search.png")));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		
		
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
				
			}
		});
		
		
		bookTable.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u6027\u522B", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);

		 this.fillBookType("search"); 
		 this.fillBookType("modify");
		 fillTable(new Book());
	}
	
	//Í¼ÊéÉ¾³ýÊÂ¼þ´¦Àí
	private void bookDeleteActionPerformed(ActionEvent e) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"ÇëÑ¡ÔñÒªÉ¾³ýµÄ¼ÇÂ¼");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "È·¶¨ÒªÉ¾³ý¸ÃÌõ¼ÇÂ¼Âð?");
		if(n==0) {
		Connection con=null;
		try {
			con=dbUtil.getCon();
			
			int deleteNum=bookDao.delete(con, id);
			if(deleteNum==1) {
				JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦");
				this.resetValue();
				this.fillTable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü");
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
		
		}
		
		
		
	}

	//Í¼ÊéÐÞ¸ÄÊÂ¼þ´¦Àí
	private void bookUpdateActionPerformed(ActionEvent e) {
		String id=this.idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "ÇëÑ¡ÔñÒªÐÞ¸ÄµÄ¼ÇÂ¼");
			return;
		}
		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		if (StringUtil.isEmpty(bookName)) {

			JOptionPane.showMessageDialog(null, "Í¼ÊéÃû²»ÄÜÎª¿Õ");
			return;
		}
		
		if (StringUtil.isEmpty(author)) {

			JOptionPane.showMessageDialog(null, "Í¼Êé×÷ÕßÃû²»ÄÜÎª¿Õ");
			return;
		}
		
		if (StringUtil.isEmpty(price)) {

			JOptionPane.showMessageDialog(null, "Í¼Êé¼Û¸ñ²»ÄÜÎª¿Õ");
			return;
		}
		
		String sex="";
		if(manJrb.isSelected()) {
			sex="ÄÐ";
		}else if(femaleJrb.isSelected()) {
			sex="Å®";

		}
		BookType bookType=(BookType) bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(Integer.parseInt(id) ,  bookName,  author,  sex, Float.parseFloat(price) , bookTypeId ,  bookDesc);
		
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
		int addNum=bookDao.update(con, book);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "Í¼ÊéÐÞ¸Ä³É¹¦");
			
				resetValue();
				this.fillTable(new Book());
			}else {
				JOptionPane.showMessageDialog(null, "Í¼ÊéÐÞ¸ÄÊ§°ÜÇëÖØÊÔ");
				
				
			}
					
			
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Í¼ÊéÐÞ¸ÄÊ§°ÜÇëÖØÊÔ");
			
			
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
			
			
		}
		
		
		
		
		
	}

	//±í¸ñÐÐµã»÷ÊÂ¼þ´¦Àí
	
	private void bookTableMousePressed(MouseEvent e) {
		int row=this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		String sex=(String)bookTable.getValueAt(row, 3);
		
		if("ÄÐ".equals(sex)) {
			this.manJrb.setSelected(true);
	
		}else {
			this.femaleJrb.setSelected(true);
		}
		
		this.priceTxt.setText((String)bookTable.getValueAt(row, 4)+"");
		this.bookDescTxt.setText((String)bookTable.getValueAt(row, 5));
		String bookTypeName=(String)this.bookTable.getValueAt(row, 6);
		int n=bookTypeJcb.getItemCount();
		for (int i = 0; i < n; i++) {
			BookType item=(BookType)this.bookTypeJcb.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)) {
				this.bookTypeJcb.setSelectedIndex(i);
				
			}
			
		}
	}

	//²éÑ¯ÊÂ¼þ´¦Àí
	private void bookSearchActionPerformed(ActionEvent e) {
		String bookName=this.s_bookNameTxt.getText();
		String author=this.s_authorTxt.getText();
		BookType bookType=(BookType)this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		Book book=new Book(bookName,author,bookTypeId);
		this.fillTable(book);
	}
	

	//³õÊ¼»¯ÏÂÀ­¿ò
	private void fillBookType(String type) {
		Connection con=null;
		BookType bookType=null;
		try {
			con=dbUtil.getCon();
		ResultSet rs=	bookTypeDao.list(con, new BookType());
		if("search".equals(type)) {
			bookType=new BookType();
			bookType.setBookTypeName("ÇëÑ¡Ôñ...");
			bookType.setId(-1);
			this.s_bookTypeJcb.addItem(bookType);
		}
		while(rs.next()) {
			bookType=new BookType();
			bookType.setBookTypeName(rs.getString("bookTypeName"));
			bookType.setId(rs.getInt("id"));
			if("search".equals(type)) {
				this.s_bookTypeJcb.addItem(bookType);
				
			}else if("modify".equals(type)){
				this.bookTypeJcb.addItem(bookType);
				
				
			}
			
			
			
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
	
	//³õÊ¼»¯±í¸ñ
		private void fillTable(Book book) {
			DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
			dtm.setRowCount(0);//ÉèÖÃ³É0ÐÐ
			Connection con=null;
			 
			try {
				con=dbUtil.getCon();
				ResultSet rs=bookDao.list(con,book);
				while(rs.next()) {
					Vector v=new Vector();
					v.add(rs.getString("id"));
					v.add(rs.getString("bookName"));
					v.add(rs.getString("author"));
					v.add(rs.getString("sex"));
					v.add(rs.getString("price"));
					v.add(rs.getString("bookDesc"));
					v.add(rs.getString("bookTypeName"));
					dtm.addRow(v);
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
		
		
		//ÖØÖÃ±íµ¥
			private void resetValue() {
				this.idTxt.setText("");
				this.bookNameTxt.setText("");
				this.authorTxt.setText("");
				this.priceTxt.setText("");
				this.manJrb.setSelected(true);
				this.bookDescTxt.setText("");
				if(this.bookTypeJcb.getItemCount()>0) {
					this.bookTypeJcb.setSelectedIndex(0);
					
				}
				
			}
		
		
		
}

