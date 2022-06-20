all:
	javac UDPClient.java  
	# java UDPCliente.class
	javac UDPServer.java
	java UDPServer
	
clean:
	rm -f *.class