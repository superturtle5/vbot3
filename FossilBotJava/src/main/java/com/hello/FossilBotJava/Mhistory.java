package com.hello.FossilBotJava;

import java.io.IOException;

import net.dv8tion.jda.core.entities.Message;

public class Mhistory {
	static String filePath = "H:/discordMsg.txt";
	public static int numOn = 0;
	public static void record(Message m) {
		if(m.getGuild().getName().equalsIgnoreCase("NHS") || m.getGuild().getName().equalsIgnoreCase("Testing")) {
			if(numOn >= hs.length - 1) {
				numOn = 0;
			}
		hs[numOn] = m;
		System.out.println("logged: " + m.getContentRaw() + " | " + m.getAuthor().getName() + " | "+ m.getGuild().getName() + "-" + m.getChannel().getName() + " | " + numOn);
		try {
			WriteFile data = new WriteFile( filePath , true );
			data.writeToFile(m.getContentRaw() + " | " + m.getAuthor().getName() + " | "+ m.getGuild().getName() + "-" + m.getChannel().getName() + " | " + numOn);
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		
		numOn++;
		} else {
			System.out.println("saw: " + m.getContentRaw() + " | " + m.getAuthor().getName() + " | "+ m.getGuild().getName() + "-" + m.getChannel().getName() + " | " + numOn);
		}
	}
	public static Message[] hs = {
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null,
			null,
			null,
			null, 
			null,
			null};
	}
