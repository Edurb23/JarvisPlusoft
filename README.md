# Challenge-Java

# Apresentação do projeto J.A.R.V.I.S
Este é o repositório do Projeto J.A.R.V.I.S, dividido em partes entre frontend e backend. O backend, com foco principalmente em Java, foi liderado por Eduardo Reis Braga durante toda a primeira fase de entrega.

Temos como objeto, desenvolver algoritmos avançados de análise de
comportamento do consumidor com base em dados de compras anteriores, interações
online e preferências de estilo, entre outros, para entender melhor as necessidades e
preferências dos clientes visando oferecer uma experiência de compra altamente
personalizada.


Além disso, nossa solução buscará identificar padrões de comportamento de
compra para prever tendências futuras, permitindo-nos adaptar o estoque e as estratégias
de marketing de acordo, garantindo uma oferta alinhada com as expectativas do
mercado.

# Contribuidores
- Raphael Pabst  rm98525
- Silvio Junior rm550821
- Pedro Braga  rm551061
- Eduardo Reis Braga rm551987

# Prazo de Entrega

O prazo estabelecido para a primeira entrega desta fase do projeto é dia 14/04/2024.





# Digramas

## Banco de dados
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/4e9dcd22-9d02-435c-80d9-18c5e1f4da94)

## Diagrama de classes
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/abc90169-c6c5-4b09-a37f-1e473d1321fb)



# Video Prosposta

# Endpoints

