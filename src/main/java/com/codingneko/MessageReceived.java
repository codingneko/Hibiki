package com.codingneko;

import java.util.List;
import com.codingneko.Commands.*;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MessageReceived extends ListenerAdapter {
    private int swearCounter = 0;

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String message = e.getMessage().getContentDisplay();
        Guild guild = e.getGuild();
        User author = e.getAuthor();
        String[] swears = {"fuck you", "cunt", "faggot", "tosser", "fark", "slutmuffin", "cuntbag", "slut", "bitch", "whore", "hoe", "twat", "motherfucker", "son of a bitch", "asshat", "prick"};
        System.out.println(author.getName() + ": \"" + message + "\" in " + guild.getName());

        CommandHandler ch = new CommandHandler(e);

        ch.runCommands();
        ch.runMessage();

        for(int i = 0; i < swears.length; ++i) {
            String swear = swears[i];
            if (message.contains(swear)) {
                String[] rudes = new String[]{"r-rude >~<", "gosh why are you so rude...?", "hey, leave him alone...", "you're making me sad ;w; don't swear...", "why would you call anyone that? jeez you're so rude uh"};
                if (this.swearCounter % 10 == 0) {
                    e.getChannel().sendMessage(rudes[random(0, rudes.length)]).queue();
                }

                this.swearCounter++;
            }
        }

    }

    public static int random(int min, int max) {
        int random = (int)(Math.random() * (double)(max - min) + (double)min);
        return random;
    }
}

