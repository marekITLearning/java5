package sk.itlearning.java5.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/Homepage")
public class Homepage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadPage(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loadPage(request, response);
	}
	
	private void loadPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String language = "en";
		String userLoggedIn = "";
		
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("language")) {
				language = c.getValue();
			}
			if (c.getName().equals("userLoggedIn")) {
				userLoggedIn = c.getValue();
			}
		}
		
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		
		// a trivial controller / page dispatcher
		if (userLoggedIn.length() > 0) {
			response.getWriter().write(getResourceHtml(getServletContext(), "welcome.html", language));
			return;
		} else {
			response.getWriter().write(getResourceHtml(getServletContext(), "login.html", language));
			return;
		}	
	}

	private static String getResourceHtml(ServletContext servletContext, String pageName, String language) throws IOException {
		InputStream is = servletContext.getResourceAsStream("/html/" + pageName);
		String page = IOUtils.toString(is, StandardCharsets.UTF_8.name());
		return localize(page, language);
	}
	
	private static String localize(String content, String language) {
		String localizedContent = content;
		Pattern pattern = Pattern.compile("\\%\\$.*\\$\\%");
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			String unlocalized = content.substring(matcher.start(), matcher.end());
			String localized = localizeString(unlocalized, language);
			localizedContent = localizedContent.replace(unlocalized, localized); 
		}
		return localizedContent;
	}
	
	private static String localizeString(String unlocalized, String language) {
		Locale locale = new Locale(language);
		ResourceBundle rb = ResourceBundle.getBundle("localization.dictionary", locale);
		return rb.getString(stripSpecialChars(unlocalized));
	}
	
	private static String stripSpecialChars(String unlocalized) {
		return unlocalized.replace("%$", "").replace("$%", "");
	}
}
