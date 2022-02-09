package model;

public class Concerner {
private int num_baf;
private int qte_aff;
private int code_pro;

public Concerner(int num_baf, int qte_aff, int code_pro) {
	super();
	this.num_baf = num_baf;
	this.qte_aff = qte_aff;
	this.code_pro = code_pro;
}
public int getNum_baf() {
	return num_baf;
}
public void setNum_baf(int num_baf) {
	this.num_baf = num_baf;
}
public int getQte_aff() {
	return qte_aff;
}
public void setQte_aff(int qte_aff) {
	this.qte_aff = qte_aff;
}
public int getCode_pro() {
	return code_pro;
}
public void setCode_pro(int code_pro) {
	this.code_pro = code_pro;
}

}
