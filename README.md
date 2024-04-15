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
o prazo final sera em novembro de 2024





# Digramas

## Banco de dados
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/4e9dcd22-9d02-435c-80d9-18c5e1f4da94)

## Diagrama de classes
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/abc90169-c6c5-4b09-a37f-1e473d1321fb)



# Video Prosposta

Link para o Video: https://youtu.be/3B3Oq7kc3yE

# Endpoints

## Cliente
- [Listagem de Cliente](#listar_cliente)
- [Buscar Cliente](#Bucar_cliente)
- [Cadastrar Cliente](#Cadastrar_Cliente)
- [Atualizar Cliente](#Atualizar_Cliente)
- [Deletar Cliente](#Deletar_Cliente)

## Telefone
- [Listar telefones ](#Listar_Telefone)
- [Cadastrar telefone](#Cadastar_Telefone)
- [Atualizar telefone](#Atualizar_Telefone)
- [Deletar telefone](#Deletar_Telefone)

## Email
- [Listar_email](#Listar_Email)
- [Cadastrar email](#Cadastar_Email)
- [Atualizar email](#Atualizar_Email)
- [Deletar email](#Deletar_Email)

## Endereço
- [Listar endereços](#listar_enderecos)
- [Cadastrar endereço](#cadastrar_endereco)
- [Atualizar endereço](#atualizar_endereco)
- [Deletar endereço](#deletar_endereco)


## Produto
- [Listar produtos](#listar_produtos)
- [Buscar produto por ID](#buscar_produto_por_id)
- [Cadastrar produto](#cadastrar_produto)
- [Atualizar produto](#atualizar_produto)
- [Deletar produto](#deletar_produto)



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


### listar_telefone
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

### cadastrar_Telefone

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
**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|


### atualizar_Telefone

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

### Deletar_Telefone

`Delete` /localhost:8080/telefone/{id}

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

### Listar_Email 

`GET` /localhost:8080/email

**Exemplo Corpo de resposta**
```JSON
[
	{
		"id": 1,
		"email": "Karina@gmail.com",
		"dadosEmail": "Karina@gmail.com",
		"statusEmail": "ativo"
	},
	{
		"id": 2,
		"email": "Jennie@gmail.com",
		"dadosEmail": "Jennie@gmail.com",
		"statusEmail": "ativo"
	},
	{
		"id": 3,
		"email": "Sana@hotmail.com",
		"dadosEmail": "sana@hotmail.com",
		"statusEmail": "ativo"
	},
	{
		"id": 4,
		"email": "playboiC@hotmail.com",
		"dadosEmail": "playboiC@hotmail.com",
		"statusEmail": "ativo"
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

### cadastrar_email

  `POST` /localhost:8080/email

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  EMAIL             |  String  |     Sim     | Campo para inserir o email
|  DADOS              |   String    |     Sim     | Campo para inserir os dados do email
|  STATUS                  |   String    |     Sim     | Campo para inserir o status do email

**Exemplo Corpo do request** 

```JSON

{
    
	 "email": "playboiC@hotmail.com",
        "dadosEmail": "playboiC@hotmail.com",
        "statusEmail": "ativo"
    }

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 4,
	"email": "playboiC@hotmail.com",
	"dadosEmail": "playboiC@hotmail.com",
	"statusEmail": "ativo"
}
```
**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|

### atualizar_email

`PUT` /localhost:8080/email/{id}

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  EMAIL             |  String  |     Sim     | Campo para inserir o email
|  DADOS              |   String    |     Sim     | Campo para inserir os dados do email
|  STATUS                  |   String    |     Sim     | Campo para inserir o status do email

```JSON

{
	"email": "playboiC@hotmail.com",
        "dadosEmail": "playboiC@hotmail.com",
        "statusEmail": "inativo"
	
    }

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 4,
	"email": "playboiC@hotmail.com",
	"dadosEmail": "playboiC@hotmail.com",
	"statusEmail": "inativo"
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

### Deletar_Email

`Delete` /localhost:8080/email/{id}

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

### Listar_Endereco 

`GET` /localhost:8080/endereco

**Exemplo Corpo de resposta**
```JSON
[
	{
		"id": 52,
		"nomeRua": "Rua Pereira Estéfano",
		"numeroResidencia": "320",
		"nomeBairro": "Vila da Saúde"
	},
	{
		"id": 53,
		"nomeRua": "Rua Doutor João Goulart",
		"numeroResidencia": "20",
		"nomeBairro": "ÁGUA RASA"
	},
	{
		"id": 54,
		"nomeRua": "Av Lins de vasconcelos",
		"numeroResidencia": "1222",
		"nomeBairro": "Aclimação"
	},
	{
		"id": 55,
		"nomeRua": "Rua da Gloria",
		"numeroResidencia": "50",
		"nomeBairro": "Liberdade"
	},
	{
		"id": 56,
		"nomeRua": "Rua da Gloria",
		"numeroResidencia": "50",
		"nomeBairro": "Liberdade"
	},
	{
		"id": 57,
		"nomeRua": "Rua frei caneca",
		"numeroResidencia": "445",
		"nomeBairro": "Consolação"
	},
	{
		"id": 58,
		"nomeRua": "Rua barão de campinas",
		"numeroResidencia": "40",
		"nomeBairro": "Bom Retiro"
	},
	{
		"id": 1,
		"nomeRua": "Rua curupace",
		"numeroResidencia": "240",
		"nomeBairro": "Mocca"
	},
	{
		"id": 954,
		"nomeRua": "Av Lins de vasconcelos",
		"numeroResidencia": "1222",
		"nomeBairro": "Aclimação"
	},
	{
		"id": 952,
		"nomeRua": "Rua Pereira Estéfano",
		"numeroResidencia": "320",
		"nomeBairro": "Vila da Saúde"
	},
	{
		"id": 953,
		"nomeRua": "Rua Doutor João Goulart",
		"numeroResidencia": "20",
		"nomeBairro": "ÁGUA RASA"
	},
	{
		"id": 955,
		"nomeRua": "Rua da Gloria",
		"numeroResidencia": "50",
		"nomeBairro": "Liberdade"
	},
	{
		"id": 956,
		"nomeRua": "Rua da Gloria",
		"numeroResidencia": "50",
		"nomeBairro": "Liberdade"
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

### cadastrar_endereco

  `POST` /localhost:8080/enderco

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  NOME DA RUA             |  String  |     Sim     | Campo para inserir o nome da rua
|  NUMERO DA RESIDENCIA            |   String    |     Sim     | Campo para inserir o numero da residencia
|  NOME DO BAIRRO                  |   String    |     Sim     | Campo para inserir o nome do bairro

**Exemplo Corpo do request** 

```JSON

{
    
	"nomeRua": "Rua da Gloria",
        "numeroResidencia": "50",
        "nomeBairro": "Liberdade"
    }

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 956,
	"nomeRua": "Rua da Gloria",
	"numeroResidencia": "50",
	"nomeBairro": "Liberdade"
}
```
**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|

### atualizar_endereco

`PUT` /localhost:8080/endereco/{id}

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  NOME DA RUA             |  String  |     Sim     | Campo para inserir o nome da rua
|  NUMERO DA RESIDENCIA            |   String    |     Sim     | Campo para inserir o numero da residencia
|  NOME DO BAIRRO                  |   String    |     Sim     | Campo para inserir o nome do bairro

```JSON

{
	"nomeRua": "Rua da Gloria",
        "numeroResidencia": "100",
        "nomeBairro": "Liberdade"
	
    }

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 956,
	"nomeRua": "Rua da Gloria",
	"numeroResidencia": "100",
	"nomeBairro": "Liberdade"
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

### Deletar_Endereco

`Delete` /localhost:8080/endereco/{id}

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


## Produto

### Listar_Produtos

`GET` /localhost:8080/produto

**Exemplo Corpo de resposta**
```JSON
[
	{
		"id": 952,
		"nomeProduto": "Camisa Branca lisa",
		"categoriaProduto": "CAMISA",
		"tamanhoProduto": "G",
		"preco": 250.5,
		"descricao": "Uma camissa branca de algodao."
	},
	{
		"id": 953,
		"nomeProduto": "Calça Jeans Reta",
		"categoriaProduto": "CALCA",
		"tamanhoProduto": "M",
		"preco": 400.0,
		"descricao": "Calça Jeans Reta."
	},
	{
		"id": 954,
		"nomeProduto": "Conjuto Moletom",
		"categoriaProduto": "MOLETOM",
		"tamanhoProduto": "M",
		"preco": 350.0,
		"descricao": "Conjuto Moletom com uma calça e um blusao com a logo."
	},
	{
		"id": 955,
		"nomeProduto": "Jaqueta Jeans Preta",
		"categoriaProduto": "JAQUETA",
		"tamanhoProduto": "GG",
		"preco": 350.0,
		"descricao": "Jaqueta."
	},
	{
		"id": 956,
		"nomeProduto": "Jaqueta Jeans Preta",
		"categoriaProduto": "JAQUETA",
		"tamanhoProduto": "GG",
		"preco": 350.0,
		"descricao": "Jaqueta Preta style 80s."
	},
	{
		"id": 957,
		"nomeProduto": "Regata com estampa",
		"categoriaProduto": "REGATA",
		"tamanhoProduto": "P",
		"preco": 120.0,
		"descricao": "Regata para o verao."
	},
	{
		"id": 958,
		"nomeProduto": "Conjuto de Aneis e pusleira",
		"categoriaProduto": "ACESSORIOS",
		"tamanhoProduto": "P",
		"preco": 100.0,
		"descricao": "Conjuto de Aneis e pusleira de aço."
	},
	{
		"id": 959,
		"nomeProduto": "Camiseta punk oversize",
		"categoriaProduto": "CAMISETA",
		"tamanhoProduto": "M",
		"preco": 250.0,
		"descricao": "Camiseta punk oversize branca"
	},
	{
		"id": 102,
		"nomeProduto": "Camisa Branca lisa",
		"categoriaProduto": "CAMISA",
		"tamanhoProduto": "G",
		"preco": 250.5,
		"descricao": "Uma camissa branca de algodao."
	},
	{
		"id": 103,
		"nomeProduto": "Calça Jeans Reta",
		"categoriaProduto": "CALCA",
		"tamanhoProduto": "M",
		"preco": 400.0,
		"descricao": "Calça Jeans Reta."
	},
	{
		"id": 104,
		"nomeProduto": "Conjuto Moletom",
		"categoriaProduto": "MOLETOM",
		"tamanhoProduto": "M",
		"preco": 350.0,
		"descricao": "Conjuto Moletom com uma calça e um blusao com a logo."
	},
	{
		"id": 105,
		"nomeProduto": "Jaqueta Jeans Preta",
		"categoriaProduto": "JAQUETA",
		"tamanhoProduto": "GG",
		"preco": 350.0,
		"descricao": "Jaqueta."
	},
	{
		"id": 106,
		"nomeProduto": "Jaqueta Jeans Preta",
		"categoriaProduto": "JAQUETA",
		"tamanhoProduto": "GG",
		"preco": 350.0,
		"descricao": "Jaqueta Preta style 80s."
	},
	{
		"id": 107,
		"nomeProduto": "Shorts Preto",
		"categoriaProduto": "SHORTS",
		"tamanhoProduto": "P",
		"preco": 120.0,
		"descricao": "Shorts preto para o verao."
	},
	{
		"id": 108,
		"nomeProduto": "Regata com estampa",
		"categoriaProduto": "REGATA",
		"tamanhoProduto": "P",
		"preco": 120.0,
		"descricao": "Regata para o verao."
	},
	{
		"id": 109,
		"nomeProduto": "Conjuto de Aneis e pusleira",
		"categoriaProduto": "ACESSORIOS",
		"tamanhoProduto": "P",
		"preco": 100.0,
		"descricao": "Conjuto de Aneis e pusleira de aço."
	},
	{
		"id": 110,
		"nomeProduto": "Camiseta punk oversize",
		"categoriaProduto": "CAMISETA",
		"tamanhoProduto": "M",
		"preco": 250.0,
		"descricao": "Camiseta punk oversize branca"
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

  `GET` /localhost:8080/produto/{id}

  **Exemplo Corpo de resposta**
  ```JSON
{
	"id": 110,
	"nomeProduto": "Camiseta punk oversize",
	"categoriaProduto": "CAMISETA",
	"tamanhoProduto": "M",
	"preco": 250.0,
	"descricao": "Camiseta punk oversize branca"
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
|  Nome  do produto              |  String  |     Sim     | Campo para inserir nome do produto
|  categoria do produto          |   String    |     Sim     | Campo para inserir o categoria do produto( CAMISA,CAMISETA, MOLETOM,JAQUETA,CALCA,SHORTS,REGATA,ACESSORIOS)
|  tamanho do produto           |   String    |     Sim     | Campo para inserir o tamanho do produto( PP, P, M, G, GG,XG)
|  preco       		|Double|     Sim     | Campo para inserir preco do produto
|  descricao              		|   String    |     Sim     | Campo para inserir a descricao do produto


**Exemplo Corpo do request** 

```JSON

{
    
   	"nomeProduto": "Camiseta punk oversize",
        "categoriaProduto": "CAMISETA",
        "tamanhoProduto": "M",
        "preco": 250.0,
        "descricao": "Camiseta punk oversize branca"
    }
```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 959,
	"nomeProduto": "Camiseta punk oversize",
	"categoriaProduto": "CAMISETA",
	"tamanhoProduto": "M",
	"preco": 250.0,
	"descricao": "Camiseta punk oversize branca"
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

`PUT` /localhost:8080/produto/{id}

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  Nome  do produto              |  String  |     Sim     | Campo para inserir nome do produto
|  categoria do produto          |   String    |     Sim     | Campo para inserir o categoria do produto( CAMISA,CAMISETA, MOLETOM,JAQUETA,CALCA,SHORTS,REGATA,ACESSORIOS)
|  tamanho do produto           |   String    |     Sim     | Campo para inserir o tamanho do produto( PP, P, M, G, GG,XG)
|  preco       		|Double|     Sim     | Campo para inserir preco do produto
|  descricao              		|   String    |     Sim     | Campo para inserir a descricao do produto

```JSON

{
    
	"nomeProduto": "Camiseta punk oversize",
	"categoriaProduto": "CAMISETA",
	"tamanhoProduto": "P",
	"preco": 250.0,
	"descricao": "Camiseta punk oversize branca"
	
    }
```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 110,
	"nomeProduto": "Camiseta punk oversize",
	"categoriaProduto": "CAMISETA",
	"tamanhoProduto": "P",
	"preco": 250.0,
	"descricao": "Camiseta punk oversize branca"
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


## Pagamento

### Listar_Pagamento 

`GET` /localhost:8080/pagamento

**Exemplo Corpo de resposta**
```JSON
[
	{
		"id": 152,
		"nome": "KARINA RODRIGUES",
		"numero": 52994129913495,
		"descricao": "CREDITO DIVIDO EM 2X",
		"data": "2024-04-11"
	},
	{
		"id": 153,
		"nome": "CRISTIANO RODRIGUES",
		"numero": 5290067142082335,
		"descricao": "CREDITO DIVIDO EM 5X",
		"data": "2024-02-14"
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

### cadastrar_pagamento

  `POST` /localhost:8080/pagamento

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  Nome            |  String  |     Sim     | Campo para inserir o nome do titular
|  Numero              |   String    |     Sim     | Campo para inserir os numeros do cartão
|  Descricao                 |   String    |     Sim     | Campo para inserir a descrição da compra
|  Data         |Local_date|     Sim     | Campo para inserir data da compra


**Exemplo Corpo do request** 

```JSON

{
    
	"nome": "CRISTIANO RODRIGUES",
        "numero": 5290067142082335,
        "descricao": "CREDITO DIVIDO EM 5X",
        "data": "2024-02-14"
        
}

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

```JSON

{
	"id": 153,
	"nome": "CRISTIANO RODRIGUES",
	"numero": 5290067142082335,
	"descricao": "CREDITO DIVIDO EM 5X",
	"data": "2024-02-14"
}
```
**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|

### Deletar_Email

`Delete` /localhost:8080/email/{id}

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