## Cliente
- [Listagem de Cliente](#listar_cliente)
- [Buscar Cliente](#buscar_usuário)
- [Cadastrar Cliente](#cadastrar_usuário)
- [Atualizar Cliente](#atualizar_usuário)
- [Deletar Cliente](#deletar_telefone)

## Telefone
- [Listar telefones ](#listar_telefone)
- [Cadastrar telefone](#cadastar_telefone_usuario)
- [Atualizar telefone](#atualizar_usuário)
- [Deletar telefone](#deletar_telefone)

## Email
- [ID do Email](#id_do_email)
- [Cadastrar email](#cadastar_email_usuario)
- [Atualizar email](#atualizar_usuário)
- [Deletar email](#deletar_email)

## Produto
- [Listar produtos](#listar_produtos)
- [Buscar produto por ID](#buscar_produto_por_id)
- [Cadastrar produto](#cadastrar_produto)
- [Atualizar produto](#atualizar_produto)
- [Deletar produto](#deletar_produto)

## Endereço
- [Listar endereços](#listar_enderecos)
- [Cadastrar endereço](#cadastrar_endereco)
- [Atualizar endereço](#atualizar_endereco)
- [Deletar endereço](#deletar_endereco)

## Pagamento
- [Listar pagamento](#listar_pagamento)
- [Cadastrar pagamento](#cadastrar_pagamento)
- [Deletar pagamento](#deletar_pagamento)
  
---
padrão

GET 
- endpoint
- exemplo corpo de resposta
- http responses

POST
- endpoint
- tabela de atributos para request
- exemplo corpo de request
- exemplo corpo de resposta 
- http responses

PUT
- endpoint
- tabela de atributos para request
- exemplo corpo de request
- exemplo corpo de resposta 
- http responses

DELETE
- endpoint 
- exemplo de request 
- não há corpo de resposta 
- http responses
---


## Cliente

### listar_cliente

`GET` /localhost:8080/cliente

**Exemplo Corpo de resposta**
```JSON
[
	{
		"id": 953,
		"nome": "Karina",
		"cpf": "11020301515",
		"rg": "1234567",
		"datanascimento": "2000-04-11",
		"senha": "karina123"
	},
	{
		"id": 954,
		"nome": "Jennie",
		"cpf": "23600731092",
		"rg": "453533395",
		"datanascimento": "1996-01-16",
		"senha": "JennieKim123"
	},
	{
		"id": 956,
		"nome": "Sana",
		"cpf": "31082448095",
		"rg": "416695188",
		"datanascimento": "1996-12-29",
		"senha": "SanaLikey123"
	},
	{
		"id": 957,
		"nome": "Jordan Terrell",
		"cpf": "97297676020",
		"rg": "345316344",
		"datanascimento": "1996-07-13",
		"senha": "wholelott@red123"
	}
]

```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

  ### Bucar_cliente 

  `GET` /localhost:8080/cliente/{id}

  **Exemplo Corpo de resposta**
  ```JSON
{
	"id": 957,
	"nome": "Jordan Terrell",
	"cpf": "97297676020",
	"rg": "345316344",
	"datanascimento": "1996-07-13",
	"senha": "wholelott@red123"
}

```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Cadastrar_Cliente

  `POST` /localhost:8080/cliente/

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  Nome                |  String  |     Sim     | Campo para inserir nome do cliente
|  CPF                 |   String    |     Sim     | Campo para inserir o CPF do cliente
|  RG                  |   String    |     Sim     | Campo para inserir o RG do cliente
|  Data de Nas        |Local_date|     Sim     | Campo para inserir data de nascimento do cliente
|  SENHA              	|   String    |     Sim     | Campo para inserir a Senha do cliente


**Exemplo Corpo do request** 

```JSON

{
    
	"nome": "Cristiano",
        "cpf": "54702324098",
        "rg": "324205727",
        "dataNascimento": "1985-02-05",
	"senha":  "cristiano7portu"
	
    }
```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 958,
	"nome": "Cristiano",
	"cpf": "54702324098",
	"rg": "324205727",
	"datanascimento": "1985-02-05",
	"senha": "cristiano7portu"
}
```
**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|


### Atualizar_Cliente

`PUT` /localhost:8080/cliente/{id}

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  Nome                |  String  |     Sim     | Campo para inserir nome do cliente
|  CPF                 |   String    |     Sim     | Campo para inserir o CPF do cliente
|  RG                  |   String    |     Sim     | Campo para inserir o RG do cliente
|  Data de Nas        |Local_date|     Sim     | Campo para inserir data de nascimento do cliente
|  SENHA              	|   String    |     Sim     | Campo para inserir a Senha do cliente

```JSON

{
    
	"nome": "Cristiano",
        "cpf": "54702324098",
        "rg": "324205727",
        "dataNascimento": "1985-02-05",
	"senha":  "cristianoR7portu"
	
    }
```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 958,
	"nome": "Cristiano",
	"cpf": "54702324098",
	"rg": "324205727",
	"datanascimento": "1985-02-05",
	"senha": "cristianoR7portu"
}
```

### Deletar_Usuário

`Delete` /localhost:8080/cliente/{id}

Retorna um arquivo JSON vazio.

**Respostas que podem aparecer no DELETE :**

| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---


###Listar telefone
`GET` /localhost:8080/telefone

**Exemplo Corpo de resposta**
```JSON
[
	{
		"id": 1,
		"numeroTelefone": "97684-9954",
		"ddd": "11",
		"operadora": "Vivo-Celular"
	},
	{
		"id": 2,
		"numeroTelefone": "98156-8733",
		"ddd": "11",
		"operadora": "Claro-Celular"
	},
	{
		"id": 3,
		"numeroTelefone": "96992-5122",
		"ddd": "11",
		"operadora": "Tim-Celular"
	}
]
```
**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Cadastrar_Telefone

  `POST` /localhost:8080/telefone

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  NUMERO               |  String  |     Sim     | Campo para inserir numero de telefone
|  DDD                |   String    |     Sim     | Campo para inserir o DDD do telefone
|  OPERADORA                  |   String    |     Sim     | Campo para inserir a operadora

**Exemplo Corpo do request** 

```JSON

{
    
	 "numeroTelefone": "96992-5122",
        "ddd": "11",
        "operadora": "Tim-Celular"
	
    }

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 3,
	"numeroTelefone": "96992-5122",
	"ddd": "11",
	"operadora": "Tim-Celular"
}
```


### Atualizar_Telefone

`PUT` /localhost:8080/telefone/{id}

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  NUMERO               |  String  |     Sim     | Campo para inserir numero de telefone
|  DDD                |   String    |     Sim     | Campo para inserir o DDD do telefone
|  OPERADORA                  |   String    |     Sim     | Campo para inserir a operadora

```JSON

{
    
	 "numeroTelefone": "96992-5122",
        "ddd": "11",
        "operadora": "Claro-Celular"
	
    }

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 3,
	"numeroTelefone": "96992-5122",
	"ddd": "11",
	"operadora": "Claro-Celular"
}
```

**Respostas que podem aparecer no PUT :**
| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success)|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---






