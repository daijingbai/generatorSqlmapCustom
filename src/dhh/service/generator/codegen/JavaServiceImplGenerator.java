package dhh.service.generator.codegen;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.codegen.AbstractXmlGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;
import dhh.service.generator.codegen.elements.BatchInsertMethodGenerator;
import dhh.service.generator.codegen.elements.CountByExampleMethodGenerator;
import dhh.service.generator.codegen.elements.DeleteByExampleMethodGenerator;
import dhh.service.generator.codegen.elements.DeleteByPrimaryKeyMethodGenerator;
import dhh.service.generator.codegen.elements.InsertMethodGenerator;
import dhh.service.generator.codegen.elements.InsertSelectiveMethodGenerator;
import dhh.service.generator.codegen.elements.SelectByExampleWithBLOBsMethodGenerator;
import dhh.service.generator.codegen.elements.SelectByExampleWithPageMethodGenerator;
import dhh.service.generator.codegen.elements.SelectByExampleWithoutBLOBsMethodGenerator;
import dhh.service.generator.codegen.elements.SelectByPrimaryKeyMethodGenerator;
import dhh.service.generator.codegen.elements.UpdateByExampleSelectiveMethodGenerator;
import dhh.service.generator.codegen.elements.UpdateByExampleWithBLOBsMethodGenerator;
import dhh.service.generator.codegen.elements.UpdateByExampleWithoutBLOBsMethodGenerator;
import dhh.service.generator.codegen.elements.UpdateByPrimaryKeySelectiveMethodGenerator;
import dhh.service.generator.codegen.elements.UpdateByPrimaryKeyWithBLOBsMethodGenerator;
import dhh.service.generator.codegen.elements.UpdateByPrimaryKeyWithoutBLOBsMethodGenerator;

public class JavaServiceImplGenerator extends AbstractJavaServiceGenerator {
	/**
     * 
     */
    public JavaServiceImplGenerator() {
        super(true);
    }

    public JavaServiceImplGenerator(boolean requiresMatchedXMLGenerator) {
        super(requiresMatchedXMLGenerator);
    }
    
    @Override
    public List<CompilationUnit> getCompilationUnits() {
    	FullyQualifiedTable table = introspectedTable.getFullyQualifiedTable();
        progressCallback.startTask(getString(
                "Progress.6", table.toString())); //$NON-NLS-1$
        CommentGenerator commentGenerator = context.getCommentGenerator();

        FullyQualifiedJavaType type = new FullyQualifiedJavaType(
                introspectedTable.getJavaServiceImplType());
        TopLevelClass topLevelClass = new TopLevelClass(type);
        topLevelClass.setVisibility(JavaVisibility.PUBLIC);
        topLevelClass.addAnnotation("@Service");
        topLevelClass.addImportedType("org.springframework.stereotype.Service");
        topLevelClass.addSuperInterface(new FullyQualifiedJavaType(introspectedTable.getJavaIServiceType()));
        topLevelClass.addImportedType(new FullyQualifiedJavaType(introspectedTable.getJavaIServiceType()));
        commentGenerator.addJavaFileComment(topLevelClass);

        Field field = new Field();
        //field.setVisibility(JavaVisibility.PUBLIC);
        field.setType(new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType()));
        
        topLevelClass.addImportedType("org.springframework.beans.factory.annotation.Autowired");
        topLevelClass.addImportedType(new FullyQualifiedJavaType(introspectedTable.getMyBatis3JavaMapperType()));
        field.setName(StringUtility.classNameToObjectName(field.getType().getShortName()));//属性名
        field.addAnnotation("@Autowired");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        Method method = null;
        FullyQualifiedJavaType fqjt=null;
        FullyQualifiedJavaType returnType=null;
        FullyQualifiedJavaType listType=null;
        
       /**countByExample方法的实现***/
//        Method method = new Method();
//        method.setVisibility(JavaVisibility.PUBLIC);
//        FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType(
//                introspectedTable.getExampleType());
//        method.setName("countByExample");
//        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
//        method.addException(new FullyQualifiedJavaType("Exception"));
//        method.addParameter(new Parameter(fqjt, "example"));
//        method.addBodyLine("return "+field.getName()+".countByExample(example);");
//        topLevelClass.addImportedType(new FullyQualifiedJavaType(introspectedTable.getExampleType()));
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
        /**countByExample方法的实现***/
        
