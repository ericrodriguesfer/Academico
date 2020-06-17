package br.com.e.calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Calculadora {

	private JFrame frmCalculadora;
	private JTextField txtDisplay;
	private double numUm;
	private double numDois;
	private double resultado;
	private String operador;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frmCalculadora.setVisible(true);
					window.frmCalculadora.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculadora() {
		initialize();
	}

	private void initialize() {
		this.frmCalculadora = new JFrame();
		this.frmCalculadora.setTitle("CALCULADORA");
		this.frmCalculadora.setResizable(false);
		this.frmCalculadora.getContentPane().setBackground(new Color(100, 149, 237));
		this.frmCalculadora.setBounds(100, 100, 270, 292);
		this.frmCalculadora.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.frmCalculadora.getContentPane().setLayout(null);

		this.txtDisplay = new JTextField();
		this.txtDisplay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtDisplay.setHorizontalAlignment(txtDisplay.RIGHT);
		this.txtDisplay.setEditable(false);
		this.txtDisplay.setBounds(10, 11, 234, 30);
		this.frmCalculadora.getContentPane().add(txtDisplay);
		this.txtDisplay.setColumns(10);

		JButton btnSete = new JButton("7");
		btnSete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("7");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "7");
				}
			}
		});
		btnSete.setBounds(10, 52, 73, 23);
		this.frmCalculadora.getContentPane().add(btnSete);

		JButton btnOito = new JButton("8");
		btnOito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("8");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "8");
				}
			}
		});
		btnOito.setBounds(88, 52, 79, 23);
		this.frmCalculadora.getContentPane().add(btnOito);

		JButton btnNove = new JButton("9");
		btnNove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("9");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "9");
				}
			}
		});
		btnNove.setBounds(171, 52, 73, 23);
		this.frmCalculadora.getContentPane().add(btnNove);

		JButton btnQuatro = new JButton("4");
		btnQuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("4");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "4");
				}
			}
		});
		btnQuatro.setBounds(10, 86, 73, 23);
		this.frmCalculadora.getContentPane().add(btnQuatro);

		JButton btnCinco = new JButton("5");
		btnCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("5");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "5");
				}
			}
		});
		btnCinco.setBounds(88, 86, 79, 23);
		this.frmCalculadora.getContentPane().add(btnCinco);

		JButton btnSeis = new JButton("6");
		btnSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("6");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "6");
				}
			}
		});
		btnSeis.setBounds(171, 86, 73, 23);
		this.frmCalculadora.getContentPane().add(btnSeis);

		JButton btnUm = new JButton("1");
		btnUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("1");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "1");
				}
			}
		});
		btnUm.setBounds(10, 120, 73, 23);
		this.frmCalculadora.getContentPane().add(btnUm);

		JButton btnDois = new JButton("2");
		btnDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("2");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "2");
				}
			}
		});
		btnDois.setBounds(88, 120, 79, 23);
		this.frmCalculadora.getContentPane().add(btnDois);

		JButton btnTres = new JButton("3");
		btnTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("3");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "3");
				}
			}
		});
		btnTres.setBounds(171, 120, 73, 23);
		this.frmCalculadora.getContentPane().add(btnTres);

		JButton btnZero = new JButton("0");
		btnZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("0");
				} else {
					String copia = getTxtDisplay().getText();
					setTxtDisplay(copia + "0");
				}
			}
		});
		btnZero.setBounds(10, 154, 73, 23);
		this.frmCalculadora.getContentPane().add(btnZero);

		JButton btnSoma = new JButton("+");
		btnSoma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumUm(Double.parseDouble(getTxtDisplay().getText()));
				setOperador("soma");
				setTxtDisplay("");
			}
		});
		btnSoma.setBounds(171, 188, 73, 23);
		this.frmCalculadora.getContentPane().add(btnSoma);

		JButton btnSubtracao = new JButton("-");
		btnSubtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumUm(Double.parseDouble(getTxtDisplay().getText()));
				setOperador("subtracao");
				setTxtDisplay("");
			}
		});
		btnSubtracao.setBounds(171, 154, 73, 23);
		this.frmCalculadora.getContentPane().add(btnSubtracao);

		JButton btnMultiplicacao = new JButton("*");
		btnMultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumUm(Double.parseDouble(getTxtDisplay().getText()));
				setOperador("multiplicacao");
				setTxtDisplay("");
			}
		});
		btnMultiplicacao.setBounds(10, 188, 73, 23);
		this.frmCalculadora.getContentPane().add(btnMultiplicacao);

		JButton btnDivisao = new JButton("/");
		btnDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumUm(Double.parseDouble(getTxtDisplay().getText()));
				setOperador("divisao");
				setTxtDisplay("");
			}
		});
		btnDivisao.setBounds(88, 188, 79, 23);
		this.frmCalculadora.getContentPane().add(btnDivisao);

		JButton btnPonto = new JButton(".");
		btnPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getTxtDisplay().getText().equals("")) {
					setTxtDisplay("");
				} else {
					String copia = getTxtDisplay().getText();

					int qtdPontos = 0;

					for (int i = 0; i < copia.length(); i++) {
						if (copia.substring(i, i + 1).equalsIgnoreCase(".")) {
							qtdPontos++;
						}
					}

					if (qtdPontos == 0) {
						setTxtDisplay(copia + ".");
					}
				}
			}
		});
		btnPonto.setBounds(88, 154, 79, 23);
		this.frmCalculadora.getContentPane().add(btnPonto);

		JButton btnResultado = new JButton("=");
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNumDois(Double.parseDouble(getTxtDisplay().getText()));

				if (getOperador().equals("subtracao")) {
					setResultado(subtrair(getNumUm(), getNumDois()));
				} else if (getOperador().contentEquals("multiplicacao")) {
					setResultado(multiplicacao(getNumUm(), getNumDois()));
				} else if (getOperador().equals("divisao")) {
					setResultado(divisao(getNumUm(), getNumDois()));
				} else if (getOperador().equals("soma")) {
					setResultado(somar(getNumUm(), getNumDois()));
				} else {
					setResultado(0);
				}

				setTxtDisplay(String.valueOf(getResultado()));
				setNumUm(0);
				setNumDois(0);
				setOperador(null);
				setResultado(0);
			}
		});
		btnResultado.setBounds(10, 222, 113, 23);
		this.frmCalculadora.getContentPane().add(btnResultado);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTxtDisplay("");
			}
		});
		btnLimpar.setBounds(133, 222, 111, 23);
		this.frmCalculadora.getContentPane().add(btnLimpar);
	}

	public JFrame getFrmCalculadora() {
		return frmCalculadora;
	}

	public void setFrmCalculadora(JFrame frmCalculadora) {
		this.frmCalculadora = frmCalculadora;
	}

	public JTextField getTxtDisplay() {
		return txtDisplay;
	}

	public void setTxtDisplay(String txtDisplay) {
		this.txtDisplay.setText(txtDisplay);
		;
	}

	public double getNumUm() {
		return numUm;
	}

	public void setNumUm(double numUm) {
		this.numUm = numUm;
	}

	public double getNumDois() {
		return numDois;
	}

	public void setNumDois(double numDois) {
		this.numDois = numDois;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public String getOperador() {
		return operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

	public double somar(double numUm, double numDois) {
		return (numUm + numDois);
	}

	public double subtrair(double numUm, double numDois) {
		return (numUm - numDois);
	}

	public double multiplicacao(double numUm, double numDois) {
		return (numUm * numDois);
	}

	public double divisao(double numUm, double numDois) {
		return (numUm / numDois);
	}
}
