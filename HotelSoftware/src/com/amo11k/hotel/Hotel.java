package com.amo11k.hotel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Hotel extends Room implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4788212720797370761L;
	protected final static int NUM_ROOMS = 40;
	private int count = 1;
	private Room[] listRoom = new Room[NUM_ROOMS];
	
	//public static Hotel hotel;


	public Hotel() {
		for (int i = 0; i < NUM_ROOMS; i++) {
			int random = (int) (Math.random() * 3);
			listRoom[i] = (new Room(count, random));
			count++;
		}
	}

	public Room getRoomAt(int numRoom) {
		Room r = listRoom[numRoom];
		return r;

	}

	public boolean getDisponible(int numRoom) {
		return listRoom[numRoom].getDisponible();
	}
	
}