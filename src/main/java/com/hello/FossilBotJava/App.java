package com.hello.FossilBotJava;


import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.channel.priv.PrivateChannelCreateEvent;
import net.dv8tion.jda.core.events.message.MessageDeleteEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.events.message.guild.react.GuildMessageReactionAddEvent;

public class App extends ListenerAdapter 
{
	
    public static void main(String[] args) throws Exception 
    {
	JDA jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking();
       jda.addEventListener(new App());
    }
   
    @Override
    public void  onMessageDelete(MessageDeleteEvent evt) {
   	 Delete.log(evt);
   }
   
    	

     
    public void onGuildMessageReceived(GuildMessageReceivedEvent evt) {
    	Clear.logClear(evt);
    	Mhistory.record(evt.getMessage());
    	if(evt.getAuthor().isBot()) {
    		Poll.ree(evt);
    		return;
    	}
    	Uncrust.bul(evt.getMessage());
    	Console.see();
    	Hello.hi(evt.getMessage());
    	//Trivia.guess(evt);
    	Ping.pong(evt.getMessage());
    	Poll.vote(evt.getMessage());
    	Portal.warp(evt);
    	Count.num(evt.getMessage());
    	//Poll.check();
    	//Control.look(evt);
    	if(evt.getMessage().getGuild().getName().equalsIgnoreCase("Testing")){
			Ref.main = evt.getMessage().getGuild();
			//System.out.println("SET MAIN");
		}
    }
 public static void onPrivateChannelCreated(PrivateChannelCreateEvent evt) {
    	Hello.t(evt);
    	
   }
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent evt) {
    	if(evt.getUser().isBot()) {
    		return;
    	}
    	Poll.rec(evt);
    	
    }
    
    
}
   

 



   

