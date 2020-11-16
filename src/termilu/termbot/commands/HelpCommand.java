package termilu.termbot.commands;

import java.time.OffsetDateTime;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import termilu.termbot.commands.types.ServerCommand;

public class HelpCommand implements ServerCommand {
	
	@Override
	public void performCommand(Member m, TextChannel channel, Message message, OffsetDateTime time) {
		
		//message.delete().queue();
		
		EmbedBuilder builder = new EmbedBuilder();
		builder.setDescription("**TermBot** \n"
		+ "The entire help section is still under construction! Here is a list of the current commands: \n"
		+ "**-help** - Got you here. Who would've thunk \n"
		+ "**-clear [n]** - Clears the last n messages \n"
		+ "**-rep [@]** - Gives mentioned user a penalty towards his TrustFactor making him burn in the eternal flames :) \n"
		+ "**-+rep [@]** - Now this might be confusing. Just as with the old Christian church a few hundred years ago, you can pay "
		+ 				"to cleanse your soul from your sins. \n"
		+ "**-snipe** - Not gonna happen lets be honest.");
		builder.setColor(0xFF0000);																									//Color RED like my trustfactor :(
		builder.setThumbnail("https://steamcdn-a.akamaihd.net/steamcommunity/public"
				+ "/images/avatars/a1/a1fe6aaf2d7a10d1357f08fedbb329074b8bd047_full.jpg");
		builder.setFooter("This bot was brought to you by termilu industries.");
		builder.setTimestamp(OffsetDateTime.now());
	
		channel.sendMessage(builder.build()).queue();																				//Send help via textchannel
		
		//	m.getUser().openPrivateChannel().queue((ch) -> {		
		//		ch.sendMessage(builder.build()).queue();																			//Send help via DM
		//	});
	
	}
}
