package com.mangementserv.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mangementserv.model.Server;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mangementserv.model.Servers;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/v1/management")
public class ManagementController {

    private final static String CONFIG_FILE_PATH = "src/main/resources/server_details.yml";

    private Servers servers;

    @Bean
    void initializeServers() {
        try {
            servers = new ObjectMapper(new YAMLFactory()).readValue(new File(CONFIG_FILE_PATH), Servers.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @PostMapping("/restart/service")
//    ResponseEntity<?> restartService(@ResponseBody )

    @GetMapping("/servers")
    public void getServers() {
        for (Server server : servers.getServers()) {
            System.out.println(server);
        }

    }
}
