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

/**
 * The purpose of the CardBrowser class is to facilitate browsing cards for the frontend code. I
 * imagine it being used along the lines of:
 * <br>
 * <pre>
 *      CardBrowser cb = new CardBrowser()
 *      Card[] cards = cb.getAllCards()
 *      // Now suppose we want to update the card (if the user edits it, for example)
 *      cards[0].addTag("someNewTagName")
 *      cb.updateCard(cards[0])
 *      // ... Now the card in cards[0] is updated in the database
 * </pre>
 */
@SuppressWarnings("unused")
public class CardBrowser {

    Card getCardById(int id) {
        // TODO: Implement this
        return null;
    }

    Card[] getAllCards() {
        // TODO: Implement this
        return null;
    }

    /**
     * This method will update the card having a matching ID. This essentially makes it possible
     * to take any Card, modify it, and pass it to updateCard, and have the correct card updated
     * in the database.
     */
    void updateCard(Card c) {

    }
}
