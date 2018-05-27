import java.util.List;

public class CardIndex {

    private static int RATE = 10;

    private Node root;

    public void addCards(List<Card> cards) {
        for (Card card : cards) {
            addCard(card);
        }
    }

    public Card getCard(String phoneNumber) {
        return getCard(root, phoneNumber);
    }

    public void printCards(Logger logger) {
        printInOrder(root, logger);
    }

    public double calculate(Card from, Card to, double duration) {
        return duration * RATE;
    }

    private void addCard(Card card) {
        root = addCard(root, card);
    }

    private Node addCard(Node curr, Card card) {
        if (curr == null) {
            return new Node(card);
        }

        if (curr.card.phoneNumber.compareTo(card.phoneNumber) > 0) {
            curr.left = addCard(curr.left, card);
        } else if (curr.card.phoneNumber.compareTo(card.phoneNumber) < 0) {
            curr.right = addCard(curr.right, card);
        } else {
            return curr;
        }

        return curr;
    }

    private Card getCard(Node curr, String number) {
        if (curr == null) {
            return null;
        }

        if (curr.card.phoneNumber.equals(number)) {
            return curr.card;
        }

        return curr.card.phoneNumber.compareTo(number) > 0
                ? getCard(curr.left, number)
                : getCard(curr.right, number);
    }

    private void printInOrder(Node node, Logger logger) {
        if (node != null) {
            printInOrder(node.left, logger);
            logger.printCard(node.card);
            printInOrder(node.right, logger);
        }
    }

    private static class Node {

        public Node(Card card) {
            this.card = card;
        }

        public Card card;

        public Node left;

        public Node right;

    }

}
