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
		// 	null�� �ϴ� �־��µ� ���Ǻ��� Ȯ���ѹ� �ؾ߰ڴ�.
		return null;
		
	}
	void show() {
		// TODO Auto-generated method stub
		
	}
}
