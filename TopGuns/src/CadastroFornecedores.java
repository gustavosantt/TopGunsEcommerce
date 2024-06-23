import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CadastroFornecedores extends JFrame {
    private JPanel panel1;
    private JTextField textFieldNome;
    private JTextField textFieldId;
    private JTextField textFieldTelefone;
    private JTextField textFieldEndereco;
    private JTextField textFieldEmail;
    private JTextField textFieldCnpj;
    private JButton salvarButton;
    private JButton limparButton;
    private JButton cancelarButton;

    // Layout Painel
    private void setupLayout() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel labelId = new JLabel("ID");
        JLabel labelNome = new JLabel("Nome");
        JLabel labelTelefone = new JLabel("Telefone");
        JLabel labelEndereco = new JLabel("Endereço");
        JLabel labelEmail = new JLabel("Email");
        JLabel labelCnpj = new JLabel("CNPJ");

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelId)
                                .addComponent(labelNome)
                                .addComponent(labelTelefone)
                                .addComponent(labelEndereco)
                                .addComponent(labelEmail)
                                .addComponent(labelCnpj))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(textFieldId)
                                .addComponent(textFieldNome)
                                .addComponent(textFieldTelefone)
                                .addComponent(textFieldEndereco)
                                .addComponent(textFieldEmail)
                                .addComponent(textFieldCnpj)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(limparButton)
                                        .addComponent(salvarButton)
                                        .addComponent(cancelarButton)))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelId)
                                .addComponent(textFieldId))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelNome)
                                .addComponent(textFieldNome))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTelefone)
                                .addComponent(textFieldTelefone))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelEndereco)
                                .addComponent(textFieldEndereco))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelEmail)
                                .addComponent(textFieldEmail))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelCnpj)
                                .addComponent(textFieldCnpj))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(limparButton)
                                .addComponent(salvarButton)
                                .addComponent(cancelarButton))
        );

        add(panel);
    }

    public CadastroFornecedores() {
        setTitle("Cadastro de Fornecedores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        setupLayout();
        setSize(600, 400);
    }

    private void initComponents() {
        panel1 = new JPanel();
        textFieldId = new JTextField(20);
        textFieldNome = new JTextField(20);
        textFieldTelefone = new JTextField(20);
        textFieldEndereco = new JTextField(20);
        textFieldEmail = new JTextField(20);
        textFieldCnpj = new JTextField(20);
        salvarButton = new JButton("Salvar");
        limparButton = new JButton("Limpar");
        cancelarButton = new JButton("Cancelar");

        setupListeners();
    }

    private void setupListeners() {
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
                    JOptionPane.showMessageDialog(CadastroFornecedores.this, "Erro ao salvar dados: " + ex.getMessage(), "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela do cadastro de fornecedores
            }
        });
    }

    private void limparCampos() {
        textFieldId.setText("");
        textFieldNome.setText("");
        textFieldTelefone.setText("");
        textFieldEndereco.setText("");
        textFieldEmail.setText("");
        textFieldCnpj.setText("");
    }

    private void salvarDados() throws IOException {
        String id = textFieldId.getText();
        String nome = textFieldNome.getText();
        String telefone = textFieldTelefone.getText();
        String endereco = textFieldEndereco.getText();
        String email = textFieldEmail.getText();
        String cnpj = textFieldCnpj.getText();

        // Cria um novo fornecedor com todos os parâmetros necessários
        Fornecedores fornecedor = new Fornecedores(id, nome, telefone, endereco, email, cnpj);

        String path = "fornecedores.txt";
        salvarNoArquivo(fornecedor, path);

        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!\n" + fornecedor.toString());

        limparCampos();
    }

    private void salvarNoArquivo(Fornecedores fornecedor, String path) throws IOException {
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true))) {
            buffWrite.append(fornecedor.toString()).append("\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroFornecedores().setVisible(true);
            }
        });
    }
}


