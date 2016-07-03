package com.ljheee.ftp.client;

import javax.swing.*;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.ljheee.ftp.MDUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * the UI of client
 * @author Administrator
 *
 */
public class ClientFrame extends JFrame{

	JLabel label_fileName,label_digest;
	JButton addFileButton;
	JFileChooser fileChooser = new JFileChooser();
	MyHandeler handel = new MyHandeler();
	private JButton upLoadButton;

	
	public ClientFrame(){
		this.setTitle("nFTP Client");
		this.setSize(480, 320);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addFileButton = new JButton("\u9009\u62E9\u4E0A\u4F20\u6587\u4EF6");
		addFileButton.addActionListener(handel);
		
		JLabel lblFilename = new JLabel("FileName  :  ");
		
		JLabel lblDi = new JLabel("Digest  :  ");
		
		label_fileName = new JLabel("");
		label_digest = new JLabel("");
		
		upLoadButton = new JButton("\u4E0A\u4F20\u6587\u4EF6");
		upLoadButton.addActionListener(handel);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(addFileButton)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFilename)
							.addGap(18)
							.addComponent(label_fileName))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDi)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_digest))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(upLoadButton)))
					.addContainerGap(359, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(addFileButton)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFilename)
						.addComponent(label_fileName))
					.addGap(39)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDi)
						.addComponent(label_digest))
					.addPreferredGap(ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
					.addComponent(upLoadButton)
					.addGap(26))
		);
		getContentPane().setLayout(groupLayout);
		
		
		
		
		
		this.setVisible(true);
	}
	class MyHandeler implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==addFileButton){
				fileChooser.showDialog(ClientFrame.this, "确定");
				//设置选择模式---既可以选择文件，也可选文件夹
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				label_fileName.setText(fileChooser.getSelectedFile().getName());
				label_digest.setText(MDUtil.getMD5(fileChooser.getSelectedFile()));
			}
			if(e.getSource()==upLoadButton){
				
			}
		}
		
		
	}
}
