import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class settingWindow {


	// クラスフィールド
	String readString = "";
	ArrayList<Object> mstrList;
	String fileStr = "";
	File filePath;

	public settingWindow() {}


	public ArrayList<Object> getMasterArrayList (File file) {


	try {
		BufferedReader breader = new BufferedReader(new FileReader(file));

		while(breader.ready()) {
			readString = breader.toString();
			mstrList.add(readString);
		}
	} catch (IOException e )  {
		System.out.println("ファイル読み込みエラー");
	}
		return mstrList;
	}
}


