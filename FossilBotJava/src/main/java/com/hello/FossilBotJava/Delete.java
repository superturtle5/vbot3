package com.hello.FossilBotJava;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.audit.ActionType;
import net.dv8tion.jda.core.audit.AuditLogEntry;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageDeleteEvent;

public class Delete {

	public static void log(MessageDeleteEvent evt) {
		 String msgId = evt.getMessageId();
	     List<AuditLogEntry> res = evt.getGuild().getAuditLogs().complete();
	     AuditLogEntry audit = res.get(0);
	     User mem = audit.getUser();     
	   	 Message msg = null;
	   	 Message[] msgs = Mhistory.hs;
	   	 for(int i = 0; i < Mhistory.hs.length - 1; i++) {
	   		 if(msgs[i] !=null) {
	   			 if(msgs[i].getId().equals(msgId)) {
	   				 msg = msgs[i];
	   			}
	   		 }
	   	 }
//	   	 System.out.println(msg + " != null");
//	   	 System.out.println(audit.getType());
//	   	 System.out.println(audit.getTargetId() + " == " + msg.getAuthor().getId());
	   	 if(msg != null && audit.getType().equals(ActionType.MESSAGE_DELETE) && audit.getTargetId().equals(msg.getAuthor().getId())) {
	   		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	   		SimpleDateFormat stf = new SimpleDateFormat("hh:mm a");
	   		Date date = new Date (System.currentTimeMillis());
	   		EmbedBuilder builder = new EmbedBuilder();
	   		builder.setTitle(mem.getName()+" has deleted `"+ msg.getContentRaw() + "` by "+ msg.getAuthor().getName());
	   		builder.setColor(Color.decode("#EA2029"));
	   		builder.setDescription("in "+ msg.getChannel().getName() + " " + sdf.format(date)+ " at " + stf.format(date));
	   		builder.setAuthor(mem.getName(), mem.getAvatarUrl(), mem.getAvatarUrl());
	   		builder.setThumbnail("https://cdn1.iconfinder.com/data/icons/round-ui/123/47-512.png");
	   		Ref.here.sendMessage(builder.build()).queue();
	   	}
	}
	
}
