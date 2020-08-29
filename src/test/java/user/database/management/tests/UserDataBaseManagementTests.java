package user.database.management.tests;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import user.database.management.model.User;
import user.database.management.model.UserCollection;
import user.database.management.repository.UserRepository;
import user.database.management.services.UserService;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UserDataBaseManagementTests {

	private UserCollection userCollection;
	private BufferedReader reader;
	private FileReader fileReader;
	private String inputFileName;
	@Autowired
	UserService userService;
	
	 @Autowired
	 UserRepository userRepository;

	@BeforeEach
	public void setUp() throws Exception {
		inputFileName = ".\\MOCK_DATA.txt";
		userCollection = new UserCollection();
		try {
			fileReader = new FileReader(inputFileName);
			reader = new BufferedReader(fileReader);
			String str;
			while (true) {
				if ((str = reader.readLine()) != null) {
					String[] fields = str.split(";");
					User user = new User();
					try {
						user.setId(Integer.parseInt(fields[0]));
						user.setName(fields[1]);
						user.setEmail(fields[2]);
						userCollection.getUserCollection().add(user);
					} catch (NumberFormatException e) {

						continue;
					}

				} else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	/*	for (User user : userCollection.getUserCollection()) {
	*		System.out.println(user.toString());
	*	}
	*	System.out.println("-----------");
	*/
	}

	
	@Test
	public void userApplicationTest() {
			User user = userService.addUser(1L, "Mark", "mark2020@gmail.com");
	        Assertions.assertNotNull(user);

	        User expected = userService.getById((long) user.getId());
	        Assertions.assertNotNull(expected);

		/*User one = userRepository.getOne(1L);
        List<User> all = userRepository.findAll();
        Assertions.assertEquals("Mara",one.getName());
        Assertions.assertEquals(1, all.size());*/
	}
	
	@AfterEach
	public void tearDown() throws Exception {
	reader.close();
	fileReader.close();
	}

}
