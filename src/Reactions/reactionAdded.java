package Reactions;

import java.util.HashMap;
import java.util.Map;

import Bot.Driver;
import Bot.MessageSave;
import ENUMS.Embeds;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

public class reactionAdded {

	MessageReactionAddEvent event;
	
	public reactionAdded(MessageReactionAddEvent event) {
		//basic data
		this.event = event;
		Emote emote = event.getReactionEmote().getEmote();
		MessageSave current = Driver.current;
		//delete current message
		current.getMessage().delete().queue();
		//send new message
		Embeds nextEmbed = null;
		System.out.println("current: " + current.getCurrent());
		System.out.println("prev: " + current.getPrev());
		if(emote.getId().equals(Driver.backArrow)) {
			nextEmbed = current.getPrev();
		}else {
			Map<String,Embeds> map = new HashMap<String,Embeds>();
			switch(current.getCurrent()) {
				case MAIN:
					map = Driver.mainEmotes;
					break;
				case DERIVATIVES:
					break;
				case EM:
					break;
				case GEOMETRY:
					break;
				case INTEGRALS:
					break;
				case MATH:
					break;
				case MECHANICS:
					map = Driver.mechanicsEmotes;
					break;
				case MODERN:
					break;
				case PHYSICS:
					map = Driver.physicsEmotes;
					break;
				case STATS:
					break;
				case THERMAL:
					break;
				case WAVESOPTICS:
					break;
				default:
					break;
			}
			nextEmbed = map.get(emote.getId());
		}
		Message sentMessage =
				current.getChannel().sendMessage(Embeds.build(nextEmbed).build()).complete();
		//save sent message
		Driver.current.setPrev(current.getCurrent());
		Driver.current.setCurrent(nextEmbed);
		Driver.current.setMessage(sentMessage);
		//add reactions
		String[] arr = null;
		switch(nextEmbed) {
			case MAIN:
				arr = Driver.mainEmotesArr;
				break;
			case DERIVATIVES:
				break;
			case EM:
				break;
			case GEOMETRY:
				break;
			case INTEGRALS:
				break;
			case MATH:
				break;
			case MECHANICS:
				arr = Driver.mechanicsEmotesArr;
				break;
			case MODERN:
				break;
			case PHYSICS:
				arr = Driver.physicsEmotesArr;
				break;
			case STATS:
				break;
			case THERMAL:
				break;
			case WAVESOPTICS:
				break;
			default:
				break;
		}
		for(String i : arr) {
			sentMessage.addReaction(event.getJDA().getGuildById(Driver.botTestingId).getEmoteById(i)).queue();
		}
	}
	
}