# SpringBoot-JPA-Persistencia-REST
Persistencia usando Spring Boot e JPA com REST

Usando a persistencia do Spring Boot com comunicação via REST Service

Para utilizar esse projeto é necessário ter um banco de dados MySQL Instalado
sendo este configurado com um banco de dados vázio com o nome persistencia-spring ou se preferir execute o seguinte comando:
CREATE SCHEMA IF NOT EXISTS `persistencia-spring` DEFAULT CHARACTER SET latin1;

feito isso é só usar as requisiçoes abaixo para fazer os testes.

# Busca pessoa estatica para testes apenas! (GET REQUEST)
http://localhost:8080/usuarios/buscar-pessoa-estatica

# Lista usuários cadastrados! (GET REQUEST)
http://localhost:8080/usuarios

# Lista usuários cadastrados por ID (GET REQUEST)
http://localhost:8080/usuarios/1

# Lista apenas usuários sem preenchimento no campo endereço! (GET REQUEST)
http://localhost:8080/usuarios/sem-endereco

# Lista usuários com iniciais do primeiro nome começando com! (GET REQUEST)
http://localhost:8080/usuarios/por-nome-comecando-com

# Lista usuários pelo nome compléto! (GET REQUEST)
http://localhost:8080/usuarios/por-nome-completo

Header param = nomeCompleto
Inserir valor válido para o nomeCompleto.

O BD por default tem os seguintes valores:
Toshie Moto
Samuel F Duarte

# Salvar ou atualiza um usuário! (POST REQUEST)
http://localhost:8080/usuarios

# Remover usuário da base de dados!
http://localhost:8080/usuarios/3




