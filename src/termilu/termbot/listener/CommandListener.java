package termilu.termbot.listener;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

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
			
				//	!test arg0 arg1 arg2
				if(message.startsWith("-")) {
					String[] args = message.substring(1).split(" ");
					if(args.length > 0) {
						if (args[0].equalsIgnoreCase("rep")) {
							
							channel.sendMessage("-rep added for " + event.getMessage().getContentRaw().substring(5)).queue(); 
							
						}
						
					}
				
				}
			
			}
		
		}
		
	}
		
}
	

