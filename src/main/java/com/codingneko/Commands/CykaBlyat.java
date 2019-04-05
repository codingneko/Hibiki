package com.codingneko.Commands;

import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CykaBlyat {
    public CykaBlyat() {
    }

    public static void run(GuildMessageReceivedEvent e) {
        User author = e.getAuthor();
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.green);
        eb.addField("IDI NAHUI", "<@" + author.getId() + ">", false);
        eb.setImage("https://static3.fjcdn.com/thumbnails/comments/Now+dance+dance+_65bdcbb116e5fb7c633219fe8ff5dd2e.gif");
        e.getChannel().sendMessage(eb.build()).queue();
    }
}
