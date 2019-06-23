package org.grantharper.example.ooo;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Blackjack {
    public static void main(String[] args) {
        Game game = new Game();
        Player player = game.getPlayer();
        Dealer dealer = game.getDealer();

        while (player.shouldHit()) {
            player.getHand().hit(game.getDeck().draw());
        }

        if (player.isBust()) {
            System.out.println("Dealer wins");
            game.printScore();
            game.printHands();
            return;
        }

        while (dealer.shouldHit()) {
            dealer.getHand().hit(game.getDeck().draw());
        }

        game.determineWinner();
        game.printHands();
    }
}

class Game {

    private Deck deck;
    private Dealer dealer;
    private Player player;

    public Game() {
        this.deck = new Deck();
        this.dealer = new Dealer(dealHand());
        this.player = new Player(dealHand());
    }

    private Hand dealHand() {
        Card draw1 = this.deck.draw();
        Card draw2 = this.deck.draw();
        return new Hand(Stream.of(draw1, draw2)
                              .collect(Collectors.toList()));
    }

    public void hit(AbstractPlayer targetPlayer) {
        Card draw = this.deck.draw();
        targetPlayer.getHand().hit(draw);
    }

    public void determineWinner() {
        if (dealer.isBust() || player.getHand().total() > dealer.getHand().total()) {
            System.out.println("Player wins");
        } else if (dealer.getHand().total() > player.getHand().total()) {
            System.out.println("Dealer wins");
        } else {
            System.out.println("It's a tie");
        }
        printScore();
    }

    public void printHands() {
        System.out.println("Player's Hand");
        player.getHand().printHand();
        System.out.println("Dealer's Hand");
        dealer.getHand().printHand();
    }

    public void printScore() {
        System.out.println("Dealer=" + dealer.getHand().total() + ", Player=" + player.getHand().total());
    }

    public Deck getDeck() {
        return deck;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public Player getPlayer() {
        return player;
    }
}

class Hand {
    private final List<Card> cards;
    private int total;

    public Hand(List<Card> cards) {
        this.cards = cards;
        this.total = computeTotal();
    }

    public void hit(Card card) {
        cards.add(card);
        this.total = computeTotal();
    }

    public int total() {
        return this.total;
    }

    private int computeTotal() {
        TreeSet<Integer> possibleScores = new TreeSet<>(Comparator.reverseOrder());
        possibleScores.add(0);
        for (Card card : this.cards) {
            Set<Integer> copiedScores = new TreeSet<>(possibleScores);
            possibleScores.clear();
            for (int score : copiedScores) {
                if (card.isAce()) {
                    possibleScores.add(score + 1);
                    possibleScores.add(score + 11);
                } else if (card.isFaceCard()) {
                    possibleScores.add(score + 10);
                } else {
                    possibleScores.add(score + card.getNumber());
                }
            }
        }
        for (int score : possibleScores) {
            if (score <= 21) {
                return score;
            }
        }
        return possibleScores.last();
    }

    public void printHand() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

}

abstract class AbstractPlayer {
    private final Hand hand;

    public AbstractPlayer(Hand hand) {
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isBust() {
        return this.hand.total() > 21;
    }

    public abstract boolean shouldHit();
}

class Dealer extends AbstractPlayer {
    public Dealer(Hand hand) {
        super(hand);
    }

    @Override
    public boolean shouldHit() {
        return this.getHand().total() < 17;
    }
}

class Player extends AbstractPlayer {
    public Player(Hand hand) {
        super(hand);
    }

    @Override
    public boolean shouldHit() {
        return this.getHand().total() < 15;
    }
}


class Deck {

    private List<Card> cards;
    private Random random;

    public Deck() {
        this.cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                this.cards.add(new Card(suit, i));
            }
        }
        this.random = new Random(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
    }

    public Card draw() {
        return this.cards.remove(this.random.nextInt(this.cards.size()));
    }

    public List<Card> getCards() {
        return cards;
    }
}

class Card {
    private final Suit suit;
    private final int number;

    public Card(Suit suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFaceCard() {
        return number >= 11;
    }

    public boolean isAce() {
        return number == 1;
    }

    @Override
    public String toString() {
        return number + " of " + suit;
    }
}

enum Suit {
    SPADES, CLUBS, HEARTS, DIAMONDS
}


