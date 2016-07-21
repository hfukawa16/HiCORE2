package jp.co.dit.android.apps.HiCore.DataContainer;

import java.util.ArrayList;

public class DailyShiftDataLine extends DailyShiftData{

	/**
	 *
	 */
	private static final long serialVersionUID = 6772258925090099948L;
	/**
	 *  このクラスで管理する日の勤務および、通信データのリストです。
	 */
	private ArrayList<DailyShiftData> dailyShift = new ArrayList<DailyShiftData>();

	/**
	 * 日の勤務状態や通信データを追加します。
	 */
	public void addDailyShift(DailyShiftData dailyShiftData) {
		dailyShift.add(dailyShiftData);
	}
	public void removeDailyShift(DailyShiftData dailyShiftData) {
		dailyShift.remove(dailyShiftData);
	}

	public void Clear() {
		dailyShift.clear();
	}

	public ArrayList<DailyShiftData> getChildren() {
		return dailyShift;
	}
	/*
	 * 以降は必要に応じてメソッド追加
	 */
}
