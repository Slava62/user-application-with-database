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
						user.setId(Long.parseLong(fields[0]));
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
	}

	
	@Test
	public void userApplicationTest() {
	    //add users from userCollection
        for (User user: userCollection.getUserCollection()) {
            userService.addUser(user.getId(), user.getName(), user.getEmail());
        }

        List<User> expected = userCollection.getUserCollection();
        List<User> actual = userRepository.findAll();
	        Assertions.assertEquals(expected.size(),actual.size());
	        for(int i=0; i<actual.size()-1;i++) {
				Assertions.assertEquals(expected.get(i).getName(), actual.get(i).getName());
				Assertions.assertEquals(expected.get(i).getEmail(), actual.get(i).getEmail());
			}
	}

	@AfterEach
	public void tearDown() throws Exception {
	reader.close();
	fileReader.close();
	}

}
