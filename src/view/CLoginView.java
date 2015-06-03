package view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import main.Constant.EEvent;
import control.CLoginControl;
import entity.VLogin;
import entity.VUser;
import entity.VUser.EUserType;
import exception.PasswordNotMatchException;
import exception.UserIDNotFoundException;

public class CLoginView extends CView {
	
	public EEvent show(Scanner scanner) {

		// input from keyboard using scanner
		VLogin vLogin = new VLogin();
		System.out.println("���̵��Է�: ");
		String userId = scanner.next();
		System.out.println("��й�ȣ�Է�: ");
		String password = scanner.next();		
		vLogin.setUserID(userId);		
		vLogin.setPassword(password);

		VUser vUser = new VUser();
		// vUser = control.login(vLogin); 29 ��ſ� �̰��� �߰��ϵ��� �ٲٶ�.
		vUser.setName(userId);
		vUser.setUserID(password);
		vUser.seteUserType(EUserType.EStudent);
		System.out.println("�α����� �����߽��ϴ�.");
		EEvent selection = null;
		if (vUser.geteUserType() == EUserType.EProfessor) {
			selection = EEvent.eProfessor;
		} 
		else {
			selection = EEvent.eStudent;
		}
		return selection;

	}

	
	
}
