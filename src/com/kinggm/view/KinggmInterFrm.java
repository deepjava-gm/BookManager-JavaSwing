package com.kinggm.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

/**
* 作者: kinggm  E-mail:82674246@qq.com
* 时间: 2019年6月5日 下午11:35:16
* 
*/
public class KinggmInterFrm extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KinggmInterFrm frame = new KinggmInterFrm();
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
	public KinggmInterFrm() {
		
		setClosable(true);
		getContentPane().setBackground(Color.CYAN);
		setIconifiable(true);
		setTitle("\u5173\u4E8EKinggm");
		setBounds(100, 100, 625, 409);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(KinggmInterFrm.class.getResource("/images/kinggm.png")));
		
		JLabel lblV = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF V1.0");
		lblV.setHorizontalAlignment(SwingConstants.CENTER);
		lblV.setForeground(Color.RED);
		lblV.setBackground(Color.RED);
		lblV.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		JLabel lblKinggm = new JLabel("Kinggm\u662F\u4F5C\u8005\u7684\u7B14\u540D");
		lblKinggm.setHorizontalAlignment(SwingConstants.CENTER);
		lblKinggm.setFont(new Font("微软雅黑", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(233)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblV)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(248))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(199)
					.addComponent(lblKinggm)
					.addContainerGap(215, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblV)
					.addGap(33)
					.addComponent(lblKinggm)
					.addGap(132))
		);
		
		
		getContentPane().setLayout(groupLayout);

		
		
		
	}
	
}

