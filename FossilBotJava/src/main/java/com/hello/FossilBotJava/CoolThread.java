package com.hello.FossilBotJava;

import java.io.IOException;
import java.util.List;

import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Role;

public class CoolThread implements Runnable{
	
	String name;
	Thread thre; 
	
	CoolThread(String tName){
		name = tName;
		thre = new Thread(this, tName);
		
		//System.out.println("new thread! " + tName);
		thre.start();
	}
	public Thread getThread() {
		return this.thre;
	}
	
	public void run() {
		if(this.name.equals("One")) {
			threadOneRun();
		}
		if(this.name.equals("Two")) {
			threadTwoRun();
		}
		if(this.name.equals("Three")) {
			threadThreeRun();
		}
		
		
	}
	
	public static void threadOneRun() {
		System.out.println("Thread One Stating: \n handleing: \"most things\"");
		

	}
	public static void threadTwoRun() {
		System.out.println("Thread Two Stating: \n handleing: \"Message History\"");
	}
	public static void threadThreeRun() {
		System.out.println("Thread Three Stating: \n handleing: \"RGB Update\"");
		int restTim = 0;
		List<Member> mem;
		Role top;
		List<Role> rs;
		Guild g = Ref.bigMain;

		while(true) {
//			System.out.println("RGB tick");
//			mem = Ref.bigMain.getMembers();
//			for(Member tar : mem) {
//				try {
//					if((tar.getOnlineStatus().equals(OnlineStatus.ONLINE) || tar.getOnlineStatus().equals(OnlineStatus.IDLE)) && Rgb.isOnList(tar)) {
//						System.out.println("Attmting to update " + tar.getAsMention() + "\n" + tar.getRoles().toString());
//						Rgb.update(tar, 9);
//					}			
//				} catch (IOException e) {}
//			}
			rs = g.getRoles();
			System.out.println(rs.get(rs.size() - 10));
			top = rs.get(rs.size() - 10);
			g.getController().modifyRolePositions().selectPosition(top).moveTo(0).queue();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {}
		}
	}
		
}
