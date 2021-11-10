package br.com.persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.persistence.Model.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long>{

}
