/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.4.20.v20190813
 * Generated at: 2020-03-10 13:49:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.sku;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("file:/D:/tools/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1567840054114L));
    _jspx_dependants.put("jar:file:/D:/tools/repository/org/apache/taglibs/taglibs-standard-impl/1.2.5/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425949870000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("  \r\n");
      out.write("<div>\r\n");
      out.write("\t<form id=\"addform\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t\t<div class=\"col\">\r\n");
      out.write("\t\t\t\t<label>商品名称</label>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"spu_id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${spu.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t        <input type=\"text\" disabled=\"disabled\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${spu.goods_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"goods_name\" class=\"form-control\" placeholder=\"商品名称\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t    <div class=\"col\">\r\n");
      out.write("\t\t       <label>标题</label>\t\r\n");
      out.write("\t\t        <input type=\"text\" name=\"title\" class=\"form-control\" placeholder=\"标题\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"form-row\">\r\n");
      out.write("\t\t    <div class=\"col\">\r\n");
      out.write("\t\t       <label>卖点</label>\t\r\n");
      out.write("\t\t        <input type=\"text\" name=\"sell_point\" class=\"form-control\" placeholder=\"卖点\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"form-row\">\r\n");
      out.write("\t\t    <div class=\"col\">\r\n");
      out.write("\t\t       <label>价格</label>\t\r\n");
      out.write("\t\t        <input type=\"text\" name=\"price\" class=\"form-control\" placeholder=\"价格\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t   <div id=\"oneSpec\"> \r\n");
      out.write("\t\t    <div class=\"form-row\">\r\n");
      out.write("\t\t\t    <div class=\"col\">\r\n");
      out.write("\t\t\t       <label>属性</label>\r\n");
      out.write("\t\t\t       <select  name=\"specids\" class=\"form-control form-control-lg\"\r\n");
      out.write("\t\t\t       onchange=\"specchange($(this))\">\r\n");
      out.write("\t\t\t\t\t \t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"col\">\r\n");
      out.write("\t\t\t       <label>属性选项（数值）</label>\t\r\n");
      out.write("\t\t\t       <select  name=\"specOptionIds\" class=\"form-control form-control-lg\">\r\n");
      out.write("\t\t\t\t\t \t\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t    <div class=\"col\">\r\n");
      out.write("\t\t\t     <label></label>\r\n");
      out.write("\t\t\t    \t<button type=\"button\" class=\"btn btn-danger\" onclick=\"del($(this))\">删除</button>\r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t  <div id=\"speclList\">\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t <div>\r\n");
      out.write("\t\t  \t <button type=\"button\" class=\"btn btn-danger\" onclick=\"addspec()\">增加属性</button>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"form-row\">\r\n");
      out.write("\t\t    <div class=\"col\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-primary\"  onclick=\"add()\">添加 </button>\r\n");
      out.write("   \t\t\t</div>\r\n");
      out.write("   \t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<script>\r\n");
      out.write("\t\t//属性选项（数值） 前一个点击 改变 下一个追加\r\n");
      out.write("\t\tfunction specchange(specSel) {\r\n");
      out.write("\t\t\t// 获取一个属性的所有的属性数值\r\n");
      out.write("\t\t\t$.post(\"/spec/openupdate\",{id:specSel.val()},function(specData){\r\n");
      out.write("\t\t\t\t// 属性值的下拉框\r\n");
      out.write("\t\t\t\tvar specOption = specSel.parent().next().children().filter(\"select\").first();\r\n");
      out.write("\t\t\t\tspecOption.empty()\r\n");
      out.write("\t\t\t\tfor (var i = 0; i < specData.options.length; i++) {\r\n");
      out.write("\t\t\t\t\t//obj.parent().next().children().filter(\"input\").first().val(obj.val()+\"aaa\");\r\n");
      out.write("\t\t\t\t\tspecOption.append(\"<option value='\"+specData.options[i].id+\"' >\" +specData.options[i].optionName +\"</option>\")\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t//console.log(specData.options[i].id)\r\n");
      out.write("\t\t\t\t} ;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//添加下拉框\r\n");
      out.write("\t\tfunction addspec(){\r\n");
      out.write("\t\t\t$(\"#speclList\").append($(\"#oneSpec\").html())\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction add(){\r\n");
      out.write("\t\t\tvar formData = new FormData($(\"#addform\")[0])\r\n");
      out.write("\t\t\t//提交数据\r\n");
      out.write("\t\t\t$.ajax({url:\"/sku/addsku\",\r\n");
      out.write("\t\t\t\t  //dataType:\"json\",\r\n");
      out.write("\t\t\t\t  data:formData,\r\n");
      out.write("\t\t\t\t  // 让jQuery 不要再提交数据之前进行处理\r\n");
      out.write("\t\t\t\t  processData : false,\r\n");
      out.write("\t\t\t\t  // 提交的数据不能加消息头\r\n");
      out.write("\t\t\t\t  contentType : false,\r\n");
      out.write("\t\t\t\t  // 提交的方式 \r\n");
      out.write("\t\t\t\t  type:\"post\",\r\n");
      out.write("\t\t\t\t  // 成功后的回调函数\r\n");
      out.write("\t\t\t\t  success:function(data){\r\n");
      out.write("\t\t\t\t\t  if(data){\r\n");
      out.write("\t\t\t\t\t\t\t alert(\"数据提交成功\");\r\n");
      out.write("\t\t\t\t\t\t\t //刷新\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#main\").load(\"/sku/list\");\r\n");
      out.write("\t\t\t\t\t\t }else{\r\n");
      out.write("\t\t\t\t\t\t\t alert(\"数据保存失败\");\r\n");
      out.write("\t\t\t\t\t\t }  \r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t\t\t  }\r\n");
      out.write("\t\t\t\t  })\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfunction del(thi){\r\n");
      out.write("\t\t\tthi.parent().parent().remove();\r\n");
      out.write("\t\t}\r\n");
      out.write("</script>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/view/sku/add.jsp(42,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/view/sku/add.jsp(42,7) '${listSpec}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${listSpec}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/view/sku/add.jsp(42,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("spec");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t\t \t\t<option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${spec.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write(' ');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${spec.spec_name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("\t\t\t\t\t \t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
