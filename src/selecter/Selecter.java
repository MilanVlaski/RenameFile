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
	
	public int[] getResult() {
		return new int[] {lowIndex, highIndex};
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
	
	public int getIndexAfterAnyKeyword() {
		
		int result = -1;
		
		for (String s : keyword) {
			int index = getIndexAfterKeyword(s);
			if(index != -1)
				result = index;
		}
		
		return result;
	}

	public int getIndexAfterKeyword(String keyword) {
		//make it case insensitive
		String word1 = word.toLowerCase();
		String keyword1 = keyword.toLowerCase();
		
		int result = word1.indexOf(keyword1, lowIndex);
		
		if(result != -1) {
			
			if(result == lowIndex) {
				result = lowIndex + keyword1.length();
				if(existsSeparatorAtIndex(result))
					result++;
			} 
			else if(existsSeparatorAtIndex(result - 1)) {
				result--;
			}
		}
		
		return result;
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
