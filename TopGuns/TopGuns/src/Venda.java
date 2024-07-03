import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Venda extends JFrame {

    private JComboBox<String> itemComboBox;
    private JButton ComprarP90;
    private JButton CompraButton;
    private JButton comprarButton2;
    private JButton CoomprarAwm;
    private JButton comprarButton;
    private JButton comprarButton1;
    private JButton comprarButton3;
    private JButton comprarButton4;
    private JButton comprarButton5;
    private JButton comprarButton6;
    private JButton finalizarCompra;
    private JPanel valorCompra;
    private JLabel totalLabel;
    private double totalValue = 0.0;

    public Venda() {
        setTitle("Carrinho de Compras");
        setSize(1000, 600); // Aumentei o tamanho para acomodar mais produtos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar componentes
        itemComboBox = new JComboBox<>();
        itemComboBox.addItem("AWM 1.500");
        itemComboBox.addItem("P90 5.000,00");
        itemComboBox.addItem("Tysoon R$ 9.000,00");
        itemComboBox.addItem("DESERTE EAGLE R$ 9.500,00");
        itemComboBox.addItem("Fal.792 R$ 10.500,00");
        itemComboBox.addItem("M4A1 R$ 12.000,00");
        itemComboBox.addItem("AK-47 R$ 11.000,00");
        itemComboBox.addItem("PT 100 .40 R$ 8.000,00");

        // Inicializar os botões
        ComprarP90 = new JButton("Comprar");
        CompraButton = new JButton("Comprar");
        comprarButton2 = new JButton("Comprar");
        CoomprarAwm = new JButton("Comprar");
        comprarButton = new JButton("Comprar");
        comprarButton1 = new JButton("Comprar");
        comprarButton3 = new JButton("Comprar");
        comprarButton4 = new JButton("Comprar");
        comprarButton5 = new JButton("Comprar");
        comprarButton6 = new JButton("Comprar");
        finalizarCompra = new JButton("Finalizar Compra");
        totalLabel = new JLabel("Total: R$ 0.00");

        // Definir cores e tamanho dos botões
        Color comprarBgColor = new Color(0xDE0707); // Azul
        Color comprarFgColor = new Color(0, 0, 0); // Branco
        Color finalizarBgColor = new Color(255, 0, 0); // Vermelho
        Color finalizarFgColor = new Color(255, 255, 255); // Branco

        // Configurar as propriedades dos botões
        setButtonProperties(ComprarP90, comprarBgColor, comprarFgColor);
        setButtonProperties(CompraButton, comprarBgColor, comprarFgColor);
        setButtonProperties(comprarButton2, comprarBgColor, comprarFgColor);
        setButtonProperties(CoomprarAwm, comprarBgColor, comprarFgColor);
        setButtonProperties(comprarButton, comprarBgColor, comprarFgColor);
        setButtonProperties(comprarButton1, comprarBgColor, comprarFgColor);
        setButtonProperties(comprarButton3, comprarBgColor, comprarFgColor);
        setButtonProperties(comprarButton4, comprarBgColor, comprarFgColor);
        setButtonProperties(comprarButton5, comprarBgColor, comprarFgColor);
        setButtonProperties(comprarButton6, comprarBgColor, comprarFgColor);
        setButtonProperties(finalizarCompra, finalizarBgColor, finalizarFgColor);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 3, 10, 10)); // Layout flexível para os produtos em três colunas

        panel.add(createProductPanel("AWM 1.500", "/Imagens/AWM.jpeg", CoomprarAwm));
        panel.add(createProductPanel("P90 5.000,00", "/Imagens/P90.jpeg", ComprarP90));
        panel.add(createProductPanel("Tysoon R$ 9.000,00", "/Imagens/Typhoon.PNG", CompraButton));
        panel.add(createProductPanel("DESERTE EAGLE R$ 9.500,00", "/Imagens/DESERT EAGLE.PNG", comprarButton2));
        panel.add(createProductPanel("Fal.792 R$ 10.500,00", "/Imagens/FAL.762.PNG", comprarButton3));
        panel.add(createProductPanel("M4A1 R$ 12.000,00", "/Imagens/M4A1.PNG", comprarButton4));
        panel.add(createProductPanel("AK-47 R$ 11.000,00", "/Imagens/AK 47.PNG", comprarButton5));
        panel.add(createProductPanel("PT 100 .40 R$ 8.000,00", "/Imagens/PT 100 40..PNG", comprarButton6));

        JPanel valorCompra = new JPanel();
        valorCompra.setLayout(new BoxLayout(valorCompra, BoxLayout.Y_AXIS));
        valorCompra.add(totalLabel);
        valorCompra.add(finalizarCompra);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(itemComboBox, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane, BorderLayout.CENTER);
        add(valorCompra, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        // Definir ações dos botões de compra
        ComprarP90.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalValue += 5000.00;
                updateTotal();
            }
        });

        CompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalValue += 9000.00;
                updateTotal();
            }
        });

        comprarButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalValue += 9500.00;
                updateTotal();
            }
        });

        CoomprarAwm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalValue += 1500.00;
                updateTotal();
            }
        });

        comprarButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalValue += 10500.00;
                updateTotal();
            }
        });

        comprarButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalValue += 12000.00;
                updateTotal();
            }
        });

        comprarButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalValue += 11000.00;
                updateTotal();
            }
        });

        comprarButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                totalValue += 8000.00;
                updateTotal();
            }
        });

        finalizarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar a tela de escolha de pagamento
                new EscolhaPagamento().setVisible(true);
                // Redefinir o total da compra
                totalValue = 0.0;
                updateTotal();
            }
        });
    }

    private void setButtonProperties(JButton button, Color bgColor, Color fgColor) {
        button.setBackground(bgColor);
        button.setForeground(fgColor);
        button.setFont(new Font("Arial", Font.PLAIN, 12)); // Diminuir fonte
        button.setPreferredSize(new Dimension(120, 40)); // Definir tamanho preferido menor
    }

    private void updateTotal() {
        totalLabel.setText("Total: R$ " + String.format("%.2f", totalValue));
    }

    private JPanel createProductPanel(String productName, String imagePath, JButton button) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(productName);
        label.setHorizontalAlignment(JLabel.CENTER);

        // Carregar imagem do produto
        URL imageUrl = getClass().getResource(imagePath);
        if (imageUrl != null) {
            ImageIcon icon = new ImageIcon(imageUrl);
            JLabel imageLabel = new JLabel(icon);
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(imageLabel, BorderLayout.CENTER);
        } else {
            JLabel imageLabel = new JLabel("Imagem não encontrada");
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            panel.add(imageLabel, BorderLayout.CENTER);
        }

        panel.add(label, BorderLayout.NORTH);
        panel.add(button, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Venda().setVisible(true);
            }
        });
    }
}
