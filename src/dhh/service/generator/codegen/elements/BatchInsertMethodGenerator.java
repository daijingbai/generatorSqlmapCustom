package dhh.service.generator.codegen.elements;

import java.util.Set;
import java.util.TreeSet;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

public class BatchInsertMethodGenerator extends AbstractJavaMapperMethodGenerator {

    public BatchInsertMethodGenerator() {
        super();
    }

    @Override
    public void addInterfaceElements(Interface interfaze) {
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        Method method = new Method();

        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName(introspectedTable.getBatchInsertStatementId());
        method.addException(new FullyQualifiedJavaType("Exception"));
        
        FullyQualifiedJavaType parameterType;
        parameterType = new FullyQualifiedJavaType(
                introspectedTable.getBaseRecordType());
            /*parameterType = introspectedTable.getRules()
                    .calculateAllFieldsClass();*/

        importedTypes.add(parameterType);
        method.addParameter(new Parameter(FullyQualifiedJavaType.getNewListInstance(), "records")); //$NON-NLS-1$

        context.getCommentGenerator().addGeneralMethodComment(method,
                introspectedTable);

        addMapperAnnotations(interfaze, method);

        if (context.getPlugins().clientInsertMethodGenerated(method, interfaze,
                introspectedTable)) {
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }

    public void addMapperAnnotations(Interface interfaze, Method method) {
        return;
    }
}
