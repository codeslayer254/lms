# lms: Library Management System Implemented using object oriented principles of Java

The LMS provides primarily; books management service. 

Three types of users can access the system; 
administrators, librarians, and the library visitors (guests). The visitors can access the LMS as guests, without the need for any credentials; with the minimum 
access privileges (retrieve the book titles, their availability, and on-shelf locations only). 
The librarians need to use the credentials created by the LMS administrators to access the system. 
The first time access librarians will be prompted to change the password.

LMS users have different level of access according to the account’s type created for them. 
As for the LMS administrators have full control permission throughout the three system panels; administrative control panel, librarian control panel, and guest panel. Administrative panel abilities include adding new books to the library’s books list, Deleting, Modifying book information, searching for a book title, check-in a book, check-out a book, and reporting. librarians abilities are almost the same as the administrator’s, however, the librarian panel does not provide the options to create/delete an LMS account and the option to delete a book record from the full list of the owned books by Knowledgica.


### Software Requirements
**Java:** JDK(>7)

**Jars:** mysql-connector-java-5.1.18-bin.jar, rs2xml.jar

**Server:** MySQL Wamp Server 15.79

### Installation & Set Up Guide
1. Download the project to your local repository directory.

2.Launch Netbeans iDE and import the project as an existing Netbeans project.

3. Add required libraries mysql-connector-java-5.1.18-bin.jar and rs2xml.jar to your project. The 2 jar files are included 
inside the lib folder.

### Database Configuration
1. Download and install [MySQL Wamp Server](https://sourceforge.net/projects/wampserver/). This application uses wampserver3_x86_apache2.4.17_mysql5.7.9_php5.6.15
2. Create a database named library and migrate tables and data to the newly created database by importing the exising library sql schema from library.sql file insde the mysql_db folder.

### Version
1.1.0

### Todos
 - Write Tests
 - Rethink Github Save
 - Add Code Comments
 - Add Night Mode

License
----

MIT
**Free Software, Hell Yeah!**

