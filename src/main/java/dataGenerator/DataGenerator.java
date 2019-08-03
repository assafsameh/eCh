package dataGenerator;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import com.github.javafaker.Faker;

public class DataGenerator {
	Faker fakeDataGenerator = new Faker();
	Random random = new Random();
	SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
	Calendar calendar = Calendar.getInstance();
	
	public HashMap<String, String> dataGenerator(){
		HashMap<String, String> fakedDataGenerated = new HashMap<String, String>();
		fakedDataGenerated.put("job", fakeDataGenerator.job().title());
		fakedDataGenerated.put("fullAddress", fakeDataGenerator.address().fullAddress());

		return fakedDataGenerated;
	}
	
	public int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("Max must be greater than min");
		}
		return random.nextInt((max - min) + 1) + min;
	}

	public String getRandomDateInRange(int minYear, int maxYear, int minMonth, int maxMonth, int minDay, int maxDay) {
		int year = getRandomNumberInRange(minYear, maxYear);
		int month = getRandomNumberInRange(minMonth, maxMonth);
		int day = getRandomNumberInRange(minDay, maxDay);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		
		return formater.format(calendar.getTime());
	}
	
	public String getRandomFullName() {
		return fakeDataGenerator.name().fullName() ;
	}
	
	public String getRandomFirstName() {
		return fakeDataGenerator.name().firstName() ;
	}
	
	public String getRandomLastName() {
		return fakeDataGenerator.name().lastName() ;
	}
	
	public String getRandomCountryName() {
		return fakeDataGenerator.address().country() ;
	}
	
	public String getRandomEmail() {
		return fakeDataGenerator.internet().emailAddress() ;
	}
	
	public String getPhoneNumber(String type) {
		if(type.equalsIgnoreCase("phone")){
			return fakeDataGenerator.phoneNumber().phoneNumber().replace("-", "");
		}else{
			return fakeDataGenerator.phoneNumber().cellPhone().replace("-", "") ;
		}
	}
	
	
}
