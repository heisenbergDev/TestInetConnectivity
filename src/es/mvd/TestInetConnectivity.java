package es.mvd;

import java.util.List;

import es.mvd.entity.InetTestResult;

public class TestInetConnectivity {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Uso: $TestInetConnectivity nombreFicheroIP");
			return;
		}
		String fileNameIP = args[0];
		String outFileNameIP = es.mvd.utils.StringUtils.FastDateFormat() + "_out_" + fileNameIP;

		List<String> systemsToTest = es.mvd.utils.FileUtils.leeFicheroIPPuertos(fileNameIP);
		int numberOfSystemsToTest = (systemsToTest != null)?systemsToTest.size():0;

		if (numberOfSystemsToTest > 0) {
			String[] outputLines = new String [numberOfSystemsToTest];
			for(int i = 0; i< numberOfSystemsToTest; i++){
				String system = systemsToTest.get(i);
				if (system.startsWith("#")) {
					outputLines[i] = system + "\n";
				} else {
					String [] ipPort = system.split(" ");
					if (ipPort.length == 3) {
						System.out.print("Conectando con "+ ipPort[0] +": [ip "+ ipPort[1] +", puerto "+ ipPort[2] +"]. Resultado -> ");
						InetTestResult testResult = es.mvd.utils.NetUtils.testInet(ipPort[1], Integer.parseInt(ipPort[2]));
						String testResultText = testResult.getCanConnect()?"Conecta":"NO CONECTA [" + testResult.getResultText().toUpperCase() + "]";
						System.out.println(testResultText);
						outputLines[i] = testResultText + " -> " + ipPort[0] +" [ip " + ipPort[1] + " , puerto " + ipPort[2] + "].\n";				
					}					
				}
			}
			es.mvd.utils.FileUtils.writeFile(outFileNameIP, outputLines);
		}
	}









}
