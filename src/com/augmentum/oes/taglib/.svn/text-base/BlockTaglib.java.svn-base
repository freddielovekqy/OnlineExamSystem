package com.augmentum.oes.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.augmentum.oes.block.BlockAbstract;
import com.augmentum.oes.util.SpringUtil;

public class BlockTaglib extends TagSupport {

    private static final long serialVersionUID = -3600035804653408819L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        BlockAbstract blockAbstract = (BlockAbstract) SpringUtil.getBean(name);
        String html = blockAbstract.displayBlock(pageContext);
        try {
            out.print(html);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    @Override
    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }
}
