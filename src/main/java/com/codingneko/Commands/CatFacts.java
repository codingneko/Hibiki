package com.codingneko.Commands;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.codingneko.JSON.CatFact;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class CatFacts extends Commands {
    public static void addField() {
        eb.addField("Cat Facts", "Displays a random catfact from https://catfact.ninja", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        String response = "";

        try {
            URL url = new URL("https://catfact.ninja/fact");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            BufferedReader in;
            String inputLine;
            for(in = new BufferedReader(new InputStreamReader(con.getInputStream())); (inputLine = in.readLine()) != null; response = response + inputLine) {

            }

            in.close();
        } catch (MalformedURLException var6) {
            var6.printStackTrace();
            e.getChannel().sendMessage("wow something went really really wrong, my server probably has an ugly red stack trace on the console right now ;w;").queue();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        Gson gson = new Gson();
        CatFact fact = (CatFact)gson.fromJson(response, CatFact.class);
        e.getChannel().sendMessage(fact.getFact()).queue();
    }
}
