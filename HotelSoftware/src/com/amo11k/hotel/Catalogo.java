package com.amo11k.hotel;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class Catalogo extends JFrame {
	private JLabel foto;
	private JPanel contentPane;
	private Timer timer;
	private int proba;
	private final int Y=600;
	private JTextPane texto;

	/**
	 * @author amo11k
	 * Constructor de la clase Catalogo.
	 */
	public Catalogo() {
		setResizable(false);
		setTitle("Catálogo de Tarifas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Catalogo.class.getResource("/com/amo11k/hotel/img/27938.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		texto = new JTextPane();
		texto.setForeground(new Color(210, 105, 30));
		texto.setBackground(new Color(240, 240, 240));
		texto.setEditable(false);
		texto.setFont(new Font("Caviar Dreams", Font.BOLD | Font.ITALIC, 24));
		texto.setText("Habitaci\u00F3n Standart: 5.15\u20AC/h\r\nHabitaci\u00F3n Lujo: 10.30\u20AC/h\r\nHabitaci\u00F3n LujoShh: 15.45\u20AC/h");
		texto.setBounds(337, 11, 414, 100);
		contentPane.add(texto);
		
		foto = new JLabel("FOTO");
		foto.setIcon(new ImageIcon(Catalogo.class.getResource("/com/amo11k/hotel/img/caesars_palace_lasvegas_hotel_53331-800x600.jpg")));
		foto.setFont(new Font("Tahoma", Font.PLAIN, 64));
		foto.setHorizontalAlignment(SwingConstants.CENTER);
		foto.setBounds(10, 11, 808, 549);
		contentPane.add(foto);
		
		init();
		
		
	}
	/**
	 * A method with a timer that autoclose the frame when message disappear.
	 * 
	 */
	public void init(){
		timer = new Timer(20, new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				int posY = texto.getLocation().y;
				int posX = texto.getLocation().x;
				texto.setLocation(posX, posY+1);
				if (posY>600){
					
					timer.stop();
					dispose();
				}
				
			}
			
		});
		timer.start();
	}
}
