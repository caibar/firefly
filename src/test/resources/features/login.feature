# language: pt
Funcionalidade: página de login
  A fim de testar página de login
  Como utilizador registado
  Eu quero especificar as condições de login

  Contexto: O usuário esteja na tala principal da aplicação
    Dado que o usuário esteja na página de principal da Aplicação

  Cenário: fluxo do login
    E o botão Sign in está presente na tela
    Quando o usuário clica no botão Sign in
    Então a tela de login do usuário é exibida
    Quando o usuário informar "ShankarGarg" no campo username
    E o usuário informar "123456" no campo password
    E o usuário clicar no botão Sign in
    Então o usuário estiver em home page
    E título da home page é "GitHub"

  Esquema do Cenário: Falha de login - combinações possíveis
    Quando o usuário clica no botão Sign in
    Então a tela de login do usuário é exibida
    Quando o usuário informar "<UserName>" no campo username
    E o usuário informar "<Password>" no campo password
    E o usuário clicar no botão Sign in
    Então o usuário recebe a mensagem de erro falha de login

    Exemplos: 
      | UserName      | Password      |
      | wrongusername | 123456        |
      | ShankarGarg   | wrongpassword |
      | wrongusername | wrongpassword |

  Cenário: Existing user Verification
    Então vamos verificar se os seguintes usuários existem
      | Name    | Email           | Phone |
      | Shankar | sgarg@email.com | 999   |
      | Ram     | ram@email.com   | 888   |
      | Sham    | sham@email.org  | 666   |

  Cenário: Novo Registro de Usuário
    Quando o usuário informar "ShankarGarg" no campo username
    E o usuário informar "sgarg@gmail.com" no campo password
    E o usuário informar "123456" no campo password
    E o usuário clica no botão Signup
    Então usuário é registrado com êxito
