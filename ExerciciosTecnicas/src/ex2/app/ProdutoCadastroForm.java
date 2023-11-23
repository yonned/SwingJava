package ex2.app;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class ProdutoCadastroForm extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nm_produto;
    private JTextField vl_preco;
    private ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProdutoCadastroForm frame = new ProdutoCadastroForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ProdutoCadastroForm() {
    	setResizable(false);
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 697, 299);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Cadastro de Produto");
        lblNewLabel.setFont(new Font("Corbel Light", Font.PLAIN, 29));
        lblNewLabel.setBounds(11, 12, 243, 36);
        contentPane.add(lblNewLabel);

        nm_produto = new JTextField();
        nm_produto.setBounds(89, 68, 170, 22);
        contentPane.add(nm_produto);
        nm_produto.setColumns(10);

        vl_preco = new JTextField();
        vl_preco.setColumns(10);
        vl_preco.setBounds(89, 111, 170, 22);
        contentPane.add(vl_preco);

        JLabel lblNewLabel_1 = new JLabel("Produto:");
        lblNewLabel_1.setBounds(13, 73, 82, 15);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("Preço (R$):");
        lblNewLabel_1_1.setBounds(11, 116, 82, 15);
        contentPane.add(lblNewLabel_1_1);

        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(424, 30, 247, 219);
        contentPane.add(textArea);

        JLabel lblNewLabel_2 = new JLabel("Desenvolvido por César Rodrigues.");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        lblNewLabel_2.setBounds(0, 246, 175, 14);
        contentPane.add(lblNewLabel_2);

        final JRadioButton tipo_alimenticio = new JRadioButton("Alimentício");
        tipo_alimenticio.setBounds(89, 149, 126, 23);
        contentPane.add(tipo_alimenticio);

        final JRadioButton tipo_duravel = new JRadioButton("Durável");
        tipo_duravel.setBounds(89, 182, 130, 23);
        contentPane.add(tipo_duravel);
        
        final JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(297, 158, 117, 14);
        contentPane.add(progressBar);

        JButton btnCadastrar = new JButton("");
        btnCadastrar.setIcon(new ImageIcon("C:\\Users\\csari\\Downloads\\imresizer-1700711956649.jpg"));
        btnCadastrar.setSelectedIcon(new ImageIcon("C:\\Users\\csari\\Downloads\\arrow-right.png"));
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String produtoNome = nm_produto.getText();
                String preco = vl_preco.getText();
                String tipo = "";

                if (tipo_alimenticio.isSelected()) {
                    tipo = "Alimentação";
                } else if (tipo_duravel.isSelected()) {
                    tipo = "Durável";
                }

                Produto novoProduto = new Produto(produtoNome, preco, tipo);
                produtos.add(novoProduto);

                nm_produto.setText("");
                vl_preco.setText("");
                tipo_alimenticio.setSelected(false);
                tipo_duravel.setSelected(false);

                textArea.setText("Produtos Cadastrados:\n");
                produtos.forEach(produto -> textArea.setText(
                		"Os dados cadastrados são" + "\n"
                		+ "O nome é: " + produto.getNome() + "\n"
                		+ "O valor é: " + produto.getPreco() + "\n" 
                	    + "O tipo é: " + produto.getTipo() + "\n"));
                
                
                if(produtoNome != null||preco != null|| tipo != null) {
					JOptionPane.showMessageDialog(contentPane, "Cadastro concluído!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else{
					JOptionPane.showMessageDialog(contentPane, "Alguma coisa está vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
					progressBar.setValue(50);
				}
            }
        });
        btnCadastrar.setBounds(325, 104, 52, 36);
        contentPane.add(btnCadastrar);
        
        JLabel lblNewLabel_3 = new JLabel("Dados dos Produtos Registrados:");
        lblNewLabel_3.setBounds(424, 5, 201, 14);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("Tipo:");
        lblNewLabel_4.setBounds(15, 168, 46, 14);
        contentPane.add(lblNewLabel_4);
        
        
    }

    public class Produto {
        private String nome;
        private String preco;
        private String tipo;

        public Produto(String nome, String preco, String tipo) {
            this.nome = nome;
            this.preco = preco;
            this.tipo = tipo;
        }

        public String getNome() {
            return nome;
        }
        public String getTipo() {
            return tipo;
        }

        public String getPreco() {
            return preco;
        }
    }
}
