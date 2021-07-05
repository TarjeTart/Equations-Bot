package MessageCommands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Bot.Driver;
import Bot.MessageSave;
import ENUMS.Embeds;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class GuildSearchCommand implements Interfaces.Command{

	private GuildMessageReceivedEvent event;
	private String msg;
	private User user;
	private Guild guild;
	private JDA jda;
	private TextChannel channel;
	private Pattern p;
	private Matcher m;
	
	public GuildSearchCommand(GuildMessageReceivedEvent event) {
		msg = event.getMessage().getContentDisplay();
		this.event = event;
	}
	
	@Override
	public void run() {
		getInfo();
		//build and send main message
		Message sentMessage = channel.sendMessage(Embeds.build(Embeds.MAIN).build()).complete();
		//save message
		Driver.current = new MessageSave(null,Embeds.MAIN,sentMessage,user,channel);
		//add main reactions
		for(String i : Driver.mainEmotesArr) {
			sentMessage.addReaction(jda.getGuildById(Driver.botTestingId).getEmoteById(i)).queue();
		}
	}

	@Override
	public boolean check() {
		p = Pattern.compile(Driver.prefix.toString() + "search",Pattern.CASE_INSENSITIVE);
		m = p.matcher(msg);
		return m.find();
	}

	
	
	@Override
	public String getName() {
		return Driver.prefix.toString() + "search";
	}

	@Override
	public String getDescription() {
		return "used to begin searching for equations";
	}

	@Override
	public void getInfo() {
		user = event.getAuthor();
		guild = event.getGuild();
		jda = event.getJDA();
		jda.getGuildById(guild.getId()).retrieveMember(user).complete();
		channel = event.getChannel();
	}

}
