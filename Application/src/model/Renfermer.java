package model;

public class Renfermer {
private int num_bliv;
private int code_pro;
private int qte_liv;
public Renfermer(int num_bliv, int code_pro, int qte_liv) {
	super();
	this.num_bliv = num_bliv;
	this.code_pro = code_pro;
	this.qte_liv = qte_liv;
}
public int getNum_bliv() {
	return num_bliv;
}
public void setNum_bliv(int num_bliv) {
	this.num_bliv = num_bliv;
}
public int getCode_pro() {
	return code_pro;
}
public void setCode_pro(int code_pro) {
	this.code_pro = code_pro;
}
public int getQte_liv() {
	return qte_liv;
}
public void setQte_liv(int qte_liv) {
	this.qte_liv = qte_liv;
}

}
