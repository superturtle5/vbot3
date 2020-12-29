


import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.server.ServerUpdater;
import org.javacord.api.entity.user.User;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.event.message.MessageCreateEvent;


public class Console {

    public static void see(MessageCreateEvent commandRaw) {
        User author = commandRaw.getMessageAuthor().asUser().get();
        String command = commandRaw.getMessage().getContent();

        if (author.isBotOwner() || command.contains(Ref.prefix)) {
            Server guild = Ref.bigMain;
            TextChannel channel = commandRaw.getChannel();
            ServerUpdater controller = new ServerUpdater(guild);
            String[] sCom = command.split(" ");
            User tar;

            if (author.isBotOwner()) {
//            System.out.println(sCom[1]);

                try {
                    tar = guild.getMembersByName(sCom[1]).iterator().next();
                    System.out.println(tar);
                } catch (Exception e) {
                    tar = null;
                }
               // System.out.println(tar);

                if (sCom[0].equals("say")) {
                    guild.getTextChannelsByNameIgnoreCase(sCom[1]).get(0).sendMessage(combine(sCom));
                    send(("sent " + combine(sCom) + " to " + sCom[1]), channel);

                } else if (sCom[0].equals("res")) {
                    author.addRole(guild.getRolesByNameIgnoreCase("LORD").get(0));
                    send("gave you the lord role", channel);
                } else if (sCom[0].equals("echo")) {
                    channel.sendMessage(combine(sCom));
                } else if (sCom[0].equals("admin")) {
                    channel.sendMessage("not ready yet");
                } else if (sCom[0].equals("mute")) {
                    tar.mute(guild);
                    send(("muted " + tar.getNickname(guild)), channel);
                } else if (sCom[0].equals("unmute")) {
                    tar.unmute(guild);
                    send(("muted " + tar.getNickname(guild)), channel);

                } else if (sCom[0].equals("deaf")) {
                    tar.deafen(guild);
                    send(("deafened " + tar.getNickname(guild)), channel);
                } else if (sCom[0].equals("undeaf")) {
                    tar.undeafen(guild);
                    send(("undeafened " + tar.getNickname(guild)), channel);
                } else if (sCom[0].equals("nick")) {
                    tar.updateNickname(guild, combine(sCom));
                    send(("Nicknamed " + tar.getNickname(guild)) + " " + combine(sCom), channel);
                } else if (sCom[0].equals("kill")) {
                    Role dead = guild.getRolesByNameIgnoreCase("dead").get(0);

                    Hello.kill(tar, controller, dead);
                    send(("Terminated " + tar.getNickname(guild)), channel);
                } else if (sCom[0].equals("kick")) {

                } else if (sCom[0].equals("ban")) {


                } else if (sCom[0].equals("create")) {
                    guild.createTextChannelBuilder().setName(sCom[1]).create();
                    send(("created " + sCom[1]), channel);

                } else if (sCom[0].equals("createV")) {
                    guild.createVoiceChannelBuilder().setName(sCom[1]).create();
                    send(("created " + sCom[1]), channel);

                } else if (sCom[0].equals("move")) {
                    tar.move(guild.getVoiceChannelsByNameIgnoreCase(sCom[2]).get(0));
                    send(("moved " + tar.getNickname(guild) + " to " + sCom[2]), channel);

                } else if (sCom[0].equals("del")) {
                    Mhistory.fetch(sCom[1]).delete();
                    send(("deleted"), channel);
                }
            }
            if (guild.canManage(author) && command.contains(Ref.prefix)) {
                tar = commandRaw.getMessage().getMentionedUsers().get(0);
                int time;

                if (sCom.length <= 2) {
                    time = 60000;
                } else {
                    time = (int) (60000*Float.parseFloat(sCom[2]));
                }

                if (sCom[0].equals(Ref.prefix + "mute")) {
                    //test = "482679182829289472"
                    Role mute = guild.getRoleById("482679182829289472").get();
                    User target = tar;
                    new Thread(() -> {
                        target.addRole(mute);
                        try {
                            Thread.sleep(time );
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        target.removeRole(mute);
                    }).start();
                }
            }
        }
    }
    static String combine(String[] words) {
        String fin = "";
        words[0] = "";
        words[1] = "";
        for (String word : words) {
            fin+=(" " + word);
        }
        return fin;
    }
    static void send(String s, TextChannel c) {
        c.sendMessage(s);
    }
}
