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

		// 1. 화면을 고유아이디를 매기라 ( view마다 번호가 모두 달라야 한다. )
		// 2. 루핑을 돌려서 메뉴 틀을 재사용하라.
		// keyword : event-driven programming
		// keyword : event handler, main event looping 
		while (selection != EEvent.eLogout) {
				// enum 타입과 폴리모피즘을 이용하여 코드를 개선시킨다.
				CView view = selection.getView();
				selection = view.show(scanner);
			}
		scanner.close();
		}
}

