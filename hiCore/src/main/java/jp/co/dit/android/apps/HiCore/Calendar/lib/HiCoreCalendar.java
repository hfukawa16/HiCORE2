package jp.co.dit.android.apps.HiCore.Calendar.lib;

import java.util.Calendar;
import java.util.GregorianCalendar;

import jp.co.dit.android.apps.HiCore.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ViewFlipper;

/**
 * HiCore勤務表専用のカレンダー表示レイアウトクラス
 *
 * 表示するActivityクラスにて下記のメソッド実装が必要です
 *
 * @Method cal_DayOnClick : 日付表示領域の押下時イベント
 *
 * @param
 */
public class HiCoreCalendar extends FrameLayout {

	// カレンダ日付
	private Calendar cal;
	private int init_YYYY; // 初期表示年
	private int init_MM; // 初期表示月
	private Boolean flg_Flipper; // Flipper状態　true=1st画面 flase=2nd画面

	Animation inFromRightAnimation;
	Animation inFromLeftAnimation;
	Animation outToRightAnimation;
	Animation outToLeftAnimation;
	ViewFlipper viewFlipper;
	Context _context;

	public HiCoreCalendar(Context context) {
		this(context, null);
	}

	public HiCoreCalendar(Context context, AttributeSet attrs) {
		super(context, attrs);

		// カレンダインスタンス取得
		cal = Calendar.getInstance();

		// 初期表示日時を退避
		init_YYYY = cal.get(Calendar.YEAR);
		init_MM = cal.get(Calendar.MONTH) + 1;

		// layoutフォルダーからxmlファイルを取得
		LayoutInflater a = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		// カレンダーレイアウトxmlを取得してインスタンス化
		View v = a.inflate(R.layout.calendar, this, false);

		// 表示Viewにカレンダーレイアウトを追加
		addView(v);

		// アニメーション用設定
		_context = context;
		viewFlipper = (ViewFlipper) findViewById(R.id.flipper);
		setAnimations();
		flg_Flipper = true;

	}

	/**
	 * 初期表示日付で再描画
	 *
	 * @param
	 * @return
	 */
	public void initHiCoreCalendar() {
		drawHiCoreCalendar(init_YYYY, init_MM);
	}

	/**
	 * 指定された移動月数分で表示領域を描画
	 *
	 * @param MoveMM
	 *            表示移動月数
	 * @return
	 */
	public void HiCoreCalendarAddMonth(int MoveMM) {

		cal.add(Calendar.MONTH, MoveMM);

		if (flg_Flipper) {
			flg_Flipper = false;
		} else {
			flg_Flipper = true;
		}

		// ヘッダー設定
		drawHiCoreCalendarTitle();

		// 日付部設定
		drawHiCoreCalendarDay();

		// 日付部アニメーション
		if (MoveMM > 0) {
			viewFlipper.setInAnimation(inFromRightAnimation);
			viewFlipper.setOutAnimation(outToLeftAnimation);
			viewFlipper.showNext();
		} else {
			viewFlipper.setInAnimation(inFromLeftAnimation);
			viewFlipper.setOutAnimation(outToRightAnimation);
			viewFlipper.showPrevious();
		}

	}

	/**
	 * 指定された年月で表示領域を描画
	 *
	 * @param YYYY
	 *            表示年
	 * @param MM
	 *            表示月 01～12
	 * @return
	 */
	public void drawHiCoreCalendar(int YYYY, int MM) {

		int MoveMM_flg = 0;


		//未来日から当日に戻った場合
		if (YYYY < cal.get(Calendar.YEAR)){
			MoveMM_flg = -1;
		//過去日から当日に戻る
		}else if (YYYY > cal.get(Calendar.YEAR)){
			MoveMM_flg = 1;
		//未来日から当日に戻る
		}else if (MM < cal.get(Calendar.MONTH) + 1){
			MoveMM_flg = -1;
		//過去日から当日に戻る
		}else if (MM > cal.get(Calendar.MONTH) + 1){
			MoveMM_flg = 1;
		}


		// 現在表示月が初期月と違っている場合はアニメーション動作する
		if (MoveMM_flg != 0) {
			if (flg_Flipper) {
				flg_Flipper = false;
			} else {
				flg_Flipper = true;
			}
		}

		// 指定年月の1日にセット
		cal.set(YYYY, MM - 1, 01);

		// ヘッダー設定
		drawHiCoreCalendarTitle();

		// 日付部設定
		drawHiCoreCalendarDay();


		// 日付部アニメーション
		if (MoveMM_flg > 0) {
			viewFlipper.setInAnimation(inFromRightAnimation);
			viewFlipper.setOutAnimation(outToLeftAnimation);
			viewFlipper.showNext();
		} else if (MoveMM_flg < 0){
			viewFlipper.setInAnimation(inFromLeftAnimation);
			viewFlipper.setOutAnimation(outToRightAnimation);
			viewFlipper.showPrevious();
		}


	}

