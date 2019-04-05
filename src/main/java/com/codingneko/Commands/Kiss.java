package com.codingneko.Commands;

import java.util.List;
import com.codingneko.MessageReceived;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Kiss extends Commands {
    public Kiss() {
    }

    public static void addField() {
        eb.addField("Kiss", "Sends a kiss to someone, if you want me to kiss you try `kiss me` if you want to kiss someone else, try `kiss @someone`", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        String[] command = e.getMessage().getContentDisplay().split(" ");
        User author = e.getAuthor();
        List mentioned = e.getMessage().getMentionedUsers();
        String message = e.getMessage().getContentDisplay();

        try {
            if (command[1].equalsIgnoreCase("me")) {
                String[] imagesLewd = new String[]{"https://media.giphy.com/media/G3va31oEEnIkM/giphy.gif", "https://78.media.tumblr.com/02b6ab35f6c47a1f50ea4c7b9bbaf06c/tumblr_oizl7kvRXa1u3gxh8o1_500.gif", "https://i.imgur.com/eisk88U.gif", "https://media1.tenor.com/images/a0b68f4704f811bfcc517574425e96a5/tenor.gif?itemid=5291693", "https://cdn.discordapp.com/attachments/382537418080780289/388368973743390720/kiss.gif"};
                String[] images = new String[]{"https://24.media.tumblr.com/51df4395955caa4d5d41e68182f82bc0/tumblr_n0ycutO5aU1qcsnnso1_500.gif", "https://data.whicdn.com/images/299527772/original.gif", "http://www.lovethisgif.com/uploaded_images/41239-Anime-Cheek-Kiss-Gif-Karen-Kissing-Shino-lewd-.gif"};
                String msg = "";
                if (!author.getName().equalsIgnoreCase("codingneko") && !author.getName().equalsIgnoreCase("brenda")) {
                    msg = "thehe you dummy...  <@" + author.getId() + "> " + images[MessageReceived.random(0, images.length)];
                } else {
                    msg = "e-etto... s-sure >/////< " + imagesLewd[MessageReceived.random(0, imagesLewd.length)] + " :heart:";
                }

                e.getChannel().sendMessage(msg).queue();
            } else if (command[1].startsWith("@")) {
                String msg = "";
                boolean kissingRestricted = false;

                for(int i = 0; mentioned.size() > i; ++i) {
                    String[] mentionedUserIdArray = mentioned.get(i).toString().split("\\(");
                    mentionedUserIdArray = mentionedUserIdArray[1].split("\\)");
                    String mentionedUserId = mentionedUserIdArray[0];
                    if (!mentionedUserId.equals("388089153939832842") && !mentionedUserId.equals("157461949645455360")) {
                        msg = msg + "<@" + mentionedUserId + ">, ";
                    } else if (mentionedUserId.equals("157461949645455360") && message.toLowerCase().contains("lips")) {
                        e.getChannel().sendMessage("H-HEY THAT'S MY HUSBAND, N-NOT IN THE LIPS!!").queue();
                        kissingRestricted = true;
                    } else if (mentionedUserId.equals("388089153939832842") && message.toLowerCase().contains("lips") && !author.getId().equals("157461949645455360")) {
                        e.getChannel().sendMessage("s-sorry but I'll only kiss my husband on the lips >///<").queue();
                        kissingRestricted = true;
                    }
                }

                String[] images;
                if (message.toLowerCase().contains("lips") && !kissingRestricted) {
                    images = new String[]{"https://media.giphy.com/media/G3va31oEEnIkM/giphy.gif", "https://78.media.tumblr.com/02b6ab35f6c47a1f50ea4c7b9bbaf06c/tumblr_oizl7kvRXa1u3gxh8o1_500.gif", "https://i.imgur.com/eisk88U.gif", "https://media1.tenor.com/images/a0b68f4704f811bfcc517574425e96a5/tenor.gif?itemid=5291693", "https://cdn.discordapp.com/attachments/382537418080780289/388368973743390720/kiss.gif"};
                    if (mentioned.size() > 1) {
                        msg = msg + "have been kissed by <@" + author.getId() + "> h-how lewd >//////<" + images[MessageReceived.random(0, images.length)];
                    } else {
                        msg = msg + "has been kissed by <@" + author.getId() + "> h-how lewd >//////<" + images[MessageReceived.random(0, images.length)];
                    }
                } else if (!kissingRestricted) {
                    images = new String[]{"https://24.media.tumblr.com/51df4395955caa4d5d41e68182f82bc0/tumblr_n0ycutO5aU1qcsnnso1_500.gif", "https://data.whicdn.com/images/299527772/original.gif", "http://www.lovethisgif.com/uploaded_images/41239-Anime-Cheek-Kiss-Gif-Karen-Kissing-Shino-lewd-.gif"};
                    if (mentioned.size() > 1) {
                        msg = msg + "have been kissed by <@" + author.getId() + "> tehehe you " + (mentioned.size() + 1) + " are so cute ^w^ " + images[MessageReceived.random(0, images.length)];
                    } else {
                        msg = msg + "has been kissed by <@" + author.getId() + "> tehehe you " + (mentioned.size() + 1) + " are so cute ^w^ " + images[MessageReceived.random(0, images.length)];
                    }
                }

                e.getChannel().sendMessage(msg).queue();
            } else {
                e.getChannel().sendMessage("sorry, you have to @ a user, try \"kiss <@157461949645455360>\" to kiss my husband, j-just don't use any extra parameters, please ;-;").queue();
            }
        } catch (IndexOutOfBoundsException var10) {
            e.getChannel().sendMessage("e-etto... who are you trying to kiss? t-try `kiss me` if you want me to kiss you >////<").queue();
        }

    }
}