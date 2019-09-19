package presentation;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import service.business.Admin;
import service.business.IUser;
import service.business.UserImpleService;

@ManagedBean(name = "authentication", eager = true)
@SessionScoped
public class Login {

	private String pwd;
	private String login;
	private Locale locale;

	private final IUser userws;

	@PostConstruct
	private void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}

	public Login() {

		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
		final UserImpleService userimpleService = new UserImpleService();
		userws = userimpleService.getUserImplePort();
	}

	public String verify() {
		final Admin admin = new Admin();
		admin.setLogin(login);
		admin.setPwd(pwd);
		System.out.println(userws.auth(admin));
		if (userws.auth(admin)) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("auth", true);
			return "index.xhtml?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ", "login ou mot de passe incorrect!"));
		}
		return null;
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		return "login.xhtml?faces-redirect=true";
	}

	public void changeLanguage(final String language) {
		System.out.println(language);
		setLocale(new Locale(language));
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(final String pwd) {
		this.pwd = pwd;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(final Locale locale) {
		this.locale = locale;
	}

}
