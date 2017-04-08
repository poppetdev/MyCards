/*
 * Copyright (c) 2017 Michael D'Arcy and Brianne O'Niel.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.group13.androidsdk.mycards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Manages review-related functionality. The main thing to note is that this class maintains an
 * internal queue of cards for review. Like <code>CardBrowser</code>, you would just create an
 * instance of this class to use it, so:
 * <br>
 * <pre>
 *      ReviewManager rm = new ReviewManager();
 *      while (0 < rm.getNumCards && !userHasQuit) {
 *           Card c = rm.getNextCard();
 *          // When user is done, put the 1-5 rating into a "score" variable
 *         rm.finishReview(c, score);
 *      }
 * </pre>
 */
@SuppressWarnings("unused")
public class ReviewManager {
    private List<Card> cardsForReview = new ArrayList<>();
    private CardStorage cardStorage = null;
    private int curCardIndex = 0;

    public ReviewManager(CardStorage cardStorage) {
        this.cardStorage = cardStorage;
        reloadCardList();
    }

    /**
     * Reloads the card list from the persistent card storage.
     */
    private void reloadCardList() {
        cardsForReview.clear();
        Card[] cards = cardStorage.getCardsForReviewBefore(new Date());
        Collections.addAll(cardsForReview, cards);
        curCardIndex = 0;
    }

    /**
     * Gets the next card from the queue.
     */
    public Card getNextCard() {
        if (!hasNextCard()) {
            return null;
        }

        return cardsForReview.get(curCardIndex++);
    }

    /**
     * @return <code>true</code> if there are more cards, false otherwise
     */
    public boolean hasNextCard() {
        return curCardIndex < cardsForReview.size();
    }

    /**
     * Shuffles the queue to put the cards in random order.
     */
    public void shuffleCards() {
        Collections.shuffle(cardsForReview);
        curCardIndex = 0;
    }

    /**
     * Completes a review for the given card. This will cause the card's scheduling information
     * to be updated and it will be removed from the queue.
     *
     * @param c     the modified card. Note that the card's ID is used to specify the
     *              corresponding card in the database
     * @param score the user's score of the card
     */
    public void finishReview(Card c, int score) {
        // TODO: Implement this
    }

    /**
     * Gets the number of cards in the queue
     */
    public int getNumCards() {
        return this.cardsForReview.size();
    }
}
