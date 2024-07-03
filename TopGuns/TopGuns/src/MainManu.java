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
    private JLabel imageLabel;

    public MainManu() {
        setTitle("Menu Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Adicionando a imagem ao lado esquerdo
        imageLabel = new JLabel(new ImageIcon("caminho/para/sua/imagem.png")); // Substitua pelo caminho da sua imagem
        mainPanel.add(imageLabel, BorderLayout.WEST);

        tabbedPane1 = new JTabbedPane();

        cadastrosPanel = new JPanel(new BorderLayout());
        vendasPanel = new JPanel(new BorderLayout());
        relatoriosPanel = new JPanel(new BorderLayout());

        JPanel cadastrosButtonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        JPanel vendasButtonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel relatoriosButtonPanel = new JPanel(new GridLayout(5, 1, 10, 10));

        Font buttonFont = new Font("Arial", Font.PLAIN, 12);

        // Botões de cadastro
        clientesButton = createButton("Clientes", buttonFont);
        funcionariosButton = createButton("Funcionarios", buttonFont);
        produtosButton = createButton("Produtos", buttonFont);
        fornecedoresButton = createButton("Fornecedores", buttonFont);

        // Botões de vendas
        iniciarNovaVendaButton = createButton("Iniciar nova venda", buttonFont);
        produtosButton1 = createButton("Produtos", buttonFont);
        funcionariosButton1 = createButton("", buttonFont);
        vitrineProdutos = createButton("Vitrine Produtos", buttonFont);
        cadFuncionarios = createButton("CadastroFuncionarios", buttonFont);

        // Botões de Relatórios
        rlEstoque = createButton("Estoque", buttonFont);
        rlClientes = createButton("Clientes", buttonFont);
        rlFornecedor = createButton("Fornecedor", buttonFont);
        rlFuncionarios = createButton("Funcionarios", buttonFont);
        rlVendas = createButton("Vendas", buttonFont);

        // Adiciona os botões aos painéis de botões
        cadastrosButtonPanel.add(clientesButton);
        cadastrosButtonPanel.add(funcionariosButton);
        cadastrosButtonPanel.add(produtosButton);
        cadastrosButtonPanel.add(fornecedoresButton);

        vendasButtonPanel.add(iniciarNovaVendaButton);
        vendasButtonPanel.add(produtosButton1);

        relatoriosButtonPanel.add(rlClientes);
        relatoriosButtonPanel.add(rlFornecedor);
        relatoriosButtonPanel.add(rlEstoque);
        relatoriosButtonPanel.add(rlFuncionarios);
        relatoriosButtonPanel.add(rlVendas);

        // Adiciona os painéis de botões ao painel principal dos respectivos abas
        cadastrosPanel.add(cadastrosButtonPanel, BorderLayout.EAST);
        vendasPanel.add(vendasButtonPanel, BorderLayout.EAST);
        relatoriosPanel.add(relatoriosButtonPanel, BorderLayout.EAST);

        tabbedPane1.addTab("Cadastros", cadastrosPanel);
        tabbedPane1.addTab("Vendas", vendasPanel);
        tabbedPane1.addTab("Relatórios", relatoriosPanel);

        mainPanel.add(tabbedPane1, BorderLayout.CENTER);

        add(mainPanel);

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

    private JButton createButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setMargin(new Insets(5, 9, 2, 6)); // Ajuste de margem
        return button;
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