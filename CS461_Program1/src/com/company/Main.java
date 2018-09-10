package com.company;


public class Main {
    public static void main(String[] args) {
        DeckOfCards a, b;
        Simulator s = new Simulator();

        Card[] player1 = new Card[5];
        Card[] player2 = new Card[5];
        Card[] player3 = new Card[5];
        Card[] player4 = new Card[5];
        Card[] player5 = new Card[5];
        Card[] community = new Card[4];
        Card[] temp = new Card[5];

        double[][] data = new double[4][500];

        int scores[] = {0, 0, 0, 0, 0};

        int i, j, k, l;
        int reps[] = {20, 100, 200};

        int w, x = 0;

        for (l = 0; l < 500; l++) {
            a = new DeckOfCards();

            a.shuffle(1000);

            x = 0;

            // store a copy of the original deck
            b = a;

            // deal main player's hole cards
            for (i = 0; i < 3; i++) {
                player1[i] = a.deal();
            }

            // deal community cards
            for (i = 0; i < 4; i++) {
                community[i] = a.deal();
            }

            // find best cards for hand
            s.bestHand(player1, community);

            // deal other players' hole cards
            a = b;
            int c = 7;

            a.simShuffle(1000);
            for (j = 0; j < 3; j++) {
                player2[j] = a.simDeal(c);
                c++;
                player3[j] = a.simDeal(c);
                c++;
                player4[j] = a.simDeal(c);
                c++;
                player5[j] = a.simDeal(c);
                c++;
            }

            for (k = 0; k < 3; k++) {
               w = 0;
                // simulate other players hands and results
                for (i = 0; i < reps[k]; i++) {
                    int handResult = 1;

                    // populate remaining hand slots with community cards
                    s.randomHand(player2, community);
                    s.randomHand(player3, community);
                    s.randomHand(player4, community);
                    s.randomHand(player5, community);


                    // store copies of each hand and score them
                    System.arraycopy(player1, 0, temp, 0, 5);
                    scores[0] = Poker.valueHand(temp);

                    System.arraycopy(player2, 0, temp, 0, 5);
                    scores[1] = Poker.valueHand(temp);

                    System.arraycopy(player3, 0, temp, 0, 5);
                    scores[2] = Poker.valueHand(temp);

                    System.arraycopy(player4, 0, temp, 0, 5);
                    scores[3] = Poker.valueHand(temp);

                    System.arraycopy(player5, 0, temp, 0, 5);
                    scores[4] = Poker.valueHand(temp);

                    //compare hand scores
                    for (j = 1; j < 5; j++) {
                        if (scores[0] < scores[j]) {
                            handResult = 0;
                        }
                    }
                    w += handResult;
                    x += handResult;
                }

                //System.out.println("Player 1 has won " + w + " out of " + (i) + " simulated hands.");
               // System.out.println();
                data[k][l] = w;
                data[3][l] = x;
            }
        }
        //System.out.println("Player 1 has won " + x + " out of all simulated hands.");

    }
}
