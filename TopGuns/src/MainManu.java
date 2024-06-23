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
        relatoriosPanel.setLayout(new GridLayout(5, 1, 10, 10));

        // Botões de cadastro
        clientesButton = new JButton("Clientes");
        funcionariosButton = new JButton("Funcionarios");
        produtosButton = new JButton("Produtos");
        fornecedoresButton = new JButton("Fornecedores");

        // Botões de vendas
        iniciarNovaVendaButton = new JButton("Iniciar nova venda");
        produtosButton1 = new JButton("Produtos");
        funcionariosButton1 = new JButton("");
        vitrineProdutos = new JButton("Vitrine Produtos");
        cadFuncionarios = new JButton("CadastroFuncionarios");

        // Botões de Relatórios
        rlEstoque = new JButton("Estoque");
        rlClientes = new JButton("Clientes");
        rlFornecedor = new JButton("Fornecedor");
        rlFuncionarios = new JButton("Funcionarios");
        rlVendas = new JButton("Vendas");

        // Adiciona os botões ao painel
        // Botões Cadastro
        cadastrosPanel.add(clientesButton);
        cadastrosPanel.add(funcionariosButton);
        cadastrosPanel.add(produtosButton);
        cadastrosPanel.add(fornecedoresButton);

        // Vendas
        vendasPanel.add(iniciarNovaVendaButton);
        vendasPanel.add(produtosButton1);

        // Relatórios
        relatoriosPanel.add(rlClientes);
        relatoriosPanel.add(rlFornecedor);
        relatoriosPanel.add(rlEstoque);
        relatoriosPanel.add(rlFuncionarios);
        relatoriosPanel.add(rlVendas);

        tabbedPane1.addTab("Cadastros", cadastrosPanel);
        tabbedPane1.addTab("Vendas", vendasPanel);
        tabbedPane1.addTab("Relatórios", relatoriosPanel);

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

    // Bloco de codigo Handle, onde é especificado o que será realizado no botão
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
        openVenda();
    }

    private void handleEstoqueButton() {
        JOptionPane.showMessageDialog(this, "Armas\n" +
                "Typhoon: 10 unidades\n" +
                "CTT .40: 15 unidades\n" +
                "Fal .762: 5 unidades\n" +
                "M4 A1 .556: 20 unidades\n" +
                "Cal. 12 CBC Pump: 8 unidades\n" +
                "Imbel MD1: 12 unidades\n" +
                "PT 92 9mm: 30 unidades\n" +
                "PT 100 .40: 25 unidades\n" +
                "TH 9: 18 unidades\n" +
                "Desert Eagle .50: 7 unidades\n" +
                "P90: 14 unidades\n" +
                "AWM: 6 unidades\n" +
                "AK47: 9 unidades\n" +
                " \n" +
                "Munições\n" +
                "Munição 9mm: 100 unidades\n" +
                "Munição .40: 80 unidades\n" +
                "Munição .45: 60 unidades\n" +
                "Munição 5.56: 120 unidades\n" +
                "Munição 7.62: 90 unidades\n" +
                " \n" +
                "Acessórios\n" +
                "Mira Holográfica: 50 unidades\n" +
                "Lanterna Tática: 40 unidades\n" +
                "Grip Vertical: 30 unidades\n" +
                "Silenciador: 20 unidades\n" +
                "Coronha Retrátil: 25 unidades");
    }

    private void handleProdutosButton1() {
        openVitrineProdutosGui();
    }

    // Blocos para abrir a tela de cadastro.
    //  Abrir cadastro de cliente
    private void openCadastroClientes() {
        CadastroClientes cadastroClientes = new CadastroClientes();
        cadastroClientes.setVisible(true);
        this.dispose();
    }

    //  Abrir cadastro de Funcionarios
    private void openCadastroFuncionarios() {
        CadastroFuncionarios cadastroFuncionarios = new CadastroFuncionarios();
        cadastroFuncionarios.setVisible(true);
        this.dispose();
    }

    //  Abrir cadastro de Produto
    private void openCadastroProdutos() {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        cadastroProdutos.setVisible(true);
        this.dispose();
    }

    // Abrir cadastro de Fornecedores
    private void openCadastroFornecedores() {
        CadastroFornecedores cadastroFornecedores = new CadastroFornecedores();
        cadastroFornecedores.setVisible(true);
        this.dispose();
    }

    // Abrir Produtos em Vendas
    private void openVitrineProdutosGui() {
        VitrineProdutosGui vitrineProdutosGui = new VitrineProdutosGui();
        vitrineProdutosGui.setVisible(true);
        this.dispose();
    }

    // Abrir venda em vendas
    private void openVenda() {
        Venda venda = new Venda();
        venda.setVisible(true);
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
