package view;

import java.util.Scanner;

import main.Constant;
import main.Constant.EEvent;

public class CStudentView extends CView {

	@Override
	public EEvent show(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("[�л�ȭ��]");
		System.out.println("6. ���°���");
		System.out.println("7. ������ȸ");
		System.out.println("8. �����Է�");
		System.out.println("0. ����");
		System.out.println("�޴����� :");
		EEvent selection = EEvent.values()[scanner.nextInt()];
		return selection;
		
	}
}
