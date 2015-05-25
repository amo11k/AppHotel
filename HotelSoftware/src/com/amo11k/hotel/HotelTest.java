package com.amo11k.hotel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HotelTest {
	
	@Before
	public void setup(){
		Hotel h = new Hotel();
	}
	
	
	@Test
	public void testGetRoomAt() {
		Hotel h = new Hotel();
		h.getRoomAt(0);
		assertEquals(h.getRoomAt(0).getClass(), Room.class);
	}

	@Test
	public void testGetDisponibleInt(){
		Hotel h = new Hotel();
		assertEquals(h.getDisponible(0), Boolean.TRUE);
	}

}
