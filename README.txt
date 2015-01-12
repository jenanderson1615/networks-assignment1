Jennifer Anderson
CS 372
Program 1
README.txt


To run the server, type 
	'java server'
into the command line (without the quotes).  Make sure you're in the current directory where both the .class and .java files are located.  The server should start.


In another command line interface, type
	'python client.py [HOSTNAME] [PORTNUMBER] [CLIENT-HANDLE]'
without the quotes.  It starts the client program.  The arguements must be entered in the same order for the program to work.  The server
prints out the port number it is currently using.  Local host was used in testing as the hostname. 


The two programs should be able to chat with each other.  The client must enter the first message and all subsequent messages must be alternating.  
To stop the chat session, either party must enter '\quit' (without the quotes).  The server ends by typing Ctrl C in the command line.  

I wrote and tested this program in the flip server.  


Resources used:
	I used a modified version of the textbook program for the Python Client
	I used the following website when I was having trouble figuring out why my messages were not getting through from the client to the server.
		https://norwied.wordpress.com/2012/04/17/how-to-connect-a-python-client-to-java-server-with-tcp-sockets/
	I also used the Java docs pages for information about setting up the sockets.

