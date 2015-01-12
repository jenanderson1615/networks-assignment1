/****************************************
*					*
*  Jen Anderson				*
*  CS 372				*
*  Programming Assignment 1		*
*  server.java				*
*					*	
*  This is my server written in 	*
*  java.  Run this program first	*
*  and it will print out the 		*
*  host name and port number to 	*
*  use with the client program		*
*					*
****************************************/

import java.io.*;
import java.net.*;
 
public class server 
{
	public static void main(String args[]) throws Exception 
	{
		/************************
		* Method Variables	*	
		************************/

		String fromClient = "";
		String toClient = "";
		String endString = "\\quit";
		String serverHandle = "server"; 
		String clientHandle = "";
		int portNumber = 9999;
		ServerSocket server = new ServerSocket(portNumber);
		Console c = System.console();        
		InetAddress hostAddress = server.getInetAddress();		
		boolean run = true;
		
		while (run == true)
		{	
			System.out.println("Waiting for connection.  The host address is " + hostAddress + ".  The port number is " + portNumber + ".\n");

			//The while loop is running and if a connection is initiated, its created	
			Socket client = server.accept();
			System.out.println("A client has connected.\n");
			
			//Create the readers for the connection
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(),true);

			clientHandle = in.readLine();
			out.println(serverHandle);	

			//The inner communication while loop continues til 1 party enters '\quit'
			while((!fromClient.equals(endString)) && (!toClient.equals(endString)))
			{
				fromClient = in.readLine();
				if(fromClient.equals(endString))
				{
					System.out.println("Current client ended connection.\n");
				}
				else
				{
					System.out.println(clientHandle + ": " + fromClient);
					toClient = c.readLine(": ");
					out.println(toClient);
				}
			}
			client.close();

			//clear client information
			clientHandle = "";
			fromClient = "";
			toClient = "";
    		}
	}
}
