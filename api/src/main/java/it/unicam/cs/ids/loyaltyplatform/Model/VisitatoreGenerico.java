package it.unicam.cs.ids.loyaltyplatform.Model;

import java.util.Objects;

public class VisitatoreGenerico {
    private int id;
    private String Nome;

    private String cognome;
    private String indirizzo;

    private String email;

    private int telefono;

    private String username;
    private String password;
    public VisitatoreGenerico(String nome, String cognome,  String indirizzo, String email, String username,  String password, int telefono) {
        this.id=randomInt();
        this.Nome = nome;
        this.cognome=cognome;
        this.indirizzo = indirizzo;
        this.email=email;
        this.username=username;
        this.password=password;
        this.telefono=telefono;
    }
    public VisitatoreGenerico(int id, String nome, String cognome, String indirizzo, String email, String username, String password, int telefono) {
        this.id = id;
        this.Nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.email = email;
        this.username = username;
        this.password = password;
        this.telefono = telefono;
    }
    private int randomInt() {
        double doubleRandom=0;

        doubleRandom=Math.random()*4000;

        int intRandom=(int ) doubleRandom;
        return intRandom;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getEmail() {
        return email;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitatoreGenerico that = (VisitatoreGenerico) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username);
    }

    @Override
    public String toString() {
        return "VisitatoreGenerico: " +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '.';
    }
}
