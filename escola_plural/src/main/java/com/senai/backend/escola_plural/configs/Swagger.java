package com.senai.backend.escola_plural.configs;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@Configuration
@OpenAPIDefinition(
info = @Info(
title = "Escola Plural",
version = "1.0",
description = "Gabrielle Gomes 3 Info A"
)
)

public class Swagger {
}

