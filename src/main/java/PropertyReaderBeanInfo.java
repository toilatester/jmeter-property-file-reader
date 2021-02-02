import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.FileEditor;

import java.beans.PropertyDescriptor;

public class PropertyReaderBeanInfo extends BeanInfoSupport {

	private static final String FIELD_PROPERTY_FILE_PATH = "propFilePath";

	public PropertyReaderBeanInfo() {
		super(PropertyReader.class);

		PropertyDescriptor p = property(FIELD_PROPERTY_FILE_PATH);
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "");
		p.setPropertyEditorClass(FileEditor.class);

	}
}
