package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(
        name = "getAccountByIdUser",
        query = "SELECT u FROM UsersAccountsEntity u WHERE u.idUser = ?1"
)
@Entity
@Table(name = "users_accounts", schema = "homebudget")
public class UsersAccountsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_account")
    private int idAccount;
    @Basic
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "groceries")
    private double groceries;
    @Basic
    @Column(name = "leisure")
    private double leisure;
    @Basic
    @Column(name = "transport")
    private double transport;
    @Basic
    @Column(name = "health")
    private double health;
    @Basic
    @Column(name = "shopping")
    private double shopping;
    @Basic
    @Column(name = "bills")
    private double bills;
    @Basic
    @Column(name = "expenses")
    private double expenses;
    @Basic
    @Column(name = "income")
    private double income;
    @Basic
    @Column(name = "balance")
    private double balance;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false, insertable = false, updatable = false)
    private UsersEntity usersByIdUser;

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getGroceries() {
        return groceries;
    }

    public void setGroceries(double groceries) {
        this.groceries = groceries;
    }

    public double getLeisure() {
        return leisure;
    }

    public void setLeisure(double leisure) {
        this.leisure = leisure;
    }

    public double getTransport() {
        return transport;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getShopping() {
        return shopping;
    }

    public void setShopping(double shopping) {
        this.shopping = shopping;
    }

    public double getBills() {
        return bills;
    }

    public void setBills(double bills) {
        this.bills = bills;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance() {
        this.balance = this.income - this.expenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersAccountsEntity that = (UsersAccountsEntity) o;

        if (idAccount != that.idAccount) return false;
        if (idUser != that.idUser) return false;
        if (Double.compare(that.groceries, groceries) != 0) return false;
        if (Double.compare(that.leisure, leisure) != 0) return false;
        if (Double.compare(that.transport, transport) != 0) return false;
        if (Double.compare(that.health, health) != 0) return false;
        if (Double.compare(that.shopping, shopping) != 0) return false;
        if (Double.compare(that.bills, bills) != 0) return false;
        if (Double.compare(that.expenses, expenses) != 0) return false;
        if (Double.compare(that.income, income) != 0) return false;
        if (Double.compare(that.balance, balance) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idAccount;
        result = 31 * result + idUser;
        temp = Double.doubleToLongBits(groceries);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(leisure);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(transport);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(health);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(shopping);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(bills);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(expenses);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(income);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public UsersEntity getUsersByIdUser() {
        return usersByIdUser;
    }

    public void setUsersByIdUser(UsersEntity usersByIdUser) {
        this.usersByIdUser = usersByIdUser;
    }

    public void addGroceries(double x) {
        this.groceries += x;
        this.expenses += x;
    }

    public void addLeisure(double x) {
        this.leisure += x;
        this.expenses += x;
    }

    public void addTransport(double x) {
        this.transport += x;
        this.expenses += x;
    }

    public void addHealth(double x) {
        this.health += x;
        this.expenses += x;
    }

    public void addShopping(double x) {
        this.shopping += x;
        this.expenses += x;
    }

    public void addBills(double x) {
        this.bills += x;
        this.expenses += x;
    }

    public void addIncome(double x) {
        this.income += x;
    }

    public void subtractGroceries(double x) {
        this.groceries -= x;
        this.expenses -= x;
    }

    public void subtractLeisure(double x) {
        this.leisure -= x;
        this.expenses -= x;
    }

    public void subtractTransport(double x) {
        this.transport -= x;
        this.expenses -= x;
    }

    public void subtractHealth(double x) {
        this.health -= x;
        this.expenses -= x;
    }

    public void subtractShopping(double x) {
        this.shopping -= x;
        this.expenses -= x;
    }

    public void subtractBills(double x) {
        this.bills -= x;
        this.expenses -= x;
    }

    public void subtractIncome(double x) {
        this.income -= x;
    }

    public int getMax() {
        List<Double> listExpenses = new ArrayList<Double>();
        listExpenses.add(this.groceries);
        listExpenses.add(this.leisure);
        listExpenses.add(this.transport);
        listExpenses.add(this.health);
        listExpenses.add(this.shopping);
        listExpenses.add(this.bills);

        int max = 0;
        for(int i = 1; i < listExpenses.size(); i++) {
            if(listExpenses.get(max) < listExpenses.get(i))
                max = i;
        }
        return max;
    }

    public static TypedQuery<UsersAccountsEntity> getAccountByIdUser(EntityManager manager, int id) {
        return manager.createNamedQuery("getAccountByIdUser", UsersAccountsEntity.class).setParameter(1, id);
    }
}
