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
- Vinícius Martins Torres Abdala rm99455

# Prazo de Entrega

- O prazo estabelecido para a primeira entrega desta fase do projeto é dia 14/04/2024 - (Concluido)
- O parzo estabelecido para a segunda entrega desta fase do projeto é dia 20/5/2024 
- o prazo final sera em novembro de 2024

# Melhorias

Nesta fase do projeto, implementamos com sucesso os relacionamentos entre as tabelas, aprimorando significativamente a estrutura do banco de dados. Agora, nosso sistema suporta relacionamentos OneToMany, ManyToOne e ManyToMany, permitindo uma modelagem de dados mais rica e complexa. Além disso, atualizamos o diagrama de classes para refletir essas alterações, garantindo que a documentação esteja em conformidade com a nova arquitetura do sistema.

Os relacionamentos OneToMany foram estabelecidos para representar situações onde uma entidade pode estar associada a várias instâncias de outra entidade, mas cada uma dessas instâncias está ligada apenas a uma entidade principal. Por outro lado, os relacionamentos ManyToOne foram implementados para capturar o inverso: múltiplas instâncias de uma entidade estão relacionadas a uma única instância de outra.

Mais complexos, os relacionamentos ManyToMany foram configurados para representar cenários onde várias instâncias de uma entidade podem estar associadas a várias instâncias de outra entidade, possibilitando uma maior flexibilidade na representação de interações entre diferentes conjuntos de dados.

Além dessas melhorias estruturais, também adicionamos validações nos campos dos DTOs (Data Transfer Objects). Essas validações garantem que os dados transmitidos entre as camadas do sistema sejam consistentes e atendam aos requisitos de integridade e formato, prevenindo erros e melhorando a robustez do sistema.





# Digramas

## Banco de dados
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/037fcfc2-ed3e-464c-b70f-ed8b20dcdbf8)



## Diagrama de classes
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/001b013f-c3a0-4fa4-935b-26ad5b8e85f3)





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

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/40d5b135-f316-4045-8cb8-a70c702a137c)



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


  
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/3eec4f97-b7a8-4912-b9a4-3a8688ff3eec)

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
    
			"nome": "Sana Minatozaki",
			"cpf": "33344455566",
			"rg": "135792468",
			"dataNascimento": "1996-12-29",
			"senha": "senha3"
}
	
    
```

**Status 200 ok**
---
**Exemplo corpo de resposta**

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/01b3ed70-1fd4-468f-865c-11f8b6d1b26f)


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
    
	"nome": "Sana Minatozaki",
	"cpf": "33344455566",
	"rg": "135792468",
	"dataNascimento": "1996-12-29",
	"senha": "sana1234"
}
	
    }
```

**Status 200 ok**
---
**Exemplo corpo de resposta**

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/5ce180da-858a-4467-b3c6-2b5872e7db21)


### Deletar_Usuário

`Delete` /localhost:8080/cliente/{id}

Retorna um arquivo JSON vazio.

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/005efd7c-5473-4f87-91c5-6a98cc88f52c)


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
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/afcd062f-f8d5-48e0-a9d0-bcbea8b9eb09)

**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### cadastrar_Telefone

  `POST` http://localhost:8080/cliente/{Id_Cliente}/telefone

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

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/5b0f57a0-c087-4867-867a-8443e7960e63)

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
	 	"numeroTelefone": "96992-51221",
     		"ddd": "11",
     		"operadora": "Claro-Celular"
}

```

**Status 200 ok**
---
**Exemplo corpo de resposta**



![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/9b641f50-72ce-4c72-8f9d-5241d16d0285)


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

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/92dc6b4a-2984-46a3-ba7d-0a35c6218989)


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
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/351669d1-002f-4287-8b4b-0270dcf831d9)


**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Buscar_email
`GET` /localhost:8080/email/{id}
**Exemplo Corpo de resposta**


![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/b4729427-2f5f-48e4-a4d5-f38d444a5db8)




### cadastrar_email

  `POST` http://localhost:8080/cliente/{id_cliente}/email

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  EMAIL             |  String  |     Sim     | Campo para inserir o email
|  DADOS              |   String    |     Sim     | Campo para inserir os dados do email
|  STATUS                  |   String    |     Sim     | Campo para inserir o status do email

**Exemplo Corpo do request** 

```JSON

