package selecter;

public class Selecter {

	int lowIndex = 0;
	int highIndex;
	String word;
	public static char[] separators = {'_', '.', '-'};
	public static String[] keyword = {"test", "spec", "step", "tests"};
	
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		highIndex = word.length();
		this.word = word;
	}

	public int getLowIndex() {
		return lowIndex;
	}
	public void setLowIndex(int lowIndex) {
		this.lowIndex = lowIndex;
	}
	public int getHighIndex() {
		return highIndex;
	}
	public void setHighIndex(int highIndex) {
		this.highIndex = highIndex;
	}
	
	public int[] getResult() {
		return new int[] {lowIndex, highIndex};
	}
	
	public void setResult(String word) {
		setWord(word);
		
		removeDirs();
		removeExtension();
		setIndexAfterAnyKeyword();
	}

	public void removeExtension() {
		for(int i = word.length() - 1; i >= 0; i--) {
			if(word.charAt(i) == '.') {
				highIndex = i;
				break;
			}
		}
	}

	public void removeDirs() {
		
		for(int i = 0; i < word.length(); i++) {
			if(word.charAt(i) == '/')
				lowIndex = i + 1;
		}
	}
	
	public void setIndexAfterAnyKeyword() {
		
		for (String s : keyword) {
			setIndexToSkipKeyword(s);
		}
	}

	public void setIndexToSkipKeyword(String keyword) {
		
		String word1 = word.toLowerCase();
		String keyword1 = keyword.toLowerCase();
		
		int indexOfKeyword = word1.indexOf(keyword1, lowIndex);
		
		if(indexOfKeyword != -1) {
			
			if(indexOfKeyword == lowIndex) {
				indexOfKeyword = lowIndex + keyword1.length();
				
				if(existsSeparatorAtIndex(indexOfKeyword)) {
					indexOfKeyword++;
				}
				setLowIndex(indexOfKeyword);
			} 
			else {
				if(existsSeparatorAtIndex(indexOfKeyword - 1)) {
					indexOfKeyword--;
				}
				setHighIndex(indexOfKeyword);
			}
		}	
	}
	
	public boolean existsSeparatorAtIndex(int index) {
		
		boolean result = false;
		
		for (char c : separators) {
			if(word.charAt(index) == c) {
				result = true;
				break;
			}
		}
		
		return result;
	}
}
