package collection.compare;

import java.util.Arrays;
import java.util.List;

public class Player {
	private List<Card> cards;
	private String name;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void peekCard(final Deck deck, int count) {
		cards = deck.getCards(count);
	}

	public int getSum() {
		if (cards == null) {
			throw new NoCardException("No card to me");
		}
		int sum = 0;
		for (Card card : cards) {
			sum += card.getNumber();
		}
		return sum;
	}
	@Override
	public String toString() {
		return String.format("%s의 카드: %s, 합계:%d", name,cards, getSum());
	}
}
