
import java.util.ArrayList;

public class AllDependencies {

    private ArrayList<Dependency> dependencies;

    public AllDependencies(ArrayList<Dependency> allDdependencies) {
        this.dependencies = allDdependencies;
    }

    public AllDependencies() {
this.dependencies=new ArrayList<>();
    }

    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }
    public void setDependencies(ArrayList<Dependency> dependencies) {
        this.dependencies = dependencies;
    }

    public void addDependency (Dependency dependency) {
        this.dependencies.add(dependency);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
      for (Dependency d:this.dependencies) {
          builder.append(d+"\n");
      }
      return builder.toString();
    }
}
