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
 * Database manager. This class provides a high-level interface to database operations in the app.
 */
class MyCardsDBManager implements NotificationStorage, CardStorage {
    private static final MyCardsDBManager ourInstance = new MyCardsDBManager();

    static MyCardsDBManager getInstance() {
        return ourInstance;
    }

    private MyCardsDBManager() {

    }

    @Override
    public void deleteCardById(int cardId) {

    }

    @Override
    public void insertOrUpdateCard(Card card) {

    }

    @Override
    public Card getCardById(int cardId) {
        return null;
    }

    @Override
    public Card[] getAllCards() {
        return new Card[0];
    }

    @Override
    public void deleteNotificationRuleById(int ruleId) {

    }

    @Override
    public void insertOrUpdateNotificationRule(NotificationRule rule) {

    }

    @Override
    public NotificationRule getNotificationRuleById(int ruleId) {
        return null;
    }

    @Override
    public NotificationRule[] getAllNotificationRules() {
        return new NotificationRule[0];
    }

    @Override
    public void setDoNotDisturb(boolean enabled) {

    }

    @Override
    public boolean getDoNotDisturb() {
        return false;
    }
}
