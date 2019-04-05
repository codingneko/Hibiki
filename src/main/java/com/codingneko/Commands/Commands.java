package com.codingneko.Commands;
import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Commands {
    static EmbedBuilder eb = new EmbedBuilder();

    public Commands() {
    }

    public static void buildEmbed() {
        eb.setColor(Color.green);
        eb.setThumbnail("https://simg3.gelbooru.com/thumbnails/ec/a5/thumbnail_eca55c937d90eaa77726a60a7a44aaba.jpg");
        eb.addField("Help", "Shows this embed DUH?", true);
        CatFacts.addField();
        CustomColours.addField();
        DoOrDoes.addField();
        Kiss.addField();
        Osu.addField();
        Pat.addField();
        Ping.addField();
        Roll.addField();
        Gelbooru.addField();
    }

    public static void run(GuildMessageReceivedEvent e) {
        e.getChannel().sendMessage(eb.build()).queue();
    }
}
