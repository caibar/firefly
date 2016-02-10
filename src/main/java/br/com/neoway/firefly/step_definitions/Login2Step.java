package br.com.neoway.firefly.step_definitions;

import br.com.neoway.firefly.pages.actions.LoginPageAction;
import br.com.neoway.firefly.pages.actions.PrincipalPageAction;
import cucumber.api.java.pt.Dado;

public class Login2Step {

	private LoginPageAction loginPageAction;

	public Login2Step(LoginPageAction loginPageAction, PrincipalPageAction principalPageAction) {
		this.loginPageAction = loginPageAction;
	}


	@Dado("^que o usuário esteja na página de principal da Aplicação$")
	public void queOUsuarioEstejaNaPaginaDePrincipalDaAplicacao() throws Exception {
		loginPageAction.enterSite();
	}

}
