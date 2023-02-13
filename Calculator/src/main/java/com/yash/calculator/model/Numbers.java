package com.yash.calculator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Numbers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	String inserted;
	String sign;
	double result;

	public String getInserted() {
		return inserted;
	}

	public void setInserted(String inserted) {
		this.inserted = inserted;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Numbers [id=" + id + ", inserted=" + inserted + ", sign=" + sign + ", result=" + result + "]";
	}

}
