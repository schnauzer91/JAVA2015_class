package main;

import java.sql.SQLException;
import java.util.Scanner;

import main.Constant.EEvent;
import control.CLoginControl;
import entity.VUser;
import entity.VUser.EUserType;
import view.CLoginView;
import view.CMainView;
import view.CProfessorView;
import view.CStudentView;
import view.CView;
import DAOs.IDAO;
import DAOs.MySQL;

public class CMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		CMainView mainView = new CMainView();
		EEvent selection = mainView.show(scanner);

		// 1. ȭ���� �������̵� �ű�� ( view���� ��ȣ�� ��� �޶�� �Ѵ�. )
		// 2. ������ ������ �޴� Ʋ�� �����϶�.
		// keyword : event-driven programming
		// keyword : event handler, main event looping 
		while (selection != EEvent.eLogout) {
				// enum Ÿ�԰� ������������ �̿��Ͽ� �ڵ带 ������Ų��.
				CView view = selection.getView();
				selection = view.show(scanner);
			}
		scanner.close();
		}
}

