# Regras de Negócio

## View
Exibir | Ocultar Loading; <br/>
Exibir mensagem de erro; <br/>
Ir para outra tela (*servidor retornar sucesso*); <br/>

## Presenter
Validação de string login e senha (*dados*);


# Organização dentro do MVP

## LoginContract 
Os contratos das regras de negócio mencionadas anteriormente.
- interface View
- interface Presenter

## LoginPresenter
Aonde ele implementará o presenter definido no **LoginContract**.
- view: View de **LoginContract**.
- repository: **LoginRepositoryImpl**.

## Login Activity
Aonde tem as interações com o usuário e ele precisa implementar View definido em **LoginContract**.
- presenter
- presenter.view


