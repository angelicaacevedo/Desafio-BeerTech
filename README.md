# Desafio-BeerTech

## O que deve ser desenvolvido:

### Tela de listagem de produtos:
* Fazer a chamada na API https://private-8f4dda-testeabi.apiary-mock.com/produtos (GET)
* Criar uma lista com a resposta da API
* Validar se o campo **desconto == true** e colocar o campo **preço** em verde #0FB816
* Exemplo da tela: 

<img width="328" alt="Tela" src="https://user-images.githubusercontent.com/71178527/99272502-a0f11100-2806-11eb-8dd6-6a7fd38f4118.png">

<img width="328" alt="Tela de Produtos" src="https://user-images.githubusercontent.com/71178527/99272757-edd4e780-2806-11eb-9be7-06974423ae6b.png">



### Bonus:
* Fazer uma tela de login
* Validar se o login ou senha estão com o campo vazio, caso esteja mostrar o erro para o usuário
* Validar o login na API (POST)
  ```curl --include \
     --request POST \
     --header "Content-Type: application/json" \
     --data-binary "{
    \"login\": \"Stella\",
    \"senha\": \"abi123\" 
    }" \
    'https://private-8f4dda-testeabi.apiary-mock.com/Login'
* Mostrar ao usuário, caso haja erro ao chamar a API
* Exemplo de tela:

<img width="328" alt="Tela de login" src="https://user-images.githubusercontent.com/71178527/99273442-ca5e6c80-2807-11eb-92c6-1e18886585b4.png">
