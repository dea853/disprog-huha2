package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mydata_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>HaloApp | Boostrap Themes</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("  <h2>List of Our Products</h2>\n");
      out.write("  <p>Berikut ini adalah daftar Product yang dimiliki</p>            \n");
      out.write("  <table class=\"table table-hover\">\n");
      out.write("    <thead>\n");
      out.write("      <tr>\n");
      out.write("        <th>Kode</th>\n");
      out.write("        <th>Nama</th>\n");
      out.write("        <th>Deskripsi</th>\n");
      out.write("        <th>Stok</th>\n");
      out.write("      </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("      <tr>\n");
      out.write("         <td>John</td>\n");
      out.write("        <td>John</td>\n");
      out.write("        <td>Doe</td>\n");
      out.write("        <td>john@example.com</td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("           <td>Mary</td>\n");
      out.write("        <td>Mary</td>\n");
      out.write("        <td>Moe</td>\n");
      out.write("        <td>mary@example.com</td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("           <td>Mary</td>\n");
      out.write("        <td>July</td>\n");
      out.write("        <td>Dooley</td>\n");
      out.write("        <td>july@example.com</td>\n");
      out.write("      </tr>\n");
      out.write("    </tbody>\n");
      out.write("  </table>\n");
      out.write("  \n");
      out.write("  <h2>List of Our Accounts</h2>\n");
      out.write("  <p>Berikut ini adalah daftar Akun  yang dimiliki</p>            \n");
      out.write("  <table class=\"table table-hover\">\n");
      out.write("    <thead>\n");
      out.write("      <tr>\n");
      out.write("        <th>username</th>\n");
      out.write("        <th>no HP</th>\n");
      out.write("        <th>Login terakhir</th>\n");
      out.write("        <th>Jumlah Failed Login</th>\n");
      out.write("        <th>Status Suspend</th>\n");
      out.write("        <th>Control</th>\n");
      out.write("      </tr>\n");
      out.write("    </thead>\n");
      out.write("    <tbody>\n");
      out.write("      <tr>\n");
      out.write("         <td>John</td>\n");
      out.write("        <td>John</td>\n");
      out.write("        <td>Doe</td>\n");
      out.write("        <td>Doe</td>\n");
      out.write("        <td>john@example.com</td>\n");
      out.write("        <td><a href=\"#\">Aktifkan Kembali</a></td>\n");
      out.write("      </tr>\n");
      out.write("      \n");
      out.write("      <tr>\n");
      out.write("           <td>Mary</td>\n");
      out.write("        <td>July</td>\n");
      out.write("        <td>Dooley</td>\n");
      out.write("        <td>Dooley</td>\n");
      out.write("        <td>july@example.com</td>\n");
      out.write("        <td><a href=\"#\">Aktifkan Kembali</a></td>\n");
      out.write("      </tr>\n");
      out.write("    </tbody>\n");
      out.write("  </table>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
