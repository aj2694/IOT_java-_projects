Embedded Systems Project

12/12/2017 v-1
===============================================================================
This code can be used toincorporate Internet of Things into an Embedded System to control the DC motor using an Android Device. 
The Raspberry Pi senses the temperature using a temperature sensor (LM35) and posts the data received on the cloud. Depending on the value of the sensor appropriate action can be taken to control the motor. 
This is achieved using a Node-Red GUI on an Android Application.
===============================================================================
Specifications:
1. The system consists of the Raspberry Pi 2/3 model with NOOBS O.S. installed. 
2.The Raspberry Pi receives the sensor value using SPI Communication  protocol.
3.The Raspberry Pi  sends the status of the sensors to the IBM Bluemix Cloud.
4.The Raspberry Pi sends the sensor value to Node Red Application using MQTT communication protocol.
5.The Node Red application sends status of sensor via email to the authorized person and also displays it on Android device.
6. An GUI is developed for displaying the status of sensor. 
7. The Android phone controls the DC motor remotely.


===============================================================================
Code details:
Please read the code comments to understand detailed working of the code.
===============================================================================

Usage Instructions:
To use this code you need to connect your Raspberry Pi 2 according to the circuit diagram given in the Lab Assignment.

Hardware required for testing:
Objectives:
1.The Raspberry Pi should be able to sense the value of the sensor using SPI communication.
2.The Raspberry Pi should be able to send the value of the sensor to the IBM Bluemix Cloud and display the same on an Android device. 
3.The Android phone should be able to control the toy motor remotely.
4.The students should be able to create a flow using Node Red Application that gets the sensor values from Raspberry Pi using MQTT. Email updates should then be sent to the user regarding the sensor values. 

Use the following commands on Raspberry Pi to run the code
python pathname/adc.py

Use the following commands on Raspberry Pi to run the code
node-red start

===============================================================================
Authors:
Agraja Jahagirdar: ajahagir@uncc.edu
Anish Venkatraman: avena12@uncc.edu

===============================================================================
Citations:
I have used the following online resources while developing my code:
https://github.com/doceme/py-spidev
 https://nodered.org/docs/platforms/android 
https://www.ibm.com/developerworks/library/iot-mobile-phone-iot-device-bluemix-apps-trs/ 
https://diyprojects.io/node-red-install-uninstall-easely-modules-palette-manager/#.Wi3Ped-nHIU
