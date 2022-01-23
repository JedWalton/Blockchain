import java.io.*;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    private String encrypt(String password) {
        char[] charPassword = password.toCharArray();
        StringBuilder passwordEncrypted = new StringBuilder();
        for (int i = 0; i < charPassword.length; i++) {
            charPassword[i] = (char) (charPassword[i] + 1);
            passwordEncrypted.append(charPassword[i]);
        }
        return passwordEncrypted.toString();
    }

    private String decrypt(String password) {
        char[] charPassword = password.toCharArray();
        StringBuilder passwordDecrypted = new StringBuilder();
        for (int i = 0; i < charPassword.length; i++) {
            charPassword[i] = (char) (charPassword[i] - 1);
            passwordDecrypted.append(charPassword[i]);
        }
        return passwordDecrypted.toString();
    }

    // implement readObject and writeObject properly
    private void writeObject(ObjectOutputStream oos) throws Exception {
        oos.defaultWriteObject();
        String encryptPassword = encrypt(password);
        oos.writeObject(encryptPassword);
    }

    private void readObject(ObjectInputStream ois) throws Exception {
        ois.defaultReadObject();
        this.password = decrypt((String) ois.readObject());
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}