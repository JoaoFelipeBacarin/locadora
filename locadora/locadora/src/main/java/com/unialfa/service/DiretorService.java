package com.unialfa.service;

import com.unialfa.dao.DiretorDao;
import com.unialfa.model.Diretor;

import java.util.Collections;
import java.util.List;

public class DiretorService {

    public void salvar(Diretor diretor) {
        try {
            DiretorDao dao = new DiretorDao();
            if (diretor.getId() == null) {
                dao.inserir(diretor);
            }else {
                dao.atualizar(diretor);
            }
        }catch (Exception e){
            System.out.println("Erro ao salvar diretor: " + e.getMessage());
        }
    }

    public void deletar(int idDiretor){
        try {
            DiretorDao dao = new DiretorDao();
            dao.deletar(idDiretor);
        }catch (Exception e){
            System.out.println("Erro ao deletar diretor: " + e.getMessage());
        }
    }

    public List<Diretor> listarDiretores() {
        try {
            var dao = new DiretorDao();
            return dao.listarTodos();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
