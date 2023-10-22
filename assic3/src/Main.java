import java.util.ArrayList;
import java.util.List;

// Legacy system with a complex data structure
class LegacySystem {
    public List<String> fetchData() {
        List<String> data = new ArrayList<>();
        data.add("Alikhan,35,Atyrau");
        data.add("Ernur,28,Los Almaty");
        data.add("Tenelbek,42,Aktau");
        return data;
    }
}

// New system expects a simplified data structure
class NewSystem {
    public void processData(List<String> data) {
        for (String line : data) {
            String[] parts = line.split(",");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            String location = parts[2];
            System.out.println("Name: " + name + ", Age: " + age + ", Location: " + location);
        }
    }
}

// Adapter to convert data from the legacy system to the new system
class LegacyToNewAdapter {
    private LegacySystem legacySystem;

    public LegacyToNewAdapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    public List<String> adaptData() {
        List<String> legacyData = legacySystem.fetchData();
        List<String> newData = new ArrayList<>();

        for (String line : legacyData) {
            String[] parts = line.split(",");
            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            String location = parts[2];
            newData.add(name + "," + age + "," + location);
        }

        return newData;
    }
}

public class Main {
    public static void main(String[] args) {
        LegacySystem legacySystem = new LegacySystem();
        NewSystem newSystem = new NewSystem();

        LegacyToNewAdapter adapter = new LegacyToNewAdapter(legacySystem);
        List<String> adaptedData = adapter.adaptData();

        System.out.println("Adapted Data:");
        newSystem.processData(adaptedData);
    }
}
