import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class CatalogXMLWorker {
    public static AllDependencies loadCatalogFromXMLFile(File file) {
        AllDependencies catalog = new AllDependencies();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element root = document.getDocumentElement();
            NodeList dependencies = root.getChildNodes();
            for (int i = 0; i < dependencies.getLength(); i++) {
                Node node = dependencies.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Dependency dependency = getBookFromNode(element);
                    if (dependency != null) {
                        catalog.addDependency(dependency);
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
        return catalog;
    }


    private static Dependency getBookFromNode(Element dependency) {
        if (!dependency.getTagName().equals("dependency")) {
            return null;
        }
        String groupId = dependency.getElementsByTagName("groupId").item(0).getTextContent();
        String artifactId = dependency.getElementsByTagName("artifactId").item(0).getTextContent();
        String version = dependency.getElementsByTagName("version").item(0).getTextContent();
        String scope = null;
        try {
            scope = dependency.getElementsByTagName("scope").item(0).getTextContent();
        } catch (Exception e) {
        }

        Dependency dependencyCurrent = new Dependency();
        dependencyCurrent.setGroupId(groupId);
        dependencyCurrent.setArtifactId(artifactId);
        dependencyCurrent.setVersion(version);
        if (scope != null) {
            dependencyCurrent.setScope(scope);
        }
        return dependencyCurrent;
    }
}
