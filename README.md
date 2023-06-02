# Sistema de Autenticação de Usuário

Este é um exemplo de código Java para um sistema de autenticação de usuário, utilizando um banco de dados MySQL.

## Descrição

O sistema permite que os usuários façam login fornecendo um login e senha. As informações são verificadas no banco de dados para autenticação. Se as credenciais forem válidas, o usuário é autenticado com sucesso.

O código apresenta um exemplo de integração com banco de dados MySQL, utilizando a API JDBC para realizar consultas e atualizações.

## Requisitos

- Java Development Kit (JDK) 8 ou superior
- MySQL Server

## Configuração do Banco de Dados

1. Certifique-se de ter o MySQL Server instalado e em execução.

2. Crie um novo banco de dados no MySQL:

   ```sql
   CREATE DATABASE nome_do_banco_de_dados; ```

3. Crie a `tabela` info no banco de dados, com as colunas `nomeUsuario` e `senhaUsuario`:

    ```sql
    USE nome_do_banco_de_dados;

    CREATE TABLE info (
        id INT PRIMARY KEY AUTO_INCREMENT,
        nomeUsuario VARCHAR(50) NOT NULL,
        senhaUsuario VARCHAR(50) NOT NULL
    ); ```

4. Configure as informações de conexão ao banco de dados no arquivo `ConexaoBd.java`, substituindo os valores das variáveis `url`, `user` e `password` de acordo com a sua configuração do MySQL.

## Executando o Sistema

1. Compile o código Java:

```bash
javac -d bin src/**/*.java
```

2. Execute o programa:

```bash
java -cp bin view.Aplicacao
```

3. O programa será iniciado e exibirá uma janela para que o usuário digite o login e a senha.

4. Insira as informações solicitadas e clique no botão de login.

5.  O programa realizará a autenticação consultando o banco de dados e exibirá uma mensagem indicando se o login foi realizado com sucesso ou se as credenciais são inválidas.

## Contribuição
Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença
Este projeto está licenciado sob a MIT License.

```javascript
Certifique-se de substituir `nome_do_banco_de_dados` pelo nome real do seu banco de dados e personalizar outras seções de acordo com as especificidades do seu código e do seu projeto. 
```




