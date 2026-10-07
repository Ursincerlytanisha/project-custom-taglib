package com.customtags;
import jakarta.servlet.jsp.tagext.*;
import java.util.*;
public class PageTagSupport extends TagSupport
{
private String name;
private int pageSize;
private int pageNumber;
private String _for;
PageProvider pageProvider;
List<PageRow> rows;
public PageTagSupport()
{
this.pageSize=10;
this.pageNumber=1;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setPageSize(int pageSize)
{
if(pageSize >0) this.pageSize=pageSize;
else this.pageSize=10;
}
public int getPageSize()
{
return this.pageSize;
}
public void setPageNumber(int pageNumber)
{
if(pageNumber >0) this.pageNumber=pageNumber;
else this.pageNumber=1;
}
public int getPageNumber()
{
return this.pageNumber;
}
public void setFor(String _for)
{
this._for=_for;
}
public String getFor()
{
return this._for;
}
public int doStartTag()
{
Tag childTag=this;
Tag parentTag;
while(true)
{
parentTag=childTag.getParent();
if(parentTag instanceof PageProvider)
{
this.pageProvider = (PageProvider)parentTag;
if(this.pageProvider.getName().equals(this._for))
{
break;
}
}
this.pageProvider = null;
if(parentTag==null) break;
childTag=parentTag;
}
if(this.pageProvider==null) return SKIP_BODY;
int numberOfPages=this.pageProvider.getNumberOfPages(this.pageSize);
pageContext.setAttribute("pageNumber", this.pageNumber);
pageContext.setAttribute("numberOfPages", numberOfPages);
this.rows=this.pageProvider.getPage(this.pageSize, this.pageNumber);
if(this.rows==null) return SKIP_BODY;
return EVAL_BODY_INCLUDE;
}
public PageRow getPageRow(int index)
{
if(index>=0 && index<this.rows.size()) return this.rows.get(index);
return null;
}
public int doEndTag()
{
return EVAL_PAGE;
}
}