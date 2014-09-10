import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/*
 * @TODO
 * 閉じるボタンでプロセス殺すようにする
 *
 *
 */
@SuppressWarnings("serial")
public class matchStringStronger extends JFrame {

	private static matchStringStronger mss = new matchStringStronger();

	JTextField inputField = new JTextField();
	JList outputList = new JList();
	JButton cnctBtn = new JButton("接続");
	JButton stngBtn = new JButton("設定");
	JScrollPane jsp = new JScrollPane(outputList);
	JCheckBox cb = new JCheckBox("接続前に警告を出す。");

	GridLayout gr = new GridLayout(3,1);
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	// ------------------------------------------
	// test
	File testFilePath = new File("C:\\pleiades\\workspace\\java_git\\src\\testmaster.txt"); // Security
	settingWindow sw = new settingWindow();
	ArrayList<Object> testList = sw.getMasterArrayList(testFilePath);




	// ------------------------------------------


	private matchStringStronger() {
		setSize(400, 200);
		setTitle("サジェスト");

		inputField.addKeyListener(new KeyEventMethod());
		cnctBtn.addActionListener(new btnActionEvent());
		stngBtn.addActionListener(new btnActionEvent());
		sw.addWindowListener(new closeChildWindow());
		super.addWindowListener(new closeChildWindow());
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

		gbc.gridx = 1; gbc.gridy = 2 ;gbc.gridwidth = 1;
		gbc.weightx = 1.0; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.VERTICAL;
		gbl.setConstraints(cnctBtn, gbc);
		getContentPane().add(cnctBtn);

		gbc.gridx = 2; gbc.gridy = 2 ;gbc.gridwidth = 1;
		gbc.weightx = 1.0; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.VERTICAL;
		gbl.setConstraints(stngBtn, gbc);
		getContentPane().add(stngBtn);

		// Window表示
		setVisible(true);
	}

	public class KeyEventMethod extends KeyAdapter {

		Object[] search;
		public void keyReleased (KeyEvent ke) {
			ArrayList<Object> searchList = new ArrayList<Object>();
			ArrayList<Object> masterList = new ArrayList<Object>(); // リプレイスの受け入れ先


			Object[] str;
			String text;	// フィールドの値をテキストに代入
			text = inputField.getText();

			// -----------------------------------
			for (Object obb : testList) {
				String[] spltString = obb.toString().split(",");
				String aryString = spltString[0] + "    " + spltString[1];

				masterList.add(aryString);
			}
			// -----------------------------------


			/*
			 * サジェスト機能
			 *
			 */
			Object[] master = masterList.toArray();
			search = master ;

			for (Object obj : search) {
				String chk = obj.toString();
				if (isStrRegResult(chk, text)) {
					searchList.add((Object)chk);	// マッチしたものを代入。
				}
			}


			// ArrayListから配列にしてリストを生成。
			//
			str = searchList.toArray();
			outputList.setListData(str);

			// フィールドが空白になったらListを全削除
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
		 * 「接続」ボタンが押されたときのアクション。
		 *
		 */



		public void actionPerformed(ActionEvent e) {

			JList listStr = outputList;
			Object obj = listStr.getSelectedValue();

			if (e.getSource() == stngBtn) {
				/*
				 * 設定ボタン押したら表示
				 */
				sw.setVisible(true);
				mss.setEnabled(false); // 親フレームをロック
			} else {
				// ---------------------------------------
				// デバッグコード
				// ---------------------------------------
				// 「接続」ボタンを押した時に、選択されているリストのテキストを
				// 取得する。

				String testString = "リストが選択されていません。";
				if (obj != null) {
					testString = obj.toString();	// リストが選択されていない場合、nullになるのでその対応
				}
				System.out.println(testString);
				// ---------------------------------------
			}
		}
	}

	public class closeChildWindow extends WindowAdapter {

		public void  windowClosing (WindowEvent e) {

			if (e.getSource() != sw) {
				System.out.println("プログラム終了");
				System.exit(1);
			} else {

				mss.setEnabled(true);	// ロック解除
				sw.setVisible(false);	// 非表示に

				System.out.println("設定画面終了");
			}

		}


	}
	public boolean isStrRegResult (String ptnBase, String reg) {
        /**
         * このメソッドはstrRegResultと中身は一緒ですが、マッチしなかった場合はfalseを返す
         * ものです。
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
         * このメソッドは正規表現まわりのクラスの使い勝手が悪いような気がしたので
         * パタンマッチさせたい文字列とパタンを引数に取り、その結果を戻り値とする
         * というものです。
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

	// メインクラス
    public static matchStringStronger getWindow() {
    	return mss;
    }

	public static void main(String[] args) {
		matchStringStronger mssWindow = matchStringStronger.getWindow();
	}

}
