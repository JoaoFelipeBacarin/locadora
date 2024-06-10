package com.unialfa.dao;

import com.unialfa.model.Diretor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiretorDao {
    private Connection connection;

    public DiretorDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/javadb?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void inserir(Diretor diretor) throws SQLException {
        String sql = "INSERT INTO diretor (nome, nacionalidade, data_nascimento, premiacao, data_inicio_carreira) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, diretor.getNome());
        ps.setString(2, diretor.getNacionalidade());
        ps.setDate(3, diretor.getDataNascimento());
        ps.setInt(4, diretor.getPremiacao());
        ps.setDate(5, diretor.getDataInicioCarreira());

        ps.execute();
    }


    public void atualizar(Diretor diretor) throws SQLException {
        String sql = "UPDATE diretor SET id = ?, nome = ?, nacionalidade = ?, data_nascimento = ?, premiacao = ? where data_inicio_carreira = ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1, diretor.getId());
        ps.setString(2, diretor.getNome());
        ps.setString(3, diretor.getNacionalidade());
        ps.setDate(4, diretor.getDataNascimento());
        ps.setInt(5, diretor.getPremiacao());
        ps.setDate(6, diretor.getDataInicioCarreira());
        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM diretor WHERE diretor.id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public Diretor consultarPorId(int id) throws SQLException {
        Diretor diretor = null;

        String sql = "select from Diretor where diretor.id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            diretor = new Diretor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("nacionalidade"),
                    rs.getDate("data_nascimento"),
                    rs.getInt("premiacao"),
                    rs.getDate("data_inicio_carreira")
            );
        }
        rs.close();

        return diretor;
    }

    public List<Diretor> listarContenhaNome(String nome) throws SQLException {
        List<Diretor> diretores = new ArrayList<>();

        String sql = "SELECT * FROM Diretor WHERE nome LIKE ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + nome + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Diretor diretor = new Diretor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("nacionalidade"),
                    rs.getDate("data_nascimento"),
                    rs.getInt("premiacao"),
                    rs.getDate("data_inicio_carreira")
            );
            diretores.add(diretor);
        }
        rs.close();

        return diretores;
    }

    public List<Diretor> listarTodos() throws SQLException {
        List<Diretor> diretores = new ArrayList<Diretor>();

        ResultSet rs = connection.prepareStatement("SELECT * FROM diretor").executeQuery();
        while (rs.next()) {
            diretores.add(new Diretor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("nacionalidade"),
                    rs.getDate("data_nascimento"),
                    rs.getInt("premiacao"),
                    rs.getDate("data_inicio_carreira")
            ));
        }
        rs.close();
        return diretores;
    }
}
