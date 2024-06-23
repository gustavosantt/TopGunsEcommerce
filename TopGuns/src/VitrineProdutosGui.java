import javax.swing.*;
import java.awt.*;

public class VitrineProdutosGui extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel armasPanel;
    private JPanel municoesPanel;
    private JPanel acessoriosPanel;
    private JList<String> armasList;
    private DefaultListModel<String> armasListModel;
    private JLabel imagemLabel;
    private JTabbedPane tabbedPane1;

    public VitrineProdutosGui() {
        setTitle("Produtos Disponíveis");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        // Painel de Armas
        armasPanel = new JPanel(new BorderLayout());
        armasListModel = new DefaultListModel<>();
        armasList = new JList<>(armasListModel);
        imagemLabel = new JLabel();

        // Adicionando itens à lista de armas
        String[] armas = {"Typhoon", "CTT .40", "Fal .762", "M4 A1 .556", "Cal. 12 CBC Pump",
                "Imbel MD1", "PT 92 9mm", "PT 100 .40", "TH 9", "Desert Eagle .50", "P90", "AWM", "AK47"};
        for (String arma : armas) {
            armasListModel.addElement(arma);
        }

        armasList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        armasList.addListSelectionListener(e -> updateImage());

        JScrollPane armasScrollPane = new JScrollPane(armasList);
        armasPanel.add(armasScrollPane, BorderLayout.CENTER);
        armasPanel.add(imagemLabel, BorderLayout.SOUTH);

        tabbedPane.addTab("Armas", armasPanel);

        // Painel de Munições
        municoesPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> municoesListModel = new DefaultListModel<>();
        JList<String> municoesList = new JList<>(municoesListModel);
        JScrollPane municoesScrollPane = new JScrollPane(municoesList);

        String[] municoes = {"Munição 9mm", "Munição .40", "Munição .45", "Munição 5.56", "Cal. 12", "Munição .380", "Munição 7.62"};
        for (String municao : municoes) {
            municoesListModel.addElement(municao);
        }

        municoesPanel.add(municoesScrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Munições", municoesPanel);

        // Painel de Acessórios
        acessoriosPanel = new JPanel(new BorderLayout());
        DefaultListModel<String> acessoriosListModel = new DefaultListModel<>();
        JList<String> acessoriosList = new JList<>(acessoriosListModel);
        JScrollPane acessoriosScrollPane = new JScrollPane(acessoriosList);

        String[] acessorios = {"Mira Holográfica", "Lanterna Tática", "Grip Vertical", "Silenciador", "Coronha Retrátil"};
        for (String acessorio : acessorios) {
            acessoriosListModel.addElement(acessorio);
        }

        acessoriosPanel.add(acessoriosScrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Acessórios", acessoriosPanel);

        add(tabbedPane);
    }

    private void updateImage() {
        String selectedArma = armasList.getSelectedValue();
        if (selectedArma != null) {
            switch (selectedArma) {
                case "P90":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\P90.jpeg")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "Typhoon":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\Typhoon.PNG"));
                case "Fal .762":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\FAL.762.PNG")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "M4 A1 .556":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\M4A1.PNG")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "Cal. 12 CBC Pump":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\CAL 12.PNG")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "Imbel MD1":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\IMBEL MD1.PNG")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "PT 92 9mm":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\PT  92 9M.PNG")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "PT 100 .40":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\PT  100 40..PNG")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "TH 9":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\TH 9.PNG")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "Desert Eagle .50":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\DESERT EAGLE.PNG")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "CTT .40":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\CTT 40.jpeg")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "AK47":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\AK 47.PNG")); // Ajuste o caminho da imagem conforme necessário
                    break;
                case "AWM":
                    imagemLabel.setIcon(new ImageIcon("C:\\Users\\Gustavo Henrique\\Downloads\\LojaTG1-main\\TopGuns\\src\\Imagens\\AWM.jpeg")); // Ajuste o caminho da imagem conforme necessário
                    break;
                    // Adicione mais cases para outras imagens
                default:
                    imagemLabel.setIcon(null);
                    break;
            }
            imagemLabel.setText(selectedArma);
        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VitrineProdutosGui vitrineProdutosGui = new VitrineProdutosGui();
            vitrineProdutosGui.setVisible(true);
        });
    }
}
