package com.customtags;
import java.util.*;
import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.jsp.*;
public class FormIdTagSupport extends TagSupport
{
public int doStartTag()
{
try
{
String uniqueFormId=UUID.randomUUID().toString();
String formId="formId1234749dfjk";
pageContext.setAttribute(uniqueFormId, uniqueFormId, PageContext.SESSION_SCOPE);
JspWriter jspWriter=pageContext.getOut();
jspWriter.println("<input type='hidden' name='"+formId+"' id='"+formId+"' value='"+uniqueFormId+"'>");
}catch(Exception exception)
{
}
return SKIP_BODY;
}
public int doEndTag()
{
System.out.println(" FormIdTagSuppport do end tag");
return EVAL_PAGE;
}
}