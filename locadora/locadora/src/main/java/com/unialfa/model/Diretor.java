package com.unialfa.model;

import java.sql.Date;
import java.time.LocalDate;

public class Diretor {
    private Integer id;
    private String nome;
    private String nacionalidade;
    private Date dataNascimento;
    private Integer premiacao;
    private Date dataInicioCarreira;

    public Diretor( String nome, String nacionalidade, Date dataNascimento, int premiacao, Date dataInicioCarreira) {

        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.premiacao = premiacao;
        this.dataInicioCarreira = dataInicioCarreira;
    }

    public Diretor(int id, String nome, String nacionalidade, Date dataNascimento, int premiacao, Date dataInicioCarreira ) {

        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.dataNascimento = dataNascimento;
        this.premiacao = premiacao;
        this.dataInicioCarreira = dataInicioCarreira;
    }

    public Integer getId() { return id; }
    public void setId(Integer Id) { this.id = id; }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getPremiacao() { return premiacao; }

    public void setPremiacao(Integer premiacao) { this.premiacao = premiacao; }

    public Date getDataInicioCarreira() { return dataInicioCarreira; }

    public void setDataInicioCarreira(Date dataInicioCarreira) {
        this.dataInicioCarreira = dataInicioCarreira;
    }



    @Override
    public String toString() {
        return "Diretor{" +
                "id = " + id
                + " nome = " + nome
                + " nacionalidade = " + nacionalidade
                + " dataNascimento = " + dataNascimento +
                " premiacao = " + premiacao +
                " dataInicioCarreira = " + dataInicioCarreira ;
    }

}
