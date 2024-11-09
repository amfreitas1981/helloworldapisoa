package br.com.alexandrefreitas.helloworldapisoa.controller;

import br.com.alexandrefreitas.helloworldapisoa.bean.Pessoa;
import br.com.alexandrefreitas.helloworldapisoa.bean.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

    private final Map<String, Pessoa> pessoas = new ConcurrentHashMap<>();

    // Método POST para salvar a pessoa
    @PostMapping
    public @ResponseBody Response welcome(@RequestBody Pessoa pessoa) {
        // Salva a pessoa no mapa usando o nome como chave
        pessoas.put(pessoa.getNome(), pessoa);

        // Cria e retorna a resposta
        Response response = new Response();
        response.setMensagem("Ola " + pessoa.getNome());
        return response;
    }

    // Método GET para recuperar a pessoa pelo nome
    @GetMapping("/{nome}")
    public String welcomeName(@PathVariable String nome) {
        // Busca a pessoa pelo nome no mapa
        Pessoa pessoa = pessoas.get(nome);

        // Retorna a saudação ou uma mensagem se a pessoa não foi encontrada
        if (pessoa != null) {
            return "Olaa " + pessoa.getNome();
        }
        return "Pessoa não encontrada";
    }
}
