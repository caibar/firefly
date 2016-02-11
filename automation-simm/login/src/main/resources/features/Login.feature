# language: pt
Funcionalidade: Usuário realiza login
  Como um usuário registrado
  Eu quero realizar login na aplicação SIMM
  De modo que eu possa acessar a aplicação

  Contexto: 
    Dado que o usuário está na página de login

  Cenário: O usuário realiza login com sucesso
    Quando o usuário realiza login com uma credencial válida
    Então o sistema exibirá a página SIMM Home
    E o sistema exibirá o nome do usuário logado

  Cenário: O usuário realiza login, logout e login com outra conta
    Quando o usuário realiza login com uma credencial válida
    E o usuário efetua o logout
    E o usuário realiza login com as credenciais "qa-vendedor@neoway.com.br" e "2016@neoway"
    Então o sistema exibirá a página SIMM Home
    E o sistema exibirá o nome do usuário logado "QA Vendedor"

  Cenário: O usuário tenta acessar a home page via URL
    Quando o usuário realiza login com uma credencial válida
    E o usuário copia a URL atual
    E o usuário efetua o logout
    E o usuário cola a URL copiada no navegador
    Então o sistema exibirá a pagina de login

  Esquema do Cenário: O usuário tenta acessar a aplicação com credencial inválida
    Quando o usuário realiza login com as credenciais "<Login>" e "<Senha>"
    Então o sistema exibirá a mensagem de falha "Usuário e/ou senha inválidos"

    Exemplos: 
      | Login                        | Senha       |
      | Automação%@%Teste!.com.br    | neoway@2015 |
      | automacao@neoway.com.br      | au$%a!cao   |
      | teste.uploader@neoway.com.br | simm2014@   |
      | uplo ad er@neoway.com.br     | simm2014@   |
      | teste.uploader@neoway.com.br | sim m2014   |
      |                              | neoway@2015 |
      | automacao@neoway.com.br      |             |
      | automacao@neoway.com.br      | automacao   |
