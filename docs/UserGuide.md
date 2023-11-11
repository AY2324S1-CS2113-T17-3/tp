# User Guide

## Table of contents

- [Introduction](#introduction)
- [Quick Start](#quick-start)
- [Features](#features)
- [Usage](#usage)
- [FAQ](#faq)
- [Command Summary](#command-summary)

## Introduction

Stocker is a desktop app that will provide quick access to currently available stock,
track incoming stock and expiration dates, and categorize drugs based on different labels.
It is optimized for use via a Command Line Interface (CLI). If you can type fast, Stocker
can get your inventory management tasks done faster than traditional GUI apps.

## Quick Start

1. Ensure that you have Java 11 or above installed.
2. Down the latest version of `Stocker` from [here](https://github.com/AY2324S1-CS2113-T17-3/tp/releases).
3. Copy the absolute filepath to where the jar file is
4. Run the following JAR file with the following command

```
java -jar "<File path of jar file>"
```

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

### Feature-find

Finds drugs using their name or expiry date.

### Feature-help

List all currently available commands in current version, their
uses and how to format them in the command line.

### Feature-register

Register a new user into the login system.

### Feature-login

Login an existing user into the system.

### Feature-saveDrugs

Save existing drugs from inventory list onto a txt file.
File is then used to update inventory list when stocker is ran.

### Feature-add vendor

Adds a vendor into a list tracked by the system.

### Feature-delete vendor

Deletes a vendor into a list tracked by the system.

### Feature-list vendors

Displays the name of all vendors being tracked by the system.

### Feature-add vendor supply

Adds a drug into a vendor's supply list to be tracked by the system.

### Feature-list vendor supply

Displays the list of all drugs being supplied by a particular vendor.

### Feature-find vendor supply

Displays the list of all vendors that supply a particular drug.

### Feature-add to cart

Adds a drug to a virtual shopping cart if the requested quantity is available in the inventory. It keeps track of the
drugs dispensed to customers.

### Feature-view cart

List all drugs and their respective quantities in the current cart. It helps to review the drugs about to be dispensed.

### Feature-checkout

Finalizes the dispensing process by deducting the drugs and quantities in your cart from your inventory. It ensures that
the inventory accurately reflects the items dispensed.

### Feature-add description

Adds a drug's description into a list to be tracked by the system.

### Feature-get description

Retrieves the description of a particular drug.

### Feature-list description

Displays a list of all the descriptions for all corresponding drugs

## Usage

### `Login System`- Create new user or login existing user

Login system is automatically launched at the start of the programme.

**Registering a user**

> Step 1 : Enter register to select option to register a user.
>
> `register`
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
> `login`
>
> Step 2: Enter registered username and password.
>
> Upon successful creation, successful login message is observed.

Expected outcome:

```
Login Successful.
```

Note

### `add` - Adds drug into inventory list

Adds a drug to be tracked by the system.

- Each individual drug is uniquely identified by a serial number.
- If the input data includes the same serial number, name, and expiry date, it will simply increase the quantity of the
  existing drug in the system.
- If the serial number is the same but either the name or expiry date is different, an error will be returned as the
  system expects consistent information for the same serial number.
- If it has a different serial number, a new entry will be added to the inventory for
  that drug.
- If none of the above conditions are met, the system will also add a new entry to the inventory.

Format:

add /n DRUG_NAME /d EXPIRY_DATE /s SERIAL_NUMBER /q QUANTITY /p PRICE

Example of usage:

`add /n Panadol /d 01/02/2024 /s ABC123 /q 52 /p 19.90
`

Expected outcome:

```
|| New drug added in the inventory: Panadol
```

### `delete` - Deletes a drug being tracked by the system

Deletes a drug being tracked by the system.

Format:

delete /s SERIAL_NUMBER

Example of usage:

`delete /s PANA002
`

Expected outcome:

```
|| Drug removed from inventory: Panadol
```

### `list` - List all drug information that is being tracked by the system

List all drug information that is being tracked by the system.

- If a drug has an expired expiry date at any time, it will be indicated with an (E) next to its entry.

Format:

list

Example of usage:

`list
`

Expected outcome:

```
|| Listed all drugs in the inventory.
|| 	1. Name: Panadol, Expiry date: 01/02/2023, Serial number: ABC123, Quantity: 52, Selling Price: 19.9 (E)
|| 	2. Name: Dol, Expiry date: 01/02/2024, Serial number: DOL124, Quantity: 52, Selling Price: 19.9
```

### `stockLevel` - List all drugs by quantity level in ascending order

List all drugs by quantity level in ascending order.

Format:

stockLevel

Example of usage:

`stockLevel
`

Expected outcome:

```
||  1. Name: histamine, Expiry date: 01/02/2024, Quantity: 10
||  2. Name: paracetamol, Expiry date: 01/02/2024, Quantity: 50
||  3. Name: panadol, Expiry date: 01/02/2024, Quantity: 120
||
|| Stock Level Report (Sorted by Quantity)
```

### `find` - Finds drugs using their name or expiry date

1. Finds drugs whose **names** contain any of the given keywords.

Format:

find /n panadol

Example of usage:

`find /n Panadol `

- The search is case-insensitive, meaning that "aspirin" will match "Aspirin."

- Only the drug name is searched.

Expected outcome:

```
||  1. Name: panadol, Expiry Date: 01/02/2024, Serial number: PAN1234, Quantity: 120

|| Listed all drugs with the keyword in the inventory.
```

2. Finds drugs whose **expiry dates** contain any of the given keywords.

Format:

find /d DATE

Example of usage:

`find /d 01/02/2024`

- Only the drug's expiry date is searched.

Expected outcome:

```
||  1. Name: panadol, Expiry Date: 01/02/2024, Serial number: PAN1234, Quantity: 120

|| Listed all drugs with the keyword in the inventory.
```

3. Finds drugs whose **serial number** contain any of the given keywords.

Format:

find /s PAN1234

Example of usage:

`find /s KEYWORD`

- Only the drug's serial number is searched.

Expected outcome:

```
||  1. Name: panadol, Expiry Date: 01/02/2024, Serial number: PAN1234, Quantity: 120

|| Listed all drugs with the keyword in the inventory.
```

### `help` - List currently available commands in current version, their uses and how to format them in the command line

List all currently available commands in current version,
their uses and how to format them in the command line

Format:

help

Example of usage:

`help
`

### `register` - Register a new user into the system

Asks for user input for a username and password field which
will be used to create a new user for the system.

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

### `saveDrugs` - save existing drugs onto hard drive of computer

Saves existing drugs onto hard drive of computer. The txt file
is then used as reference to update drug inventory when stocker
is booted up.

Format:

saveDrugs

Example of usage:

`saveDrugs`

Expected outcome:

```
Drugs successfully saved.
```

### `addVendor` - adds a vendor into list of vendors being tracked by system

- Adds a vendor to be tracked by the system. The entries are used to form a list of summarised vendors.
- The vendor's name is not case-sensitive, meaning 'Pfizer' and 'pfizer' are treated as the same.

Format:

addVendor /v VENDOR_NAME

Example of usage:

`addVendor /v Moderna`

Expected outcome:

```
|| New vendor added into the vendors list: Moderna
```

### `deleteVendor` - deletes a vendor from list of vendors tracked by the system

- Deletes a vendor to be tracked by the system.
- The vendor's name is not case-sensitive, meaning 'Pfizer' and 'pfizer' are treated as the same.

Format:

deleteVendor /v VENDOR_NAME

Example of usage:

`deleteVendor /v Moderna`

Expected outcome:

```
|| Vendor deleted from the vendors list: Pfizer
```

### `listVendors` - list all vendors currently being tracked by the system

Displays a list of all vendors currently being tracked by the system.

Format:

listVendors

Example of usage:

`listVendors`

Expected outcome:

```
||  1. Name : Moderna
||
|| Listed all vendors in the list.
```

### `addVendorSupply` - Adds a drug into a vendor's supply list to be tracked by the system.

- Adds a drug into a vendor's supply list to be tracked by the system
    - Vendor must already be added into the system.
    - If the drug already exists in the vendor's supply list, system will inform user

Format:

addVendorSupply /v VENDOR_NAME /n DRUG_NAME

Example of usage:

`addVendorSupply /v Moderna /n Paracetamol`

Expected outcome:

```
|| New drug added to moderna's supply list: paracetamol
```

Note : As this serves as a catalogue for information related to vendor supply lists, drugs not currently tracked by the
inventory can be added into the supply list.

### `listVendorSupply` - Displays the list of all drugs being supplied by a particular vendor.

Displays the list of all drugs being supplied by a particular vendor.

Format:

listVendorSupply VENDOR_NAME

Example of usage:

`listVendorSupply /v Moderna`

Expected outcome:

```
|| Drugs supplied by moderna: paracetamol, panadol
```

### `findVendorSupply` -Displays the list of all vendors that supply a particular drug.

Displays the list of all vendors that supply a particular drug.

Format:

findVendorSupply /n DRUG_NAME

Example of usage:

`findVendorSupply /n paracetamol`

Expected outcome:

```
|| Vendors supplying the drug paracetamol: moderna, apotheca
```

### `addToCart` - Adds drug into current cart

Adds a drug in a specified quantity in the current cart.

Format:

addToCart /s SERIAL_NUMBER /q QUANTITY

Example of usage:

`addToCart /s PANA01 /q 3
`

Expected outcome:

```
|| New drug added in the cart : Panadol
```

### `viewCart` - Lists all the entries in the cart

Lists all the added drugs, quantity, and total cost in the cart.

Format:

viewCart

Example of usage:

`viewCart
`

Expected outcome:

```
|| 1. Key : Panadole, Quantity: 10
||
|| Listed all the content of your cart.
|| Total Cost of Items in Cart: $39.90
```

### `checkout` - Checks out the current cart

Empty the current cart and retrieve all the specified drugs and quantity from the inventory

- If after checkout, the quantity of a specific drug falls below the set threshold level, it triggers an
  alert.

Format:

checkout

Example of usage:

`checkout
`

Expected outcome:

```
|| The current cart has been checked out.
```

Expected outcome with alert:

```
|| ALERT! Panadol is below the threshold level
|| The current cart has been checked out.
```

### `setThreshold` - Set the threshold quantity for a drug

Set the threshold quantity for a specific drug in your inventory. The threshold quantity is the minimum quantity of the
drug that you want to keep in stock.

Format:

setThreshold /s [Serial number] /tq [Threshold Quantity]

Example of usage:

`setThreshold /s DOL002 /tq 50
`

Expected outcome:

```
|| Threshold quantity set for Doliprane: 50
```

### `listThreshold` - List all drugs and their threshold levels

Retrieve a list of all drugs in your inventory and their corresponding threshold levels. The threshold level is the
minimum quantity of each drug that you want to keep in stock. By default, if the user hasn't specified individual
threshold levels for each
drug, the standard threshold level for all drugs is set at 100.

Format:

listThreshold

Example of usage:

`listThreshold
`

Expected outcome:

```
||  1. Doliprane: 50
||
|| Listed all drugs by threshold level in the inventory.

```

### `addDescription` - Adds a drug's description into a list to be tracked by the system.

Adds a drug's description into a list to be tracked by the system.

Format:

addDescription /n DRUG_NAME /desc DESCRIPTION

Example of usage:

`addDescription /n Panadol /desc Pain Relief
`

Expected outcome:

```
|| New drug description added for Panadol: Pain Relief
```

Note : As this serves as a catalogue for information related to drug usage and their respective descriptions,
drugs not currently tracked by the inventory can be added with a description here. Both lists are separate.

### `getDescription` - Retrieves the description of a particular drug.

Retrieves the description of a particular drug.

Format:

getDescription /n DRUG_NAME

Example of usage:

`getDescription /n Panadol
`

Expected outcome:

```
|| Pain Relief
```

### `listDescriptions` - Displays a list of all the descriptions for all corresponding drugs

Displays a list of all the descriptions for all corresponding drugs

Format:

listDescriptions

Example of usage:

`listDescriptions
`

Expected outcome:

```
|| List of Drug Descriptions:
|| Panadol: Pain Relief
|| Dolo: Stomache Discomfort
```

## FAQ

**Q**: Can i register with blank username and password

**A**: No. Ensure your entries are not blank.

**Q**: Why can i register and login again even after being logged in

**A**: A user is able to login another user or can help to register a new user without rebooting the application

**Q**: Why is my registration and login details not masked

**A**: Masking of input is a security concern that will be developed on in future iterations

## Command Summary

- register : `register`
- login : `login`
- save : `saveDrugs`
- help : `help`
- add : `add /n DRUG_NAME /d EXPIRY_DATE /s SERIAL_NUMBER /q QUANTITY /p PRICE`
- delete : `delete /s SERIAL_NUMBER`
- list : `list`
- find : `find /n KEYWORD` or `find /d KEYWORD`
- add Vendor : `addVendor`
- list Vendor : `listVendors`
- add Vendor Supply : `addVendorSupply /v VENDOR_NAME /n DRUG_NAME`
- list Vendor Supply : `listVendorSupply /v VENDOR_NAME`
- find Vendor Supply : `findVendorSupply /n DRUG_NAME`
- delete Vendor Supply : `deleteVendorSupply /v VENDOR_NAME /n DRUG_NAME`
- add description : `addDescription /n DRUG_NAME /desc DESCRIPTION`
- get description : `getDescription /n DRUG_NAME`
- list descriptions : `listDescriptions`
- list stock level : `stockLevel`
- add drug to cart : `addToCart /s SERIAL_NUMBER /q QUANTITY`
- checks out current cart : `checkout`
- view current cart items : `viewCart`
- set threshold quantity for a drug : `setThreshold /s SERIAL_NUMBER /tq THRESHOLD_QUANTITY`
- list all drugs and threshold levels : `listThreshold`
- bye : `bye`
