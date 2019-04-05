package com.codingneko;

import net.dv8tion.jda.core.JDA;

import java.util.Scanner;

class ConsoleThread implements Runnable{
    public void run(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String command = sc.next();
            if(command.equals("exit")){
                System.exit(0);
            }
        }
    }
}
