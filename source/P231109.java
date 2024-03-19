/*
 * --------------------------------
 *
 * 英語と数学のテストの合計点を出力するプログラムを作成する。
 * ユーザーは整数を入力する。
 *
 * 合計点が160点以上の場合「優」と表示する。
 * 合計点が140点以上の場合「可」と表示する。
 * 合計点140点未満の場合「不可」と表示する。
 *
 * 入力する点数は、各教科0～100点までとする。
 * 文字列、範囲外の整数、小数が入力された場合、エラーメッセージを表示して最初から入力をやり直す。
 * プログラムを終了する場合、exitと入力する。それ以外ではプログラムは停止しない。
 *
 * 表示例：
 * 点数を入力してください。
 * 英語=> (ユーザーが点数を入力するのをここで待機)
 * 数学=> (同上)
 * 合計点数は〇〇点です。「優」
 *
 *
 * エラー対策1：整数ではなく、文字列が入力された場合の表示と小数が入力された場合と
 *            あまりにも巨大な整数が入力されてプログラムで取り扱えない場合。
 * 有効な整数に変換できませんでした。もう一度入力しなおしてください。
 * 入力する点数は、各教科0～100点までの範囲です。
 *
 * エラー対策2：プログラムが取り扱える整数の範囲内で、入力された整数が0～100の範囲外の場合
 * 範囲外の点数が入力されました。もう一度入力しなおしてください。
 * 入力する点数は、各教科0～100点までの範囲です。
 *
 * エラー対策3：その他何らかのエラーが発生した場合
 * 例外が発生しました。
 *
 * --------------------------------
 */

import java.nio.BufferOverflowException;
import java.util.Scanner;

public class P231109 {
    public static void main(String[] args) {
        // ----宣言----
        int math = 0;
        int eng = 0;
        int sum = 0;
        String engStr = "";
        String mathStr = "";
        String cmd = "";
        // ----エラーメッセージ----
        String error1 = """
                        有効な整数に変換できませんでした。もう一度入力しなおしてください。
                        入力する点数は、各教科0～100点までの範囲です。
                        """;
        String error2 = """
                        範囲外の点数が入力されました。もう一度入力しなおしてください。
                        入力する点数は、各教科0～100点までの範囲です。
                        """;
        String error3 = "例外が発生しました。";

        // ----入力用Scannerオブジェクト----
        Scanner sc = new Scanner(System.in);

        // ----繰り返し----
        while(! cmd.equals("exit")) {
            System.out.println("点数を入力してください。");

            // ----入力----
            try {
                System.out.print("英語=>");
                //eng = sc.nextInt(); （改行文字が残留するため直後に使用するnextLine()がスルーされる）
                engStr = sc.nextLine();
                eng = Integer.parseInt(engStr);
                System.out.print("数学=>");
                //math = sc.nextInt(); （改行文字が残留するため直後に使用するnextLine()がスルーされる）
                mathStr = sc.nextLine();
                math = Integer.parseInt(mathStr);

                // ----処理----
                if ((eng < 0 || math < 0) || (eng > 100 || math > 100)) {
                    throw new BufferOverflowException();
                }

                sum = eng + math;

                // ----判定と出力----
                if(sum >= 160){
                    System.out.printf("合計点数は%d点です。「優」\n" , sum);
                }else if(sum < 160 && sum >= 140){
                    System.out.printf("合計点数は%d点です。「可」\n" , sum);
                }else if(sum < 140){
                    System.out.printf("合計点数は%d点です。「不可」\n" , sum);
                }
                System.out.print("プログラムを終了する場合は exit と入力してください。");
                cmd = sc.nextLine();

            // ----例外キャッチ----
            } catch (NumberFormatException e) {
                System.out.println(error1); // 有効な整数以外の入力
            } catch (BufferOverflowException e) {
                System.out.println(error2); // 指定範囲外の整数
            } catch (Exception e) {
                System.out.println(error3); // その他何らかの例外
                System.out.println(e.getMessage());
            }
        }
        System.out.println("プログラム終了");
    }
}
