package br.com.neoway.leads.step_definitions;

import br.com.neoway.leads.pages.actions.LoginPageAction;
import br.com.neoway.leads.pages.actions.PrincipalPageAction;
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
