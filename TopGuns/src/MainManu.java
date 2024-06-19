import com.sun.security.auth.module.JndiLoginModule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainManu extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel cadastrosPanel;
    private JPanel vendasPanel;
    private JPanel relatoriosPanel;
    private JButton clientesButton;
    private JButton funcionariosButton;
    private JButton produtosButton;
    private JButton fornecedoresButton;
    private JButton iniciarNovaVendaButton;
    private JButton produtosButton1;
    private JButton cadFuncionarios;
    private JTabbedPane paneVendas;
    private JTabbedPane paneRl;
    private JButton rlEstoque;
    private JButton rlClientes;
    private JButton rlFuncionarios;
    private JButton rlVendas;
    private JButton rlFornecedor;
    private JButton vitrineProdutos;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane3;
    private JButton funcionariosButton1;
    private JButton rlFornecedores;

    public MainManu() {
        setTitle("Menu Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        tabbedPane1 = new JTabbedPane();

        cadastrosPanel = new JPanel();
        vendasPanel = new JPanel();
        relatoriosPanel = new JPanel();

        cadastrosPanel.setLayout(new GridLayout(4, 1, 10, 10));
        vendasPanel.setLayout(new GridLayout(2, 1, 10, 10));
        relatoriosPanel.setLayout(new GridLayout(1, 1, 10, 10));

        // Botões  de cadastro
        clientesButton = new JButton("Clientes");
        funcionariosButton = new JButton("Funcionarios");
        produtosButton = new JButton("Produtos");
        fornecedoresButton = new JButton("Fornecedores");

        // Botões de vendas
        iniciarNovaVendaButton = new JButton("Iniciar nova venda");
        produtosButton1 = new JButton("Produtos");
        funcionariosButton1 = new JButton("");
        vitrineProdutos = new JButton("Vitrine Produtos");
        cadFuncionarios = new JButton("CadastroFuncionairos");

        //  // Botões  de Relatorios
        rlEstoque = new JButton(" Estoque");
        rlClientes = new JButton(" Clientes");
        rlFornecedor  = new JButton(" Fornecedor");
        rlFuncionarios = new JButton("Funcionario");
        rlVendas = new JButton("Vendas");


        // Adiciona os botões aos painel
        // Botõoes Cadastro
        cadastrosPanel.add(clientesButton);
        cadastrosPanel.add(funcionariosButton);
        cadastrosPanel.add(produtosButton);
        cadastrosPanel.add(fornecedoresButton);

        // Vendas
        vendasPanel.add(iniciarNovaVendaButton);
        vendasPanel.add(produtosButton1);

        // Relatorios
        relatoriosPanel.add(rlClientes);
        relatoriosPanel.add(rlFornecedor);
        relatoriosPanel.add(rlEstoque);
        relatoriosPanel.add(rlFuncionarios);
        relatoriosPanel.add(rlVendas);


        tabbedPane1.addTab("Cadastros", cadastrosPanel);
        tabbedPane1.addTab("Vendas", vendasPanel);
        tabbedPane1.addTab("Relatórios", relatoriosPanel);

        // Add tabbed pane to the frame
        add(tabbedPane1);

        // Adicionar evento nos botões
        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleClientesButton();
            }
        });

        funcionariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleFuncionariosButton();
            }
        });

        produtosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleProdutosButton();
            }
        });

        fornecedoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleFornecedoresButton();
            }
        });

        iniciarNovaVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleIniciarNovaVendaButton();
            }
        });

        rlEstoque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleEstoqueButton();
            }
        });

        produtosButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleProdutosButton1();
            }
        });
    }
    // Bloco de codigo Handle, onde e especificado o que será realizado no botão
    private void handleClientesButton() {
        openCadastroClientes();
    }

    private void handleFuncionariosButton() {
        openCadastroFuncionarios();
    }

    private void handleProdutosButton() {
        openCadastroProdutos();
    }

    private void handleFornecedoresButton() {
        openCadastroFornecedores();
    }

    private void handleIniciarNovaVendaButton() {
        JOptionPane.showMessageDialog(this, "Iniciar Nova Venda inativo!");
    }

    private void handleEstoqueButton() {
        JOptionPane.showMessageDialog(this, "Estoque inativo!");
    }

    private void handleProdutosButton1() {
        JOptionPane.showMessageDialog(this, "Produtos inativo!");
    }

    // Blocos para abrir a tela de cadastro.
    //  Abrir  cadastro de  cliente
    private void openCadastroClientes() {
        CadastroClientes cadastroClientes = new CadastroClientes();
        cadastroClientes.setVisible(true);
        this.dispose();
    }

    //  Abrir  cadastro de Funcionarios
    private void openCadastroFuncionarios() {
        CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();
        cadastroFuncionarios.setVisible(true);
        this.dispose();
    }
    //  Abrir  cadastro de Produto
    private void openCadastroProdutos() {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        cadastroProdutos.setVisible(true);
        this.dispose();
    }
    //Abrir  cadastro de Fornecedores
    private void openCadastroFornecedores() {
        CadastroFornecedores cadastroFornecedores = new CadastroFornecedores();
        cadastroFornecedores.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainManu().setVisible(true);
            }
        });
    }
}