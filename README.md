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
- Gustavo Bernardo rm93770

# Prazo de Entrega

O prazo estabelecido para a primeira entrega desta fase do projeto é dia 14/04/2024.





# Digramas

## Banco de dados
![image](https://github.com/Edurb23/JarvisPlusoft/assets/105024461/4e9dcd22-9d02-435c-80d9-18c5e1f4da94)


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

### listar_cliente

`GET` /localhost:8080/cliente

**Exemplo Corpo de resposta**
```JSON
{
    "id": 1,
    "nome": "Ronaldo",
    "cpf": "50189933089",
    "rg": "111631221"
    "dataNascimento": "1995-07-20",
    "senha": "1234",
}

  



