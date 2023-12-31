package pl.yuro.zupki.model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "zupki")
public class Zupka {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Marka")
    private String marka;

    @Column(name = "Smak")
    private String smak;

    @Column(name = "Pochodzenie")
    private String pochodzenie;

    @Column(name = "Waga")
    private int waga;

    @Column(name = "Cena_hurtowa")
    private float cena_hurtowa;

    public Zupka() {

    }

    public Zupka(String marka, String smak, String pochodzenie, int waga, float cena_hurtowa) {
        this.marka = marka;
        this.smak = smak;
        this.pochodzenie = pochodzenie;
        this.waga = waga;
        this.cena_hurtowa = cena_hurtowa;
    }

    public long getId() {
        return id;
    }

    public String getMarka() {
        if (String.valueOf(marka) == "null") {
            return "";
        } return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getSmak() {
            if (String.valueOf(smak) == "null") {
                return "";
            } return smak;

    }

    public void setSmak(String smak) {
        this.smak = smak;
    }

    public String getPochodzenie() {
        if (String.valueOf(pochodzenie) == "null") {
            return "";
        } return this.pochodzenie;
    }

    public void setPochodzenie(String pochodzenie) {
        this.pochodzenie = pochodzenie;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    public float getCena_hurtowa() {
        return cena_hurtowa;
    }

    public void setCena_hurtowa(float cena_hurtowa) {
        this.cena_hurtowa = cena_hurtowa;
    }
}

