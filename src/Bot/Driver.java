package Bot;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import ENUMS.Embeds;
import EventHandlers.*;
import Reactions.reactionAdded;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


//https://discord.com/oauth2/authorize?client_id=860979122301698068&scope=bot&permissions=2148006976
public class Driver extends ListenerAdapter{
	
	public static String token;
	public static Pattern prefix;
	public static JdaMaker jdaMaker;
	public static String location = 
			System.getProperty("user.dir").equals("D:\\Eclipse Upgrade\\workspace\\Equations Bot")
			? "D:\\Eclipse Upgrade\\Equations Bot\\" : "";
	public static String myID = "251761821885792256";
	public static String botTestingId = "512859462307151872";
	public static String version = "0.1.0";
	public static String botAvatarUrl;
	public static MessageSave current;
	public static String backArrow = "861667379603963924";
	public static Map<String,Embeds> mainEmotes = new HashMap<String,Embeds>();
	public static String[] mainEmotesArr;
	public static Map<String,Embeds> physicsEmotes = new HashMap<String,Embeds>();
	public static String[] physicsEmotesArr;
	public static Map<String,Embeds> mechanicsEmotes = new HashMap<String,Embeds>();
	public static String[] mechanicsEmotesArr;
	public static Map<String,Embeds> thermalEmotes = new HashMap<String,Embeds>();
	public static String[] thermalEmotesArr;
	public static Map<String,Embeds> wavesEmotes = new HashMap<String,Embeds>();
	public static String[] wavesEmotesArr;
	public static Map<String,Embeds> emEmotes = new HashMap<String,Embeds>();
	public static String[] emEmotesArr;
	public static Map<String,Embeds> modernEmotes = new HashMap<String,Embeds>();
	public static String[] modernEmotesArr;
	public static Map<String,Embeds> geometryEmotes = new HashMap<String,Embeds>();
	public static String[] geometryEmotesArr;
	public static Map<String,Embeds> mathEmotes = new HashMap<String,Embeds>();
	public static String[] mathEmotesArr;
	public static Map<String,Embeds> statsEmotes = new HashMap<String,Embeds>();
	public static String[] statsEmotesArr;
	public static Map<String,Embeds> derivativeEmotes = new HashMap<String,Embeds>();
	public static String[] derivativeEmotesArr;
	public static Map<String,Embeds> integralEmotes = new HashMap<String,Embeds>();
	public static String[] integralEmotesArr;

	public static void main(String[] args) {

		//load startup data
		if(!getData()){
			System.out.println("Failed to load token, prefix, or website");
			return;
		}
		
		mainEmotesArr = mainEmotes(); physicsEmotesArr = physicsEmotes();
		mechanicsEmotesArr = mechanicsEmotes(); thermalEmotesArr = thermalEmotes();
		wavesEmotesArr = wavesEmotes(); emEmotesArr = emEmotes(); modernEmotesArr = modernEmotes();
		mathEmotesArr = mathEmotes(); geometryEmotesArr = geometryEmotes();
		statsEmotesArr = statsEmotes(); derivativeEmotesArr = derivativeEmotes();
		integralEmotesArr = integralEmotes();
		
		//bot maker class
		jdaMaker = new JdaMaker(token,prefix.toString() + "help");
		//create bot
		jdaMaker.constructJda();
		
		botAvatarUrl = jdaMaker.getJda().getSelfUser().getAvatarUrl();
		
		System.out.println("Location var set to " + location);
		System.out.println("Current version:" + version);
		
	}
	
