package com.BancoFoda.BancoFoda.controller.usuario;

<<<<<<< Updated upstream
import com.BancoFoda.BancoFoda.exceptions.ContaNotFoundException;
import com.BancoFoda.BancoFoda.model.domain.conta.Cartao;
import com.BancoFoda.BancoFoda.model.dtos.usuario.ClienteDTO;
import com.BancoFoda.BancoFoda.model.service.conta.CartaoService;
import com.BancoFoda.BancoFoda.model.service.usuario.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
=======
import com.BancoFoda.BancoFoda.model.domain.movimentacao.Transferencia;
import com.BancoFoda.BancoFoda.model.dtos.movimentacao.TransferenciaDTO;
import com.BancoFoda.BancoFoda.model.dtos.usuario.ClienteDTO;
import com.BancoFoda.BancoFoda.model.service.movimentacao.TransferenciaService;
import com.fasterxml.jackson.databind.ObjectMapper;
>>>>>>> Stashed changes
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

<<<<<<< Updated upstream
import java.lang.reflect.Array;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
=======

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
>>>>>>> Stashed changes
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTest
{
    @Autowired
    private MockMvc mockMvc;
<<<<<<< Updated upstream

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private CartaoService cartaoService;
=======
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TransferenciaService transferenciaService;
>>>>>>> Stashed changes

    @Test
    void save( ) throws Exception
    {
<<<<<<< Updated upstream

        ClienteDTO cliente = new ClienteDTO(
            "35767227187",
            "Arthur Heliodoro dos Santos",
            "arthurheliodoro@hotmail.com",
            "2003-07-17",
            1000.0f,
            "1234"
=======
        ClienteDTO cliente = new ClienteDTO(
                "35767227187",
                "Arthur Heliodoro dos Santos",
                "arthurheliodoro@hotmail.com",
                "2003-07-17",
                1000.0f,
                "1234"
>>>>>>> Stashed changes
        );

        MvcResult response = mockMvc.perform(post("/cliente")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cliente)))
<<<<<<< Updated upstream
                        .andExpect(status().isOk()).andReturn();
=======
                .andExpect(status().isOk()).andReturn();
>>>>>>> Stashed changes

        JSONObject clienteJson = new JSONObject(response.getResponse().getContentAsString());
        double creditoTotal = clienteJson.getJSONObject( "conta" ).getDouble( "creditoTotal" );

        assertEquals(600.0, creditoTotal);
    }

    @Test
    void delete() throws Exception
    {
        ClienteDTO cliente = new ClienteDTO(
<<<<<<< Updated upstream
            "35767227187",
            "Arthur Heliodoro dos Santos",
            "arthurheliodoro@hotmail.com",
            "2003-07-17",
            1000.0f,
            "1234"
        );

        MvcResult responseSave = mockMvc.perform( post("/cliente")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cliente)))
                        .andExpect(status().isOk()).andReturn();

        Object[] cartoes = clienteService.getById( "35767227187" ).getConta().getCartoes().toArray();
        Long cartaoCreditoId = ((Cartao) cartoes[1]).getNumero();

        MvcResult responseDelete = mockMvc.perform( MockMvcRequestBuilders.delete("/cliente")
                        .contentType("application/json")
                        .param("cpf", "35767227187"))
                        .andExpect(status().isNoContent()).andReturn();

        ContaNotFoundException exception = assertThrowsExactly( ContaNotFoundException.class, () -> {
            cartaoService.findById( cartaoCreditoId );
        } );

        assertEquals( "Conta #" + cartaoCreditoId + " não encontrado", exception.getMessage() );
=======
                "35767227187",
                "Arthur Heliodoro dos Santos",
                "arthurheliodoro@hotmail.com",
                "2003-07-17",
                1000.0f,
                "1234"
        );

        MvcResult response = mockMvc.perform(post("/cliente")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk()).andReturn();

        JSONObject clienteJson = new JSONObject(response.getResponse().getContentAsString());
        Long contaId = clienteJson.getJSONObject( "conta" ).getLong( "numero" );

        mockMvc.perform( post("/transferencia")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(new TransferenciaDTO( 100.0f, 1L, contaId ))))
                .andExpect(status().isOk());

        mockMvc.perform( MockMvcRequestBuilders.delete("/cliente")
                        .contentType("application/json")
                        .queryParam("cpf", "35767227187"))
                .andExpect(status().isNoContent());

        List< Transferencia > transferencias = transferenciaService.list();

        assertNull( transferencias.get( 0 ).getDestino( ) );
>>>>>>> Stashed changes
    }
}