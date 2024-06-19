import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CadastroProdutos extends JFrame {
    private JTextField textFieldDescricao;
    private JTextField textFieldTipo;
    private JTextField textFieldPreco;
    private JTextField textFieldQuantEstoq;
    private JTextField textFieldNome;
    private JTextField textFieldIdProduto;
    private JButton limparButton;
    private JButton salvarButton;
    private JButton cancelarButton;

    public CadastroProdutos() {
        setTitle("Cadastro de Produtos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel labelDescricao = new JLabel("Descrição:");
        JLabel labelTipo = new JLabel("Tipo:");
        JLabel labelPreco = new JLabel("Preço:");
        JLabel labelQuantEstoq = new JLabel("Quantidade em Estoque:");
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelIdProduto = new JLabel("Id Produto:");

        textFieldDescricao = new JTextField(20);
        textFieldTipo = new JTextField(20);
        textFieldPreco = new JTextField(20);
        textFieldQuantEstoq = new JTextField(20);
        textFieldNome = new JTextField(20);
        textFieldIdProduto = new JTextField(20);

        // Create buttons
        limparButton = new JButton("Limpar");
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Sair");

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
                    JOptionPane.showMessageDialog(CadastroProdutos.this, "Erro ao salvar dados: " + ex.getMessage());
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
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
                                .addComponent(labelDescricao)
                                .addComponent(labelTipo)
                                .addComponent(labelPreco)
                                .addComponent(labelQuantEstoq)
                                .addComponent(labelNome)
                                .addComponent(labelIdProduto))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(textFieldDescricao)
                                .addComponent(textFieldTipo)
                                .addComponent(textFieldPreco)
                                .addComponent(textFieldQuantEstoq)
                                .addComponent(textFieldNome)
                                .addComponent(textFieldIdProduto)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(limparButton)
                                        .addComponent(salvarButton)
                                        .addComponent(cancelarButton)))
        );

        // Create vertical group
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDescricao)
                                .addComponent(textFieldDescricao))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTipo)
                                .addComponent(textFieldTipo))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelPreco)
                                .addComponent(textFieldPreco))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelQuantEstoq)
                                .addComponent(textFieldQuantEstoq))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelNome)
                                .addComponent(textFieldNome))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(labelIdProduto)
                                .addComponent(textFieldIdProduto))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(limparButton)
                                .addComponent(salvarButton)
                                .addComponent(cancelarButton))
        );

        // Add panel to frame
        add(panel);
    }

    private void limparCampos() {
        textFieldDescricao.setText("");
        textFieldTipo.setText("");
        textFieldPreco.setText("");
        textFieldQuantEstoq.setText("");
        textFieldNome.setText("");
        textFieldIdProduto.setText("");
    }

    private void salvarDados() throws IOException {
        String descricao = textFieldDescricao.getText();
        String tipo = textFieldTipo.getText();
        String nome = textFieldNome.getText();
        String idProduto = textFieldIdProduto.getText();
        float preco;
        int quantEstoq;

        try {
            preco = Float.parseFloat(textFieldPreco.getText().replace(",", "."));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Preço inválido. Por favor, insira um número válido.");
            return;
        }

        try {
            quantEstoq = Integer.parseInt(textFieldQuantEstoq.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantidade em Estoque inválida. Por favor, insira um número inteiro válido.");
            return;
        }

        Produtos produto = new Produtos(descricao, tipo, preco, quantEstoq, nome, idProduto);

        // Save product object to file
        String path = "produtos.txt";
        try (BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path, true))) {
            buffWrite.append(produto.toString());
            buffWrite.append("\n");
        }

        // Show success message
        JOptionPane.showMessageDialog(this, "Dados salvos com sucesso!\n" + produto.toString());

        // Optionally, clear fields after saving
        limparCampos();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroProdutos().setVisible(true);
            }
        });
    }
}