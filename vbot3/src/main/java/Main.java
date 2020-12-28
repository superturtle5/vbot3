import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.Message;


 public class Main {
        public static void main(String[] args) throws Exception {
            DiscordApi api = new DiscordApiBuilder().setToken(Ref.token).login().join();
            api.addMessageCreateListener(event -> {
                if(event.getMessage().getUserAuthor().get().isYourself() && event.getMessage().getContent().contains("<ap")){
                    Message mes = event.getMessage();
                    Poll.react("✅", mes);
                    Poll.react("\uD83D\uDD36", mes);
                    Poll.react("❌", mes);
                    return;
                }
                if(event.getMessage().getUserAuthor().get().isBot()){
                    return;
                }
              Hello.hi(event);
              Mhistory.record(event);
              Poll.vote(event);
            });
            api.addReactionAddListener(event -> {
                if(event.getUser().get().isBot()){
                    return;
                }
                Poll.rec(event);
            });


        }
 }

