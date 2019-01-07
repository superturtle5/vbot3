package com.hello.FossilBotJava;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.core.entities.Message;

public class Count {
	public static void num(Message m) {
		if(!Bools.isAdmin(m)) {
			if(!Poll.isNum(m.getContentRaw(), 0, 99999) && m.getChannel().getName().equalsIgnoreCase("counting")) {
				m.delete().queueAfter(2, TimeUnit.SECONDS);
			}
		}
	}
}
