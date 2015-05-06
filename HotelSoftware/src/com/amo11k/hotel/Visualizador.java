package com.amo11k.hotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class Visualizador extends JFrame {

	private JPanel pane;
	private JTextArea txtVisu;
	public JButton btnLeer;
	private StringBuilder builder;

	/**
	 * Create the frame.
	 */
	public Visualizador() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Visualizador.class.getResource("/com/amo11k/hotel/img/27938.png")));
		setTitle("Historial de Reservas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		pane = new JPanel();
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		pane.setLayout(null);
		
		txtVisu = new JTextArea();
		txtVisu.setEditable(false);
		txtVisu.setBounds(29, 11, 284, 240);
		pane.add(txtVisu);
		
		btnLeer = new JButton("LEER");
		btnLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedReader in = null;
				try {
					in = new BufferedReader(new FileReader("Historial Reservas"));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				String s;
				builder = new StringBuilder();
				try {
					in = new BufferedReader(new FileReader("Historial Reservas"));
					while ((s = in.readLine()) != null) {
						builder.append(s + "\n");
					}
					txtVisu.setText(builder.toString());

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						in.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnLeer.setBounds(647, 27, 89, 23);
		pane.add(btnLeer);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(647, 90, 89, 23);
		pane.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane(txtVisu);
		scrollPane.setBounds(29, 11, 589, 482);
		pane.add(scrollPane);
		
		JButton btnVerHotel = new JButton("Ver Hotel");
		btnVerHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				 builder = new StringBuilder();
				 for (int i = 0; i<Hotel.NUM_ROOMS;i++){
					 builder.append(AppHotel.hotel.getRoomAt(i).toString()+"\n");
				 }
				 txtVisu.setText(builder.toString());
			}
		});
		btnVerHotel.setBounds(630, 456, 106, 23);
		pane.add(btnVerHotel);
	}
}
