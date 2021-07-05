package EventHandlers;

import java.util.ArrayList;

import Bot.*;
import MessageCommands.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import Interfaces.Command;

public class GuildMessageReceived {

	private static ArrayList<Command> commands = new ArrayList<Command>();

	public GuildMessageReceived(GuildMessageReceivedEvent event) {
		
		//string version of message
		String msg = event.getMessage().getContentDisplay();
		
		//checks if this is an attepted command
		if(!Driver.prefix.matcher(msg).find()) {
			return;
		}
		
		//add all bot commands to commands list
		GuildSearchCommand searchCommand = new GuildSearchCommand(event);
		commands.add(searchCommand);
		
		//check message
		if(searchCommand.check())
			searchCommand.run();
		
		//help command
		if(event.getMessage().getContentDisplay().equalsIgnoreCase(Driver.prefix.toString() + "help"))
			new HelpCommand(commands,event);
	}
	
}