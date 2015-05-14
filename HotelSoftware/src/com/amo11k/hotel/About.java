package com.amo11k.hotel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
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
	public About() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAuthoramok = new JLabel("Author: @amo11k");
		lblAuthoramok.setBounds(152, 12, 133, 36);
		contentPane.add(lblAuthoramok);
		
		JLabel lblApphotelV = new JLabel("AppHotel v1.0");
		lblApphotelV.setBounds(163, 79, 108, 36);
		contentPane.add(lblApphotelV);
		
		JButton btnBuyIt = new JButton("BUY IT");
		btnBuyIt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnBuyIt.setBounds(12, 227, 117, 25);
		contentPane.add(btnBuyIt);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(313, 227, 117, 25);
		contentPane.add(btnExit);
	}
}
