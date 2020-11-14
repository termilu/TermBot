package termilu.termbot.commands;

import java.lang.reflect.Member;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import termilu.termbot.commands.types.ServerCommand;

public class ClearCommand implements ServerCommand {

	@Override
	public void performCommand(Member m, TextChannel channel, Message message) {
		
	//	if(m.hasPermission(channel, Permission.MESSAGE_MANAGE))       //???????????? https://ci.dv8tion.net/job/JDA/javadoc/net/dv8tion/jda/api/entities/IPermissionHolder.html#hasPermission(net.dv8tion.jda.api.Permission...)
	//	message.delete().queue();
		
	}

}
