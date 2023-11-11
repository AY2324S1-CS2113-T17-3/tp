# Developer Guide

## Acknowledgements

1. Reference to AB-3 Developer Guide

- [Source](https://se-education.org/addressbook-level3/DeveloperGuide.html#proposed-undoredo-feature)
- Used as template to structure this Developer Guide

## Design & implementation

<img src="UML Diagrams/Architecture_Diagram.png" width="280">

The architecture diagram given above explains the high level design of the application. The diagram depicts the key
component of the application that enables it to provide its functionalities.

Majority of the app's work is done by the following components

- Login System : Handles user authentication before enabling app usage
- Ui : Asks for user input by handling output messages
- Parser : Makes sense of user input
- Commands : List of various commands
- CommandResult : Execution of various commands

The section below will explain in more detail the design considerations, implementations and rationale of the various
components listed above.

---

### Login System Component

---

The login system component seeks to authenticate and login existing users or register a new user.

#### Design considerations

- There must be a way to check and verify users with a master list
- The search for existing users username and password must be fast
- Master list must be stored separately on hard drive of machine

#### Implementation and rationale

The login system class works in the following way. Upon booting up the application, a txt file
containing a current list of existing users will be loaded into a users attribute within the class in the form of a hash
table.When a user attempts to login to their account, the entered username and password is checked against
the current list of users in the hashtable. If the username and password matches, the user is logged in.

As for registering new users, newly inputted username and password will be saved to the users attribute and this
pair of username and password is then appended to the txt file containing current users. The updated user list will be
loaded into the users attribute when the application is booted up again.

The login system class uses the below methods to achieve its functionality

- `authenticateUserChoice()` -Decides whether the user chooses to register or login
- `newUserCreator()` -Creates a new user for future login
- `loginExistingUser()` -Login existing user
- `loadExistingUsers()` -Load existing users into hashtable for reference

Given below is an example of how the login system class works.

When the user first launches the programme, the Stocker object will be instantiated. The object will
invoke its own `run()` method which will call its own `start()` method. The Stocker object then instantiates a
new UI object which displays the login message by invoking `showLoginMessage()` method. At this point, Stocker object
will also instantiate a new login system object.

The login system object will invoke its own `run()` method to begin the login process. This method begins by loading
existing users into the users attribute of the login system class by `loadExistingusers()` method. it then invokes
`authenticateUserChoice()` to receive an input from the user to whether register or login a user. Based on the input of
the user, either `newUserCreator()` is launched or `loginExistingUser()` methods will be called to register or login a
user.

The following sequence diagram shows how the login system class works when the program is launched.

<img src="UML Diagrams/StockerToLoginSystem.png" width="350">

---

### Parser Component

---

The Parser component is responsible for interpreting user input and converting it into executable commands. It plays a
critical role in bridging the user interface (UI) and the command execution components of the application.

#### Design considerations

- **User Input Parsing:** The Parser must effectively break down user input into its constituent parts, such as the
  command
  keyword and any associated arguments.

- **Command Recognition:** The Parser must recognize the specific command the user intends to execute. This involves
  matching
  the command keyword to a predefined set of commands.

- **Arguments Extraction:** For commands that require additional information, the Parser should correctly extract and
  format
  arguments, ensuring they are ready for command execution.

- **Error Handling:** In cases where the input does not match any recognized command or has formatting errors, the
  Parser
  should generate appropriate error messages.

#### Implementation and rationale

The Parser class is designed to handle these considerations through a well-structured parsing process. Here's how it
works:

1. Splitting User Input: The Parser takes the full user input and splits it into two parts: the command word and the
   remaining arguments.

2. Command Recognition: It matches the command word to a predefined set of commands. If a valid command is recognized,
   it
   proceeds to the next step.

3. Arguments Extraction: Depending on the specific command, the Parser may further parse and extract arguments. For
   instance, for the "AddCommand," it extracts drug-related details like name, expiry date, serial number, and quantity.

4. Command Creation: The Parser creates an instance of the appropriate Command class, passing along any required
   arguments.
   This encapsulates the user's request in an executable command object.

5. Error Handling: If the user input does not match any recognized command or has formatting errors, the Parser
   generates
   an "IncorrectCommand" with an error message, providing feedback to the user.

By structuring the parsing process this way, the application ensures that user input is correctly interpreted and
translated into executable commands for the subsequent phases of the application.

The parser class uses the below method to achieve its functionality

- `parseCommand(String userInput)` - This method takes the user's input as a parameter and processes it to identify the
  command keyword and any associated arguments. It then recognizes the specific command and prepares it for execution.

Given below is an example of how the login system class works.

Suppose a user enters the command `add /n Paracetamol /d 2023-12-31 /s ABC123 /q 100`. The Parser first splits this
input
into the command word "add" and the arguments. It then recognizes the "add" command, extracts the drug details (name,
expiry date, serial number, and quantity), and creates an instance of the "`AddCommand`" with these details. If the user
enters an invalid command or incorrect formatting, the Parser provides feedback to guide the user, ensuring a seamless
interaction between the user and the application.

The Parser is a crucial component that forms the bridge between user intentions and the core functionality of the stock
management system.

The following sequence diagram shows how the parser class works when the program is running.
<img src="UML Diagrams/ParserDiagram.png" width="500">

---

### Command Class

---
The `Command` class serves as a foundational component of the stock management system, acting as a bridge between user
requests and the core functionality of the application. This class is extended by various concrete command classes, each
representing a specific action that a user can perform within the system.

#### Key Components

1. **Inventory**: This represents the collection of drugs and their quantities in stock.

2. **SalesList**: It maintains records of sales transactions.

3. **Cart**: The user's shopping cart, where they can add and remove items.

4. **VendorsList**: This contains information about vendors and suppliers.

#### Design and Purpose

- **Data Access**: It provides access to essential data structures and components of the system, including the inventory
  of
  drugs, sales records, the user's shopping cart, and the list of vendors.
- **Abstraction**: It acts as an abstract command template, defining a common interface for all concrete command classes
  to
  implement.
- **Execution**: It enforces the execution of commands through its abstract execute method, which returns a result that
  may be
  specific to the particular command.
- **Data Initialization**: The class enables the initialization of data dependencies through the setData method,
  ensuring that
  commands have access to the necessary data for their execution.

#### Implementation and Rationale

Prior to execution, the `setData` method is used to provide the required data dependencies to the command. The
extensibility of the `Command` class allows the addition of new commands as the application evolves. Each new command
class extends the Command class and implements its own execute method, providing flexibility for incorporating new
features and functionalities.

Given below is an example of how the Command class works.

Suppose a user adds a new drug to the inventory, using the `AddDrugCommand`.

First, the application sets the necessary data dependencies by invoking the `setData` method. It
provides access to the inventory, sales records, the user's cart, and vendor information.
The `AddDrugCommand` class implements the execute method. Within this method, the logic for adding a new drug
to the inventory is defined. The command verifies the drug details, quantity, and other relevant data. It also ensures
that the drug meets the required criteria.
Upon successful execution, the `AddDrugCommand` class returns a result, which may be a confirmation message such
as "New drug added to the inventory". In case of any issues during execution, an
appropriate error message is returned.

The following sequence diagram shows how the command class works when the program is running.


---

### CommandResult Class

---

The `CommandResult` class is a crucial part of the Stocker application, responsible for providing feedback and results
to the user after executing various commands. It contains a feedback message to describe the outcome of the command
execution, as well as an optional list of relevant elements produced by the command.

**Design Considerations**
The design of the `CommandResult` class considers the following aspects:

1. **Feedback Message:** The class stores a feedback message to inform the user about the outcome of the executed
   command.

2. **Relevant Elements:** For commands that produce a list of relevant elements, the `CommandResult` can store this list
   for display.

**Implementation and Rationale**

The `CommandResult` class is implemented with two constructors and methods to access relevant elements and construct
feedback messages.

- `CommandResult(String feedbackToUser)`: This constructor is used when there are no relevant elements to be included in
  the result. It sets the feedback message.

- `CommandResult(String feedbackToUser, List<T> relevantElements)`: This constructor is used when the command produces a
  list of relevant elements (e.g., a list of drugs). It sets both the feedback message and the list of relevant
  elements.

- `getRelevantElements()`: This method returns an optional list of relevant elements. It can be used to check if
  relevant elements are present.

- `getFeedbackToUser()`: This method returns the feedback message as a string.

- `getFeedbackToUserWithElements()`: This method constructs a feedback message that includes the relevant elements. It
  formats the list of elements with serial numbers (if applicable) and includes the feedback message.

**Example Usage**

The `CommandResult` class is used throughout the Stocker application to provide feedback to the user after executing
commands. For example, when a user issues a `list` command, the `CommandResult` includes a list of drugs produced by the
command along with the success message. The feedback message is then displayed to the user.

The following sequence diagram shows how the Command Result function works.

<img src="UML Diagrams/CommandResultDiagram.png" width="350">

---

### Main data structures

---

#### Implementation

##### Drug

The Drug class is very basic class for now. It only contains the product name as well as it's expiry date, but we will
soon add some new properties such as product description, etc...

##### Inventory

The Inventory class is used to keep track of the quantity of product in stock. The hash map seemed to be the most
appropriate data structure to match a product id to a quantity and a product entity which are encapsulated in a "
StockEntry" class.

##### Cart

The Cart class is used to represent an ongoing transaction : to perform a sale, the vendor can add different products
with their respective quantities in a cart which will be deducted from the inventory at the checkout.
To represent this, we chose to use an arraylist of "CartEntry" classes which reprensent a product/quantity tuple.

##### SalesList

The SalesList is used to represent every past sales in order to create some statistics and reports. This class is only a
list of subclasses representing validated carts.

---

## Commands

---

## 1. Find Function

The "Find" function is designed to enable users to search for specific drugs in the inventory using either the drug's
name or the drugs expiry date. This component assists in locating and retrieving relevant drugs efficiently.

**Design Considerations**
The design of the "Find" function takes into account the following considerations:

1. **Search Criteria:** The function must provide users with the ability to specify each criteria, such as keywords or
   attributes, to filter the items they are looking for.
2. **Search Speed:** To enhance user experience, the search process should be fast and responsive, ensuring that users
   receive search results quickly.

**Implementation and Rationale**

The "Find" function is implemented as follows:

- **User-Defined Search Criteria:** Users provide search criteria, such as keywords, to define what they
  are looking for. The "Find" function processes these criteria to locate relevant items.

- **Search Algorithm:** A robust search algorithm is employed to efficiently scan through the list of items and identify
  those
  that match the specified criteria.

- **Result Presentation:** The function displays the search results, presenting users with a list of items that meet the
  search criteria, allowing them to quickly identify the items they are interested in.

- **User-Friendly Interface:** The "Find" function is integrated into the user interface, making it easily accessible
  and intuitive for users to perform searches.

- **Alternative Consideration:** During the design process, alternative approaches to searching are evaluated to ensure
  the
  most effective and user-friendly method is implemented.

The "Find" function offers a valuable way for users to narrow down their searches, find specific items of interest, and
enhance the usability of the application.

**Function Methods**

The "Find" function includes the following method to achieve its functionality:

- `execute()` - This method is responsible for executing the "Find" command, searching for drugs that match the
  user-specified keyword within the inventory.
- It returns a `CommandResult` containing the outcome of the command execution,
  which includes a success message and a list of found StockEntry objects.

**Example Usage**

To illustrate how the "Find" function works, consider the following example usage:

1. **User Input:** The user initiates the "Find" command by typing something like the following:

`find /n panadol` - This command instructs the program to search for drugs in the inventory based on the name criteria
and the keyword "panadol."

`find /d 12/03/2026` - This command instructs the program to search for drugs in the inventory based on the expiry date
criteria and the keyword "12/03/2026."

`find /s PARC3189` - This command instructs the program to search for drugs in the inventory based on the serial number
criteria and the keyword "PARC3189."

2. **Method Execution:** The `execute()` method within the "FindCommand" class is called. It takes the provided keyword
   and criterion as input.

3. **Search Process:** The method processes the search by iterating through the list of `StockEntry` objects in the
   inventory.
   For each entry, it checks if the `matches` method returns `true`, which means that the drug name or expiry date
   contains the given keyword.
4. **Building Results:** As matching entries are found, they are added to a list called `foundEntries`.
5. **Result Display:** The `CommandResult` is prepared, containing a success message (e.g., "Listed all drugs with the
   keyword
   in the inventory.") and the list of found `StockEntry` objects.
6. `User Feedback:` The result is then displayed to the user, showing a list of drugs in the inventory that match the
   specified keyword.

The following sequence diagram shows how the Find Command function works.

<img src="UML Diagrams/FindCommandDiagram.png" width="350">

---

## 2. ListCommand

The `ListCommand` is responsible for listing all drugs in the inventory. This command retrieves the list of drugs from
the inventory and provides it as part of the command result. If the inventory is empty, it informs the user that the
inventory has no drugs.

### Design Considerations

- **User-Friendly Listing:** The primary goal of the `ListCommand` is to provide a user-friendly way to list all drugs
  in the inventory, enhancing the user's experience in accessing inventory information.

- **Data Presentation:** The design considers how to present the list of drugs in a clear and organized manner to
  provide valuable information to the user.

- **Performance:** The implementation should be optimized to list the inventory efficiently, even if it contains a large
  number of drugs.

### Implementation

The `ListCommand` is implemented as follows:

- **Retrieving Drug List:** The command retrieves the list of drugs from the inventory using the `getAllDrugs` method.

- **Handling Empty Inventory:** It checks if the list of drugs is empty. If the inventory is empty, it returns a
  user-friendly message indicating that the inventory is empty.

- **Listing Drugs:** If the inventory contains drugs, the command constructs a success message and includes the list of
  drugs in the command result.

- **User-Friendly Presentation:** The implementation ensures that the list of drugs is presented in a clear and
  organized format, including relevant details such as drug names, quantities, and other attributes.

- **Optimized Performance:** To enhance user experience, the command is designed to list the inventory efficiently,
  ensuring that users receive search results quickly.

### Function Methods

The `ListCommand` includes the following method to achieve its functionality:

- `execute()`: This method is responsible for executing the `ListCommand`, listing all drugs in the inventory. It checks
  the inventory, prepares a user-friendly result message, and returns a `CommandResult` containing the outcome of the
  command execution, which includes a success message and the list of found `Drug` objects.

### Example Usage

To illustrate how the `ListCommand` works, consider the following example usage:

1. **User Input:** The user initiates the `ListCommand` by entering the following command:

2. **Method Execution:** The `execute()` method within the "ListCommand" class is called.

3. **Inventory Check:** The method checks the inventory to retrieve the list of drugs.

4. **Result Building:** If the inventory contains drugs, the method constructs a success message (e.g., "Listed all
   drugs in the inventory.") and includes the list of drugs with relevant details.

5. **User Feedback:** The result is displayed to the user, showing a clear and organized list of drugs in the inventory.

The "ListCommand" enhances the user's ability to access inventory information efficiently and is designed to handle
various inventory sizes while providing a user-friendly experience.

The following sequence diagram shows how the Find Command function works.

<img src="UML Diagrams/ListCommandDiagram.png" width="350">

---

## 3. ShowStockLevel Command

This command allows users to generate a report displaying the
stock levels of drugs. This report is sorted in ascending order based on the quantity of each drug, providing a clear
overview of the available inventory.

### Design Considerations

- **Stock Level Report**: The primary objective of this command is to create a stock level report, which shows the
  quantity of
  drugs available, allowing users to assess the stock levels efficiently.
- **Sorting**: The report is designed to be sorted by quantity in ascending order to make it easier for users to
  identify
  drugs with lower quantities.

### Implementation

The `ShowStockLevelCommand` is implemented to create a report of drug stock levels sorted in ascending order by
quantity.
It retrieves and sorts the list of stock entries, returning the sorted list in a CommandResult if the inventory is not
empty. If the inventory is empty, it returns a message indicating that.

---

## 4. Delete Command

The "Delete" function is designed to enable users to remove specific drugs from the inventory based on the drug's name,
to remove drugs they no longer need, fully depleted or discontinued.

**Design Considerations**

1. **User-Specified Drug Name:** The function allows users to specify the drug name they want to delete from the
   inventory.

2. **Data Integrity:** It ensures that the deletion operation maintains the integrity of the inventory data structure,
   updating it correctly.

**Implementation and Rationale**

This method is executed when the delete command is invoked. First, it attempts to delete a drug from the inventory
using the inventory.deleteDrug(this.keyToDelete) method. If successful, it retrieves the deleted entry.
If the drug is successfully deleted, it returns a success message.
If the drug is not found (i.e., a DrugNotFoundException is thrown), it returns a failure message.

---

## 5. Help Command

The command is responsible for showing users a list of all possible commands.

**Design Considerations**

The command was designed to print out and show how to use a list of all possible commands in a neat and concise way.

**Implementation and Rationale**

Command will use java's system out to print out all required information with a blank line in between for clarity.

---

## 6. saveDrugs Command

The save command was made as a means to backup user entered drug data into the hard drive of the computer to ensure
previously entered data is saved and accessable whenever the app is launched.

### Design Considerations

The save command had to be implemented in a way to enable direct writing of files onto the hard drive and a function had
to be made to load said file back into the drug inventory upon starting the application.

### Implementation

There is a method to access the drugs within the inventory class. a separate method from the inventory class would then
write the contents of these drugs back to the txt file for saving. This is depicted by the sequence diagram shown below.

<img src="UML Diagrams/SaveCommandDiagram.png" width="350">

Upon booting up the system, a method from the inventory class goes through the contents of the txt file and copies it to
the inventory drug list.

---

## 7. SetThreshold Command

This command allows users to specify a threshold
quantity for a particular drug in the inventory, aiding in better management of stock levels.

### Design Considerations

This command enable users to set a specific threshold quantity for a drug.
The threshold quantity serves as a reference point, indicating the minimum quantity of a drug that should trigger a
restock or reorder.

### Implementation

The default threshold for all drugs is initially set at 100. If a user decides to modify this threshold for a specific
drug, the new threshold will replace the default value for that particular drug.

---

## 8. ListThreshold Command

This command enables users to retrieve a list
of all drugs in the inventory, along with their associated threshold levels.

### Design Considerations

The storage capacity should be size adjustable based on the quantity of items, specifically drugs, and their
corresponding threshold levels added to it.

### Implementation

In order to attain the adjustable storage based on number of items, an ArrayList was used as additional drugs can be
appended to the ArrayList whenever a new entry is required.

---

## 9. addVendor Command

The command was made to add vendors to a list of vendors so as to have access to it when needed.

### Design Considerations

The storage must be size adjustable based on the number of objects, in this case vendors placed into it.

### Implementation

In order to attain the adjustable storage based on number of objects, an ArrayList was used as additional vendors can be
appended to the ArrayList whenever a new entry is required.

---

## 10. deleteVendor Command

It is designed to remove vendors from the list of vendors, ensuring that the system remains organized and up to date.

### Design Considerations

The storage must be size adjustable based on the number of objects, in this case vendors removed from it.

### Implementation

In order to attain the adjustable storage based on number of objects, an ArrayList was used as vendors can be
removed from the ArrayList.

---

## 11. listVendors Command

The command was made to list all vendors being tracked by the system in a neat way to the user

### Design Considerations

The possibility of an empty list had to be considered

### Implementation

The list of vendors could be printed by using streams to efficiently collect and print out the information of vendors

---

## 12. addVendorSupply Command

This method adds a drug to a vendor's supply list in the inventory management system, to track
what vendors supply what products.

### Design Considerations

This method checks if the specified vendor exists and, if so, adds the drug to their supply list.

### Implementation

The execute method in the AddVendorSupplyCommand class checks if a specified vendor exists, adds a drug to their supply
list, and returns a success message. If the vendor is not found, it returns a message indicating that the vendor was
not found.

---

## Product scope

---

### Target user profile

- Works in the field of drug distribution, such as pharmacies and doctors' offices.
- Manages a large inventory of pharmaceuticals with varying details (expiration dates, manufacturers, storage
  conditions).
- Prefers desktop applications for their work.
- Proficient in fast typing.
- Favors typing over mouse interactions.
- Comfortable using Command Line Interface (CLI) applications for efficiency.
- Requires password-protected access to sensitive patient healthcare information.

### Value proposition

**Stocker** is designed to cater to the specific needs of drug distributors by offering the following benefits:

1. Quick access to real-time inventory information.
2. Efficient tracking of incoming stock.
3. Categorization of drugs based on various labels.
4. A prioritized list of urgently needed restocks for timely replenishment.
5. Assistance in generating comprehensive reports for stock turnover analysis.
6. Secure access through individual user accounts to safeguard patient healthcare data.
7. Enhanced user experience for experienced professionals who prefer keyboard commands and CLI interactions for seamless
   stock management.

## User Stories

Priorities: High (must have) - \* \* _, Medium (nice to have) - _ _, Low (unlikely to have) - _

| Priority | Version | As a ...             | I want to ...                                        | So that I can ...                                              |
|----------|---------|----------------------|------------------------------------------------------|----------------------------------------------------------------|
| \* \* \* | v1.0    | Pharmacist           | Add drugs to track what drugs are available in stock | Reduce manual errors                                           |
| \* \* \* | v1.0    | Pharmacist           | Remove drugs to track what are no longer in used     | Ensure compliance                                              |
| \* \* \* | v1.0    | Receptionist         | View a list of products of that category             | Easily obtain an overview of the products                      |
| \* \* \* | v1.0    | First-time user      | See a list of all available actions                  | Better understand how to use the application                   |
| \* \* \* | v1.0    | Inventory Manager    | Find a specific drug currently in the system         | Check up its details and quantities specifically               |
| \* \* \* | v1.0    | user                 | Have a way to login to the system                    | Access the system only if i am allowed to                      |
| \* \*    | v2.0    | System Administrator | Perform regular backup of inventory database         | Safeguard against data loss and system failure                 |
| \* \* \* | v2.0    | Receptionist         | Add vendors supplying drugs into the system          | Keep track of what vendors i am working with                   |
| \* \* \* | v2.0    | Receptionist         | View a list of vendors                               | Easily access a list of contacts for current and future orders |
| \* \* \* | v2.0    | Receptionist         | Add and view vendors' supply lists                   | Keep track of what each vendors' supply                        |
| \* \* \* | v2.0    | Receptionist         | Find which drugs are supplied by which vendors       | Easily access a list of vendors to contact for drug reordering |
| \* \*    | v2.0    | Receptionist         | Add and view descriptions of various drugs           | Easily access usage of products for quick reference            |

_(More to be added)_

## Non-Functional Requirements

1. Should work on any mainstream OS as long as it has Java 11 or above installed.

2. Should be able to hold up to 1000 drug entries without a noticeable sluggishness in performance for typical usage.

3. A user with above-average typing speed for regular English text (i.e. not code, not system admin commands) should be
   able to accomplish most of the tasks faster using commands than using the mouse.

_(More to be added)_

