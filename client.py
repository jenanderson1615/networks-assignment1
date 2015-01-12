#!/usr/bin/env python

#################################
#				#
#  Jen Anderson			#
#  CS 372			#
#  Program 1			#
#  client.py			#
#				#	
#################################
 
import socket
import sys

#Get the command line arguements

if len(sys.argv) < 3:
	print "You need to enter a hostname, a port number, and a client handle as command line to use this program.\n"
	sys.exit()
else:
	HOST = sys.argv[1]
	PORT = int(sys.argv[2])
	clientHandle = sys.argv[3]

quitString = '\quit' 
outputString = ''
inputString = ''

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.connect((HOST, PORT))

print 'Welcome to the chat program\n'

#Sending the client handle to the server and getting the server handle
sock.send(clientHandle + '\n')
serverHandle = sock.recv(1024)
serverHandle = serverHandle.rstrip('\n')

var = 1;
while (var == 1):
	outputString = raw_input(': ')
	sock.send(outputString + '\n')
	if outputString == quitString:
		var = 0
		break
	inputString = sock.recv(1024)
	inputString = inputString.rstrip('\n')
	print serverHandle + ": " + inputString
	if inputString == quitString:
		var = 0
		break

sock.close()
print "Socket closed"
