package org.apache.jsp.disk;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\t\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t\t<title><a href=\"\">Garleton Academy</a>\r\n");
      out.write("\t\t</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\"\r\n");
      out.write("\t\t\thref=\"/Garleton/bootstrap3.3.6/dist/css/bootstrap.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/Garleton/css/index.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/Garleton/css/curtain.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/Garleton/css/myBreadcrumb.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/Garleton/css/search_icon.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"/Garleton/css/pubuliu.css\" />\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<div id=\"curtain\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"wrapper\">\r\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"userAction!log\" id=\"sign_in_form\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"用户名\" name=\"name\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"密码\" name=\"pwd\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Sign In\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<form method=\"post\" id=\"sign_up_form\" action=\"userAction!reg\"\r\n");
      out.write("\t\t\t\t\tenctype=\"multipart/form-data\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t照片:\r\n");
      out.write("\t\t\t\t\t</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=\"file\" />\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"姓名\" name=\"name\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" placeholder=\"密码\" name=\"pwd\" id=\"first_pwd\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" placeholder=\"重新输入密码\" id=\"second_pwd\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t男\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"male\">\r\n");
      out.write("\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t女\r\n");
      out.write("\t\t\t\t\t\t<input type=\"radio\" name=\"sex\" value=\"female\" checked=\"checked\">\r\n");
      out.write("\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"单位\" name=\"unit\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"电话\" name=\"tel\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"手机\" name=\"cel\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"邮箱\" name=\"email\">\r\n");
      out.write("\t\t\t\t\t<br />\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"Sign Up\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<header id=\"header\">\r\n");
      out.write("\t\t<div id=\"top_info\"></div>\r\n");
      out.write("\t\t<div id=\"carousel\">\r\n");
      out.write("\t\t\t<div id=\"carousel-example-generic\" class=\"carousel slide\"\r\n");
      out.write("\t\t\t\tdata-ride=\"carousel\">\r\n");
      out.write("\t\t\t\t<!-- Indicators -->\r\n");
      out.write("\t\t\t\t<ol class=\"carousel-indicators\">\r\n");
      out.write("\t\t\t\t\t<li data-target=\"#carousel-example-generic\" data-slide-to=\"0\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"active\"></li>\r\n");
      out.write("\t\t\t\t\t<li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\r\n");
      out.write("\t\t\t\t\t<li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\r\n");
      out.write("\t\t\t\t</ol>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Wrapper for slides -->\r\n");
      out.write("\t\t\t\t<div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("\t\t\t\t\t<div class=\"item active\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/Garleton/img/scope2.jpg\" alt=\"...\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"carousel-caption\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t红利息\r\n");
      out.write("\t\t\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"item\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/Garleton/img/scope4.jpg\" alt=\"...\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"carousel-caption\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t胡光延\r\n");
      out.write("\t\t\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t胡光延也不容易呀\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"item\">\r\n");
      out.write("\t\t\t\t\t\t<img src=\"/Garleton/img/scope5.jpg\" alt=\"...\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"carousel-caption\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>\r\n");
      out.write("\t\t\t\t\t\t\t\t肥货\r\n");
      out.write("\t\t\t\t\t\t\t</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t我觉得还是说些有用的比较好\r\n");
      out.write("\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t...\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<!-- Controls -->\r\n");
      out.write("\t\t\t\t<a class=\"left carousel-control\" href=\"#carousel-example-generic\"\r\n");
      out.write("\t\t\t\t\trole=\"button\" data-slide=\"prev\"> <span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\">Previous</span> </a>\r\n");
      out.write("\t\t\t\t<a class=\"right carousel-control\" href=\"#carousel-example-generic\"\r\n");
      out.write("\t\t\t\t\trole=\"button\" data-slide=\"next\"> <span\r\n");
      out.write("\t\t\t\t\tclass=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t\t\t<span class=\"sr-only\">Next</span> </a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<nav id=\"nav_bar\">\r\n");
      out.write("\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\tGarleton Academy\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<ul class=\"myBreadcrumb\">\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"#\">Home</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"#\">Vehicles</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"#\">Vans</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"#\">Camper Vans</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"search\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"category\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"\" class=\"search_rule\">类别</a>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"\">文章名</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"\">时间</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"\">发布人</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"search_ajax\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" placeholder=\"支持模糊匹配\" id=\"search_bar\" />\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<ul id=\"search_result\">\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a>1234</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a>1234</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<a>1234</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"icon\">\r\n");
      out.write("\t\t\t\t<a></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<ul class=\"sign\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"\" id=\"sign_in\">Sign In</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"\" id=\"sign_up\">Sign Up</a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t\t<div id=\"wrapper\">\r\n");
      out.write("\t\t\t<article id=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t</article>\r\n");
      out.write("\t\t\t<aside>\r\n");
      out.write("\t\t\t<header></header>\r\n");
      out.write("\t\t\t<div id=\"advice\"></div>\r\n");
      out.write("\t\t\t</aside>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t<div id=\"footer_info\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<address>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span>联系电话：<a href=\"\">15950570536</a>\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span>地址：<a href=\"\">南京大学南园4舍</a>\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span>邮箱：<a href=\"\">ybbdaidai@126.com</a>\r\n");
      out.write("\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</address>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t\t<script src=\"/Garleton/jquery.1.12.1-min.js\"></script>\r\n");
      out.write("\t\t<script src=\"/Garleton/bootstrap3.3.6/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"/Garleton/js/util/util.js\"></script>\r\n");
      out.write("\t\t<script src=\"/Garleton/js/index.js\"></script>\r\n");
      out.write("\t\t<script src=\"/Garleton/js/pubuliu.js\"></script>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
