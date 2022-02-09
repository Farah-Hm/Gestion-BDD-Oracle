package model;

public class Contenir {
private int code_pro;
private int num_bco;
private int qte_cde;
public Contenir(int code_pro, int num_bco, int qte_cde) {
	super();
	this.code_pro = code_pro;
	this.num_bco = num_bco;
	this.qte_cde = qte_cde;
}
public int getCode_pro() {
	return code_pro;
}
public void setCode_pro(int code_pro) {
	this.code_pro = code_pro;
}
public int getNum_bco() {
	return num_bco;
}
public void setNum_bco(int num_bco) {
	this.num_bco = num_bco;
}
public int getQte_cde() {
	return qte_cde;
}
public void setQte_cde(int qte_cde) {
	this.qte_cde = qte_cde;
}

}
