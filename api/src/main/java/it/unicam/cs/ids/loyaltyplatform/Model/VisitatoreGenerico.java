package it.unicam.cs.ids.loyaltyplatform.Model;

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

}
