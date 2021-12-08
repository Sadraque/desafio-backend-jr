package com.desafiobackendjr.logging;

import com.google.gson.Gson;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Log
@Component
public class Logger {

    private HashMap<Object, Object> map;

    private Logger() {
        this.map = new HashMap<>();
    }
    public static Logger builder() {
        return new Logger();
    }

    public Logger add(Enum key, Object value) {
        map.put(key, value);
        return this;
    }

    public Logger add(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public void fine() {
        log.fine(new Gson().toJson(map));
    }

    private void fine(HashMap<Object, Object> map) {
        log.fine(new Gson().toJson(map));
    }

    public void fine(Object object) {
        log.fine(new Gson().toJson(object));
    }

    public void info() {
        log.info(new Gson().toJson(map));
    }

    public void info(HashMap<Enum, Object> map) {
        log.info(new Gson().toJson(map));
    }

    public void info(Object object) {
        log.info(new Gson().toJson(object));
    }

    public void warning() {
        log.warning(new Gson().toJson(map));
    }

    private void warning(HashMap<Object, Object> map) {
        log.warning(new Gson().toJson(map));
    }

    public void warning(Object object) {
        log.warning(new Gson().toJson(object));
    }

    public void severe() {
        log.severe(new Gson().toJson(map));
    }

    private void severe(HashMap<Enum, Object> map) {
        log.severe(new Gson().toJson(map));
    }

    public void severe(Object object) {
        log.severe(new Gson().toJson(object));
    }
}
