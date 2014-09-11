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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.sun.org.apache.bcel.internal.generic.NEW;



@SuppressWarnings("serial")
public class settingWindow extends JFrame {


	// クラスフィールド
	String readString = "";
	ArrayList<Object> mstrList = new ArrayList<Object>();
	String fileStr = "";
	File filePath;

	JButton settingButton = new JButton("登録と編集");
	JButton masterButton = new JButton("マスタ");

	JLabel stnBtnLabel = new JLabel("ユーザーの登録と編集");
	JLabel mstrBtnLabel = new JLabel("ユーザのマスタファイルの選択");

	JCheckBox cnfrmbox = new JCheckBox("接続前に確認を行う");

	// tabbed pane
	JPanel regAndEditPanel = new JPanel();
	JPanel masterAndSettingPanel = new JPanel();

	JTabbedPane regAndEditPane = new JTabbedPane();

	GridBagLayout stnGbl = new GridBagLayout();
	GridBagConstraints stnGbc = new GridBagConstraints();



	public settingWindow () {

		setBounds(400, 130, 400, 300);

		setTitle("設定画面");
		regAndEditPanel.setLayout(stnGbl);
		masterAndSettingPanel.setLayout(stnGbl);

		// -------------------------------------------------------------------------------------
		// 登録と編集タブ
		stnGbc.gridx = 0; stnGbc.gridy = 0 ;stnGbc.gridwidth = 1;
		stnGbc.weightx = 1.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.HORIZONTAL;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(settingButton, stnGbc);
		regAndEditPanel.add(settingButton);

		stnGbc.gridx = 0; stnGbc.gridy = 1 ;stnGbc.gridwidth = 1;
		stnGbc.weightx = 1.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.HORIZONTAL;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(masterButton, stnGbc);
		regAndEditPanel.add(masterButton);

		stnGbc.gridx = 1; stnGbc.gridy = 0 ;stnGbc.gridwidth = 1;
		stnGbc.weightx = 5.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.BOTH;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(stnBtnLabel, stnGbc);
		regAndEditPanel.add(stnBtnLabel);

		stnGbc.gridx = 1; stnGbc.gridy = 1 ;stnGbc.gridwidth = 1;
		stnGbc.weightx = 5.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.BOTH;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(mstrBtnLabel, stnGbc);
		regAndEditPanel.add(mstrBtnLabel);


		// ---------------------------------------------------------------------------------
		// マスタタブ
		stnGbc.gridx = 0; stnGbc.gridy = 2 ;stnGbc.gridwidth = 2;
		stnGbc.weightx = 1.0; stnGbc.weighty = 1.0; stnGbc.fill = GridBagConstraints.BOTH;
		stnGbc.insets = new Insets(1, 1, 1, 1);
		stnGbl.setConstraints(cnfrmbox, stnGbc);
		masterAndSettingPanel.add(cnfrmbox);


		regAndEditPane.add(regAndEditPanel, "登録と編集");
		regAndEditPane.add(masterAndSettingPanel, "マスタと設定");

		getContentPane().add(regAndEditPane);


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


