/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Aluno;

/**
 *
 * @author r_pab
 */
public class AlunoDAO {

    static Connection c;

    public static void insereAluno(Aluno aluno) {
        c = Conectar.getConnection();

        String sql = "INSERT INTO aluno(nome,email,tel,rua,numrua,sexo,atv) "
                + "VALUES (?,?,?,?,?,?,?);";
        try {
            PreparedStatement ppstt = c.prepareStatement(sql);
            ppstt.setString(1, aluno.getNome());
            ppstt.setString(2, aluno.getEmail());
            ppstt.setLong(3, aluno.getTel());
            ppstt.setString(4, aluno.getRua());
            ppstt.setString(5, aluno.getNumRua());
            ppstt.setString(6, aluno.getSexo());
            ppstt.setString(7, aluno.getAtv());
            ppstt.execute();
            ppstt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void fecharConexao(){
        try{
        c.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }

}
