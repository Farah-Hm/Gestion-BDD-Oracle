package school;
public class Bon_Sortie{
	
	private int Num_bso;
	private String Date_sor;
	private int Code_empl;
	
	public Bon_Sortie(int Num_bso, String date_sor, int code_emp) {
		super();
		this.Num_bso = Num_bso;
		this.Date_sor = date_sor;
		this.Code_empl = code_emp;
	}
	public int getNum_bso() {
		return Num_bso;
	}
	public String getDate_sor() {
		return Date_sor;
	}
	public int getCode_empl() {
		return Code_empl;
	}
	public void setNum_bso(int num_bso) {
		Num_bso = Num_bso;
	}
	public void setDate_sor(String date_sor) {
		Date_sor = date_sor;
	}
	public void setCode_empl(int code_empl) {
		Code_empl = code_empl;
	}
}