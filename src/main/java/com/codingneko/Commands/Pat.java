package com.codingneko.Commands;

import com.codingneko.MessageReceived;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Pat extends Commands {
    public Pat() {
    }

    public static void addField() {
        eb.addField("Pat", "I'll pat you or another user, if you want me to pat you try `.pat me` if you want me to pat someone else, try `.pat @someone`", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        User author = e.getAuthor();
        String[] command = e.getMessage().getContentDisplay().split(" ");

        try {
            if (command[1].equalsIgnoreCase("me")) {
                String[] images = new String[]{"https://media.giphy.com/media/10g9il7Y31ZPAQ/giphy.gif", "http://i.imgur.com/laEy6LU.gif", "https://i.imgur.com/2ZSlFNY.gif", "https://media.giphy.com/media/lZnEy2UefUZvq/giphy.gif", "https://i.imgur.com/nCp9C6y.gif", "https://data.whicdn.com/images/64236201/original.gif"};
                String msg = "";
                if (author.getName().equalsIgnoreCase("codingneko")) {
                    msg = "here here <@157461949645455360> " + images[MessageReceived.random(0, images.length)] + " ily sweetheart ^w^ :heart:";
                } else {
                    msg = "here here <@" + author.getId() + "> " + images[MessageReceived.random(0, images.length)];
                }

                e.getChannel().sendMessage(msg).queue();
            }
        } catch (IndexOutOfBoundsException var5) {
            e.getChannel().sendMessage("e-etto... who are you patting? try `pat me` if you want me to pat you ^^").queue();
        }

    }
}
