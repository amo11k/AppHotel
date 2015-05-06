package com.amo11k.hotel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class Reserva extends JFrame {

	private JPanel pane;
	protected JComboBox comboBox;
	protected JDateChooser dateChooser;
	protected FileWriter out;
	protected static File hist = new File("Historial Reservas");
	protected BufferedReader in;
	public java.util.Date date;
	public Date hoy;
	public JSpinField spinInit;
	private JSpinField spinFin;
	public int c;
	public final int HORAS_DIA = 24;
	public static double precio;
	public final double TARIFA = 5.15;
	DecimalFormat formatPrice = new DecimalFormat("#.##");
	private final static int NUM_ROOMS = 40;
	public static Hotel hotel;
	private Room room;
	private JCheckBox fumadorCheck;

	/**
	 * Create the frame.
	 */
	public Reserva() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Reserva.class.getResource("/com/amo11k/hotel/img/27938.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Realizar reserva");
		setBounds(100, 100, 450, 406);
		pane = new JPanel();
		pane.setBackground(new Color(233, 150, 122));
		pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pane);
		pane.setLayout(null);

		JLabel ttlReserva = new JLabel("REALIZE SU RESERVA");
		ttlReserva.setFont(new Font("Andalus", Font.PLAIN, 18));
		ttlReserva.setHorizontalAlignment(SwingConstants.CENTER);
		ttlReserva.setBounds(125, 12, 203, 38);
		pane.add(ttlReserva);

		comboBox = new JComboBox();
		comboBox.setToolTipText("Elija tipo");
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Standar",
				"Lujo", "LujoShh" }));
		comboBox.setBounds(269, 74, 121, 25);
		pane.add(comboBox);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(269, 105, 121, 25);
		pane.add(dateChooser);

		JLabel lblHabt = new JLabel("Tipo de habitación:");
		lblHabt.setBounds(39, 79, 183, 14);
		pane.add(lblHabt);

		JLabel lblFecha = new JLabel("Fecha de reserva:");
		lblFecha.setBounds(39, 116, 138, 14);
		pane.add(lblFecha);

		JButton btnConfirm = new JButton("CONFIRMAR");
		btnConfirm.setFont(new Font("Dialog", Font.BOLD, 10));
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					room = asignarRoom(AppHotel.hotel);
					precio = getPrice();
					rent(room, precio);
					dispose();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					System.out.println(hist);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfirm.setBounds(39, 325, 107, 23);
		pane.add(btnConfirm);

		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(283, 324, 107, 23);
		pane.add(btnCancel);

		JLabel horaInit = new JLabel("Hora de reserva:");
		horaInit.setToolTipText("Escoga la hora de inicio de su reserva");
		horaInit.setBounds(41, 156, 136, 15);
		pane.add(horaInit);

		spinInit = new JSpinField();
		spinInit.setBounds(331, 152, 59, 19);
		spinInit.setMinimum(0);
		spinInit.setMaximum(24);
		pane.add(spinInit);

		spinFin = new JSpinField();
		spinFin.setBounds(331, 183, 59, 19);
		spinFin.setMinimum(0);
		spinFin.setMaximum(24);
		pane.add(spinFin);

		JLabel horaFIn = new JLabel("Hora de fin:");
		horaFIn.setBounds(39, 187, 138, 15);
		pane.add(horaFIn);

		fumadorCheck = new JCheckBox("Fumador");
		fumadorCheck.setBackground(new Color(255, 153, 102));
		fumadorCheck.setBounds(261, 232, 129, 23);
		pane.add(fumadorCheck);
	}

	public void rent(Room room, double precio) throws IOException {
		Date hoy = new Date();
		date = dateChooser.getDate();
		if (date.before(hoy)) {
			JOptionPane.showMessageDialog(null,
					"La fecha introducida no es correcta");
		} else {
			write(room, precio);
			Dialog confim = new Dialog();
			confim.setVisible(true);
			confim.setLocationRelativeTo(null);
		}
	}

	private Room asignarRoom(Hotel h) {
		Room r = null;
		Room asig = null;
		boolean done=false;
		int type = comboBox.getSelectedIndex();
		boolean fuma = fumadorCheck.isSelected();
		while (asig == null) {
			for (int i = 0; i < NUM_ROOMS; i++) {
				r = Hotel.getRoomAt(i);
				if ((r.getTypeInt() == type) && (r.getDisponible() == true)
						&& (r.getSmokeBoolean() == fuma) && (!done)) {
					asig = r;
					asig.setDisponible(false);
					done=true;
				}
			}
		}
		if (asig == null)
			JOptionPane.showMessageDialog(null,
					"No quedan habitaciones libres con estos criterios");

		return asig;
	}

	public void write(Room r, double precio) {
		try {
			out = new FileWriter(hist, true);

			out.write(r.toString() + ";");
			out.write(date.toString() + ";");
			out.write("Hora de inicio " + spinInit.getValue() + ":00;");
			out.write("Hora fin " + spinFin.getValue() + ":00;");
			out.write("Precio " + formatPrice.format(precio) + "€;");
			out.write("\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR ARCHIVO");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public double getPrice() {
		c = comboBox.getSelectedIndex();
		int indice;
		if (spinInit.getValue() > spinFin.getValue()) {
			indice = HORAS_DIA - (spinInit.getValue() - spinFin.getValue());
			precio = indice * TARIFA * (c + 1);
		} else {
			precio = (spinFin.getValue() - spinInit.getValue()) * TARIFA
					* (c + 1);
		}
		return precio;
	}
}