	/**
	 * ヘッダーの年月を描画
	 *
	 * @param
	 * @return
	 */
	private void drawHiCoreCalendarTitle() {

//		 tblBtn;

		// 引数の年月から設定の為の要素を取得
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;

		// 年月タイトル設定
		String strDate = year + "/" + month;
		TextView tblBtn = (TextView) findViewById(R.id.calendar_date);
		tblBtn.setText(strDate);

	}

	/**
	 * ディテール部の日数を描画
	 *
	 * @param
	 * @return
	 */
	public void drawHiCoreCalendarDay() {

		TableLayout tbl;
		TableRow tblRow;
		Button tblBtn;

		// 引数の年月から設定の為の要素を取得
		int startWeek = cal.get(Calendar.DAY_OF_WEEK);
		int endDay = cal.getActualMaximum(GregorianCalendar.DATE);
		int selCount = 0;
		int setDayCount = 0;

		// 日付部のテーブルレイアウト取得
		if (flg_Flipper) {
			tbl = (TableLayout) findViewById(R.id.calendar_day_table_1);
		} else {
			tbl = (TableLayout) findViewById(R.id.calendar_day_table_2);
		}

		// 日付部のテーブルレイアウトの行数分処理（8週分）
		for (int i = 0; i < tbl.getChildCount(); i++) {

			// テーブルレイアウトに設定されているTableRowの取得
			tblRow = (TableRow) tbl.getChildAt(i);

			// TableRowの設定Button数分処理（7日分）
			for (int j = 0; j < tblRow.getChildCount(); j++) {
				// TableRowに設定されているButtonの取得
				tblBtn = (Button) tblRow.getChildAt(j);

				selCount++; // 設定セルカウンタＵＰ

				// 背景のデフォルト設定
				Drawable d = getResources().getDrawable(R.drawable.cal_ca0);
				tblBtn.setBackgroundDrawable(d);

				// 日数テキストの設定
				if (selCount < startWeek) {
					// 月初以前のカラム設定
					tblBtn.setText("");
					tblBtn.setEnabled(false);
				} else if (setDayCount < endDay) {
					// 表示日カラムの設定
					setDayCount++;
					tblBtn.setText(Integer.toString(setDayCount));
					tblBtn.setEnabled(true);
				} else {
					// 月末以降のカラム設定
					tblBtn.setText("");
					tblBtn.setEnabled(false);
				}
			}
		}

	}

	public Calendar getCal() {
		return cal;
	}

	protected void setAnimations() {
		inFromRightAnimation = AnimationUtils.loadAnimation(_context,
				R.anim.calendar_right_in);
		inFromLeftAnimation = AnimationUtils.loadAnimation(_context,
				R.anim.calendar_left_in);
		outToRightAnimation = AnimationUtils.loadAnimation(_context,
				R.anim.calendar_right_out);
		outToLeftAnimation = AnimationUtils.loadAnimation(_context,
				R.anim.calendar_left_out);
	}

	/**
	 * ディテール部の日の「デフォルト」描画変更設定
	 *
	 * @param DD
	 *            変更対象日
	 * @return
	 */
	public void setDayDrawCA0(String DD) {
		this.setDayDrawCA0(Integer.parseInt(DD));
	}

	public void setDayDrawCA0(int DD) {
		this.setDayDraw(DD, 0);
	}

	/**
	 * ディテール部の日の「未入力」描画変更設定
	 *
	 * @param DD
	 *            変更対象日
	 * @return
	 */
	public void setDayDrawCA1(String DD) {
		this.setDayDrawCA1(Integer.parseInt(DD));
	}

	public void setDayDrawCA1(int DD) {
		this.setDayDraw(DD, 1);
	}

