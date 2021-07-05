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
	//mechanics
	KINEMATICS,
	CENTRIPETALACCELERATION,
	IMPULSE,
	WORK,
	POWER,
	BERNOULLI,
	//thermal
	THERMOFIRST,
	ENTROPY,
	THERMOWORK,
	ENTHALPY,
	MAXWELLBOLTZMAN,
	//waves and optics
	PERIODICWAVES,
	INTENSITY,
	DOPPLER,
	INTERFERENCE,
	SNELL,
	INTENSITYLEVEL,
	//em
	OHMS,
	CAPACITANCE,
	EPOWER,
	RESISTORS,
	BIOT,
	MAXWELLS,
	//modern
	LORENTZ,
	TIMEDILATION,
	LENGTHCONTRACTION,
	PHOTONENERGY,
	SCHROEDINGER,
	UNCERTAINTY,
	;
	
	public static EmbedBuilder build(Embeds embed) {
		switch(embed){
			case MAIN:
				return buildMain();
			case PHYSICS:
				return buildPhysics();
			case MECHANICS:
				return buildMechanics();
			case THERMAL:
				return buildThermal();
			case WAVESOPTICS:
				return buildWaves();
			case EM:
				return buildEm();
			case MODERN:
				return buildModern();
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
	
	private static EmbedBuilder buildThermal() {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("Thermal:").setColor(Color.RED).setThumbnail(Driver.botAvatarUrl);
		eb.addField("First Law of Thermodynamics", "React with 1", false);
		eb.addField("Entorpy", "React with 2", false);
		eb.addField("Work", "React with 3", false);
		eb.addField("Enthalpy", "React with 4", false);
		eb.addField("Maxwell-Boltzmann Equation", "React with 5", false);
		return eb;
	}
	
	private static EmbedBuilder buildWaves() {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("Waves and Optics:").setColor(Color.BLUE).setThumbnail(Driver.botAvatarUrl);
		eb.addField("Periodic Waves", "React with 1", false);
		eb.addField("Intensity", "React with 2", false);
		eb.addField("Intensity Level", "React with 3", false);
		eb.addField("Doppler Effect", "React with 4", false);
		eb.addField("Interference Fringes", "React with 5", false);
		eb.addField("Snell's Law", "React with 6", false);
		return eb;
	}
	
	private static EmbedBuilder buildEm() {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("Electricity & Magnetism:").setColor(Color.YELLOW).setThumbnail(Driver.botAvatarUrl);
		eb.addField("Ohms Law", "React with 1", false);
		eb.addField("Capacitance", "React with 2", false);
		eb.addField("Power", "React with 3", false);
		eb.addField("Resistors", "React with 4", false);
		eb.addField("Biot-Savart Law", "React with 5", false);
		eb.addField("Maxwell's Equations", "React with 6", false);
		return eb;
	}
	
	private static EmbedBuilder buildModern() {
		EmbedBuilder eb = new EmbedBuilder();
		eb.setTitle("Modern:").setColor(Color.WHITE).setThumbnail(Driver.botAvatarUrl);
		eb.addField("Lorentz Factor", "React with 1", false);
		eb.addField("Time Dilation", "React with 2", false);
		eb.addField("Length Contraciton", "React with 3", false);
		eb.addField("Photon Energy", "React with 4", false);
		eb.addField("Schroedinger's Equation", "React with 5", false);
		eb.addField("Uncertainty Principle", "React with 6", false);
		return eb;
	}
}