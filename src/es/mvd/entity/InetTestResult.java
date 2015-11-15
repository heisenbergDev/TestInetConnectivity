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
