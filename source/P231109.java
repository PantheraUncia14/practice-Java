import java.nio.BufferOverflowException;
import java.util.Scanner;

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
* プログラムを修了する場合、exitと入力する。それ以外ではプログラムは停止しない。
*
* 表示例：
* 点数を入力してください。
* 英語=> (ユーザーが点数を入力するのをここで待機)
* 数学=> (同上)
* 合計点数は〇〇点です。
*
*
* エラー対策1：整数ではなく、文字列が入力された場合の表示と小数が入力された場合の表示
* 整数が入力されませんでした。もう一度入力しなおしてください。
*
* エラー対策2：入力された整数が0～100の範囲外の場合
* 範囲外の点数が入力されました。もう一度入力しなおしてください。
* 入力する点数は、各教科0～100点までの範囲です。
*
* エラー対策3：その他何らかのエラーが発生した場合
* 例外が発生しました。
*
* --------------------------------
*/
public class P231109 {
    public static void main(String[] args) {
        // ----ローカル変数----
        int math = 0;
        int eng = 0;
        int sum = 0;
        String engStr = "";
        String mathStr = "";

        // ----エラーメッセージ----
        String error1 = "整数が入力されませんでした。もう一度入力しなおしてください。";
        String error2 = """
                        範囲外の点数が入力されました。もう一度入力しなおしてください。
                        入力する点数は、各教科0～100点までの範囲です。
                        """;
        String error3 = "例外が発生しました。";
        String cmd = "";

        // ----入力用Scannerオブジェクト----
        Scanner sc = new Scanner(System.in);

        // ----繰り返し----
        while(! cmd.equals("exit")) {
            System.out.println("点数を入力してください。");
            // ----入力----
            try {
                System.out.print("英語=>");
                //eng = sc.nextInt(); 77行目がスルーされる
                engStr = sc.nextLine();
                eng = Integer.parseInt(engStr);
                System.out.print("数学=>");
                //math = sc.nextInt(); 77行目がスルーされる
                mathStr = sc.nextLine();
                math = Integer.parseInt(mathStr);

                // ----処理----

                if ((eng < 0 || math < 0) || (eng > 100 || math > 100)) {
                    throw new BufferOverflowException();
                }
                sum = eng + math;

                // ----出力----
                System.out.printf("合計点数は%d点です。\n" , sum);
                System.out.print("プログラムを修了する場合は exit と入力してください。");
                cmd = sc.nextLine();
            } catch (NumberFormatException e) {
                System.out.println(error1); // 整数以外の入力
            } catch (BufferOverflowException e) {
                System.out.println(error2); // 指定範囲外の整数
            } catch (Exception e) {
                System.out.println(error3); // その他何らかの例外
                System.out.println(e.getMessage());
            }
        }
        System.out.println("プログラム修了");
    }
}