        /**deleteByExample方法的实现***/
//        method = new Method();
//        method.setVisibility(JavaVisibility.PUBLIC);
//        fqjt = new FullyQualifiedJavaType(
//                introspectedTable.getExampleType());
//        method.setName("deleteByExample");
//        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
//        method.addException(new FullyQualifiedJavaType("Exception"));
//        method.addParameter(new Parameter(fqjt, "example"));
//        method.addBodyLine("return "+field.getName()+".deleteByExample(example);");
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
        /**deleteByExample方法的实现***/
        
        
        /**deleteByPrimaryKey方法的实现***/
        if(introspectedTable.getRules().generateDeleteByPrimaryKey()){
		        method = new Method();
		        method.setVisibility(JavaVisibility.PUBLIC);
		        List<IntrospectedColumn> introspectedColumns = introspectedTable
		                .getPrimaryKeyColumns();
		        for (IntrospectedColumn introspectedColumn : introspectedColumns) {
		            type = introspectedColumn
		                    .getFullyQualifiedJavaType();
		            topLevelClass.addImportedType(type);
		            Parameter parameter = new Parameter(type, introspectedColumn
		                    .getJavaProperty());
		            method.addParameter(parameter);
		            method.addBodyLine("return "+field.getName()+".deleteByPrimaryKey("+introspectedColumn
		                    .getJavaProperty()+");");
		        }
		        fqjt = new FullyQualifiedJavaType(
		                introspectedTable.getPrimaryKeyType());
		        method.setName("deleteByPrimaryKey");
		        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		        method.addException(new FullyQualifiedJavaType("Exception"));
		        commentGenerator.addGeneralMethodComment(method, introspectedTable);
		        topLevelClass.addMethod(method);
        /**deleteByPrimaryKey方法的实现***/
        }
        
        /**insert方法的实现***/
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        fqjt = new FullyQualifiedJavaType(
                introspectedTable.getBaseRecordType());
        method.setName("insert");
        method.addParameter(new Parameter(fqjt, "record"));
        method.addBodyLine("return "+field.getName()+".insert(record);");
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.addException(new FullyQualifiedJavaType("Exception"));
        topLevelClass.addImportedType(fqjt);
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        /**insert方法的实现***/

        /**insertSelective方法的实现***/
//        method = new Method();
//        method.setVisibility(JavaVisibility.PUBLIC);
//        fqjt = new FullyQualifiedJavaType(
//                introspectedTable.getBaseRecordType());
//        method.setName("insertSelective");
//        method.addParameter(new Parameter(fqjt, "record"));
//        method.addBodyLine("return "+field.getName()+".insertSelective(record);");
//        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
//        method.addException(new FullyQualifiedJavaType("Exception"));
//        topLevelClass.addImportedType(fqjt);
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
        /**insertSelective方法的实现***/
        
        /**selectByExample方法的实现***/
//        method = new Method();
//        
//        FullyQualifiedJavaType returnType = FullyQualifiedJavaType
//                .getNewListInstance();
//        
//        method.setVisibility(JavaVisibility.PUBLIC);
//        fqjt = new FullyQualifiedJavaType(
//                introspectedTable.getExampleType());
//        method.setName("selectByExample");
//        method.addParameter(new Parameter(fqjt, "example"));
//        method.addBodyLine("return "+field.getName()+".selectByExample(example);");
//        method.setReturnType(returnType);
//        
//        FullyQualifiedJavaType listType;
//        if (introspectedTable.getRules().generateBaseRecordClass()) {
//            listType = new FullyQualifiedJavaType(introspectedTable
//                    .getBaseRecordType());
//        } else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
//            listType = new FullyQualifiedJavaType(introspectedTable
//                    .getPrimaryKeyType());
//        } else {
//            throw new RuntimeException(getString("RuntimeError.12")); //$NON-NLS-1$
//        }
//        returnType.addTypeArgument(listType);
//        topLevelClass.addImportedType(returnType);
//        method.addException(new FullyQualifiedJavaType("Exception"));
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
        /**selectByExample方法的实现***/
        
