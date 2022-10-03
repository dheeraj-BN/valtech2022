package com.valtech.training.maven.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticImplTest {

	@Test
	public void testAdd() {
		Arithmetic a=new ArithmeticImpl();
		assertEquals(5, a.add(2, 3));
		assertEquals(5, a.add(3, 2));
		assertEquals(3, a.add(0, 3));
	}


@Test
public void testSub() {
	Arithmetic a=new ArithmeticImpl();
	assertEquals(-1, a.sub(2, 3));
	assertEquals(1, a.sub(3, 2));
	assertEquals(-3, a.sub(0, 3));
}

@Test
public void testMul() {
	Arithmetic a=new ArithmeticImpl();
	assertEquals(6, a.mul(2, 3));
	assertEquals(6, a.mul(3, 2));
	assertEquals(0, a.mul(0, 3));
}

@Test
public void testDiv() {
	Arithmetic a=new ArithmeticImpl();
	assertEquals(1, a.div(3, 3));
	assertEquals(3, a.div(6, 2));
	try {
		a.div(3, 0);
		fail("Ae expected");
		
	}catch (ArithmeticException ae) {
		// TODO: handle exception
	}
}
}