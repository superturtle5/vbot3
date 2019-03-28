package com.hello.FossilBotJava;

public class Command {
	 private String com;
	 private String res;
	
	public  Command(String com, String res) {
		super();
		this.com = com;
		this.res = res;
	}
	
	public String getCom() {
		return com;
	}
	public void setCom(String com, String res) {
		this.com = com;
		this.res = res;
	}
	public String getRes() {
		return res;
	}
	
	
	
	
}
