package com.codingneko.Commands;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.managers.GuildController;

public class CustomColours extends Commands {
    public CustomColours() {
    }

    public static void addField() {
        eb.addField("Custom Colours", "Allows you to set a custom colour for yourself, if the color is already created, you'll only have to do `@hibiki set color <your color's name>` otherwise you'll have to create it with `@hibiki new color <#hex value> <colour name>`, to change your color, fist unset your current color with `@hibiki unset color <colour name>` if you need a list of colors that are already created, use `@Hibiki list colors`", true);
    }

    public static void run(GuildMessageReceivedEvent e) {
        String[] command = e.getMessage().getContentDisplay().split(" ");
        Guild guild = e.getGuild();
        GuildController guildController = new GuildController(guild);
        User author = e.getAuthor();
        if (command[1].equalsIgnoreCase("new") && command[2].equalsIgnoreCase("color")) {
            guild.getController().createRole().setColor(Color.decode(command[3])).setName(command[4]).queue();
            e.getChannel().sendMessage("congrats, the color " + command[3] + " is now recognized as " + command[4]).queue();
        }

        if (command[1].equalsIgnoreCase("set") && command[2].equalsIgnoreCase("color")) {
            guildController.addSingleRoleToMember(guild.getMemberById(author.getId()), (Role)guild.getRolesByName(command[3], true).get(0)).queue();
            e.getChannel().sendMessage("congrats, your color is now set to " + command[3]).queue();
        }

        if (command[1].equalsIgnoreCase("unset") && command[2].equalsIgnoreCase("color")) {
            guildController.removeRolesFromMember(guild.getMemberById(author.getId()), new Role[]{(Role)guild.getRolesByName(command[3], true).get(0)}).queue();
            e.getChannel().sendMessage(command[3] + " is no longer your color").queue();
        }

        if (command[1].equalsIgnoreCase("list") && command[2].equalsIgnoreCase("colors")) {
            List<Role> roles = guildController.getGuild().getRoles();
            boolean show = false;
            Iterator var7 = roles.iterator();

            while(var7.hasNext()) {
                Role role = (Role)var7.next();
                if (role.getName().equals("defaultColor")) {
                    show = true;
                }

                if (show && !role.getName().equals("@everyone") && !role.getName().equals("defaultColor")) {
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.setColor(role.getColor());
                    eb.addField(role.getName(), "This color's hex value is " + String.format("#%02X%02X%02X", role.getColor().getRed(), role.getColor().getGreen(), role.getColor().getBlue()), false);
                    e.getChannel().sendMessage(eb.build()).queue();
                }
            }
        }

    }
}
