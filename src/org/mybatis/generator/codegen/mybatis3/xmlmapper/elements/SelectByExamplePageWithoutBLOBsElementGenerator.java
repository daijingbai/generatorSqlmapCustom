package org.mybatis.generator.codegen.mybatis3.xmlmapper.elements;


import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

public class SelectByExamplePageWithoutBLOBsElementGenerator extends
AbstractXmlElementGenerator{
	public SelectByExamplePageWithoutBLOBsElementGenerator() {
        super();
    }

    @Override
    public void addElements(XmlElement parentElement) {
        //String fqjt = introspectedTable.getExampleType();

        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$

        answer.addAttribute(new Attribute("id", //$NON-NLS-1$
                introspectedTable.getSelectByExampleWithPageStatementId()));
        answer.addAttribute(new Attribute(
                "resultMap", introspectedTable.getBaseResultMapId())); //$NON-NLS-1$
        answer.addAttribute(new Attribute("parameterType", "map")); //$NON-NLS-1$

        context.getCommentGenerator().addComment(answer);

        answer.addElement(new TextElement("select * from (select g.*,rownum rn from (select")); //$NON-NLS-1$
        XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
        ifElement.addAttribute(new Attribute("test", "example.distinct")); //$NON-NLS-1$ //$NON-NLS-2$
        ifElement.addElement(new TextElement("distinct")); //$NON-NLS-1$
        answer.addElement(ifElement);

        StringBuilder sb = new StringBuilder();
        /*if (stringHasValue(introspectedTable
                .getSelectByExampleQueryId())) {
            sb.append('\'');
            sb.append(introspectedTable.getSelectByExampleQueryId());
            sb.append("' as QUERYID,"); //$NON-NLS-1$
            answer.addElement(new TextElement(sb.toString()));
        }*/
        answer.addElement(getBaseColumnListElement());

        sb.setLength(0);
        sb.append("from "); //$NON-NLS-1$
        sb.append(introspectedTable
                .getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement((new TextElement(sb.toString())));
        
        //Ìí¼ÓjoinµÄÓï¾äÅÐ¶ÏÆ¬¶Î
        ifElement = new XmlElement("if");
        ifElement.addAttribute(new Attribute("test", "example.join != null"));
        ifElement.addElement(new TextElement("${example.join}"));
        answer.addElement(ifElement);
        
        answer.addElement(getExampleIncludeElement());

        ifElement = new XmlElement("if"); //$NON-NLS-1$
        ifElement.addAttribute(new Attribute("test", "example.orderByClause != null")); //$NON-NLS-1$ //$NON-NLS-2$
        ifElement.addElement(new TextElement("order by ${example.orderByClause}")); //$NON-NLS-1$
       
        answer.addElement(ifElement);
        answer.addElement(new TextElement(") g where rownum &lt;= ${endPage} ) where rn &gt; ${startPage}")); //$NON-NLS-1$

        if (context.getPlugins()
                .sqlMapSelectByExampleWithoutBLOBsElementGenerated(answer,
                        introspectedTable)) {
            parentElement.addElement(answer);
        }
    }

	@Override
	protected XmlElement getExampleIncludeElement() {
		 XmlElement ifElement = new XmlElement("if"); //$NON-NLS-1$
	        ifElement.addAttribute(new Attribute("test", "_parameter != null")); //$NON-NLS-1$ //$NON-NLS-2$

	        XmlElement includeElement = new XmlElement("include"); //$NON-NLS-1$
	        includeElement.addAttribute(new Attribute("refid", //$NON-NLS-1$
	        		introspectedTable.getExampleWhereClausePageId()));
	        ifElement.addElement(includeElement);

	        return ifElement;
	}
    
    
}
