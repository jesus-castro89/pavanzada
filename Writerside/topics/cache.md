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
    * Este método debe ser sincronizado para evitar problemas de concurrencia.
    * Deberás utilizar el patrón de diseño Singleton para garantizar que solo se cree una instancia de la clase.
    * ```java
      public static ImageCache getInstance() {
         return INSTANCE;
      }
      ```
6. Haz que la clase tenga un método llamado `getImage` que reciba un `String` con el nombre de la imagen y retorne un
   `BufferedImage` con la imagen. En caso de que la imagen no exista en la caché, se deberá retornar `null`.
    * Puedes utilizar el método `getOrDefault` de la clase `HashMap` para retornar la imagen o `null` en caso de que no
      exista.
    * ```java
      public BufferedImage getImage(String name) {
          return cache.getOrDefault(name, null);
      }
      ```
7. Haz que la clase tenga un método llamado `addImage` que reciba un `String` con el nombre de la imagen y un
   `BufferedImage` con la imagen y la agregue a la caché, en caso de que no exista.
    * Puedes utilizar el método `putIfAbsent` de la clase `HashMap` para agregar la imagen a la caché solo si no existe.
    * ```java
      public void addImage(String name, BufferedImage image) {
          cache.putIfAbsent(name, image);
      }
      ```

## Pruebas

Para probar que la caché de imágenes funciona correctamente, deberás hacer lo siguiente:

1. Descarga la imagen de un gato desde internet y muévela a la carpeta `images` de tu proyecto.
    * Para crear el directorio `images` en tu proyecto, haz clic derecho en el proyecto, selecciona `New` > `Directory`
      y escribe `images`.
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

Ejecuta la clase `Main` y verífica que la imagen del gato se haya cargado correctamente.

## Criterios de evaluación

| Criterio | Descripción                                                                             | Puntaje |
|----------|-----------------------------------------------------------------------------------------|---------|
| Portada  | La portada contiene el nombre de los integrantes del equipo y el nombre de la actividad | 5%      |
| Clase    | La clase `ImageCache` tiene los atributos y métodos requeridos                          | 30%     |
| Pruebas  | El código de prueba carga la imagen del gato correctamente                              | 65%     |
| Total    |                                                                                         | 100%    |

## Fecha de entrega

La fecha de entrega es el día 19 de marzo de 2025 a las 11:59 p.m.

Actividades enviadas después de la fecha y hora límite serán evaluadas sobre el 70% de la calificación total.