
# Afterpay Touch Coding Exercise

## Table of contents:

* [Challenge statement](./README.md#Challenge-statement)
* [Acceptance Criteria](./README.md#Acceptance-Criteria)
* [Deliverables](./README.md#Deliverables)
* [Setup](./README.md#Setup)
* [Quality Analysis](./README.md#Quality-Analysis)


## Challenge statement
Write a method on a class, which, when given a list transactions, a date and a price threshold T, returns a list of hashed credit card numbers that have been identified as fraudulent for that day.

## Acceptance Criteria
Consider the following credit card fraud detection algorithm:
- A credit card transaction is comprised of the following elements;
    - hashed credit card number
    - timestamp - of format 'year-month-dayThour:minute:second'
    - price - of format 'dollars.cents'
- Transactions are to be received as a comma separated string of elements eg. '10d7ce2f43e35fa57d1bbf8b1e2, 2014-04-29T13:15:54, 10.00'
- A credit card will be identified as fraudulent if the sum of prices for a unique hashed credit card number, for a given day, exceeds the price threshold T.


## Deliverables
- Written in Java 8
- All acceptance criteria to be demonstrable through tests

## Setup
1. Make sure you have Java 8 installed in your machine. 
2. Build app, run tests and quality check from command line:

    ```./gradlew clean build```
    
    (Optional) Please run `chmod +x gradlew` if getting error ./gradlew: Permission denied

## Publish

`./gradlew upload`

## Release

```
./gradlew release \
    -Prelease.useAutomaticVersion=true \
    -Prelease.releaseVersion=1.0.0  \
    -Prelease.newVersion=1.1.0-SNAPSHOT
```

## Quality Analysis

|Name|Report|
|:----:|:---:|
|Test Summary|```../build/reports/tests/test/index.html```|
|Test Coverage|```../build/reports/tests/coverage/index.html```|
|Checkstyle|```../build/reports/checkstyle/main.html```|
|FindBugs|```../build/reports/findbugs/main.html```|
|PMD|```../build/reports/pmd/main.html```|
