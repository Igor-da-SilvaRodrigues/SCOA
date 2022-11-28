# SCOA API
# Modulo Financeiro

## Folha de Pagamento

|rota                                                               |funções |argumentos de url                                |argumento de corpo|entidades                         |descrição                           |
|-------------------------------------------------------------------|--------|-------------------------------------------------|------------------|----------------------------------|------------------------------------|
|`/financeiro/pagamento/{id}`                                       |`GET`   |id: inteiro                                      |                  |Folha de Pagamento                |Retorna uma folha de pagamento
|`/financeiro/pagamento`                                            |`GET`   |                                                 |                  |Folha de Pagamento                |Retorna todas as folhas de pagamento
|`/financeiro/pagamento`                                            |`POST`  |                                                 |Folha de Pagamento|Folha de Pagamento                |Insere uma folha de pagamento
|`/financeiro/pagamento/{id}`                                       |`DELETE`|id: inteiro                                      |                  |Folha de Pagamento                |Remove uma folha de pagamento
|`/financeiro/pagamento/{id_pagamento}/funcionario/{id_funcionario}`|`PUT`   |id_pagamento: inteiro,<br>id_funcionario: inteiro|                  |Folha de Pagamento,<br>Funcionario|Relaciona uma folha de pagamento com um funcionário

## Mensalidade

|rota                                                                 |funções |argumentos de url                                |argumento de corpo|entidades                         |descrição                           |
|---------------------------------------------------------------------|--------|-------------------------------------------------|------------------|----------------------------------|------------------------------------|
|`/financeiro/mensalidade/{id}`                                       |`GET`   |id: inteiro                                      |                  |Mensalidade                       |Retorna uma mensalidade
|`/financeiro/mensalidade`                                            |`GET`   |                                                 |                  |Mensalidade                       |Retorna todas as mensalidades
|`/financeiro/mensalidade`                                            |`POST`  |                                                 |Mensalidade       |Mensalidade                       |Insere uma mensalidade
|`/financeiro/mensalidade/{id}`                                       |`DELETE`|id: inteiro                                      |                  |Mensalidade                       |Remove uma mensalidade
|`/financeiro/mensalidade/{id_mensalidade}/aluno/{id_aluno}`          |`PUT`   |id_mensalidade: inteiro,<br>id_aluno: inteiro    |                  |Mensalidade,<br>Aluno             |Relaciona uma mensalidade com um aluno

## Boleto

|rota                                                            |funções |argumentos de url                                |argumento de corpo|entidades             |descrição                           |
|----------------------------------------------------------------|--------|-------------------------------------------------|------------------|----------------------|------------------------------------|
|`/financeiro/boleto/{id}`                                       |`GET`   |id: inteiro                                      |                  |Boleto                |Retorna um boleto
|`/financeiro/boleto`                                            |`GET`   |                                                 |                  |Boleto                |Retorna todos os boletos
|`/financeiro/boleto`                                            |`POST`  |                                                 |Boleto            |Boleto                |Insere um boleto
|`/financeiro/boleto/{id}`                                       |`DELETE`|id: inteiro                                      |                  |Boleto                |Remove um boleto
|`/financeiro/boleto/{id_boleto}/mensalidade/{id_mensalidae}`    |`PUT`   |id_boleto: inteiro,<br>id_mensalidade: inteiro   |                  |Boleto,<br>Mensalidade|Relaciona um boleto com uma mensalidade

## Objetos

<sub>Obs: Dados inseríveis são aqueles que podem estar na requisição. Dados não inseríveis não são permitidos na requisição.<sub>

### Folha de Pagamento
|atributo|tipo|inserível|
|--------|----|---------|
|id|inteiro|
|pagamento_liquido|float| Sim
|pagamento_bruto|float| Sim
|data|string| Sim
|funcionario|Funcionario|



### Mensalidade
|atributo|tipo|inserível|
|--------|----|---------|
|id|inteiro|
|total|inteiro| Sim
|parcela_fixa|500| Sim
|parcela_variavel|500| Sim
|data|string| Sim
|aluno|Aluno|



### Boleto
|atributo|tipo|inserível|
|--------|----|---------|
|id|inteiro|
|vencimento|string| Sim
|data|string| Sim
|pagador|string| Sim
|beneficiario|string| Sim
|linha_digitavel|string| Sim
|mensalidade|Mensalidade|