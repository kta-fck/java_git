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



public class settingWindow extends JFrame {


	// �N���X�t�B�[���h
	String readString = "";
	ArrayList<Object> mstrList = new ArrayList<Object>();
	String fileStr = "";
	File filePath;

	JButton settingButton = new JButton("�ݒ�ƕҏW");
	JButton masterButton = new JButton("�}�X�^");

	JLabel stnBtnLabel = new JLabel("���[�U�[�̓o�^�ƕҏW");
	JLabel mstrBtnLabel = new JLabel("���[�U�̃}�X�^�t�@�C���̑I��");

	JCheckBox cnfrmbox = new JCheckBox("�ڑ��O�Ɋm�F���s��");



	GridBagLayout stnGbl = new GridBagLayout();
	GridBagConstraints stnGbc = new GridBagConstraints();



	public settingWindow () {

		setSize(300, 300);
		setTitle("�ݒ���");
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
		System.out.println("�t�@�C���ǂݍ��݃G���[");
	}
		return mstrList;
	}
}


