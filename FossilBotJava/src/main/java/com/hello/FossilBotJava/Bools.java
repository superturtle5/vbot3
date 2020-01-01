package com.hello.FossilBotJava;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;

public class Bools {
	public static boolean isAdmin(Message m) {
		 if(m.getGuild().getMemberById(m.getAuthor().getId()).hasPermission(Permission.ADMINISTRATOR)){
				return true;
			}else {
				return false;
			}
	}
}

