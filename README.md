# Project Proposal

John stibbards

For project 1, I will be building an automated build and deployment tool in java. This tool will be used to simplify the process of running the varying commands necessary to build, initialize and test a java program. The primary processes I will focus on for the tool to manage are maven, junit, git, and postgres via docker containers. As there are pre existing tools that already fulfill this goal in java development, the end result for this project will ideally mirror the baseline functionality of one of these tools, such as Jenkins.

## User Stories:

Billiam has built a stock market tracking and helper tool in java. However his program lacks some key features to be a marketable product, namely the ability to pull active changing stock data from the internet and integrate this into his database. In order to fix this problem he has enlisted the help of some additional developers to increase the speed at which these features are integrated, however he would like to provide them with a tool that makes the program easier to build and test.

Joey made a basic java program that does not require web integration and would like to deliver it to friends and clients for use. However in its current state it requires calling several command line commands in order to initialize the database and program itself. He would ideally like this to be easier for a user who is not used to using the command line to achieve in order to use his program.
