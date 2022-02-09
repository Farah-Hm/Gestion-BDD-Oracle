package model;

public class Refere {
private int num_bso;
private int code_pro;
private int qte_sortie;
public Refere(int code, int code_prod, int qte) {
	super();
	this.num_bso = code;
	this.code_pro = code_prod;
	this.qte_sortie = qte;
}
public int getNum_bso() {
	return num_bso;
}
public void setNum_bso(int num_bso) {
	this.num_bso = num_bso;
}
public int getCode_pro() {
	return code_pro;
}
public void setCode_pro(int code_prod) {
	this.code_pro = code_prod;
}
public int getQte_sortie() {
	return qte_sortie;
}
public void setQte_sortie(int qte_sortie) {
	this.qte_sortie = qte_sortie;
}






}
