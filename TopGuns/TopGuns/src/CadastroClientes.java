import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CadastroClientes extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JComboBox comboBox1;
    private JButton limparButton;
    private JButton salvarButton;
    private JButton sairButton;

    public CadastroClientes() {
        setTitle("Cadastro de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel label1 = new JLabel("Nome:");
        JLabel label2 = new JLabel("Telefone:");
        JLabel label3 = new JLabel("CPF:");
        JLabel label4 = new JLabel("RG:");
        JLabel label5 = new JLabel("Endereço:");
        JLabel label6 = new JLabel("E-mail:");
        JLabel label7 = new JLabel("ID de Cadastro:");
        JLabel label8 = new JLabel("Autorização de compra da PF:");

        textField1 = new JTextField(20);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5 = new JTextField(20);
        textField6 = new JTextField(20);
        textField7 = new JTextField(20);
        comboBox1 = new JComboBox(new String[]{"Sim", "Não"});

        // Create buttons
        limparButton = new JButton("Limpar");
        salvarButton = new JButton("Salvar");
        sairButton = new JButton("Sair");

        // Add action listeners for buttons
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvarDados();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create panel and set layout
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Create horizontal group
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label1)
                                .addComponent(label2)
                                .addComponent(label3)
                                .addComponent(label4)
                                .addComponent(label5)
                                .addComponent(label6)
                                .addComponent(label7)
                                .addComponent(label8))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(textField1)
                                .addComponent(textField2)
                                .addComponent(textField3)
                                .addComponent(textField4)
                                .addComponent(textField5)
                                .addComponent(textField6)
                                .addComponent(textField7)
                                .addComponent(comboBox1)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(limparButton)
                                        .addComponent(salvarButton)
                                        .addComponent(sairButton)))
        );

        // Create vertical group
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label1)
                                .addComponent(textField1))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(textField2))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(textField3))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(textField4))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(textField5))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(textField6))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label7)
                                .addComponent(textField7))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label8)
                                .addComponent(comboBox1))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(limparButton)
                                .addComponent(salvarButton)
                                .addComponent(sairButton))
        );

        // Add panel to frame
        add(panel);
    }

    private void limparCampos() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
        comboBox1.setSelectedItem("Sim");
    }

    private void salvarDados() throws IOException {
        String nome = textField1.getText();
        String telefone = textField2.getText();
        String cpf = textField3.getText();
        String rg = textField4.getText();
        String endereco = textField5.getText();
        String email = textField6.getText();
        boolean autorizacao = comboBox1.getSelectedItem().equals("Sim");

        Clientes cliente = new Clientes(nome, telefone, cpf, rg, endereco, email, autorizacao);

        String path = "clientes.txt";
        salvarNoArquivo(cliente, path);

        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!\n" + cliente.toString());

        limparCampos();
    }

    private void salvarNoArquivo(Clientes cliente, String path) throws IOException {
        BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true));
        buffWrite.append(cliente.toString() + "\n");
        buffWrite.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroClientes().setVisible(true);
            }
        });
    }
}