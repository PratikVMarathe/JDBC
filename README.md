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
3. Create Statement <br>
   - Statement <br>
   - PreparedStatement <br>
   - CallableStatement <br>
4. Execute Statement <br>
   - *execute()*: <br>
    • This method is used for all the commands like DDL, DML, DQL. <br>
    • Return type of execute method is Boolean. <br>
    • Return true when DQL commands are used. <br>
    • Return false when other than DQL commands are used. <br>
   - *executeUpdate()*: <br>
    • This method is used for DML commands <br>
    • Return type is int. <br>
    • DML commands like update, insert, delete. <br>
   - *executeQuery()*: <br>
    • This method is used for DQL commands <br>
    • Return type is Resultset. <br>
    • This method is used for Select query. <br>
5. Close
