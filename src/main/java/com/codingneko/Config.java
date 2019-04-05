package com.codingneko;

import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

public class Config {
    Ini ini;
    String token;
    String game;

    public Config(){
        try {
            this.ini = new Ini(new File("config.ini"));
            this.token = ini.get("connection", "token");
            this.game = ini.get("customization", "game");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("The configuration file was not found");
        }
    }

    public Ini getIni() {
        return this.ini;
    }

    public String getToken() {
        return token;
    }

    public String getGame() {
        return game;
    }
}
