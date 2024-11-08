package br.com.alexandrefreitas.helloworldapisoa.controller;

import br.com.alexandrefreitas.helloworldapisoa.bean.Pessoa;
import br.com.alexandrefreitas.helloworldapisoa.bean.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper; // para converter objetos em JSON

    private Pessoa pessoa;

    @BeforeEach
    void setup() {
        pessoa = new Pessoa();
        pessoa.setNome("Alexandre");
    }

    @Test
    public void testWelcomePost() throws Exception {
        Response response = new Response();
        response.setMensagem("Ola Alexandre");

        mockMvc.perform(post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pessoa)))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    public void testWelcomeNameGet() throws Exception {
        // Primeiro, adiciona a pessoa usando o método POST
        mockMvc.perform(post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pessoa)))
                .andExpect(status().isOk());

        // Testa o método GET para recuperar a saudação pelo nome
        mockMvc.perform(get("/hello/Alexandre"))
                .andExpect(status().isOk())
                .andExpect(content().string("Olaa Alexandre"));
    }

    @Test
    public void testWelcomeNameNotFound() throws Exception {
        mockMvc.perform(get("/hello/Desconhecido"))
                .andExpect(status().isOk())
                .andExpect(content().string("Pessoa não encontrada"));
    }
}
