package view;

import entity.UsersEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LoginForm{
    public JPanel mainPanel;
    private JTextField emailField;
    private JTextField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private static RegisterForm registerForm;
    private static AccountForm accountForm;
    public static JFrame mainFrame;
    private UsersEntity user;
    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction transaction;

    public LoginForm() {
        mainFrame = new JFrame();
        mainFrame.setSize(400, 400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setTitle("Logowanie");
        mainFrame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factory = Persistence.createEntityManagerFactory("default");
                manager = factory.createEntityManager();
                List<UsersEntity> users = UsersEntity.getUserByEmail(manager, emailField.getText()).getResultList();
                if(users.size() == 0) {
                    JOptionPane.showMessageDialog(null, "Nie ma takiego uzytkownika!");
                } else{
                    String pwd = users.get(0).getPassword();
                    if(BCrypt.checkpw(passwordField.getText(), pwd)) {
                        accountForm = new AccountForm(users.get(0));
                        mainFrame.setVisible(false);
                    } else{
                        JOptionPane.showMessageDialog(null, "Zle haslo!");
                    }
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerForm = new RegisterForm();
                mainFrame.setVisible(false);
            }
        });
    }
}
