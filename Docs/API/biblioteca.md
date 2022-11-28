# SCOA API

# Modulo Biblioteca

## Obra

|rota                                                               |funções |argumentos de url                                |argumento de corpo|entidades                         |descrição                           |
|-------------------------------------------------------------------|--------|-------------------------------------------------|------------------|----------------------------------|------------------------------------|
|`/biblioteca/obra/{id}     `                                       |`GET`   |id: inteiro                                      |                  |Obra                              |Retorna uma obra
|`/biblioteca/obra`                                                 |`GET`   |                                                 |                  |Obra                              |Retorna todas as obras
|`/biblioteca/obra/artigo`                                          |`POST`  |                                                 |Artigo            |Artigo                            |Insere um artigo
|`/biblioteca/obra/filme`                                           |`POST`  |                                                 |Filme             |Filme                             |Insere um filme
|`/biblioteca/obra/livro`                                           |`POST`  |                                                 |Livro             |Livro                             |Insere um livro
|`/biblioteca/obra/jornal`                                          |`POST`  |                                                 |Jornal            |Jornal                            |Insere um jornal
|`/biblioteca/obra/manual`                                          |`POST`  |                                                 |Manual            |Manual                            |Insere um manual
|`/biblioteca/obra/Revista`                                         |`POST`  |                                                 |Revista           |Revista                           |Insere uma revista
|`/biblioteca/obra/{id}`                                            |`DELETE`|id: inteiro                                      |                  |Obra                              |Remove uma obra


## Emprestimo

|rota                                                               |funções |argumentos de url                                |argumento de corpo|entidades                         |descrição                           |
|-------------------------------------------------------------------|--------|-------------------------------------------------|------------------|----------------------------------|------------------------------------|
|`/biblioteca/emprestimo/{id}`                                      |`GET`   |id: inteiro                                      |                  |Empréstimo                        |Retorna um empréstimo
|`/biblioteca/emprestimo`                                           |`GET`   |                                                 |                  |Empréstimo                        |Retorna todos os empréstimos
|`/biblioteca/emprestimo`                                           |`POST`  |                                                 |Empréstimo        |Empréstimo                        |Insere um empréstimo
|`/biblioteca/emprestimo/{id}`                                      |`DELETE`|id: inteiro                                      |                  |Empréstimo                        |Remove um empréstimo
|`/biblioteca/emprestimo/{id_emprestimo}/obra/{id_obra}`            |`PUT`   |id_emprestimo: inteiro,<br>id_obra: inteiro      |                  |Empréstimo,<br>Obra               |Relaciona um empréstimo com uma obra
