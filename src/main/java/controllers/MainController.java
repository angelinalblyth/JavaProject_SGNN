package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.SparkBase.staticFileLocation;
import static spark.route.HttpMethod.get;

public class MainController {

    public static void main(String[] args) {


        Seeds.seedData();

        staticFileLocation("/public");

        JournalistController journalistController = new JournalistController();
        ArticleController articleController = new ArticleController();
        NewsController newsController = new NewsController();

        get("/", (req, res) -> {
            HashMap<String, Object> model = new HashMap<>();

            model.put("template", "templates/index.vtl");

            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
