import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.server.ServerUpdater;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;

import java.util.concurrent.TimeUnit;

public class Hello {
    public static void hi(MessageCreateEvent m) {


        //System.out.println(Mhistory.fetch(m.getId()));
        String[] words  = m.getMessage().getContent().split(" ");
        Server guild = m.getServer().get();
        ServerTextChannel channel = m.getServerTextChannel().get();
        User author = m.getMessageAuthor().asUser().get();
        ServerUpdater controller = new ServerUpdater(guild);
        Role dead = null;
        User tar = null;
        try{
             dead = guild.getRolesByName("Dead").get(0);
             tar = m.getMessage().getMentionedUsers().get(0);
        }catch(Exception e){

        }

        // System.out.println(Ref.votes);
        if(words[0].equalsIgnoreCase(Ref.prefix+"hello")
                || words[0].equalsIgnoreCase(Ref.prefix+"hi")
                || words[0].equalsIgnoreCase(Ref.prefix+"sup")
                || words[0].equalsIgnoreCase(Ref.prefix+"yo")
                || words[0].equalsIgnoreCase(Ref.prefix+"good morning")) {
           channel.sendMessage("greetigns!");

        }
        if(guild.getTextChannelById("482384287513968665") != null) {
            Ref.here = guild.getTextChannelById("482384287513968665").get();
        } if(words[0].equalsIgnoreCase(Ref.prefix + "die")) {
            channel.sendMessage("Beatings!");
        } if(words[0].equalsIgnoreCase(Ref.prefix + "spam100 21234")) {
            m.deleteMessage();
            for(int I = 0; I <= 100; I++) {
                m.getChannel().sendMessage("spam: " + I);
            }
        }

        if(words[0].equalsIgnoreCase(Ref.prefix + "unkill")) {

            controller.removeRoleFromUser(tar, dead).update();

            m.getChannel().sendMessage("Fine- ill revive them... for now");
        }
        if(words[0].equalsIgnoreCase(Ref.prefix + "kill")) {

            controller.addRoleToUser(author, dead).update();

            if(author.canManageRole(dead)||author.isBotOwner()) {
                kill(tar, controller, dead);
                channel.sendMessage(tar.getMentionTag() + " has be terminated!");
            }else if(author.getRoles(guild).contains(dead)){
                m.getChannel().sendMessage("You are dead. Dead people can't kill people");
            }else if(tar.getRoles(guild).contains(dead)) {
                m.getChannel().sendMessage("They're already dead- should I kill you instead? hmmmm... i'll spare you for now");
            }else if(tar.getName().equals("chuck")) {
                kill(tar, controller, dead);
                channel.sendMessage("Charlie!! I've always wanted to kill Charlie!");
            } else {
                m.getChannel().sendMessage("You do not have permission to use this command. You will now be exterminated <3");
                kill(author, controller, dead);
            }


        }
    }

    public static void kill(User tar, ServerUpdater updater, Role dead) {
        new Thread(() -> {
            updater.addRoleToUser(tar,dead).update();

            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            updater.removeRoleFromUser(tar,dead).update();
        }).start();

    }

}
