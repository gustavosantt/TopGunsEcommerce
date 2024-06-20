import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VitrineProdutosGui extends JFrame {
    private ArrayList<Produto> produtos;

    public VitrineProdutosGui() {
        setTitle("Vitrine de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        produtos = new ArrayList<>();
        // Adicionar alguns produtos de exemplo
        produtos.add(new Produto("Revólver Magnum", 599.99, "images/revolver_magnum.jpg"));
        produtos.add(new Produto("Rifle Sniper", 1499.99, "images/rifle_sniper.jpg"));
        produtos.add(new Produto("Pistola Automática", 799.99, "images/pistola_automatica.jpg"));
        produtos.add(new Produto("Ak47", 5000.09, "images/pistola_automatica.jpg"));


        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(0, 3, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (Produto produto : produtos) {
            JPanel card = new JPanel(new BorderLayout());
            JLabel nomeLabel = new JLabel(produto.getNome());
            nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JLabel precoLabel = new JLabel(String.format("R$ %.2f", produto.getPreco()));
            precoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            JLabel imagemLabel = new JLabel();
            imagemLabel.setIcon(produto.getImagem());

            card.add(imagemLabel, BorderLayout.CENTER);
            card.add(nomeLabel, BorderLayout.NORTH);
            card.add(precoLabel, BorderLayout.SOUTH);

            panel.add(card);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new VitrineProdutosGui().setVisible(true);
            }
        });
    }
}
