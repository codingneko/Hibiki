package com.codingneko.Commands;

import com.codingneko.MessageReceived;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class DoOrDoes extends Commands {
    public DoOrDoes() {
    }

    public static void addField() {
        eb.addField("Do / Does", "will tell you if someone does something, if you if you do something, try `.do I <something>` if you want to know if someone else does something try `.does @someone <something>`", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        String[] command = e.getMessage().getContentDisplay().split(" ");

        try {
            String[] options;
            String msg;
            if (command[1].equalsIgnoreCase("I")) {
                options = new String[]{"Yes", "No"};
                msg = options[MessageReceived.random(0, options.length)];
                e.getChannel().sendMessage(msg).queue();
            } else if (command[1].startsWith("@")) {
                options = new String[]{"Yes", "No"};
                msg = options[MessageReceived.random(0, options.length)];
                e.getChannel().sendMessage(msg).queue();
            } else {
                e.getChannel().sendMessage("hmmm... did you @someone? you have to @ them, otherwise I won't know who you're talking about if there are two persons with the same name >~<").queue();
            }
        } catch (IndexOutOfBoundsException var4) {
            e.getChannel().sendMessage("who do you think should do this?").queue();
        }

    }
}