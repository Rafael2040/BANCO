package veiw;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.ContaBancaria;
import model.dao.ContaBancariaDAO;


public class JFListarContaBancaria extends JFrame {

	private JPanel contentPane;
	private JTable jtCalcado;
	private JButton btnLimpar;
	private JButton btnCancelar;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarContaBancaria frame = new JFListarContaBancaria();
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
	public JFListarContaBancaria() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				readJtable();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Conta Bancaria");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 322, 23);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 541, 241);
		contentPane.add(scrollPane);
		
		jtCalcado = new JTable();
		jtCalcado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Agencia", "Conta", "Nome", "Saldo","T/ Conta"
			}
		));
		scrollPane.setViewportView(jtCalcado);
		
		btnLimpar = new JButton("Atualizar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtCalcado.getSelectedRow() != -1) {
					JFAtualizarContaBancaria ac = new JFAtualizarContaBancaria((int)jtCalcado.getValueAt(jtCalcado.getSelectedRow(), 0 ));
					ac.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Selecione uma linha");
				}
				readJtable();
			}
		});
		btnLimpar.setBounds(10, 330, 99, 26);
		contentPane.add(btnLimpar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setAction(action_1);
		btnCancelar.setBounds(321, 330, 93, 26);
		contentPane.add(btnCancelar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setAction(action_2);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtCalcado.getSelectedRow() != -1) {	
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja deletar o Calcado selecionado", "Deletar", JOptionPane.YES_NO_OPTION);
					if(opcao == 0) {
						ContaBancariaDAO dao = new ContaBancariaDAO();
						ContaBancaria c = new ContaBancaria();
						c.setId((int) jtCalcado.getValueAt(jtCalcado.getSelectedRow(), 0));
						dao.delete(c);
					}
				}
				else {
					JOptionPane.showMessageDialog(null,"Selecione uma linha");
				}
				readJtable();
				
			}
		});
		btnDeletar.setBounds(119, 330, 93, 26);
		contentPane.add(btnDeletar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					JFCadastrarContaBancaria ac;
					ac = new JFCadastrarContaBancaria();
					ac.setVisible(true);
				}
		});
		btnCadastrar.setAction(action_3);
		btnCadastrar.setBounds(218, 330, 93, 26);
		contentPane.add(btnCadastrar);
		
		readJtable();
	}
	
	
	public void readJtable() {
		DefaultTableModel modelo = (DefaultTableModel) jtCalcado.getModel();
		modelo.setNumRows(0);
		ContaBancariaDAO cDAO = new ContaBancariaDAO();
		for(ContaBancaria c: cDAO.read()) {
			String est = null;
			if(c.isCorrente_Poupaça() == true) {
				est = ("Poupança");
			}
			else {
				est = ("Corrente");
			}
			modelo.addRow(new Object[] {
					c.getId(),
					c.getAgencia(),
					c.getConta(),
					c.getNome(),
					c.getSaldo(),
					est
			});
		}
		
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Limpar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Cancelar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Deletar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "Cadastrar");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}