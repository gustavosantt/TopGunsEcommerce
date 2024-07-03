import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CadastroFuncionarios extends JFrame {
    private JTextField textFieldId;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JTextField textFieldCargo;
    private JTextField textFieldCpf;
    private JTextField textFieldSalario;
    private JLabel labelId;
    private JLabel labelNome;
    private JLabel labelEmail;
    private JLabel labelCargo;
    private JLabel labelCpf;
    private JLabel labelSalario;
    private JButton limparButton;
    private JButton salvarButton;
    private JButton cancelarButton;
    private MainManu mainManu; // Referência para o menu principal

    public CadastroFuncionarios() {
        setTitle("Cadastro de Funcionários");
        initComponents();
        setupLayout();
        setupListeners();

        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        // Initialize components
        labelId = new JLabel("ID:");
        labelNome = new JLabel("Nome:");
        labelEmail = new JLabel("E-mail:");
        labelCargo = new JLabel("Cargo:");
        labelCpf = new JLabel("CPF:");
        labelSalario = new JLabel("Salário:");

        textFieldId = new JTextField(20);
        textFieldNome = new JTextField(20);
        textFieldEmail = new JTextField(20);
        textFieldCargo = new JTextField(20);
        textFieldCpf = new JTextField(20);
        textFieldSalario = new JTextField(20);

        limparButton = new JButton("Limpar");
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");
    }

    private void setupLayout() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelId)
                                .addComponent(labelNome)
                                .addComponent(labelEmail)
                                .addComponent(labelCargo)
                                .addComponent(labelCpf)
                                .addComponent(labelSalario))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(textFieldId)
                                .addComponent(textFieldNome)
                                .addComponent(textFieldEmail)
                                .addComponent(textFieldCargo)
                                .addComponent(textFieldCpf)
                                .addComponent(textFieldSalario)
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
                                .addComponent(labelEmail)
                                .addComponent(textFieldEmail))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelCargo)
                                .addComponent(textFieldCargo))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelCpf)
                                .addComponent(textFieldCpf))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelSalario)
                                .addComponent(textFieldSalario))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(limparButton)
                                .addComponent(salvarButton)
                                .addComponent(cancelarButton))
        );

        add(panel);
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
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CadastroFuncionarios.this, "Erro: O valor do salário deve ser um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(CadastroFuncionarios.this, "Erro ao salvar dados: " + ex.getMessage(), "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela do cadastro de funcionários
                mainManu.setVisible(true); // Exibe o menu principal
            }
        });
    }

    private void limparCampos() {
        textFieldId.setText("");
        textFieldNome.setText("");
        textFieldEmail.setText("");
        textFieldCargo.setText("");
        textFieldCpf.setText("");
        textFieldSalario.setText("");
    }

    private void salvarDados() throws IOException {
        String id = textFieldId.getText();
        String nome = textFieldNome.getText();
        String email = textFieldEmail.getText();
        String cargo = textFieldCargo.getText();
        String cpf = textFieldCpf.getText();

        // Tratamento da exceção NumberFormatException
        float salario;
        try {
            salario = Float.parseFloat(textFieldSalario.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro: O valor do salário deve ser um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
            return; // Sai do método sem salvar se houver erro de formato
        }

        // Crie um novo funcionário com todos os parâmetros necessários
        Funcionarios funcionario = new Funcionarios(id, nome, email, cargo, cpf, salario, "Outra Informação");

        String path = "funcionarios.txt";
        salvarNoArquivo(funcionario, path);

        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!\n" + funcionario.toString());

        limparCampos();
    }

    private void salvarNoArquivo(Funcionarios funcionario, String path) throws IOException {
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true))) {
            buffWrite.append(funcionario.toString()).append("\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainManu mainManu = new MainManu(); // Crie uma instância do menu principal
                CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();
                cadastroFuncionarios.mainManu = mainManu; // Defina a referência para o menu principal
                cadastroFuncionarios.setVisible(true);
                mainManu.setVisible(false); // Esconda o menu principal inicialmente
            }
        });
    }
}
