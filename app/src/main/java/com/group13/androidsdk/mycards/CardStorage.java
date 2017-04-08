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

import java.util.Date;

/**
 * An interface for storage and retrieval of <code>Card</code> objects.
 */
@SuppressWarnings("unused")
interface CardStorage {
    void deleteCardById(int cardId);
    void insertOrUpdateCard(Card card);
    Card getCardById(int cardId);
    Card[] getAllCards();
    Card[] getCardsForReviewBefore(Date d);
}
