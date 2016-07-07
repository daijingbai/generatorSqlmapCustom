package dhh.service.generator.codegen;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;
import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;
import org.mybatis.generator.config.PropertyRegistry;

import dhh.service.generator.codegen.elements.DeleteByPrimaryKeyMethodGenerator;
import dhh.service.generator.codegen.elements.FindByPageMethodGenerator;
import dhh.service.generator.codegen.elements.InsertMethodGenerator;
import dhh.service.generator.codegen.elements.UpdateByPrimaryKeySelectiveMethodGenerator;

public class JavaIServiceGenerator extends AbstractJavaServiceGenerator {
	/**
     * 
     */
    public JavaIServiceGenerator() {
        super(true);
    }

    public JavaIServiceGenerator(boolean requiresMatchedXMLGenerator) {
        super(requiresMatchedXMLGenerator);
    }
    
    @Override
    public List<CompilationUnit> getCompilationUnits() {
        progressCallback.startTask(getString("Progress.17", //$NON-NLS-1$
                introspectedTable.getFullyQualifiedTable().toString()));
        CommentGenerator commentGenerator = context.getCommentGenerator();

        FullyQualifiedJavaType type = new FullyQualifiedJavaType(
                introspectedTable.getJavaIServiceType());
        Interface interfaze = new Interface(type);
        interfaze.setVisibility(JavaVisibility.PUBLIC);
        commentGenerator.addJavaFileComment(interfaze);

        String rootInterface = introspectedTable
            .getTableConfigurationProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
        if (!stringHasValue(rootInterface)) {
            rootInterface = context.getJavaIServiceGeneratorConfiguration()
                .getProperty(PropertyRegistry.ANY_ROOT_INTERFACE);
        }

        if (stringHasValue(rootInterface)) {
            FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(
                    rootInterface);
            interfaze.addSuperInterface(fqjt);
            interfaze.addImportedType(fqjt);
        }
        
        //addCountByExampleMethod(interfaze);
        //addCountByExampleMethod(interfaze);
        //addDeleteByExampleMethod(interfaze);
        addDeleteByPrimaryKeyMethod(interfaze);
        addInsertMethod(interfaze);
        addFindByPageMethod(interfaze);
        //addBatchInsertMethod(interfaze);
        //addInsertSelectiveMethod(interfaze);
        //addSelectByExampleWithBLOBsMethod(interfaze);
        //addSelectByExampleWithoutBLOBsMethod(interfaze);
        //addSelectByExampleWithPageMethod(interfaze);
        //addSelectByPrimaryKeyMethod(interfaze);
        //addUpdateByExampleSelectiveMethod(interfaze);
        //addUpdateByExampleWithBLOBsMethod(interfaze);
        //addUpdateByExampleWithoutBLOBsMethod(interfaze);
        addUpdateByPrimaryKeySelectiveMethod(interfaze);
        //addUpdateByPrimaryKeyWithBLOBsMethod(interfaze);
        //addUpdateByPrimaryKeyWithoutBLOBsMethod(interfaze);

        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        if (context.getPlugins().clientGenerated(interfaze, null,
                introspectedTable)) {
            answer.add(interfaze);
        }
        
        List<CompilationUnit> extraCompilationUnits = getExtraCompilationUnits();
        if (extraCompilationUnits != null) {
            answer.addAll(extraCompilationUnits);
        }

        return answer;
    }

//    protected void addSelectByExampleWithPageMethod(Interface interfaze) {
//        AbstractJavaMapperMethodGenerator methodGenerator = new SelectByExampleWithPageMethodGenerator();
//        initializeAndExecuteGenerator(methodGenerator, interfaze);	
//	}
//
//	protected void addCountByExampleMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateCountByExample()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new CountByExampleMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }
//
//    protected void addDeleteByExampleMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateDeleteByExample()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new DeleteByExampleMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }

    //如果有主健，才生成该方法
    protected void addDeleteByPrimaryKeyMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateDeleteByPrimaryKey()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new DeleteByPrimaryKeyMethodGenerator(false);
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }
    
    protected void addInsertMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateInsert()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new InsertMethodGenerator(false);
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }
    
    protected void addFindByPageMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateInsert()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new FindByPageMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }
    
//    protected void addBatchInsertMethod(Interface interfaze) {
//    	if(introspectedTable.getGeneratedKey()!=null){//如果没有配置GeneratedKey，那么就不做该方法处理
//	        AbstractJavaMapperMethodGenerator methodGenerator = new BatchInsertMethodGenerator();
//	        initializeAndExecuteGenerator(methodGenerator, interfaze);
//    	}
//    }
//
//    protected void addInsertSelectiveMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateInsertSelective()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new InsertSelectiveMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }
//
//    protected void addSelectByExampleWithBLOBsMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateSelectByExampleWithBLOBs()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new SelectByExampleWithBLOBsMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }
//
//    protected void addSelectByExampleWithoutBLOBsMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new SelectByExampleWithoutBLOBsMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }
//
//    protected void addSelectByPrimaryKeyMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateSelectByPrimaryKey()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new SelectByPrimaryKeyMethodGenerator(false);
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }
//
//    protected void addUpdateByExampleSelectiveMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateUpdateByExampleSelective()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByExampleSelectiveMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }
//
//    protected void addUpdateByExampleWithBLOBsMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateUpdateByExampleWithBLOBs()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByExampleWithBLOBsMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }
//
//    protected void addUpdateByExampleWithoutBLOBsMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateUpdateByExampleWithoutBLOBs()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByExampleWithoutBLOBsMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }
//
    protected void addUpdateByPrimaryKeySelectiveMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByPrimaryKeySelectiveMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
       }
    }

//    protected void addUpdateByPrimaryKeyWithBLOBsMethod(Interface interfaze) {
//        if (introspectedTable.getRules().generateUpdateByPrimaryKeyWithBLOBs()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByPrimaryKeyWithBLOBsMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
//    }
//
//    protected void addUpdateByPrimaryKeyWithoutBLOBsMethod(Interface interfaze) {
//        if (introspectedTable.getRules()
//                .generateUpdateByPrimaryKeyWithoutBLOBs()) {
//            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByPrimaryKeyWithoutBLOBsMethodGenerator();
//            initializeAndExecuteGenerator(methodGenerator, interfaze);
//        }
    //}

    protected void initializeAndExecuteGenerator(
            AbstractJavaMapperMethodGenerator methodGenerator,
            Interface interfaze) {
        methodGenerator.setContext(context);
        methodGenerator.setIntrospectedTable(introspectedTable);
        methodGenerator.setProgressCallback(progressCallback);
        methodGenerator.setWarnings(warnings);
        methodGenerator.addInterfaceElements(interfaze);
    }

    public List<CompilationUnit> getExtraCompilationUnits() {
        return null;
    }

    @Override
    public AbstractXmlGenerator getMatchedXMLGenerator() {
        return new XMLMapperGenerator();
    }
}
