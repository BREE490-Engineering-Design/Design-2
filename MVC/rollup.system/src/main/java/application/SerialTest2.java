package application;

import java.io.IOException;
import java.util.Scanner;

import com.fazecast.jSerialComm.SerialPort;

import arduino.*;

public class SerialTest2 {
	
	public static void main(String[] args) {
		int i = 0;
		Scanner sc = new Scanner(System.in);
		Arduino a = new Arduino();
		SerialPort sp = SerialPort.getCommPort("COM3"); // device name TODO: must be changed
		sp.setComPortParameters(9600, 8, 1, 0); // default connection settings for Arduino
		sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written
		a.setPortDescription("COM3");
		
		//a.getPortDescription().setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0); // block until bytes can be written
		 
		a.openConnection();
		while (i<10) {
			System.out.println(a.serialRead());
			a.serialWrite(sc.nextLine());
			i++;
		
		}
		a.closeConnection();
		
	}
	
	
	
	
  
}