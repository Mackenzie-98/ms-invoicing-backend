//package com.ceiba.cliente.controlador;
//
//import com.ceiba.ApplicationMock;
//import com.ceiba.cliente.modelo.entities.Cliente;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ControladorCliente.class)
//@ContextConfiguration(classes = ApplicationMock.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//class ControladorClienteTest {
//
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private MockMvc mocMvc;
//
//    public static final String JSON_RESPONSE = "{\n" +
//            "  \"identificacion\": \"string\",\n" +
//            "  \"nombre\": \"string\",\n" +
//            "  \"apellido\": \"string\"\n" +
//            "}";
//
//
//    @Test
//    void deberiaCrearUnCliente() throws Exception{
//        // arrange
//        Cliente cliente =Cliente.builder()
//                .identificacion("123")
//                .nombre("Edinsson")
//                .apellido("Melo")
//                .build();
//
//        // act - assert
//        mocMvc.perform(post("/clientes/registrar")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(cliente)))
//                .andExpect(status().isOk())
//                .andExpect(content().json(JSON_RESPONSE));
//    }
//
//}