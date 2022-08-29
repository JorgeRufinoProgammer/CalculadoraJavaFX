package util;

import javafx.scene.control.TextField;

public class Constraints {

	public static void setTextFieldInteger(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*")) {
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldMaxLength(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}

	public static void setTextFieldDouble(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {	
			if (newValue != null && !newValue.matches("\\d*([\\.]\\d*)?")) {
				txt.setText(oldValue);
			}
		});
	}
	//Permite apenas Numeros e os sinas das Operações
	public static void setTextFieldNumbersOperations(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {			
			if (newValue != null && !newValue.matches("(\\d*([\\.+-/*)(^]\\d*)?)*")) {				
				txt.setText(oldValue);
			}
		});
	}
	//Impede sinais das operacoes repetidos ou alternados
	public static void impedeSinais(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (validaStringTextField(oldValue, newValue)) {
				txt.setText(oldValue);
			}
		});
	}

	private static boolean validaStringTextField(String oldValue, String newValue) {
		boolean result = false;

		//Evita que comece digitando as operaçoes
		if ((newValue.equals("+") && oldValue.equals("")) || (newValue.equals("/") && oldValue.equals(""))
		||  (newValue.equals("*") && oldValue.equals("")) || (newValue.equals(".") && oldValue.equals(""))) 
		 {
			
			result = true;
		}
		//Evita repeticao e alternancia das operacoes
		if (newValue.contains("++") || newValue.contains("--") || newValue.contains("..") || newValue.contains("**")
		 || newValue.contains("//") || newValue.contains("+-") || newValue.contains("-+") || newValue.contains("+*")
		 || newValue.contains("*+") || newValue.contains("+/") || newValue.contains("/+") || newValue.contains("*-")
		 || newValue.contains("-*") || newValue.contains("*/") || newValue.contains("/*") || newValue.contains(".+")
		 || newValue.contains("+.") || newValue.contains(".-") || newValue.contains("-.") || newValue.contains(".*")
		 || newValue.contains("*.") || newValue.contains("./") || newValue.contains("/.") || newValue.contains("/-")
		 || newValue.contains("-/") || newValue.contains("()") || newValue.contains(")("))  {
			
			result = true;
		}		
		
		return result;
	}
	
	public static boolean validateExpression(String str) {				
		int contador = 0;
		//Verifica se termina com um operador
		if (Utils.lastCharactereIsOperation(str)) {		
			return false;
		}
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c == '(') {
				contador++;
			}
			if(c == ')') {
				contador--;
				if(isOperator(str.charAt(i-1))) {
					return false;
				}
			}
		}
		
		if (contador == 0 ) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
	}
}
