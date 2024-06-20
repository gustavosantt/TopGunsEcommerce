import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel panel1;
    private JLabel jlLogin;
    private JLabel jlSenha;
    private JTextField jtfLogin;
    private JPasswordField jtfSenha;
    private JButton jbLogin;
    private JButton jbCancel;
    private JLabel imageLabel;

    public Login() {
        setTitle("Login");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        initComponents();
        setupListeners();
        loadImage();
    }

    private void initComponents() {
        panel1 = new JPanel(new GridBagLayout());
        setContentPane(panel1);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5); // Margens entre os componentes

        imageLabel = new JLabel();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel1.add(imageLabel, constraints);

        jlLogin = new JLabel("Login:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;
        panel1.add(jlLogin, constraints);

        jtfLogin = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(jtfLogin, constraints);

        jlSenha = new JLabel("Senha:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.NONE;
        panel1.add(jlSenha, constraints);

        jtfSenha = new JPasswordField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(jtfSenha, constraints);

        jbLogin = new JButton("Login");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;
        panel1.add(jbLogin, constraints);

        jbCancel = new JButton("Cancel");
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.CENTER;
        panel1.add(jbCancel, constraints);
    }

    private void setupListeners() {
        jbLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = jtfLogin.getText();
                String password = new String(jtfSenha.getPassword());

                if (validateLogin(username, password)) {
                    JOptionPane.showMessageDialog(Login.this, "Login Successful!");
                    openMainManu();
                } else {
                    JOptionPane.showMessageDialog(Login.this, "Invalid Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jbCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  // Fecha a aplicação
            }
        });
    }

    private boolean validateLogin(String username, String password) {
        return "admin".equals(username) && "123".equals(password);
    }

    private void openMainManu() {
        MainManu mainMenu = new MainManu();
        mainMenu.setVisible(true);
        this.dispose();
    }

    // Carrega a imagem do arquivo
    private void loadImage() {
        ImageIcon icon = new ImageIcon("logo.png"); // Substitua "logo.png" pelo nome do seu arquivo de imagem
        Image img = icon.getImage().getScaledInstance(280, 100, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(img));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}


