# Los niveles de acceso

Los niveles de acceso en Java son modificadores que se utilizan para controlar la visibilidad y accesibilidad de las
clases, métodos y variables en un programa. Los niveles de acceso permiten restringir el acceso a ciertas partes del
código y proteger la integridad de los datos.

En Java, existen cuatro niveles de acceso que se pueden aplicar a clases, métodos y variables:

| Nivel de acceso | Descripción                                                        |
|-----------------|--------------------------------------------------------------------|
| `public`        | Acceso desde cualquier clase en cualquier paquete.                 |
| `protected`     | Acceso desde la misma clase, clases del mismo paquete y subclases. |
| `default`       | Acceso desde la misma clase y clases del mismo paquete.            |
| `private`       | Acceso solo desde la misma clase.                                  |

Los niveles de acceso en Java se utilizan para controlar la visibilidad y accesibilidad de las clases, métodos y
variables en un programa. Es importante comprender los diferentes niveles de acceso y cómo se aplican en la programación
para desarrollar aplicaciones seguras y mantenibles.

## Ejemplo de niveles de acceso en Java

A continuación se muestra un ejemplo de cómo se aplican los niveles de acceso en Java:

```java
public class Persona {
    public String nombre;
    protected int edad;
    double altura;
    private double peso;
}
```

En este ejemplo, la clase `Persona` tiene cuatro atributos con diferentes niveles de acceso:

- El atributo `nombre` tiene nivel de acceso `public`, lo que significa que es accesible desde cualquier clase en
  cualquier paquete.
- El atributo `edad` tiene nivel de acceso `protected`, lo que significa que es accesible desde la misma clase, clases
  del mismo paquete y subclases.
- El atributo `altura` tiene nivel de acceso `default`, lo que significa que es accesible desde la misma clase y clases
  del mismo paquete.
- El atributo `peso` tiene nivel de acceso `private`, lo que significa que solo es accesible desde la misma clase.
- Los niveles de acceso se aplican a los atributos de la clase, pero también se pueden aplicar a los métodos y a la
  clase en sí misma.

> Es importante utilizar los niveles de acceso de forma adecuada para proteger la integridad de los datos y garantizar
> la seguridad de la aplicación.

## Reglas de los niveles de acceso en Java

Para aplicar los niveles de acceso en Java, se deben seguir las siguientes reglas:

- Las clases por lo general tienen nivel de acceso `public` o `default`.
- Los atributos de una clase por regla de encapsulamiento deben tener nivel de acceso `private`. Aunque más adelante se
  verá que se pueden tener atributos con nivel de acceso `protected` o `default` si es necesario.
- Los métodos de una clase pueden tener cualquier nivel de acceso, dependiendo de la necesidad de acceso a los mismos.

Los niveles de acceso en Java son una herramienta poderosa para controlar la visibilidad y accesibilidad de las clases,
métodos y variables en un programa. Al utilizar los niveles de acceso de forma adecuada, se puede proteger la integridad
de los datos y garantizar la seguridad de la aplicación.