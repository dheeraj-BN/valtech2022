package com.valtech.training.valtech.junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AritmeticTest {
	
	private Arithmetic arithmetic;
	private static int ZERO;
	
	
	
	@BeforeEach
	public void runBeforeTest() {
		arithmetic=new ArithmeticImpl();
		
		System.out.println("run Before......");
	}

	@Test
	public void testHello() {
		assertTrue(true);
		System.out.println("hi.....");
	}
	@Test
	public void testHi() {
		assertTrue(true);
		System.out.println("hello ....");
		
	}
	
	@AfterEach
	public void runAfterTest(){
		System.out.println("after each methord");
	}
	
	@BeforeAll
	public static void excuteMeFirst(){
		System.out.println("before ALL -First executed");
		ZERO=0;
	}
	
	@AfterAll
	public static void excuteMeLast(){
		System.out.println("After ALL -last executed");
	}
	
	
	@Test
	@DisplayName("generic  test Cases for add")
	public void testAdd(){
		assertEquals(5,arithmetic.add(2, 3));
	}
	//methord 1
	@ParameterizedTest
	@ValueSource(ints={2,3,4,-1,-2})
	@DisplayName(value="{index} Testing for add with {0}and 0")
	public void testAdd(int a){
		assertEquals(a,arithmetic.add(a, ZERO));
	}
	
	
	//mehtord 2
	public static Stream<Arguments> argumentsForAdd(){
		return Stream.of(Arguments.of(2,3,4),Arguments.of(1,3,4));
	}
	
	@ParameterizedTest
	@MethodSource("argumentsForAdd")
	public void testAdd(int a,int b,int res){
		
	}
	
	
	//methord 3
	@ParameterizedTest
	@CsvSource({
		"'Adding 2 positive Nos',2,3,5",
		"'Adding 2 negative Nos',-2,-3,-5",
		"'Adding 1 negative 1 positive Nos',-2,3,1"
	})
    public void testAdd(String name,int a,int b,int res){
		assertEquals(res, arithmetic.add(a, b));
	}
	
	
	//nested
	@Nested
	@DisplayName("this is for testing sub methord of the arthmaetic")
	public class SubTest{
		
		private Arithmetic arithmetic;
		
		@ParameterizedTest
		@CsvSource({
			"'Subtracting 2 positive Nos',2,3,-1",
			"'Subtracting 2 negative Nos',-2,-3,1",
			"'Subtracting 1 negative 1 positive Nos',-2,3,-5"
		})
	    public void testSub(String name,int a,int b,int res){
			arithmetic=new ArithmeticImpl();
			assertEquals(res, arithmetic.sub(a, b));
		}
		
	}
	
	@Nested
    public class DivisionTest {
        
        private Arithmetic arithmetic;
        
        @Test
        public void testDivByZero(){
           arithmetic= new ArithmeticImpl();
           assertThrows(ArithmeticException.class,() -> { arithmetic.div(2,ZERO);});
        }
    }
	
}
