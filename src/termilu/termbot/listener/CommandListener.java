package termilu.termbot.listener;

import net.dv8tion.jda.api.entities.Member;

import java.time.OffsetDateTime;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import termilu.termbot.TermBot;

public class CommandListener extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		
		if(event.getAuthor().isBot()) {
			return;
		}else {
		
			String message = event.getMessage().getContentDisplay();
		
			System.out.println(message);
		
			if(event.isFromType(ChannelType.TEXT)) {
				TextChannel channel = event.getTextChannel();
				OffsetDateTime time = event.getMessage().getTimeCreated();
				
				//	!test arg0 arg1 arg2
				if(message.startsWith("-")) {									//-rep
					String[] args = message.substring(1).split(" ");
					if(args.length > 0) {
						if(!TermBot.INSTANCE.getCmdMan().perform(args[0], (Member) event.getMember(), channel, event.getMessage(), time)) {
							
							channel.sendMessage("Unbekannter Command").queue();
					
						}
					}
				
			//	}else if(message.startsWith("+")) {								//+rep
			//		String[] args = message.substring(1).split(" ");
			//		if(args.length > 0) {
			//			if (args[0].equalsIgnoreCase("rep")) {
							
			//				channel.sendMessage("+rep added for " + event.getMessage().getContentRaw().substring(5)).queue();
							//insert +rep implementation
			//			}
			//		}
					
				}
			}
		}
	}
}
	

