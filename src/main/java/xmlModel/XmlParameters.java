package xmlModel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "param")
public class XmlParameters {

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "description")
	private String description;

	@XmlElement(name = "consumers")
	private List<XmlConsumer> consumers;

	// liste providers
	@XmlElement(name = "providers")
	private List<XmlProvider> providers;

	// liste de link
	@XmlElement(name = "links")
	private List<XmlLink> links;

	public XmlParameters() {
		this.consumers = new ArrayList<>();
		this.providers = new ArrayList<>();
		this.links = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<XmlConsumer> getConsumers() {
		return consumers;
	}

	public void setConsumers(List<XmlConsumer> consumers) {
		this.consumers = consumers;
	}

	public List<XmlProvider> getProviders() {
		return providers;
	}

	public void setProviders(List<XmlProvider> providers) {
		this.providers = providers;
	}

	public List<XmlLink> getLinks() {
		return links;
	}

	public void setLinks(List<XmlLink> links) {
		this.links = links;
	}

}
