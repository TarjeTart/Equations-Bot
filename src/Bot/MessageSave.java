package Bot;

import ENUMS.*;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;

public class MessageSave {

	private Embeds prev,current;
	private Message message;
	private User user;
	private MessageChannel channel;
	boolean isGuild;
	boolean didBack;
	
	public boolean isDidBack() {
		return didBack;
	}

	public void setDidBack(boolean didBack) {
		this.didBack = didBack;
	}

	public MessageSave(Embeds prev,Embeds current, Message message, User user, MessageChannel channel, boolean didBack) {
		super();
		this.prev = prev;
		this.message = message;
		this.user = user;
		this.channel = channel;
		this.setCurrent(current);
		isGuild = message.isFromType(ChannelType.TEXT);
		this.didBack = didBack;
	}

	public Embeds getPrev() {
		return prev;
	}

	public void setPrev(Embeds prev) {
		this.prev = prev;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MessageChannel getChannel() {
		return channel;
	}

	public void setChannel(TextChannel channel) {
		this.channel = channel;
	}

	public Embeds getCurrent() {
		return current;
	}

	public void setCurrent(Embeds current) {
		this.current = current;
	}
	
	

}