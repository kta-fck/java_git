import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;



@SuppressWarnings("serial")
public class settingWindow extends JFrame {


	// クラスフィールド
	String readString = "";
	ArrayList<Object> mstrList = new ArrayList<Object>();
	String fileStr = "";
	File filePath;

	JButton settingButton = new JButton("登録と編集");
	JButton masterButton = new JButton("マスタ^");

	JLabel stnBtnLabel = new JLabel("ユーザーの登録と編集");
	JLabel mstrBtnLabel = new JLabel("ユーザのマスタファイルの選択");

	JCheckBox cnfrmbox = new JCheckBox("接続前に確認を行う");



	GridBagLayout stnGbl = new GridBagLayout();
	GridBagConstraints stnGbc = new GridBagConstraints();



	public settingWindow () {

		setSize(400, 300);
		setTitle("設定画面");
		setLayout(stnGbl);

		stnGbc.gridx = 0; stnGbc.gridy = 0 ;stnGbc.gridwidth = 1;
		stnGbc.weightx = 1.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.HORIZONTAL;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(settingButton, stnGbc);
		getContentPane().add(settingButton);

		stnGbc.gridx = 0; stnGbc.gridy = 1 ;stnGbc.gridwidth = 1;
		stnGbc.weightx = 1.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.HORIZONTAL;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(masterButton, stnGbc);
		getContentPane().add(masterButton);

		stnGbc.gridx = 1; stnGbc.gridy = 0 ;stnGbc.gridwidth = 1;
		stnGbc.weightx = 5.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.BOTH;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(stnBtnLabel, stnGbc);
		getContentPane().add(stnBtnLabel);

		stnGbc.gridx = 1; stnGbc.gridy = 1 ;stnGbc.gridwidth = 1;
		stnGbc.weightx = 5.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.BOTH;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(mstrBtnLabel, stnGbc);
		getContentPane().add(mstrBtnLabel);

		stnGbc.gridx = 0; stnGbc.gridy = 2 ;stnGbc.gridwidth = 2;
		stnGbc.weightx = 1.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.BOTH;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(cnfrmbox, stnGbc);
		getContentPane().add(cnfrmbox);


	}





	public ArrayList<Object> getMasterArrayList (File file) {

	try {
		BufferedReader breader = new BufferedReader(new FileReader(file));

		while(breader.ready()) {
			readString = breader.readLine();
			if (readString != null) {
				System.out.println(readString);
				mstrList.add(readString);
			}
		}
	} catch (IOException e )  {
		System.out.println("ファイル読み込みエラー");
	}
		return mstrList;
	}
}


