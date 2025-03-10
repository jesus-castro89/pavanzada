# Entregable 1: Calculadora de Figuras Geométricas con clases abstractas

En este entregable, se pide implementar una calculadora de figuras geométricas en Java utilizando clases abstractas. La
calculadora debe ser capaz de calcular el área y el perímetro de las siguientes figuras geométricas:

1. Círculo
2. Triángulo
3. Rectángulo
4. Cuadrado
5. Pentágono
6. Hexágono
7. Trapecio
8. Rombo
9. Paralelogramo
10. Elipse

Para ello, se deben seguir los siguientes pasos:

1. Crear una clase abstracta `Figura` que contenga los siguientes métodos abstractos:

    * `double area()`: Este método debe calcular y devolver el área de la figura.
    * `double perimetro()`: Este método debe calcular y devolver el perímetro de la figura.
    * `String imprimirResultados()`: Este método debe devolver una cadena de texto con los resultados de los cálculos
      realizados. **Es tu decisión si es concrete o abstracto.**
2. Crear una clase concreta para cada una de las figuras geométricas mencionadas anteriormente que herede de la clase
   `Figura` y que implemente los métodos `area` y `perimetro` según corresponda.
3. Crear una clase `CalculadoraFiguras` que contenga un método `main` en el que se instancien y se calculen el área y el
   perímetro de cada una de las figuras geométricas mencionadas anteriormente. Recuerda que deberás utilizar
   polimorfismo y JOptionPane para solicitar los datos necesarios para realizar los cálculos y el desplegar el menú de
   interacción con el usuario.
4. Realizar pruebas unitarias para verificar el correcto funcionamiento de las clases implementadas.

Recuerda que las fórmulas para calcular el área y el perímetro de cada una de las figuras geométricas se pueden
encontrar en internet o en libros de geometría.

## Requisitos

1. Utilizar clases abstractas para definir la clase `Figura` y las clases concretas de las figuras geométricas.
2. Utilizar polimorfismo para realizar los cálculos de área y perímetro de las figuras geométricas.
3. Utilizar JOptionPane para solicitar los datos necesarios para realizar los cálculos y para desplegar los resultados.
4. Valida los datos ingresados por usuario, esto se refiere a que no se puedan ingresar valores negativos o cero en los
   campos de datos.
5. Realizar pruebas unitarias para verificar el correcto funcionamiento de las clases implementadas.
6. Documentar el código y explicar el funcionamiento de las clases y métodos implementados.
7. Comprimir y subir el proyecto a la plataforma de acuerdo a las indicaciones del profesor.

## Criterios de evaluación

| Criterio            | Descripción                                                                                                       | Puntaje |
|---------------------|-------------------------------------------------------------------------------------------------------------------|---------|
| Portada             | Contiene los datos de identificación de los integrantes del equipo (nombres completos, grupo, número de control). | 5%      |
| Documentación       | Contiene la documentación de las clases y tipos enumerados implementados.                                         | 5%      |
| Funcionalidad       | La calculadora de figuras geométricas realiza los cálculos de área y perímetro de forma correcta.                 | 40%     |
| Interfaz            | La calculadora de figuras geométricas utiliza JOptionPane para solicitar los datos y desplegar los resultados.    | 20%     |
| Pruebas             | Se realizan pruebas unitarias para verificar el correcto funcionamiento de las clases implementadas.              | 20%     |
| Validación de Datos | Se valida que los datos ingresados por el usuario sean correctos.                                                 | 10%     |
| Total               |                                                                                                                   | 100%    |

## Fecha de entrega

Viernes 14 de marzo de 2025 a las 23:59 hrs.

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos como máximo.**
> {style="warning"}

> **Integrante que no aparezca en la portada del documento no será calificado.**
> {style="warning"}