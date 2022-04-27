//package com.ceiba.cliente.controlador;
//
//import com.ceiba.ApplicationMock;
//import com.ceiba.cliente.modelo.entities.Cliente;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.BeforeEach;
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
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(controllers = ControladorCliente.class)
//@ContextConfiguration(classes = ApplicationMock.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//@ExtendWith(SpringExtension.class)
//class ControladorClienteTest {
//
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    private MockMvc mocMvc;
//
//
//    @BeforeEach
//    void setup(){
//        objectMapper = new ObjectMapper();
////        this.mocMvc = MockMvcBuilders.standaloneSetup(controladorCliente).build();
//    }
//
//    public String BODY = "{\n" +
//            "  \"identificacion\": \"123\",\n" +
//            "  \"nombre\": \"Edinsson\",\n" +
//            "  \"apellido\": \"Melo\"\n" +
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
//                .andDo(print())
//                .andExpect(status().is2xxSuccessful());
////                .andExpect(content().json(BODY))
//    }
//
//    @Test
//    void deberiaEliminarUnCliente() throws Exception{
//        // arrange
//        String id = "123";
//        // act - assert
//        mocMvc.perform(delete("/clientes/{id}",id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//
//        mocMvc.perform(get("/clientes/listar")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(0)));
//    }
//
//}