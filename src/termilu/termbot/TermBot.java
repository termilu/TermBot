package termilu.termbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import termilu.termbot.listener.CommandListener;

public class TermBot {

	public static TermBot INSTANCE;
	
	public JDA jda;
	public ShardManager shardMan;
	private CommandManager cmdMan;
	
	public static void main(String[] args) {
		try {
			new TermBot();
		} catch (LoginException | IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public TermBot() throws LoginException, IllegalArgumentException  {
		INSTANCE = this;
		
		String Token = Config.getToken();
		
			DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(null);
			builder.setToken(Token);
			builder.setStatus(OnlineStatus.ONLINE);
			builder.setActivity(Activity.watching("Your Trustfactor :)"));
			
			this.cmdMan = new CommandManager();
			
			builder.addEventListeners(new CommandListener());
			
			shardMan = builder.build();
			System.out.println("Bot online");
			
			shutdown();
			
	}
	
	public void shutdown() {
		new Thread(() -> {
			
			String line = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				while((line = reader.readLine()) != null) {
					
					if(line.equalsIgnoreCase("exit")) {
						if(shardMan != null) {
							shardMan.setStatus(OnlineStatus.OFFLINE);
							shardMan.shutdown();
							System.out.println("Bot offline");
						}
						
						reader.close();
					}
					else {
						System.out.println("Use 'exit' to shutdown.");
					}
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}).start();
	}
	
	
	public CommandManager getCmdMan() {
		return cmdMan;
	}

	
}