        /**FindByPage方法的实现***/
        method = new Method();
        
        
        returnType = FullyQualifiedJavaType.getNewMapInstance();
        returnType.addTypeArgument(new FullyQualifiedJavaType("String,Object"));
        
        if (introspectedTable.getRules().generateBaseRecordClass()) {
            listType = new FullyQualifiedJavaType(introspectedTable
                    .getBaseRecordType());
        } else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
            listType = new FullyQualifiedJavaType(introspectedTable
                    .getPrimaryKeyType());
        } else {
            throw new RuntimeException(getString("RuntimeError.12")); //$NON-NLS-1$
        }
        
        method.setVisibility(JavaVisibility.PUBLIC);
        fqjt = new FullyQualifiedJavaType(
                introspectedTable.getExampleType());
        method.setName("findByPage");
        method.addParameter(new Parameter(listType, "record"));
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "startPage"));
        method.addParameter(new Parameter(FullyQualifiedJavaType.getIntInstance(), "endPage"));
        method.addBodyLine("Map<String,Object> map=new LinkedHashMap<String,Object>();");
        method.addBodyLine(fqjt.getShortName()+" example=new "+fqjt.getShortName()+"();");
        method.addBodyLine("//具体条件查询请自行处理！！！");
        method.addBodyLine("map.put(\"total\", "+field.getName()+".selectByExampleWithPage(example,startPage,endPage));");
        method.addBodyLine("map.put(\"rows\", "+field.getName()+".countByExample(example));");
        
        method.addBodyLine("return map;");
        method.setReturnType(returnType);
        //importedTypes.add(returnType);
        //importedTypes.add(fqjt);
        //importedTypes.add(new FullyQualifiedJavaType("java.util.LinkedHashMap"));
        
        topLevelClass.addImportedType(returnType);
        topLevelClass.addImportedType(fqjt);
        topLevelClass.addImportedType(new FullyQualifiedJavaType("java.util.LinkedHashMap"));
        method.addException(new FullyQualifiedJavaType("Exception"));
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        /**FindByPage方法的实现***/
        
        
        /**selectByPrimaryKey方法的实现***/
//        method = new Method();
//        method.setVisibility(JavaVisibility.PUBLIC);
//        introspectedColumns = introspectedTable
//                .getPrimaryKeyColumns();
//        for (IntrospectedColumn introspectedColumn : introspectedColumns) {
//            type = introspectedColumn
//                    .getFullyQualifiedJavaType();
//            topLevelClass.addImportedType(type);
//            Parameter parameter = new Parameter(type, introspectedColumn
//                    .getJavaProperty());
//            method.addParameter(parameter);
//            method.addBodyLine("return "+field.getName()+".selectByPrimaryKey("+introspectedColumn
//                    .getJavaProperty()+");");
//        }
//        fqjt = new FullyQualifiedJavaType(
//                introspectedTable.getPrimaryKeyType());
//        method.setName("selectByPrimaryKey");
//        method.setReturnType(listType);
//        method.addException(new FullyQualifiedJavaType("Exception"));
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
        /**selectByPrimaryKey方法的实现***/
        
        
        /**updateByExampleSelective方法的实现***/
//        method = new Method();
//        
//        returnType = FullyQualifiedJavaType
//                .getIntInstance();
//        
//        method.setVisibility(JavaVisibility.PUBLIC);
//        fqjt = new FullyQualifiedJavaType(
//                introspectedTable.getExampleType());
//        method.setName("updateByExampleSelective");
//        
//        method.addParameter(new Parameter(listType, "record"));
//        method.addParameter(new Parameter(fqjt, "example"));
//        
//        method.addBodyLine("return "+field.getName()+".updateByExampleSelective(record,example);");
//        method.setReturnType(returnType);
//        
//        if (introspectedTable.getRules().generateBaseRecordClass()) {
//            listType = new FullyQualifiedJavaType(introspectedTable
//                    .getBaseRecordType());
//        } else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
//            listType = new FullyQualifiedJavaType(introspectedTable
//                    .getPrimaryKeyType());
//        } else {
//            throw new RuntimeException(getString("RuntimeError.12")); //$NON-NLS-1$
//        }
//        method.addException(new FullyQualifiedJavaType("Exception"));
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
        /**updateByExampleSelective方法的实现***/
        
        /**updateByExample方法的实现***/
