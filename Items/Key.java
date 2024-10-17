package Items;

import Base.Inventory;
import Interfaces.ITakeable;
import Interfaces.IUsable;

public class Key extends Item implements ITakeable, IUsable {
private static int ID;
    //Constructeur
    public Key(String description, String name) {
        super(description, name);
        ID = 1;
    }

    //Méthode de l'interface ITakeable
    public void take() {
        Inventory.getInstance().addItem(this);
    }
    public void drop(){
        Inventory.getInstance().removeItem(this);
    }

    //Méthode de l'interface IUsable
    public void use() {
        System.out.println("Utilisation de "+this.getName());
    }

    public int getId(){
        return ID;
    }

    public String toString() {
        return super.getName();
    }
}