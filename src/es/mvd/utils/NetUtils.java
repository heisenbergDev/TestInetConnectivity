package es.mvd.utils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import es.mvd.entity.InetTestResult;

public class NetUtils {

	// Prueba de conexión.
	public static InetTestResult testInet(String site, int port) {
		Socket sock = new Socket();
		InetSocketAddress addr = new InetSocketAddress(site, port);
		InetTestResult testResult = new InetTestResult();
		try {
			sock.connect(addr,3000);
			testResult.setResultText("Connected");
			testResult.setCanConnect(true);
		} catch (IOException e) {
			testResult.setResultText(e.getMessage());
			testResult.setCanConnect(false);
		} finally {
			try {
				sock.close();
			} catch (IOException e) {
				testResult.setResultText("Error closing socket!");
			}
		}
		return testResult;
	}	

}
