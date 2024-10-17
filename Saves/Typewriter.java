package Saves;

import Interfaces.IUsable;
import Items.Item;

import java.util.Scanner;

public class Typewriter extends Item implements IUsable {

    //Constructeur
    public Typewriter(String description, String name) {
        super(description, name);
    }

    //Méthode de l'interface IUsable
    public void use() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ecrivez votre texte >");
        String input = scanner.nextLine();
    }
    //Méthode utiliser un objet 

}
