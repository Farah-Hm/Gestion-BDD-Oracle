package school;
public class Bon_Affectation{
	
	private int Num_baf;
	private String Date_aff;
	private int Code_empl;
	
	public Bon_Affectation(int num_baf, String date_aff, int code_emp) {
		super();
		Num_baf = num_baf;
		Date_aff = date_aff;
		Code_empl = code_emp;
	}

	public int getNum_baf() {
		return Num_baf;
	}

	public String getDate_aff() {
		return Date_aff;
	}

	public int getCode_empl() {
		return Code_empl;
	}

	public void setNum_baf(int num_baf) {
		Num_baf = num_baf;
	}

	public void setDate_aff(String date_aff) {
		Date_aff = date_aff;
	}

	public void setCode_empl(int code_empl) {
		Code_empl = code_empl;
	}
	
}