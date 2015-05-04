package com.amo11k.hotel;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Hotel extends Room implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4788212720797370761L;
	protected final static int NUM_ROOMS = 40;
	private int count = 1;
	private static Room[] listRoom = new Room[NUM_ROOMS];

	public Hotel() {
		for (int i = 0; i < 40; i++) {
			int random = (int) (Math.random() * 3);
			listRoom[i] = (new Room(count, random));
			count++;
		}
	}

	public static Room getRoomAt(int numRoom) {
		Room r = listRoom[numRoom];
		return r;

	}

	public boolean getDisponible(int numRoom) {
		return listRoom[numRoom].getDisponible();
	}

	public static void main(String[] args) {
		Hotel hab = new Hotel();

		for (int i = 0; i < 40; i++) {

			System.out.println(hab.getRoomAt(i));
		}
	}
}