{
	"email": "sana@gmail.com",
    	"dadosEmail": "sana@gmail.com",
    	"statusEmail": "ATIVO"

		
}

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/c2f30f0a-e9af-4a69-b59d-2b785e0a8e10)

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
	"email": "JennieKim@gmail.com",
	"dadosEmail": "jenniekim@gmail.com",
	"statusEmail": "INATIVO"
}

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/47bccf77-ac4a-4d74-ba53-9e354df69388)


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

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/6491b9fc-7e05-42ce-b606-3feffbf08b6a)


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
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/dc367e5a-2593-48a8-991b-7b0579b1c4d6)


**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### cadastrar_endereco

  `POST` http://localhost:8080/cliente/{Id_Cliente}/endereco

  **Atributos do request**
|        Campo         |   Tipo   | Obrigatorio |  Descrição
|----------------------|----------|:-----------:|--------------------------------------------------|
|  NOME DA RUA             |  String  |     Sim     | Campo para inserir o nome da rua
|  NUMERO DA RESIDENCIA            |   String    |     Sim     | Campo para inserir o numero da residencia
|  NOME DO BAIRRO                  |   String    |     Sim     | Campo para inserir o nome do bairro

**Exemplo Corpo do request** 

```JSON

{
    "nomeRua": "Avenida Faria Lima",
    "numeroResidencia": "2500",
    "nomeBairro": "Itaim Bibi"
}

```

**Status 200 ok**
---
**Exemplo corpo de resposta**
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/9a1cceb8-222f-4fe7-928f-c392cbc308ce)

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
	
		"nomeRua": "Avenida Paulista",
		"numeroResidencia": "1100",
		"nomeBairro": "Bela Vista"
}

```

**Status 200 ok**
---
**Exemplo corpo de resposta**

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/72282d58-aa78-400c-a47a-ae915a07790d)


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

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/ef56e28d-95b2-41b5-acb0-f10d51f2bf72)


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
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/96c8bb96-05a0-43c4-afa7-1d33d82a5e25)

**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

  ### Bucar_porID 

  `GET` /localhost:8080/produto/{id}

  **Exemplo Corpo de resposta**
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/9a5214df-d066-40db-8c53-e3f53a5c73d0)

**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### Cadastrar_Produto

  `POST` /localhost:8080/produto

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
	"nomeProduto": "Moletom com Capuz",
    "categoriaProduto": "MOLETOM",
    "tamanhoProduto": "GG",
    "preco": 129.90,
    "descricao": "Moletom confortável e estiloso"
}
```

**Status 200 ok**
---
**Exemplo corpo de resposta**

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/51982f29-62da-4153-95be-495008c389df)

**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|


### Atualizar_Produto

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
    
	"nomeProduto": "Boné Trucker",
	"categoriaProduto": "ACESSORIOS",
	"tamanhoProduto": "P",
	"preco": 19.9,
	"descricao": "Boné estilo trucker com ajuste traseiro"
	
    }
```

**Status 200 ok**
---
**Exemplo corpo de resposta**

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/7958718f-c3c9-44d5-9c28-f9cfa7be3f2f)


### Deletar_Produto

`Delete` /localhost:8080/produto/{id}

Retorna um arquivo JSON vazio.

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/f735135a-e22d-4f0e-8d8c-9cab9e627911)


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
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/1792e99f-8638-4840-83a3-eb1dd4fbaaad)


**HTTP responses para `GET`**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|
---

### cadastrar_pagamento

  `POST` http://localhost:8080/produto/{Id_Produto}/pagamento

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
	
		"nome": "KARINA RODRIGUES",
		"numero": 52994129913495,
		"descricao": "CREDITO DIVIDO EM 2X",
		"data": "2024-04-11"
	}

```

**Status 200 ok**
---
**Exemplo corpo de resposta**
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/4d3f27ac-6a51-464a-95ac-108803d7b3e0)

**HTTP responses para POST**
| Código | Descrição |
|---|---|
| `200` | Requisição executada com sucesso (success)|
| `400` | Bad request|
| `404` | Registro pesquisado não encontrado (Not found)|
| `500` | Internal server error|

### Deletar_Pagemento

`Delete` /localhost:8080/email/{id}

Retorna um arquivo JSON vazio.

![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/036da3f2-8d69-42db-95a1-152b75b5e1fc)


| Código | Descrição |
|---|---|
| `204` | Requisição executada com sucesso (success).|
| `400` | Erros de validação ou os campos informados não existem no sistema|
| `404` | Registro pesquisado não encontrado (Not found)|
| `405` | Método não implementado.|
| `500` | Internal server error|
---

## Produto_Cliente 

`Put` http://localhost:8080/cliente/{ID_CLIENTE}/produto/{ID_PROUTO}


![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/b541521c-c1af-49cc-8f22-0e7a5a016567)





