package com.josephee.cs462.common.handler;

import org.slf4j.Logger;

abstract class EventHandler {

    Logger logger;

    EventHandler(Logger logger) {
        this.logger = logger;
    }
}
