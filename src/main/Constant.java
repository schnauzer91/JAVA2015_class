package main;

import view.CLoginView;
import view.CProfessorView;
import view.CStudentView;
import view.CView;

public class Constant {

	public enum EEvent {
		eLogout(null), 
		eMain(null), 
		eSignIn(new CLoginView()),
		eSingUp(null),
		eProfessor(new CProfessorView()),
		eStudent(new CStudentView()),
		// 아직 없는 화면은 구현시킬 것.
		// 서수에 new만 해주면 돌아간다.
		eCreateClass(null), 
		eGetClass(null),
		eSetGrade(null), 
		eGetGradeP(null),
		eRegisterClass(null), 
		eGetGradeS(null);
		
		// new가 호출되어 나온다.
		private CView view;
		public CView getView() {return view;}
		private EEvent (CView view) {
			this.view = view;
		}
		
	}
	
}
