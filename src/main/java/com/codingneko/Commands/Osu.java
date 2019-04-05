package com.codingneko.Commands;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.codingneko.JSON.OsuUser;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class Osu extends Commands {
    public Osu() {
    }

    public static void addField() {
        eb.addField("Osu!", "Displays Osu! user info, for example, if you want to know Cookiezi's rank, try `Osu! rank Cookiezi` there are a lot of other things you can request, for a list on those, try `Osu! help`", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        String[] command = e.getMessage().getContentDisplay().split(" ");

        try {
            String response = "";
            String user = command[2];

            try {
                URL url = new URL("https://osu.ppy.sh//api/get_user?k=d217de71720f664a91deebe001a3c0dc0504a63a&u=" + user);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();

                BufferedReader in;
                String inputLine;
                for(in = new BufferedReader(new InputStreamReader(con.getInputStream())); (inputLine = in.readLine()) != null; response = response + inputLine) {
                    ;
                }

                in.close();
            } catch (MalformedURLException var8) {
                var8.printStackTrace();
            } catch (IOException var9) {
                var9.printStackTrace();
            }

            Gson gson = new Gson();
            OsuUser[] OsuUser = (OsuUser[])gson.fromJson(response, OsuUser[].class);
            if (command[1].equalsIgnoreCase("rank")) {
                e.getChannel().sendMessage(OsuUser[0].getPp_rank()).queue();
            }

            if (command[1].equalsIgnoreCase("300s")) {
                e.getChannel().sendMessage(OsuUser[0].getCount300()).queue();
            }

            if (command[1].equalsIgnoreCase("100s")) {
                e.getChannel().sendMessage(OsuUser[0].getCount100()).queue();
            }

            if (command[1].equalsIgnoreCase("50s")) {
                e.getChannel().sendMessage(OsuUser[0].getCount50()).queue();
            }

            if (command[1].equalsIgnoreCase("SS")) {
                e.getChannel().sendMessage(OsuUser[0].getCount_rank_ss()).queue();
            }

            if (command[1].equalsIgnoreCase("S")) {
                e.getChannel().sendMessage(OsuUser[0].getCount_rank_s()).queue();
            }

            if (command[1].equalsIgnoreCase("A")) {
                e.getChannel().sendMessage(OsuUser[0].getCount_rank_a()).queue();
            }

            if (command[1].equalsIgnoreCase("country")) {
                e.getChannel().sendMessage(OsuUser[0].getCountry()).queue();
            }

            if (command[1].equalsIgnoreCase("play_count")) {
                e.getChannel().sendMessage(OsuUser[0].getPlayCount()).queue();
            }

            if (command[1].equalsIgnoreCase("Ranked_Score")) {
                e.getChannel().sendMessage(OsuUser[0].getRankedScore()).queue();
            }

            if (command[1].equalsIgnoreCase("Score")) {
                e.getChannel().sendMessage(OsuUser[0].getTotalScore()).queue();
            }

            if (command[1].equalsIgnoreCase("Country_rank")) {
                e.getChannel().sendMessage(OsuUser[0].getPp_country_rank()).queue();
            }

            if (command[1].equalsIgnoreCase("pp")) {
                e.getChannel().sendMessage(OsuUser[0].getPp_raw()).queue();
            }

            if (command[1].equalsIgnoreCase("accuracy")) {
                e.getChannel().sendMessage(OsuUser[0].getAccuracy() + "%").queue();
            }
        } catch (Exception var10) {
            e.getChannel().sendMessage("Hmm either I didn't find that user or the Osu! API is down ;w;").queue();
        }

    }
}
