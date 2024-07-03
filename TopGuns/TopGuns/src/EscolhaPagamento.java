import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EscolhaPagamento extends JFrame {
    private JButton finalizarCompraButton;
    private JRadioButton cartaoCreditoButton;
    private JRadioButton cartaoDebitoButton;
    private JRadioButton boletoButton;
    private JRadioButton pixButton;
    private JButton confirmarButton;
    private JButton cancelarButton;
    private ButtonGroup pagamentoGroup;

    public EscolhaPagamento() {
        setTitle("Escolha Forma de Pagamento");
        initComponents();
        setupLayout();
        setupListeners();

        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        finalizarCompraButton = new JButton("Finalizar Compra");

        cartaoCreditoButton = new JRadioButton("Cartão de Crédito");
        cartaoDebitoButton = new JRadioButton("Cartão de Débito");
        boletoButton = new JRadioButton("Boleto");
        pixButton = new JRadioButton("Pix");

        pagamentoGroup = new ButtonGroup();
        pagamentoGroup.add(cartaoCreditoButton);
        pagamentoGroup.add(cartaoDebitoButton);
        pagamentoGroup.add(boletoButton);
        pagamentoGroup.add(pixButton);

        confirmarButton = new JButton("Confirmar");
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
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(cartaoCreditoButton)
                                .addComponent(cartaoDebitoButton)
                                .addComponent(boletoButton)
                                .addComponent(pixButton)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(confirmarButton)
                                        .addComponent(cancelarButton)))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(cartaoCreditoButton)
                        .addComponent(cartaoDebitoButton)
                        .addComponent(boletoButton)
                        .addComponent(pixButton)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(confirmarButton)
                                .addComponent(cancelarButton))
        );

        add(panel);
    }

    private void setupListeners() {
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cartaoCreditoButton.isSelected()) {
                    JOptionPane.showMessageDialog(EscolhaPagamento.this, "COMPRA EFETUADA COM SUCESSO!!.");
                } else if (cartaoDebitoButton.isSelected()) {
                    JOptionPane.showMessageDialog(EscolhaPagamento.this, "COMPRA EFETUADA COM SUCESSO!!");
                } else if (boletoButton.isSelected()) {
                    JOptionPane.showMessageDialog(EscolhaPagamento.this, "COMPRA EFETUADA COM SUCESSO!!");
                } else if (pixButton.isSelected()) {
                    JOptionPane.showMessageDialog(EscolhaPagamento.this, "COMPRA EFETUADA COM SUCESSO!!");
                } else {
                    JOptionPane.showMessageDialog(EscolhaPagamento.this, "Por favor, selecione uma forma de pagamento.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela de escolha de pagamento
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EscolhaPagamento().setVisible(true);
            }
        });
    }
}