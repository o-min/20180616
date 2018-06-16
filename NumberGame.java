package NumberGame;

public class NumberGame {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("数字当てゲームを開始します");
		int level = 1;
		int ans = 0;

		//do {
			System.out.println("1から3までの半角数字で難易度を選んでください");
			System.out.println("1 :一桁  2:二桁 3: 三桁");
		level = new java.util.Scanner(System.in).nextInt();
		ans = answer(level);
		//}while(level <=1 && 3<= level);
		//System.out.println("答えは"+ ans + "です");//＊＊＊＊＊＊動作確認用＊＊＊＊＊＊
		check(ans,level);
	}

	/* 難易度にあわせた桁数の正解を作成するメソッド */
	 static int answer(int level) {
		 int ans = 0;
		 switch(level){
			 case 1:
				 ans = new java.util.Random().nextInt(10);
				break;
			 case 2:
				 ans = new java.util.Random().nextInt(100);
				 break;
			 case 3:
				 ans = new java.util.Random().nextInt(1000);
		 }
		return ans;
	}

	 /* 答えが正解かどうかを判定するメソッド */
	 static int check(int ans,int level) {
		 int num = 0;
		 int trial = 1;
		 do {
				System.out.println(trial + "回目：" + level + "桁の数字を入力してください");
				 num = new java.util.Scanner(System.in).nextInt();
				 if(num != ans) {
					 hint(ans,num);
					 trial++;
				 }
			}while(ans != num);
			System.out.println("正解です。おめでとうございます！");
			System.out.println(trial + "回目でクリアしました！");

		 return 0;
	 }

	 /* 入力された数値と正解の数値を比較し、一致している桁数を表示するメソッド */
	 static void hint(int ans, int num) {
		 int hundredA =  ans / 100;
		 int tenA		 = (ans / 10) % 10;
		 int oneA		 =  ans % 10;
		 int hundredN =  num / 100;
		 int tenN		 = (num / 10) % 10;
		 int oneN		 =  num % 10;
		 int chk = 0;
		 if(hundredA == hundredN) {
			 chk++;
		 }if(tenA == tenN) {
			 chk++;
		 }if(oneA == oneN) {
			 chk++;
		 }
		 System.out.println("数値が一致している桁が"+ chk + "桁あります！");
	 }
}
