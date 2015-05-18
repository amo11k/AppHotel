package com.amo11k.hotel;

import java.io.Serializable;

public class Room implements Serializable {
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

	/**
	 * Room class constructor. Needs two arguments.
	 * 
	 * @param num
	 *            will be the number of the room.
	 * @param type
	 *            will be type of the room.
	 */
	public Room(int num, int type) {
		disponible = true;
		numRoom = num;
		typeRoom = type;
		if (numRoom % 2 == 0)
			smokeRoom = true;
		else
			smokeRoom = false;
	}

	/**
	 * That method returns the type of the room as a String.
	 * 
	 * @param i
	 *            will be a integer corresponding with typeRoom
	 * @return a typeRoom as String
	 */
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

	/**
	 * 
	 * @return That method returns a integer typeRoom
	 */
	public int getTypeInt() {
		return typeRoom;
	}

	/**
	 * 
	 * @return that method returns a String if the room is able or not to smoke.
	 */
	public String getSmoke() {
		String s;
		if (smokeRoom) {
			s = "Fumar";
		} else {
			s = "No fumar";
		}
		return s;
	}

	/**
	 * 
	 * @returnIf it's true the room is able to smoke, if it's false is not able.
	 */
	public boolean getSmokeBoolean() {
		return smokeRoom;
	}
	
	/**
	 * 
	 * @return a boolean. True if the room is able, false if not.
	 */
	public boolean getDisponible() {
		return disponible;
	}
	
	/**
	 * This method set the Room's attribute "disponible".
	 * @param disp
	 */
	public void setDisponible(boolean disp) {
		disponible = disp;
	}

	/**
	 * just a toString() method -de toda la vida- for Romm class.
	 * @return a String
	 */
	public String toString() {
		return "Nº" + numRoom + ";T" + getType(getTypeInt()) + ";F:"
				+ getSmoke() + ";D:" + getDisponible();
	}
}