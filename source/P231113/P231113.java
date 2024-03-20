/*
* ----------------------
* 乱数を生成するRandomクラスを利用して、1～6までの整数を表示する
* サイコロプログラムを作成せよ
* ‐‐‐‐‐‐‐‐‐‐‐‐‐---------
*/
import java.util.Random;

public class P231113 {
    public static void main(String[] args) {
        // ----ローカル変数の宣言----
        Random rd = new Random();
        int dice = 0;

        // ----通知----
        System.out.println("サイコロを振ります。");

        // ----処理----
        dice = rd.nextInt(6)+1;

        // ----結果出力----
        System.out.printf("サイコロの目は%dです。",dice);
    }
}
