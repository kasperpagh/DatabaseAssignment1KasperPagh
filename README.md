# Kasper Roland Pagh database assignement 1


This project is written in java, and as such you need all the usual java stuff to run it (jdk etc.)


I would have very much liked to just provide you with a .jar file, but for some reason i can't get 
java to understand where the entry point for my application is and time is running short :)

Therefore ill just give you the easy way to do it

Clone the code 
$- git clone https://github.com/kasperpagh/DatabaseAssignment1KasperPagh.git

Open the code in you favorite IDE in your favorite OS.
I have only tested in IntelliJ, so you might have to run it through that as well, if it fucks up. 
As I said i'd have liked to make a more "general" way of running it, but i'm drowning in bugs here ^-^).
In case you can make Java understand the manifest file, i have included the class files in the <i>out</i> directory.


Otherwise Please have a look at the main method, within the Main class, where you will find tests of most of 
the DB's functionality, such as various searches and saves and stuff.
(you can run the app, by right-clicking the main in IntelliJ and pressing run)


# About the DB
- Takes entries containing an integer key, and a String value (see main for some examples)
- saves the data as binary ASCII (oh yeah no non-ascii chars either please)
- Saves to the file simply called Data in the project root.
- Has an index (a hashmap) where the individual keys are stored, along with the bit offset of the data 
(eg. {key:1 | "160-580"} meaning that the data belonging to key 1 is between the 160'th and 580'th bit in the DB)
- If you want to recreate the index, you just have to call the setIndexMap method in the Database class, and it will read the file
and recreate the index.



List of features:
- Save
- Read all
- Read one

List of non exsisting features/bugs etc (things you CAN'T DO)
- Delete
- Update
- Find more than one record, but less that all records(so to speak)
- put any numbers in you data.



PS. I know this is kindda lazy (with a lot of holes - yeah i know) but i had my birthday this weekend, so i've been somewhat AFK
I hope you can find some sense to this mess anyways :) 

PPS. Sorry again for providing such platform and IDE specific instructions, i usually hate it myself, when people do that to me.



