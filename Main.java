import Base.Game;
import Base.Player;
import Commands.*;
import Interfaces.ICommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nBienvenue dans TheDialogGame");
        System.out.println("Quel est le nom que tu veux donner à ton joueur ? ");
        String playerName = scanner.nextLine();

        Game game = Game.getInstance();
        Player.getInstance().setName(playerName);


        System.out.println("\nRavi de vous voir ici " + playerName + " vous êtes actuellement à " + Player.getInstance().getLocation().getName() + " !");
        System.out.println(Player.getInstance().getLocation().getDescription());
        System.out.println("\nVoici la carte du jeu : ");
        CommandRegistery.getInstance().getCommandByName("map").execute(null);
        System.out.println("Tapez la commande >help pour voir les commandes disponibles");
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.print(">");
            String input = scanner.nextLine();

            // Utilisation de guillemets comme délimiteurs pour capturer les objets avec des espaces dans leur nom
            String[] tokens = input.split("\"");
            List<String> processedTokens = new ArrayList<>();

            for (int i = 0; i < tokens.length; i++) {
                // Les éléments pairs sont des parties entre guillemets, les éléments impairs sont des parties en dehors des guillemets
                if (i % 2 == 0) {
                    // Divise les parties non entre guillemets en utilisant des espaces comme séparateurs
                    String[] nonQuotedTokens = tokens[i].trim().split("\\s+");
                    processedTokens.addAll(Arrays.asList(nonQuotedTokens));
                } else {
                    // Ajoute les parties entre guillemets sans les modifier
                    processedTokens.add(tokens[i]);
                }
            }

            try {
                ICommand commandToRun = CommandRegistery.getInstance().getCommandByName(processedTokens.get(0).toLowerCase());
                if (CommandRegistery.getInstance().getAllCommands().containsValue(commandToRun) && commandToRun != null) {
                    commandToRun.execute(processedTokens.toArray(new String[0]));
                } else if (input.isEmpty()) {
                    System.out.println("Vous n'avez rien saisi :( ");
                } else {
                    System.out.printf("Commande %s n'existe pas \n", processedTokens.get(0));
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Vous n'avez rien saisi :( ");
            }
        }
    }


}
