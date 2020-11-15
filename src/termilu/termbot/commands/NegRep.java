package termilu.termbot.commands;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import termilu.termbot.commands.types.ServerCommand;

public class NegRep implements ServerCommand {

	@Override
	public void performCommand(Member m, TextChannel channel, Message message) {
		
		if(m.hasPermission(channel, Permission.ADMINISTRATOR)) {
			String[] args = message.getContentDisplay().split(" ");
			
			//-rep @termilu#9999
			if(args.length == 2) {
				channel.sendMessage("-rep added for " + message.getContentRaw().substring(5)).queue();
				channel.addReactionById(message.getId(), "☹️").queue(); 
				return;
				
			}else if(args.length == 1) {
				channel.sendMessage("Please mention ONE person.").queue();
			}else if(args.length > 2) {
				channel.sendMessage("Currently multi rep'ing is not yet available").queue();					//currently also sees people with space in their name
																												//as 3+ args, needs fixing
				
	//		}else if(((User) message.getMentionedUsers()).isBot()) {											//isBot check still needs some work 																								
	//			channel.sendMessage("We don't rep bots around here aight?").queue();						
			}else {
				channel.sendMessage("Damn something went wrong, try again!").queue();							//Fail-Safe
			}
		}
	}
}	