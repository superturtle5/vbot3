package com.hello.FossilBotJava;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Ping extends ListenerAdapter {
	 public static void pong(Message m) {
		 String[] words  = m.getContentRaw().split(" ");
	
		if(words[0].equalsIgnoreCase(Ref.prefix+"ping")) {
			 	m.getChannel().sendMessage("Pong!").queue();
		}if(m.getGuild().getName().equalsIgnoreCase("Testing")){
			Ref.main = m.getGuild();
			System.out.println("SET MAIN");
		}
	}
}
