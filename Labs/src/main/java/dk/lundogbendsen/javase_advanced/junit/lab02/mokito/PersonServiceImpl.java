package dk.lundogbendsen.javase_advanced.junit.lab02.mokito;

public class PersonServiceImpl implements PersonService {

	@SuppressWarnings("unused")
	private final AuditService audit;

	@SuppressWarnings("unused")
	private final PersonDao dao;

	public PersonServiceImpl(PersonDao dao, AuditService auditService) {
		this.dao = dao;
		this.audit = auditService;

	}

	public void persistFamily(Person... persons) {
		// ADD code that persists persons over the age of 18
		// Underaged persons are logged to the audit logger.
	}
}
