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
		assertArrayEquals(expected, selecter.selectName("a.b"));
	}
	
	@Test
	void shouldReturnZeroZerpIfNoExtension() {
		int[] expected = {0, 0};
		assertArrayEquals(expected, selecter.selectName("a"));
	}
	
	@Test
	void shouldReturnZeroZeroIfEmptyString() {
		int[] expected = {0, 0};
		assertArrayEquals(expected, selecter.selectName(""));
	}


}
