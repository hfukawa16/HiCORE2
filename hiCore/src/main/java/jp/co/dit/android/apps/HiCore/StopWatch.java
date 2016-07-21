package jp.co.dit.android.apps.HiCore;
/**
 * 特定区間の処理にかかる時間を計測するクラス
 */
public class StopWatch {
 
  private static long start_          = 0;
 
    /**
  * 処理時間の計測を開始します。
    */
 public static void start() {
        start_ = System.nanoTime();
 }
 
   /**
  * 計測開始からの経過ナノ秒を取得します。
   *
   * @return    経過時間
   */
 public static long nanoTime() {
     return System.nanoTime() - start_;
  }
 
   /**
  * 計測開始からの経過マイクロ秒を取得します。
     *
   * @return    経過時間
   */
 public static long microTime() {
        return (System.nanoTime() - start_) / 1000;
 }
 
   /**
  * 計測開始からの経過ミリ秒を取得します。
   *
   * @return    経過時間
   */
 public static long milliTime() {
        return (System.nanoTime() - start_) / 1000000;
  }
 
   /**
  * 計測開始からの経過秒を取得します。
     *
   * @return    経過時間
   */
 public static long secondTime() {
       return (System.nanoTime() - start_) / 1000000000;
   }
 
   /**
  * 計測開始からの経過ナノ秒を標準出力に出力します。
  */
 public static void printNanoTime() {
        System.out.println(nanoTime());
 }
 
   /**
  * 指定したメッセージとともに計測開始からの経過ナノ秒を標準出力に出力します。
     *
   * @param msg    メッセージ
   */
 public static void printNanoTime(String msg) {
      System.out.println(msg + nanoTime());
   }
 
   /**
  * 計測開始からの経過マイクロ秒を標準出力に出力します。
    */
 public static void printMicroTime() {
       System.out.println(microTime());
    }
 
   /**
  * 指定したメッセージとともに計測開始からの経過マイクロ秒を標準出力に出力します。
   *
   * @param msg    メッセージ
   */
 public static void printMicroTime(String msg) {
     System.out.println(msg + microTime());
  }
 
   /**
  * 計測開始からの経過ミリ秒を標準出力に出力します。
  */
 public static void printMilliTime() {
       System.out.println(milliTime());
    }
 
   /**
  * 指定したメッセージとともに計測開始からの経過ミリ秒を標準出力に出力します。
     *
   * @param msg    メッセージ
   */
 public static void printMilliTime(String msg) {
     System.out.println(msg + milliTime());
  }
 
   /**
  * 計測開始からの経過秒を標準出力に出力します。
    */
 public static void printSecondTime() {
      System.out.println(secondTime());
   }
 
   /**
  * 指定したメッセージとともに計測開始からの経過秒を標準出力に出力します。
   *
   * @param msg    メッセージ
   */
 public static void printSecondTime(String msg) {
        System.out.println(msg + secondTime());
 }
}
