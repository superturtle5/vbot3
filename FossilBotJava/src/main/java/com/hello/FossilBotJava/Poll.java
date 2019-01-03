package com.hello.FossilBotJava;

import net.dv8tion.jda.core.entities.Message;

public class Poll {
	public static void vote(Message m) {
		String[] words = m.getContentRaw().split(" ");
		int num;
		String[] alpha = {"🇦", "🇧", "🇨", "🇩", "🇪", "🇫", "🇬", "🇭", "🇮", "🇯"};
		if(m.getContentRaw().contains(Ref.prefix+"m") || m.getContentRaw().contains(Ref.prefix+"multiple")) {
				if(isNum(words[1], 2, 11)) {
					num = Integer.parseInt(words[1]);
					for(int i = 0; i < num; i ++) {
						m.addReaction(alpha[i]).queue();
					}
				} else
					m.getChannel().sendMessage("Please use `<m (number of choices, 2 - 10) (your poll)`").queue();
		}if(m.getContentRaw().contains(Ref.prefix+"p") ||m.getContentRaw().contains(Ref.prefix+"poll")) {
			System.out.println("LOOK");
			m.addReaction("✅").queue();
    		m.addReaction("🔶").queue();
    		m.addReaction("❌").queue();
		}if( m.getContentRaw().contains(Ref.prefix+"y") ||m.getContentRaw().contains(Ref.prefix+"yesno")){
			m.addReaction("✅").queue();
			m.addReaction("❌").queue();
		}
	}
	static boolean isNum(String num, int min, int max) {
		boolean n = false;
		for(int i = min; i < max; i++) {
			if(num.equals(Integer.toString(i))) {
				n = true;
			}
		}
		if(n) {
			return true;
		} else {
			return false;
		}
	}
}
