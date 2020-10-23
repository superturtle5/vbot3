import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.Reaction;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.event.message.reaction.ReactionAddEvent;

import java.util.List;

public class Poll {
        public static void vote(MessageCreateEvent m) {
            String content = m.getMessageContent();
            String[] words  = m.getMessage().getContent().split(" ");
            Server guild = m.getServer().get();
            ServerTextChannel channel = m.getServerTextChannel().get();
            User author = m.getMessageAuthor().asUser().get();
            Message mes = m.getMessage();
            int num;
            String[] alpha = {"🇦", "🇧", "🇨", "🇩", "🇪", "🇫", "🇬", "🇭", "🇮", "🇯", "🇰", "🇱", "🇲", "🇳", "🇴", "🇵", "🇶", "🇷", "🇸", "🇹", "🇺", "🇼", "🇽", "🇾", "🇿"};
            if(content.contains(Ref.prefix+"m ") || content.contains(Ref.prefix+"multiple")) {
                if(isNum(words[1], 2, 22)) {
                    num = Integer.parseInt(words[1]);
                    for(int i = 0; i < num; i ++) {
                         m.getMessage().addReaction(alpha[i]);
                    }
                } else
                    m.getChannel().sendMessage("Please use `<m (number of choices, 2 - 22) (your poll)`");
            }else if(content.contains(Ref.prefix+"p ") ||content.contains(Ref.prefix+"poll")) {
                react("✅", mes);
                react("\uD83D\uDD36", mes);
                react("❌", mes);

            }else if(content.contains(Ref.prefix+"y ") || content.contains(Ref.prefix+"yesno")){
                react("✅", mes);
                react("\uD83D\uDD36", mes);
                react("❌", mes);
            }else if(content.contains(Ref.prefix+"ap ") || content.contains(Ref.prefix+"apoll")) {

                Ref.votes.add(new Vote (content, mes.getIdAsString()));
                mes.delete();
                m.getChannel().sendMessage(content + " &" + findVote(mes.getIdAsString()).getIndex());
            } else if(words[0].equalsIgnoreCase(Ref.prefix + "result")) {
                Vote vote = findVote(words[1]);
                m.getChannel().sendMessage("**Here's what people said:**\n" + "Results of: __**" + vote.getVote() + "**__"
                        + "\n Yes: **" + vote.getYes() + "**" + "\n Maybe: **" + vote.getMaybe()
                        + "**\n No: **"+ vote.getNo() + "**");
            }
//        else if(m.getChannel().getId().equals("509375073958887424")) {
//            m.addReaction("✅").queue();
//            m.addReaction("🔶").queue();
//            m.addReaction("❌").queue();
//
//        }
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
        static void rec(ReactionAddEvent evt) {

            try {
                User u = evt.getUser().get();
                String m = evt.getEmoji().asUnicodeEmoji().get();
                Message mm = Mhistory.fetch(evt.getMessage().get().getIdAsString());
                String[] words = mm.getContent().split(" ");
                Vote vote = findVote(words[words.length - 1]);
                if(words[0].contains(Ref.prefix+"ap ") ||mm.getContent().contains(Ref.prefix+"apoll")) {
                }	if(m.equals("✅")) {
                    vote.addYes(evt.getUser().get());
                }else if (m.equals("🔶")) {
                    vote.addMaybe(evt.getUser().get());
                }else if(m.equals("❌")) {
                    vote.addNo(evt.getUser().get());
                }
                clear(mm, vote, evt.getReaction().get(), u);
            } catch(Exception e){
                System.out.println("we ran out of history :O {Poll: 90}");
            }

        }
        static void clear(Message mm, Vote vote, Reaction r, User u) {
            //String send = mm.getContentRaw() + " &" + vote.getIndex();
            r.removeUser(u);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mm.addReaction("✅"); mm.addReaction("🔶"); mm.addReaction("❌");
            //mm.getChannel().sendMessage(mm.getContent()).queue();
        }
        public static Vote findVote(String id) {
            List<Vote> votes = Ref.votes;
            for(Vote vote: votes) {
                if(vote.getId().equals(id)) {
                    return vote;
                }
            }
            int i = Integer.parseInt(id.substring(1));
            for(Vote vote: votes) {
                if(vote.getIndex() == i) {
                    return vote;
                }
            }
            return null;
        }
        public static void react(String reaction, Message message){
            message.addReaction(reaction);
        }
    }

