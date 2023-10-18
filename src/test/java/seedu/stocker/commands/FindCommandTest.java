package seedu.stocker.commands;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import seedu.stocker.drugs.Inventory;
import seedu.stocker.drugs.Drug;

class FindCommandTest {

    @Test
    public void executeTest() {
        // Create an instance of FindCommand with a keyword
        FindCommand command = new FindCommand("Pa");

        // Create a new inventory
        Inventory inventory = new Inventory();
        Drug drug1 = new Drug("Paracetamol", "12/05/2024", 12L);
        inventory.addDrug(drug1);
        Drug drug2 = new Drug("Panadol", "01/03/2027", 20L);
        inventory.addDrug(drug2);


        // Set the modified inventory for the command
        command.setData(inventory);


        // Define expected output
        String expectedOutput = "1. [Name: Paracetamol, Expiry Date: 12/05/2024, Quantity: 12, " +
                "Name: Panadol, Expiry Date: 01/03/2027, Quantity: 20]" +
                System.lineSeparator() +
                "2. [Name: Paracetamol, Expiry Date: 12/05/2024, Quantity: 12, " +
                "Name: Panadol, Expiry Date: 01/03/2027, Quantity: 20]" +
                System.lineSeparator() +
                System.lineSeparator() +
                "Listed all drugs with the keyword in the inventory.";


        CommandResult actualResult = command.execute();

        // Test the command's execute method with the modified inventory
        assertEquals(expectedOutput, actualResult.getFeedbackToUserFindTest());
    }
}
