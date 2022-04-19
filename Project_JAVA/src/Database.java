import java.time.LocalDate;
import java.util.HashMap;

public class Database {
    
    private HashMap<Integer, Object> TheDatabase;

    public Database() {
        TheDatabase = new HashMap<Integer, Object>();
    }


    public void addStudent(int i, int id, String firstName, String secondName, LocalDate birthDate) {
      switch (i) {
        case (1): TheDatabase.put(id, new TechnicalStudy(id, firstName, secondName, birthDate)); break;
        case (2): TheDatabase.put(id, new HumanitarianStudy(id, firstName, secondName, birthDate)); break;
        case (3): TheDatabase.put(id, new CombinedStudy(id, firstName, secondName, birthDate)); break;
    }

    
  }
  }
