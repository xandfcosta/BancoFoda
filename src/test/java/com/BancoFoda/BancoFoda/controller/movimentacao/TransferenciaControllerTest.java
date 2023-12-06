package com.BancoFoda.BancoFoda.controller.movimentacao;

import com.BancoFoda.BancoFoda.model.domain.conta.Conta;
import com.BancoFoda.BancoFoda.model.dtos.movimentacao.TransferenciaDTO;
import com.BancoFoda.BancoFoda.model.service.movimentacao.TransferenciaService;
import com.BancoFoda.BancoFoda.model.service.conta.ContaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransferenciaControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TransferenciaService transferenciaService;
    @Autowired
    private ContaService contaService;

    @Test
    void save( ) throws Exception
    {
        float valor = 100.0f;
        Long origem = 1L;
        Long destino = 2L;

        float saldoOrigemAntes = contaService.findById( origem ).getSaldo();
        float saldoDestinoAntes = contaService.findById( destino ).getSaldo();

        TransferenciaDTO transferencia = new TransferenciaDTO( valor, origem, destino );

        MvcResult response = mockMvc.perform(post("/transferencia")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(transferencia)))
                        .andExpect(status().isOk()).andReturn();

        float saldoOrigemDepois = contaService.findById( origem ).getSaldo();
        float saldoDestinoDepois = contaService.findById( destino ).getSaldo();

        float[] diferencasSaldos = new float[]{saldoOrigemDepois - saldoOrigemAntes, saldoDestinoDepois - saldoDestinoAntes};
        float[] assertDiferencaSaldos = new float[]{-100.0f, 100.0f};

        assertArrayEquals( assertDiferencaSaldos, diferencasSaldos );
    }
}