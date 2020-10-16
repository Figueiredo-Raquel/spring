package org.generation.blogPessoal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
public class Testes {
	
	
	@Test
	public void testarStrings(){
	String obj1="Junit";
	String objt2="Junit";
	assertNotEquals(obj1,objt2);
	}
	
	
	@Test
	public void testarInteiros(){
	int obj1=1;
	int objt2=2;
	assertEquals(obj1,objt2);
	}
	
	@Test
	public void testarNulo(){
	String obj1="teste";
	String objt2="Junit";
	assertNull(obj1);
	
	}
	
	@Test
	public void whenAssertingNotSameObject_thenDifferent() {
	Object cat = new Object();
	Object dog = new Object();
	assertNotSame(cat, dog);
	}
	
	
}

























