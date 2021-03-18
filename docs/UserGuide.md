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

Examples:
`add t/E a/football d/60 date/05-01-2020 add the exercise record of football for 60 mins at the date of 05-01-2020.`

Output:
```
A new exercise activity record is added successfully!
Record summary: 60 minutes football exercise on 05-01-2020.
```

### View Exercise Data: `view`
View one exercise activity with the duration and the date.

Format: `view  t/E  [a/ACTIVITY_NAME]  [date/DD-MM-YYYY]`

* View existing exercise records. The records will be sorted by date in descending order (The latest record will be the first record).
* The tag value should be `E` in the upper case, which specifies the output for records of exercise data.
* The name and date of the exercise activity are optional fields used for filtering the records that will be displayed. If none, all existing records will be displayed.
* The name of the exercise activity may be specified to view records of the specified exercise activity. The name of the exercise should be a String.
* The date/activity name of the exercise activity may be specified to view records on the specified date.
* The date should be less than or equal to the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.


Example of usage:  
`view t/E a/football `

Output:
```
Displaying all football exercise records: 
Index    Date         Activity   Duration 
1        15-01-2020   football     60 min
2        05-01-2020   football     60 min
```

Examples:
`view t/E date/05-02-2020`

Output:
```
Displaying all exercise records on date 05-02-2020:
Index    Date         Activity   Duration 
1        05-01-2020   football     60 min
```

Examples:
`view t/E view all exercises`

Output:
```
Displaying all exercise records:
Index    Date         Activity   Duration
1        15-01-2020   football     60 min
2        05-01-2020   football     60 min
```

### Delete Exercise Data: `delete`
Delete existing exercise record.

Format: `delete  t/E i/INDEX`

* Delete a single exercise record using the Index of the record.
* The tag value should be `E` in the upper case, which specifies that the operation is for exercise data.
* The index of the record must be specified. The index must be an `integer` within the range of the total number of records, index out of range or other formats are not acceptable.

Example of usage:  
`Delete t/E i/1`

Output:
```
You have successfully deleted the exercise record of index 1!
Record summary: 15-01-2020   football     60 min
Displaying current exercise records:
Index    Date         Activity   Duration 
1        05-01-2020   football     60 min
```

### Input Diet Data: `add`

Add one exercise activity with the duration and the date

Format: `add  t/D f/FOOD_NAME  w/WEIGHT  [date/DD-MM-YYYY]`

* Add one record. The name of diet and weight must be specified. The name of the exercise should be a String.
* The tag value should be `D` in the upper case, which specifies that the current record is for exercise data.
* The default unit of weight is in grams. An `integer` is expected for the duration, other formats are not acceptable.
* The date of the exercise activity is optional. If not provided, the system date will be used.
* The date should be less than or equal to the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.

Examples:
`add t/D a/bread d/400`

Output:
```
A new diet item record is added successfully!
Record summary: 40g bread on XX-XX-XXXX(Today).
```

### View Diet Data: `view`

View diet details on a specific date.

Format: `view  t/D  [a/FOOD_NAME]  [date/DD-MM-YYYY]`

* View existing records. The records will be sorted by date in descending order (The latest record will be the first record).
* The tag value should be `D` in the upper case, which specifies the output for records of exercise data.
* The name and date of the food item are optional fields used for filtering the records that will be displayed. If none, all existing records will be displayed.
* The name of the food may be specified to view records of the specified food. The name of the food should be a `String`.
* The date/ name of the food may be specified to view records on the specified date.
* The date should be less than or equal to the current date.
* The date format should be `DD-MM-YYYY`, other formats are not acceptable.

Examples:
`view t/D a/bread view`

Output:
```
Displaying all bread intake records:
Index    Date         Food Item    Weight
1        15-01-2020   bread        160 g
2        05-01-2020   bread        120 g
```

Examples:
`view t/D date/05-02-2020`

Output:
```
Displaying all diet records on date 05-02-2020:
Index    Date         Food Item    Weight
1        05-01-2020   bread        160 g
```

Examples:
`view t/E`

Output:
```
Displaying all diet records:
Index    Date         Food Item    Weight
1        15-01-2020   bread        160 g
2        05-01-2020   bread        120 g
```
### Delete Diet Data: `delete`

Delete existing exercise record.

Format: `delete  t/D i/INDEX`

* Delete a single diet record using the Index of the record.
* The tag value should be `D` in the upper case, which specifies that the operation is for exercise data.
* The index of the record must be specified. The index must be an `integer` within the range of the total number of records, index out of range or other formats are not acceptable.

Examples:
`Delete t/E i/1`

Output:
```
You have successfully deleted the diet record of index 1!
Record summary: 15-01-2020   bread     60 g
Displaying current diet records:
Index    Date         Diet    Weight
1        05-01-2020   egg     60 g
```

## FAQ

**Q**: {What is the format of date?}

**A**: {The date format should be DD-MM-YYYY}

## Command summary

Action | Format | Examples
--- | --- | --- |
Help | `help`
Input Exercise Data: `add` | `add  t/E a/ACTIVITY_NAME  d/DURATION  [date/DD-MM-YYYY]` | `add t/E a/running d/40`
View Exercise Data: `view` | `view  t/E  [a/ACTIVITY_NAME]  [date/DD-MM-YYYY]` | `view t/E a/football`
Delete Exercise Data: `delete` | `delete  t/E i/INDEX` | `Delete t/E i/1`
Input Diet Data: `add` | `add  t/D f/FOOD_NAME  w/WEIGHT  [date/DD-MM-YYYY]` | `add t/D a/bread d/400`
View Diet Data: `view` | `view  t/D  [a/FOOD_NAME]  [date/DD-MM-YYYY]` | `view t/D a/bread`
Delete Diet Data: `delete` | `delete  t/D i/INDEX` | `Delete t/E i/1`
Input Sleep Data: `add` | `add  t/S  d/DURATION  [date/DD-MM-YYYY]` | `add t/S d/7`
View Sleep Data: `view` | `view  t/S  [date/DD-MM-YYYY]` | `view t/S`
Delete Sleep Data: `delete` | `delete  t/S i/INDEX` | `Delete t/S i/1`
Input bodyweight Data: `add` | `add  t/W w/WEIGHT [date/DD-MM-YYYY]` | `add t/W w/68.5 date/10-01-2021`
View bodyweight Data: `view` | `view  t/W  [date/DD-MM-YYYY]` | `view t/W date/05-01-2020`
Delete bodyweight Data: `delete` | `delete  t/W i/INDEX` | `Delete t/W i/1`