# Actividad 2: Crear la cache de imagenes

## Descripción

En esta actividad vamos a crear una caché de imágenes para que las imágenes que se descarguen de internet se guarden en
la caché y no se descarguen cada vez que se necesiten.

## Instrucciones

1. Crear un paquete llamado `cache` dentro de `org.brick_breaker`.
2. Dentro del paquete `cache` crear una clase llamada `ImageCache`.
3. Haz que la clase tenga los siguientes atributos:
    * `private final HashMap<String, BufferedImage> cache = new HashMap<>();`
    * `private static final SpriteCache INSTANCE = new SpriteCache();`
4. Haz que la clase tenga un constructor privado.
5. Haz que la clase tenga un método estático llamado `getInstance` que retorne la instancia de la clase.
6. Haz que la clase tenga un método llamado `getImage` que reciba un `String` con el nombre de la imagen y retorne un
   `BufferedImage` con la imagen. En caso de que la imagen no exista en la caché, se deberá retornar `null`.
7. Haz que la clase tenga un método llamado `addImage` que reciba un `String` con el nombre de la imagen y un
   `BufferedImage` con la imagen y la agregue a la caché, en caso de que no exista.

## Pruebas

Para probar que la caché de imágenes funciona correctamente, deberás hacer lo siguiente:

1. Descarga la imagen de un gato desde internet y muévela a la carpeta `images` de tu proyecto.
2. Crea una clase llamada `Main` en el paquete `org.brick_breaker` y escribe el siguiente código:

```java
import org.brick_breaker.cache.ImageCache;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ImageCache imageCache = ImageCache.getInstance();

        try {
            BufferedImage catImage = ImageIO.read(new File("images/cat.jpg"));
            imageCache.addImage("cat", catImage);

            BufferedImage cachedCatImage = imageCache.getImage("cat");

            if (cachedCatImage != null) {
                System.out.println("La imagen del gato se ha cargado correctamente.");
            } else {
                System.out.println("La imagen del gato no se ha cargado correctamente.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Ejecuta la clase `Main` y verifica que la imagen del gato se haya cargado correctamente.

## Entrega

Esta actividad no requiere entrega, pero es importante que la realices para que puedas utilizar la caché de imágenes en
las siguientes actividades.