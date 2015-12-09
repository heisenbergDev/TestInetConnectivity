/*******************************************************************************
 * Copyright (c) 2015 Mario Villacé
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 *******************************************************************************/
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
			try {sock.close();}
			catch (IOException e) {testResult.setResultText("Error closing socket!");}
		}
		return testResult;
	}	
}
