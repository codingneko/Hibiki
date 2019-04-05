package com.codingneko.Commands;

import com.google.gson.Gson;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.codingneko.MessageReceived;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Gelbooru extends Commands {
    public Gelbooru() {
    }

    public static void addField() {
        eb.addField("Gelbooru", "queries images from Gelbooru, syntax is `.gelbooru <tags>`, other shorthand methods are .loli to get a loli, or .shota to get a shota.", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.green);
        String tags = e.getMessage().getContentDisplay().replaceFirst(".gelbooru ", "");
        String response = "";

        try {
            URL url = new URL("https://gelbooru.com/index.php?page=dapi&s=post&q=index&json=1&tags=" + tags);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            BufferedReader in;
            String inputLine;
            for(in = new BufferedReader(new InputStreamReader(con.getInputStream())); (inputLine = in.readLine()) != null; response = response + inputLine) {
                ;
            }

            in.close();
        } catch (MalformedURLException var8) {
            var8.printStackTrace();
            System.out.println("URL invalid");
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        com.codingneko.JSON.Gelbooru[] gelbooru = (com.codingneko.JSON.Gelbooru[])(new Gson()).fromJson(response, com.codingneko.JSON.Gelbooru[].class);
        int selectPic = MessageReceived.random(0, 100);
        eb.setImage(gelbooru[selectPic].getFile_url());
        eb.setFooter(gelbooru[selectPic].getOwner() + " " + gelbooru[selectPic].getSource(), "https://pbs.twimg.com/profile_images/1758796925/gelbooru_400x400.png");
        e.getChannel().sendMessage(eb.build()).queue();
    }

    public static void loli(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.green);
        String tags = e.getMessage().getContentDisplay().replaceFirst(".gelbooru ", "");
        String response = "";

        try {
            URL url = new URL("https://gelbooru.com/index.php?page=dapi&s=post&q=index&json=1&tags=loli");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            BufferedReader in;
            String inputLine;
            for(in = new BufferedReader(new InputStreamReader(con.getInputStream())); (inputLine = in.readLine()) != null; response = response + inputLine) {
                ;
            }

            in.close();
        } catch (MalformedURLException var8) {
            var8.printStackTrace();
            System.out.println("URL invalid");
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        com.codingneko.JSON.Gelbooru[] gelbooru = (com.codingneko.JSON.Gelbooru[])(new Gson()).fromJson(response, com.codingneko.JSON.Gelbooru[].class);
        int selectPic = MessageReceived.random(0, 100);
        eb.setImage(gelbooru[selectPic].getFile_url());
        eb.setFooter(gelbooru[selectPic].getOwner() + " " + gelbooru[selectPic].getSource(), "https://pbs.twimg.com/profile_images/1758796925/gelbooru_400x400.png");
        e.getChannel().sendMessage(eb.build()).queue();
    }

    public static void shota(GuildMessageReceivedEvent e) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.green);
        String tags = e.getMessage().getContentDisplay().replaceFirst(".gelbooru ", "");
        String response = "";

        try {
            URL url = new URL("https://gelbooru.com/index.php?page=dapi&s=post&q=index&json=1&tags=shota");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            BufferedReader in;
            String inputLine;
            for(in = new BufferedReader(new InputStreamReader(con.getInputStream())); (inputLine = in.readLine()) != null; response = response + inputLine) {
                ;
            }

            in.close();
        } catch (MalformedURLException var8) {
            var8.printStackTrace();
            System.out.println("URL invalid");
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        com.codingneko.JSON.Gelbooru[] gelbooru = (com.codingneko.JSON.Gelbooru[])(new Gson()).fromJson(response, com.codingneko.JSON.Gelbooru[].class);
        int selectPic = MessageReceived.random(0, 100);
        eb.setImage(gelbooru[selectPic].getFile_url());
        eb.setFooter(gelbooru[selectPic].getOwner() + " " + gelbooru[selectPic].getSource(), "https://pbs.twimg.com/profile_images/1758796925/gelbooru_400x400.png");
        e.getChannel().sendMessage(eb.build()).queue();
    }
}
