package exceptions;

import org.brick_breaker.utils.Randomized;

import javax.swing.*;

public class Main {

    public static void validateInt() {

        try {
            int value = Integer.parseInt(
                    JOptionPane.showInputDialog("Ingrese un número"));
            JOptionPane.showMessageDialog(null, value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Valor ingresado no numérico. Intente de nuevo",
                    "Error", JOptionPane.ERROR_MESSAGE);
            validateInt();
        }
    }

    public static void main(String[] args) {

        try {
            int x = Randomized.randomInt(1, 30);
            validateInt();
            if (x < 18)
                throw new NoMinimunException("El número es menor a 18");
            System.out.println("El número es mayor o igual a 18");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
