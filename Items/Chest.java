package Items;


import Base.World;
import Commands.CommandRegistery;
import Commands.GoToCommand;
import Interfaces.ICommand;
import Interfaces.IOpenable;

public class Chest extends Item implements IOpenable {
    private static int id = 1;
    private final int ID;
    private boolean isOpen;

    public Chest(String description, String name) {
        super(description, name);
        this.ID = id;
        this.isOpen = false;
        id++;
    }

    public int getId() {
        return ID;
    }

    public void open() {
        this.isOpen = true;
        System.out.println("Ouverture de " + getName());
        this.giveReward();
    }

    public String getName() {
        return super.getName();
    }

    public String getDescription() {
        return super.getDescription();
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void giveReward() {
        switch (this.ID) {
            case 1:
                System.out.println("""

                        Bravo, vous venez de débloquer les ailes. \
                        Vous pouvez maintenant voler de zones en zones grâce a la nouvelle commande "goto", ses informations se trouvent dans la commande help.\
                        
                        De plus, maintenant que vous possèdez la capacité de voler, vous pouvez vous rendre à skypea, la ville céleste. Génial !""");
                ICommand goTo = GoToCommand.getInstance();
                CommandRegistery.getInstance().addCommand("goto", goTo);
                World.getInstance().getLocationByName("skypea").setOpen();
                break;
            case 2:
                System.out.println("Récompense 2 ");
                break;
            case 3:
                System.out.println("Récompense 3 ");
                break;
            case 4:
                System.out.println("Récompense 4 ");
                break;
            case 5:
                System.out.println("Récompense 5 ");
                break;
            default:
                System.out.println("Aucune récompense");
                break;
        }
    }

}
