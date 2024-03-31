package dk.lundogbendsen.javase_advanced.junit.lab02.mokito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonServiceImplTest {

	// Subject under Test:
	private PersonServiceImpl personService;

	// Collaborators ( are mocked )
	private PersonDao personDaoMock;
	private AuditService auditServiceMock;

	// A few persons
	private Person james = new Person("James", "Gosling", 63);
	private Person linus = new Person("Linus", "Thorvalds", 47);
	private Person scalaJohansson = new Person("Scala", "Johansson", 17);

	@BeforeEach
	public void init() {
		personDaoMock = mock(PersonDao.class);
		auditServiceMock = mock(AuditService.class);
		personService = new PersonServiceImpl(personDaoMock, auditServiceMock);
	}

	@Test
	public void persistFamilySkipsYoungsters() {
		personService.persistFamily(james, scalaJohansson, linus);

		verify(personDaoMock).persist(james);
		verify(personDaoMock).persist(linus);
		verifyNoMoreInteractions(personDaoMock);
	}

	@Test
	public void persistFamilyLogsYoungsters() {
		personService.persistFamily(james, scalaJohansson, linus);

		verify(auditServiceMock).log(anyString());
		verifyNoMoreInteractions(auditServiceMock);
	}
}
