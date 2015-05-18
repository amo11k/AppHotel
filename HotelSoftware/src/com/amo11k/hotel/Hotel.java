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
	 * 
	 */
	
	
	private static final long serialVersionUID = -4788212720797370761L;
	protected final static int NUM_ROOMS = 40;
	private int count = 1;
	private Room[] listRoom = new Room[NUM_ROOMS];

	/**
	 * Hotel class constructor. Don't need any argument.
	 */
	public Hotel() {
		for (int i = 0; i < NUM_ROOMS; i++) {
			int random = (int) (Math.random() * 3);
			listRoom[i] = (new Room(count, random));
			count++;
		}
	}
	
	/**
	 * That method returns the Room saved in the array.
	 * @param numRoom will be a integer corresponding with the index we want to search in the array.
	 * @return an object type Room
	 */
	public Room getRoomAt(int numRoom) {
		Room r = listRoom[numRoom];
		return r;

	}
	/**
	 * That method returns the Room's attribute boolean disponible.  
	 * @param numRoom will be a integer corresponding with the index we want to search in the array.
	 * @return a boolean. True if the room is able, false if not.
	 */
	public boolean getDisponible(int numRoom) {
		return listRoom[numRoom].getDisponible();
	}
	
}