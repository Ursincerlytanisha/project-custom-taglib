package com.customtags;
import java.util.*; //for UUID
import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.jsp.*;
 public class UIDTagSupport extends TagSupport
{
public int doStartTag()
{
System.out.println("  UIDTagSupport dostart tag method calls");
String uniqueId= UUID.randomUUID().toString();
pageContext.setAttribute("uid", uniqueId, PageContext.REQUEST_SCOPE);
return SKIP_BODY;
}
public int doEndTag()
{
System.out.println(" UIDTagSupport do end tag method calls");
return EVAL_PAGE;
}
}