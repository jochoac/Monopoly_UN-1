package UI;

/**
 *
 * @author - Juan Ochoa - Diego Ruiz
 */
public class MonopolyConsole implements ui {

    // Start option
    private int option;    
    // Options player
    private int option2;    
    // Input -- > output, line validate
    private String line;
    private int cantPlayers;

    /**
     * Window welcome for monopoly console
     */
    @Override
    public void welcome() {
        System.out.println("Welcome to Monopoly! \n1. New Game\n2. Exit");
        System.out.print("-------------------- >       ");
        this.setOption(reader.nextInt(6));
    }

    @Override
    public void options(String option) {
        if (option.equalsIgnoreCase("player options")) {
            System.out.println(" 1- Drop the dice\n 2- Information\n 3 - Give up");
            System.out.print("-------------------- >       ");
            this.option2 = reader.nextInt(6);
        }
    }

    public void selectionPlayers() {
        System.out.println("Select number of players (1 to 4)");
        System.out.print("-------------------- >       ");
        this.cantPlayers = reader.nextInt(5);        
    }
    
    @SuppressWarnings("empty-statement")
    public void inputLine(){                
        this.line = reader.nextLine();
        if (this.line.isEmpty()) {
            this.line = reader.nextLine().toUpperCase();
        }else{
            this.line = this.line.toUpperCase();;
        }        
    }
    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getCantPlayers() {
        return cantPlayers;
    }

    public void setCantPlayers(int cantPlayers) {
        this.cantPlayers = cantPlayers;
    }

    public int getOption2() {
        return option2;
    }

    public void setOption2(int option2) {
        this.option2 = option2;
    }
    
    
    

}
