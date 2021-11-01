package br.com.alura.agenda.model;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
public class Aluno implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id = 0;
    private String nome;
    private String telefoneFixo;
    private String telefoneCelular;
    private String email;
    private Calendar data = Calendar.getInstance();

    public void setData(Calendar calendar) {
        this.data = calendar;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public String getEmail() {
        return email;
    }

    @NonNull
    @Override
    public String toString() {
        return nome + " - " + telefoneFixo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean temIdValido() {
        return id > 0;
    }

    public Calendar getData() {
       return data;
    }

    public String getMoment()
    {
        String format = new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
        return format;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
}
