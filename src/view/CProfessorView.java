package view;

import java.util.Scanner;

import main.Constant.EEvent;

public class CProfessorView extends CView {

	@Override
	public EEvent show(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("[ ����ȭ�� ]");
		System.out.println("1. ���°���");
		System.out.println("2. ������ȸ");
		System.out.println("3. �����Է�");
		System.out.println("4. ������ȸ");
		System.out.println("5. �α׾ƿ�");
		System.out.println("0. ����");
		System.out.println("�޴����� :");
		EEvent selection = EEvent.values()[scanner.nextInt()];
		return selection;
		
	}
}
