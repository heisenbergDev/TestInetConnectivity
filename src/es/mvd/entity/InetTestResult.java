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
package es.mvd.entity;

public class InetTestResult {
	
	private Boolean canConnect = false;
	
	private String resultText;

	public Boolean getCanConnect() {
		return canConnect;
	}

	public void setCanConnect(Boolean canConnect) {
		this.canConnect = canConnect;
	}

	public String getResultText() {
		return resultText;
	}

	public void setResultText(String resultText) {
		this.resultText = resultText;
	}

	@Override
	public String toString() {
		return "InetTestResult [canConnect=" + canConnect + ", resultText=" + resultText + "]";
	}
	
}
