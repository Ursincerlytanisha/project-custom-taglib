package com.customtags;
import jakarta.servlet.jsp.tagext.*;
public class PageNumberTagSupport extends BodyTagSupport
{
private String of;
PageTagSupport pageTagSupport;
int pageNumber;
int numberOfTabs=4;
int startAt;
int endAt;
String nameOfPageNumber;
public void setOf(String of)
{
this.of=of;
}
public String getOf()
{
return this.of;
}
public void setNameOfPageNumber(String nameOfPageNumber)
{
this.nameOfPageNumber=nameOfPageNumber;
}
public String getNameOfPageNumber()
{
return this.nameOfPageNumber;
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
this.pageNumber=this.pageTagSupport.getPageNumber();
int totalPages= (int)pageContext.getAttribute("numberOfPages");
if(this.pageNumber > totalPages) return SKIP_BODY;
this.startAt=((int)((this.pageNumber-1)/numberOfTabs))*numberOfTabs +1;
this.endAt=this.startAt+numberOfTabs-1;
pageContext.setAttribute(this.nameOfPageNumber, this.startAt);
pageContext.setAttribute("pageNumber", this.pageNumber);
return EVAL_BODY_INCLUDE;
}
public int doAfterBody()
{
this.startAt++;
if(this.startAt>this.endAt) return SKIP_BODY;
pageContext.setAttribute(this.nameOfPageNumber, this.startAt);
pageContext.setAttribute("pageNumber", this.pageNumber);
return EVAL_BODY_AGAIN;
}
public int doEndTag()
{
return EVAL_PAGE;	
}
}