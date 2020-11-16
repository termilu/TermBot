package termilu.termbot.listener;

import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class DeleteListener extends ListenerAdapter{

	@Override
	public void onMessageDelete(MessageDeleteEvent event){
	
					// Wanted to implement a Snipe command here, sadly it seems like this is not possible
					// with JDA v4.2.0 (blaze it brother), cause messages don't seem to get cached? 
					// Or maybe they do but I'm just too stupid to figure it out ¯\_(ツ)_/¯
					// But now I already started including OffsetDateTime time and created SnipeCommand.java
					// so I'm just gonna leave this right here and hope no one ever notices it and
					// maybe I somehow figure it out in the far far future. -termilu 16.11.2020 06:37 am
		
	}
	
	
}
