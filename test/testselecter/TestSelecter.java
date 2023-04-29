package testselecter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import selecter.Selecter;

class TestSelecter {

	Selecter selecter;
	
	@BeforeEach
	void setup() {
		selecter = new Selecter();
	}
	
	@Test
	void shouldReturnZeroAndOneIfExtension() {
		int[] expected = {0, 1};
		
		selecter.setWord("a.b");
		selecter.removeExtension();
		
		assertArrayEquals(expected, selecter.getResult());
	}
	
	@Test
	void shouldReturnZeroOneIfNoExtension() {
		int[] expected = {0, 1};
		
		selecter.setWord("a");
		selecter.removeExtension();
		
		assertArrayEquals(expected, selecter.getResult());
	}
	
	@Test
	void shouldReturnZeroOneIfEmptyString() {
		int[] expected = {0, 0};
		
		selecter.setWord("");
		selecter.removeExtension();
		
		assertArrayEquals(expected, selecter.getResult());
	}

	@Test
	void shouldReturnIndexAfterDir() {
		int[] expected = {2, 3};
		
		selecter.setWord("a/b");
		selecter.removeDirs();
		
		assertArrayEquals(expected, selecter.getResult());
	}
	
	@Test
	void shouldReturnIndexAfterTwoDirs() {
		int[] expected = {4, 5};
		
		selecter.setWord("a/b/c");
		selecter.removeDirs();
		
		assertArrayEquals(expected, selecter.getResult());
	}
	
	@Test
	void shouldReturnIndexIfExtensionAndDir() {
		int[] expected = {2, 3};
		
		selecter.setWord("a/b.c");
		selecter.removeExtension();
		selecter.removeDirs();
		
		assertArrayEquals(expected, selecter.getResult());
	}

}
