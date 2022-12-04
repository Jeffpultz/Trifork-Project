# Trifork-Project
This was an assignment for a job interview

### Known issue
There is some times problem with running the ./gradlew build command i have tested this on a few computers and it works most of the time.
Sadly i don't have a fix for this as of yet and wanted to hand this in a, somewhat timely manner so if it becomes an issue i recommend either opening the project in Intellij and running it from there, Or maybe try to change the docker file in angularassigment to use "gradlew build" instead

# How to use
Download the repository and use **docker-compose up** in the folder.

# How to use the website
So as this was an assignment that I was only allowed to use 15 hours on the website have some flaws so here is a guide on how to use it and see that it works

### Create a person
 1. CPR is 10 numbers without the "-"
 2. press the submit after and refresh the page.
 
 ### Search for a person 
In the search field type the CPR with "-" and then press enter

### Delete a person
Press the cross and refresh the page.

### Edit a person
Press the pencil and the information will be filled out in the form, make the changes and press submit refresh the page




# Some notes about improvements.
I wanted to do some improvements if i had the time, like making more checks for values, and make so you didn't have to refresh to get the new things from the database 

## Other notes
This was a really fun project and made me learn some kotlin and angular. As well as getting a more handson experince with docker
