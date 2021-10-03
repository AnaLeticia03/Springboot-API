# API-Springboot
API de uma livraria utilizando springboot para apresentar como projeto da matéria de LTP do terceiro bimestre, a branch de código é a branch master

# Informações importantes da API:

Banco h2: (**path =**  ```/h2 ```) 
        **url:** ```jdbc:h2:mem::livraria ```
        ** username:** ```root```
        **password:** ``` ```
        **driverClassName:** ```org.h2.Driver```
        
|      Verbo HTTP  |  Caminho (path)    |                                           Descrição                                     |
| -----------------| -------------------|---------------------------------------------------------------------------------------- |
|  GET             |  /livros           |  Retorna um objeto JSON com todos os livros                                             |
|  GET             | /livros/{id}       |  Retorna um objeto JSON com o livro de id especifícado na URL                           |
|  POST            | /livros/criar      |  Insere um livro no banco de dados seguindo a ordem: ```nome, gênero, autor, sinopse``` |
|  PUT             | /livros/update/{id}|  Atualiza as informações de um livros com o id especificado                             |
|  DELETE          | /delete/{id}       |  Deleta o livro de id especificado na URL                                               |

### Exemplo de objeto para testar o POST

{
 "nome": "nome genérico",
 "genero": "genérico",
  "autor": "Autor genérico",
  "sinopse": "Lorem Ipsum Sit Dolor amet"
}
