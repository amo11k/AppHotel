package com.amo11k.hotel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AppHotel extends JFrame {

	private JPanel pane;
	static Hotel hotel;

	int count = 0;
	FileOutputStream fos;
	FileInputStream fis;
	ObjectOutputStream out;
	ObjectInputStream in;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

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
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public AppHotel() {
		/*if ("fichero.bin" != null) {
			try {
				hotel = readHotel();
			} catch (ClassNotFoundException | IOException e1) {
				JOptionPane.showMessageDialog(null, "Error al cargar");
			}
		}*/
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
				System.exit(1);

			}
		});

		JMenuItem mntmCrearHotel = new JMenuItem("Crear Hotel");
		mntmCrearHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hotel = new Hotel();
					writeHotel(hotel);
					JOptionPane.showMessageDialog(null, "Creado correctamente");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al crear Hotel");
				}
			}
		});
		mnArchivo.add(mntmCrearHotel);

		JMenuItem mntmCargarHotel = new JMenuItem("Cargar Hotel...");
		mntmCargarHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					hotel = readHotel();
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(null, "Error al cargar");
				}
			}
		});
		mnArchivo.add(mntmCargarHotel);

		JMenuItem mntmGuardarHotel = new JMenuItem("Guardar Hotel...");
		mntmGuardarHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					writeHotel(hotel);
					JOptionPane.showMessageDialog(null, "Hotel guardado correctamente");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error al guardar");
				}
			}
		});
		mnArchivo.add(mntmGuardarHotel);
		mnArchivo.add(mntmSalir);

		JMenu mnAbout = new JMenu("About");
		mnAbout.setForeground(new Color(0, 0, 0));
		menuBar.add(mnAbout);

		JMenuItem mntmAmokHotel = new JMenuItem("Amo11k Hotel");
		mntmAmokHotel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About a = new About();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
			}
		});
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

	protected void writeHotel(Hotel hotel) throws IOException {
		for (int i = 0; i < 40; i++) {

			System.out.println(hotel.getRoomAt(i));
		}
		fos = new FileOutputStream("hotel.bin");
		out = new ObjectOutputStream(fos);
		// Escribir el objeto en el fichero
		out.writeObject(hotel);
	}

	private Hotel readHotel() throws IOException, ClassNotFoundException {
		fis = new FileInputStream("hotel.bin");
		in = new ObjectInputStream(fis);
		// Leer el objeto en el fichero
		hotel=(Hotel) in.readObject();
		JOptionPane.showMessageDialog(null, "Hotel cargado correctamente");
		for (int i = 0; i < 40; i++) {

			System.out.println(hotel.getRoomAt(i));
		}
		return hotel;
	}
}
