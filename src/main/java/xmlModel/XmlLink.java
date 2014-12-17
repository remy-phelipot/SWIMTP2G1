package xmlModel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "link")
public class XmlLink {

	@XmlElement(name = "consumer")
	private XmlConsumer consumer;

	@XmlElement(name = "provider")
	private XmlProvider provider;

	@XmlElement(name = "sequences")
	private List<XmlSequence> sequences;

	public XmlConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(XmlConsumer consumer) {
		this.consumer = consumer;
	}

	public XmlProvider getProvider() {
		return provider;
	}

	public void setProvider(XmlProvider provider) {
		this.provider = provider;
	}

	public List<XmlSequence> getSequences() {
		return sequences;
	}

	public void setSequences(List<XmlSequence> sequences) {
		this.sequences = sequences;
	}


	public XmlLink() {
		this.sequences = new ArrayList<XmlSequence>();
	}
}