	//////////////////////// Events ///////////////////////////////////////////////////
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        new GuildMessageReceived(event);
    }//ends message received event
	
	public void onMessageReactionAdd(MessageReactionAddEvent event) {
		if(event.getUser().isBot())
			return;
		new reactionAdded(event);
	}
	
	//////////////////////// Methods //////////////////////////////////////////////////
	
	//loads startup data and returns true if was successful
	private static boolean getData() {
		File file = new File(location + "startup.txt");
		try {
			Scanner scnr = new Scanner(file);
			prefix = Pattern.compile(scnr.nextLine(),Pattern.CASE_INSENSITIVE);
			token = scnr.nextLine();
			scnr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private static String[] mainEmotes() {
		mainEmotes.put("861393726110433280",Embeds.PHYSICS);
		mainEmotes.put("861393752757370890",Embeds.MATH);
		String[] arr = {"861393726110433280","861393752757370890"};
		return arr;
	}
	
	private static String[] physicsEmotes() {
		physicsEmotes.put("716468511806849067",Embeds.MECHANICS);//1
		physicsEmotes.put("716467615056265236",Embeds.THERMAL);//2
		physicsEmotes.put("716467864584060960",Embeds.WAVESOPTICS);//3
		physicsEmotes.put("716467958838460437",Embeds.EM);//4
		physicsEmotes.put("716468491359617104",Embeds.MODERN);//5
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960",
                "716467958838460437","716468491359617104"};
		return arr;
	}
	
	private static String[] mechanicsEmotes() {
		mechanicsEmotes.put("716468511806849067",Embeds.KINEMATICS);//1
		mechanicsEmotes.put("716467615056265236",Embeds.CENTRIPETALACCELERATION);//2
		mechanicsEmotes.put("716467864584060960",Embeds.IMPULSE);//3
		mechanicsEmotes.put("716467958838460437",Embeds.WORK);//4
		mechanicsEmotes.put("716468491359617104",Embeds.POWER);//5
		mechanicsEmotes.put("861671535433089055",Embeds.BERNOULLI);//6
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960",
                "716467958838460437","716468491359617104","861671535433089055"};
		return arr;
	}
	
	private static String[] thermalEmotes() {
		thermalEmotes.put("716468511806849067",Embeds.THERMOFIRST);//1
		thermalEmotes.put("716467615056265236",Embeds.ENTROPY);//2
		thermalEmotes.put("716467864584060960",Embeds.THERMOWORK);//3
		thermalEmotes.put("716467958838460437",Embeds.ENTHALPY);//4
		thermalEmotes.put("716468491359617104",Embeds.MAXWELLBOLTZMAN);//5
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960",
                "716467958838460437","716468491359617104"};
		return arr;
	}

	private static String[] wavesEmotes() {
		wavesEmotes.put("716468511806849067",Embeds.PERIODICWAVES);//1
		wavesEmotes.put("716467615056265236",Embeds.INTENSITY);//2
		wavesEmotes.put("716467864584060960",Embeds.INTENSITYLEVEL);//3
		wavesEmotes.put("716467958838460437",Embeds.INTERFERENCE);//4
		wavesEmotes.put("716468491359617104",Embeds.SNELL);//5
		wavesEmotes.put("861671535433089055",Embeds.DOPPLER);//6
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960",
                "716467958838460437","716468491359617104","861671535433089055"};
		return arr;
	}
	
	private static String[] emEmotes() {
		emEmotes.put("716468511806849067",Embeds.OHMS);//1
		emEmotes.put("716467615056265236",Embeds.CAPACITANCE);//2
		emEmotes.put("716467864584060960",Embeds.EPOWER);//3
		emEmotes.put("716467958838460437",Embeds.RESISTORS);//4
		emEmotes.put("716468491359617104",Embeds.BIOT);//5
		emEmotes.put("861671535433089055",Embeds.MAXWELLS);//6
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960",
                "716467958838460437","716468491359617104","861671535433089055"};
		return arr;
	}
	
	private static String[] modernEmotes() {
		modernEmotes.put("716468511806849067",Embeds.LORENTZ);//1
		modernEmotes.put("716467615056265236",Embeds.TIMEDILATION);//2
		modernEmotes.put("716467864584060960",Embeds.LENGTHCONTRACTION);//3
		modernEmotes.put("716467958838460437",Embeds.PHOTONENERGY);//4
		modernEmotes.put("716468491359617104",Embeds.SCHROEDINGER);//5
		modernEmotes.put("861671535433089055",Embeds.UNCERTAINTY);//6
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960",
                "716467958838460437","716468491359617104","861671535433089055"};
		return arr;
	}
	
	private static String[] geometryEmotes() {
		geometryEmotes.put("716468511806849067",Embeds.SPHEREA);//1
		geometryEmotes.put("716467615056265236",Embeds.SPHEREV);//2
		geometryEmotes.put("716467864584060960",Embeds.CYLINDERV);//3
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960"};
		return arr;
	}
	
	private static String[] mathEmotes() {
		mathEmotes.put("716468511806849067",Embeds.GEOMETRY);//1
		mathEmotes.put("716467615056265236",Embeds.STATS);//2
		mathEmotes.put("716467864584060960",Embeds.DERIVATIVES);//3
		mathEmotes.put("716467958838460437",Embeds.INTEGRALS);//4
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960",
                "716467958838460437"};
		return arr;
	}
	
	private static String[] statsEmotes() {
		statsEmotes.put("716468511806849067",Embeds.MEAN);//1
		statsEmotes.put("716467615056265236",Embeds.STDDEV);//2
		statsEmotes.put("716467864584060960",Embeds.CORRCOE);//3
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960"};
		return arr;
	}
	
	private static String[] derivativeEmotes() {
		derivativeEmotes.put("716468511806849067",Embeds.DSEC);//1
		derivativeEmotes.put("716467615056265236",Embeds.DCOS);//2
		derivativeEmotes.put("716467864584060960",Embeds.DCOT);//3
		derivativeEmotes.put("716467958838460437",Embeds.DARCSIN);//4
		derivativeEmotes.put("716468491359617104",Embeds.DARCCOS);//5
		derivativeEmotes.put("861671535433089055",Embeds.DARCTAN);//6
		derivativeEmotes.put("862749525432991754",Embeds.DARCCOT);//7
		derivativeEmotes.put("862749582983299112",Embeds.DARCSEC);//8
		derivativeEmotes.put("862749691233959977",Embeds.DARCCSC);//9
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960",
                "716467958838460437","716468491359617104","861671535433089055","862749525432991754",
                "862749582983299112","862749691233959977"};
		return arr;
	}
	
	private static String[] integralEmotes() {
		integralEmotes.put("716468511806849067",Embeds.ISEC);//1
		integralEmotes.put("716467615056265236",Embeds.ICOS);//2
		integralEmotes.put("716467864584060960",Embeds.ICOT);//3
		integralEmotes.put("716467958838460437",Embeds.IARCSIN);//4
		integralEmotes.put("716468491359617104",Embeds.IARCCOS);//5
		integralEmotes.put("861671535433089055",Embeds.IARCTAN);//6
		integralEmotes.put("862749525432991754",Embeds.IARCCOT);//7
		integralEmotes.put("862749582983299112",Embeds.IARCSEC);//8
		integralEmotes.put("862749691233959977",Embeds.IARCCSC);//9
		String[] arr = {backArrow,"716468511806849067","716467615056265236","716467864584060960",
                "716467958838460437","716468491359617104","861671535433089055","862749525432991754",
                "862749582983299112","862749691233959977"};
		return arr;
	}
	
}
