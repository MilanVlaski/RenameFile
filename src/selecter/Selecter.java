package selecter;

public class Selecter {

	int lowIndex = 0;
	int highIndex;
	String word;
	
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
	
}
