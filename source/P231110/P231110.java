/*
 *-------------------------
 * ユーザーが入力した値に応じて、英単語を表示するプログラム
 * if文で記述したと、switch文（case,break）、switch文（->）で記述しなおし
 * 最終的にswitch（->）で完成させよ。
 *
 * 表示例：
 * 1以上の整数を入力してください。
 * 1または2が入力されたとき、”One-two”
 * 3が入力されたとき、”three”
 * 4が入力されたとき、"four"
 * 5が入力されたとき、"five"
 * 条件に当てはまらないとき、"other"
 *
 * また、発生しうるexceptionに対応し、exceptionが発生した場合、
 * エラーメッセージを表示して初めから入力をやり直す。
 * プログラムを終了する場合、exitと入力する。それ以外ではプログラムは停止しない。
 *
 * エラーメッセージについては任意とする。
 *
 * ------------------------
 */

import java.util.Scanner;

public class P231110 {
    public static void main(String[] args) {
        // ----ローカル変数の宣言----
        Scanner sc = new Scanner(System.in);
        String numStr = "";
        String cmd = "";
        int num = 0;

        // ----繰り返し----
        while (!cmd.equals("exit")) {

            // ----入力----
            System.out.print("1以上の整数を入力してください。=>");
            try {
                numStr = sc.nextLine();
                num = Integer.parseInt(numStr);

                // ----例外キャッチ----
            } catch (NumberFormatException e) {
                System.out.println("有効な整数に変換できませんでした。");
                continue;
            } catch (RuntimeException e){
                System.out.println("その他例外が発生しました。");
                continue;
            }

            // ----処理と結果出力----
            switch(num){
                case 1,2 -> System.out.println("one-two");
                case 3 -> System.out.println("three");
                case 4 -> System.out.println("four");
                case 5 -> System.out.println("five");
                default -> System.out.println("other");
            }

            System.out.print("プログラムを終了する場合は exit と入力してください。=>");
            cmd = sc.nextLine();
        }
        System.out.println("プログラム終了");
    }
}
