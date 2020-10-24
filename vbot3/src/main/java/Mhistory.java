import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class Mhistory {
        static String filePath = "Archive/discord.txt";
        public static int numOn = 0;
        public static void record(MessageCreateEvent m ) {
            String content = m.getMessage().getContent();
            Server guild = m.getServer().get();
            User author = m.getMessageAuthor().asUser().get();

            if(guild.getName().equalsIgnoreCase("NHS") || guild.getName().equalsIgnoreCase("Testing")|| guild.getName().equalsIgnoreCase("testII")) {
                if(numOn >= hs.length - 1) {
                    numOn = 0;
                }
                hs[numOn] = m.getMessage();
                System.out.println("logged: " + content + " | " + author.getNickname(guild) + " (" + author.getName() + ") "+ " | "+ guild.getName() + "-" + m.getServerTextChannel().toString() + " | " + m.getMessage().getCreationTimestamp() + " | " + m.getMessage().getIdAsString());
                try {
                    WriteFile data = new WriteFile( filePath , true );
                    data.writeToFile(content + " | " + author.getNickname(guild) + " (" + author.getName() + ") "+ " | "+ guild.getName() + "-" + m.getServerTextChannel().toString() + " | " + m.getMessage().getCreationTimestamp() + " | " + m.getMessage().getIdAsString());
                }catch(IOException e) {
                    //System.out.println(e.getMessage());
                }


                numOn++;
            } else {
                System.out.println("saw: " +content + " | " + author.getNickname(guild).get() + " (" + author.getName() + ") "+ " | "+ guild.getName() + "-" + m.getServerTextChannel().get().getName() + " | " + m.getMessage().getCreationTimestamp() + " | " + m.getMessage().getIdAsString());
            }
        }
        public static Message fetch(String msgId) {
            Message msg = null;
            Message[] msgs = hs;
            for(int i = 0; i < hs.length - 1; i++) {
                if(msgs[i] !=null) {
                    if(msgs[i].getIdAsString().equals(msgId)) {
                        msg = msgs[i];
                        return msg;
                    }
                }
            }
            return null;
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

