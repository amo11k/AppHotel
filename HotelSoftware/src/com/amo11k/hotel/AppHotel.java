package com.amo11k.hotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Toolkit;

public class AppHotel extends JFrame {

	private JPanel pane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		 * Habitacion hab = new Habitacion(); hab.printRooms();
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					AppHotel frame = new AppHotel();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppHotel() {
		Reserva r = new Reserva();
		Hotel h = new Hotel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AppHotel.class.getResource("/com/amo11k/hotel/img/27938.png")));
		setForeground(Color.RED);
		setTitle("Amo11k Hotel");
		setFont(new Font("Bebas", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		pane = new JPanel();
		pane.setBackground(new Color(205, 133, 63));
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		pane.setLayout(null);

		JButton btnReservar = new JButton("RESERVAR");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reserva r = new Reserva();
				r.setVisible(true);
				r.setLocationRelativeTo(null);
			}
		});
		btnReservar.setBounds(10, 430, 150, 80);
		pane.add(btnReservar);

		JButton btnVisor = new JButton("VISUALIZAR");
		btnVisor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Visualizador visu = new Visualizador();
				visu.setVisible(true);
				visu.setLocationRelativeTo(null);
			}
		});
		btnVisor.setBounds(624, 430, 150, 80);
		pane.add(btnVisor);

		JButton cat = new JButton("Ver CAT\u00C1LOGO");
		cat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Catalogo cat = new Catalogo();
				cat.setVisible(true);
				cat.setLocationRelativeTo(null);
			}
		});
		cat.setToolTipText("Pulsa aqui para ver nuestro catalogo de habitaciones");
		cat.setForeground(new Color(0, 0, 0));
		cat.setBackground(new Color(144, 238, 144));
		cat.setBounds(327, 493, 150, 56);
		pane.add(cat);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 240, 245));
		menuBar.setBounds(0, 0, 786, 21);
		pane.add(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setForeground(new Color(0, 0, 0));
		menuBar.add(mnArchivo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnArchivo.add(mntmSalir);

		JMenu mnAbout = new JMenu("About");
		mnAbout.setForeground(new Color(0, 0, 0));
		menuBar.add(mnAbout);

		JMenuItem mntmAmokHotel = new JMenuItem("Amo11k Hotel");
		mnAbout.add(mntmAmokHotel);

		JLabel ttlPane = new JLabel("Hotel SHHH");
		ttlPane.setIcon(new ImageIcon(
				AppHotel.class
						.getResource("/com/amo11k/hotel/img/16-hotel-las-palmas-sercotel-cristina-las-palmas-habitacion.jpg")));
		ttlPane.setFont(new Font("Andalus", Font.ITALIC, 18));
		ttlPane.setHorizontalAlignment(SwingConstants.CENTER);
		ttlPane.setBounds(0, -36, 854, 633);
		pane.add(ttlPane);
	}
}
