package jp.co.dit.android.apps.HiCore.DataContainer;

import java.io.Serializable;

/**
 * 勤務表管理での全ての要素の基本となる抽象クラスです。
 * （コンポジットパターン）
 *
 * シリアラズする事を想定中。。
 *
 */
public abstract class DailyShiftData  implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6896718067940583611L;

	/*
	 * 日の勤務状態を追加します。
	 */
	public void DailyShift(DailyShiftData dailyShiftData){

	}
}
