•Server_1 
This program reading the data from program Client_1 which simulate fire detector
Program incudes five classes:
1)Server_1
2)Domen
3)Compare
4)Connect
5)DB

♦Class Server_1 - in this class created interface of application.
♦Class Domen - this class performs the function of addinga new device.
♦Class Compare - function of this class is defintion of a connected client.
♦Class Connect - provides the connection of clients, translate data from clients to class DB and outputs the received data to the output field of application. 
♦Class DB - writes received data to fire system database.

•Client_1
This application simulate fire detector. After running the program you must enter the IP-address of the server application.
Main window of client application includes two textfields. 
First textfield intended for transmission smoke sensor readings.
Second textfield intended for transmission temperature sensor readings.
