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
		System.out.println("아이디입력: ");
		String userId = scanner.next();
		System.out.println("비밀번호입력: ");
		String password = scanner.next();		
		vLogin.setUserID(userId);		
		vLogin.setPassword(password);

		VUser vUser = new VUser();
		// vUser = control.login(vLogin); 29 대신에 이것을 추가하도록 바꾸라.
		vUser.setName(userId);
		vUser.setUserID(password);
		vUser.seteUserType(EUserType.EStudent);
		System.out.println("로그인이 성공했습니다.");
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
