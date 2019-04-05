package com.codingneko.Commands;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Ping extends Commands {
    public Ping() {
    }

    public static void addField() {
        eb.addField("Ping", "Sends an ICMP packet between hibiki and the server and tells you how long it took it to get there", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        User author = e.getAuthor();
        String msg = "<@" + author.getId() + "> your ping is `" + e.getJDA().getPing() + "ms`";
        e.getChannel().sendMessage(msg).queue();
    }
}
