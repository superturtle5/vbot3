import org.javacord.api.entity.channel.ServerTextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.server.ServerUpdater;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import java.awt.*;
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
            //nhs = 793336579883270194
            // testing = 662008568731533332
             dead = guild.getRoleById("793336579883270194").get();
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

            tar.removeRole(dead);
            m.getChannel().sendMessage("Fine- ill revive them... for now");
        }
        if(words[0].equalsIgnoreCase(Ref.prefix + "link")) {
            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle("Title")
                    .setDescription("Description")
                    .setAuthor("Author Name", "http://google.com/", "https://cdn.discordapp.com/embed/avatars/0.png")
                    .addField("A field", "Some text inside the field")
                    .addInlineField("An inline field", "More text")
                    .addInlineField("Another inline field", "Even more text")
                    .setColor(Color.BLUE)
                    .setFooter("Footer", "https://cdn.discordapp.com/embed/avatars/1.png")
                    .setImage("https://cdn.britannica.com/s:800x450,c:crop/66/195966-138-F9E7A828/facts-turtles.jpg")
                    .setThumbnail("data:image/jpeg;base64,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");

            m.getChannel().sendMessage(embed);

             new MessageBuilder()
                    .setEmbed(new EmbedBuilder()
                            .setTitle("Click Me!")
                            .setDescription("Really cool pictures!")
                            .setUrl("google.com")
                            .setColor(Color.ORANGE))
                    .send(channel);


            System.out.println(m.getChannel());
            System.out.println("got oyur thing  \n" + embed.toString());
        }
        if(words[0].equalsIgnoreCase(Ref.prefix + "kill")) {

           // controller.addRoleToUser(author, dead).update();

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
           tar.addRole(dead);
            try {
                Thread.sleep(300000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tar.removeRole(dead);
        }).start();
    }

}
