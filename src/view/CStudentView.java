package view;

import java.util.Scanner;

import main.Constant;
import main.Constant.EEvent;

public class CStudentView extends CView {

	@Override
	public EEvent show(Scanner scanner) {
		// TODO Auto-generated method stub
		System.out.println("[학생화면]");
		System.out.println("6. 강좌개설");
		System.out.println("7. 강좌조회");
		System.out.println("8. 성적입력");
		System.out.println("0. 종료");
		System.out.println("메뉴선택 :");
		EEvent selection = EEvent.values()[scanner.nextInt()];
		return selection;
		
	}
}
