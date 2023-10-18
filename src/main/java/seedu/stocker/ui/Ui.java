package seedu.stocker.ui;

import java.util.Scanner;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import seedu.stocker.drugs.Drug;
import seedu.stocker.commands.CommandResult;

import static seedu.stocker.common.Messages.MESSAGE_USERNAME_INPUT;
import static seedu.stocker.common.Messages.MESSAGE_USER_ALREADY_EXIST;
import static seedu.stocker.common.Messages.MESSAGE_LOGIN_WELCOME;
import static seedu.stocker.common.Messages.MESSAGE_SUCCESSFUL_LOGIN;
import static seedu.stocker.common.Messages.MESSAGE_NO_BLANK_NAME_ALLOWED;
import static seedu.stocker.common.Messages.MESSAGE_NO_BLANK_PASSWORD_ALLOWED;
import static seedu.stocker.common.Messages.MESSAGE_PASSWORD_INPUT;
import static seedu.stocker.common.Messages.MESSAGE_WELCOME;
import static seedu.stocker.common.Messages.MESSAGE_INVALID_CHOICE;
import static seedu.stocker.common.Messages.MESSAGE_GOODBYE;
import static seedu.stocker.common.Messages.MESSAGE_INVALID_USERNAME_OR_PASSWORD;
import static seedu.stocker.common.Messages.MESSAGE_SUCCESSFUL_REGISTRATION;


public class Ui {

    /**
     * Offset required to convert between 1-indexing and 0-indexing.
     */
    public static final int DISPLAYED_INDEX_OFFSET = 1;

    /**
     * A decorative prefix added to the beginning of lines printed by Jerry
     */
    private static final String LINE_PREFIX = "|| ";

    private static final String DIVIDER = "===================================================";

    /**
     * A platform independent line separator.
     */
    private static final String LS = System.lineSeparator();

    /**
     * Format of indexed list item
     */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    private final Scanner in;
    private final PrintStream out;

    public Ui() {
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public void printVersion1Help() {
        System.out.println("Here are a list of possible commands");
        System.out.println("1. add - Add a drug into the system");
        System.out.println("2. delete - Remove a drug from the system");
        System.out.println("3. list - List all current drugs in the system");
        System.out.println("4. find - Find a specific drug in the system");
        System.out.println("5. help - List all available commands");

        System.out.println();
        System.out.println();

        System.out.println("Here is the formatting for the commands");

        System.out.println("For add:");
        System.out.println("add /n <drug name> /d <expiry date> /q <quantity>");
        System.out.println();

        System.out.println("For delete:");
        System.out.println("delete /n <drug name>");
        System.out.println();


        System.out.println("For list:");
        System.out.println("list");
        System.out.println();


        System.out.println("For find:");
        System.out.println("find <keyword>");
        System.out.println();


        System.out.println("For help:");
        System.out.println("help");

    }

    /**
     * Prompts for the command and reads the text entered by the user.
     * Ignores empty, pure whitespace, and comment lines.
     * Echos the command back to the user.
     *
     * @return command (full line) entered by the user
     */
    public String getUserCommand() {
        out.print(LINE_PREFIX + "Enter command: ");

        return in.nextLine();
    }

    /**
     * Shows message(s) to the user
     */
    public void showToUser(String... message) {
        for (String m : message) {
            out.println(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX));
        }
    }

    public void showLoginMessage() {
        showToUser(DIVIDER, MESSAGE_LOGIN_WELCOME, DIVIDER);
    }

    public void showUsernameMessage() {
        showToUser(MESSAGE_USERNAME_INPUT);
    }

    public void showPasswordMessage() {
        showToUser(MESSAGE_PASSWORD_INPUT);
    }

    public void showSuccessfulRegistrationMessage() {
        showToUser(MESSAGE_SUCCESSFUL_REGISTRATION);
    }

    public void showSuccessfulLoginMessage() {
        showToUser(MESSAGE_SUCCESSFUL_LOGIN);
    }

    public void showInvalidChoiceMessage() {
        showToUser(MESSAGE_INVALID_CHOICE);
    }

    public void showUserAlreadyExistMessage() {
        showToUser(MESSAGE_USER_ALREADY_EXIST);
    }

    public void showEnterChoiceAgainMessage() {
        showToUser(MESSAGE_LOGIN_WELCOME);
    }

    public void showInvalidUsernameOrPasswordMessage() {
        showToUser(MESSAGE_INVALID_USERNAME_OR_PASSWORD);
    }

    public void showBlankNameMessage() {
        showToUser(MESSAGE_NO_BLANK_NAME_ALLOWED);
    }

    public void showBlankPasswordMessage() {
        showToUser(MESSAGE_NO_BLANK_PASSWORD_ALLOWED);
    }

    public void showWelcomeMessage() {
        showToUser(MESSAGE_WELCOME, DIVIDER, DIVIDER);
    }

    public void showGoodbyeMessage() {
        showToUser(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    /**
     * Shows the result of a command execution to the user. Includes additional formatting to demarcate different
     * command execution segments.
     */
    public void showResultToUser(CommandResult result) {
        final Optional<List<Drug>> resultDrugs = result.getRelevantDrugs();
        resultDrugs.ifPresent(this::showDrugListView);
        showToUser(result.feedbackToUser, DIVIDER);
    }

    /**
     * Shows a list of strings to the user, formatted as an indexed list.
     */
    private void showToUserAsIndexedList(List<String> list) {
        showToUser(getIndexedListForViewing(list));
    }

    /**
     * Shows a list of drugs to the user, formatted as an indexed list.
     */
    private void showDrugListView(List<Drug> drugs) {
        final List<String> formattedDrugs = new ArrayList<>();
        for (Drug drug : drugs) {
            formattedDrugs.add(drug.toString());
        }
        showToUserAsIndexedList(formattedDrugs);
    }

    /**
     * Formats a list of strings as a viewable indexed list.
     */
    public static String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append(LS);
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
