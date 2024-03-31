package dk.lundogbendsen.javase_advanced.junit.lab02.mokito;

public class PersonServiceImpl implements PersonService {

	private final AuditService audit;

	private final PersonDao dao;

	public PersonServiceImpl(PersonDao dao, AuditService auditService) {
		this.dao = dao;
		this.audit = auditService;

	}

	public void persistFamily(Person... persons) {

		// Step 1: validate input
		if (persons == null) {
			throw new IllegalArgumentException("Null is not a valid argument");
		}

		// Step 2: Persist persons over the age of 18
		for (Person person : persons) {
			if (person.getAge() >= 18) {
				dao.persist(person);
			} else {
				audit.log("Skipping underaged person " + person);
			}
		}
	}
}
