package view;

import model.Automaton;

import javax.swing.*;
import java.awt.Color;

public class Program {
    static{
        UIManager.put("OptionPane.background", Color.decode("#03045E"));
        UIManager.put("Panel.background", Color.decode("#03045E"));
        UIManager.put("OptionPane.messageForeground", Color.decode("#FFFFFF"));
        UIManager.put("Button.background", Color.decode("#00B4D8"));
        UIManager.put("Button.foreground", Color.decode("#FFFFFF"));
    }

    public static void main(String[] args) {
        Automaton afd = new Automaton();
        Icon gifclose = new ImageIcon(Program.class.getResource("/close.gif"));
        while(true){
            String num = JOptionPane.showInputDialog(null,
                "Type a roman number between I and L: \nDon't write if you wanna exit", "AFD Roman Nums",
                JOptionPane.QUESTION_MESSAGE);
            if(num == null || num.isBlank()) break;

            String afdAnswer = afd.verify(num);
            processAnswer(afdAnswer);
        }
        JOptionPane.showMessageDialog(null, "Closing... Press OK", "AFD Roman Nums",
                JOptionPane.PLAIN_MESSAGE, gifclose);

    }

    private static void processAnswer(String answer){
        // abrir el gif correcto
        String fileName = (answer.contains("Valid")) ? "/bien.gif" : "/mal.gif";
        Icon gif = new ImageIcon(Program.class.getResource(fileName));

        JOptionPane.showMessageDialog(null, answer, "AFD Roman Nums", JOptionPane.PLAIN_MESSAGE, gif);
    }
}
