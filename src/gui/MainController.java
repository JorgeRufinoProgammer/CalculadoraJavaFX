package gui;

import java.net.URL;
import java.util.ResourceBundle;

import entities.Calculator;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import util.Constraints;
import util.Utils;

public class MainController implements Initializable{
	@FXML
	private TextField txtResult;
	
	@FXML
	private Button btn0;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;
	@FXML
	private Button btn9;
	@FXML
	private Button btnDot;
	
	@FXML
	private Button btnSum;
	@FXML
	private Button btnSub;
	@FXML
	private Button btnMultiply;
	@FXML
	private Button btnDivide;
	@FXML
	private Button btnResult;
	@FXML
	private Button btnExpon;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnDeleteAll;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldNumbersOperations(txtResult);
		Constraints.impedeSinais(txtResult);
	}
	
	public void onBtn0Result() {
		String strField = txtResult.getText();
		Calculator obj = new Calculator();
		txtResult.setText(""+obj.evaluate(strField));
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtnSum() {
		Utils.changeOperation(txtResult, "+");				
	}
	
	public void onBtnSub() {
		Utils.changeOperation(txtResult, "-");			
	}
	
	public void onBtnMultiply() {
		Utils.changeOperation(txtResult, "*");				
	}
	
	public void onBtnDivide() {
		Utils.changeOperation(txtResult, "/");				
	}
	
	public void onBtnExpon() {
		Utils.changeOperation(txtResult, "^");			
	}
	
	public void onBtnDelete() {
		txtResult.setText(Utils.removeLastCharactere(txtResult.getText()));
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtnDeleteAll() {
		txtResult.setText("");
		Utils.gainFocus(txtResult);
	}
	
	//Atalho de teclado
	public EventHandler<KeyEvent> keyShortcut = new EventHandler <KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
//        	Se aperta ESC apaga todo o display
//          if (event.getCode() == KeyCode.ESCAPE) {
//          	onBtnDeleteAll();
//          }        	
        	String operation = ""+ event.getCode();
        	
        	switch (operation) {
				case "ESCAPE" 	 ->	onBtnDeleteAll();
				case "EQUALS" 	 ->	onBtn0Result();
				case "ENTER"  	 ->	onBtn0Result();
				case "ADD"    	 ->	{Utils.changeOperation(txtResult, "+");}
				case "SUBTRACT"  ->	{Utils.changeOperation(txtResult, "-");}
				case "DIVIDE"    ->	{Utils.changeOperation(txtResult, "/");}
				case "MULTIPLY"  ->	{Utils.changeOperation(txtResult, "*");}
				
				default -> operation = ""; 			
			}
        }
    };
	
    public void onBtn0Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"0");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtn1Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"1");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtn2Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"2");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtn3Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"3");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtn4Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"4");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtn5Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"5");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtn6Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"6");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtn7Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"7");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtn8Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"8");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtn9Action() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+"9");
		Utils.gainFocus(txtResult);		
	}
	
	public void onBtnDotAction() {
		String strField = txtResult.getText();		
		txtResult.setText(strField+".");
		Utils.gainFocus(txtResult);		
	}
}

