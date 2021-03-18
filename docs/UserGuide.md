# Healthier | User Guide

## Introduction

Healtheir targets people who care about fitness, who exercise regularly (at least 3 times/week) and have diet plans. It is designed for users of age group 18-30.  
This app is used via **Command Line Interface (CLI)**. If the user is proficient in using command-line tools & typing, then it could be very efficient to use. This app also provides several shortcut commands for advanced users for further efficient operations.

---
## Table of Content
* [Quick start](README.md#quick-start)
* [Features](README.md#features)
* [Command summary](README.md#command-summary)


## Quick Start
This is a cross-platform application, you can run it on any operating system as long as **Java 11** is installed. 
> To verify if you have **Java 11** installed, simply type command `java --version` in your terminal.
1. Download the `tp.jar` file from the [latest release](https://github.com/AY2021S2-CS2113-F10-2/tp/releases).
1. Open a new terminal at the folder where the `Tp.jar` file is located.
1. Run the applictaion use command `java -jar Tp.jar`
1. Refer to the [Features](README.md#features) section below for more info on commands.

## Features 

> **Note:**
> * All commands should be input in `lower_case`. It is always the first word supplied by the user.
> 
>   e.g. `add`, `view`, `delete` etc.
> 
> 
> * Parameters of a command are denoted in `UPPER_CASE`. They must be supplied by the user, otherwise the command will not be recognized.
>   The actual input of the parameters can be in any case. 
>   
>   e.g. in `add XXX`, `XXX` is a parameter which can be used as ``.
> 
> 
> * Redundant parameters for single-word commands (e.g. `help`) will be ignored. 
> 
>    e.g. if the command `help hahahaha` is input, it is equivalent to `help`.
> 
> * After the appliction starts running, it checks if a `data` folder exists in the same directory where `tp.jar` is located.
>   If the folder does not exist, the application will create a new folder `data`, 
>   which is used to store the `data.txt` file which contains details of the user's data.
>
> * The text file `data.txt` will be automatically updated after each operation of the app. 
>

### Get help from instructions on how to use this app : `help`
Adds a to-do type of task to the task list.

Format: `help`

Example: `help`

Expected outcome:
```
```

### Input Exercise Data: `add`
Add one exercise activity with the duration and the date.

Format: `add  t/E a/ACTIVITY_NAME  d/DURATION  [date/DD-MM-YYYY]`

* Add one exercise record. The name of exercise activity `a/ACTIVITY_NAME` and duration `d/DURATION` **MUST** be specified. 
* The name of the exercise should be a `String`.
* The tag value should be `E` in the upper case, which specifies that the current record is for **exercise data**.
* The default unit of duration is in **minutes**. An `integer` is expected for the duration, other formats are **not acceptable**.
* The date of the exercise activity `[date/DD-MM-YYYY]` is optional. If not provided, the system date will be used.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.


Example of usage:  
`add t/E a/running d/40 add one exercise record of running for 40 minutes. `  

Output:  
```
A new exercise activity record is added successfully!
Record summary: 40 minutes running exercise on XX-XX-XXXX(Today).
```
  
`add t/E a/football d/60 date/05-01-2020 add the exercise record of football for 60 mins at the date of 05-01-2020.`  

Output:  
```
A new exercise activity record is added successfully!
Record summary: 60 minutes football exercise on 05-01-2020.
```


### Input Sleep Data: `add`
Add one sleep record with the duration and the date.

Format: `add  t/S  d/DURATION  [date/DD-MM-YYYY]`

* Add one day’s sleep record with a duration. The duration `d/DURATION` **MUST** be specified.
* The tag value should be `S` in the upper case, which specifies that the current record is for **sleep data**.
* The default unit of duration is in **hours**. An `integer` is expected for the duration, other formats are **not acceptable**.
* The date of the sleep record `[date/DD-MM-YYYY]` is optional. If not provided, the system date will be used.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.


Example of usage:  
`add t/S d/7` add one sleep record for 7 hours. 

Output:
```
A new sleep record is added successfully!
Record summary: 7 hours of sleep on XX-XX-XXXX(Today).
```

`add t/S  d/8  date/05-01-2020` add one sleep record of 8 hours on 05-01-2020.

Output:
```
A new sleep record is added successfully!
Record summary: 8 hours of sleep on 05-01-2020.
```

`add t/S  d/5  date/05-01-2020` add one sleep record of 5 hours on the same date again.

Output:
```
A sleep record is already added for the date 05-01-2020.
Please try adding the record for another date or delete the existing record. 
```

### View Sleep Data: `view`
View one sleep record with the duration and the date.

Format: `view  t/S  [date/DD-MM-YYYY]`

* View existing sleep records. The records will be sorted by date in descending order (The latest record will be the first record).
* The tag value should be `S` in the upper case, which specifies that the current record is for **sleep data**.
* The date of sleep record is an optional field used for filtering the records that will be displayed. If none, all existing records will be displayed.
* The date of the sleep record may be specified to view records on the specified date.
* If no record is found on the given date, an error message will be displayed.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.


Example of usage:  
`view t/S` view all sleep records.

Output:
```
Displaying all sleep records:
ndex    Date         Duration 
1        15-01-2020    8 hours
2        05-01-2020    7 hours
```

`view t/S date/05-01-2020` view sleep at the date of 05-01-2020.

Output:
```
Displaying all exercise records on date 05-01-2020:
Index    Date         Duration 
1        05-01-2020    7 hours
```

`view t/S date/05-02-2029`  view sleep at the date of 05-02-2029.

Output:
```
Sorry, no record is found on the date 05-02-2029
```

### Delete Sleep Data: `delete`
Delete existing sleep record.

Format: `delete  t/S i/INDEX`

* Delete a single sleep record using the `Index` of the record.
* The tag value should be `S` in the upper case, which specifies that the current record is for **sleep data**.
* The index of the record must be specified.
* The index must be an integer within the range of the total number of records, index out of range or other formats are not acceptable.

Example of usage:  
`Delete t/S i/1`  delete the exercise record of index 1.

Output:
```
You have successfully deleted the sleep record of index 1!
Record summary: 15-01-2020    8 hours
Displaying current exercise records:
Index    Date         Duration 
1        05-01-2020    8 hours  
```

### Input bodyweight Data: `add`
Add one bodyweight record with the date.

Format: `add  t/W w/WEIGHT [date/DD-MM-YYYY]`

* Add one bodyweight record. The body weight must be specified. 
* The tag value should be `W` in the upper case, which specifies that the current record is for **bodyweight**.
* The default unit of body weight is in kilograms. The body weight should be a `double floating-point number`.
* The date of the bodyweight record is optional. If not provided, the system date will be used.
* The date should be less than or equal to the current date.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.
* There is at most one bodyweight record for each day. An error message will be printed when trying to add a record with the same date as any existing record.

Example of usage:  
`add t/W w/68.5 date/10-01-2021` add a bodyweight record of 68.5kg on 10 Jan 2021.

Output:
```
A new bodyweight record is added successfully!
Record summary: body weight 68.5kg on 10-01-2021.
```

`add t/W w/69`  add a bodyweight record of 69kg.

Output:
```
A new bodyweight record is added successfully!
Record summary: body weight 69kg on XX-XX-XXXX(Today).
```

### Delete Sleep Data: `delete`
Delete existing sleep record.

Format: `delete  t/S i/INDEX`

* Delete a single sleep record using the `Index` of the record.
* The tag value should be `S` in the upper case, which specifies that the current record is for **sleep data**.
* The index of the record must be specified.
* The index must be an integer within the range of the total number of records, index out of range or other formats are not acceptable.

Example of usage:  
`Delete t/S i/1`  delete the exercise record of index 1.

Output:
```
You have successfully deleted the sleep record of index 1!
Record summary: 15-01-2020    8 hours
Displaying current exercise records:
Index    Date         Duration 
1        05-01-2020    8 hours  
```

### View Bodyweight Data: `view`
View existing bodyweight record.

Format: `view  t/W  [date/DD-MM-YYYY]`

* View existing bodyweight records. The records will be sorted by date in descending order (The latest record will be the first record).
* The tag value should be `W` in the upper case, which specifies that the current record is for **bodyweight**.
* The date is an optional field used to view records on the specified date. If none, all existing records will be displayed.
* The date of the bodyweight record is optional. If not provided, the system date will be used.
* The date should be less than or equal to the current date.
* The date should be **less than or equal to** the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.

Example of usage:  
`view t/W` view all bodyweight records

Output:
```
Displaying all bodyweight records: 
Index    Date         Body Weight   
1        15-01-2020   68.5     
2        05-01-2020   69    
```

`view t/W date/05-01-2020` view body weight record at the date of 05-02-2020

Output:
```
Displaying body weight records on date 05-01-2020:
Index    Date         Body Weight 
1        05-01-2020   68.5
```

### Delete Bodyweight Data: `view`
Delete existing bodyweight record.

Format: ` t/W i/INDEX`

* Delete a single bodyweight record using the Index of the record.
* The tag value should be `W` in the upper case, which specifies that the current record is for **bodyweight**.
* The index of the record must be specified. The index must be an `integer` within the range of the total number of records, index out of range or other formats are not acceptable.

Example of usage:  
`Delete t/W i/1` delete the bodyweight record of index 1

Output:
```
You have successfully deleted the bodyweight record of index 1!
Record summary: 15-01-2020   67
Displaying current exercise records:
Index    Date         Body Weight
1        20-01-2020   68
```



## FAQ

**Q**: {?}

**A**: {your answer here}

## Command summary

Action | Format, Examples
--- | ---
Help | `help`

