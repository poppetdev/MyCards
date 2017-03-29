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
 * A daemon that handles notification generation.
 * <br>
 * There are still quite a few things to work out on this class, such as whether it will
 * periodically update the notification schedule automatically, and if so how often.
 * <br>
 * Another noteworthy point is that this class is a singleton, so if necessary you would call it
 * with <code>NotificationDaemon.getInstance().updateSchedule()</code> rather than instantiating
 * it with <code>new NotificationDaemon()</code>
 */
class NotificationDaemon {
    private static final NotificationDaemon ourInstance = new NotificationDaemon();

    static NotificationDaemon getInstance() {
        return ourInstance;
    }

    private NotificationDaemon() {

    }

    /**
     * Manually request that the Daemon updates the schedule.
     */
    public void updateSchedule() {
        // TODO: Implement this
    }
}
