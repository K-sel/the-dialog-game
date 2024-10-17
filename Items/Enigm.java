package Items;

import Interfaces.ISolvable;

import java.util.Scanner;

public class Enigm extends Item implements ISolvable {
    private String answer;
    private boolean solved;

    //Constructeur
    public Enigm(String description, String name, String answer) {
        super(description, name);
        this.answer = answer;
        this.solved = false;
    }

    //Méthode de l'interface IUsable
    public void solve() {
        boolean running = true;
        if (!this.isSolved()) {
            while (running) {
                System.out.println(getDescription());
                System.out.println("Pour abandonner l'énigme, écrivez leave");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Ecrivez votre réponse : ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("leave")) {
                    running = false;
                    System.out.println("Vous avez quitté : " + this.getName());
                } else {
                    checkAnswer(input);
                    if (this.solved) {
                        System.out.printf("Bravo ! Vous avez répondu correctement !\n");
                        giveReward(answer);
                        running = false;
                    } else {
                        System.out.println("Mauvaise réponse...\n");
                    }
                }
            }
        }else{
            System.out.println("Vous avez déja résolu cette énigme.");
        }
    }

    public boolean isSolved() {
        return solved;
    }

    public String getDescription() {
        return super.getDescription();
    }

    public boolean checkAnswer(String answer) {
        if (answer.equalsIgnoreCase(this.answer)) this.solved = true;
        return this.solved;
    }

    public void giveReward(String answer) {
        String rep = answer.toLowerCase();
        switch (rep) {
            case "eau":
                ItemRegistery.getInstance().addItem(new Key("Dévérouille surement quelque chose de très vieux", "Clé rouillée"), "kiri");
                System.out.println("Une mystérieuse clé vient d'apparaitre dans le région de kiri");
                System.out.println();
                ItemRegistery.getInstance().addItem(new Enigm("Combien font 4+4*4/2 ? \nLes charpentiers doivent connaitre une valeurs mais ont trop fait la fête hier pour calculer de tête","Énigme des charpentiers","8"),"loguetown");
                System.out.println("Une énigme est apparue à loguetown.");
                break;
            case "8":
                System.out.println("Bravo c'est la bonne réponse... Mais j'ai pas fini d'implémenter le gameplay.");
                break;
            case "boolean":
                System.out.println("Enigm reward 3");
                break;
            case "green":
                System.out.println("Enigm reward 4");
                break;
            case "100":
                System.out.println("Enigm reward 5");
                break;
            default:
                System.out.println("Aucune récompense");
                break;
        }
    }

}
