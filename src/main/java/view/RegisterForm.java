package view;

import entity.UsersAccountsEntity;
import entity.UsersEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RegisterForm{
    public JPanel mainPanel;
    private JTextField emailField;
    private JTextField passwordField;
    private JButton registerButton;
    private JButton loginButton;

    private static LoginForm loginForm;
    public static JFrame mainFrame;

    private UsersEntity user;
    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction transaction;

    public RegisterForm() {
        mainFrame = new JFrame();
        mainFrame.setSize(400, 400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setTitle("Rejestracja");
        mainFrame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginForm = new LoginForm();
                mainFrame.setVisible(false);
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                factory = Persistence.createEntityManagerFactory("default");
                manager = factory.createEntityManager();
                transaction = manager.getTransaction();
                try {
                    transaction.begin();
                    UsersEntity user = new UsersEntity();
                    user.setMail(emailField.getText());
                    String pwd = BCrypt.hashpw(passwordField.getText(), BCrypt.gensalt());
                    user.setPassword(pwd);
                    manager.persist(user);
                    transaction.commit();
                    transaction.begin();
                    UsersAccountsEntity account = new UsersAccountsEntity();
                    List<UsersEntity> users = UsersEntity.getUserByEmail(manager, emailField.getText()).getResultList();
                    users.get(0).setUsersAccountsByIdUser(new ArrayList<UsersAccountsEntity>());
                    users.get(0).getUsersAccountsByIdUser().add(account);
                    account.setIdUser(users.get(0).getIdUser());
                    account.setUsersByIdUser(users.get(0));
                    transaction.commit();
                } finally {
                    if(transaction.isActive()) {
                        transaction.rollback();
                    }
                    manager.close();
                    factory.close();
                }
            }
        });
    }
}
