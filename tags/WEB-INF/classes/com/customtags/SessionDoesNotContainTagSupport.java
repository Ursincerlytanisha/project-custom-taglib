package com.customtags;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import java.util.*;
import jakarta.servlet.jsp.tagext.*;
public class SessionDoesNotContainTagSupport extends TagSupport
{
private String key;
private Object value;
private boolean processPage;
public SessionDoesNotContainTagSupport()
{
this.key="user";
this.value= null;
}
public void setKey(String key)
{
this.key=key;
}
public String getKey()
{
return this.key;
}
public void setValue(Object value)
{
this.value=value;
}
public Object getValue()
{
return this.value;
}
public int doStartTag()
{
try
{
processPage= (pageContext.getAttribute(key, PageContext.SESSION_SCOPE)!=null);
if(!processPage) return EVAL_BODY_INCLUDE;
}catch(Exception exception)
{
}
return SKIP_BODY;
}
public int doEndTag()
{
return (processPage)?EVAL_PAGE:SKIP_PAGE;
}
}