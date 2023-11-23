package ex3.app;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;

class CalculadoraNumeros {
    public static double calcularMedia(ArrayList<Integer> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("A lista de números não pode ser nula ou vazia.");
        }

        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }

        return (double) soma / numeros.size();
    }
}

public class CalculadoraForm extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField numeroField1;
    private JTextField numeroField2;
    private JTextArea resultadoArea;

    public CalculadoraForm() {
        setTitle("Calculadora de Média + Tratamento de Erros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(475, 207);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        // Componentes do formulário
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 486, 236);
        JLabel label1 = new JLabel("Número 1:");
        label1.setBounds(10, 71, 50, 14);
        JLabel label2 = new JLabel("Número 2:");
        label2.setBounds(10, 110, 50, 14);
        numeroField1 = new JTextField(10);
        numeroField1.setBounds(65, 68, 86, 20);
        numeroField2 = new JTextField(10);
        numeroField2.setBounds(65, 107, 86, 20);
        JButton calcularButton = new JButton("Calcular Média");
        calcularButton.setBounds(174, 91, 101, 23);
        resultadoArea = new JTextArea(5, 20);
        resultadoArea.setBounds(285, 48, 164, 94);
        resultadoArea.setEditable(false);
        panel.setLayout(null);

        // Adicionando componentes ao painel
        panel.add(label1);
        panel.add(numeroField1);
        panel.add(label2);
        panel.add(numeroField2);
        panel.add(calcularButton);
        panel.add(resultadoArea);

        // Adicionando o painel ao JFrame
        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("Calcular Média + Tratamento de Erros");
        lblNewLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
        lblNewLabel.setBounds(7, 0, 306, 38);
        panel.add(lblNewLabel);

        // Ação do botão calcular
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obter os números dos campos de texto
                    int numero1 = Integer.parseInt(numeroField1.getText().trim());
                    int numero2 = Integer.parseInt(numeroField2.getText().trim());

                    // Criar uma lista com os números
                    ArrayList<Integer> numeros = new ArrayList<>();
                    numeros.add(numero1);
                    numeros.add(numero2);

                    // Calcular a média usando a classe CalculadoraNumeros
                    double media = CalculadoraNumeros.calcularMedia(numeros);

                    // Exibir o resultado na área de texto
                    resultadoArea.setText("Média dos números: " + media);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira números válidos.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraForm().setVisible(true);
            }
        });
    }
}
