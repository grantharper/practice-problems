package org.grantharper.example.ooo;

import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BlackjackTest {


    @Test
    public void randomTest() {
        int result = new Random().nextInt(52);
        assertThat(result).isBetween(0, 53);
    }

    @Test
    public void totalTest() {
        Hand hand1 = new Hand(Stream.of(new Card(Suit.SPADES, 3), new Card(Suit.CLUBS, 4)).collect(Collectors.toList()));

        assertThat(hand1.total()).isEqualTo(7);

        Hand hand2 = new Hand(Stream.of(new Card(Suit.SPADES, 13), new Card(Suit.CLUBS, 10)).collect(Collectors.toList()));

        assertThat(hand2.total()).isEqualTo(20);

        Hand hand3 = new Hand(Stream.of(new Card(Suit.SPADES, 10), new Card(Suit.CLUBS, 1)).collect(Collectors.toList()));
        assertThat(hand3.total()).isEqualTo(21);

        List<Card> cards = Stream.of(
                new Card(Suit.SPADES, 10),
                new Card(Suit.CLUBS, 1),
                new Card(Suit.DIAMONDS, 2))
                                 .collect(Collectors.toList());
        assertThat(cards).hasSize(3);
        Hand hand4 = new Hand(cards);
        assertThat(hand4.total()).isEqualTo(13);

        Hand hand5 = new Hand(Stream.of(
                new Card(Suit.SPADES, 10),
                new Card(Suit.CLUBS, 1),
                new Card(Suit.DIAMONDS, 1))
                                    .collect(Collectors.toList()));
        assertThat(hand5.total()).isEqualTo(12);

    }

    @Test
    public void weirdComboTests() {
        Hand hand = new Hand(Stream.of(
                new Card(Suit.SPADES, 13),
                new Card(Suit.SPADES, 3),
                new Card(Suit.HEARTS, 4)
        ).collect(Collectors.toList()));
        assertThat(hand.total()).isEqualTo(17);
    }

    @Test
    public void dealTest() {
        Game game = new Game();

        assertThat(game.getDeck().getCards()).hasSize(48);
        assertThat(game.getDealer().getHand().total()).isNotEqualTo(0);
        assertThat(game.getPlayer().getHand().total()).isNotEqualTo(0);
    }


}
