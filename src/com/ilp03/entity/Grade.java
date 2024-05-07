package com.ilp03.entity;

public class Grade {
	private long gradeId;
	private String gradeName;
	private double gradeBasic;
	private double gradeTa;
	private double gradeHra;
	private double gradeMa;
	private double gradeBonus;
	private double gradePf;
	private double gradePt;
	public Grade(long gradeId, String gradeName, double gradeBasic, double gradeTa, double gradeHra, double gradeMa,
			double gradeBonus, double gradePf, double gradePt) {
		super();
		this.gradeId = gradeId;
		this.gradeName = gradeName;
		this.gradeBasic = gradeBasic;
		this.gradeTa = gradeTa;
		this.gradeHra = gradeHra;
		this.gradeMa = gradeMa;
		this.gradeBonus = gradeBonus;
		this.gradePf = gradePf;
		this.gradePt = gradePt;
	}
	public long getGradeId() {
		return gradeId;
	}
	public void setGradeId(long gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public double getGradeBasic() {
		return gradeBasic;
	}
	public void setGradeBasic(double gradeBasic) {
		this.gradeBasic = gradeBasic;
	}
	public double getGradeTa() {
		return gradeTa;
	}
	public void setGradeTa(double gradeTa) {
		this.gradeTa = gradeTa;
	}
	public double getGradeHra() {
		return gradeHra;
	}
	public void setGradeHra(double gradeHra) {
		this.gradeHra = gradeHra;
	}
	public double getGradeMa() {
		return gradeMa;
	}
	public void setGradeMa(double gradeMa) {
		this.gradeMa = gradeMa;
	}
	public double getGradeBonus() {
		return gradeBonus;
	}
	public void setGradeBonus(double gradeBonus) {
		this.gradeBonus = gradeBonus;
	}
	public double getGradePf() {
		return gradePf;
	}
	public void setGradePf(double gradePf) {
		this.gradePf = gradePf;
	}
	public double getGradePt() {
		return gradePt;
	}
	public void setGradePt(double gradePt) {
		this.gradePt = gradePt;
	}

}
