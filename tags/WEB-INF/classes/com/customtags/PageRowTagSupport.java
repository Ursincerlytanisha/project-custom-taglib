package com.customtags;
import jakarta.servlet.jsp.tagext.*;
public class PageRowTagSupport  extends BodyTagSupport
{
private String beanName;
private String of;
private int index;
PageTagSupport pageTagSupport;
public PageRowTagSupport()
{
this.beanName="";
this.of="";
}
public void setBeanName(String beanName)
{
this.beanName=beanName;
}
public String getBeanName()
{
return this.beanName;
}
public void setOf(String of)
{
this.of=of;
}
public String getOf()
{
return this.of;
}
public int doStartTag()
{
Tag childTag=this;
Tag parentTag;
while(true)
{
parentTag=childTag.getParent();
if(parentTag instanceof PageTagSupport)
{
this.pageTagSupport = (PageTagSupport)parentTag;
if(this.pageTagSupport.getName().equals(this.of))
{
break;
}
}
this.pageTagSupport = null;
if(parentTag==null) break;
childTag=parentTag;
}
if(this.pageTagSupport==null) return SKIP_BODY;
this.index=0;
PageRow pageRow=this.pageTagSupport.getPageRow(index);
if(pageRow==null) return SKIP_BODY;
pageContext.setAttribute(this.beanName, pageRow);
return EVAL_BODY_INCLUDE;
}
public int doAfterBody()
{
this.index++;
PageRow pageRow=this.pageTagSupport.getPageRow(index);
if(pageRow==null) return SKIP_BODY;
pageContext.setAttribute(this.beanName, pageRow);
return EVAL_BODY_AGAIN;
}
public int doEndTag()
{
return EVAL_PAGE;
}
}