package seedu.stocker.commands;

import seedu.stocker.drugs.Drug;

import java.util.ArrayList;
import java.util.List;

import static seedu.stocker.common.Messages.MESSAGE_INVALID_COMMAND_FORMAT;



/**
 * Represents a command to find drugs in the inventory that match a given keyword.
 */
public class FindCommand extends Command {


    public static final String COMMAND_WORD = "find";

    /**
     * Usage message for the 'find' command.
     */
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds drug in inventory " + System.lineSeparator() +
            "Example: " + COMMAND_WORD + " panadol";

    /**
     * Success message displayed after successfully finding drugs in the inventory.
     */
    public static final String MESSAGE_SUCCESS = "Listed all drugs with the keyword in the inventory.";

    private final String keyword;

    /**
     * Creates a FindCommand with the specified keyword.
     *
     * @param keyword The keyword to search for in the inventory.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the 'find' command, searching for drugs that match the keyword.
     *
     * @return A CommandResult containing the outcome of the command execution.
     */
    @Override
    public CommandResult execute() {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new CommandResult(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_USAGE));
        }

        List<Drug> drugs = inventory.getAllDrugs();
        List<Drug> foundDrugs = new ArrayList<>();

        for (Drug drug : drugs) {
            String drugDescription = drug.toString().toLowerCase();
            if (drugDescription.contains(keyword.toLowerCase())) {
                foundDrugs.add(drug);

            }
        }
        return new CommandResult(MESSAGE_SUCCESS, foundDrugs);
    }
}