//        method = new Method();
//        
//        returnType = FullyQualifiedJavaType
//                .getIntInstance();
//        
//        method.setVisibility(JavaVisibility.PUBLIC);
//        fqjt = new FullyQualifiedJavaType(
//                introspectedTable.getExampleType());
//        method.setName("updateByExample");
//        
//        method.addParameter(new Parameter(listType, "record"));
//        method.addParameter(new Parameter(fqjt, "example"));
//        
//        method.addBodyLine("return "+field.getName()+".updateByExample(record,example);");
//        method.setReturnType(returnType);
//        
//        if (introspectedTable.getRules().generateBaseRecordClass()) {
//            listType = new FullyQualifiedJavaType(introspectedTable
//                    .getBaseRecordType());
//        } else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
//            listType = new FullyQualifiedJavaType(introspectedTable
//                    .getPrimaryKeyType());
//        } else {
//            throw new RuntimeException(getString("RuntimeError.12")); //$NON-NLS-1$
//        }
//        method.addException(new FullyQualifiedJavaType("Exception"));
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
        /**updateByExample方法的实现***/
        
        /**updateByPrimaryKeySelective方法的实现***/
        if(introspectedTable.getRules().generateDeleteByPrimaryKey()){
	        method = new Method();
	        
	        if (introspectedTable.getRules().generateBaseRecordClass()) {
	            listType = new FullyQualifiedJavaType(introspectedTable
	                    .getBaseRecordType());
	        } else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
	            listType = new FullyQualifiedJavaType(introspectedTable
	                    .getPrimaryKeyType());
	        } else {
	            throw new RuntimeException(getString("RuntimeError.12")); //$NON-NLS-1$
	        }
	        
	        returnType = FullyQualifiedJavaType
	                .getIntInstance();
	        
	        method.setVisibility(JavaVisibility.PUBLIC);
	        fqjt = new FullyQualifiedJavaType(
	                introspectedTable.getExampleType());
	        method.setName("updateByPrimaryKeySelective");
	        
	        method.addParameter(new Parameter(listType, "record"));
	        
	        method.addBodyLine("return "+field.getName()+".updateByPrimaryKeySelective(record);");
	        method.setReturnType(returnType);
	        
	        
	        method.addException(new FullyQualifiedJavaType("Exception"));
	        commentGenerator.addGeneralMethodComment(method, introspectedTable);
	        topLevelClass.addMethod(method);
        }
        /**updateByPrimaryKeySelective方法的实现***/
        
        /**updateByPrimaryKey方法的实现***/
