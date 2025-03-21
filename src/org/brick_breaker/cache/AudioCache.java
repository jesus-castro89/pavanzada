package org.brick_breaker.cache;

import javax.sound.sampled.Clip;
import java.util.HashMap;

public class AudioCache {

    private final HashMap<String, Clip> cache = new HashMap<>();
    private static final AudioCache INSTANCE = new AudioCache();

    private AudioCache() {

    }

    public static AudioCache getInstance() {

        return INSTANCE;
    }

    public void addMusic(String name, Clip music) {

        cache.putIfAbsent(name, music);
    }

    public Clip getMusic(String name) {

        return cache.getOrDefault(name, null);
    }
}
