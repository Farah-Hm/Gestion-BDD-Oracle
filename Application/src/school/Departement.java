package school;

public class Departement {
	private int code_Dep;
	private String intitule_dep;
	private String nom_chef;
	private String prenom_chef;

	public Departement(int code_Dep, String intitule_dep, String nom_chef, String prenom_chef) {
		this.code_Dep = code_Dep;
		this.intitule_dep = intitule_dep;
		this.nom_chef = nom_chef;
		this.prenom_chef = prenom_chef;
	}

	public void setCode_Dep(int code_Dep) {
		this.code_Dep = code_Dep;
	}

	public void setIntitule_dep(String intitule_dep) {
		this.intitule_dep = intitule_dep;
	}

	public void setNom_chef(String nom_chef) {
		this.nom_chef = nom_chef;
	}

	public void setPrenom_chef(String prenom_chef) {
		this.prenom_chef = prenom_chef;
	}

	public int getCode_dep() {
		return code_Dep;
	}

	public String getIntitule_dep() {
		return intitule_dep;
	}

	public String getNom_chef() {
		return nom_chef;
	}

	public String getPrenom_chef() {
		return prenom_chef;
	}
}