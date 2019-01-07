package com.hello.FossilBotJava;


import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageDeleteEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Hello world!
 *
 */
public class App extends ListenerAdapter 
{
	
    public static void main( String[] args ) throws Exception 
    {
	JDA jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking();
       jda.addEventListener(new App());
    }
   
    @Override
    public void  onMessageDelete(MessageDeleteEvent evt) {
   	 Delete.log(evt);
   }
     
    public void onMessageReceived(MessageReceivedEvent evt) {
    	Clear.logClear(evt);
    	Mhistory.record(evt.getMessage());
    	if(evt.getAuthor().isBot()) {
    		return;
    	}
    	Console.see();
    	Hello.hi(evt.getMessage());
    	Trivia.guess(evt);
    	Ping.pong(evt.getMessage());
    	Poll.vote(evt.getMessage());
    	Portal.warp(evt);
    	Count.num(evt.getMessage());
    }
}
   

 



   

