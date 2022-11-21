package org.senai.prjjava;

import java.util.Optional;

import org.senai.prjjava.Usuario;
import org.senai.prjjava.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    // @ResponseBody significa que a string retornada é a resposta, não um nome de exibição
    // @RequestParam significa que é um parâmetro da solicitação GET ou POST

    @Autowired
    UsuarioRepository uRepository;

    @PostMapping("/")
    public @ResponseBody Integer addUsuario(@RequestBody Usuario objU) {
        uRepository.save(objU);
        return objU.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Usuario> buscarUsuarios() {
        return uRepository.findAll();
    }
    
    // http://localhost:8080/api/usuario/2 - nesse exemlo é usado uma variável de path(caminho)
    @GetMapping("/{id}")
    public @ResponseBody Optional<Usuario> buscarUsuario(@PathVariable Integer id){
        return uRepository.findById(id);
    }

    @PutMapping("/")
    public @ResponseBody Usuario atualizar(@RequestBody Usuario objU){
        uRepository.save(objU);
        return objU;
    }

    @DeleteMapping("/{id}")
    public @ResponseBody String apagar(@PathVariable Integer id){
        uRepository.deleteById(id);
        return "Ok ao apagar!";
    }
