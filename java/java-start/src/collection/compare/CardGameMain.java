package collection.compare;

public class CardGameMain {
	public static void main(String[] args) {
		Player player1 = new Player("플레이어1");
		Player player2 = new Player("플레이어2");
		Deck deck = new Deck();
		startGame(player1, deck, player2);
		doGame(player1, player2);

	}

	private static Player doGame(Player player1, Player player2) {
		Player won = null;
		if (player1.getSum() > player1.getSum()) {
			won = player1;
		} else if (player1.getSum() < player2.getSum()) {
			won = player2;
		}
		if (won == null) {
			System.out.println("무승부");
		} else {
			System.out.println(won.getName() + " 승리");
		}
		return won;
	}

	private static void startGame(Player player1, Deck deck, Player player2) {
		deck.shuffle();
		player1.peekCard(deck, 5);
		player2.peekCard(deck, 5);
		System.out.println(player1);
		System.out.println(player2);
	}
}
