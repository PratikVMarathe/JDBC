# JDBC
MySQL Connector Java » 8.0.28 dependency is required 
## INTRODUCTION TO JDBC
1. JDBC stands for Java Database Connectivity.
2. JDBC is used to communicate with the database.
3. JDBC API is the one API which is used to connect with the database.
4. JDBC API uses the Drivers to communicate.
5. JDBC is the standard Java API for independent database connection and is Driver-dependent.
6. It is composed of a number of classes and interfaces that represent a connection to the database.
7. JDBC acts like a translator or an API that translates Java programming language to SQL and vice-versa.

### STEPS TO CONNECT:
1. Load or register the driver
2. Establish Connection
3. Create Statement
  • Statement
  • PreparedStatement
  • CallableStatement
4. Execute Statement
  ► execute():
    • This method is used for all the commands like DDL,DML,DQL.
    • Return type of execute method is Boolean.
    • Return true when DQL commands are used.
    • Return false when other than DQL commands are used.
  ► executeUpdate():
    • This method is used for DML commands
    • Return type is int.
    • DML commands like update,insert,delete.
  ► executeQuery():
    • This method is used for DQL commands
    • Return type is Resultset.
    • This method is used for Select query.
5. Close
