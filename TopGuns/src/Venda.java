import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Venda extends JFrame {

    private JComboBox<String> comboBox1;
    private JScrollBar scrollBar1;
    private JButton ComprarP90;
    private JButton CompraButton;
    private JPanel valorCompra;
    private JButton comprarButton2;
    private JButton CoomprarAwm;
    private JButton comprarButton;
    private JButton comprarButton1;
    private JButton comprarButton3;
    private JButton finalizarCompra;
    private JLabel totalLabel;
    private double totalValue = 0.0;

    public Venda() {
        setTitle("Carrinho de Compras");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicializar componentes
        comboBox1 = new JComboBox<>();
        scrollBar1 = new JScrollBar();
        ComprarP90 = new JButton("Comprar");
        CompraButton = new JButton("Comprar");
        comprarButton2 = new JButton("Comprar");
        CoomprarAwm = new JButton("Comprar");
        comprarButton = new JButton("Comprar");
        comprarButton1 = new JButton("Comprar");
        finalizarCompra = new JButton("Finalizar Compra");
        totalLabel = new JLabel("Total: R$ 0.00");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(createProductPanel("AWM 1.500", "C:\\Users\\Gustavo Henrique\\Downloads\\TopGuns\\TopGuns\\src\\Imagens\\AWM.jpeg", CoomprarAwm));
        panel.add(createProductPanel("P90 5.000,00", "C:\\Users\\Gustavo Henrique\\Downloads\\TopGuns\\TopGuns\\src\\Imagens\\P90.jpeg", ComprarP90));
        panel.add(createProductPanel("Tysoon R$ 9.000,00", "C:\\Users\\Gustavo Henrique\\Downloads\\TopGuns\\TopGuns\\src\\Imagens\\Typhoon.PNG", CompraButton));
        panel.add(createProductPanel("DESERTE EAGLE R$ 9.500,00", "C:\\Users\\Gustavo Henrique\\Downloads\\TopGuns\\TopGuns\\src\\Imagens\\DESERT EAGLE.PNG", comprarButton2));

        valorCompra = new JPanel();
        valorCompra.setLayout(new BoxLayout(valorCompra, BoxLayout.Y_AXIS));
        valorCompra.add(totalLabel);
        valorCompra.add(finalizarCompra);

        add(panel, BorderLayout.CENTER);
        add(valorCompra, BorderLayout.SOUTH);

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

    private void updateTotal() {
        totalLabel.setText("Total: R$ " + String.format("%.2f", totalValue));
    }

    private JPanel createProductPanel(String productName, String imagePath, JButton button) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(productName);
        label.setHorizontalAlignment(JLabel.CENTER);

        // Carregar imagem do produto
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        panel.add(imageLabel, BorderLayout.CENTER);
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