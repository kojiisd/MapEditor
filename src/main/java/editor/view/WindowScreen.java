package editor.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.apache.log4j.Logger;

/**
 * ウィンドウにオブジェクトを生成していくスクリーンクラス。
 * 
 * @author yalow
 * 
 */
public class WindowScreen extends JFrame implements Screen {
	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = 1L;

	/** ウィンドウのサイズ */
	private static final Dimension WINDOWSIZE = new Dimension(600, 700);

	private int sizeHeightMax = 700;

	private int sizeWidthMax = 600;

	/** タイトル */
	private static final String TITLE = "Map Editor";

	static Logger logger_ = Logger.getLogger(WindowScreen.class);

	/** マウスの押下状態 */
	private boolean mouseFlag_;

	/**
	 * コンストラクタ。
	 */
	public WindowScreen() {
		mouseFlag_ = false;
		view();
	}

	/**
	 * 画面表示をする。
	 * 
	 */
	private void view() {
		// 各種ウィンドウの設定
		setTitle(TITLE);
		setResizable(false);
		setMaximumSize(new Dimension(sizeWidthMax, sizeHeightMax));
		setSize(WINDOWSIZE);

		// 閉じるボタンを押したらアプリケーションを終了する
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// コンテナの取得
		// Container contentPane = getContentPane();
		// ダブルバッファリングを有効にする
		getRootPane().setDoubleBuffered(true);
		if (logger_.isDebugEnabled()) {
			logger_.debug("ダブルバッファ ： " + getRootPane().isDoubleBuffered());
		}

	}

	/**
	 * メニューをセットする。
	 */
	private void setMenu() {
		// メニューの作成
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("ファイル");
		JMenu menuEdit = new JMenu("編集");

		JMenuItem menuItemFile = new JMenuItem("開く");
		menuItemFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				menuItemFileActionPerformed(event);
			}
		});

		JMenuItem menuItemExit = new JMenuItem("終了");
		// ActionPerformed追加
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				menuItemExitActionPerformed(event);
			}
		});

		menuFile.add(menuItemFile);
		menuFile.add(menuItemExit);

		menuBar.add(menuFile);
		menuBar.add(menuEdit);

		setJMenuBar(menuBar);
	}

	/**
	 * 画面の描画
	 * 
	 * @params graphic
	 */
	public void paint(Graphics graphic) {
		Graphics2D g2 = (Graphics2D) graphic;
		paintTitle(g2);
		setMenu();

		// 画面を再描画する。
		invalidate();
	}

	/**
	 * タイトル画面の描画。
	 * 
	 * @param g2
	 */
	public void paintTitle(Graphics2D g2) {
		logger_.info("タイトル画面を描画します。");
	}

	/**
	 * 終了を選択したときの処理
	 * 
	 * @param event
	 *            イベント
	 */
	private void menuItemExitActionPerformed(ActionEvent event) {
		logger_.debug("アプリケーションを終了します。");
		System.exit(0);
	}

	/**
	 * 開くを選択したときの処理
	 * 
	 * @param event
	 *            イベント
	 */
	private void menuItemFileActionPerformed(ActionEvent event) {
		logger_.debug("ファイルを開きます。");

	}
}
