package com.bckndjsb.prj0001;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Prj0001Application {

	public static void main(String[] args) {
		SpringApplication.run(Prj0001Application.class, args);
	}
	
	//aqui fiz uma melhoria no codigo permitindo que rode um servidor h2 e disponibilizar a conexão 
	//atraves de um servidor na porta 9092 para usar com outros programas tal como DBeaver 
	//para esse projeto usamos o mem:testdb como database 
    @Bean(initMethod = "start", destroyMethod = "stop")
    Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
