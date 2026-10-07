package com.customtags;
import jakarta.servlet.jsp.tagext.*;
import jakarta.servlet.jsp.*;
public class LoopTagSupport extends BodyTagSupport
{
private int startAt;
private int endAt;
private int value;
public void setStartAt(int startAt)
{
this.startAt=startAt;
}
public void setEndAt(int endAt)
{
this.endAt=endAt;
}
public int getStartAt()
{
return this.startAt;
}
public int getEndAt()
{
return this.endAt;
}
public int doStartTag()
{
if(this.startAt > this.endAt) return SKIP_BODY;
this.value=this.startAt;
pageContext.setAttribute("value", value);
return EVAL_BODY_INCLUDE;
}
public int doAfterBody()
{
this.value++;
if(value > this.endAt) return SKIP_BODY;
pageContext.setAttribute("value", value);
return EVAL_BODY_AGAIN;
}
public int doEndTag()
{
return EVAL_PAGE;
}
}