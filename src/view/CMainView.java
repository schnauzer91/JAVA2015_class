package view;

import java.util.Scanner;

import main.Constant.EEvent;

public class CMainView extends CView {

	@Override
	public EEvent show(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("[�л���� �ý���]");
		System.out.println("1. �α���");
		System.out.println("2. ȸ������");
		System.out.println("0. ����");
		System.out.println("�޴����� :");
		EEvent selection = EEvent.values()[scanner.nextInt()];
		return selection;
		
	}

}
