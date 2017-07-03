package com.josephee.cs462.common.dispatch;

import org.slf4j.Logger;

abstract class EventsDispatcher {

    Logger logger;

    EventsDispatcher(Logger logger) {
        this.logger = logger;
    }
}
