/*
THIS CODE IS MY OWN DEVELOPMENT)
*/
package com.company;
import java.util.*;

public class Simulator {
    Card[] temp = new Card[5];
    Card[] temp1 = new Card[5];

    int i, j, k;
    int tempScore = 0;

    public void bestHand(Card[] player, Card[] community) {
        System.arraycopy(player, 0, temp, 0, 5);
        int tempScore = 0;

        for (i = 0; i < 3; i++) {
            for (j = i + 1; j < 4; j++) {
                temp[3] = community[i];
                temp[4] = community[j];
                System.arraycopy(temp, 0, temp1, 0, 5);

                if (Poker.valueHand(temp1) > tempScore) {
                    System.arraycopy(temp, 0, player, 0, 5);
                    tempScore = Poker.valueHand(temp1);
                }

            }

        }
    }

    public void randomHand(Card[] player, Card[] community)
    {
        Random ran = new Random();
        int y = ran.nextInt(4);
        int z = ran.nextInt(4);
        while (y == z) z = ran.nextInt(4);
        player[3] = community[y];
        player[4] = community[z];
    }


}
