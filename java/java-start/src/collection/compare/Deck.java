package collection.compare;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Deck {
	private static List<Card> cards = new ArrayList<>();

	public Deck() {
		for (int i = Card.MIN_NUMBER; i <= Card.MAX_NUMBER; i++) {
			for (Card.Shape value : Card.Shape.values()) {
				cards.add(new Card(i, value));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public List<Card> getCards(int count) {
		if (isEmpty()) {
			throw new NoCardException("No card anymore");
		}
		List<Card> result = cards.subList(0, count);
		cards.removeAll(result);
		return result;
	}

	public boolean isEmpty() {
		return cards.isEmpty();
	}
}
