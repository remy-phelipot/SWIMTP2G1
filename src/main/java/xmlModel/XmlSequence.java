package xmlModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "sequence")
public class XmlSequence {

	@XmlAttribute(name = "begin")
	private int begin;

	@XmlAttribute(name = "begin")
	private int end;

	@XmlElement(name = "processing_time_provider")
	private float processingTimeProvider;

	@XmlElement(name = "data_size")
	private float dataSize;

	@XmlElement(name = "nbr_req_per_sec_consumer")
	private int nbReqPerSecConsumer;

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public float getProcessingTimeProvider() {
		return processingTimeProvider;
	}

	public void setProcessingTimeProvider(float processingTimeProvider) {
		this.processingTimeProvider = processingTimeProvider;
	}

	public float getDataSize() {
		return dataSize;
	}

	public void setDataSize(float dataSize) {
		this.dataSize = dataSize;
	}

	public int getNbReqPerSecConsumer() {
		return nbReqPerSecConsumer;
	}

	public void setNbReqPerSecConsumer(int nbReqPerSecConsumer) {
		this.nbReqPerSecConsumer = nbReqPerSecConsumer;
	}

}
