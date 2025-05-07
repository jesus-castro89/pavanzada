# Actividad 9: Cargando las tipografías

## Objetivo

Gestionar correctamente las tipografías de un proyecto, en Java.

## Instrucciones

1. Crear las clases `FontLoader` y `FontCache` en el paquete `org.brick_breaker.cache`, las cuales se encargan de cargar
   y almacenar las tipografías del juego.
2. Crear la clase `FontLoader` que tenga un método `loadFont` que reciba como parámetro el nombre de la tipografía y el
   tamaño y devuelva un objeto `Font`.
3. Crear la clase `FontCache` que almacene las tipografías cargadas en un `HashMap` y tenga un método `getFont` que
   reciba como parámetro el nombre de la tipografía y el tamaño y devuelva la tipografía correspondiente.

## Creando las clases

### FontLoader

Esta clase se encargará de cargar las tipografías del juego. Para ello, crearemos un método `loadFont` que reciba como
parámetro el nombre de la tipografía y el tamaño y devuelva un objeto `Font`.

```java
package org.brick_breaker.cache;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class FontLoader {


    public static Font loadFont(String path) {

        try {

            return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(12f);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la fuente: " + path,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return Font.getFont("Arial").deriveFont(12f);
    }
}
```

### FontCache

Esta clase almacenará las tipografías cargadas en un `HashMap` y tendrá un método `getFont` que reciba como parámetro
el nombre de la tipografía y el tamaño y devuelva la tipografía correspondiente.

```java
package org.brick_breaker.cache;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FontCache {

    public static final Map<String, Font> cache = new HashMap<>();
    private static final FontCache INSTANCE = new FontCache();

    private FontCache() {
    }

    public static FontCache getInstance() {
        return INSTANCE;
    }

    public static Font addFont(String fontName, String fontPath) {

        Font font;
        if (!cache.containsKey(fontName)) {

            font = FontLoader.loadFont(fontPath);
            cache.put(fontName, font);
        } else {
            font = cache.get(fontName);
        }
        return font;
    }

    public static Font getFont(String fontName, int style, int size) {

        return cache.getOrDefault(fontName, Font.getFont("Arial")).deriveFont(style, size);
    }

    public static Font getFont(String fontName) {

        return getFont(fontName, Font.PLAIN, 12);
    }

    public static Font getFont(String fontName, int size) {

        return getFont(fontName, Font.PLAIN, size);
    }
}
```

## Conclusión

En esta actividad hemos aprendido a gestionar las tipografías de un proyecto en Java, creando las clases `FontLoader` y
`FontCache` que se encargan de cargar y almacenar las tipografías del juego. Hemos visto cómo utilizar un `HashMap` para
almacenar las tipografías cargadas y cómo crear métodos para obtener las tipografías correspondientes. También hemos
aprendido a manejar excepciones al cargar las tipografías y a utilizar la clase `Font` para crear objetos de tipo
`Font`.