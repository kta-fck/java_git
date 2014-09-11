import java.net.Inet4Address;
import java.net.InetAddress;

public class remoteCon {
	/**
	 * このクラスは実際にリモートデスクトップ接続を行うものです。
	 *
	 */
	private String remoteAddress = "";
	private String nullAddress = "";

	private remoteCon rCon = new remoteCon();

	private remoteCon() {}

	public remoteCon getInst () {
		/**
		 * remoteConのインスタンスを返します。
		 * @return remoteCon
		 */

		return rCon;
	}

	public void setRemoteAddress(String str) {
		/**
		 * IPアドレスをセットします。
		 *
		 * @param String
		 */

		remoteAddress = str;

	}

	public String getRemoteAddress() {
		/**
		 * セットされたIPアドレスを返します。
		 *
		 * @return String
		 *
		 */
		return remoteAddress;
	}

	public void cleanRemoteAddress() {
		/**
		 * フィールドにセットされたアドレスを初期化します。
		 *
		 */
		remoteAddress = nullAddress;
	}

	public boolean isConnectionEstablished () {
		/**
		 * 接続が確立しているか確認。
		 */
		return true;
	}





	/*
	 * test method
	 *
	 */
	public static void main(String[] args) {

	}




}
