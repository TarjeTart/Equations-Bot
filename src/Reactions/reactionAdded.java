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
		Boolean didBack = false;
		int level = isLowLevel(emote.getId(), current.getCurrent());
		if(emote.getId().equals(Driver.backArrow)) {
			nextEmbed = current.getPrev();
			didBack = true;
		}else if(level != -1){
			event.getChannel().sendMessage(Embeds.getEquation(current.getCurrent(), level).build()).queue();
			return;
		}else{
			Map<String,Embeds> map = new HashMap<String,Embeds>();
			switch(current.getCurrent()) {
				case MAIN:
					map = Driver.mainEmotes;
					break;
				case DERIVATIVES:
					map = Driver.derivativeEmotes;
					break;
				case EM:
					map = Driver.emEmotes;
					break;
				case GEOMETRY:
					map = Driver.geometryEmotes;
					break;
				case INTEGRALS:
					map = Driver.integralEmotes;
					break;
				case MATH:
					map = Driver.mathEmotes;
					break;
				case MECHANICS:
					map = Driver.mechanicsEmotes;
					break;
				case MODERN:
					map = Driver.modernEmotes;
					break;
				case PHYSICS:
					map = Driver.physicsEmotes;
					break;
				case STATS:
					map = Driver.statsEmotes;
					break;
				case THERMAL:
					map = Driver.thermalEmotes;
					break;
				case WAVESOPTICS:
					map = Driver.wavesEmotes;
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
		Driver.current.setDidBack(didBack);
		//add reactions
		String[] arr = null;
		switch(nextEmbed) {
			case MAIN:
				arr = Driver.mainEmotesArr;
				break;
			case DERIVATIVES:
				arr = Driver.derivativeEmotesArr;
				break;
			case EM:
				arr = Driver.emEmotesArr;
				break;
			case GEOMETRY:
				arr = Driver.geometryEmotesArr;
				break;
			case INTEGRALS:
				arr = Driver.integralEmotesArr;
				break;
			case MATH:
				arr = Driver.mathEmotesArr;
				break;
			case MECHANICS:
				arr = Driver.mechanicsEmotesArr;
				break;
			case MODERN:
				arr = Driver.modernEmotesArr;
				break;
			case PHYSICS:
				arr = Driver.physicsEmotesArr;
				break;
			case STATS:
				arr = Driver.statsEmotesArr;
				break;
			case THERMAL:
				arr = Driver.thermalEmotesArr;
				break;
			case WAVESOPTICS:
				arr = Driver.wavesEmotesArr;
				break;
			default:
				break;
		}
		int count = 0;
		for(String i : arr) {
			if((count == 0 && Driver.current.isDidBack()) && Driver.current.getCurrent() != Embeds.MAIN) {
				count++;
			}else {
				sentMessage.addReaction(event.getJDA().getGuildById(Driver.botTestingId).getEmoteById(i)).queue();
			}
		}
	}
	
	private int isLowLevel(String id, Embeds e) {
		if(e == Embeds.MAIN || e == Embeds.PHYSICS || e == Embeds.MATH) {
			return -1;
		}
		switch(id) {
			case "716468511806849067":
				return 1;
			default:
				return -1;
		}
		/* || id.equals("716467615056265236")2
				|| id.equals("716467864584060960")3 || id.equals("716467958838460437")4
				|| id.equals("716468491359617104")5 || id.equals("861671535433089055")6
				|| id.equals("862749525432991754")7 || id.equals("862749582983299112")8
				|| id.equals("862749691233959977")9;*/
	}
	
}