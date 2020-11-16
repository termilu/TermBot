package termilu.termbot;

import java.time.OffsetDateTime;
import java.util.concurrent.ConcurrentHashMap;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import termilu.termbot.commands.ClearCommand;
import termilu.termbot.commands.HelpCommand;
import termilu.termbot.commands.NegRep;
import termilu.termbot.commands.PosRep;
import termilu.termbot.commands.SnipeCommand;
import termilu.termbot.commands.types.ServerCommand;

public class CommandManager {

	public ConcurrentHashMap<String, ServerCommand> commands;
	
	public CommandManager() {
		
		this.commands = new ConcurrentHashMap<>();
		
		this.commands.put("clear", new ClearCommand());
		this.commands.put("rep", new NegRep());
		this.commands.put("+rep", new PosRep());
		this.commands.put("help", new HelpCommand());
		this.commands.put("snipe", new SnipeCommand());
	}
	
	
	public boolean perform(String command, Member member, TextChannel channel, Message message, OffsetDateTime time) {
		
		ServerCommand cmd;
		if((cmd = this.commands.get(command.toLowerCase())) != null) {
			
			cmd.performCommand(member, channel, message, time);
			return true;
		}
		
		return false;
	}

}
