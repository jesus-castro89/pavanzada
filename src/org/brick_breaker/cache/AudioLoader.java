package org.brick_breaker.cache;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Clase que se encarga de cargar los sonidos que se van a reproducir en el juego.
 */
public class AudioLoader {

    /**
     * Función que carga un sonido.
     *
     * @param path Ruta del sonido.
     * @return Sonido cargado.
     */
    public static Clip loadMusic(String path) {

        try {

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            return clip;
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showConfirmDialog(null,
                    "Error al cargar el audio: " + path,
                    "Error", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
