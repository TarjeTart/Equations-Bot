package ENUMS;

import java.awt.Color;
import Bot.Driver;
import net.dv8tion.jda.api.EmbedBuilder;

public enum Embeds {

	//Main
	MAIN,
	//Subjects
	PHYSICS,
	MATH,
	//Phys Fields
	MECHANICS,
	THERMAL,
	WAVESOPTICS,
	EM,
	MODERN,
	//Math Fields
	GEOMETRY,
	STATS,
	DERIVATIVES,
	INTEGRALS,
	KINEMATICS,
	CENTRIPETALACCELERATION,
	IMPULSE,
	WORK,
	POWER,
	BERNOULLI;
	
	public static EmbedBuilder build(Embeds embed) {
		switch(embed){
			case MAIN:
				return buildMain();
			case PHYSICS:
				return buildPhysics();
			case MECHANICS:
				return buildMechanics();
			default:
				return null;
		}
	}
	
	private static EmbedBuilder buildMain() {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("Fields:").setColor(Color.BLACK).setThumbnail(Driver.botAvatarUrl);
		eb.addField("Physics", "React with P", false);
		eb.addField("Mathematics", "React with M", false);
		return eb;
	}
	
	private static EmbedBuilder buildPhysics(){
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("Physics:").setColor(Color.GREEN).setThumbnail(Driver.botAvatarUrl);
		eb.addField("Mechanics", "React with 1", false);
		eb.addField("Thermal", "React with 2", false);
		eb.addField("Waves and Optics", "React with 3", false);
		eb.addField("Electricity & Magnetism", "React with 4", false);
		eb.addField("Modern", "React with 5", false);
		return eb;
	}
	
	private static EmbedBuilder buildMechanics() {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("Mechanics:").setColor(Color.BLACK).setThumbnail(Driver.botAvatarUrl);
		eb.addField("Kinematics", "React with 1", false);
		eb.addField("Centripetal Acceleration", "React with 2", false);
		eb.addField("Impulse", "React with 3", false);
		eb.addField("Work", "React with 4", false);
		eb.addField("Power", "React with 5", false);
		eb.addField("Bernoulli's Equation", "React with 6", false);
		return eb;
	}
	
}