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

<img src="UML Diagrams/StockerToLoginSystem.png" width="280">

---

### Main data structures

---

#### Implementation

##### Drug

The Drug class is very basic class for now. It only contains the product name as well as it's expiry date, but we will soon add some new properties such as product description, etc...

##### Inventory

The Inventory class is used to keep track of the quantity of product in stock. The hash map seemed to be the most appropriate data structure to match a product id to a quantity and a product entity which are encapsulated in a "StockEntry" class.

##### Cart

The Cart class is used to represent an ongoing transaction : to perform a sale, the vendor can add different products with their respective quantities in a cart which will be deducted from the inventory at the checkout.
To represent this, we chose to use an arraylist of "CartEntry" classes which reprensent a product/quantity tuple.

##### SalesList

The SalesList is used to represent every past sales in order to create some statistics and reports. This class is only a list of subclasses representing validated carts.

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

Architecture Diagram of find command function:

<img src="UML Diagrams/FindCommandArchitectureDiagram.png" width="500">

## 2. Delete Function
The "Delete" function is designed to enable users to remove specific drugs from the inventory based on the drug's name. This component facilitates the management of the inventory by allowing users to remove drugs they no longer need, fully depleted or discontinued.
**Design Considerations**
The design of the "Delete" function takes into account the following considerations:
1. **User-Specified Drug Name:** The function allows users to specify the drug name they want to delete from the inventory.
2. **Data Integrity:** It ensures that the deletion operation maintains the integrity of the inventory data structure, updating it correctly.
   **Implementation and Rationale**
   The "Delete" function is implemented as follows:
- **User-Defined Drug Name:** Users provide the name of the drug they wish to delete.
- **Data Deletion Algorithm:** The function employs data deletion logic to remove the specified drug from the inventory. This involves identifying the drug based on the provided name and removing it from the list.
- **Error Handling:** The function includes error handling to address scenarios where the specified drug is not found in the inventory. In such cases, an appropriate error message is generated.
- **User Feedback:** Upon successful deletion, the function generates a success message confirming the removal of the drug.
  The "Delete" function is an essential feature for managing the inventory, allowing users to keep it up to date and remove unwanted or outdated drugs.
  **Function Methods**
  The "Delete" function includes the following method to achieve its functionality:
- `execute()` - This method is responsible for executing the "Delete" command, removing the drug with the specified name from the inventory. It returns a `CommandResult` containing the outcome of the command execution, which includes a success message upon successful deletion or an error message if the drug is not found in the inventory.
  **Example Usage**
  To illustrate how the "Delete" function works, consider the following example usage:
1. **User Input:** The user initiates the "Delete" command by typing something like the following:
   `delete /n panadol`- This command instructs the program to remove the drug named "paracetamol" from the inventory.
2. **Method Execution:** The `execute()` method within the "DeleteCommand" class is called. It takes the provided drug name as input.
3. **Search Process:** The method processes the deletion by searching for the drug with the specified name in the inventory.
4. **Deletion Operation:** If the drug is found, it is removed from the inventory.
5. **Success Message:** The `CommandResult` is prepared, containing a success message (e.g., "Drug removed from inventory: paracetamol").
6. **User Feedback:** The result is displayed to the user, confirming the successful removal of the drug from the inventory.
   The "Delete" function provides a straightforward way for users to manage the inventory by removing specific drugs as needed.


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

| Priority | Version | As a ...          | I want to ...                                        | So that I can ...                                           |
| -------- | ------- | ----------------- | ---------------------------------------------------- | ----------------------------------------------------------- |
| \* \* \* | v1.0    | Pharmacist        | Add drugs to track what drugs are available in stock | Reduce manual errors                                        |
| \* \* \* | v1.0    | Pharmacist        | Remove drugs to track what are no longer in used     | Ensure compliance                                           |
| \* \* \* | v1.0    | Receptionist      | View a list of products of that category             | Easily obtain an overview of the products                   |
| \* \* \* | v1.0    | First-time user   | See a list of all available actions                  | Better understand how to use the application                |
| \* \* \* | v1.0    | Inventory Manager | Find a specific drug currently in the system         | Check up its details and quantities specifically            |
| \* \* \* | v2.0    | user              | find a to-do item by name                            | locate a to-do without having to go through the entire list |

_(More to be added)_

## Non-Functional Requirements

1. Should work on any mainstream OS as long as it has Java 11 or above installed.

2. Should be able to hold up to 1000 drug entries without a noticeable sluggishness in performance for typical usage.

3. A user with above-average typing speed for regular English text (i.e. not code, not system admin commands) should be
   able to accomplish most of the tasks faster using commands than using the mouse.

_(More to be added)_

## Glossary

- _glossary item_ - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
