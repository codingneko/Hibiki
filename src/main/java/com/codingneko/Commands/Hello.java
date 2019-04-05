package com.codingneko.Commands;

import com.codingneko.MessageReceived;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Hello extends Commands {
    public Hello() {
    }

    public static void run(GuildMessageReceivedEvent e) {
        User author = e.getAuthor();
        String[] command = e.getMessage().getContentDisplay().split(" ");
        String[] greetings = new String[]{"Hewwo", "Hey, welcome back", "hihi", "o-oh! w-welcome"};
        String[] textEmojis = new String[]{"^w^", "^^", ":3", "(^-^)/", "^///^"};
        String[] aliases = new String[]{"honey", "sweetheart", "cutie", "love"};
        String msg = "";
        if (!author.getName().equalsIgnoreCase("codingneko")) {
            msg = greetings[MessageReceived.random(0, greetings.length)] + " <@" + author.getId() + "> " + textEmojis[MessageReceived.random(0, textEmojis.length)];
        } else {
            msg = greetings[MessageReceived.random(0, greetings.length)] + " " + aliases[MessageReceived.random(0, aliases.length)] + " " + textEmojis[MessageReceived.random(0, textEmojis.length)] + " :heart:";
        }

        e.getChannel().sendMessage(msg).queue();
    }
}