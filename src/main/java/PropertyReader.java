import org.apache.commons.lang3.StringUtils;
import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.services.FileServer;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.util.JMeterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PropertyReader extends ConfigTestElement implements TestBean, TestStateListener {

	private static final Logger log = LoggerFactory.getLogger(PropertyReader.class);
	private String propFilePath;

	public PropertyReader() {
		super();
	}

	public void testStarted() {
		if (StringUtils.isNotEmpty(getPropFilePath())) {
				Path path = Paths.get(getPropFilePath());
			if (!path.isAbsolute())
				path = Paths.get(FileServer.getFileServer().getBaseDir(), path.toString());
			try(FileInputStream inputStream = new FileInputStream(path.toString())) {
				JMeterUtils.getJMeterProperties().load(inputStream);
				log.info("Property file reader - loading properties from " + path);
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
	}

	public void testStarted(String s) {
		throw new UnsupportedOperationException("Not supported yet");

	}

	public void testEnded() {
		throw new UnsupportedOperationException("Not supported yet");
	}

	public void testEnded(String s) {
		throw new UnsupportedOperationException("Not supported yet");

	}

	/**
	 * @return the file path
	 */
	public String getPropFilePath() {
		return this.propFilePath;
	}

	/**
	 * @param propFilePath the file path to read
	 */
	public void setPropFilePath(String propFilePath) {
		this.propFilePath = propFilePath;
	}
}
