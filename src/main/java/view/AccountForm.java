package view;

import entity.UsersAccountsEntity;
import entity.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.System.exit;

public class AccountForm {
    private JTextField balanceField;
    private JButton plusGroceriesButton;
    private JButton plusLeisureButton;
    private JButton plusTransportButton;
    private JButton plusIncomeButton;
    private JButton plusHealthButton;
    private JButton plusShoppingButton;
    private JButton plusBillsButton;
    private JButton minusGroceriesButton;
    private JButton minusLeisureButton;
    private JButton minusTransportButton;
    private JButton minusHealthButton;
    private JButton minusShoppingButton;
    private JButton minusBillsButton;
    private JButton minusIncomeButton;
    private JButton maxButton;
    private JButton saveButton;
    private JTextField amountField;
    private JPanel mainPanel;
    private JButton percentExpenses;

    private UsersAccountsEntity account;
    private UsersEntity user;
    private EntityManagerFactory factory;
    private EntityManager manager;
    private EntityTransaction transaction;
    public static JFrame mainFrame;

    private static AccountForm form;
    private static LoginForm loginForm;


    public AccountForm(UsersEntity user) {
        mainFrame = new JFrame();

        factory = Persistence.createEntityManagerFactory("default");
        manager = factory.createEntityManager();
        transaction = manager.getTransaction();
        transaction.begin();
        account = UsersAccountsEntity.getAccountByIdUser(manager, user.getIdUser()).getResultList().get(0);
        balanceField.setText(Double.toString(account.getBalance()));

        mainFrame.setSize(600, 600);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(mainPanel);
        mainFrame.setTitle("Budzet domowy");
        mainFrame.setVisible(true);


        plusGroceriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.addGroceries(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        minusGroceriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.subtractGroceries(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        plusLeisureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.addLeisure(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        minusLeisureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.subtractLeisure(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        plusTransportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.addTransport(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        minusTransportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.subtractTransport(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        plusHealthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.addHealth(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        minusHealthButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.subtractHealth(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        plusShoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.addShopping(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        minusShoppingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.subtractShopping(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        plusBillsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.addBills(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        minusBillsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.subtractBills(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        plusIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.addIncome(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        minusIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!transaction.isActive()) {
                    transaction.begin();
                }
                account.subtractIncome(Double.parseDouble(amountField.getText()));
                account.setBalance();
                balanceField.setText(Double.toString(account.getBalance()));
            }
        });

        maxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int max = account.getMax();
                switch(max) {
                    case 0: JOptionPane.showMessageDialog(null, "Jedzenie: " + account.getGroceries());; break;
                    case 1: JOptionPane.showMessageDialog(null, "Rozrywka: " + account.getLeisure()); break;
                    case 2: JOptionPane.showMessageDialog(null, "Transport: " + account.getTransport()); break;
                    case 3: JOptionPane.showMessageDialog(null, "Zdrowie: " + account.getHealth()); break;
                    case 4: JOptionPane.showMessageDialog(null, "Zakupy: " + account.getShopping()); break;
                    case 5: JOptionPane.showMessageDialog(null, "Rachunki: " + account.getBills()); break;
                }
            }
        });

        percentExpenses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double groceries_ = (account.getGroceries()/account.getExpenses()) * 100;
                double leisure_ = (account.getLeisure()/account.getExpenses()) * 100;
                double transport_ = (account.getTransport()/account.getExpenses()) * 100;
                double health_ = (account.getHealth()/account.getExpenses()) * 100;
                double shopping_ = (account.getShopping()/account.getExpenses()) * 100;
                double bills_ = (account.getBills()/account.getExpenses()) * 100;
                JOptionPane.showMessageDialog(null, "Jedzenie: " + account.getGroceries() + "(" + String.format("%.2f", groceries_) + "%" + ")");
                JOptionPane.showMessageDialog(null, "Rozrywka: " + account.getLeisure() + "(" + String.format("%.2f", leisure_) + "%" + ")");
                JOptionPane.showMessageDialog(null, "Transport: " + account.getTransport() + "(" + String.format("%.2f", transport_) + "%" + ")");
                JOptionPane.showMessageDialog(null, "Zdrowie: " + account.getHealth() + "(" + String.format("%.2f", health_) + "%" + ")");
                JOptionPane.showMessageDialog(null, "Zakupy: " + account.getShopping() + "(" + String.format("%.2f", shopping_) + "%" + ")");
                JOptionPane.showMessageDialog(null, "Rachunki: " + account.getBills() + "(" + String.format("%.2f", bills_) + "%" + ")");
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    transaction.commit();
                } finally {
                    if(transaction.isActive()) {
                        transaction.rollback();
                    }
                }
            }
        });
    }
}
