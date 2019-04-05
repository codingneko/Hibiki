package com.codingneko.Commands;

import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Ily extends Commands {
    public Ily() {
    }

    public static void addField() {
        eb.addField("I love you hibiki :heart:", "I'll... try and be kind >~<", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        User author = e.getAuthor();
        String[] command = e.getMessage().getContentDisplay().split(" ");
        String msg = "";
        if (author.getId().equals("157461949645455360")) {
            msg = "Awwww I love you too honey :heart:";
        } else {
            msg = "Sorry, I am already dating <@157461949645455360> but we can still be friends ^w^";
        }

        e.getChannel().sendMessage(msg).queue();
    }
}

