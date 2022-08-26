package util;

import java.util.Optional;

import javafx.scene.control.TextField;

public class Utils {
	public static void gainFocus(TextField txt) {
		//Ganha o foco
		txt.requestFocus();
		//Positicona o cursor no final do texto
		txt.positionCaret(txt.getText().length());
	}
	//Verifica se o ultimo charactere é um sinal de operação
	public static boolean lastCharactereIsOperation(String str) {
		String ultimaLetra = "";
		
		if (str!= null && str.length() > 0) {
			ultimaLetra = String.valueOf(str.trim().charAt(str.length() - 1));
		}
		
		return ultimaLetra.matches("[^\\d]+");
	}
	//Se o ultimo character for um sinal de operação, alterar ele para um novo sinal de operaçao, ou somente adciona um 
	public static void changeOperation (TextField txt, String newOperation) {
		String strField = txt.getText();
		
		if (lastCharactereIsOperation(strField)) {			
			strField = Optional.ofNullable(strField)
		    .filter(s -> s.length() != 0)
		    .map(s -> s.substring(0, s.length() - 1))
		    .orElse(strField);
			
			txt.setText(strField + newOperation);
			
		}else {
			txt.setText(strField + newOperation);
		}
		
		Utils.gainFocus(txt);	
	}
	
	//Remove ultimo charactere
	public static String removeLastCharactere(String str) {
		return str = Optional.ofNullable(str)
			    .filter(s -> s.length() != 0)
			    .map(s -> s.substring(0, s.length() - 1))
			    .orElse(str);
	}
}
