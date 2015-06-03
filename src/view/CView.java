package view;

import java.util.Scanner;

import main.Constant.EEvent;
import control.CControl;

abstract public class CView {
	// association
	private CControl control;
	public CControl getControl() {return control;}
	public void setControl(CControl control) {this.control = control;}
	

	public EEvent show(Scanner scanner){
		// 	null로 일단 넣었는데 강의보고 확인한번 해야겠다.
		return null;
		
	}
	void show() {
		// TODO Auto-generated method stub
		
	}
}
