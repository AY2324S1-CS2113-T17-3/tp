# Barbara - Project Portfolio Page

## Project : Stocker
Stocker is a Command Line Interface(CLI) app for drug inventory management purposes.
If you can type fast, it can get your inventory management tasks done faster than traditional
GUI apps.

### Summary of Contributions

-**Code contributed** [Link to response contribution graph](https://nus-cs2113-ay2324s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code&since=2023-09-22&tabOpen=true&tabType=authorship&tabAuthor=Barbaracwx&tabRepo=AY2324S1-CS2113-T17-3%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

-**Features implemented**
1) **Find drug by name**
    * What it does: Allows users to search for drugs by its name.
2) **Find drug by date**
    * What it does: Enables users to search for drugs by their expiration date.
3) **List drugs by quantity level**
    * What it does: Provides a list of drugs based on their current quantity, listed according to ascending order.
4) **Set threshold level for each drug**
    * What it does: Allows users to set a threshold quantity for each drug.
5) **List threshold level for all drugs**
    * What it does: Provides a list of threshold levels for all drugs.
6) **Alert function when a drug is below the set threshold level**
    * What it does: Sends alerts when a drug's quantity falls below the user-defined threshold.
7) **Prevent Adding Expired Drugs to Cart**
    * What it does: Displays an error alert when a user attempts to add an expired drug to their cart.
8) **Indicate Expired Drugs in the List**
    * What it does: Adds an (E) next to the entry of any drug with an expired expiration date
9) **Delete Vendor**
    * What it does: Deletes a vendor from the vendors list.


-**Classes implemented**
* `FindCommand`
* `ShowStockLevelCommand`
* `SetThresholdCommand`
* `ListThresholdCommand`
* `DeleteVendorCommand`

-**Contributions to the UG**
* Barbara added documentation for the following sections of
  the user guide:
    * [Find Command](https://ay2324s1-cs2113-t17-3.github.io/tp/UserGuide.html#find---finds-drugs-using-their-name-or-expiry-date)
    * [ShowStockLevel Command](https://ay2324s1-cs2113-t17-3.github.io/tp/UserGuide.html#stockLevel---List-all-drugs-by-quantity-level-in-ascending-order)
    * [SetThreshold Command](https://ay2324s1-cs2113-t17-3.github.io/tp/UserGuide.html#setthreshold---set-the-threshold-quantity-for-a-drug)
    * [ListThreshold Command](https://ay2324s1-cs2113-t17-3.github.io/tp/UserGuide.html#listthreshold---list-all-drugs-and-their-threshold-levels)
    * [DeleteVendor Command](https://ay2324s1-cs2113-t17-3.github.io/tp/UserGuide.html#deletevendor---deletes-a-vendor-into-list-of-vendors-being-tracked-by-system)


-**Contributions to the DG**
* Barbara added documentation for the following section of
  the developer guide:
    * [Command Class]()
    * [Parser Class]()
    * [Find Command]()
    * [ShowStockLevel Command]()
    * [SetThreshold Command]()
    * [ListThreshold Command]()
    * [DeleteVendor Command]()
* UML Diagrams
    *[Sequence Diagram for Parser Class]()
    *[Sequence Diagram for Find Command]()

-**Contributions to team-based tasks**
* Maintain issues and milestone tracker
* Updated portions of user/developer docs not specific to a feature eg: user stories, target user profile,
  value proposition
* Kept up to date weekly deliverables during meetings

**Providing Assistance**
- Offered support by explaining concepts and providing help with code to group mates facing challenges.





