package entity;

import javax.persistence.*;
import java.util.Collection;

@NamedQuery(
        name = "getUserByEmail",
        query = "SELECT u FROM UsersEntity u WHERE u.mail = ?1"
)
@Entity
@Table(name = "users", schema = "homebudget")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "mail")
    private String mail;
    @Basic
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "usersByIdUser", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<UsersAccountsEntity> usersAccountsByIdUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (idUser != that.idUser) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public Collection<UsersAccountsEntity> getUsersAccountsByIdUser() {
        return usersAccountsByIdUser;
    }

    public void setUsersAccountsByIdUser(Collection<UsersAccountsEntity> usersAccountsByIdUser) {
        this.usersAccountsByIdUser = usersAccountsByIdUser;
    }

    public static TypedQuery<UsersEntity> getUserByEmail(EntityManager manager, String email) {
        return manager.createNamedQuery("getUserByEmail", UsersEntity.class).setParameter(1, email);
    }
}
