package br.com.neoway.firefly.step_definitions;

import org.junit.Assert;

import br.com.neoway.firefly.pages.actions.LoginPageAction;
import br.com.neoway.firefly.pages.actions.PrincipalPageAction;
import cucumber.api.DataTable;
import cucumber.api.java.pt.*;

public class LoginStep {

	private LoginPageAction loginPageAction;
	private PrincipalPageAction principalPageAction;

	public LoginStep(LoginPageAction loginPageAction, PrincipalPageAction principalPageAction) {
		this.loginPageAction = loginPageAction;
		this.principalPageAction = principalPageAction;
	}

	@Quando("^usuário informar username$")
	public void usuarioInformarUsername() throws Exception {
		principalPageAction.clickSigninLink();
		loginPageAction.isloginsectionDisplayed();
		loginPageAction.preencherLogin("jc.caibar");
	}

	@Quando("^informar o password$")
	public void informarOPassword() {
		loginPageAction.preencherPassword("123321");
	}

	@Quando("^clica no botão de login$")
	public void clicaNoBotaoDeLogin() throws Exception {
		loginPageAction.clickSigninButton();
	}

	@Então("^o usuário está na pagina home da Aplicação$")
	public void oUsuarioEstaNaPaginaHomeDaAplicacao() {

	}

	@Então("^usuário recebe uma seção bootcamp do GitHub$")
	public void usuarioRecebeUmaSecaoBootcampDoGitHub() {

	}

	@Quando("^usuário se concentra na Seção GitHub Bootcamp$")
	public void usuarioSeConcentraNaSecaoGitHubBootcamp() {

	}

	@Então("^usuário recebe uma opção para configuração git$")
	public void usuarioRecebeUmaOpcaoParaConfiguracaoGit() {

	}

	@Quando("^usuário se concentra no Top Banner$")
	public void usuarioSeConcentraNoTopBanner() {

	}

	@Então("^usuário recebe uma opção de home page$")
	public void usuarioRecebeUmaOpcaoDeHomePage() {

	}

	@Dado("^o botão Sign in está presente na tela$")
	public void oBotaoSignInEstaPresenteNaTela() throws Exception {
		Assert.assertTrue(principalPageAction.ishomepageDisplayed());
	}

	@Quando("^o usuário clica no botão Sign in$")
	public void oUsuarioClicaNoBotaoSignIn() throws Exception {
		principalPageAction.clickSigninLink();
	}

	@Então("^a tela de login do usuário é exibida$")
	public void aTelaDeLoginDoUsuarioEExibida() {
		loginPageAction.isloginsectionDisplayed();
	}

	@Quando("^o usuário informar \"([^\"]*)\" no campo username$")
	public void oUsuarioInformarNoCampoUsername(String userName) {
		loginPageAction.preencherLogin(userName);
	}

	@Quando("^o usuário informar \"([^\"]*)\" no campo password$")
	public void oUsuarioInformarNoCampoPassword(String password) {
		loginPageAction.preencherPassword(password);
	}

	@Quando("^o usuário clicar no botão Sign in$")
	public void oUsuarioClicarNoBotaoSignIn() throws Exception {
		loginPageAction.clickSigninButton();
	}

	@Então("^o usuário estiver em home page$")
	public void oUsuarioEstiverEmHomePage() {
		// homePage.isHomesectionDisplayed();
	}

	@Então("^título da home page é \"([^\"]*)\"$")
	public void tituloDaHomePageE(String arg1) {

	}

	@Então("^o usuário recebe a mensagem de erro falha de login$")
	public void oUsuarioRecebeAMensagemDeErroFalhaDeLogin() {
		// Assert.assertEquals("Incorrect username or
		// password.",loginPage.getErrorMessage());
	}

	@Então("^vamos verificar se os seguintes usuários existem$")
	public void vamosVerificarSeOsSeguintesUsuariosExistem(DataTable arg1) {
	}

	@Quando("^o usuário clica no botão Signup$")
	public void oUsuarioClicaNoBotaoSignup() {

	}

	@Então("^usuário é registrado com êxito$")
	public void usuarioERegistradoComExito() {

	}
}
