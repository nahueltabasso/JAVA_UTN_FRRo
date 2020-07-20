package utils;

public class Utils {
	
	public static boolean cadContainsDigits(String cad) {
		for (int i = 0; i < cad.length(); i++) {
			char caracter = cad.charAt(i);
			if (Character.isDigit(caracter)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean cadContainsLetters(String cad) {
		for (int i = 0; i < cad.length(); i++) {
			char caracter = cad.charAt(i);
			if (!Character.isDigit(caracter)) {
				return true;
			}
		}
		return false;
	}
}
