package de.jugda.registration.service;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import lombok.SneakyThrows;

import java.util.Map;

/**
 * @author Niko Köbler, http://www.n-k.de, @dasniko
 */
public class HandlebarsService {

    private final Handlebars handlebars;

    public HandlebarsService() {
        TemplateLoader loader = new ClassPathTemplateLoader();
        loader.setPrefix("/templates");
        loader.setSuffix(".html");

        handlebars = new Handlebars(loader);
    }

    public String getRegistrationForm(Map<String, String> model) {
        return renderTemplate("registration", model);
    }

    public String getThanksPage(Map<String, String> model) {
        return renderTemplate("thanks", model);
    }

    public String getRegistrationsPage(Map<String, Object> model) {
        return renderTemplate("list", model);
    }

    @SneakyThrows
    private String renderTemplate(String templateName, Map<String, ?> model) {
        Template template = handlebars.compile(templateName);
        return template.apply(model);
    }

}