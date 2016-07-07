package dhh.service.generator.codegen;

import org.mybatis.generator.codegen.AbstractJavaGenerator;
import org.mybatis.generator.codegen.AbstractXmlGenerator;

public abstract class AbstractJavaServiceGenerator extends AbstractJavaGenerator {
	 private boolean requiresXMLGenerator;
	    
	    public AbstractJavaServiceGenerator(boolean requiresXMLGenerator) {
	        super();
	        this.requiresXMLGenerator = requiresXMLGenerator;
	    }

	    /**
	     * @return true if matching XML is required
	     */
	    public boolean requiresXMLGenerator() {
	        return requiresXMLGenerator;
	    }
	    
	    /**
	     * This method returns an instance of the XML generator associated
	     * with this client generator.
	     * 
	     * @return the matched XML generator.  May return null if no
	     * XML is required by this generator
	     */
	    public abstract AbstractXmlGenerator getMatchedXMLGenerator();
}
