package selecter;

public class Selecter {

	public int[] selectName(String nameWithExtension) {
		
		int[] result = new int[2];
		result[0] = 0;
		for(int i = 0; i < nameWithExtension.length(); i++) {
			if(nameWithExtension.charAt(i) == '.')
				result[1] = i;
		}
		
		return result;
	}

	
}
