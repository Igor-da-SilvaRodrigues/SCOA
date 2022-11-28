# SCOA API
Documentação da api do SCOA.

## Padrões

Todas as funções da api retornam dados no formato `JSON` quando bem sucedidas, o conteúdo depende da operação.

- Funções `GET` retornam o recurso solicitado
- Funções `DELETE` retornam o recurso deletado
- Funções `POST` retornam o recurso inserido
- Funções `PUT` retornam o recurso atualizado

Todas as funções da api que recebem dados como entrada aceitam apenas dados através da URL ou através do corpo (body) da requisição. Todas as funções que aceitam dados pelo corpo da requisição, apenas aceitam dados no formato `JSON`, necessitando que o cabeçalho (head) da requisição contenha o campo `Content-Type` definido no valor `application/json`


Sempre que uma operação é bem sucedida, a API retorna o código Http `200 OK`

Sempre que uma operação falha porque um recurso não foi encontrado, a API retorna o código `404 Not Found` 

Sempre que uma operação falha devido a um erro interno, a api retorna o código `500 Internal Server Error`

Sempre que uma operação falhar devido a um erro na requisição (como dados de entrada mal formatados), a api retorna o código `400 Bad Request`

Sempre que uma operação falhar porque o método invocado não existe no domínio chamado, a api retorna o código `405 Method Not Allowed`

### `GET`
Funções `GET` resgatam uma entidade do banco de dados no formato `application/json`. Elas podem aceitar um `id` na `url` para retornar apenas a entidade que possuir o `id` especificado.

O tipo do `id` depende da entidade desejada, algumas entidades recebem números inteiros (`1, 2, 3, 4`), outras recebem strings (`exemplo@email.com`)

#### Exemplos

- Uma requisição `GET` para a url `http://localhost:8080/financeiro/pagamento/3` irá retornar a folha de pagamento de id 3.

````
{
    "id": 3,
    "pagamento_liquido": 1500.0,
    "pagamento_bruto": 1900.0,
    "data": "2022-12-03",
    "funcionario": null
}

````

- Uma requisição `GET` para a url `http://localhost:8080/financeiro/pagamento` irá retornar todas as folhas de pagamento em uma lista

````
[
    {
        "id": 3,
        "pagamento_liquido": 1500.0,
        "pagamento_bruto": 1900.0,
        "data": "2022-12-03",
        "funcionario": null
    },
    {
        "id": 4,
        "pagamento_liquido": 1500.0,
        "pagamento_bruto": 1900.0,
        "data": "2022-12-03",
        "funcionario": null
    }
]
````
### `POST`
Funções `POST` inserem uma entidade no banco de dados.

Funções `POST` aceitam dados através do corpo (body) da requisição e aceitam apenas dados no formato `application/json`

#### Exemplos

- A seguinte requisição `POST` para a url `http://localhost:8080/financeiro/pagamento/`:
````
{
    "pagamento_bruto": 1900,
    "pagamento_liquido":1500,
    "data": "2022-12-03"
    
}
````
Irá retornar a seguinte resposta: 
````
{
    "id": 4,
    "pagamento_liquido": 1500.0,
    "pagamento_bruto": 1900.0,
    "data": "2022-12-03",
    "funcionario": null
}
````
Indicando que a entidade foi inserida com sucesso.

### `DELETE`
Funções `DELETE` removem uma entidade do banco de dados.
Na maioria das vezes a remoção de uma entidade remove todas as suas relações com outras entidades, mas não remove nenhuma outra entidade além da especificada, portanto todas as entidades de uma relação devem ser removidas manualmente com múltiplas requisições.

Funções `DELETE` obrigatoriamente aceitam um `id` na url para identificar a entidade a ser removida.

#### Exemplos 
- Uma requisição `DELETE` para a url `http://localhost:8080/financeiro/pagamento/4` irá remover a folha de pagamento de id 4.

Retornando a seguinte resposta:
````
{
    "id": 4,
    "pagamento_liquido": 1500.0,
    "pagamento_bruto": 1900.0,
    "data": "2022-12-03",
    "funcionario": null
}
````
Indicando que a entidade foi removida com sucesso.

### `PUT`
Funções `PUT` relacionam duas entidades

Funções `PUT` aceitam dois `id`s, um para cada entidade.

Funções `PUT` são sempre realizadas do ponto de vista da entidade que é proprietária da relação. Relações `1 pra 1` e `N pra N` não possuem regras para definir qual lado é o proprietário da relação. Relações `1 pra N` sempre terão o lado `N` como proprietário da relação.

#### Exemplos

Para relacionar as entidades pagamento de `id=3` com o funcionario de `id=5`, podemos enviar uma requisição `PUT` para a seguinte url:

```
http://localhost:8080/financeiro/pagamento/3/funcionario/5
```
Retornando a seguinte resposta:
````
{
    "id": 3,
    "pagamento_liquido": 1500.0,
    "pagamento_bruto": 1900.0,
    "data": "2022-12-03",
    "funcionario": {
        "id": 5,
        "usuario": null,
        "departamento": "departamento",
        "salario_liquido": 1400
    }
}
````
Indicando que o relacionamento foi realizado com sucesso.

## Atalhos

#### [Modulo Financeiro](financeiro.md)
#### [Modulo Biblioteca](biblioteca.md)
#### [Modulo Almoxarifado](almoxarifado.md)
#### [Modulo Usuario](usuario.md)