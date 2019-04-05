package com.codingneko.Commands;

import com.codingneko.MessageReceived;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Roll extends Commands {
    public Roll() {
    }

    public static void addField() {
        eb.addField("Roll", "Rolls a number between two numbers, for example, if you want a random number between 100 and 1000 try `.roll 100 1000", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        User author = e.getAuthor();
        String[] command = e.getMessage().getContentDisplay().split(" ");

        try {
            int min = Integer.valueOf(command[1]);
            int max = Integer.valueOf(command[2]);
            int random = MessageReceived.random(min, max);
            String msg = "<@" + author.getId() + ">  rolled a " + Integer.toString(random);
            e.getChannel().sendMessage(msg).queue();
        } catch (ArrayIndexOutOfBoundsException var7) {
            e.getChannel().sendMessage("Sorry, you have to specify a range, try `roll 0 10` to roll a number between 0 and 10").queue();
        }

    }
}