	/**
	 * ディテール部の日の「仮登録」描画変更設定
	 *
	 * @param DD
	 *            変更対象日
	 * @return
	 */
	public void setDayDrawCA2(String DD) {
		this.setDayDrawCA2(Integer.parseInt(DD));
	}

	public void setDayDrawCA2(int DD) {
		this.setDayDraw(DD, 2);
	}

	/**
	 * ディテール部の日の「承認待ち」描画変更設定
	 *
	 * @param DD
	 *            変更対象日
	 * @return
	 */
	public void setDayDrawCA3(String DD) {
		this.setDayDrawCA3(Integer.parseInt(DD));
	}

	public void setDayDrawCA3(int DD) {
		this.setDayDraw(DD, 3);
	}

	/**
	 * ディテール部の日の「総務確定」描画変更設定
	 *
	 * @param DD
	 *            変更対象日
	 * @return
	 */
	public void setDayDrawCA4(String DD) {
		this.setDayDrawCA4(Integer.parseInt(DD));
	}

	public void setDayDrawCA4(int DD) {
		this.setDayDraw(DD, 4);
	}

	/**
	 * ディテール部の日の「差戻し」描画変更設定
	 *
	 * @param DD
	 *            変更対象日
	 * @return
	 */
	public void setDayDrawCA5(String DD) {
		this.setDayDrawCA5(Integer.parseInt(DD));
	}

	public void setDayDrawCA5(int DD) {
		this.setDayDraw(DD, 5);
	}

	/**
	 * ディテール部の日の「総務承認待ち」描画変更設定
	 *
	 * @param DD
	 *            変更対象日
	 * @return
	 */
	public void setDayDrawCA6(String DD) {
		this.setDayDrawCA6(Integer.parseInt(DD));
	}

	public void setDayDrawCA6(int DD) {
		this.setDayDraw(DD, 6);
	}

	/**
	 * ディテール部の日の描画変更設定
	 *
	 * @param DD
	 *            変更対象日
	 * @param COLOR
	 *            0:デフォルト 1:未入力 2:仮登録 3:承認待ち 4:総務確定 5:差戻し 6:総務承認待ち
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public void setDayDraw(int DD, int COLOR) {

		TableLayout tbl;
		TableRow tblRow;
		Button tblBtn;

		// 引数の年月から設定の為の要素を取得
		int startWeek = cal.get(Calendar.DAY_OF_WEEK);
		int selCount = 0; // 表示セル位置
		int rowCount = 0; // 表示row位置
		int btnCount = 0; // 表示ボタン位置

		// 日付部のテーブルレイアウト取得
		if (flg_Flipper) {
			tbl = (TableLayout) findViewById(R.id.calendar_day_table_1);
		} else {
			tbl = (TableLayout) findViewById(R.id.calendar_day_table_2);
		}

		// 対象日が表示されているTableRow位置と、Button位置の算出
		selCount = DD + startWeek - 2; // 表示セル数算出(0起点)
		rowCount = selCount / 7; // 表示row位置算出
		btnCount = selCount % 7; // 表示ボタン位置算出

		// 対象TableRowの取得
		tblRow = (TableRow) tbl.getChildAt(rowCount);

		// 対象Buttonの取得
		tblBtn = (Button) tblRow.getChildAt(btnCount);

		// 背景設定
		Drawable d = null;
		switch (COLOR) {
		case 0:
			d = getResources().getDrawable(R.drawable.cal_ca0);
			break;
		case 1:
			d = getResources().getDrawable(R.drawable.cal_ca1);
			break;
		case 2:
			d = getResources().getDrawable(R.drawable.cal_ca2);
			break;
		case 3:
			d = getResources().getDrawable(R.drawable.cal_ca3);
			break;
		case 4:
			d = getResources().getDrawable(R.drawable.cal_ca4);
			break;
		case 5:
			d = getResources().getDrawable(R.drawable.cal_ca5);
			break;
		case 6:
			d = getResources().getDrawable(R.drawable.cal_ca6);
			break;
		}
		tblBtn.setBackgroundDrawable(d);

	}

	public void setInit_YYYY(int init_YYYY) {
		this.init_YYYY = init_YYYY;
	}

	public void setInit_MM(int init_MM) {
		this.init_MM = init_MM;
	}

	public int getInit_YYYY() {
		return init_YYYY;
	}

	public int getInit_MM() {
		return init_MM;
	}


}
