package school;



public class Employee {
	public Employee(int Code_empl,String nom_empl,String prenom_empl,String grade_empl,String fonction_empl,int code_dep) {
		this.Code_emp=Code_empl;
		this.nom_emp=nom_empl;
		this.prenom_emp=prenom_empl;
		this.grade_emp=grade_empl;
		this.fonction_emp=fonction_empl;
		this.code_dep=code_dep;
	}
	public int getCode_empl() {
		return Code_emp;
	}

	public int getCode_dep() {
		return code_dep;
	}
	public void setCode_dep(int code_dep) {
		this.code_dep = code_dep;
	}
	public void setCode_empl(int code_empl) {
		Code_emp = code_empl;
	}
	public void setNom_empl(String nom_empl) {
		this.nom_emp = nom_empl;
	}
	public void setPrenom_empl(String prenom_empl) {
		this.prenom_emp = prenom_empl;
	}
	public void setGrade_empl(String grade_empl) {
		this.grade_emp = grade_empl;
	}
	public void setFonction_empl(String fonction_empl) {
		this.fonction_emp = fonction_empl;
	}
	public String getNom_empl() {
		return nom_emp;
	}

	public String getPrenom_empl() {
		return prenom_emp;
	}

	public String getGrade_empl() {
		return grade_emp;
	}

	public String getFonction_empl() {
		return fonction_emp;
	}

	public int getcode_dep() {
		return code_dep;
	}

	private int Code_emp;
	private	String nom_emp;
	private String prenom_emp;
	private String grade_emp;
	private	String fonction_emp;
	private int code_dep;
	
	
}
