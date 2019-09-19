package utilities;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter({ "/faces/index.xhtml", "/faces/fournisseur.xhtml", "/faces/vente.xhtml", "/faces/achat.xhtml",
//"/faces/article.xhtml", "/faces/client.xhtml" })
public class LoginFilter implements Filter {

	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse resp = (HttpServletResponse) response;
		final HttpSession session = req.getSession(true);
		// final String path =
		// req.getRequestURI().substring(req.getContextPath().length() + 6);
//		if (session.getAttribute("auth") != null || path.equals("/login.xhtml") || path.startsWith("/resources")) {
//			System.out.println("yes");
//			chain.doFilter(request, response);
//		} else {
//			resp.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
//		}
		System.out.println("state: " + session.getAttribute("auth"));
		if (session.getAttribute("auth") != null) {
			if (((boolean) session.getAttribute("auth")) == true) {
				chain.doFilter(request, response);
			}

		} else {
			resp.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
		}

	}

	@Override
	public void init(final FilterConfig fConfig) throws ServletException {
	}

}
