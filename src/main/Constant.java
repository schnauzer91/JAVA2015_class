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
		// ���� ���� ȭ���� ������ų ��.
		// ������ new�� ���ָ� ���ư���.
		eCreateClass(null), 
		eGetClass(null),
		eSetGrade(null), 
		eGetGradeP(null),
		eRegisterClass(null), 
		eGetGradeS(null);
		
		// new�� ȣ��Ǿ� ���´�.
		private CView view;
		public CView getView() {return view;}
		private EEvent (CView view) {
			this.view = view;
		}
		
	}
	
}
