import java.io.File;

public class Main {
    public static void main(String[] args) {
        AllDependencies dependencies = CatalogXMLWorker.loadCatalogFromXMLFile(new File("Dep.xml"));
        System.out.println(dependencies);
    }
}
