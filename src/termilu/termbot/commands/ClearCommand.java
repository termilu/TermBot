package termilu.termbot.commands;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import termilu.termbot.commands.types.ServerCommand;

public class ClearCommand implements ServerCommand {

	@Override
	public void performCommand(Member m, TextChannel channel, Message message, OffsetDateTime time) {
		
		if(m.hasPermission(channel, Permission.MESSAGE_MANAGE)) {      																//???????????? https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/entities/IPermissionHolder.html#hasPermission(net.dv8tion.jda.api.Permission...)
			message.delete().queue();
			String[] args = message.getContentDisplay().split(" ");
		
			try {
				TimeUnit.MILLISECONDS.sleep(250);																					//Sleep for .25s so bot doesnt flag self
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			//-clear 5 
			if(args.length == 2) {
				try {
				
					int amount = Integer.parseInt(args[1]);
					channel.purgeMessages(get(channel, amount));
					channel.sendMessage(amount + " messages deleted :)").complete().delete().queueAfter(5, TimeUnit.SECONDS);		//Delete own message for structure
					return;
				
				} catch (NumberFormatException e) {																					//Catch smart people that insert a string and throw them into hell
					e.printStackTrace();
					channel.sendMessage("Just for that you get a -rep too " + message.getAuthor().getAsMention() + " :)").queue();
				}
			}	
		}	
	}

	public List<Message> get(MessageChannel channel, int amount) {
		List<Message> messages = new ArrayList<>();
		int i = amount++;
		
		for(Message message : channel.getIterableHistory().cache(false)) {
			if(!message.isPinned()) {
				messages.add(message);
			}
			if(--i <= 0) break;
		}
		return messages;
	}
}
