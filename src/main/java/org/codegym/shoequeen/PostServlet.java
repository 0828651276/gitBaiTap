package org.codegym.shoequeen;

import org.codegym.shoequeen.controllers.BaseController;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "PostServlet", urlPatterns = {"/admin/posts/*"})

public class PostServlet extends BaseController {
}