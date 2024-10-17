package Interfaces;

public interface ICommand {
    public String getName();

    public String getUsage();

    public String getDescription();

    public void execute(String[] args);

    public boolean hasValidArgs(String[] args);

}
