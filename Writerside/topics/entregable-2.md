# Entregable 2: Sistema de Vehículos para una App de Transporte

En este entregable, se pide implementar un sistema de vehículos para una app de transporte en Java utilizando clases
abstractas e interfaces. El sistema debe ser capaz de gestionar los siguientes tipos de vehículos:

1. Automóvil
2. Motocicleta
3. Scooter
4. Camioneta

Para ello, se deben seguir los siguientes pasos:

1. Crear una clase abstracta `Vehicle` que contenga los siguientes métodos abstractos:
    * `calculateTripCost(double distance)`: Este método debe calcular y devolver la tarifa del vehículo.
    * `printTicket()`: Este método debe devolver una cadena de texto con los datos del vehículo y la tarifa calculada.
      **Es tu decisión si es concrete o abstracto.**
    * `displayVehicleInfo()`: Este método debe mostrar en consola la información del vehículo.
    * Así como los siguientes atributos:
        * `brand`: Marca del vehículo.
        * `model`: Modelo del vehículo.
        * `year`: Año de fabricación del vehículo.
        * `licensePlate`: Placa del vehículo.
        * `rentalPrice`: Precio de renta del vehículo por día.
        * `pricePerKm`: Precio por kilómetro del vehículo.
2. Crear una interfaz `Rentable` con el siguiente método:
    * `rentVehicle(int days)`: Este método debe calcular y devolver el costo de renta del vehículo por los días
      especificados.
3. Crear una clase concreta para cada uno de los tipos de vehículos mencionados anteriormente que herede de la clase
   `Vehicle` e implemente los métodos `calculateTripCost`, `printTicket` y `displayVehicleInfo` según corresponda.
    * La clase `Automobile` debe tener un atributo adicional `fuelConsumption` que indique el consumo de combustible del
      automóvil en kilómetros por litro. Así como una función adicional `calculateFuelCost(double distance)` que calcule
      el costo de combustible para un viaje de la distancia especificada.
    * La clase `Motorcycle` debe tener un atributo adicional `engineDisplacement` que indique la cilindrada del motor de
      la motocicleta en centímetros cúbicos. Así como una función adicional `calculateInsuranceCost()` que calcule el
      costo del seguro de la motocicleta.
    * La clase `Scooter` debe tener un atributo adicional `maxSpeed` que indique la velocidad máxima de la scooter en
      kilómetros por hora. Así como una función adicional `calculateHelmetCost(int helmets)` que calcule el costo de los
      cascos para el número especificado.
    * La clase `Van` debe tener un atributo adicional `maxLoad` que indique la carga máxima que puede transportar la
      camioneta en kilogramos. Así como una función adicional `calculateLoadCost(double load)` que calcule el costo de
      la carga para el peso especificado.
4. Implementar la interfaz `Rentable` en las clases `Automobile`, `Motorcycle`, `Scooter` y `Van`.
5. Crear una clase `TransportApp` que contenga un arreglo dinámico de vehículos.
6. Define las funciones que cubrán los siguientes requerimientos:
    * Agregar un vehículo al arreglo.
    * Mostrar la información de todos los vehículos.
    * Calcular la tarifa de un viaje para un vehículo específico.
    * Calcular el costo de renta de un vehículo por los días especificados.
    * Calcular el costo de combustible de un automóvil para un viaje de la distancia especificada.
    * Calcular el costo del seguro de una motocicleta.
    * Calcular el costo de los cascos para una scooter.
    * Calcular el costo de la carga para una camioneta.
    * Mostrar el ticket con los datos del vehículo y la tarifa calculada.
7. Realizar pruebas unitarias para verificar el correcto funcionamiento de las clases implementadas.
8. Documentar el código y explicar el funcionamiento de las clases y métodos implementados.

## Requisitos

1. Utilizar clases abstractas para definir la clase `Vehicle` y las clases concretas de los vehículos.
2. Utilizar interfaces para definir la interfaz `Rentable`.
3. Utilizar arreglos dinámicos para almacenar los vehículos en la clase `TransportApp`.
4. Realizar pruebas unitarias para verificar el correcto funcionamiento de las clases implementadas.
5. Documentar el código y explicar el funcionamiento de las clases y métodos implementados.
6. Comprimir y subir el proyecto a la plataforma de acuerdo a las indicaciones del profesor.

## Criterios de evaluación

| Criterio      | Descripción                                                                                          | Puntaje  |
|---------------|------------------------------------------------------------------------------------------------------|----------|
| Portada       | Contiene los datos del equipo.                                                                       | 5%       |
| Documentación | Contiene la documentación de las clases y tipos enumerados implementados.                            | 5%       |
| Funcionalidad | El sistema de vehículos realiza los cálculos de tarifa y renta de forma correcta.                    | 40%      |
| Interfaz      | El sistema de vehículos permite agregar vehículos, mostrar información y calcular tarifas y rentas.  | 20%      |
| Pruebas       | Se realizan pruebas unitarias para verificar el correcto funcionamiento de las clases implementadas. | 30%      |
| **Total**     |                                                                                                      | **100**% |

## Fecha de entrega

Viernes 28 de marzo de 2025 a las 23:59 hrs.

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos como máximo.**
> {style="warning"}

> **Integrante que no aparezca en la portada del documento no será calificado.**
> {style="warning"}