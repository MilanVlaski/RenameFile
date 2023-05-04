package testselecter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import selecter.Selecter;

class TestAllCases {

	Selecter selecter;
	
	@BeforeEach
	void setup() {
		selecter = new Selecter();
	}
	
	@Test
	void shouldTest1() {
		selecter.setResult("src/Hiker_spec.re");
		assertArrayEquals(new int[] {4, 9}, selecter.getResult());
	}
	
	@Test
	void shouldTest2() {
		selecter.setResult("test/hiker_test.exs");
		assertArrayEquals(new int[] {5, 10}, selecter.getResult());
	}
	
	@Test
	void shouldTest3() {
		selecter.setResult("wibble/test/hiker_spec.rb");
		assertArrayEquals(new int[] {12, 17}, selecter.getResult());
	}
	
	@Test
	void shouldTest4() {
		selecter.setResult("hiker_steps.rb");
		assertArrayEquals(new int[] {0, 5}, selecter.getResult());
	}
	
	@Test
	void shouldTest5() {
		selecter.setResult("hikerTest.chpl");
		assertArrayEquals(new int[] {0, 5}, selecter.getResult());
	}
	
	@Test
	void shouldTest6() {
		selecter.setResult("hiker-test.js");
		assertArrayEquals(new int[] {0, 5}, selecter.getResult());
	}
	
	@Test
	void shouldTest7() {
		selecter.setResult("hiker");
		assertArrayEquals(new int[] {0, 5}, selecter.getResult());
	}

}
