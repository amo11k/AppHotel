package com.amo11k.hotel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Font;

public class Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField textField;
	private DecimalFormat formatPrice = new DecimalFormat("#.##");

	/**
	 * Create the dialog.
	 */
	public Dialog() {
		setFont(new Font("Dialog", Font.PLAIN, 10));
		setTitle("Reserva confirmada");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dialog.class.getResource("/com/amo11k/hotel/img/27938.png")));
		setBounds(100, 100, 200, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblReservaConfirmada = new JLabel("Reserva Confirmada");
			contentPanel.add(lblReservaConfirmada);
		}
		{
			textField = new JTextField();
			textField.setHorizontalAlignment(SwingConstants.CENTER);
			textField.setEditable(false);
			contentPanel.add(textField);
			textField.setColumns(10);
			textField.setText(formatPrice.format(Reserva.precio)+"€/h");
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
