package com.amo11k.hotel;

import java.io.Serializable;

public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numRoom;
	private int typeRoom;
	private boolean smokeRoom;
	private boolean disponible;

	public Room() {

	}

	public Room(int num, int type) {
		disponible = true;
		numRoom = num;
		typeRoom = type;
		if (numRoom % 2 == 0)
			smokeRoom = true;
		else
			smokeRoom = false;
	}

	public int getNumRoom() {
		return numRoom;
	}

	public String getType(int i) {
		String kindRoom = "NOVA";
		switch (i) {
		case 0:
			kindRoom = "Standar";
			break;
		case 1:
			kindRoom = "Lujo";
			break;
		case 2:
			kindRoom = "LujoShh";
			break;
		}
		return kindRoom;
	}
	

	public int getTypeInt() {
		return typeRoom;
	}

	public String getSmoke() {
		String s;
		if (smokeRoom) {
			s = "Fumar";
		} else {
			s = "No fumar";
		}
		return s;
	}

	public boolean getSmokeBoolean() {
		return smokeRoom;

	}

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disp) {
		disponible = disp;
	}

	public String toString() {
		return "Nº" + numRoom + ";T" + getType(getTypeInt()) + ";F:" + getSmoke() +";D:"+getDisponible();
	}

	/*public static void main(String[] args) {
		Room hab = new Room(1, 2);
		System.out.println(hab.toString() + hab.getDisponible());

		for (int i = 0; i < 40; i++) {

			System.out.println();
		}
	}*/
}