package termilu.termbot.commands;

import java.time.OffsetDateTime;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import termilu.termbot.commands.types.ServerCommand;

public class SnipeCommand implements ServerCommand {

	@Override
	public void performCommand(Member m, TextChannel channel, Message message, OffsetDateTime time) {
	
		EmbedBuilder builder = new EmbedBuilder();
		builder.setDescription("Okay but don't even wait for this feature to hit live.");
		builder.setAuthor("termilu");
		builder.setColor(0xFF0000);																// Don't even bother. #listener/DeleteListener.java
		builder.setFooter("This command was brought to you by endless amounts of pain.");
		builder.setTimestamp(time);
		
		channel.sendMessage(builder.build()).queue();
		
	}
	
}
