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
		
		selecter.setWord("a.b");
		selecter.removeExtension();
		
		assertArrayEquals(new int[]{0, 1}, selecter.getResult());
	}
	
	@Test
	void shouldReturnZeroOneIfNoExtension() {
		
		selecter.setWord("a");
		selecter.removeExtension();
		
		assertArrayEquals(new int[]{0, 1}, selecter.getResult());
	}
	
	@Test
	void shouldReturnZeroOneIfEmptyString() {
		
		selecter.setWord("");
		selecter.removeExtension();
		
		assertArrayEquals(new int[]{0, 0}, selecter.getResult());
	}

	@Test
	void shouldReturnIndexAfterDir() {
		
		selecter.setWord("a/b");
		selecter.removeDirs();
		
		assertArrayEquals(new int[]{2, 3}, selecter.getResult());
	}
	
	@Test
	void shouldReturnIndexAfterTwoDirs() {
		
		selecter.setWord("a/b/c");
		selecter.removeDirs();
		
		assertArrayEquals(new int[]{4, 5}, selecter.getResult());
	}
	
	@Test
	void shouldReturnIndexIfExtensionAndDir() {
		
		selecter.setWord("a/b.c");
		selecter.removeExtension();
		selecter.removeDirs();
		
		assertArrayEquals(new int[]{2, 3}, selecter.getResult());
	}
	

}