//        method = new Method();
//        
//        returnType = FullyQualifiedJavaType
//                .getIntInstance();
//        
//        method.setVisibility(JavaVisibility.PUBLIC);
//        fqjt = new FullyQualifiedJavaType(
//                introspectedTable.getExampleType());
//        method.setName("updateByPrimaryKey");
//        
//        method.addParameter(new Parameter(listType, "record"));
//        
//        method.addBodyLine("return "+field.getName()+".updateByPrimaryKey(record);");
//        method.setReturnType(returnType);
//        
//        if (introspectedTable.getRules().generateBaseRecordClass()) {
//            listType = new FullyQualifiedJavaType(introspectedTable
//                    .getBaseRecordType());
//        } else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
//            listType = new FullyQualifiedJavaType(introspectedTable
//                    .getPrimaryKeyType());
//        } else {
//            throw new RuntimeException(getString("RuntimeError.12")); //$NON-NLS-1$
//        }
//        method.addException(new FullyQualifiedJavaType("Exception"));
//        commentGenerator.addGeneralMethodComment(method, introspectedTable);
//        topLevelClass.addMethod(method);
        /**updateByPrimaryKey方法的实现***/
       /* addCountByExampleMethod(interfaze);
        addDeleteByExampleMethod(interfaze);
        addDeleteByPrimaryKeyMethod(interfaze);
        addInsertMethod(interfaze);
        //addBatchInsertMethod(interfaze);
        addInsertSelectiveMethod(interfaze);
        addSelectByExampleWithBLOBsMethod(interfaze);
        addSelectByExampleWithoutBLOBsMethod(interfaze);
        addSelectByExampleWithPageMethod(interfaze);
        addSelectByPrimaryKeyMethod(interfaze);
        addUpdateByExampleSelectiveMethod(interfaze);
        addUpdateByExampleWithBLOBsMethod(interfaze);
        addUpdateByExampleWithoutBLOBsMethod(interfaze);
        addUpdateByPrimaryKeySelectiveMethod(interfaze);
        addUpdateByPrimaryKeyWithBLOBsMethod(interfaze);
        addUpdateByPrimaryKeyWithoutBLOBsMethod(interfaze);*/

        /*List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        if (context.getPlugins().clientGenerated(interfaze, null,
                introspectedTable)) {
            answer.add(interfaze);
        }
        
        List<CompilationUnit> extraCompilationUnits = getExtraCompilationUnits();
        if (extraCompilationUnits != null) {
            answer.addAll(extraCompilationUnits);
        }*/
        
        List<CompilationUnit> answer = new ArrayList<CompilationUnit>();
        if (context.getPlugins().modelExampleClassGenerated(
                topLevelClass, introspectedTable)) {
            answer.add(topLevelClass);
        }

        return answer;
    }

    protected void addSelectByExampleWithPageMethod(Interface interfaze) {
        AbstractJavaMapperMethodGenerator methodGenerator = new SelectByExampleWithPageMethodGenerator();
        initializeAndExecuteGenerator(methodGenerator, interfaze);	
	}

	protected void addCountByExampleMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateCountByExample()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new CountByExampleMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addDeleteByExampleMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateDeleteByExample()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new DeleteByExampleMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

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
    
    protected void addBatchInsertMethod(Interface interfaze) {
    	if(introspectedTable.getGeneratedKey()!=null){//如果没有配置GeneratedKey，那么就不做该方法处理
	        AbstractJavaMapperMethodGenerator methodGenerator = new BatchInsertMethodGenerator();
	        initializeAndExecuteGenerator(methodGenerator, interfaze);
    	}
    }

    protected void addInsertSelectiveMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateInsertSelective()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new InsertSelectiveMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addSelectByExampleWithBLOBsMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateSelectByExampleWithBLOBs()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new SelectByExampleWithBLOBsMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addSelectByExampleWithoutBLOBsMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateSelectByExampleWithoutBLOBs()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new SelectByExampleWithoutBLOBsMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addSelectByPrimaryKeyMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateSelectByPrimaryKey()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new SelectByPrimaryKeyMethodGenerator(false);
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addUpdateByExampleSelectiveMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateUpdateByExampleSelective()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByExampleSelectiveMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addUpdateByExampleWithBLOBsMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateUpdateByExampleWithBLOBs()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByExampleWithBLOBsMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addUpdateByExampleWithoutBLOBsMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateUpdateByExampleWithoutBLOBs()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByExampleWithoutBLOBsMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addUpdateByPrimaryKeySelectiveMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateUpdateByPrimaryKeySelective()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByPrimaryKeySelectiveMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addUpdateByPrimaryKeyWithBLOBsMethod(Interface interfaze) {
        if (introspectedTable.getRules().generateUpdateByPrimaryKeyWithBLOBs()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByPrimaryKeyWithBLOBsMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

    protected void addUpdateByPrimaryKeyWithoutBLOBsMethod(Interface interfaze) {
        if (introspectedTable.getRules()
                .generateUpdateByPrimaryKeyWithoutBLOBs()) {
            AbstractJavaMapperMethodGenerator methodGenerator = new UpdateByPrimaryKeyWithoutBLOBsMethodGenerator();
            initializeAndExecuteGenerator(methodGenerator, interfaze);
        }
    }

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
