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

### Folha de Pagamento
|atributo|tipo|
|--------|----|
|id|inteiro|
|pagamento_liquido|float|
|pagamento_bruto|float|
|data|string|
|funcionario|Funcionario|



### Mensalidade
|atributo|tipo|
|--------|----|
|id|inteiro|
|total|inteiro|
|parcela_fixa|500|
|parcela_variavel|500|
|data|string|
|aluno|Aluno|



### Boleto
|atributo|tipo|
|--------|----|
|id|inteiro|
|vencimento|string|
|data|string|
|pagador|string|
|beneficiario|string|
|linha_digitavel|string|
|mensalidade|Mensalidade|