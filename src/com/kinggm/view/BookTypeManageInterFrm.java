package com.kinggm.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.kinggm.dao.BookDao;
import com.kinggm.dao.BookTypeDao;
import com.kinggm.model.BookType;
import com.kinggm.util.DbUtil;
import com.kinggm.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;

/**
* 作者: kinggm  E-mail:82674246@qq.com
* 时间: 2019年6月10日 下午10:08:02
* 
*/
public class BookTypeManageInterFrm extends JInternalFrame {
	private JTable bookTypeTable;

	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private JTextField s_bookTypeNameTxt;
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTextArea  bookTypeDescTxt;
	private BookDao bookDao=new BookDao();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
	public BookTypeManageInterFrm() {
		getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 15));
		setTitle("\u56FE\u4E66\u7C7B\u522B\u7BA1\u7406");
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 602, 629);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e); 
				
				
			}
		});
		

		//设置密码框监听Enter键 
		s_bookTypeNameTxt.addKeyListener(new KeyListener() {
			
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
						
						
					// Enter键
						bookTypeSearchActionPerformed(e);
						
					} catch (Exception e2) {
					e2.printStackTrace();
						
					}
					
					
				}

				
			}
		});
		
		
		
		button.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/search.png")));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_bookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
							.addGap(44)
							.addComponent(button, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane))
					.addGap(66))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(label, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(s_bookTypeNameTxt)
								.addComponent(button, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
					.addGap(29))
		);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7:");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setHorizontalAlignment(SwingConstants.CENTER);
		idTxt.setBackground(Color.WHITE);
		idTxt.setForeground(Color.BLACK);
		idTxt.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		idTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u7C7B\u522B\u540D\u79F0:");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("\u63CF\u8FF0:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		 bookTypeDescTxt = new JTextArea();
		bookTypeDescTxt.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
				
			}
		});
		
		
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_1.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/modify.png")));
		
		JButton button_2 = new JButton("\u5220\u9664");
		
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionEvent(e);
				
				
			}
		});
		
		
		
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_2.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/delete.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(10)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeNameTxt, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addGap(0)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(157)
									.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
									.addGap(28)
									.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
								.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE))))
					.addGap(23))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 21, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(button_2, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addComponent(button_1, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(30))
		);
		panel.setLayout(gl_panel);
		
		
		//设置文本域边框
				bookTypeDescTxt.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, null, null, null));
			
				idTxt.setBorder(new LineBorder(new java.awt.Color(127, 157, 185),1,false));
				
		
		bookTypeTable = new JTable();
		
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			int row=bookTypeTable.getSelectedRow();
			idTxt.setText((String)bookTypeTable.getValueAt(row, 0));	
			bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row, 1));	
			bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row, 2)); 
			
			
			
			}
		});
		
		
		
		
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(156);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(231);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);

		
		this.fillTable(new BookType());
	}

	//表单删除操作
	private void bookTypeDeleteActionEvent(ActionEvent e) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null,"请选择要删除的记录");
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确定要删除该条记录吗?");
		if(n==0) {
		Connection con=null;
		
		
		try {
			con=dbUtil.getCon();
		boolean flag=	bookDao.existBookTypeId(con, id); 
			if(flag) {
				JOptionPane.showMessageDialog(null, "当前图书类别下有图书，不能删除此图书类别");
				return;
			}
			 
			int deleteNum=bookTypeDao.delete(con, id);
			if(deleteNum==1) {
				JOptionPane.showMessageDialog(null, "删除成功");
				this.resetValue();
				this.fillTable(new BookType());
			}else {
				JOptionPane.showMessageDialog(null, "删除失败");
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败");
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		
		
		}
		
		
		
	}


	
	
	//表单更新操作
	private void bookTypeUpdateActionEvent(ActionEvent e) {
	String id=idTxt.getText();
	String bookTypeName=bookTypeNameTxt.getText();
	String bookTypeDesc=bookTypeDescTxt.getText();
	if(StringUtil.isEmpty(id)) {
		JOptionPane.showMessageDialog(null,"请在表格中选择要修改的记录");
		return;
	}
	
	if(StringUtil.isEmpty(bookTypeName)) {
		JOptionPane.showMessageDialog(null,"图书类别名称不能为空");
		return;
	}
	
	BookType bookType=new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);	 
	Connection con=null;
	
	try {
		con=dbUtil.getCon();
	int modifyNum=bookTypeDao.update(con, bookType);
	if(modifyNum==1) {
		JOptionPane.showMessageDialog(null,"修改成功");
		this.resetValue();
		this. fillTable(new BookType());
	}else {
		JOptionPane.showMessageDialog(null,"修改失败");
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

	//图书类别查询事件处理
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
	 String s_bookTypeName =this.s_bookTypeNameTxt.getText();
	BookType bookType=new BookType();
	bookType.setBookTypeName(s_bookTypeName);
	this.fillTable(bookType);
		
		
		
	}

	//图书类别查询事件处理 Enter键
		private void bookTypeSearchActionPerformed(KeyEvent evt) {
		 String s_bookTypeName =this.s_bookTypeNameTxt.getText();
		BookType bookType=new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.fillTable(bookType);
			
			
			
		}

	
	
	//初始化表格
	private void fillTable(BookType bookType) {
		DefaultTableModel dtm=(DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0);//设置成0行
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con,bookType);
			while(rs.next()) {
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
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
	
	//重置表单
	private void resetValue(){
		this. idTxt. setText(""); 
		this. bookTypeNameTxt. setText("");
		this. bookTypeDescTxt. setText("");
	}
	
}

