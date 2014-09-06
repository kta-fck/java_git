package logCheckTool;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class matchStringStronger extends JFrame {


	JTextField inputField = new JTextField();
	JList outputList = new JList();
	JButton cnctBtn = new JButton("�ڑ�");
	JButton stngBtn = new JButton("�ݒ�");
	JScrollPane jsp = new JScrollPane(outputList);
	JCheckBox cb = new JCheckBox("�ڑ��O�Ɍx�����o���B");

	GridLayout gr = new GridLayout(3,1);
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();



	// �팟���l
	Object[] master = {
					 "abc    de"
					,"adcde"
					,"edaddd"
	};

	public matchStringStronger() {
		setSize(400, 200);
		setTitle("Match StringLine Stronger");

		inputField.addKeyListener(new KeyEventMethod());
		cnctBtn.addActionListener(new btnActionEvent());

		setLayout(gbl);

		/*
		* UI
		*/
		gbc.gridx = 0; gbc.gridy = 0 ;gbc.gridwidth = 3;
		gbc.weightx = 1.0; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(1, 1, 1, 1);
		gbl.setConstraints(inputField, gbc);
		getContentPane().add(inputField);

		gbc.gridx = 0; gbc.gridy = 1 ;gbc.gridwidth = 3;
		gbc.weightx = 1.0; gbc.weighty = 5.0; gbc.fill = GridBagConstraints.BOTH;
		gbl.setConstraints(jsp, gbc);
		getContentPane().add(jsp);

//		gbc.gridx = 0; gbc.gridy = 2 ;gbc.gridwidth = 1;
//		gbc.weightx = 1.0; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.VERTICAL;
//		gbl.setConstraints(cb, gbc);
//		getContentPane().add(cb);

		gbc.gridx = 1; gbc.gridy = 2 ;gbc.gridwidth = 1;
		gbc.weightx = 1.0; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.VERTICAL;
		gbl.setConstraints(cnctBtn, gbc);
		getContentPane().add(cnctBtn);

		gbc.gridx = 2; gbc.gridy = 2 ;gbc.gridwidth = 1;
		gbc.weightx = 1.0; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.VERTICAL;
		gbl.setConstraints(stngBtn, gbc);
		getContentPane().add(stngBtn);

	}

	public class KeyEventMethod extends KeyAdapter {

		Object[] search;
		public void keyReleased (KeyEvent ke) {
			ArrayList<Object> searchList = new ArrayList<Object>();

			Object[] str;
			String text;
			text = inputField.getText();

			search = master ;
			for (Object obj : search) {
				String chk = obj.toString();
				if (isStrRegResult(chk, text)) {
					searchList.add((Object)chk);
				}
			}
			str = searchList.toArray();
			outputList.setListData(str);

			// �t�B�[���h���󔒂ɂȂ�����List��S�폜
			if (text.length() == 0) {
				Object[] nulObj = {""};
				str = null;
				searchList.clear();
				outputList.setListData(nulObj);

			}
		}
	}

	public class btnActionEvent extends JFrame implements ActionListener {
		/*
		 * �u�ڑ��v�{�^���������ꂽ�Ƃ��̃A�N�V�����B
		 *
		 */


		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}
	public boolean isStrRegResult (String ptnBase, String reg) {
        /**
         * ���̃��\�b�h��strRegResult�ƒ��g�͈ꏏ�ł����A�}�b�`���Ȃ������ꍇ��false��Ԃ�
         * ���̂ł��B
         */
    	boolean isResult = true;
    	String isNull = strRegResult(ptnBase, reg);
    	if (isNull != null) {
    		isResult = true;
    	} else {
    		isResult = false;
    	}
    	return isResult;
    }

    public String strRegResult (String ptnBase, String reg) {
        /**
         * ���̃��\�b�h�͐��K�\���܂��̃N���X�̎g�����肪�����悤�ȋC�������̂�
         * �p�^���}�b�`��������������ƃp�^���������Ɏ��A���̌��ʂ�߂�l�Ƃ���
         * �Ƃ������̂ł��B
         *
         */

    	Pattern ptnIn = Pattern.compile(reg);
    	Matcher matchIn = ptnIn.matcher(ptnBase);
    	matchIn.find();
    	try {
    		String outStr = matchIn.group();
    		return outStr;

		} catch (Exception e) {
			return null;
		}

    }

	// ���C���N���X
	public static void main(String[] args) {
		matchStringStronger mss = new matchStringStronger();

		mss.setVisible(true);
	}

}
