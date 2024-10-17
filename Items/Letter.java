package Items;

import Base.Inventory;
import Interfaces.IReadable;
import Interfaces.ITakeable;

public class Letter extends Item implements ITakeable, IReadable {

    private String content;

    //Constructeur
    public Letter(String description, String name, String content) {
        super(description, name);
        this.content = content;
    }

    //Méthode read pour lire le contenu de la lettre
    public void read() {
        System.out.println(content);
    }

    //Méthode ITakeable
    public void take() {
        Inventory.getInstance().addItem(this);
    }
    public void drop(){
        Inventory.getInstance().removeItem(this);
    }

    public String toString(){
        return super.getName();
    }

    public String getContent() {
        return content;
    }
}
