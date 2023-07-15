package com.quotes.models;

public class Quote {
private String q;
private String a;
private String h;

public Quote() {
	super();
	// TODO Auto-generated constructor stub
}

public Quote(String q, String a, String h) {
	super();
	this.q = q;
	this.a = a;
	this.h = h;
}

public String getQ() {
	return q;
}

public void setQ(String q) {
	this.q = q;
}

public String getA() {
	return a;
}

public void setA(String a) {
	this.a = a;
}

public String getH() {
	return h;
}

public void setH(String h) {
	this.h = h;
}

@Override
public String toString() {
	return "Quote [q=" + q + ", a=" + a + ", h=" + h + "]";
}

}
