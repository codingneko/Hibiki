package com.codingneko;

import com.codingneko.Commands.*;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class CommandHandler {
    String message;
    String[] command;
    Member author;
    List mentioned;
    GuildMessageReceivedEvent e;

    public CommandHandler(GuildMessageReceivedEvent e) {
        this.message = e.getMessage().getContentDisplay();
        this.command = this.message.split(" ");
        this.author = e.getMessage().getMember();
        this.mentioned = e.getMessage().getMentionedMembers();
        this.e = e;
    }

    public void runMessage(){
        if (message.equalsIgnoreCase("I love you Hibiki ❤") || message.equalsIgnoreCase("Hibiki I love you ❤")) {
            Ily.run(e);
        }

        if (message.equalsIgnoreCase("hello")) {
            Hello.run(e);
        }

        if (message.toLowerCase().startsWith("cyka blyat")) {
            CykaBlyat.run(e);
        }

        if (mentioned.size() == 1 && mentioned.get(0).toString().equalsIgnoreCase("U:Hibiki(388089153939832842)")) {
            CustomColours.run(e);
        }

        if (message.toLowerCase().startsWith("cat fact")) {
            CatFacts.run(e);
        }

        if (message.toLowerCase().startsWith("sorry hibiki")) {
            e.getChannel().sendMessage("it's okay >~<").queue();
        }
    }

    public void runCommands(){
        command[0] = command[0].charAt(0) == '.' ? command[0].substring(1) : "not a command";

        switch(command[0].toLowerCase()) {
            case "ping":
                Ping.run(e);
                break;
            case "roll":
                Roll.run(e);
                break;
            case "pat":
                Pat.run(e);
                break;
            case "kiss":
                Kiss.run(e);
                break;
            case "does":
                DoOrDoes.run(e);
                break;
            case "do":
                DoOrDoes.run(e);
                break;
            case "osu!":
                Osu.run(e);
                break;
            case "osu":
                Osu.run(e);
                break;
            case "help":
                Commands.run(e);
                break;
            case "gelbooru":
                Gelbooru.run(e);
                break;
            case "loli":
                Gelbooru.loli(e);
                break;
            case "shota":
                Gelbooru.shota(e);
        }
    }
}
