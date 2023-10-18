package seedu.stocker;

import seedu.stocker.authentication.LoginSystem;
import seedu.stocker.ui.Ui;
import seedu.stocker.parser.Parser;
import seedu.stocker.commands.Command;
import seedu.stocker.commands.CommandResult;
import seedu.stocker.commands.ExitCommand;
import seedu.stocker.drugs.Inventory;

import java.io.IOException;


public class Stocker {

    private Ui ui;
    private Inventory inventory;



    public static void main(String[] launchArgs) throws IOException {
        new Stocker().run();
    }

    /**
     * Runs Login System.
     */
    public boolean startLogin() throws IOException {
        this.ui = new Ui();
        ui.showLoginMessage();
        LoginSystem system = new LoginSystem();
        system.run();

        return system.loginStatus;
    }


    /**
     * Runs the program until termination.
     */
    public void run() throws IOException {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    /**
     * Sets up the required objects, and prints the welcome message.
     */
    private void start() throws IOException {
        this.ui = new Ui();
        this.inventory = new Inventory();
        boolean checker = startLogin();
        assert checker;
        ui.showWelcomeMessage();
    }

    /**
     * Prints the Goodbye message and exits.
     */
    private void exit() {
        ui.showGoodbyeMessage();
        System.exit(0);
    }

    /**
     * Reads the user command and executes it, until the user issues the exit command.
     */
    private void runCommandLoopUntilExitCommand() {
        Command command;
        do {
            String userCommandText = ui.getUserCommand();
            command = new Parser().parseCommand(userCommandText);
            CommandResult result = executeCommand(command);
            ui.showResultToUser(result);

            assert !ExitCommand.isExit(command);

        } while (!ExitCommand.isExit(command));
    }


    /**
     * Executes the command and returns the result.
     *
     * @param command user command
     * @return result of the command
     */
    private CommandResult executeCommand(Command command) {
        command.setData(inventory);
        return command.execute();
    }
}
