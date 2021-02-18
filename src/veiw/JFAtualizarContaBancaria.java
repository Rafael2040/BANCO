package veiw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.bean.ContaBancaria;
import model.dao.ClienteDAO;
import model.dao.ContaBancariaDAO;
import veiw.JFCadastrarContaBancaria.SwingAction;
import veiw.JFCadastrarContaBancaria.SwingAction_1;
import veiw.JFCadastrarContaBancaria.SwingAction_2;

public class JFAtualizarContaBancaria extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel = new JLabel("Atualizar Conta Banc\u00E1ria");
	private JTextField textAgencia;
	private JTextField textConta;
	private JTextField textNome;
	private JTextField textSaldo;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarContaBancaria frame = new JFAtualizarContaBancaria(id);
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
	public JFAtualizarContaBancaria(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(5, 5, 424, 14);
		contentPane.add(lblNewLabel);
		
		
		ContaBancariaDAO cdao = new ContaBancariaDAO();
		ContaBancaria c = cdao.read(id);
		
		JLabel lblNewLabel_4 = new JLabel("id:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(234, 6, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblId = new JLabel("");
		lblId.setBounds(268, 6, 45, 13);
		contentPane.add(lblId);
		
		textAgencia = new JTextField();
		textAgencia.setBounds(5, 107, 86, 20);
		contentPane.add(textAgencia);
		textAgencia.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ag\u00EAncia");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(5, 83, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Conta");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(104, 83, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textConta = new JTextField();
		textConta.setBounds(101, 107, 86, 20);
		contentPane.add(textConta);
		textConta.setColumns(10);
		
		textNome = new JTextField();
		textNome.setBounds(5, 53, 404, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nome");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(5, 29, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton rdbtnCorrente = new JRadioButton("Conta corrente");
		rdbtnCorrente.setBounds(234, 105, 212, 23);
		contentPane.add(rdbtnCorrente);
		
		JRadioButton rdbtnPoupança = new JRadioButton("Conta poupan\u00E7a");
		rdbtnPoupança.setBounds(234, 130, 212, 23);
		contentPane.add(rdbtnPoupança);
		
		ButtonGroup Corrente_Poupança = new ButtonGroup();
		Corrente_Poupança.add(rdbtnPoupança);
		Corrente_Poupança.add(rdbtnCorrente);
		
		
		JLabel lblNewLabel_6 = new JLabel("Saldo");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(5, 157, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textSaldo = new JTextField();
		textSaldo.setBounds(5, 181, 86, 20);
		contentPane.add(textSaldo);
		textSaldo.setColumns(10);
		
		lblId.setText(String.valueOf(c.getId()));
		textAgencia.setText(c.getAgencia());
		textConta.setText(c.getConta());
		String str = String.valueOf(c.getSaldo());
		textSaldo.setText(str);
		textNome.setText(c.getNome());
		if(c.isCorrente_Poupaça() == false) {
			rdbtnCorrente.setSelected(true);
		}else{
			rdbtnPoupança.setSelected(true);
		}
		
		JButton btnCadastrar = new JButton("Atualizar");
		btnCadastrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				ContaBancaria c = new ContaBancaria();
				ContaBancariaDAO dao = new ContaBancariaDAO();
				c.setId(id);	
				c.setAgencia(textAgencia.getText());
				c.setConta(textConta.getText());
				c.setNome(textNome.getText());
				c.setSaldo(Double.parseDouble(textSaldo.getText()));
				
				if(rdbtnCorrente.isSelected()) {
					c.setCorrente_Poupaça(false);
				}
				else if (rdbtnPoupança.isSelected()) {
					c.setCorrente_Poupaça(true);
				}
				dao.update(c);
			}
		});
		btnCadastrar.setAction(action);
		btnCadastrar.setBounds(5, 293, 89, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tipo de conta");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(213, 79, 95, 23);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textAgencia.setText(null);
				textConta.setText(null);
				textNome.setText(null);
				textSaldo.setText(null);
				Corrente_Poupança.clearSelection();
			}
		});
		btnLimpar.setAction(action_1);
		btnLimpar.setBounds(98, 294, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setAction(action_2);
		btnCancelar.setBounds(340, 294, 89, 23);
		contentPane.add(btnCancelar);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Alterar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Limpar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Cancelar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}