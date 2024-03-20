/*
* ----------------------------------
* 0～100まで複数のランダムな整数を生成する。
* 生成するランダムな整数の個数は任意とする。すなわちユーザーに指定させる。
* 少なくとも2つ以上の整数を生成するようにする。
* 個数が2未満の場合は個数の入力に戻る。
* 3つの整数をArrayListにaddし、すべての整数の合計値を求める。
*
* 発生する例外の対処を行う。
* 例外が発生した場合、プログラムの初めから処理を行う。
* 表示するメッセージは任意とする。
* ----------------------------------
*/

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class P231115 {
    public static void main(String[] args) {
        // ----ローカル変数の宣言----
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        ArrayList<Integer> numArray = new ArrayList<>();
        String dataStr = "";
        int data = 0;
        int num = 0;
        int sum = 0;

        // ----処理----
        do {
            try {
                System.out.println("ランダムな整数を生成します。");
                System.out.print("生成する個数を指定してください。（2以上）=> ");
                dataStr = sc.nextLine();
                data = Integer.parseInt(dataStr);
                if (data < 2) {
                    System.out.println("2個以上を指定してください。");
                }
            } catch (NumberFormatException e) {
                System.out.println("有効な整数に変換できませんでした。");
                System.out.print("もう一度入力してください。");
            } catch (RuntimeException e){
                System.out.println("その他の例外が発生しました。");
                System.out.print("もう一度入力してください。");
            }
        }while(!(data >= 2));

        for(int i = 0; i < data; i++) {
            num = rd.nextInt(101);
            System.out.printf("%3d ",num);
            numArray.add(num);
            if(((i+1) % 10) == 0){
                System.out.println(); // 10個で改行
            }
        }

        System.out.println(); // 改行

        for(int i : numArray){
            sum += i;
        }
        // ----結果の出力----
        System.out.printf("%d 個のランダムな整数の合計は %d です。", data, sum);
    }
}
