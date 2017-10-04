package UI;

/**
 *
 * @author - Juan Ochoa - Diego Ruiz
 */
public class MonopolyConsole implements ui {

    private int option;

    /**
     * Window welcome for monopoly console
     */
    @Override
    public void welcome() {
        System.out.println("Welcome to Monopoly! \n1. New Game\n2. Exit");
        this.setOption(reader.nextInt());
    }

    @Override
    public void options() {

    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    

}
