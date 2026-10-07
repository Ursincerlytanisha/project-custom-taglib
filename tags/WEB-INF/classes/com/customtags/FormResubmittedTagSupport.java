package com.customtags;
import jakarta.servlet.jsp.*;
import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class FormResubmittedTagSupport extends TagSupport
{
public int doStartTag()
{
try
{
HttpServletRequest request= (HttpServletRequest)pageContext.getRequest();
String formId= request.getParameter("formId1234749dfjk");
if(formId==null || pageContext.getAttribute(formId,PageContext.SESSION_SCOPE)==null)
{
return EVAL_BODY_INCLUDE;
}
pageContext.removeAttribute(formId, pageContext.SESSION_SCOPE);
System.out.println("hello from FormResubmission");
}catch(Exception exception)
{
}
return SKIP_BODY;
}
public int doEndTag()
{
return EVAL_PAGE;
}
}