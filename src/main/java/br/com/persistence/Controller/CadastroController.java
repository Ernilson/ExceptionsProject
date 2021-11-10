package br.com.persistence.Controller;

import java.time.Instant;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.persistence.Model.Cadastro;
import br.com.persistence.ServiceImpl.CadastroServiceImplements;
import br.com.persistence.exceptions.DefaultError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/cadastro")
public class CadastroController {

	@Autowired
	private CadastroServiceImplements csi;

	@GetMapping
	public List<Cadastro> listALL() {
		return csi.listAll();
	}

	@GetMapping(path = {"/{id}" })
	public ResponseEntity findById(@PathVariable long id) {
		try {
			Cadastro cad = csi.buscaPorId(id);
			return ResponseEntity.ok().body(cad);
			
		} catch (Exception e) {			
			DefaultError err = new DefaultError ();
			err.setTimestamp(Instant.now()); err.setStatus(HttpStatus.NOT_FOUND.value());
			err.setError("Resource not found");	err.setMessage(e.getMessage());
			err.setPath("/cadastro/ " + id); log.info("Long mostra ->");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		}
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity savaOrUpdateCadastro(@RequestBody Cadastro c) {
		csi.salveOrUpdate(c);
		return ResponseEntity.ok("OK");
		// throw new NullPointerException();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		try {
			Cadastro cad = csi.buscaPorId(id);
			csi.delete(id);
			
		} catch (Exception e) {		
			DefaultError err = new DefaultError ();
			err.setTimestamp(Instant.now()); err.setStatus(HttpStatus.NOT_FOUND.value());
			err.setError("Resource not found");	err.setMessage(e.getMessage());
			err.setPath("/cadastro/ " + id); log.info("Long mostra ->");
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

		}		
	}
}
