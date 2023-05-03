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
	void shouldSetResultFourNineIfWordWithDirExtensionAndKeyword() {
		selecter.setResult("src/Hiker_spec.re");
		assertArrayEquals(new int[] {4, 9}, selecter.getResult());
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
	
	@Test
	void shouldSetLowIndexToFourIfWordStartsWithTest() {
		selecter.setWord("testA");
		selecter.setIndexToSkipKeyword("test");
		assertEquals(4, selecter.getLowIndex());
	}
	
	@Test
	void shouldSetHighIndexToOneIfWordEndsWithTest() {
		selecter.setWord("aTest");
		selecter.setIndexToSkipKeyword("test");
		assertEquals(1, selecter.getHighIndex());
	}
	
	@Test
	void shouldSetHighIndexToOneIfWordEndsWithUnderscoreTest() {
		selecter.setWord("a_test");
		selecter.setIndexToSkipKeyword("test");
		assertEquals(1, selecter.getHighIndex());
	}
	
	@Test
	void shouldSetLowIndexToFiveIfWordStartsWithTestUnderscore() {
		selecter.setWord("test_A");
		selecter.setIndexToSkipKeyword("test");
		assertEquals(5, selecter.getLowIndex());
	}
	
	@Test
	void shouldReturnFiveAfterSpecUnderscore() {
		selecter.setWord("spec_A");
		selecter.setIndexAfterAnyKeyword();
		assertEquals(5, selecter.getLowIndex());
	}
	
	@Test
	void shouldReturnMinusOneIfNoKeywords() {
		selecter.setWord("abc");
		selecter.setIndexAfterAnyKeyword();
		assertArrayEquals(new int[] {0, 3}, selecter.getResult());
	}
	
	@Test
	void shouldBeTrueIfSeparator() {
		selecter.setWord("_");
		assertEquals(true, selecter.existsSeparatorAtIndex(0));
	}
	
	@Test
	void shouldBeFalseIfNotSeparator() {
		selecter.setWord("a");
		assertEquals(false, selecter.existsSeparatorAtIndex(0));
	}
	
	@Test
	void shouldReturnSameJson() {
		
	}
	

}
