package org.brick_breaker.utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {

    private Clip backgroundClip;
    private Clip overlayClip;

    /**
     * Constructor que recibe el nombre del archivo de sonido de fondo.
     */
    public SoundPlayer(String backgroundFile) {
        try {
            // Cargar el sonido de fondo
            backgroundClip = AudioSystem.getClip();
            AudioInputStream bgStream = AudioSystem.getAudioInputStream(new File(backgroundFile));
            backgroundClip.open(bgStream);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY); // Bucle continuo
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicia la reproducción del sonido de fondo.
     */
    public void playBackground() {

        if (backgroundClip != null) {

            backgroundClip.start();
        }
    }

    /**
     * Detiene la reproducción del sonido de fondo.
     */
    public void stopBackground() {

        if (backgroundClip != null) {

            backgroundClip.stop();
        }
    }

    /**
     * Reproduce un sonido superpuesto (efecto).
     */
    public void playOverlay(String overlayFile) {

        new Thread(() -> {
            try {

                // Crear un nuevo clip para el sonido corto
                overlayClip = AudioSystem.getClip();
                AudioInputStream overlayStream = AudioSystem.getAudioInputStream(new File(overlayFile));
                overlayClip.open(overlayStream);
                overlayClip.start();
                // Espera a que termine para liberar recursos
                overlayClip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        overlayClip.close();
                    }
                });
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

                e.printStackTrace();
            }
        }).start();
    }

    /**
     * Libera los recursos al finalizar.
     */
    public void close() {

        if (backgroundClip != null) {

            backgroundClip.close();
        }
        if (overlayClip != null) {

            overlayClip.close();
        }
    }
}
