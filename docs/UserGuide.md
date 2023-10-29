# User Guide

## Introduction

Stocker v1.o is a desktop app  that will provide quick access to currently available stock, 
track incoming stock and expiration dates, and categorize drugs based on different labels. 
It is optimized for use via a Command Line Interface (CLI). If you can type fast, Stocker 
can get your inventory management tasks done faster than traditional GUI apps.

## Quick Start

{Give steps to get started quickly}

1. Ensure that you have Java 11 or above installed.
1. Down the latest version of `Stocker` from [here](https://github.com/AY2324S1-CS2113-T17-3/tp/releases).

## Features 

### Feature-Login System

Authentication system that allows user to register as a user or login
as an existing user.

### Feature-add

Adds a drug into the inventory list.

### Feature-delete

Deletes a drug being tracked by the system.

### Feature-list

List all drug information that is being tracked by the system.

### Feature-stocklevel

List all drugs by quantity level in ascending order.

### Feature-find

Finds drugs using their name or expiry date.

### Feature-help

List all currently available commands in current version, their 
uses and how to format them in the command line.

### Feature-register

Register a new user into the login system.

### Feature-login

Login an existing user into the system.

### Feature-save

Save existing drugs from inventory list onto a txt file.
File is then used to update inventory list when stocker is ran.

### Feature-add vendor

Adds a vendor into a list to be tracked by the system.

### Feature- list vendors

Displays the name of all vendors being tracked by the system.

## Usage

### `Login System`- Create new user or login existing user

Login system is automatically launched at the start of the programme.

**Registering a user**

> Step 1 : Enter register to select option to register a user.
> 
> Step 2: Enter desired username and password.
> 
> Upon successful creation, registration success message is observed

Expected outcome:

```
Registration successful.
```

**Login an existing user**

> Step 1 : Enter login to select option to login a user.
>
> Step 2: Enter registered username and password.
>
> Upon successful creation, successful login message is observed.

Expected outcome:

```
Login Successful.
```

### `add` - Adds drug into inventory list

Adds a drug to be tracked by the system.

Format:

add /n DRUG_NAME /d EXPIRY_DATE /q QUANTITY


Example of usage:

`add /n Panadol /d 12 June 2026 /q 300
`

Expected outcome:

```
New drug added in the inventory: Panadol
```
### `delete` - Deletes a drug being tracked by the system

Deletes a drug being tracked by the system.

Format:

delete /n DRUG_NAM


Example of usage:

`delete /n Panadol
`

Expected outcome:

```
removed : Panadol
There are now 0 drugs in the system
```
### `list` - List all drug information that is being tracked by the system

List all drug information that is being tracked by the system.

Format:

list


Example of usage:

`list
`

Expected outcome:

```
|| 1. Name: Panadol, Expiry Date: 12 June 2026/  Quantity: 300

Listed all drugs in the inventory.




```

### `list` - List all drug information that is being tracked by the system

List all drug information that is being tracked by the system.

Format:

list


Example of usage:

`list
`

Expected outcome:

```
|| 1. Name: Panadol, Expiry Date: 12 June 2026/  Quantity: 300

Listed all drugs in the inventory.
```

### `stocklevel` - List all drugs by quantity level in ascending order

List all drugs by quantity level in ascending order.

Format:

stocklevel


Example of usage:

`stocklevel
`

Expected outcome:

```
 1. Name: histamine, Expiry date: 101010, Quantity: 10
 2. Name: paracetamol, Expiry date: 101010, Quantity: 50
 3. Name: panadol, Expiry date: 101010, Quantity: 120
 
 Stock Level Report (Sorted by Quantity)
```

### `find` - Finds drugs using their name or expiry date

1. Finds drugs whose **names** contain any of the given keywords.

Format:

find /n panadol


Example of usage:

` find /n KEYWORD 
`
- The search is case-insensitive, meaning that "aspirin" will match "Aspirin."

- The order of the keywords does not matter. For example, "Painkiller Relief" will match "Relief Painkiller."

- Only the drug name is searched.


Expected outcome:

```
1. Name: panadol, Expiry Date: 12 sep, Quantity: 120

Listed all drugs with the keyword in the inventory.
```
2. Finds drugs whose **expiry dates** contain any of the given keywords.

Format:

find /d sep


Example of usage:

` find /d KEYWORD
`

- Only the drug's expiry date is searched.


Expected outcome:

```
1. Name: panadol, Expiry Date: 12 sep, Quantity: 120

Listed all drugs with the keyword in the inventory.
```
### `help` - List currently available commands in current version, their uses and how to format them in the command line

List all currently available commands in current version, 
their uses and how to format them in the command line


Format:

help


Example of usage:

`help
`

Expected outcome:

```
|| 
|| add: Adds a new drug to the drug list. Parameters: NAME, EXPIRY DATE, QUANTITY,  
|| Example: add /n Doliprane /d 12/06/2035 /q 52
|| 
|| delete: Removes a drug from drug list. Parameters: Name  
|| Example: delete <Drug Name>
|| 
|| help: Shows program usage instructions. 
|| Example: help
|| 
|| list: List all drug information that is being tracked by the system. 
|| Example: list
|| 
|| find: Finds drug in inventory using name or expiry date
|| Example: find /n panadol
|| Example: find /d sep
|| 
|| bye: Exits the program.
|| Example: bye
```

### `register` - Register a new user into the system

Asks for user input for a username and password field which
will be used to create a  new user for the system.


Format:

register


Example of usage:

`register`

Expected outcome:

```
Registration Successful.
New User Created.
```

### `login` - login an existing user into the system

Asks for user input for a username and password field which
will be used to check if such a user exists for the system
and log the user in.


Format:

login

Example of usage:

`login`

Expected outcome:

```
Login Sucessful
Welcome Back!
```

### `save` - save existing drugs onto hard drive of computer

Saves existing drugs onto hard drive of computer. The txt file
is then used as reference to update drug inventory when stocker 
is booted up.

Format:

save

Example of usage:

`save`

Expected outcome:

```
Drugs successfully saved.
```

### `addVendor` - adds a vendor into list of vendors being tracked by system

Adds a vendor to be tracked by the system. The enteries are used to form a list of summarised vendors.
is booted up.

Format:

addVendor DRUGNAME

Example of usage:

`addVendor Moderna`

Expected outcome:

```
New vendor added into the vendors list: Moderna
```

### `listVendors` - list all vendors currently being tracked by the system

Displays a list of all vendors currently being tracked by the system.

Format:

listVendors

Example of usage:

`listVendors`

Expected outcome:

```
1. Name : Moderna
Listed all vendors in the list.


## FAQ

**Q**: Can I register with blank username and password

**A**: No. Ensure your entries are not blank.

## Command Summary

* add :   `add /n DRUG_NAME /d EXPIRY_DATE /q QUANTITY`
* delete : `delete /n DRUG_NAME`
* list : `list`
* find : `find /n KEYWORD` or `find /d KEYWORD`
* help : `help`
* register : `register`
* login : `login`
* save : `save`
* add Vendor : `addVendor`
* list Vendor : `listVendors`