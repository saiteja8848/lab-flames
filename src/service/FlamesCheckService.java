package service;

// Create a class called FlamesCheckService
// FlamesCheckService has a method findFlames to find the flames between two names
// char findFlames(String name1, String name2) takes two strings as arguments
// Your task is to calculate the flames value and return the corresponding character as output 
// You must return only the following values ['f','l','a','m','e','s']
// change the return value at the end of the method corresponding to your return value

public class FlamesCheckService {

	public static int leftCount(String name1, String name2) {
		StringBuilder sb1 = new StringBuilder(name1);
		StringBuilder sb2 = new StringBuilder(name2);
		int i, j;
		for (i = 0; i < sb1.length(); i++) {
			for (j = 0; j < sb2.length();) {
				if (sb1.charAt(i) == sb2.charAt(j)) {
					sb1.deleteCharAt(i);
					sb2.deleteCharAt(j);
					i = 0;
					j = 0;
					continue;
				}
				j++;
			}
		}
		String combined = sb1.toString() + sb2.toString();
		return combined.length();
	}

	public char findRelation(String name1, String name2) {
		int index, flamesCount;
		StringBuilder word = new StringBuilder("flames");
		boolean status = true;
		flamesCount = leftCount(name1, name2);
		flamesCount -= 1;
		while (status) {
			if (flamesCount >= 6)
				index = flamesCount % word.length();
			else
				index = flamesCount;

			word.deleteCharAt(index);
			StringBuilder t = new StringBuilder((word.substring(index) + word.substring(0, index)));
			word = t;
			if (word.length() == 1)
				status = false;

		}
		char result = word.charAt(0);
		return result;
	}

	public char findFlames(String name1, String name2) {
		return findRelation(name1, name2);
	}

}