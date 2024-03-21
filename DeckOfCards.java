// Amaan Seraj
// 01/12/2024
// CS & 145
// Lab 2: Card Shuffling and Dealing program Ex. 7.16
// This program will make a card shuffling
// and dealing program and it will determine
// what your the hand contains
 

public class DeckOfCards {
    public static final String[] Faces = {"Ace", "Deuce", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    public static final String[] Suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

    // This method shuffles the cards in the deck
    public static void shuffleCard(Card[] deck) {
        for (int first = 0; first < deck.length; first++) {
            int second = (int) (Math.random() * deck.length);
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    // Checks if there is a pair in the hand
    public static boolean checkTwin(Card hand[]) {
        int t = 0;
        int[] frequency = new int[Faces.length];
        for (int h = 0; h < hand.length; h++) {
            for (int i = 0; i < Faces.length; i++) {
                if (hand[h].getFace().equals(Faces[i]))
                    frequency[i]++;
            }
        }
        for (int j = 0; j < frequency.length; j++) {
            if (frequency[j] == 2) {
                t++;
            }
        }
        return (t == 1);
    }

    // Main method
    public static void main(String[] args) {
        final int numberOfCards = 52;
        Card[] deck = new Card[numberOfCards];
        for (int count = 0; count < deck.length; count++)
            deck[count] = new Card(Faces[count % 13], Suits[count / 13]);
        shuffleCard(deck);
        Card[] hand = new Card[5];
        for (int counts = 0; counts < 5; counts++) {
            hand[counts] = deck[counts];
        }
        System.out.println("The obtained hand is: ");
        for (int counts = 0; counts < hand.length; counts++) {
            System.out.println(hand[counts]);
        }
        System.out.print("\n Hand contains: ");

        if (checkTwin(hand)) {
            System.out.println("A pair!");
        } else {
            System.out.println("No pair in the hand.");
        }
    }
}

class Card {
    private final String face;
    private final String suit;

    public Card(String cardFace, String cardSuit) {
        face = cardFace;
        suit = cardSuit;
    }

    public String toString() {
        return face + " of " + suit;
    }

    public String getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }
}