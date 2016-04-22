package org.apache.jsp.disk;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class administrator_jsp extends org.apache.jasper.runtime.HttpJspBase
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
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title><a href=\"\">Garleton Academy</a></title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/Garleton/bootstrap3.3.6/dist/css/bootstrap.min.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/Garleton/css/index.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/Garleton/css/admin.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/Garleton/css/myBreadcrumb.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/Garleton/css/search_icon.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/Garleton/css/pubuliu.css\"/>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t<header id=\"header\">\r\n");
      out.write("\t\t<div id=\"top_info\"></div>\r\n");
      out.write("\t\t<div id=\"carousel\">\r\n");
      out.write("\t\t\t<div id=\"carousel-example-generic\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("\t\t\t  <!-- Indicators -->\r\n");
      out.write("\t\t\t  <ol class=\"carousel-indicators\">\r\n");
      out.write("\t\t\t    <li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("\t\t\t    <li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\r\n");
      out.write("\t\t\t    <li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\r\n");
      out.write("\t\t\t  </ol>\r\n");
      out.write("\r\n");
      out.write("\t\t\t  <!-- Wrapper for slides -->\r\n");
      out.write("\t\t\t  <div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("\t\t\t    <div class=\"item active\">\r\n");
      out.write("\t\t\t      <img src=\"../img/scope2.jpg\" alt=\"...\">\r\n");
      out.write("\t\t\t      <div class=\"carousel-caption\">\r\n");
      out.write("\t\t\t        <h2>红利息</h2>\r\n");
      out.write("\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"item\">\r\n");
      out.write("\t\t\t      <img src=\"../img/scope4.jpg\" alt=\"...\" >\r\n");
      out.write("\t\t\t      <div class=\"carousel-caption\">\r\n");
      out.write("\t\t\t        <h2>胡光延</h2>\r\n");
      out.write("\t\t\t        <p>胡光延也不容易呀</p>\r\n");
      out.write("\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"item\">\r\n");
      out.write("\t\t\t      <img src=\"../img/scope5.jpg\" alt=\"...\" >\r\n");
      out.write("\t\t\t      <div class=\"carousel-caption\">\r\n");
      out.write("\t\t\t        <h2>肥货</h2>\r\n");
      out.write("\t\t\t        <p>我觉得还是说些有用的比较好</p>\r\n");
      out.write("\t\t\t      </div>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    ...\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t  <!-- Controls -->\r\n");
      out.write("\t\t\t  <a class=\"left carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("\t\t\t    <span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t    <span class=\"sr-only\">Previous</span>\r\n");
      out.write("\t\t\t  </a>\r\n");
      out.write("\t\t\t  <a class=\"right carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("\t\t\t    <span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("\t\t\t    <span class=\"sr-only\">Next</span>\r\n");
      out.write("\t\t\t  </a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<nav id=\"nav_bar\">\r\n");
      out.write("\t\t\t<div id=\"logo\">\r\n");
      out.write("\t\t\t\tGarleton Academy\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<ul class=\"myBreadcrumb\">\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Home</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Vehicles</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Vans</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"#\">Camper Vans</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"search\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"category\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<a href=\"\" class=\"search_rule\">类别</a>\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">文章名</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">时间</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">发布人</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"search_ajax\">\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" placeholder=\"支持模糊匹配\" id=\"search_bar\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<ul id=\"search_result\">\r\n");
      out.write("\t\t\t\t\t\t<li><a>1234</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a>1234</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a>1234</a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"icon\"><a></a></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<ul class=\"sign\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a class=\"manage\" href=\"\">用户管理</a>\r\n");
      out.write("\t\t\t\t\t<ul id=\"userAction\"> \r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\" class=\"query\">查看用户</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\" class=\"delete\">删除用户</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a class=\"manage\" href=\"\" >机构管理</a>\r\n");
      out.write("\t\t\t\t\t<ul id=\"institutionAction\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\" class=\"query\">查看机构</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\" class=\"add\">新增机构</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\" class=\"delete\">删除机构</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<a class=\"manage\" href=\"\">授权</a>\r\n");
      out.write("\t\t\t\t\t<ul id=\"authorizeAction\">\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\" class=\"columnAuthorize\">栏目</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\" class=\"articleAuthorize\">文章</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<li><a href=\"\" id=\"log_out\">Log Out</a></li>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</nav>\r\n");
      out.write("\t</header>\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("\t\t<article id=\"main_block\">\r\n");
      out.write("\t\t\t<header></header>\r\n");
      out.write("\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</article>\r\n");
      out.write("\t\t<aside>\r\n");
      out.write("\t\t\t<header></header>\r\n");
      out.write("\t\t\t<div id=\"advice\"></div>\r\n");
      out.write("\t\t</aside>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<footer>\r\n");
      out.write("\t\t<div id=\"footer_info\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<address>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li><span>联系电话：<a href=\"\">15950570536</a></span></li>\r\n");
      out.write("\t\t\t\t\t<li><span>地址：<a href=\"\">南京大学南园4舍</a></span></li>\r\n");
      out.write("\t\t\t\t\t<li><span>邮箱：<a href=\"\">ybbdaidai@126.com</a></span></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</address>\t\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</footer>\r\n");
      out.write("\t<script src=\"/Garleton/jquery.1.12.1-min.js\"></script>\r\n");
      out.write("\t<script src=\"/Garleton/bootstrap3.3.6/dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script src=\"/Garleton/js/util/util.js\"></script>\r\n");
      out.write("\t<script src=\"/Garleton/js/pubuliu.js\"></script>\r\n");
      out.write("\t<script src=\"/Garleton/js/admin.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
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
