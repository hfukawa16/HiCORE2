package jp.co.dit.android.apps.lib;

import java.util.ArrayList;
import java.util.Iterator;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.animation.BounceInterpolator;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;

public class DurmScrollView extends ScrollView implements
		GestureDetector.OnGestureListener {

	// ドラムスクロールプロパティ
	private int DurmFont = 30; // 文字サイズ
	private int DurmLineCount = 4; // 表示行数
	private int DurmLinePadding = 60; // 行間
	private String DurmSelectedString = null; // 選択文字列
	private int DurmSelected = 0; // 選択位置

	// 内部静的変数
	private int layoutPaddingTop = 500; // ドラムレイアウトPaddingTop
	private int layoutPaddingBottom = 1000;// ドラムレイアウト
	private int layoutPaddingRight = 5;// ドラムレイアウト
	private int layoutPaddingLeft = 5;// ドラムレイアウト

	// 内部動的変数
	private int initPosition = 0; // 初期選択位置
	private int DisplayLineSize = DurmFont + DurmLinePadding;
	private int DisplyStartPosition = 0; // 表示開始y座標
	private int DisplyEndPosition = 0; // 表示終了y座標
	private int DurmLineCountOld = 0; // 前回ドラム表示行
	private boolean onDrawFlg = false; // 初回表示判定フラグ

	// ジェスチャディテクタ
	private GestureDetector gestureDetector = null;

	// スクローラー（スクロールエミュレート）
	private Scroller scroller = null;

	// インターフェース
	public static interface OnChangeDurmListener {
		public abstract void OnChangeDurm(String durmSelectedString,
				int durmSelected);
	}

	private OnChangeDurmListener listenere = null;

	// コンストラクタ
	public DurmScrollView(Context context) {
		super(context);
	}

	public DurmScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.init(context, attrs);
	}

	public DurmScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * 初期処理
	 */
	private void init(Context context, AttributeSet attrs) {

		// ジェスチャディテクタ生成して自身にイベントリスナ登録
		gestureDetector = new GestureDetector(context, this);

		// スクロール（バウンドタイプ）のシュミレート生成
		scroller = new Scroller(context, new BounceInterpolator());

		// スクロールビュー設定
		this.setScrollViewSeting();

		// Durmテキストを格納するLinearLayout設定
		this.setDurmLinearLayout();

		// ドラム表示行設定
		this.reDrawDurm();

	}

	// ScrollViewの設定
	private void setScrollViewSeting() {
		// スクロールバー非表示
		this.setVerticalScrollBarEnabled(false);
	}

	// Durmテキストを格納するLinearLayout設定
	private void setDurmLinearLayout() {
		// 表示テキスト格納用LinearLayout設定
		LinearLayout linear = new LinearLayout(this.getContext());
		// 余白設定
		linear.setPadding(layoutPaddingLeft, layoutPaddingTop,
				layoutPaddingRight, layoutPaddingBottom);
		// 縦並び
		linear.setOrientation(LinearLayout.VERTICAL);
		// 背景
		linear.setBackgroundColor(Color.WHITE);
		// パラメータ
//		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
//				LayoutParams.WRAP_CONTENT);
		// LinearLayout登録
//		this.addView(linear, params);
		this.addView(linear);

	}

	/**
	 * ドラムの表示設定
	 *
	 */
	private void reDrawDurm() {

		// LinearLayout取得
		LinearLayout linear = (LinearLayout) this.getChildAt(0);

		// 表示行増
		if (DurmLineCount > DurmLineCountOld) {
			// 予備領域の追加
			for (int i = 0; i < (DurmLineCount - DurmLineCountOld); i++) {
				TextView text = new TextView(getContext());
				text.setHeight(DisplayLineSize);
				linear.addView(text, 0);
			}
		}

		// 表示行減
		if (DurmLineCount < DurmLineCountOld) {
			// 予備領域の削除
			for (int i = 0; i < (DurmLineCountOld - DurmLineCount); i++) {
				linear.removeViewAt(0);
			}
		}

		// 旧表示数の更新
		DurmLineCountOld = DurmLineCount;

		// 表示高さ更新
		this.DisplayLineSize = this.DurmFont + this.DurmLinePadding;

		// 奇数表示する際の調整領域サイズ算出
		int DisplyAdjustSize = 0;
		if ((DurmLineCount % 2) == 0) {
			DisplyAdjustSize = DisplayLineSize / 2;
		}

		// 表示開始位置の算出
		DisplyStartPosition = layoutPaddingTop
				+ (DisplayLineSize * ((DurmLineCount + 1) / 2))
				+ DisplyAdjustSize;

		// 表示終了位置の算出
		int textcount = linear.getChildCount() - DurmLineCount - 1;
		DisplyEndPosition = (textcount * DisplayLineSize) + DisplyStartPosition;

		// ドラムのテキスト部設定
		for (int i = 0; i < linear.getChildCount(); i++) {
			TextView text = (TextView) linear.getChildAt(i);
			text.setTextSize(DurmFont);
			text.setHeight(DisplayLineSize);
		}

		// ドラムの影指定
		this.setFadingEdgeLength((this.DisplayLineSize * (this.DurmLineCount - 1)) / 2);

		// 表示行高の変更によるスクロール位置調整
		this.adjustScroll();

	}

	// 初期表示前の初期選択設定
	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		super.onWindowFocusChanged(hasWindowFocus);

		// 初表示時
		if (!this.onDrawFlg) {

			if (this.initPosition == 0) {
				// 初期位置の指定無しの場合
				this.scrollTo(0, this.DisplyStartPosition);
			} else {
				// 初期位置が指定されている場合
				this.scrollTo(0, this.initPosition);
			}
			// 選択位置取得処理
			this.getDurmSelectitdStatus();
			// 初期表示フラグｏｎ
			this.onDrawFlg = true;
		}

	}

	// ドラムの選択位置取得
	private void getDurmSelectitdStatus() {

		// LinearLayout取得
		LinearLayout linear = (LinearLayout) this.getChildAt(0);

		// 停止スクロール位置（現地点）
		int stopScrollY = this.getScrollY();

		// 停止位置に該当するＬｉｓｔカウント
		this.DurmSelected = (stopScrollY - this.DisplyStartPosition)
				/ this.DisplayLineSize;

		// 停止位置に対する文字列
		TextView text = (TextView) linear.getChildAt(DurmSelected
				+ this.DurmLineCount);
		this.DurmSelectedString = text.getText().toString();

		if (this.listenere != null) {
			listenere.OnChangeDurm(DurmSelectedString, DurmSelected);
		}
	}

	/**
	 * ドラムの表示文字の追加
	 *
	 */
	public void addDurmString(ArrayList<String> DurmList) {
		Iterator<String> it = DurmList.iterator();

		while (it.hasNext()) {
			addDurmString(it.next());
		}
	}

	/**
	 * ドラムの表示文字の追加
	 *
	 */
	public void addDurmString(String string) {
		LinearLayout layout = (LinearLayout) this.getChildAt(0);

//		LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
//				LayoutParams.WRAP_CONTENT);

		TextView text = new TextView(getContext());
		text.setTextColor(Color.BLACK);
		text.setText(string);
		text.setTextSize(DurmFont);
		text.setHeight(DisplayLineSize);
		text.setGravity(Gravity.CENTER_VERTICAL);
//		layout.addView(text, params);
		layout.addView(text);

		this.reDrawDurm();
	}

	/**
	 * ドラムの表示文字の削除
	 *
	 */
	public void removeDurmString(int position) {
		LinearLayout layout = (LinearLayout) this.getChildAt(0);

		layout.removeViewAt(position + this.DurmLineCount);

		this.reDrawDurm();
	}

	public void removeDurmString() {
		LinearLayout layout = (LinearLayout) this.getChildAt(0);

		layout.removeViewAt(layout.getChildCount() - 1);

		this.reDrawDurm();
	}

	/**
	 * ドラムの表示前の最終表示幅設定
	 *
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);

		// Viewの横幅取得
		int width = MeasureSpec.getSize(widthMeasureSpec);
		// Viewの縦幅を表示　行数×行高　で算出
		int height = DisplayLineSize * DurmLineCount;
		// 横幅は規定値、縦幅を算出値
		this.setMeasuredDimension(width, height);

	}

	/**
	 * ドラムのスクロールイベント
	 *
	 */
	@Override
	public void computeScroll() {
		super.computeScroll();
	}

	/**
	 * ドラムのタッチイベント
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		// スクロールを停止
		scroller.forceFinished(true);

		// モーションイベントをジェスチャディテクタにリレー。
		if (gestureDetector.onTouchEvent(event)) {
			return true;
		}

		// タッチアップ時は停止位置を調整
		if (event.getAction() == MotionEvent.ACTION_UP) {
			// 調整スクロール
			this.adjustScroll();
			return true;
		}

		// 他イベントは親にスルー
		super.onTouchEvent(event);
		return true;
	}

	/**
	 * ドラムの調整スクロールの為の移動距離算出（表示枠の真ん中に調整）
	 */
	private int adjustPosition() {

		// 調整スクロール量（返却値）
		int adjustScrollY = 0;

		// スクロール停止位置（現在地点）
		int stopScrollY = this.getScrollY();

		// 最終スクロール位置
		int endScrollY = 0;

		if (stopScrollY < DisplyStartPosition) {
			// 表示開始位置より前の場合
			endScrollY = DisplyStartPosition;
		} else if (stopScrollY > DisplyEndPosition) {
			// 表示終了位置より後の場合
			endScrollY = DisplyEndPosition;
		} else {
			// 上記以外
			// スクロール調整閾値（1行の半分）
			int ajaustJudgmentSize = this.DisplayLineSize / 2;
			// 先頭余白を除いた移動距離
			int moveY = stopScrollY - DisplyStartPosition;
			// 移動行数
			int moveLine = moveY / DisplayLineSize;
			// 余剰移動分
			int surplusY = moveY % DisplayLineSize;

			// 余剰移動が1行の半分を超えていたら次行にスライド
			if (surplusY > ajaustJudgmentSize) {
				moveLine++;
			}
			// 最終位置
			endScrollY = moveLine * DisplayLineSize + DisplyStartPosition;
		}

		// 調整移動距離
		adjustScrollY = endScrollY - stopScrollY;

		return adjustScrollY;
	}

	/**
	 * ドラムの調整スクロール（表示枠の真ん中に調整）
	 */
	private void adjustScroll() {
		// 画面表示されていない場合はスルー
		if (!this.onDrawFlg) {
			return;
		}

		// スクロール調整位置の取得
		int ajaust = this.adjustPosition();

		// スクロールシュミレート
		this.scroller.startScroll(0, this.getScrollY(), 0, ajaust, 500);
		// スクロール実行
		this.post(new Runnable() {

			public void run() {
				// 次移動ポイントセット
				scroller.computeScrollOffset();

				// スクロール
				smoothScrollTo(0, scroller.getCurrY());

				// 移動完了までループ
				if (!scroller.isFinished()) {
					post(this);
				} else {
					// 最後背に選択された情報を取得
					getDurmSelectitdStatus();
				}
			}

		});
	}

	/**
	 * ドラム自動スクロール
	 */
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {

		int MinY = this.DisplyStartPosition - this.DisplayLineSize; // スクロール最小位置
		int MaxY = this.DisplyEndPosition + this.DisplayLineSize; // スクロール最大位置

		// フリックによる自動スクロールシュミレート
		scroller.fling(0, this.getScrollY(), 0, -(int) velocityY, 0, 0, MinY,
				MaxY);

		// スクロール実行
		this.post(new Runnable() {

			public void run() {
				// 次移動ポイントセット
				scroller.computeScrollOffset();

				// スクロール
				smoothScrollTo(0, scroller.getCurrY());

				// 移動完了までループ
				if (!scroller.isFinished()) {
					post(this);
				} else {
					// 最後に調整スクロール
					adjustScroll();
				}
			}

		});
		return true;

	}

	public boolean onDown(MotionEvent motionevent) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	public void onShowPress(MotionEvent motionevent) {
		// TODO 自動生成されたメソッド・スタブ
	}

	public boolean onSingleTapUp(MotionEvent motionevent) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1,
			float f, float f1) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	public void onLongPress(MotionEvent motionevent) {
		// TODO 自動生成されたメソッド・スタブ
	}

	/**
	 * ドラム表示フォントの設定
	 */
	public void setDurmFont(int durmFont) {
		DurmFont = durmFont;
		this.reDrawDurm();// ドラム描写更新
	}

	/**
	 * ドラム表示行数の設定
	 */
	public void setDurmLineCount(int durmLineCount) {
		DurmLineCount = durmLineCount;
		this.reDrawDurm();// ドラム描写更新
	}

	/**
	 * ドラム表示の行間隔の設定
	 */
	public void setDurmLinePadding(int durmLinePadding) {
		DurmLinePadding = durmLinePadding;
		// ドラム描写更新
		this.reDrawDurm();
	}

	public void setDurmSelected(int durmSelected) {
		DurmSelected = durmSelected;

		if (this.onDrawFlg) {
			// 初期描画済みの場合はスクロール
			this.scrollTo(0, (this.DurmSelected * this.DisplayLineSize));
		} else {
			this.initPosition = this.DisplyStartPosition
					+ (this.DurmSelected * this.DisplayLineSize);
		}

	}

	public int getDurmFont() {
		return DurmFont;
	}

	public int getDurmLinePadding() {
		return DurmLinePadding;
	}

	public int getDurmLineCount() {
		return DurmLineCount;
	}

	public void setOnChangeDurmListener(OnChangeDurmListener listenere) {
		this.listenere = listenere;
	}

	public String getDurmSelectedString() {
		return DurmSelectedString;
	}

	public int getDurmSelected() {
		return DurmSelected;
	}

}
