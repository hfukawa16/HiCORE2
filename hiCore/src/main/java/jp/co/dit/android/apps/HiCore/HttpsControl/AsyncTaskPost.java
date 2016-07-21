package jp.co.dit.android.apps.HiCore.HttpsControl;

import java.net.UnknownHostException;

import javax.security.auth.login.LoginException;

import jp.co.dit.android.apps.HiCore.DataBean.BaseBean;
import android.content.Context;



/**
 * バックグラウンドタスク 実行時引数()、進捗単位(Void)、処理結果()
 */
public class AsyncTaskPost extends
		AsyncTaskBase {

	public AsyncTaskPost(Context activity) {
		super(activity);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	protected Integer doInBackground(BaseBean... arg0) {
		// TODO 自動生成されたメソッド・スタブ
		// バックグラウンドで実行
		try {

			for (int i = 0; i < arg0.length; i++) {
				//http通信の実行
				cControl.screenPost(arg0[i]);

				if (cControl.getMessage() != null) {
					return TaskWaring;
				}
			}

		} catch (LoginException e) {
			return TaskError_UnknownUser;
		} catch (UnknownHostException e) {
			return TaskError_UnknownHost;
		} catch (Exception e) {
			return TaskError_Exception;
		}
		return 0;

	}





}
