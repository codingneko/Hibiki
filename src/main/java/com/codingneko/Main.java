package com.codingneko;

import com.codingneko.Commands.Commands;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.JDA;

import java.io.File;
import java.io.IOException;
import javax.security.auth.login.LoginException;

import org.ini4j.Ini;


public class Main extends ListenerAdapter {
    public static JDA api;

    public static void main(String[] args) {
        Thread console = new Thread(new ConsoleThread());
        console.start();

        Config c = new Config();

        try {
            api = (new JDABuilder(AccountType.BOT)).setToken(c.getToken()).build();
            api.getPresence().setGame(Game.listening(c.getGame()));
            api.addEventListener(new MessageReceived());
            Commands.buildEmbed();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("The configuration file was not found");
        }
    }
}