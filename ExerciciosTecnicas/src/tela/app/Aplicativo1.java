package tela.app;

import java.awt.BorderLayout;
import java.util.*;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;

public class Aplicativo1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nm_cliente;
	private JTextField idade_cliente;
	private JTextField email_cliente;
	private JTextField cpf_cliente;
	private JTextField date_cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicativo1 frame = new Aplicativo1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Aplicativo1() {
		setResizable(false);
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea telaFinal = new JTextArea();
		telaFinal.setEditable(false);
		telaFinal.setBounds(313, 13, 261, 317);
		contentPane.add(telaFinal);		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(87, 323, 146, 14);
		contentPane.add(progressBar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 128, 119, 22);
		contentPane.add(comboBox);
		
		final JComboBox opcao = comboBox;
		
		final JProgressBar progresso = progressBar;
		
		final JTextArea finalTelaFinal = telaFinal;
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Object sexo = opcao.getSelectedItem();
				// Botão de enviar:
				String nome = nm_cliente.getText();
				String idade = idade_cliente.getText();
				String email = email_cliente.getText();
				String cpf = cpf_cliente.getText();
				String datanascimento = date_cliente.getText();
				String opcaosexual = sexo.toString();
				
				finalTelaFinal.setText(
						"Bem vindo ao log de cadastro de clientes!" +  "\n"
						+ "" 
					    + "Dados cadastrados do cliente: " + "\n"
						+ "Nome: " + nome + "\n"
						+ "Idade: " + idade + "\n"
						+ "Email: " + email + "\n"
						+ "CPF: " + cpf + "\n"
						+ "Data de nascimento: " + datanascimento + "\n"
						+ "Gênero: " + opcaosexual +  "\n"
						);
			
				progresso.setValue(100);
				
				// Alerta:
				if(nm_cliente != null||idade != null|| email != null|| cpf != null || datanascimento != null || opcaosexual != null) {
					JOptionPane.showMessageDialog(contentPane, "Cadastro concluído!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
				}
				
				else{
					JOptionPane.showMessageDialog(contentPane, "Alguma coisa está vazia!", "Erro", JOptionPane.ERROR_MESSAGE);
					progresso.setValue(50);
				}
			}
		});
		btnNewButton.setBounds(115, 289, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(60, 59, 37, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(59, 94, 37, 14);
		contentPane.add(lblIdade);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(61, 133, 41, 14);
		contentPane.add(lblSexo);
		
		nm_cliente = new JTextField();
		nm_cliente.setBounds(102, 55, 119, 23);
		contentPane.add(nm_cliente);
		nm_cliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setBounds(60, 170, 38, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setBounds(64, 202, 41, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data nascimento:");
		lblNewLabel_3.setBounds(10, 251, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		idade_cliente = new JTextField();
		idade_cliente.setColumns(10);
		idade_cliente.setBounds(102, 89, 119, 23);
		contentPane.add(idade_cliente);
		
		email_cliente = new JTextField();
		email_cliente.setColumns(10);
		email_cliente.setBounds(102, 165, 119, 23);
		contentPane.add(email_cliente);
		
		cpf_cliente = new JTextField();
		cpf_cliente.setColumns(10);
		cpf_cliente.setBounds(102, 199, 119, 23);
		contentPane.add(cpf_cliente);
		
		date_cliente = new JTextField();
		date_cliente.setColumns(10);
		date_cliente.setBounds(102, 247, 119, 23);
		contentPane.add(date_cliente);
		
	
		
		// Adicionar items ao combobox:
		comboBox.addItem("Masculino");
		comboBox.addItem("Feminino");
		comboBox.addItem("Outro");
		comboBox.addItem("Prefiro não responder");
		
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Gostou? Marque se sim.");
		chckbxNewCheckBox.setBounds(417, 331, 189, 23);
		contentPane.add(chckbxNewCheckBox);		
		
		JLabel lblNewLabel_4 = new JLabel("Cadastro de Cliente");
		lblNewLabel_4.setFont(new Font("SimSun-ExtB", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(45, 7, 236, 28);
		contentPane.add(lblNewLabel_4);
	}
}
