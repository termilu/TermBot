package termilu.termbot;

import java.util.concurrent.ConcurrentHashMap;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import termilu.termbot.commands.ClearCommand;
import termilu.termbot.commands.NegRep;
import termilu.termbot.commands.PosRep;
import termilu.termbot.commands.types.ServerCommand;

public class CommandManager {

	public ConcurrentHashMap<String, ServerCommand> commands;
	
	public CommandManager() {
		
		this.commands = new ConcurrentHashMap<>();
		
		this.commands.put("clear", new ClearCommand());
		this.commands.put("rep", new NegRep());
		this.commands.put("+rep", new PosRep());
	}
	
	
	public boolean perform(String command, Member member, TextChannel channel, Message message) {
		
		ServerCommand cmd;
		if((cmd = this.commands.get(command.toLowerCase())) != null) {
			
			cmd.performCommand(member, channel, message);
			return true;
		}
		
		return false;
	}

}
